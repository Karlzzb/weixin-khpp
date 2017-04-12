create database khpp_db;
use khpp_db;
CREATE TABLE `user` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `wx_open_id` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL DEFAULT '',
  `paid_pw` varchar(64) NOT NULL DEFAULT '',
  `user_state` int(11) NOT NULL DEFAULT '1' COMMENT '用户状态：1-关注；2-取消关注',
  `subscribe_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '关注日期',
  `unsubscribe_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '取消关注日期',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dml_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `parking_order`;
CREATE TABLE `parking_order` (
  `order_id` char(32) NOT NULL,
  `offer_id` int(11) unsigned NOT NULL COMMENT '停车券ID',
  `parking_id` int(11) unsigned NOT NULL COMMENT '停车场ID',
  `parking_name` varchar(64) NOT NULL COMMENT '停车场名称',
  `wx_openid_sellor` varchar(64) NOT NULL COMMENT '卖家微信ID',
  `wx_nick_name_sellor` varchar(64) NOT NULL COMMENT '卖家微信匿名',
  `wx_openid_buier` varchar(64) NOT NULL COMMENT '买家微信ID',
  `wx_nick_name_buier` varchar(64) NOT NULL COMMENT '买家微信匿名',
  `order_status` int(11) NOT NULL DEFAULT '1' COMMENT '订单户状态：0-订单已提交；1-买家已支付；2-卖家发货；3-买家确认（交易成功）；4-交易失败',
  `wx_from_order_id` varchar(64) NOT NULL COMMENT '微信订单ID,收取订单',
  `wx_to_order_id` varchar(64) COMMENT '微信订单ID,支付订单',
  `paid_amount` decimal(8,2) NOT NULL COMMENT '支付价格',
  `service_fee` decimal(8,2) NOT NULL COMMENT '服务费用',
  `sellor_msg` varchar(128) COMMENT '卖家预留信息',
  `buier_msg` varchar(128) COMMENT '买家预留信息',
  `latitude` float(10,6) NOT NULL DEFAULT '0.000000' COMMENT '纬度',
  `longitude` float(10,6) NOT NULL DEFAULT '0.000000' COMMENT '经度 ',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dml_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期',
  PRIMARY KEY (`order_id`),
  KEY `user_id_sellor_key` (`wx_openid_sellor`),
  KEY `user_id_buier_key` (`wx_openid_buier`),
  KEY `offer_id_key` (`offer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='停车券订单表';

DROP TABLE IF EXISTS `dict_parking`;
CREATE TABLE `dict_parking` (
  `parking_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `parking_name` varchar(64) NOT NULL COMMENT '停车场名称',
  `defined_price` DECIMAL(8,2) NOT NULL DEFAULT 5 COMMENT '预定售价',
  `latitude` FLOAT(10,6) NOT NULL DEFAULT 0 COMMENT '纬度',
  `longitude` FLOAT(10,6) NOT NULL DEFAULT 0 COMMENT '经度 ',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dml_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期',
  PRIMARY KEY (`parking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='停车场字典表';

DROP TABLE IF EXISTS `parking_offer`;
CREATE TABLE `parking_offer` (
  `offer_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '停车券ID',
  `parking_id` int(11) unsigned NOT NULL COMMENT '停车场ID',
  `parking_name` varchar(64) NOT NULL COMMENT '停车场名称',
  `wx_openid` varchar(64) NOT NULL COMMENT '卖家微信ID',
  `wx_nick_name` varchar(64) NOT NULL COMMENT '卖家微信匿名',
  `offer_status` int(11) NOT NULL DEFAULT '1' COMMENT '卡券状态：1-发布中；2-已售出；3-暂时失效（被预定）；4-没用了;',
  `price` decimal(8,2) NOT NULL COMMENT '卖家售价',
  `valid_start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '有效交易时间（开始）',
  `valid_end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '有效交易时间（结束）',
  `detail` varchar(64) NOT NULL DEFAULT '' COMMENT '卖家描述',
  `latitude` float(10,6) NOT NULL DEFAULT '0.000000' COMMENT '纬度',
  `longitude` float(10,6) NOT NULL DEFAULT '0.000000' COMMENT '经度 ',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dml_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新日期',
  PRIMARY KEY (`offer_id`),
  KEY `user_id_sellor_key` (`wx_openid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='停车券表';