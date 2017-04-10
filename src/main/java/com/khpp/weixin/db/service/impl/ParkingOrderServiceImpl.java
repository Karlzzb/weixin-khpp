package com.khpp.weixin.db.service.impl;

import java.util.List;

import javax.annotation.Resource;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.khpp.weixin.config.CommonConstans;
import com.khpp.weixin.core.GenericDao;
import com.khpp.weixin.core.GenericServiceImpl;
import com.khpp.weixin.db.dao.ParkingOfferMapper;
import com.khpp.weixin.db.dao.ParkingOrderMapper;
import com.khpp.weixin.db.domain.ParkingOffer;
import com.khpp.weixin.db.domain.ParkingOrder;
import com.khpp.weixin.db.domain.ParkingOrderExample;
import com.khpp.weixin.db.service.ParkingOrderService;
import com.khpp.weixin.service.WeixinService;

@Service
public class ParkingOrderServiceImpl extends
		GenericServiceImpl<ParkingOrder, String> implements ParkingOrderService {

	private static final Logger logger = LoggerFactory
			.getLogger(ParkingOrderServiceImpl.class);

	@Resource
	private ParkingOrderMapper parkingOrderMapper;

	@Resource
	private ParkingOfferMapper parkingOfferMapper;

	@Resource
	private WeixinService weixinService;

	@Override
	public GenericDao<ParkingOrder, String> getDao() {
		return parkingOrderMapper;
	}

	@Override
	public Boolean orderPayConfirm(String orderId) {
		ParkingOrder order = parkingOrderMapper.selectByPrimaryKey(orderId);
		parkingOfferMapper.updateByPrimaryKeySelective(new ParkingOffer(order
				.getOfferId(), CommonConstans.OFFERSTATUS_SOLD));
		parkingOrderMapper.updateByPrimaryKeySelective(new ParkingOrder(
				orderId, CommonConstans.PARKING_ORDER_STATUS_BUY));
		try {
			weixinService.getKefuService().sendKefuMessage(
					WxMpKefuMessage.TEXT().toUser(order.getWxOpenidSellor())
							.content("你的停车券已经出售，请联系买家发货！").build());
		} catch (WxErrorException e) {
			logger.error("通知卖家售出失败：", e);
		}

		return false;
	}

	@Override
	public Boolean orderBuierConfirm(String orderId) {
		ParkingOrder order = parkingOrderMapper.selectByPrimaryKey(orderId);
		parkingOrderMapper.updateByPrimaryKeySelective(new ParkingOrder(
				orderId, CommonConstans.PARKING_ORDER_STATUS_SUCCESS));
		// TODO paid sellor

		try {
			weixinService.getKefuService().sendKefuMessage(
					WxMpKefuMessage.TEXT().toUser(order.getWxOpenidSellor())
							.content("你的停车券已经交易成功，钱款已转入你的账户，稍有延迟！").build());
		} catch (WxErrorException e) {
			logger.error("通知卖家收钱失败：", e);
		}

		return false;
	}

	@Override
	public List<ParkingOrder> getOrderListByBuier(String openId) {
		ParkingOrderExample example = new ParkingOrderExample();
		example.createCriteria().andWxOpenidBuierEqualTo(openId);
		example.setOrderByClause("dml_time desc");
		return parkingOrderMapper.selectByExample(example);
	}

}
