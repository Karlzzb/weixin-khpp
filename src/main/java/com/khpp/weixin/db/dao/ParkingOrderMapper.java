package com.khpp.weixin.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.khpp.weixin.core.GenericDao;
import com.khpp.weixin.db.domain.ParkingOrder;
import com.khpp.weixin.db.domain.ParkingOrderExample;

public interface ParkingOrderMapper extends GenericDao<ParkingOrder, Integer> {
	int countByExample(ParkingOrderExample example);

	int deleteByExample(ParkingOrderExample example);

	int deleteByPrimaryKey(Integer orderId);

	int insert(ParkingOrder record);

	int insertSelective(ParkingOrder record);

	List<ParkingOrder> selectByExampleWithBLOBs(ParkingOrderExample example);

	List<ParkingOrder> selectByExample(ParkingOrderExample example);

	ParkingOrder selectByPrimaryKey(Integer orderId);

	int updateByExampleSelective(@Param("record") ParkingOrder record,
			@Param("example") ParkingOrderExample example);

	int updateByExampleWithBLOBs(@Param("record") ParkingOrder record,
			@Param("example") ParkingOrderExample example);

	int updateByExample(@Param("record") ParkingOrder record,
			@Param("example") ParkingOrderExample example);

	int updateByPrimaryKeySelective(ParkingOrder record);

	int updateByPrimaryKeyWithBLOBs(ParkingOrder record);

	int updateByPrimaryKey(ParkingOrder record);
}