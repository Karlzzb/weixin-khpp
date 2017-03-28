package com.khpp.weixin.handler;

import me.chanjar.weixin.mp.api.WxMpMessageHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

/**
 * 
 * @author Binary Wang
 *
 */
public abstract class AbstractHandler implements WxMpMessageHandler {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected final Gson gson = new Gson();

}
