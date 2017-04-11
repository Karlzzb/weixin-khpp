package com.khpp.weixin.handler;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khpp.common.constants.WxMenuKeyConfig;
import com.khpp.db.domain.DictParking;
import com.khpp.db.service.DictParkingService;
import com.khpp.db.service.UserService;
import com.khpp.weixin.builder.AbstractBuilder;
import com.khpp.weixin.builder.TextBuilder;
import com.khpp.weixin.dto.WxMenuKey;
import com.khpp.weixin.service.WxGenricService;

/**
 * 
 * @author Binary Wang
 *
 */
@Component
public class MenuHandler extends AbstractHandler {

	@Autowired
	private UserService userService;

	@Autowired
	private DictParkingService dictParkingService;

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
			Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		WxGenricService weixinService = (WxGenricService) wxMpService;

		String key = wxMessage.getEventKey();
		WxMenuKey menuKey = new WxMenuKey(key, key);

		AbstractBuilder builder = null;
		switch (menuKey.getType()) {
		case WxMenuKeyConfig.CLICK_HELP:
			builder = new TextBuilder();
			menuKey.setContent("有什么可以帮您！");
			break;
		case WxMenuKeyConfig.PARKING_SELL:
			builder = new TextBuilder();
			menuKey.setContent(getParkingList());
			break;
		case WxMenuKeyConfig.PARKING_BUY:
			builder = new TextBuilder();
			menuKey.setContent(getParkingList());
			break;
		default:
			break;
		}

		if (builder != null) {
			try {
				return builder.build(menuKey.getContent(), wxMessage,
						weixinService);
			} catch (Exception e) {
				this.logger.error(e.getMessage(), e);
			}
		}

		return null;
	}

	private String getParkingList() {
		String content = "您附近有需求的停车场有: \n";
		List<DictParking> parkingList = dictParkingService.selectList();
		if (parkingList == null || parkingList.isEmpty()) {
			return content;
		}
		for (Iterator<DictParking> iterator = parkingList.iterator(); iterator
				.hasNext();) {
			DictParking dictParking = (DictParking) iterator.next();
			content += dictParking.getParkingId() + "."
					+ dictParking.getParkingName() + " \n";
		}
		content += "请选择?";
		return content;
	}

}
