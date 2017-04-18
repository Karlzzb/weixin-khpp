package com.khpp.db.service;

import com.khpp.db.domain.CouponOffer;
import com.khpp.db.genric.GenericService;

public interface CouponOfferService extends
		GenericService<CouponOffer, Integer> {

	/**
	 * 提取一个优惠券
	 * 
	 * @param couponBrand
	 * @param couponType
	 * @return
	 */
	public CouponOffer takeCoupon(String couponBrand, int couponType);

	/**
	 * 归还一个优惠券
	 * 
	 * @param couponOffer
	 * @return
	 */
	public Boolean returnCoupon(CouponOffer couponOffer);

	/**
	 * 修改优惠券状态
	 * 
	 * @param couponId
	 * @param couponOfferStatus
	 */
	public void updateCouponOfferStatus(Integer couponId, Integer offerStatus);

	/**
	 * 数据库查询
	 * 
	 * @param couponOfferId
	 * @return
	 */
	public CouponOffer getCouponOffer(Integer couponId);
}
