package com.khpp.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.khpp.db.domain.CouponOrder;
import com.khpp.db.domain.CouponOrderExample;
import com.khpp.db.genric.GenericDao;

public interface CouponOrderMapper extends GenericDao<CouponOrder, String> {
	int countByExample(CouponOrderExample example);

	int deleteByExample(CouponOrderExample example);

	int deleteByPrimaryKey(String couponOrderId);

	int insert(CouponOrder record);

	int insertSelective(CouponOrder record);

	List<CouponOrder> selectByExample(CouponOrderExample example);

	CouponOrder selectByPrimaryKey(String couponOrderId);

	int updateByExampleSelective(@Param("record") CouponOrder record,
			@Param("example") CouponOrderExample example);

	int updateByExample(@Param("record") CouponOrder record,
			@Param("example") CouponOrderExample example);

	int updateByPrimaryKeySelective(CouponOrder record);

	int updateByPrimaryKey(CouponOrder record);
}