package com.khpp.db.service;

import java.util.List;

import com.khpp.db.domain.ParkingOffer;
import com.khpp.db.genric.GenericService;

public interface ParkingOfferService extends
		GenericService<ParkingOffer, Integer> {

	List<ParkingOffer> getOfferListByParkingId(Integer parkingId);

	List<ParkingOffer> getOfferListAll();

	Integer updateOfferStatus(int offerId, int offerStatus);

	List<ParkingOffer> getAvailableOfferListByParkingId(Integer selectParkingId);

	List<ParkingOffer> getOfferListByOwner(String openId);

}
