package com.khpp.db.service.impl;

import java.util.List;

import javax.annotation.Resource;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.pay.result.WxPaySendRedpackResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.khpp.common.constants.CommonConstans;
import com.khpp.common.utils.MathUtil;
import com.khpp.db.dao.ParkingOfferMapper;
import com.khpp.db.dao.ParkingOrderMapper;
import com.khpp.db.domain.ParkingOffer;
import com.khpp.db.domain.ParkingOrder;
import com.khpp.db.domain.ParkingOrderExample;
import com.khpp.db.genric.DomainBuilder;
import com.khpp.db.genric.GenericDao;
import com.khpp.db.genric.GenericServiceImpl;
import com.khpp.db.service.ParkingOrderService;
import com.khpp.weixin.service.WxGenricService;
import com.khpp.weixin.service.WxPayService;

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
	private WxPayService wxPayService;

	@Resource
	private WxGenricService wxGenricService;

	@Override
	public GenericDao<ParkingOrder, String> getDao() {
		return parkingOrderMapper;
	}

	@Override
	public Boolean txOrderPayConfirm(String orderId) {
		ParkingOrder order = parkingOrderMapper.selectByPrimaryKey(orderId);
		if (order == null
				|| !order.getOrderStatus().equals(
						CommonConstans.PARKING_ORDER_STATUS_SUBMIT)) {
			return false;
		}

		try {
			// notice sellor
			wxGenricService.getKefuService().sendKefuMessage(
					WxMpKefuMessage
							.TEXT()
							.toUser(order.getWxOpenidSellor())
							.content(
									"你的停车券已经出售,买家已支付，请及时联系买家发货！\n买家【"
											+ order.getWxNickNameBuier()
											+ "】预留信息：" + order.getBuierMsg())
							.build());
			// notice buier
			wxGenricService.getKefuService().sendKefuMessage(
					WxMpKefuMessage
							.TEXT()
							.toUser(order.getWxOpenidBuier())
							.content(
									"卖家【" + order.getWxNickNameSellor()
											+ "】预留信息：" + order.getSellorMsg())
							.build());
		} catch (WxErrorException e) {
			logger.error("通知买卖方交易信息失败：", e);
		}
		parkingOfferMapper.updateByPrimaryKeySelective(new ParkingOffer(order
				.getOfferId(), CommonConstans.OFFERSTATUS_SOLD));
		parkingOrderMapper.updateByPrimaryKeySelective(DomainBuilder
				.buildParkingOrder(orderId,
						CommonConstans.PARKING_ORDER_STATUS_BUY));

		return false;
	}

	@Override
	public Boolean txOrderBuierConfirm(String orderId) {
		ParkingOrder order = parkingOrderMapper.selectByPrimaryKey(orderId);
		DomainBuilder.genratewxToOrderId(order);
		try {
			WxPaySendRedpackResult wxPaySendRedpackResult = wxPayService
					.singleRedBagSentor(
							order.getWxToOrderId(),
							CommonConstans.REDBAG_TITLE_PARKING,
							order.getWxOpenidSellor(),
							MathUtil.div(order.getPaidAmount(),
									order.getServiceFee()));
			logger.info("向个人支付红包的结果：" + wxPaySendRedpackResult.getXmlString());
			wxGenricService.getKefuService().sendKefuMessage(
					WxMpKefuMessage.TEXT().toUser(order.getWxOpenidSellor())
							.content("你的停车券已经交易成功，钱款已转入你的账户，稍有延迟！").build());
			parkingOrderMapper.updateByPrimaryKeySelective(DomainBuilder
					.buildParkingOrder(order.getOrderId(),
							CommonConstans.PARKING_ORDER_STATUS_SUCCESS,
							order.getWxToOrderId()));
			return true;
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

	@Override
	public void txOrderCreator(ParkingOrder parkingOrder) {
		parkingOrderMapper.insertSelective(parkingOrder);
		parkingOfferMapper.updateByPrimaryKeySelective(new ParkingOffer(
				parkingOrder.getOfferId(),
				CommonConstans.OFFERSTATUS_TMP_UNAVILABLE));
	}
}
