package com.khpp.weixin.db.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khpp.weixin.core.GenericDao;
import com.khpp.weixin.core.GenericServiceImpl;
import com.khpp.weixin.db.dao.ParkingOfferMapper;
import com.khpp.weixin.db.domain.ParkingOffer;
import com.khpp.weixin.db.domain.ParkingOfferExample;
import com.khpp.weixin.db.service.ParkingOfferService;

@Service
public class ParkingOfferServiceImpl extends
		GenericServiceImpl<ParkingOffer, Integer> implements
		ParkingOfferService {

	@Resource
	private ParkingOfferMapper parkingOfferMapper;

	@Override
	public GenericDao<ParkingOffer, Integer> getDao() {
		return parkingOfferMapper;
	}

	@Override
	public List<ParkingOffer> getOfferListByParkingId(Integer parkingId) {
		ParkingOfferExample example = new ParkingOfferExample();
		example.createCriteria().andParkingIdEqualTo(parkingId);
		return parkingOfferMapper.selectByExample(example);
	}

	@Override
	public List<ParkingOffer> getOfferListAll() {
		ParkingOfferExample example = new ParkingOfferExample();
		return parkingOfferMapper.selectByExample(example);
	}

	@Override
	public Integer updateOfferStatus(int offerId, int offerStatus) {
		return parkingOfferMapper.updateByPrimaryKeySelective(new ParkingOffer(
				offerId, offerStatus));
	}
}
