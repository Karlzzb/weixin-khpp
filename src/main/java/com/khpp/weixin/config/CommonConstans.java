package com.khpp.weixin.config;

public class CommonConstans {
	public static final String SESSION_WXUSER_KEY = "wxMapuser";

	// 停车券状态
	public static final Integer OFFERSTATUS_PUBLIC = 1;
	public static final Integer OFFERSTATUS_SOLD = 2;
	public static final Integer OFFERSTATUS_UNAVILABLE = 3;
	public static final Integer OFFERVALIDHOURS = 4;

	// 服务费
	public static final double ORDER_SERVICE_FEE = 2.0;

	// 微信相关KEY值
	public static final String WX_TRADETYPE_JSAPI = "JSAPI";
	public static final String WX_PREPAY_ID_KEY = "prepay_id";

	// 订单状态常量
	public static final int PARKING_ORDER_STATUS_SUBMIT = 0;
	public static final int PARKING_ORDER_STATUS_BUY = 1;
	public static final int PARKING_ORDER_STATUS_SUCCESS = 3;
	public static final int PARKING_ORDER_STATUS_FAILED = 4;

}
