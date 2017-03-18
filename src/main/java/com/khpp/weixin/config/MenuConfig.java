package com.khpp.weixin.config;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.mp.api.WxMpService;

/**
 * Created by FirenzesEagle on 2016/6/1 0001. Email:liumingbo2008@gmail.com
 */
public class MenuConfig {

	/**
	 * 定义菜单结构
	 *
	 * @return
	 */
	public static WxMenu getMenu(WxMpService wxMpService) {

		WxMenu menu = new WxMenu();
		WxMenuButton button1 = new WxMenuButton();
		button1.setType(WxConsts.BUTTON_VIEW);
		button1.setName("星巴克");
		WxMenuButton button11 = new WxMenuButton();
		button11.setType(WxConsts.BUTTON_VIEW);
		button11.setName("下单");
		button11.setUrl(wxMpService.oauth2buildAuthorizationUrl("",
				"snsapi_base", ""));

		WxMenuButton button12 = new WxMenuButton();
		button12.setType(WxConsts.BUTTON_VIEW);
		button12.setName("我的订单");
		button12.setUrl(wxMpService.oauth2buildAuthorizationUrl("",
				"snsapi_base", ""));
		button1.getSubButtons().add(button11);
		button1.getSubButtons().add(button12);

		WxMenuButton button2 = new WxMenuButton();
		button2.setName("停车优惠");

		WxMenuButton button21 = new WxMenuButton();
		button21.setType(WxConsts.BUTTON_CLICK);
		button21.setName("卖停车券");
		button21.setKey(WxMenuKeyConfig.PARKING_SELL);

		WxMenuButton button22 = new WxMenuButton();
		button22.setType(WxConsts.BUTTON_VIEW);
		button22.setName("买停车券");
		button22.setUrl(wxMpService.oauth2buildAuthorizationUrl("",
				"snsapi_base", ""));

		WxMenuButton button23 = new WxMenuButton();
		button23.setType(WxConsts.BUTTON_VIEW);
		button23.setName("我的订单");
		button23.setUrl(wxMpService.oauth2buildAuthorizationUrl("",
				"snsapi_base", ""));

		WxMenuButton button24 = new WxMenuButton();
		button24.setType(WxConsts.BUTTON_VIEW);
		button24.setName("停车场申请");
		button24.setUrl(wxMpService.oauth2buildAuthorizationUrl("",
				"snsapi_base", ""));

		WxMenuButton button25 = new WxMenuButton();
		button25.setType(WxConsts.BUTTON_LOCATION_SELECT);
		button25.setName("发送地理信息");
		button25.setKey(WxMenuKeyConfig.LOCATION_SELECT);

		button2.getSubButtons().add(button21);
		button2.getSubButtons().add(button22);
		button2.getSubButtons().add(button23);
		button2.getSubButtons().add(button24);
		button2.getSubButtons().add(button25);

		WxMenuButton button3 = new WxMenuButton();
		button3.setType(WxConsts.BUTTON_CLICK);
		button3.setName("使用帮助");
		button3.setKey(WxMenuKeyConfig.CLICK_HELP);

		menu.getButtons().add(button1);
		menu.getButtons().add(button2);
		menu.getButtons().add(button3);

		return menu;
	}
}
