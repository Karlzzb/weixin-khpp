package com.khpp.weixin.service;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.kefu.result.WxMpKfOnlineList;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khpp.db.service.DictParkingService;
import com.khpp.weixin.dto.MenuConfig;
import com.khpp.weixin.dto.WxMpConfig;
import com.khpp.weixin.handler.AbstractHandler;
import com.khpp.weixin.handler.KfSessionHandler;
import com.khpp.weixin.handler.LocationHandler;
import com.khpp.weixin.handler.LogHandler;
import com.khpp.weixin.handler.MenuHandler;
import com.khpp.weixin.handler.MsgHandler;
import com.khpp.weixin.handler.NullHandler;
import com.khpp.weixin.handler.StoreCheckNotifyHandler;
import com.khpp.weixin.handler.SubscribeHandler;
import com.khpp.weixin.handler.UnsubscribeHandler;

/**
 * 
 * @author Binary Wang
 *
 */
@Service
public class WxGenricService extends WxMpServiceImpl {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected LogHandler logHandler;

	@Autowired
	protected NullHandler nullHandler;

	@Autowired
	protected KfSessionHandler kfSessionHandler;

	@Autowired
	protected StoreCheckNotifyHandler storeCheckNotifyHandler;

	@Autowired
	private WxMpConfig wxConfig;

	@Autowired
	private LocationHandler locationHandler;

	@Autowired
	private MenuHandler menuHandler;

	@Autowired
	private MsgHandler msgHandler;

	@Autowired
	private UnsubscribeHandler unsubscribeHandler;

	@Autowired
	private SubscribeHandler subscribeHandler;

	@Autowired
	private DictParkingService dictParkingService;

	private WxMpMessageRouter router;

	@PostConstruct
	public void init() throws Exception {
		final WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		config.setAppId(this.wxConfig.getAppid());// 设置微信公众号的appid
		config.setSecret(this.wxConfig.getAppsecret());// 设置微信公众号的app corpSecret
		config.setToken(this.wxConfig.getToken());// 设置微信公众号的token
		config.setAesKey(this.wxConfig.getAesKey());// 设置消息加解密密钥
		config.setPartnerId(this.wxConfig.getParentId());
		config.setPartnerKey(this.wxConfig.getParentKey());
		// 证书设置
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		try (FileInputStream instream = new FileInputStream(new File(
				this.wxConfig.getCertificatePath()))) {
			keyStore.load(instream, this.wxConfig.getParentId().toCharArray());
		}
		SSLContext sslcontext = SSLContexts
				.custom()
				.loadKeyMaterial(keyStore,
						this.wxConfig.getParentId().toCharArray()).build();
		config.setSslContext(sslcontext);
		super.setWxMpConfigStorage(config);
		this.refreshRouter();

		try {
			this.getMenuService().menuCreate(MenuConfig.getMenu(this));
		} catch (WxErrorException e) {
			this.logger.error("菜单初始化失败！", e);
		}
	}

	private void refreshRouter() {
		final WxMpMessageRouter newRouter = new WxMpMessageRouter(this);

		// 记录所有事件的日志
		newRouter.rule().handler(this.logHandler).next();

		// 接收客服会话管理事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxConsts.EVT_KF_CREATE_SESSION)
				.handler(this.kfSessionHandler).end();
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxConsts.EVT_KF_CLOSE_SESSION)
				.handler(this.kfSessionHandler).end();
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxConsts.EVT_KF_SWITCH_SESSION)
				.handler(this.kfSessionHandler).end();

		// 门店审核事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxConsts.EVT_POI_CHECK_NOTIFY)
				.handler(this.storeCheckNotifyHandler).end();

		// 自定义菜单事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxConsts.BUTTON_CLICK).handler(this.getMenuHandler())
				.end();

		// 点击菜单连接事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxConsts.BUTTON_VIEW).handler(this.nullHandler).end();

		// 关注事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxConsts.EVT_SUBSCRIBE)
				.handler(this.getSubscribeHandler()).end();

		// 取消关注事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxConsts.EVT_UNSUBSCRIBE)
				.handler(this.getUnsubscribeHandler()).end();

		// 上报地理位置事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxConsts.EVT_LOCATION)
				.handler(this.getLocationHandler()).end();

		// 接收地理位置消息
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_LOCATION)
				.handler(this.getLocationHandler()).end();

		// 扫码事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
				.event(WxConsts.EVT_SCAN).handler(this.getScanHandler()).end();

		// 默认
		newRouter.rule().async(false).handler(this.getMsgHandler()).end();

		this.router = newRouter;
	}

	public WxMpXmlOutMessage route(WxMpXmlMessage message) {
		try {
			return this.router.route(message);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}

		return null;
	}

	public boolean hasKefuOnline() {
		try {
			WxMpKfOnlineList kfOnlineList = this.getKefuService()
					.kfOnlineList();
			return kfOnlineList != null
					&& kfOnlineList.getKfOnlineList().size() > 0;
		} catch (Exception e) {
			this.logger.error("获取客服在线状态异常: " + e.getMessage(), e);
		}

		return false;
	}

	protected MenuHandler getMenuHandler() {
		return this.menuHandler;
	}

	protected SubscribeHandler getSubscribeHandler() {
		return this.subscribeHandler;
	}

	protected UnsubscribeHandler getUnsubscribeHandler() {
		return this.unsubscribeHandler;
	}

	protected AbstractHandler getLocationHandler() {
		return this.locationHandler;
	}

	protected MsgHandler getMsgHandler() {
		return this.msgHandler;
	}

	protected AbstractHandler getScanHandler() {
		return null;
	}

}
