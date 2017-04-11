package com.khpp.db.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khpp.common.constants.CommonConstans;
import com.khpp.db.dao.ParkingOfferMapper;
import com.khpp.db.domain.ParkingOffer;
import com.khpp.db.domain.ParkingOfferExample;
import com.khpp.db.genric.GenericDao;
import com.khpp.db.genric.GenericServiceImpl;
import com.khpp.db.service.ParkingOfferService;

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

	@Override
	public ParkingOffer selectById(Integer offerId) {

		return parkingOfferMapper.selectByPrimaryKey(offerId);
	}

	@Override
	public List<ParkingOffer> getAvailableOfferListByParkingId(Integer parkingId) {
		return getAvailableOfferListByParkingId(parkingId,
				CommonConstans.OFFERSTATUS_PUBLIC);
	}

	private List<ParkingOffer> getAvailableOfferListByParkingId(
			Integer parkingId, Integer offerStatus) {
		ParkingOfferExample example = new ParkingOfferExample();
		example.createCriteria().andParkingIdEqualTo(parkingId)
				.andOfferStatusEqualTo(offerStatus);
		example.setOrderByClause("dml_time desc");
		return parkingOfferMapper.selectByExample(example);
	}

	@Override
	public List<ParkingOffer> getOfferListByOwner(String openId) {
		ParkingOfferExample example = new ParkingOfferExample();
		example.createCriteria().andWxOpenidEqualTo(openId);
		example.setOrderByClause("dml_time desc");
		return parkingOfferMapper.selectByExample(example);
	}
}
