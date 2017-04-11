package com.khpp.db.service;

import java.util.List;

import com.khpp.db.domain.ParkingOrder;
import com.khpp.db.genric.GenericService;

public interface ParkingOrderService extends
		GenericService<ParkingOrder, String> {

	Boolean txOrderPayConfirm(String outTradeNo);

	List<ParkingOrder> getOrderListByBuier(String openId);

	Boolean txOrderBuierConfirm(String orderId);

	void txOrderCreator(ParkingOrder parkingOrder);

}
