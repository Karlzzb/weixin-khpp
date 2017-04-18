package com.khpp.db.genric;

import com.khpp.common.utils.MD5Util;
import com.khpp.db.domain.CouponOffer;
import com.khpp.db.domain.CouponOrder;
import com.khpp.db.domain.ParkingOrder;

public class DomainBuilder {

	/**
	 * 
	 * @param orderId
	 *            <pre>
	 * 订单状态
	 * {@link com.khpp.common.constants.CommonConstans#PARKING_ORDER_STATUS_SUBMIT}
	 * {@link com.khpp.common.constants.CommonConstans#PARKING_ORDER_STATUS_BUY}
	 * {@link com.khpp.common.constants.CommonConstans#PARKING_ORDER_STATUS_FAILED}
	 * {@link com.khpp.common.constants.CommonConstans#PARKING_ORDER_STATUS_SUCCESS}
	 * </pre>
	 * @param orderStatus
	 * @return
	 */
	public static ParkingOrder buildParkingOrder(String orderId, int orderStatus) {
		ParkingOrder order = new ParkingOrder();
		order.setOrderId(orderId);
		order.setOrderStatus(orderStatus);
		return order;
	}

	/**
	 * 
	 * @param orderId
	 *            <pre>
	 * 订单状态
	 * {@link com.khpp.common.constants.CommonConstans#PARKING_ORDER_STATUS_SUBMIT}
	 * {@link com.khpp.common.constants.CommonConstans#PARKING_ORDER_STATUS_BUY}
	 * {@link com.khpp.common.constants.CommonConstans#PARKING_ORDER_STATUS_FAILED}
	 * {@link com.khpp.common.constants.CommonConstans#PARKING_ORDER_STATUS_SUCCESS}
	 * </pre>
	 * @param orderStatus
	 * @param wxToOrderId
	 * @return
	 */
	public static ParkingOrder buildParkingOrder(String orderId,
			int orderStatus, String wxToOrderId) {
		ParkingOrder order = new ParkingOrder();
		order.setOrderId(orderId);
		order.setOrderStatus(orderStatus);
		order.setWxToOrderId(wxToOrderId);
		return order;
	}

	public static void genratewxToOrderId(ParkingOrder order) {
		order.setWxToOrderId(String.valueOf(System.currentTimeMillis()));
	}

	public static ParkingOrder buildParkingOrder(Integer offerId,
			Integer parkingId, String parkingName, String wxOpenidSellor,
			String wxNickNameSellor, String wxOpenidBuier,
			String wxNickNameBuier, Integer orderStatus, Double paidAmount,
			Double serviceFee, String buierMsg, String sellorMsg) {
		ParkingOrder order = new ParkingOrder();
		order.setOfferId(offerId);
		order.setParkingId(parkingId);
		order.setParkingName(parkingName);
		order.setWxOpenidSellor(wxOpenidSellor);
		order.setWxNickNameSellor(wxNickNameSellor);
		order.setWxOpenidBuier(wxOpenidBuier);
		order.setWxNickNameBuier(wxNickNameBuier);
		order.setOrderStatus(orderStatus);
		order.setPaidAmount(paidAmount);
		order.setServiceFee(serviceFee);
		order.setBuierMsg(buierMsg);
		order.setSellorMsg(sellorMsg);
		order.setOrderId(MD5Util.md5EncodeUTF8(wxOpenidBuier + offerId
				+ wxOpenidSellor + System.currentTimeMillis()));
		return order;
	}

	public static CouponOrder buildCouponOrder(Integer couponId,
			String couponBrand, Integer couponType, String couponQrcode,
			String wxOpenidBuier, String wxNickNameBuier, Integer orderStatus,
			Double paidAmount) {
		CouponOrder order = new CouponOrder();
		order.setCouponId(couponId);
		order.setCouponBrand(couponBrand);
		order.setCouponType(couponType);
		order.setCouponQrcode(couponQrcode);
		order.setWxOpenidBuier(wxOpenidBuier);
		order.setWxNickNameBuier(wxNickNameBuier);
		order.setOrderStatus(orderStatus);
		order.setPaidAmount(paidAmount);
		order.setCouponOrderId(MD5Util.md5EncodeUTF8(wxOpenidBuier + couponId
				+ System.currentTimeMillis()));
		return order;
	}

	/**
	 * 
	 * @param couponOrderId
	 * @param wxOrderId
	 *            <pre>
	 * 订单状态
	 * {@link com.khpp.common.constants.CommonConstans#COUPON_ORDER_STATUS_SUBMIT}
	 * {@link com.khpp.common.constants.CommonConstans#COUPON_ORDER_STATUS_FAILED}
	 * {@link com.khpp.common.constants.CommonConstans#COUPON_ORDER_STATUS_SUCCESS}
	 * </pre>
	 * @param orderStatus
	 * @return
	 */
	public static CouponOrder buildCouponOrder(String couponOrderId,
			String wxOrderId, int orderStatus) {
		CouponOrder order = new CouponOrder();
		order.setCouponOrderId(couponOrderId);
		order.setOrderStatus(orderStatus);
		order.setWxOrderId(wxOrderId);
		return order;
	}

	/**
	 * 
	 * @param orderId
	 * @param wxTransactionId
	 *            <pre>
	 * 订单状态
	 * {@link com.khpp.common.constants.CommonConstans#PARKING_ORDER_STATUS_SUBMIT}
	 * {@link com.khpp.common.constants.CommonConstans#PARKING_ORDER_STATUS_BUY}
	 * {@link com.khpp.common.constants.CommonConstans#PARKING_ORDER_STATUS_FAILED}
	 * {@link com.khpp.common.constants.CommonConstans#PARKING_ORDER_STATUS_SUCCESS}
	 * </pre>
	 * @param orderStatus
	 * @return
	 */
	public static ParkingOrder buildParkingOrder(String orderId,
			String wxTransactionId, int orderStatus) {
		ParkingOrder order = new ParkingOrder();
		order.setOrderId(orderId);
		order.setOrderStatus(orderStatus);
		order.setWxFromOrderId(wxTransactionId);
		return order;
	}

	public static CouponOffer buildCouponOffer(Integer couponId,
			Integer offerStatus) {
		CouponOffer offer = new CouponOffer();
		offer.setCouponId(couponId);
		offer.setOfferStatus(offerStatus);
		return offer;
	}
}
