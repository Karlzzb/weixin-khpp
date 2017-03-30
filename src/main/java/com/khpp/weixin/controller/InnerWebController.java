package com.khpp.weixin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.khpp.weixin.config.CommonConstans;
import com.khpp.weixin.db.domain.DictParking;
import com.khpp.weixin.db.domain.ParkingOffer;
import com.khpp.weixin.db.service.DictParkingService;
import com.khpp.weixin.db.service.ParkingOfferService;
import com.khpp.weixin.db.service.UserService;
import com.khpp.weixin.service.WeixinService;
import com.khpp.weixin.web.model.ParkingOfferModel;

@Controller
@RequestMapping("/innerweb")
public class InnerWebController extends GenericController {

	private static final Logger logger = LoggerFactory
			.getLogger(InnerWebController.class);

	@Resource
	private WeixinService weixinService;

	@Resource
	private UserService userService;

	@Resource
	private DictParkingService dictParkingService;

	@Resource
	private ParkingOfferService parkingOfferService;

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "pakringBuyList", method = RequestMethod.GET)
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
				.getOfferListByParkingId(selectParkingId);
		model.addAttribute("offerList", parkingOfferList);

		return "pakringBuyList";
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "parkingOfferSubmit", method = RequestMethod.POST)
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
		}
		DictParking dictParking = dictParkingService
				.selectById(parkingOfferModel.getParkingId());

		parkingOfferService.insert(parkingOfferModel.toDomain(dictParking,
				wxMapuser));
		return "redirect:/innerweb/pakringBuyList?selectParking="
				+ parkingOfferModel.getParkingId();
	}
}
