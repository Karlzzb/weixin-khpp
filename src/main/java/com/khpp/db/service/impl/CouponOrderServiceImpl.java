package com.khpp.db.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.khpp.common.constants.CommonConstans;
import com.khpp.db.dao.CouponOfferMapper;
import com.khpp.db.dao.CouponOrderMapper;
import com.khpp.db.domain.CouponOrder;
import com.khpp.db.domain.CouponOrderExample;
import com.khpp.db.genric.DomainBuilder;
import com.khpp.db.genric.GenericDao;
import com.khpp.db.genric.GenericServiceImpl;
import com.khpp.db.service.CouponOrderService;
import com.khpp.weixin.service.WxGenricService;

/**
 * 优惠券订单Service实现类
 * 
 * @author kevin
 *
 */
@Service
public class CouponOrderServiceImpl extends
		GenericServiceImpl<CouponOrder, String> implements CouponOrderService {
	private static final Logger logger = LoggerFactory
			.getLogger(CouponOrderServiceImpl.class);

	@Resource
	private CouponOrderMapper couponOrderMapper;

	@Resource
	private CouponOfferMapper couponOfferMapper;

	@Resource
	private WxGenricService wxGenricService;

	@Override
	public GenericDao<CouponOrder, String> getDao() {
		return this.couponOrderMapper;
	}

	@Override
	public void txOrderCreator(CouponOrder couponOrder) {
		couponOrderMapper.insertSelective(couponOrder);
	}

	@Override
	public Boolean txOrderPayConfirm(HttpServletRequest request,
			String couponOrderId, String wxTransactionId) {
		CouponOrder order = couponOrderMapper.selectByPrimaryKey(couponOrderId);
		if (order == null
				|| !order.getOrderStatus().equals(
						CommonConstans.COUPON_ORDER_STATUS_SUBMIT)) {
			return false;
		}
		try {
			// TODO 二维码发送问题
			WxMpKefuMessage.WxArticle article = new WxMpKefuMessage.WxArticle();
			article.setPicUrl(request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ "/wxredirect/couponqr?orderId="
					+ order.getCouponOrderId());
			article.setDescription("向柜台出示此二维码，来支付您的咖啡\n感谢您的惠顾，祝愿您度过美好的一天！");
			article.setTitle("您的星巴克券");
			wxGenricService.getKefuService().sendKefuMessage(
					WxMpKefuMessage.NEWS().toUser(order.getWxOpenidBuier())
							.addArticle(article).build());
			couponOrderMapper.updateByPrimaryKeySelective(DomainBuilder
					.buildCouponOrder(order.getCouponOrderId(),
							wxTransactionId,
							CommonConstans.COUPON_ORDER_STATUS_SUCCESS));
			couponOfferMapper.updateByPrimaryKeySelective(DomainBuilder
					.buildCouponOffer(order.getCouponId(),
							CommonConstans.COUPON_OFFER_STATUS_SOLD));
			return true;
		} catch (Exception e) {
			logger.error("优惠券交易确认失败{orderId:" + couponOrderId
					+ ",wxTransactionId:" + wxTransactionId + "}", e);
		}
		return false;
	}

	@Override
	public CouponOrder getOrderById(String couponOrderId) {
		return couponOrderMapper.selectByPrimaryKey(couponOrderId);
	}

	@Override
	public List<CouponOrder> getOrdersByBuier(String openId) {
		CouponOrderExample example = new CouponOrderExample();
		example.createCriteria().andWxOpenidBuierEqualTo(openId);
		example.setOrderByClause("dml_time desc");
		return couponOrderMapper.selectByExample(example);
	}
}
