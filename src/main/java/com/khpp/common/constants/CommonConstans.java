package com.khpp.common.constants;

public class CommonConstans {
	public static final String SESSION_WXUSER_KEY = "wxMapuser";

	// 停车券状态
	public static final Integer OFFERSTATUS_PUBLIC = 1;
	public static final Integer OFFERSTATUS_SOLD = 2;
	public static final Integer OFFERSTATUS_TMP_UNAVILABLE = 3;
	public static final Integer OFFERSTATUS_USELESS = 4;
	public static final Integer OFFERVALIDHOURS = 4;// 默认停车券有效时间（小时）

	// 服务费
	public static final double ORDER_SERVICE_FEE = 0.2;

	// 微信相关KEY值
	public static final String WX_TRADETYPE_JSAPI = "JSAPI";
	public static final String WX_PREPAY_ID_KEY = "prepay_id";
	public static final String WX_PACKAGE_KEY = "package";
	public static final String WX_PACKAGE_PREFIX = "prepay_id=";

	// 停车券订单状态常量
	public static final int PARKING_ORDER_STATUS_SUBMIT = 0;
	public static final int PARKING_ORDER_STATUS_BUY = 1;
	public static final int PARKING_ORDER_STATUS_SUCCESS = 3;
	public static final int PARKING_ORDER_STATUS_FAILED = 4;

	// 支付用户红包名
	public static final String REDBAG_TITLE_PARKING = "停车券分享";

	// 优惠券类型
	public static final String COUPON_BRAND_STARBUCKS = "starbucks";
	public static final int COUPON_TYPE_STARBUCKS_REGULAR = 1001;
	public static final int COUPON_TYPE_STARBUCKS_LARGE = 1002;

	// 优惠券状态
	public static final Integer COUPON_OFFER_STATUS_PUBLIC = 1;
	public static final Integer COUPON_OFFER_STATUS_SOLD = 2;
	public static final Integer COUPON_OFFER_STATUS_TMP_UNAVILABLE = 3;
	public static final Integer COUPON_OFFER_STATUS_USELESS = 4;

	// 优惠券订单状态常量
	public static final Integer COUPON_ORDER_STATUS_SUBMIT = 0;
	public static final Integer COUPON_ORDER_STATUS_SUCCESS = 3;
	public static final Integer COUPON_ORDER_STATUS_FAILED = 4;
}
