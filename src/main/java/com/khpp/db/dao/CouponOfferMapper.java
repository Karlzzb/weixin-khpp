package com.khpp.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.khpp.db.domain.CouponOffer;
import com.khpp.db.domain.CouponOfferExample;
import com.khpp.db.genric.GenericDao;

public interface CouponOfferMapper extends GenericDao<CouponOffer, Integer> {
	int countByExample(CouponOfferExample example);

	int deleteByExample(CouponOfferExample example);

	int deleteByPrimaryKey(Integer couponId);

	int insert(CouponOffer record);

	int insertSelective(CouponOffer record);

	List<CouponOffer> selectByExample(CouponOfferExample example);

	List<CouponOffer> selectByExamplePage(
			@Param("example") CouponOfferExample example,
			@Param("beginLine") Integer beginLine,
			@Param("endLine") Integer endLine);

	CouponOffer selectByPrimaryKey(Integer couponId);

	int updateByExampleSelective(@Param("record") CouponOffer record,
			@Param("example") CouponOfferExample example);

	int updateByExample(@Param("record") CouponOffer record,
			@Param("example") CouponOfferExample example);

	int updateByPrimaryKeySelective(CouponOffer record);

	int updateByPrimaryKey(CouponOffer record);
}