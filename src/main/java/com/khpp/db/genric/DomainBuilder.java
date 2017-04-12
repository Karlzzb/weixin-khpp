package com.khpp.db.genric;

import com.khpp.common.utils.MD5Util;
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
}
