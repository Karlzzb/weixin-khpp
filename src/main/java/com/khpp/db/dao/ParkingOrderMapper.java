package com.khpp.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.khpp.db.domain.ParkingOrder;
import com.khpp.db.domain.ParkingOrderExample;
import com.khpp.db.genric.GenericDao;

public interface ParkingOrderMapper extends GenericDao<ParkingOrder, String> {
	int countByExample(ParkingOrderExample example);

	int deleteByExample(ParkingOrderExample example);

	int deleteByPrimaryKey(String orderId);

	int insert(ParkingOrder record);

	int insertSelective(ParkingOrder record);

	List<ParkingOrder> selectByExample(ParkingOrderExample example);

	ParkingOrder selectByPrimaryKey(String orderId);

	int updateByExampleSelective(@Param("record") ParkingOrder record,
			@Param("example") ParkingOrderExample example);

	int updateByExample(@Param("record") ParkingOrder record,
			@Param("example") ParkingOrderExample example);

	int updateByPrimaryKeySelective(ParkingOrder record);

	int updateByPrimaryKey(ParkingOrder record);
}