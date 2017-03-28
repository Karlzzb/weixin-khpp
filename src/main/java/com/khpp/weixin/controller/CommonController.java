package com.khpp.weixin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共视图控制器
 * 
 * @author starzou
 * @since 2014年4月15日 下午4:16:34
 **/
@Controller
public class CommonController {
	/**
	 * 首页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request) {
		return "index";
	}

	/**
	 * 首页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("MP_verify_dAhoxDfAZ6LUl5Z2.txt")
	public String reDirectFile(HttpServletRequest request) {
		return "MP_verify_dAhoxDfAZ6LUl5Z2";
	}

}