package com.khpp.weixin.builder;

import com.khpp.weixin.service.WxGenricService;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutImageMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * 
 * @author Binary Wang
 *
 */
public class ImageBuilder extends AbstractBuilder {

  @Override
  public WxMpXmlOutMessage build(String content, WxMpXmlMessage wxMessage,
      WxGenricService service) {

    WxMpXmlOutImageMessage m = WxMpXmlOutMessage.IMAGE().mediaId(content)
        .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
        .build();

    return m;
  }

}
