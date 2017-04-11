package com.khpp.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.bean.pay.request.WxPayUnifiedOrderRequest;
import me.chanjar.weixin.mp.bean.pay.result.WxPayUnifiedOrderResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.khpp.common.constants.CommonConstans;
import com.khpp.common.utils.XMLUtil;
import com.khpp.db.service.ParkingOfferService;
import com.khpp.db.service.ParkingOrderService;
import com.khpp.web.model.ReturnModel;
import com.khpp.web.security.Token;
import com.khpp.weixin.dto.WxMpConfig;
import com.khpp.weixin.service.WxGenricService;
import com.khpp.weixin.service.WxPayService;

/**
 * 微信支付Controller
 *
 */
@Controller
@RequestMapping(value = "wxPayParking")
public class WxPayParkingController extends GenericController {

	@Autowired
	protected WxGenricService wxGenricService;

	@Autowired
	protected WxPayService wxPayService;

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
		WxPayUnifiedOrderResult result = this.wxGenricService.getPayService()
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
		ReturnModel returnModel = new ReturnModel();
		try {
			Map<String, String> payInfo = wxPayService.prepayParkingSentor(
					"wxPayParking", request, offerId);
			returnModel.setResult(true);
			returnModel.setDatum(payInfo);
		} catch (WxErrorException e) {
			logger.error("微信支付失败！订单号：{},原因:{}", "", e.getMessage());
			returnModel.setResult(false);
			returnModel.setReason(e.getError().getErrorMsg());
		}
		renderString(response, returnModel);
	}

	/**
	 * 支付完成后的信息
	 *
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "prepayResult", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public void prepayResult(
			HttpServletResponse response,
			@RequestParam(value = "selectOfferId", required = true) String offerId,
			@RequestBody Map<String, String> result) {
		ReturnModel returnModel = new ReturnModel();
		Boolean returnSign = false;
		if (result != null && result.containsKey("err_msg")) {
			returnSign = "get_brand_wcpay_request:ok".equals(result
					.get("err_msg"));
		}

		// 解冻停车券
		if (!returnSign) {
			parkingOfferService.updateOfferStatus(Integer.valueOf(offerId),
					CommonConstans.OFFERSTATUS_PUBLIC);
		}

		returnModel.setResult(returnSign);
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
				if (this.wxGenricService.getPayService().checkSign(kvm,
						getWxMpConfigStorage().getPartnerKey())) {
					String outTradeNo = kvm.get("out_trade_no");
					if (kvm.get("result_code").equals("SUCCESS")) {
						if (parkingOrderService.txOrderPayConfirm(outTradeNo)) {
							logger.info("out_trade_no: "
									+ kvm.get("out_trade_no") + " pay SUCCESS!");
							response.getWriter()
									.write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[ok]]></return_msg></xml>");
							return;
						}
					}
					this.logger.error("out_trade_no: "
							+ kvm.get("out_trade_no") + " result_code is FAIL");
					return;
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
		return this.wxGenricService.getWxMpConfigStorage();
	}
}
