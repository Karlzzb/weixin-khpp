package com.khpp.db.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khpp.common.constants.CommonConstans;
import com.khpp.db.dao.CouponOfferMapper;
import com.khpp.db.domain.CouponOffer;
import com.khpp.db.domain.CouponOfferExample;
import com.khpp.db.genric.GenericDao;
import com.khpp.db.genric.GenericServiceImpl;
import com.khpp.db.service.CouponOfferService;

@Service
public class CouponOfferServiceImpl extends
		GenericServiceImpl<CouponOffer, Integer> implements CouponOfferService {

	@Resource
	private CouponOfferMapper couponOfferMapper;

	private ConcurrentLinkedQueue<CouponOffer> regularStarbucksCuopon;
	private ConcurrentLinkedQueue<CouponOffer> largeStarbucksCuopon;

	@PostConstruct
	public void init() throws Exception {
		regularStarbucksCuopon = new ConcurrentLinkedQueue<CouponOffer>();
		largeStarbucksCuopon = new ConcurrentLinkedQueue<CouponOffer>();

		// 释放数据库中被队列占用的券
		CouponOffer record = new CouponOffer();
		record.setOfferStatus(CommonConstans.COUPON_OFFER_STATUS_PUBLIC);
		CouponOfferExample example = new CouponOfferExample();
		example.createCriteria().andOfferStatusEqualTo(
				CommonConstans.COUPON_OFFER_STATUS_TMP_UNAVILABLE);
		couponOfferMapper.updateByExampleSelective(record, example);
	}

	@Override
	public CouponOffer takeCoupon(String couponBrand, int couponType) {
		CouponOffer couponOffer = null;
		if (CommonConstans.COUPON_BRAND_STARBUCKS.equals(couponBrand)) {
			ConcurrentLinkedQueue<CouponOffer> queue = null;
			switch (couponType) {
			case CommonConstans.COUPON_TYPE_STARBUCKS_REGULAR:
				queue = regularStarbucksCuopon;
				break;
			case CommonConstans.COUPON_TYPE_STARBUCKS_LARGE:
				queue = largeStarbucksCuopon;
				break;
			default:
				break;
			}
			couponOffer = queue.poll();
			if (couponOffer == null) {
				couponOffer = fillQueue(queue, couponType);
			}
		}
		return couponOffer;
	}

	@Override
	public Boolean returnCoupon(CouponOffer couponOffer) {
		if (couponOffer == null) {
			return Boolean.FALSE;
		}
		ConcurrentLinkedQueue<CouponOffer> queue = null;
		switch (couponOffer.getCouponType()) {
		case CommonConstans.COUPON_TYPE_STARBUCKS_REGULAR:
			queue = regularStarbucksCuopon;
			break;
		case CommonConstans.COUPON_TYPE_STARBUCKS_LARGE:
			queue = largeStarbucksCuopon;
			break;
		default:
			break;
		}
		if (queue != null) {
			return queue.add(couponOffer);
		}
		return Boolean.FALSE;
	}

	@Override
	public GenericDao<CouponOffer, Integer> getDao() {
		return this.couponOfferMapper;
	}

	/**
	 * 填充优惠券队列
	 * 
	 * @param queue
	 * @param couponType
	 * @return
	 */
	private CouponOffer fillQueue(ConcurrentLinkedQueue<CouponOffer> queue,
			int couponType) {
		synchronized (queue) {
			CouponOfferExample example = new CouponOfferExample();
			example.createCriteria()
					.andCouponTypeEqualTo(couponType)
					.andOfferStatusEqualTo(
							CommonConstans.COUPON_OFFER_STATUS_PUBLIC);
			List<CouponOffer> offerList = couponOfferMapper
					.selectByExamplePage(example, 0, 10);
			if (offerList != null && !offerList.isEmpty()) {
				CouponOffer record = new CouponOffer();
				record.setOfferStatus(CommonConstans.COUPON_OFFER_STATUS_TMP_UNAVILABLE);
				example = new CouponOfferExample();
				List<Integer> offerIds = new ArrayList<Integer>();
				for (CouponOffer offer : offerList) {
					offerIds.add(offer.getCouponId());
				}
				example.createCriteria().andCouponIdIn(offerIds);
				couponOfferMapper.updateByExampleSelective(record, example);
				queue.addAll(offerList);
			}
		}
		return queue.poll();
	}

	@Override
	public void updateCouponOfferStatus(Integer couponId, Integer offerStatus) {
		CouponOffer offer = new CouponOffer();
		offer.setCouponId(couponId);
		offer.setOfferStatus(offerStatus);
		couponOfferMapper.updateByPrimaryKeySelective(offer);
	}

	@Override
	public CouponOffer getCouponOffer(Integer couponId) {
		return couponOfferMapper.selectByPrimaryKey(couponId);
	}

}
