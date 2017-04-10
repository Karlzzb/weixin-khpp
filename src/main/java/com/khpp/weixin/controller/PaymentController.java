package com.khpp.weixin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.bean.pay.request.WxPayBaseRequest;
import me.chanjar.weixin.mp.bean.pay.request.WxPayUnifiedOrderRequest;
import me.chanjar.weixin.mp.bean.pay.result.WxPayUnifiedOrderResult;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.khpp.weixin.config.CommonConstans;
import com.khpp.weixin.config.WxMpConfig;
import com.khpp.weixin.db.domain.ParkingOffer;
import com.khpp.weixin.db.domain.ParkingOrder;
import com.khpp.weixin.db.service.ParkingOfferService;
import com.khpp.weixin.db.service.ParkingOrderService;
import com.khpp.weixin.service.WeixinService;
import com.khpp.weixin.utils.WebUtil;
import com.khpp.weixin.utils.XMLUtil;
import com.khpp.weixin.web.model.ReturnModel;
import com.khpp.weixin.web.security.Token;

/**
 * 微信支付Controller
 *
 */
@Controller
@RequestMapping(value = "wxPay")
public class PaymentController extends GenericController {

	@Autowired
	protected WeixinService wxMpService;
	@Autowired
	private WxMpConfig wxConfig;
	@Autowired
	private ParkingOfferService parkingOfferService;

	@Autowired
	private ParkingOrderService parkingOrderService;

	/**
	 * 用于返回预支付的结果 WxMpPrepayIdResult，一般不需要使用此接口
	 *
	 * @param response
	 * @param request
	 * @throws WxErrorException
	 */
	@RequestMapping(value = "getPrepayIdResult")
	public void getPrepayId(HttpServletResponse response,
			HttpServletRequest request) throws WxErrorException {

		WxPayUnifiedOrderRequest payInfo = new WxPayUnifiedOrderRequest();
		payInfo.setOpenid(request.getParameter("openid"));
		payInfo.setOutTradeNo(request.getParameter("out_trade_no"));
		payInfo.setTotalFee(Integer.valueOf(request.getParameter("total_fee")));
		payInfo.setBody(request.getParameter("body"));
		payInfo.setTradeType(request.getParameter("trade_type"));
		payInfo.setSpbillCreateIp(request.getParameter("spbill_create_ip"));
		payInfo.setNotifyURL("");
		this.logger.info("PartnerKey is :"
				+ getWxMpConfigStorage().getPartnerKey());
		WxPayUnifiedOrderResult result = this.wxMpService.getPayService()
				.unifiedOrder(payInfo);
		this.logger.info(new Gson().toJson(result));
		renderString(response, result);
	}

	/**
	 * 返回前台H5调用JS支付所需要的参数，公众号支付调用此接口
	 *
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "getJSSDKPayInfo")
	@Token(remove = true)
	public void getJSSDKPayInfo(
			HttpServletResponse response,
			HttpServletRequest request,
			HttpSession session,
			@RequestParam(value = "selectOfferId", required = true) String offerId) {
		WxMpUser wxMapuser = (WxMpUser) session
				.getAttribute(CommonConstans.SESSION_WXUSER_KEY);
		// 生成订单数据对象
		ParkingOffer offer = parkingOfferService.selectById(Integer
				.valueOf(offerId));
		WxPayUnifiedOrderRequest prepayInfo = new WxPayUnifiedOrderRequest();
		prepayInfo.setOpenid(wxMapuser.getOpenId());
		ParkingOrder parkingOrder = new ParkingOrder(offer.getOfferId(),
				offer.getParkingId(), offer.getParkingName(),
				offer.getWxOpenid(), offer.getWxNickName(),
				wxMapuser.getOpenId(), wxMapuser.getNickname(),
				CommonConstans.PARKING_ORDER_STATUS_SUBMIT, offer.getPrice(),
				CommonConstans.ORDER_SERVICE_FEE);
		// 微信接口参数组装
		prepayInfo.setOutTradeNo(parkingOrder.getOrderId());
		prepayInfo.setTotalFee(WxPayBaseRequest.yuanToFee(String
				.valueOf((parkingOrder.getPaidAmount()))));
		prepayInfo.setBody("1");
		prepayInfo.setTradeType(CommonConstans.WX_TRADETYPE_JSAPI);
		prepayInfo.setSpbillCreateIp(WebUtil.getIpAddr(request));
		prepayInfo.setNotifyURL(request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ "/wxPay/getJSSDKCallbackData");
		logger.info("NotifyURL = " + request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ "/wxPay/getJSSDKCallbackData");
		prepayInfo.setDeviceInfo("WEB");
		// 页面返回处理
		ReturnModel returnModel = new ReturnModel();
		try {
			Map<String, String> payInfo = wxMpService.getPayService()
					.getPayInfo(prepayInfo);
			logger.info("paidedResult=" + new Gson().toJson(prepayInfo));
			returnModel.setResult(true);
			returnModel.setDatum(payInfo);
			// 保持订单信息
			parkingOrder.setWxFromOrderId(payInfo
					.get(CommonConstans.WX_PREPAY_ID_KEY));
			parkingOrderService.insert(parkingOrder);
		} catch (WxErrorException e) {
			logger.error("微信支付失败！订单号：{},原因:{}", "", e.getMessage());
			returnModel.setResult(false);
			returnModel.setReason("支付失败，请重试！");
		}
		renderString(response, returnModel);
	}

	/**
	 * 微信通知支付结果的回调地址，notify_url
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "getJSSDKCallbackData")
	public void getJSSDKCallbackData(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			synchronized (this) {
				Map<String, String> kvm = XMLUtil.parseRequestXmlToMap(request);
				if (this.wxMpService.getPayService().checkSign(kvm,
						getWxMpConfigStorage().getPartnerKey())) {
					String outTradeNo = kvm.get("out_trade_no");

					for (String key : kvm.keySet()) {
						logger.info("kvm: Key = " + key + "|Value="
								+ kvm.get(key));
					}

					if (kvm.get("result_code").equals("SUCCESS")) {
						if (parkingOrderService.orderPayConfirm(outTradeNo)) {
							logger.info("out_trade_no: "
									+ kvm.get("out_trade_no") + " pay SUCCESS!");
							response.getWriter()
									.write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[ok]]></return_msg></xml>");
							return;
						}
					}
					this.logger.error("out_trade_no: "
							+ kvm.get("out_trade_no") + " result_code is FAIL");
				}
				this.logger.error("out_trade_no: " + kvm.get("out_trade_no")
						+ " check signature FAIL");
				response.getWriter()
						.write("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[check signature FAIL]]></return_msg></xml>");
			}
		} catch (Exception e) {
			logger.error("微信支付回调处理失败！订单号：{},原因:{}", "", e.getMessage());
		}

	}

	private WxMpConfigStorage getWxMpConfigStorage() {
		return this.wxMpService.getWxMpConfigStorage();
	}
}
