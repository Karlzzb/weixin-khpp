package com.khpp.weixin.db.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khpp.weixin.core.GenericDao;
import com.khpp.weixin.core.GenericServiceImpl;
import com.khpp.weixin.db.dao.ParkingOrderMapper;
import com.khpp.weixin.db.domain.ParkingOrder;
import com.khpp.weixin.db.service.ParkingOrderService;

@Service
public class ParkingOrderServiceImpl extends
		GenericServiceImpl<ParkingOrder, String> implements ParkingOrderService {

	@Resource
	private ParkingOrderMapper parkingOrderMapper;

	@Override
	public GenericDao<ParkingOrder, String> getDao() {
		return parkingOrderMapper;
	}

}
