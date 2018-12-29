/*
SQLyog Ultimate v12.2.6 (64 bit)
MySQL - 5.7.20-log : Database - sywg
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `sywg`;

/*Table structure for table `t_account_data_info` */

DROP TABLE IF EXISTS `t_account_data_info`;

CREATE TABLE `t_account_data_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_num` varchar(8) DEFAULT NULL,
  `accounting_time` varchar(20) DEFAULT NULL,
  `alipay_trade_no` varchar(64) NOT NULL,
  `alipay_tx_no` varchar(32) DEFAULT NULL,
  `merchant_order_no` varchar(32) DEFAULT NULL,
  `financial_type` varchar(16) DEFAULT NULL,
  `income` decimal(10,2) DEFAULT '0.00',
  `expenditure` decimal(10,2) DEFAULT '0.00',
  `balance` decimal(10,2) DEFAULT '0.00',
  `service_charge` decimal(10,2) DEFAULT '0.00',
  `payment_channel` varchar(24) DEFAULT NULL,
  `signed_products` varchar(64) DEFAULT NULL,
  `payer_account` varchar(24) DEFAULT NULL,
  `payer_name` varchar(32) DEFAULT NULL,
  `bank_order_code` varchar(32) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL,
  `order_code` varchar(64) NOT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `source_file_name` varchar(128) DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  `edit_time` datetime DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `a_o_k` (`alipay_trade_no`,`order_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_account_data_info_src` */

DROP TABLE IF EXISTS `t_account_data_info_src`;

CREATE TABLE `t_account_data_info_src` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_num` varchar(8) DEFAULT NULL,
  `accounting_time` varchar(20) DEFAULT NULL,
  `alipay_trade_no` varchar(64) DEFAULT NULL,
  `alipay_tx_no` varchar(32) DEFAULT NULL,
  `merchant_order_no` varchar(32) DEFAULT NULL,
  `financial_type` varchar(16) DEFAULT NULL,
  `income` decimal(10,2) DEFAULT '0.00',
  `expenditure` decimal(10,2) DEFAULT '0.00',
  `balance` decimal(10,2) DEFAULT '0.00',
  `service_charge` decimal(10,2) DEFAULT '0.00',
  `payment_channel` varchar(24) DEFAULT NULL,
  `signed_products` varchar(64) DEFAULT NULL,
  `payer_account` varchar(24) DEFAULT NULL,
  `payer_name` varchar(32) DEFAULT NULL,
  `bank_order_code` varchar(32) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL,
  `order_code` varchar(64) DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `source_file_name` varchar(128) DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  `edit_time` datetime DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_alipay_mismatch` */

DROP TABLE IF EXISTS `t_alipay_mismatch`;

CREATE TABLE `t_alipay_mismatch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_num` varchar(8) DEFAULT NULL,
  `accounting_time` varchar(20) DEFAULT NULL,
  `alipay_trade_no` varchar(64) NOT NULL,
  `alipay_tx_no` varchar(32) DEFAULT NULL,
  `merchant_order_no` varchar(32) DEFAULT NULL,
  `financial_type` varchar(16) DEFAULT NULL,
  `income` decimal(10,2) DEFAULT '0.00',
  `expenditure` decimal(10,2) DEFAULT '0.00',
  `balance` decimal(10,2) DEFAULT '0.00',
  `service_charge` decimal(10,2) DEFAULT '0.00',
  `payment_channel` varchar(24) DEFAULT NULL,
  `signed_products` varchar(64) DEFAULT NULL,
  `payer_account` varchar(24) DEFAULT NULL,
  `payer_name` varchar(32) DEFAULT NULL,
  `bank_order_code` varchar(32) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL,
  `order_code` varchar(64) NOT NULL,
  `remark` varchar(256) DEFAULT NULL,
  `source_file_name` varchar(128) DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  `edit_time` datetime DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `a_o_k` (`alipay_trade_no`,`order_code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `t_platform_mismatch` */

DROP TABLE IF EXISTS `t_platform_mismatch`;

CREATE TABLE `t_platform_mismatch` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(30) DEFAULT NULL COMMENT '状态(参考枚举:paymentrecordstatusenum)',
  `editor` varchar(100) DEFAULT NULL COMMENT '修改者',
  `creater` varchar(100) DEFAULT NULL COMMENT '创建者',
  `edit_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `product_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `merchant_order_no` varchar(50) NOT NULL COMMENT '商户订单号',
  `trx_no` varchar(50) NOT NULL COMMENT '支付流水号',
  `bank_order_no` varchar(50) DEFAULT NULL COMMENT '银行订单号',
  `bank_trx_no` varchar(50) DEFAULT NULL COMMENT '银行流水号',
  `merchant_name` varchar(300) DEFAULT NULL COMMENT '商家名称',
  `merchant_no` varchar(50) NOT NULL COMMENT '商家编号',
  `payer_user_no` varchar(50) DEFAULT NULL COMMENT '付款人编号',
  `payer_name` varchar(60) DEFAULT NULL COMMENT '付款人名称',
  `payer_pay_amount` decimal(20,6) DEFAULT '0.000000' COMMENT '付款方支付金额',
  `payer_fee` decimal(20,6) DEFAULT '0.000000' COMMENT '付款方手续费',
  `payer_account_type` varchar(30) DEFAULT NULL COMMENT '付款方账户类型(参考账户类型枚举:accounttypeenum)',
  `receiver_user_no` varchar(15) DEFAULT NULL COMMENT '收款人编号',
  `receiver_name` varchar(60) DEFAULT NULL COMMENT '收款人名称',
  `receiver_pay_amount` decimal(20,6) DEFAULT '0.000000' COMMENT '收款方支付金额',
  `receiver_fee` decimal(20,6) DEFAULT '0.000000' COMMENT '收款方手续费',
  `receiver_account_type` varchar(30) DEFAULT NULL COMMENT '收款方账户类型(参考账户类型枚举:accounttypeenum)',
  `order_ip` varchar(30) DEFAULT NULL COMMENT '下单ip(客户端ip,从网关中获取)',
  `order_referer_url` varchar(100) DEFAULT NULL COMMENT '从哪个页面链接过来的(可用于防诈骗)',
  `order_amount` decimal(20,6) DEFAULT '0.000000' COMMENT '订单金额',
  `plat_income` decimal(20,6) DEFAULT NULL COMMENT '平台收入',
  `fee_rate` decimal(20,6) DEFAULT NULL COMMENT '费率',
  `plat_cost` decimal(20,6) DEFAULT NULL COMMENT '平台成本',
  `plat_profit` decimal(20,6) DEFAULT NULL COMMENT '平台利润',
  `return_url` varchar(600) DEFAULT NULL COMMENT '页面回调通知url',
  `notify_url` varchar(600) DEFAULT NULL COMMENT '后台异步通知url',
  `pay_way_code` varchar(50) DEFAULT NULL COMMENT '支付方式编号',
  `pay_way_name` varchar(100) DEFAULT NULL COMMENT '支付方式名称',
  `pay_success_time` datetime DEFAULT NULL COMMENT '支付成功时间',
  `complete_time` datetime DEFAULT NULL COMMENT '完成时间',
  `is_refund` varchar(30) DEFAULT '101' COMMENT '是否退款(100:是,101:否,默认值为:101)',
  `refund_times` int(11) DEFAULT '0' COMMENT '退款次数(默认值为:0)',
  `success_refund_amount` decimal(20,6) DEFAULT NULL COMMENT '成功退款总金额',
  `trx_type` varchar(30) DEFAULT NULL COMMENT '交易业务类型  ：消费、充值等',
  `order_from` varchar(30) DEFAULT NULL COMMENT '订单来源',
  `pay_type_code` varchar(50) DEFAULT '“”' COMMENT '支付类型编号',
  `pay_type_name` varchar(100) DEFAULT NULL COMMENT '支付类型名称',
  `fund_into_type` varchar(30) DEFAULT NULL COMMENT '资金流入类型',
  `remark` varchar(3000) DEFAULT NULL COMMENT '备注',
  `field1` varchar(2000) DEFAULT NULL,
  `field2` varchar(500) DEFAULT NULL,
  `field3` varchar(500) DEFAULT NULL,
  `field4` varchar(500) DEFAULT NULL,
  `field5` varchar(500) DEFAULT NULL,
  `bank_return_msg` varchar(2000) DEFAULT NULL COMMENT '银行返回信息',
  `bank_channel_code` varchar(50) DEFAULT NULL,
  `bank_channel_name` varchar(100) DEFAULT NULL,
  `sett_type` varchar(30) DEFAULT NULL,
  `sett_status` varchar(30) DEFAULT NULL,
  `sett_merchant_no` varchar(50) DEFAULT NULL COMMENT '结算商户编号，主要是用来保存是结算给哪个商户的',
  `sett_request_no` varchar(50) DEFAULT '' COMMENT '结算请求号',
  `bank_way_code` varchar(50) DEFAULT NULL,
  `bank_way_name` varchar(100) DEFAULT NULL,
  `bank_code` varchar(50) DEFAULT NULL,
  `bank_name` varchar(100) DEFAULT NULL,
  `organization_no` varchar(50) DEFAULT NULL,
  `recon_status` varchar(50) DEFAULT 'NO',
  `recon_time` datetime DEFAULT NULL,
  `bank_result_order_no` varchar(100) DEFAULT NULL COMMENT '银行返回的订单号',
  `stage_num` int(4) DEFAULT NULL COMMENT '分期数',
  `payer_mch_id` varbinary(32) DEFAULT NULL COMMENT '用户在商户中的唯一编码（库分期）',
  `channel_merchant_no` varchar(100) DEFAULT NULL COMMENT '请求通道所使用的商户号',
  `tm_work_id` varchar(50) DEFAULT NULL COMMENT '同名进出支付标识',
  `open_card_id` varchar(50) DEFAULT NULL COMMENT '同名进商户号',
  `plat_merchant_code` varchar(50) DEFAULT NULL COMMENT '同名进出绑卡序号',
  `user_no` varchar(150) DEFAULT NULL COMMENT '商户号所属用户编号',
  `channel_merchant_name` varchar(50) DEFAULT '' COMMENT '商户号名称',
  `tm_order_type` varchar(20) DEFAULT NULL COMMENT '同名进出订单类型',
  `channel_type_id` int(11) DEFAULT NULL,
  `request_result_msg` varchar(2000) DEFAULT NULL COMMENT '请求返回信息',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `bank_order_no` (`bank_order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
