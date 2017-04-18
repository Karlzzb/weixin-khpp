package com.khpp.db.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.khpp.db.domain.CouponOrder;
import com.khpp.db.genric.GenericService;

public interface CouponOrderService extends GenericService<CouponOrder, String> {

	public Boolean txOrderPayConfirm(HttpServletRequest request,
			String couponOrderId, String wxTransactionId);

	public void txOrderCreator(CouponOrder couponOrder);

	public CouponOrder getOrderById(String orderId);

	public List<CouponOrder> getOrdersByBuier(String openId);
}
