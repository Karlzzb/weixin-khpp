package com.khpp.weixin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khpp.weixin.db.domain.DictParking;
import com.khpp.weixin.db.domain.ParkingOffer;
import com.khpp.weixin.db.domain.User;
import com.khpp.weixin.db.service.DictParkingService;
import com.khpp.weixin.db.service.ParkingOfferService;
import com.khpp.weixin.db.service.UserService;
import com.khpp.weixin.service.WeixinService;
import com.khpp.weixin.web.model.ParkingOfferModel;

@Controller
@RequestMapping("/wxredirect")
public class WxRedirectController extends GenericController {

	@Resource
	private WeixinService weixinService;

	@Resource
	private UserService userService;

	@Resource
	private DictParkingService dictParkingService;

	@Resource
	private ParkingOfferService parkingOfferService;

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult result, Model model,
			HttpServletRequest request) {
		try {
			Subject subject = SecurityUtils.getSubject();
			// 已登陆则 跳到首页
			if (subject.isAuthenticated()) {
				return "redirect:/";
			}
			if (result.hasErrors()) {
				model.addAttribute("error", "参数错误！");
				return "login";
			}
			// 身份验证
			subject.login(new UsernamePasswordToken(user.getUsername(), user
					.getPassword()));
			// 验证成功在Session中保存用户信息
			final User authUserInfo = userService.selectOne();
			request.getSession().setAttribute("userInfo", authUserInfo);
		} catch (AuthenticationException e) {
			// 身份验证失败
			model.addAttribute("error", "用户名或密码错误 ！");
			return "login";
		}
		return "redirect:/";
	}

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
	 * @throws WxErrorException
	 */
	@RequestMapping(value = "parkingOffer", method = RequestMethod.GET)
	public ModelAndView parkingOffer(String code, Model model,
			HttpSession session) throws WxErrorException {
		WxMpUser wxMapuser = weixinService.oauth2getUserInfo(
				weixinService.oauth2getAccessToken(code), null);
		session.setAttribute("wxMapuser", wxMapuser);

		List<DictParking> parkingList = dictParkingService.selectList();
		model.addAttribute("parkingList", parkingList);
		ModelAndView modelAndView = new ModelAndView("parkingOfferForm");
		modelAndView.addObject("ParkingOfferModel", new ParkingOfferModel());
		modelAndView.addObject("parkingList", parkingList);
		return modelAndView;
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

		WxMpUser wxMapuser = (WxMpUser) session.getAttribute("wxMapuser");
		DictParking dictParking = dictParkingService
				.selectById(parkingOfferModel.getParkingId());

		parkingOfferService.insert(parkingOfferModel.toDomain(dictParking,
				wxMapuser));
		return "redirect:/wxredirect/pakringBuyList?selectParkin="
				+ parkingOfferModel.getParkingId();
	}
}
