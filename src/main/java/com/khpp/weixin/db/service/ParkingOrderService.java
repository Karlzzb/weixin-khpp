package com.khpp.weixin.db.service;

import java.util.List;

import com.khpp.weixin.core.GenericService;
import com.khpp.weixin.db.domain.ParkingOrder;

public interface ParkingOrderService extends
		GenericService<ParkingOrder, String> {

	Boolean orderPayConfirm(String outTradeNo);

	List<ParkingOrder> getOrderListByBuier(String openId);

	Boolean orderBuierConfirm(String orderId);

}
