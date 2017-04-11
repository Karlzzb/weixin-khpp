package com.khpp.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.khpp.db.domain.ParkingOffer;
import com.khpp.db.domain.ParkingOfferExample;
import com.khpp.db.genric.GenericDao;

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