package com.khpp.weixin.service;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import me.chanjar.weixin.common.bean.result.WxError;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.pay.request.WxPayBaseRequest;
import me.chanjar.weixin.mp.bean.pay.request.WxPaySendRedpackRequest;
import me.chanjar.weixin.mp.bean.pay.request.WxPayUnifiedOrderRequest;
import me.chanjar.weixin.mp.bean.pay.result.WxPaySendRedpackResult;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.khpp.common.constants.CommonConstans;
import com.khpp.common.utils.WebUtil;
import com.khpp.db.domain.ParkingOffer;
import com.khpp.db.domain.ParkingOrder;
import com.khpp.db.service.ParkingOfferService;
import com.khpp.db.service.ParkingOrderService;

@Service
public class WxPayService {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private WxGenricService wxGenricService;

	@Resource
	private ParkingOfferService parkingOfferService;

	@Resource
	private ParkingOrderService parkingOrderService;

	/**
	 * 
	 * @param bizOrderId
	 *            业务订单ID
	 * @param redBagName
	 *            红包标题
	 * @param wxopenId
	 *            收款人微信OPEN ID
	 * @param paidAmount
	 *            支付金额（元）
	 * @return
	 * @throws WxErrorException
	 */
	public WxPaySendRedpackResult singleRedBagSentor(String bizOrderId,
			String redBagName, String wxopenId, Double paidAmount)
			throws WxErrorException {
		WxPaySendRedpackRequest request = new WxPaySendRedpackRequest();
		request.setNonceStr("");
		request.setReOpenid(wxopenId);
		request.setTotalAmount(WxPayBaseRequest.yuanToFee(String
				.valueOf(paidAmount)));
		request.setSendName("停车券平台");
		request.setTotalNum(1);
		request.setWishing("感谢你的使用，祝你生活愉快");
		request.setClientIp("192.168.1.1");
		request.setActName(redBagName);
		request.setMchBillNo(bizOrderId);
		return wxGenricService.getPayService().sendRedpack(request);
	}

	/**
	 * 预支付ID获取原始方法
	 * 
	 * @param wxMapuser
	 *            用户session信息
	 * @param request
	 *            Controller 参数
	 * @param bizOrderId
	 * @param paidAmount
	 * @return
	 * @throws WxErrorException
	 */
	public Map<String, String> prepayGenricSentor(String requestMappingValue,
			WxMpUser wxMapuser, HttpServletRequest request, String bizOrderId,
			Double paidAmount) throws WxErrorException {
		WxPayUnifiedOrderRequest prepayInfo = new WxPayUnifiedOrderRequest();
		prepayInfo.setOpenid(wxMapuser.getOpenId());
		prepayInfo.setOutTradeNo(bizOrderId);
		prepayInfo
				.setTotalFee(WxPayBaseRequest.yuanToFee(paidAmount.toString()));
		prepayInfo.setBody("1");
		prepayInfo.setTradeType(CommonConstans.WX_TRADETYPE_JSAPI);
		prepayInfo.setSpbillCreateIp(WebUtil.getIpAddr(request));
		prepayInfo.setNotifyURL(request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort() + "/"
				+ requestMappingValue + "/getJSSDKCallbackData");
		logger.info("NotifyURL = {}", prepayInfo.getNotifyURL());
		prepayInfo.setDeviceInfo("WEB");
		Map<String, String> payInfo = wxGenricService.getPayService()
				.getPayInfo(prepayInfo);

		return payInfo;
	}

	/**
	 * 预支付ID获取停车券业务方法
	 * 
	 * @param string
	 * 
	 * @param request
	 * @param offerId
	 * @return
	 * @throws WxErrorException
	 */
	public Map<String, String> prepayParkingSentor(String requestMappingValue,
			HttpServletRequest request, String offerId) throws WxErrorException {
		Object wxMapuserObj = request.getSession().getAttribute(
				CommonConstans.SESSION_WXUSER_KEY);
		if (wxMapuserObj == null || !(wxMapuserObj instanceof WxMpUser)) {
			WxError wxError = new WxError();
			wxError.setErrorCode(6001);
			wxError.setErrorMsg("微信登陆信息失效，Session 中无用户信息。");
			throw new WxErrorException(wxError);
		}
		WxMpUser wxMapuser = (WxMpUser) wxMapuserObj;
		ParkingOffer offer = parkingOfferService.selectById(Integer
				.valueOf(offerId));
		if (offer == null
				|| !offer.getOfferStatus().equals(
						CommonConstans.OFFERSTATUS_PUBLIC)) {
			WxError wxError = new WxError();
			wxError.setErrorCode(6002);
			wxError.setErrorMsg("当前停车券不可用，请选择其他车券。");
			throw new WxErrorException(wxError);
		}

		ParkingOrder parkingOrder = new ParkingOrder(offer.getOfferId(),
				offer.getParkingId(), offer.getParkingName(),
				offer.getWxOpenid(), offer.getWxNickName(),
				wxMapuser.getOpenId(), wxMapuser.getNickname(),
				CommonConstans.PARKING_ORDER_STATUS_SUBMIT, offer.getPrice(),
				CommonConstans.ORDER_SERVICE_FEE);
		Map<String, String> payInfo = prepayGenricSentor(requestMappingValue,
				wxMapuser, request, parkingOrder.getOrderId(), offer.getPrice());
		logger.info("paidedResult=" + new Gson().toJson(payInfo));

		// 保存订单信息
		parkingOrder.setWxFromOrderId(payInfo
				.get(CommonConstans.WX_PACKAGE_KEY).replace(
						CommonConstans.WX_PACKAGE_PREFIX, ""));
		parkingOrderService.txOrderCreator(parkingOrder);
		return payInfo;
	}
}
