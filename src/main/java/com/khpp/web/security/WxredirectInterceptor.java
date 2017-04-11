package com.khpp.web.security;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.khpp.common.constants.CommonConstans;
import com.khpp.weixin.service.WxGenricService;

public class WxredirectInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory
			.getLogger(WxredirectInterceptor.class);

	@Resource
	private WxGenricService wxGenricService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Object wxMapuserObj = request.getSession().getAttribute(
				CommonConstans.SESSION_WXUSER_KEY);
		if (wxMapuserObj != null && wxMapuserObj instanceof WxMpUser) {
			return Boolean.TRUE;
		}
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()) {
			logger.error("Redirect code is not exists, auth failed!");
			return Boolean.FALSE;
		}
		WxMpUser wxMapuser = wxGenricService.oauth2getUserInfo(
				wxGenricService.oauth2getAccessToken(code), null);
		if (wxMapuser == null) {
			logger.error("WxMpUser is empty according to the code[" + code
					+ "], auth failed!");
			return Boolean.FALSE;
		}
		request.getSession().setAttribute(CommonConstans.SESSION_WXUSER_KEY,
				wxMapuser);
		return Boolean.TRUE;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
