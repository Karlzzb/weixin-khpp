package com.khpp.weixin.handler;

import java.util.Map;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

import org.springframework.stereotype.Component;

import com.khpp.weixin.builder.AbstractBuilder;
import com.khpp.weixin.builder.TextBuilder;
import com.khpp.weixin.config.WxMenuKeyConfig;
import com.khpp.weixin.dto.WxMenuKey;
import com.khpp.weixin.service.WeixinService;

/**
 * 
 * @author Binary Wang
 *
 */
@Component
public class MenuHandler extends AbstractHandler {

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
			Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		WeixinService weixinService = (WeixinService) wxMpService;

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
			menuKey.setContent("您附近有需求的停车场有：\n 1.宝龙广场  \n 2.长泰广场\n 请选择?");
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

}
