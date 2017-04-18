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
import com.khpp.db.domain.CouponOffer;
import com.khpp.db.domain.CouponOrder;
import com.khpp.db.domain.ParkingOffer;
import com.khpp.db.domain.ParkingOrder;
import com.khpp.db.genric.DomainBuilder;
import com.khpp.db.service.CouponOfferService;
import com.khpp.db.service.CouponOrderService;
import com.khpp.db.service.ParkingOfferService;
import com.khpp.db.service.ParkingOrderService;
import com.khpp.web.model.CouponOrderModel;
import com.khpp.web.model.ParkingOrderModel;

@Service
public class WxPayService {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private WxGenricService wxGenricService;

	@Resource
	private ParkingOfferService parkingOfferService;

	@Resource
	private ParkingOrderService parkingOrderService;

	@Resource
	private CouponOrderService couponOrderService;

	@Resource
	private CouponOfferService couponOfferService;

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
	 * @param couponOrderModel
	 * @return
	 * @throws WxErrorException
	 */
	public Map<String, String> prepayParkingSentor(String requestMappingValue,
			HttpServletRequest request, ParkingOrderModel parkingorderModel)
			throws WxErrorException {
		Object wxMapuserObj = request.getSession().getAttribute(
				CommonConstans.SESSION_WXUSER_KEY);
		if (wxMapuserObj == null || !(wxMapuserObj instanceof WxMpUser)) {
			WxError wxError = new WxError();
			wxError.setErrorCode(6001);
			wxError.setErrorMsg("微信登陆信息失效，Session 中无用户信息。");
			throw new WxErrorException(wxError);
		}
		WxMpUser wxMapuser = (WxMpUser) wxMapuserObj;
		ParkingOffer offer = parkingOfferService.selectById(parkingorderModel
				.getSelectOfferId());
		ParkingOrder parkingOrder = DomainBuilder.buildParkingOrder(
				offer.getOfferId(), offer.getParkingId(),
				offer.getParkingName(), offer.getWxOpenid(),
				offer.getWxNickName(), wxMapuser.getOpenId(),
				wxMapuser.getNickname(),
				CommonConstans.PARKING_ORDER_STATUS_SUBMIT, offer.getPrice(),
				CommonConstans.ORDER_SERVICE_FEE,
				parkingorderModel.getDetail(), offer.getDetail());
		Map<String, String> payInfo = prepayGenricSentor(requestMappingValue,
				wxMapuser, request, parkingOrder.getOrderId(), offer.getPrice());
		logger.info("\nparking paidedResult=" + new Gson().toJson(payInfo));

		// 保存订单信息
		parkingOrderService.txOrderCreator(parkingOrder);
		return payInfo;
	}

	/**
	 * 预支付ID获取优惠券券业务方法
	 * 
	 * @param string
	 * 
	 * @param request
	 * @param parkingorderModel
	 * @return
	 * @throws WxErrorException
	 */
	public Map<String, String> prepayCouponSentor(String requestMappingValue,
			HttpServletRequest request, CouponOrderModel couponOrderModel)
			throws WxErrorException {
		Object wxMapuserObj = request.getSession().getAttribute(
				CommonConstans.SESSION_WXUSER_KEY);
		if (wxMapuserObj == null || !(wxMapuserObj instanceof WxMpUser)) {
			WxError wxError = new WxError();
			wxError.setErrorCode(6001);
			wxError.setErrorMsg("微信登陆信息失效，Session 中无用户信息。");
			throw new WxErrorException(wxError);
		}
		WxMpUser wxMapuser = (WxMpUser) wxMapuserObj;
		CouponOffer offer = couponOfferService.takeCoupon(
				couponOrderModel.getCouponBrand(),
				couponOrderModel.getCouponType());

		if (offer == null
				|| !offer.getOfferStatus().equals(
						CommonConstans.COUPON_OFFER_STATUS_PUBLIC)) {
			WxError wxError = new WxError();
			wxError.setErrorCode(6002);
			wxError.setErrorMsg("优惠券已销售一空，我们会加紧上货，请稍后重试！");
			throw new WxErrorException(wxError);
		}

		CouponOrder couponOrder = DomainBuilder.buildCouponOrder(
				offer.getCouponId(), offer.getCouponBrand(),
				offer.getCouponType(), offer.getCouponQrcode(),
				wxMapuser.getOpenId(), wxMapuser.getNickname(),
				CommonConstans.COUPON_ORDER_STATUS_SUBMIT, offer.getPrice());
		Map<String, String> payInfo = prepayGenricSentor(requestMappingValue,
				wxMapuser, request, couponOrder.getCouponOrderId(),
				offer.getPrice());
		logger.info("\n Coupon paidedResult=" + new Gson().toJson(payInfo));

		// 保存订单信息
		couponOrderService.txOrderCreator(couponOrder);
		return payInfo;
	}
}
