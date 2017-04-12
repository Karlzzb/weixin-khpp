package com.khpp.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.khpp.common.constants.CommonConstans;
import com.khpp.db.domain.DictParking;
import com.khpp.db.service.DictParkingService;
import com.khpp.db.service.ParkingOfferService;
import com.khpp.db.service.ParkingOrderService;
import com.khpp.db.service.UserService;
import com.khpp.web.model.ParkingOfferModel;
import com.khpp.web.model.ReturnModel;
import com.khpp.web.security.Token;
import com.khpp.weixin.service.WxGenricService;

@Controller
@RequestMapping("/innerweb")
public class InnerWebController extends GenericController {

	@Resource
	private WxGenricService wxGenricService;

	@Resource
	private UserService userService;

	@Resource
	private DictParkingService dictParkingService;

	@Resource
	private ParkingOfferService parkingOfferService;

	@Resource
	private ParkingOrderService parkingorderService;

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "parkingOfferSubmit", method = RequestMethod.POST)
	@Token(remove = true)
	public String parkingOfferSubmit(
			@Valid ParkingOfferModel parkingOfferModel,
			BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "parkingOffer";
		}

		WxMpUser wxMapuser = (WxMpUser) session
				.getAttribute(CommonConstans.SESSION_WXUSER_KEY);
		if (wxMapuser == null) {
			logger.error("wxMapuser is not exists in Session, parkingOfferSubmit failed!");
			return "wxinfoNotExitst";
		}

		DictParking dictParking = dictParkingService
				.selectById(parkingOfferModel.getParkingId());

		parkingOfferService.insert(parkingOfferModel.toDomain(dictParking,
				wxMapuser));
		return "redirect:/wxredirect/parkingBuyList?selectParking="
				+ parkingOfferModel.getParkingId();
	}

	@RequestMapping(value = "orderConfirm")
	public void orderConfirm(
			HttpServletResponse response,
			HttpServletRequest request,
			HttpSession session,
			@RequestParam(value = "selectOrderId", required = true) String orderId) {
		ReturnModel returnModel = new ReturnModel();
		WxMpUser wxMapuser = (WxMpUser) session
				.getAttribute(CommonConstans.SESSION_WXUSER_KEY);
		if (wxMapuser == null) {
			logger.error("wxMapuser is not exists in Session, order confirm failed!");
			returnModel.setReason("您的微信身份丢失，请从公众号内重新进入！");
			returnModel.setResult(false);
			renderString(response, returnModel);
			return;
		}

		parkingorderService.txOrderBuierConfirm(orderId);
		returnModel.setResult(true);
		renderString(response, returnModel);
	}

	@RequestMapping(value = "messageDeliver")
	public void messageDeliver(
			HttpServletResponse response,
			HttpServletRequest request,
			HttpSession session,
			@RequestParam(value = "sellorId", required = true) String sellorId,
			@RequestParam(value = "msg2sellor", required = true) String msg2sellor) {
		if (sellorId == null || sellorId.isEmpty() || msg2sellor == null
				|| msg2sellor.isEmpty()) {
			return;
		}
		ReturnModel returnModel = new ReturnModel();
		try {
			WxMpUser wxMapuser = (WxMpUser) session
					.getAttribute(CommonConstans.SESSION_WXUSER_KEY);
			wxGenricService.getKefuService().sendKefuMessage(
					WxMpKefuMessage
							.TEXT()
							.toUser(sellorId)
							.content(
									"买家【" + wxMapuser.getNickname() + "】向你留言："
											+ msg2sellor).build());
		} catch (WxErrorException e) {
			logger.error("发送信息给卖家失败：", e);
		}
		returnModel.setResult(true);
		renderString(response, returnModel);
	}
}
