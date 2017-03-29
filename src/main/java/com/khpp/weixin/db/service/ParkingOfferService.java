package com.khpp.weixin.db.service;

import java.util.List;

import com.khpp.weixin.core.GenericService;
import com.khpp.weixin.db.domain.ParkingOffer;

public interface ParkingOfferService extends
		GenericService<ParkingOffer, Integer> {

	List<ParkingOffer> getOfferListByParkingId(Integer parkingId);

	List<ParkingOffer> getOfferListAll();

}
