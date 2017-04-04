package com.khpp.weixin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Binary Wang
 *
 */
@Configuration
public class WxMpConfig {
	@Value("#{wxProperties.wx_token}")
	private String token;

	@Value("#{wxProperties.wx_appid}")
	private String appid;

	@Value("#{wxProperties.wx_appsecret}")
	private String appsecret;

	@Value("#{wxProperties.wx_aeskey}")
	private String aesKey;

	@Value("#{wxProperties.wx_mchid}")
	private String parentId;

	@Value("#{wxProperties.wx_mchkey}")
	private String parentKey;

	@Value("#{wxProperties.wx_p12}")
	private String certificatePath;

	public String getToken() {
		return this.token;
	}

	public String getAppid() {
		return this.appid;
	}

	public String getAppsecret() {
		return this.appsecret;
	}

	public String getAesKey() {
		return this.aesKey;
	}

	public String getParentId() {
		return parentId;
	}

	public String getParentKey() {
		return parentKey;
	}

	public String getCertificatePath() {
		return certificatePath;
	}
}
