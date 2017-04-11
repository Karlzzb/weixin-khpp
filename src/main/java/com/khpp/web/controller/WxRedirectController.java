package com.khpp.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khpp.common.constants.CommonConstans;
import com.khpp.common.utils.DateUtil;
import com.khpp.db.domain.DictParking;
import com.khpp.db.domain.ParkingOffer;
import com.khpp.db.domain.ParkingOrder;
import com.khpp.db.service.DictParkingService;
import com.khpp.db.service.ParkingOfferService;
import com.khpp.db.service.ParkingOrderService;
import com.khpp.web.model.ParkingOfferModel;
import com.khpp.web.security.Token;
import com.khpp.weixin.service.WxGenricService;

@Controller
@RequestMapping("/wxredirect")
public class WxRedirectController extends GenericController {

	@Resource
	private WxGenricService weixinService;

	@Resource
	private DictParkingService dictParkingService;

	@Resource
	private ParkingOfferService parkingOfferService;

	@Resource
	private ParkingOrderService parkingOrderService;

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "parkingBuyList", method = RequestMethod.GET)
	@Token(save = true)
	public String parkingList(
			@RequestParam(value = "selectParking", required = false) String selectParkingIdStr,
			Model model) {
		List<DictParking> parkingList = dictParkingService.selectList();
		model.addAttribute("parkingList", parkingList);
		DictParking selectParking = parkingList.get(0);
		Integer selectParkingId = selectParking.getParkingId();
		if (selectParkingIdStr != null && !selectParkingIdStr.isEmpty()) {
			selectParkingId = Integer.valueOf(selectParkingIdStr);
			for (DictParking d : parkingList) {
				if (d.getParkingId().equals(selectParkingId)) {
					selectParking = d;
					break;
				}
			}
		}
		model.addAttribute("selectParking", selectParking);
		List<ParkingOffer> parkingOfferList = parkingOfferService
				.getAvailableOfferListByParkingId(selectParkingId);
		model.addAttribute("offerList", parkingOfferList);

		return "parkingBuyList";
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws WxErrorException
	 */
	@RequestMapping(value = "parkingOffer", method = RequestMethod.GET)
	@Token(save = true)
	public ModelAndView parkingOffer(Model model) throws WxErrorException {
		List<DictParking> parkingList = dictParkingService.selectList();
		model.addAttribute("parkingList", parkingList);
		ModelAndView modelAndView = new ModelAndView("parkingOfferForm");
		ParkingOfferModel offerModel = new ParkingOfferModel(new Date(),
				DateUtil.hourSwing(new Date(), CommonConstans.OFFERVALIDHOURS));
		modelAndView.addObject("parkingOfferModel", offerModel);
		modelAndView.addObject("parkingList", parkingList);
		return modelAndView;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "selfOfferList", method = RequestMethod.GET)
	public String selfOfferList(Model model, HttpSession session) {
		WxMpUser wxMapuser = (WxMpUser) session
				.getAttribute(CommonConstans.SESSION_WXUSER_KEY);
		if (wxMapuser == null) {
			logger.error("wxMapuser is not exists in Session, parkingOfferSubmit failed!");
			return "wxinfoNotExitst";
		}
		List<ParkingOffer> parkingOfferList = parkingOfferService
				.getOfferListByOwner(wxMapuser.getOpenId());
		model.addAttribute("offerList", parkingOfferList);

		return "selfOfferList";
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "selfOrderList", method = RequestMethod.GET)
	public String selfOrderList(Model model, HttpSession session) {
		WxMpUser wxMapuser = (WxMpUser) session
				.getAttribute(CommonConstans.SESSION_WXUSER_KEY);
		if (wxMapuser == null) {
			logger.error("wxMapuser is not exists in Session, parkingOfferSubmit failed!");
			return "wxinfoNotExitst";
		}
		List<ParkingOrder> parkingOrderList = parkingOrderService
				.getOrderListByBuier(wxMapuser.getOpenId());
		model.addAttribute("orderList", parkingOrderList);

		return "selfOrderList";
	}
}
