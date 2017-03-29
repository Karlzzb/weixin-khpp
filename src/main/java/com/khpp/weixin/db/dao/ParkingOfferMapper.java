package com.khpp.weixin.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.khpp.weixin.core.GenericDao;
import com.khpp.weixin.db.domain.ParkingOffer;
import com.khpp.weixin.db.domain.ParkingOfferExample;

public interface ParkingOfferMapper extends GenericDao<ParkingOffer, Integer> {
	int countByExample(ParkingOfferExample example);

	int deleteByExample(ParkingOfferExample example);

	int deleteByPrimaryKey(Integer offerId);

	int insert(ParkingOffer record);

	int insertSelective(ParkingOffer record);

	List<ParkingOffer> selectByExample(ParkingOfferExample example);

	ParkingOffer selectByPrimaryKey(Integer offerId);

	int updateByExampleSelective(@Param("record") ParkingOffer record,
			@Param("example") ParkingOfferExample example);

	int updateByExample(@Param("record") ParkingOffer record,
			@Param("example") ParkingOfferExample example);

	int updateByPrimaryKeySelective(ParkingOffer record);

	int updateByPrimaryKey(ParkingOffer record);
}