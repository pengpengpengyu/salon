/*
 Navicat Premium Data Transfer

 Source Server         : salon
 Source Server Type    : MySQL
 Source Server Version : 80027 (8.0.27)
 Source Host           : localhost:3306
 Source Schema         : salon

 Target Server Type    : MySQL
 Target Server Version : 80027 (8.0.27)
 File Encoding         : 65001

 Date: 13/07/2024 15:55:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_balance_consume_record
-- ----------------------------
DROP TABLE IF EXISTS `t_balance_consume_record`;
CREATE TABLE `t_balance_consume_record` (
  `balance_consume_record_id` bigint NOT NULL AUTO_INCREMENT COMMENT '余额消费记录id',
  `member_id` bigint NOT NULL DEFAULT '-1' COMMENT '会员id',
  `item_id` bigint NOT NULL COMMENT '项目id',
  `item_name` varchar(200) NOT NULL COMMENT '项目名称',
  `consume_amount` decimal(10,2) NOT NULL COMMENT '消费金额',
  `balance_original` decimal(10,2) DEFAULT '0.00' COMMENT '原始余额',
  `balance_after` decimal(10,2) DEFAULT '0.00' COMMENT '剩余余额',
  `give_balance_original` decimal(10,2) DEFAULT '0.00' COMMENT '原始赠送余额',
  `give_balance_after` decimal(10,2) DEFAULT '0.00' COMMENT '剩余赠送余额',
  `consume_date` date DEFAULT (curdate()) COMMENT '消费日期',
  `operator` varchar(60) DEFAULT '' COMMENT '操作人',
  `enter_store_channel` char(2) DEFAULT '' COMMENT '进店渠道',
  `introducer` varchar(60) DEFAULT '' COMMENT '介绍人',
  `remark` varchar(400) DEFAULT '' COMMENT '备注',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 null代表删除）',
  `create_by` varchar(64) DEFAULT 'system' COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT 'system' COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`balance_consume_record_id`),
  KEY `idx_balance_consume_record1` (`member_id`,`item_id`),
  KEY `idx_balance_consume_record2` (`introducer`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='余额消费记录表';

-- ----------------------------
-- Table structure for t_balance_recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `t_balance_recharge_record`;
CREATE TABLE `t_balance_recharge_record` (
  `balance_recharge_record_id` bigint NOT NULL AUTO_INCREMENT COMMENT '余额充值记录id',
  `member_id` bigint NOT NULL COMMENT '会员id',
  `recharge_amount` decimal(10,2) NOT NULL COMMENT '充值金额',
  `give_amount` decimal(10,2) DEFAULT '0.00' COMMENT '赠送金额',
  `activity_name` varchar(130) DEFAULT '' COMMENT '活动名称',
  `recharge_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '充值时间',
  `pay_mode` char(1) DEFAULT '1' COMMENT '支付方式 1微信 2支付宝 3现金 9其他',
  `remark` varchar(400) DEFAULT '' COMMENT '备注',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 null代表删除）',
  `create_by` varchar(64) DEFAULT 'system' COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT 'system' COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`balance_recharge_record_id`),
  KEY `idx_balance_recharge_record1` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='余额充值记录表';

-- ----------------------------
-- Table structure for t_item
-- ----------------------------
DROP TABLE IF EXISTS `t_item`;
CREATE TABLE `t_item` (
  `item_id` bigint NOT NULL AUTO_INCREMENT COMMENT '项目id',
  `item_name` varchar(200) NOT NULL COMMENT '项目名称',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  `discounted_price` decimal(10,2) DEFAULT '0.00' COMMENT '折扣价格',
  `description` varchar(320) DEFAULT '' COMMENT '描述',
  `del_item_id` bigint DEFAULT '0' COMMENT '删除的item_id,用于唯一索引',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT 'system' COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT 'system' COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`item_id`),
  UNIQUE KEY `uk_item1` (`item_name`,`del_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目表';

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `member_id` bigint NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `member_name` varchar(50) NOT NULL COMMENT '会员姓名',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `mobile_no` varchar(30) DEFAULT '' COMMENT '手机号',
  `gender` char(1) DEFAULT 'F' COMMENT '性别 F女 M男',
  `recharge_balance` decimal(10,2) DEFAULT '0.00' COMMENT '充值余额',
  `give_balance` decimal(10,2) DEFAULT '0.00' COMMENT '赠送余额',
  `integral` int DEFAULT '0' COMMENT '积分',
  `level` char(2) DEFAULT '00' COMMENT '等级',
  `label` varchar(30) DEFAULT '' COMMENT '标签',
  `introducer` varchar(60) DEFAULT '' COMMENT '介绍人',
  `remark` varchar(400) DEFAULT '' COMMENT '备注',
  `last_custom_date` date DEFAULT NULL COMMENT '最近消费日期',
  `del_member_id` bigint DEFAULT '0' COMMENT '删除的member_id,用于唯一索引',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT 'system' COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT 'system' COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`member_id`),
  UNIQUE KEY `uk_member1` (`member_name`,`mobile_no`,`del_member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员表';

-- ----------------------------
-- Table structure for t_member_item_rel
-- ----------------------------
DROP TABLE IF EXISTS `t_member_item_rel`;
CREATE TABLE `t_member_item_rel` (
  `member_item_rel_id` bigint NOT NULL AUTO_INCREMENT COMMENT '会员项目关联id',
  `member_id` bigint NOT NULL COMMENT '会员id',
  `item_id` bigint NOT NULL COMMENT '项目id',
  `times` int NOT NULL COMMENT '充值次数',
  `give_times` int NOT NULL DEFAULT '0' COMMENT '赠送次数',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 null代表删除）',
  `create_by` varchar(64) DEFAULT 'system' COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT 'system' COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`member_item_rel_id`),
  UNIQUE KEY `uk_member_item_rel` (`member_id`,`item_id`,`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=209 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员项目关联表';

-- ----------------------------
-- Table structure for t_rchg_give_item_record
-- ----------------------------
DROP TABLE IF EXISTS `t_rchg_give_item_record`;
CREATE TABLE `t_rchg_give_item_record` (
  `rchg_give_item_record_id` bigint NOT NULL AUTO_INCREMENT COMMENT '充值赠送项目记录id',
  `recharge_record_id` bigint NOT NULL COMMENT '充值记录id',
  `member_id` bigint NOT NULL COMMENT '会员id',
  `item_id` bigint NOT NULL COMMENT '项目id',
  `give_times` int NOT NULL COMMENT '赠送次数',
  `recharge_type` char(1) NOT NULL COMMENT '充值类型',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 null代表删除）',
  `create_by` varchar(64) DEFAULT 'system' COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT 'system' COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`rchg_give_item_record_id`),
  KEY `idx_chg_give_item_record1` (`recharge_record_id`,`recharge_type`),
  KEY `idx_chg_give_item_record2` (`member_id`,`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='充值赠送项目记录表';

-- ----------------------------
-- Table structure for t_times_consume_record
-- ----------------------------
DROP TABLE IF EXISTS `t_times_consume_record`;
CREATE TABLE `t_times_consume_record` (
  `times_consume_record_id` bigint NOT NULL AUTO_INCREMENT COMMENT '次数消费记录id',
  `member_id` bigint NOT NULL COMMENT '会员id',
  `item_id` bigint NOT NULL COMMENT '项目id',
  `item_name` varchar(200) NOT NULL COMMENT '项目名称',
  `consume_times` int NOT NULL DEFAULT '1' COMMENT '消费次数',
  `times_original` int DEFAULT NULL COMMENT '原始次数',
  `give_times_original` int DEFAULT NULL COMMENT '原始赠送次数',
  `times_after` int DEFAULT NULL COMMENT '剩余次数',
  `give_times_after` int DEFAULT NULL COMMENT '剩余赠送次数',
  `consume_date` date DEFAULT (curdate()) COMMENT '消费日期',
  `operator` varchar(60) DEFAULT '' COMMENT '操作人',
  `remark` varchar(400) DEFAULT '' COMMENT '备注',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 null代表删除）',
  `create_by` varchar(64) DEFAULT 'system' COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT 'system' COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`times_consume_record_id`),
  KEY `idx_times_consume_record1` (`member_id`,`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='次数消费记录表';

-- ----------------------------
-- Table structure for t_times_recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `t_times_recharge_record`;
CREATE TABLE `t_times_recharge_record` (
  `times_recharge_record_id` bigint NOT NULL AUTO_INCREMENT COMMENT '次数充值记录id',
  `member_id` bigint NOT NULL COMMENT '会员id',
  `item_id` bigint NOT NULL COMMENT '项目id',
  `recharge_times` int NOT NULL COMMENT '充值次数',
  `recharge_amount` decimal(10,2) NOT NULL COMMENT '充值金额',
  `give_amount` decimal(10,2) DEFAULT '0.00' COMMENT '赠送金额',
  `activity_name` varchar(130) DEFAULT '' COMMENT '活动名称',
  `recharge_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '充值时间',
  `pay_mode` char(1) DEFAULT '1' COMMENT '支付方式 1微信 2支付宝 3现金 9其他',
  `remark` varchar(400) DEFAULT '' COMMENT '备注',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 null代表删除）',
  `create_by` varchar(64) DEFAULT 'system' COMMENT '创建者',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT 'system' COMMENT '更新者',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`times_recharge_record_id`),
  KEY `idx_times_recharge_record1` (`member_id`,`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='次数充值记录表';

-- 散客会员初始化
insert into t_member (member_id, member_name)
values (-1, '散客');

SET FOREIGN_KEY_CHECKS = 1;
