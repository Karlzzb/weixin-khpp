package com.khpp.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.khpp.db.domain.DictParking;
import com.khpp.db.domain.DictParkingExample;
import com.khpp.db.genric.GenericDao;

public interface DictParkingMapper extends GenericDao<DictParking, Integer> {
	int countByExample(DictParkingExample example);

	int deleteByExample(DictParkingExample example);

	int deleteByPrimaryKey(Integer parkingId);

	int insert(DictParking record);

	int insertSelective(DictParking record);

	List<DictParking> selectByExample(DictParkingExample example);

	DictParking selectByPrimaryKey(Integer parkingId);

	int updateByExampleSelective(@Param("record") DictParking record,
			@Param("example") DictParkingExample example);

	int updateByExample(@Param("record") DictParking record,
			@Param("example") DictParkingExample example);

	int updateByPrimaryKeySelective(DictParking record);

	int updateByPrimaryKey(DictParking record);
}