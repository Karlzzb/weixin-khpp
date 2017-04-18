package com.khpp.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.binarywang.utils.qrcode.MatrixToImageWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.khpp.common.constants.CommonConstans;
import com.khpp.common.utils.DateUtil;
import com.khpp.common.utils.WebUtil;
import com.khpp.db.domain.CouponOrder;
import com.khpp.db.domain.DictParking;
import com.khpp.db.domain.ParkingOffer;
import com.khpp.db.domain.ParkingOrder;
import com.khpp.db.service.CouponOrderService;
import com.khpp.db.service.DictParkingService;
import com.khpp.db.service.ParkingOfferService;
import com.khpp.db.service.ParkingOrderService;
import com.khpp.web.model.CouponOrderModel;
import com.khpp.web.model.ParkingOfferModel;
import com.khpp.web.model.ParkingOrderModel;
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

	@Resource
	private CouponOrderService couponOrderService;

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "parkingBuyList", method = RequestMethod.GET)
	@Token(save = true)
	public ModelAndView parkingList(
			@RequestParam(value = "selectParking", required = false) String selectParkingIdStr,
			Model model) {
		ModelAndView modelAndView = new ModelAndView("parkingBuyList");
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
		modelAndView.addObject("parkingOrderModel", new ParkingOrderModel());

		return modelAndView;
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

	/**
	 * 
	 * @param request
	 * @return
	 * @throws WxErrorException
	 */
	@RequestMapping(value = "starbucksBuyList", method = RequestMethod.GET)
	@Token(save = true)
	public ModelAndView starbucksBuyList(Model model) throws WxErrorException {
		ModelAndView modelAndView = new ModelAndView("starbucksBuyList");
		modelAndView.addObject("couponOrderModel", new CouponOrderModel());
		modelAndView.addObject("thisbrand",
				CommonConstans.COUPON_BRAND_STARBUCKS);

		return modelAndView;
	}

	@RequestMapping(value = "/couponqr")
	public void couponqr(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "orderId", required = true) String orderId)
			throws IOException, WriterException {
		if (orderId != null && !orderId.isEmpty()) {
			CouponOrder couponOrder = couponOrderService.getOrderById(orderId);
			if (couponOrder == null
					|| !CommonConstans.COUPON_ORDER_STATUS_SUCCESS
							.equals(couponOrder.getOrderStatus())) {
				return;
			}
			String format = "png";
			Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			BitMatrix bitMatrix = new MultiFormatWriter().encode(
					couponOrder.getCouponQrcode(), BarcodeFormat.QR_CODE, 600,
					400, hints);
			OutputStream outputStream = response.getOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, format, outputStream);
		}
	}

	@RequestMapping(value = "/couponqrpage")
	public ResponseEntity<byte[]> couponqrpage(
			@RequestParam(value = "orderId", required = true) String orderId)
			throws IOException, WriterException {
		if (orderId != null && !orderId.isEmpty()) {
			CouponOrder couponOrder = couponOrderService.getOrderById(orderId);
			if (couponOrder == null
					|| !CommonConstans.COUPON_ORDER_STATUS_SUCCESS
							.equals(couponOrder.getOrderStatus())) {
				return null;
			}
			String url = couponOrder.getCouponQrcode();
			return WebUtil.getResponseEntity(url, 300, 300, "png");
		}
		return null;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "selfCouponList", method = RequestMethod.GET)
	public String selfCouponList(Model model, HttpSession session) {
		WxMpUser wxMapuser = (WxMpUser) session
				.getAttribute(CommonConstans.SESSION_WXUSER_KEY);
		if (wxMapuser == null) {
			logger.error("wxMapuser is not exists in Session, parkingOfferSubmit failed!");
			return "wxinfoNotExitst";
		}
		List<CouponOrder> couponOrderList = couponOrderService
				.getOrdersByBuier(wxMapuser.getOpenId());
		model.addAttribute("couponOrderList", couponOrderList);

		return "selfCouponList";
	}
}
