/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : phone_erp

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-06-13 21:50:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for allot
-- ----------------------------
DROP TABLE IF EXISTS `allot`;
CREATE TABLE `allot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `in_shop_id` int(11) NOT NULL COMMENT '入库门店Id',
  `out_shop_id` int(11) NOT NULL COMMENT '出库门店Id',
  `operat_time` date NOT NULL COMMENT '调拨时间',
  `phone_id` int(11) NOT NULL COMMENT '手机Id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调拨单';

-- ----------------------------
-- Records of allot
-- ----------------------------

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(50) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `brand_name` (`brand_name`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES ('1', '三星', null, '2016-06-07 19:55:23');
INSERT INTO `brand` VALUES ('2', '魅蓝', null, '2016-06-07 19:55:52');
INSERT INTO `brand` VALUES ('3', '红米', null, '2016-06-07 19:56:15');
INSERT INTO `brand` VALUES ('4', '小米', null, '2016-06-07 20:01:23');
INSERT INTO `brand` VALUES ('5', '华为', null, '2016-06-07 20:01:33');
INSERT INTO `brand` VALUES ('6', '酷派', null, '2016-06-07 20:01:42');
INSERT INTO `brand` VALUES ('7', '联想', null, '2016-06-07 20:01:50');
INSERT INTO `brand` VALUES ('8', '至美', null, '2016-06-07 20:02:02');
INSERT INTO `brand` VALUES ('10', '珀云', null, '2016-06-07 20:03:52');
INSERT INTO `brand` VALUES ('11', '沃普丰', null, '2016-06-07 20:04:00');
INSERT INTO `brand` VALUES ('12', 'OPPO', null, '2016-06-07 20:04:07');
INSERT INTO `brand` VALUES ('13', 'Vivo', null, '2016-06-07 20:04:13');
INSERT INTO `brand` VALUES ('14', '金立', null, '2016-06-07 20:04:20');
INSERT INTO `brand` VALUES ('15', '菲乐普', null, '2016-06-07 20:04:31');
INSERT INTO `brand` VALUES ('16', '老人智能机', null, '2016-06-07 20:04:47');
INSERT INTO `brand` VALUES ('17', '小天才手表', null, '2016-06-07 20:04:53');
INSERT INTO `brand` VALUES ('18', '护宝星儿童手表', null, '2016-06-07 20:04:59');
INSERT INTO `brand` VALUES ('19', '奥乐', null, '2016-06-07 20:05:05');
INSERT INTO `brand` VALUES ('20', '欧奇', null, '2016-06-07 20:05:12');
INSERT INTO `brand` VALUES ('21', '金雷', null, '2016-06-07 20:05:17');
INSERT INTO `brand` VALUES ('22', '聆韵', null, '2016-06-07 20:05:23');
INSERT INTO `brand` VALUES ('23', '先科', null, '2016-06-07 20:05:29');
INSERT INTO `brand` VALUES ('24', '诺菲', null, '2016-06-07 20:05:35');
INSERT INTO `brand` VALUES ('25', '海尔', null, '2016-06-07 20:05:48');
INSERT INTO `brand` VALUES ('26', '渴望', null, '2016-06-07 20:05:55');
INSERT INTO `brand` VALUES ('27', '唐为', null, '2016-06-07 20:06:00');
INSERT INTO `brand` VALUES ('28', '诺凯', null, '2016-06-07 20:06:07');
INSERT INTO `brand` VALUES ('29', '心迪', null, '2016-06-07 20:06:12');
INSERT INTO `brand` VALUES ('30', '嘉源', null, '2016-06-07 20:06:18');
INSERT INTO `brand` VALUES ('31', '奥洛斯', null, '2016-06-07 20:06:23');
INSERT INTO `brand` VALUES ('32', '同心', null, '2016-06-07 20:06:29');
INSERT INTO `brand` VALUES ('33', '金摩达', null, '2016-06-07 20:06:39');
INSERT INTO `brand` VALUES ('34', '恒宇丰', null, '2016-06-07 20:06:45');
INSERT INTO `brand` VALUES ('35', '中天语', null, '2016-06-07 20:06:53');
INSERT INTO `brand` VALUES ('36', '京凯达', null, '2016-06-07 20:06:58');
INSERT INTO `brand` VALUES ('37', '科乐斯', null, '2016-06-07 20:07:03');
INSERT INTO `brand` VALUES ('38', '诺基亚', null, '2016-06-07 20:07:09');
INSERT INTO `brand` VALUES ('39', '铂乐', null, '2016-06-07 20:07:13');
INSERT INTO `brand` VALUES ('40', '华纳威秀', null, '2016-06-07 20:07:22');
INSERT INTO `brand` VALUES ('41', '小天才', null, '2016-06-07 20:07:27');
INSERT INTO `brand` VALUES ('42', '贝尔丰', null, '2016-06-07 20:07:33');
INSERT INTO `brand` VALUES ('43', '福中福', null, '2016-06-07 20:07:39');
INSERT INTO `brand` VALUES ('44', '魅族', null, '2016-06-07 20:07:48');
INSERT INTO `brand` VALUES ('45', '完美', null, '2016-06-07 20:07:58');
INSERT INTO `brand` VALUES ('46', '乐视', null, '2016-06-07 20:08:06');
INSERT INTO `brand` VALUES ('47', '紫米', null, '2016-06-07 20:08:14');
INSERT INTO `brand` VALUES ('48', '金来紫米', null, '2016-06-07 20:08:22');
INSERT INTO `brand` VALUES ('49', '铂云', null, '2016-06-07 20:08:30');
INSERT INTO `brand` VALUES ('50', '星米', null, '2016-06-07 20:08:38');
INSERT INTO `brand` VALUES ('51', '丰米', null, '2016-06-07 20:08:45');
INSERT INTO `brand` VALUES ('52', '优思', null, '2016-06-07 20:08:54');
INSERT INTO `brand` VALUES ('53', '科铭', null, '2016-06-07 20:09:01');
INSERT INTO `brand` VALUES ('54', '百迪通', null, '2016-06-07 20:09:08');
INSERT INTO `brand` VALUES ('55', '全福', null, '2016-06-07 20:09:15');

-- ----------------------------
-- Table structure for color
-- ----------------------------
DROP TABLE IF EXISTS `color`;
CREATE TABLE `color` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `color_name` varchar(50) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `color_name` (`color_name`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of color
-- ----------------------------
INSERT INTO `color` VALUES ('1', '白', null, '2016-06-07 20:21:23');
INSERT INTO `color` VALUES ('3', '黑', null, '2016-06-07 20:21:30');
INSERT INTO `color` VALUES ('4', '金', null, '2016-06-07 20:21:31');
INSERT INTO `color` VALUES ('5', '银', null, '2016-06-07 20:21:31');
INSERT INTO `color` VALUES ('6', '蓝', null, '2016-06-07 20:21:31');
INSERT INTO `color` VALUES ('7', '黄', null, '2016-06-07 20:21:32');
INSERT INTO `color` VALUES ('8', '红', null, '2016-06-07 20:21:32');
INSERT INTO `color` VALUES ('9', '咖啡', null, '2016-06-07 20:21:32');
INSERT INTO `color` VALUES ('10', '俏丽粉', null, '2016-06-07 20:21:32');
INSERT INTO `color` VALUES ('11', '香槟金', null, '2016-06-07 20:21:33');
INSERT INTO `color` VALUES ('12', '星亮黑', null, '2016-06-07 20:21:33');
INSERT INTO `color` VALUES ('13', '中国红', null, '2016-06-07 20:21:33');
INSERT INTO `color` VALUES ('14', '精睿银', null, '2016-06-07 20:21:34');
INSERT INTO `color` VALUES ('15', '樽金', null, '2016-06-07 20:21:34');
INSERT INTO `color` VALUES ('16', '红色', null, '2016-06-07 20:21:34');
INSERT INTO `color` VALUES ('17', '兰', null, '2016-06-07 20:21:34');
INSERT INTO `color` VALUES ('18', '灰', null, '2016-06-07 20:21:34');
INSERT INTO `color` VALUES ('19', '粉', null, '2016-06-07 20:21:35');
INSERT INTO `color` VALUES ('20', '粉色', null, '2016-06-07 20:21:35');
INSERT INTO `color` VALUES ('21', '玫瑰金', null, '2016-06-07 20:21:36');
INSERT INTO `color` VALUES ('22', '魔力黑', null, '2016-06-07 20:21:36');
INSERT INTO `color` VALUES ('23', '锖', null, '2016-06-07 20:21:36');
INSERT INTO `color` VALUES ('24', '绿', null, '2016-06-07 20:21:37');

-- ----------------------------
-- Table structure for model
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model_name` varchar(50) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `model_name` (`model_name`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of model
-- ----------------------------
INSERT INTO `model` VALUES ('1', 'A9000', null, '2016-06-07 20:17:34');
INSERT INTO `model` VALUES ('2', 'G5108', null, '2016-06-07 20:17:38');
INSERT INTO `model` VALUES ('3', 'S7278', null, '2016-06-07 20:17:38');
INSERT INTO `model` VALUES ('4', 'G3588V', null, '2016-06-07 20:17:39');
INSERT INTO `model` VALUES ('5', 'G5500', null, '2016-06-07 20:17:39');
INSERT INTO `model` VALUES ('6', 'Note2', null, '2016-06-07 20:17:39');
INSERT INTO `model` VALUES ('7', '4C', null, '2016-06-07 20:17:40');
INSERT INTO `model` VALUES ('8', '4C增强版', null, '2016-06-07 20:17:40');
INSERT INTO `model` VALUES ('9', '4A', null, '2016-06-07 20:17:40');
INSERT INTO `model` VALUES ('10', '荣耀4X', null, '2016-06-07 20:17:41');
INSERT INTO `model` VALUES ('11', '8712', null, '2016-06-07 20:17:41');
INSERT INTO `model` VALUES ('12', 'A5800', null, '2016-06-07 20:17:41');
INSERT INTO `model` VALUES ('13', 'A2800', null, '2016-06-07 20:17:41');
INSERT INTO `model` VALUES ('14', 'A368t', null, '2016-06-07 20:17:42');
INSERT INTO `model` VALUES ('15', 'X3', null, '2016-06-07 20:17:42');
INSERT INTO `model` VALUES ('16', 'GM520', null, '2016-06-07 20:17:42');
INSERT INTO `model` VALUES ('17', 'S2', null, '2016-06-07 20:17:43');
INSERT INTO `model` VALUES ('18', '5117', null, '2016-06-07 20:17:43');
INSERT INTO `model` VALUES ('19', 'A33', null, '2016-06-07 20:17:43');
INSERT INTO `model` VALUES ('20', 'X5Prov', null, '2016-06-07 20:17:43');
INSERT INTO `model` VALUES ('21', 'N152', null, '2016-06-07 20:17:44');
INSERT INTO `model` VALUES ('22', 'GN5001S', null, '2016-06-07 20:17:44');
INSERT INTO `model` VALUES ('23', 'GN8001', null, '2016-06-07 20:17:44');
INSERT INTO `model` VALUES ('24', 'Z513', null, '2016-06-07 20:17:45');
INSERT INTO `model` VALUES ('25', 'VOLTE', null, '2016-06-07 20:17:45');
INSERT INTO `model` VALUES ('26', 'Y102', null, '2016-06-07 20:17:45');
INSERT INTO `model` VALUES ('28', 'A515', null, '2016-06-07 20:17:46');
INSERT INTO `model` VALUES ('29', '188', null, '2016-06-07 20:17:46');
INSERT INTO `model` VALUES ('30', '690', null, '2016-06-07 20:17:46');
INSERT INTO `model` VALUES ('31', 'E830', null, '2016-06-07 20:17:47');
INSERT INTO `model` VALUES ('32', 'OK118', null, '2016-06-07 20:17:47');
INSERT INTO `model` VALUES ('33', 'OKV7', null, '2016-06-07 20:17:47');
INSERT INTO `model` VALUES ('34', 'C5小钢炮', null, '2016-06-07 20:17:48');
INSERT INTO `model` VALUES ('35', 'pi300', null, '2016-06-07 20:17:48');
INSERT INTO `model` VALUES ('36', 'A818', null, '2016-06-07 20:17:48');
INSERT INTO `model` VALUES ('37', 'A819', null, '2016-06-07 20:17:49');
INSERT INTO `model` VALUES ('38', 'NL26', null, '2016-06-07 20:17:49');
INSERT INTO `model` VALUES ('39', 'M320', null, '2016-06-07 20:17:49');
INSERT INTO `model` VALUES ('40', 'A9', null, '2016-06-07 20:17:50');
INSERT INTO `model` VALUES ('41', 'TW99', null, '2016-06-07 20:17:50');
INSERT INTO `model` VALUES ('42', 'TW90电信版', null, '2016-06-07 20:17:50');
INSERT INTO `model` VALUES ('43', 'TW99电信版', null, '2016-06-07 20:17:50');
INSERT INTO `model` VALUES ('44', 'WT96', null, '2016-06-07 20:17:51');
INSERT INTO `model` VALUES ('45', 'G818', null, '2016-06-07 20:17:51');
INSERT INTO `model` VALUES ('46', 'D5000', null, '2016-06-07 20:17:51');
INSERT INTO `model` VALUES ('47', '399', null, '2016-06-07 20:17:52');
INSERT INTO `model` VALUES ('48', 'V328', null, '2016-06-07 20:17:52');
INSERT INTO `model` VALUES ('49', '302', null, '2016-06-07 20:17:52');
INSERT INTO `model` VALUES ('50', 'TK100B', null, '2016-06-07 20:17:53');
INSERT INTO `model` VALUES ('51', '106铁榔头', null, '2016-06-07 20:17:53');
INSERT INTO `model` VALUES ('52', '998', null, '2016-06-07 20:17:53');
INSERT INTO `model` VALUES ('53', '1088C', null, '2016-06-07 20:17:53');
INSERT INTO `model` VALUES ('54', '166P', null, '2016-06-07 20:17:54');
INSERT INTO `model` VALUES ('55', 'i58', null, '2016-06-07 20:17:54');
INSERT INTO `model` VALUES ('56', 'K818', null, '2016-06-07 20:17:54');
INSERT INTO `model` VALUES ('57', '130', null, '2016-06-07 20:17:54');
INSERT INTO `model` VALUES ('58', '107', null, '2016-06-07 20:17:55');
INSERT INTO `model` VALUES ('59', 'A5100', null, '2016-06-07 20:17:55');
INSERT INTO `model` VALUES ('60', 'A7108', null, '2016-06-07 20:17:55');
INSERT INTO `model` VALUES ('61', '5S', null, '2016-06-07 20:17:56');
INSERT INTO `model` VALUES ('62', 'L88福星', null, '2016-06-07 20:17:56');
INSERT INTO `model` VALUES ('63', 'F8', null, '2016-06-07 20:17:56');
INSERT INTO `model` VALUES ('64', 'GN9010', null, '2016-06-07 20:17:57');
INSERT INTO `model` VALUES ('65', 'Note3', null, '2016-06-07 20:17:57');
INSERT INTO `model` VALUES ('66', 'KV106', null, '2016-06-07 20:17:57');
INSERT INTO `model` VALUES ('67', '368t ', null, '2016-06-07 20:17:57');
INSERT INTO `model` VALUES ('68', 'TW96H', null, '2016-06-07 20:17:58');
INSERT INTO `model` VALUES ('69', 'Y01', null, '2016-06-07 20:17:58');
INSERT INTO `model` VALUES ('70', '3608', null, '2016-06-07 20:17:58');
INSERT INTO `model` VALUES ('71', '5X', null, '2016-06-07 20:17:58');
INSERT INTO `model` VALUES ('72', 'V3Max', null, '2016-06-07 20:17:59');
INSERT INTO `model` VALUES ('73', 'S7 edge', null, '2016-06-07 20:17:59');
INSERT INTO `model` VALUES ('74', 'X6S A(64G)', null, '2016-06-07 20:17:59');
INSERT INTO `model` VALUES ('75', 'Y35 A', null, '2016-06-07 20:18:00');
INSERT INTO `model` VALUES ('76', 'T13', null, '2016-06-07 20:18:00');
INSERT INTO `model` VALUES ('77', 'NL16', null, '2016-06-07 20:18:00');
INSERT INTO `model` VALUES ('78', 'FL103', null, '2016-06-07 20:18:01');
INSERT INTO `model` VALUES ('79', 'XPlay5A', null, '2016-06-07 20:18:01');
INSERT INTO `model` VALUES ('80', '3', null, '2016-06-07 20:18:01');
INSERT INTO `model` VALUES ('81', '5c', null, '2016-06-07 20:18:02');
INSERT INTO `model` VALUES ('82', 'F669', null, '2016-06-07 20:18:02');
INSERT INTO `model` VALUES ('83', 'Y51', null, '2016-06-07 20:18:02');
INSERT INTO `model` VALUES ('84', 'V3', null, '2016-06-07 20:18:02');
INSERT INTO `model` VALUES ('85', 'R9Plustm', null, '2016-06-07 20:18:03');
INSERT INTO `model` VALUES ('86', 'A53', null, '2016-06-07 20:18:03');
INSERT INTO `model` VALUES ('87', 'A33m', null, '2016-06-07 20:18:03');
INSERT INTO `model` VALUES ('88', 'A31', null, '2016-06-07 20:18:04');
INSERT INTO `model` VALUES ('89', 'F100', null, '2016-06-07 20:18:04');
INSERT INTO `model` VALUES ('90', 'GN152', null, '2016-06-07 20:18:04');
INSERT INTO `model` VALUES ('91', 'J5008', null, '2016-06-07 20:18:04');
INSERT INTO `model` VALUES ('92', 'Y635', null, '2016-06-07 20:18:05');
INSERT INTO `model` VALUES ('93', 'Y523', null, '2016-06-07 20:18:05');
INSERT INTO `model` VALUES ('94', '平板58-710w', null, '2016-06-07 20:18:05');
INSERT INTO `model` VALUES ('95', 'MX5', null, '2016-06-07 20:18:06');
INSERT INTO `model` VALUES ('96', 'N0TE2', null, '2016-06-07 20:18:06');
INSERT INTO `model` VALUES ('97', 'A2860', null, '2016-06-07 20:18:07');
INSERT INTO `model` VALUES ('98', 'K3', null, '2016-06-07 20:18:07');
INSERT INTO `model` VALUES ('99', 'T18', null, '2016-06-07 20:18:07');
INSERT INTO `model` VALUES ('100', 'X6splus', null, '2016-06-07 20:18:07');
INSERT INTO `model` VALUES ('101', 'X6S', null, '2016-06-07 20:18:08');
INSERT INTO `model` VALUES ('102', 'Y23', null, '2016-06-07 20:18:08');
INSERT INTO `model` VALUES ('103', 'R7Plus', null, '2016-06-07 20:18:08');
INSERT INTO `model` VALUES ('104', '6607', null, '2016-06-07 20:18:09');
INSERT INTO `model` VALUES ('105', '9011', null, '2016-06-07 20:18:09');
INSERT INTO `model` VALUES ('106', 'F105', null, '2016-06-07 20:18:09');
INSERT INTO `model` VALUES ('107', 'M5plus', null, '2016-06-07 20:18:10');
INSERT INTO `model` VALUES ('108', '187', null, '2016-06-07 20:18:10');
INSERT INTO `model` VALUES ('109', 'M5', null, '2016-06-07 20:18:10');
INSERT INTO `model` VALUES ('110', '709L', null, '2016-06-07 20:18:10');
INSERT INTO `model` VALUES ('111', 'W5', null, '2016-06-07 20:18:11');
INSERT INTO `model` VALUES ('112', 'V338', null, '2016-06-07 20:18:11');
INSERT INTO `model` VALUES ('113', 'TW2014V', null, '2016-06-07 20:18:11');
INSERT INTO `model` VALUES ('114', 'TW96', null, '2016-06-07 20:18:12');
INSERT INTO `model` VALUES ('115', 'TW91', null, '2016-06-07 20:18:12');
INSERT INTO `model` VALUES ('116', 'TW90', null, '2016-06-07 20:18:12');
INSERT INTO `model` VALUES ('117', 'M318', null, '2016-06-07 20:18:12');
INSERT INTO `model` VALUES ('118', 'Mate8', null, '2016-06-07 20:18:13');
INSERT INTO `model` VALUES ('119', 'C5巨无霸', null, '2016-06-07 20:18:13');
INSERT INTO `model` VALUES ('120', 'Y51A', null, '2016-06-07 20:18:13');
INSERT INTO `model` VALUES ('121', 'G-3608', null, '2016-06-07 20:18:14');
INSERT INTO `model` VALUES ('122', 'G-5500', null, '2016-06-07 20:18:14');
INSERT INTO `model` VALUES ('123', '2', null, '2016-06-07 20:18:14');
INSERT INTO `model` VALUES ('124', 'Y29', null, '2016-06-07 20:18:15');
INSERT INTO `model` VALUES ('125', '荣耀5X', null, '2016-06-07 20:18:15');
INSERT INTO `model` VALUES ('126', '荣耀4A', null, '2016-06-07 20:18:15');
INSERT INTO `model` VALUES ('127', 'A100', null, '2016-06-07 20:18:16');
INSERT INTO `model` VALUES ('128', 'MX4', null, '2016-06-07 20:18:16');
INSERT INTO `model` VALUES ('129', 'A3800', null, '2016-06-07 20:18:16');
INSERT INTO `model` VALUES ('130', 'GN5002', null, '2016-06-07 20:18:17');
INSERT INTO `model` VALUES ('131', 'G5', null, '2016-06-07 20:18:17');
INSERT INTO `model` VALUES ('132', 'G6', null, '2016-06-07 20:18:18');
INSERT INTO `model` VALUES ('133', 'G11', null, '2016-06-07 20:18:18');
INSERT INTO `model` VALUES ('134', 'GM520-D', null, '2016-06-07 20:18:18');
INSERT INTO `model` VALUES ('135', 'T-M3', null, '2016-06-07 20:18:19');
INSERT INTO `model` VALUES ('136', 'BF-T12', null, '2016-06-07 20:18:19');
INSERT INTO `model` VALUES ('137', '978', null, '2016-06-07 20:18:19');
INSERT INTO `model` VALUES ('138', 'TW96K', null, '2016-06-07 20:18:20');
INSERT INTO `model` VALUES ('139', 'TW91A', null, '2016-06-07 20:18:20');
INSERT INTO `model` VALUES ('140', 'V68', null, '2016-06-07 20:18:20');
INSERT INTO `model` VALUES ('141', 'DL300', null, '2016-06-07 20:18:21');
INSERT INTO `model` VALUES ('142', 'V19', null, '2016-06-07 20:18:21');
INSERT INTO `model` VALUES ('143', '830', null, '2016-06-07 20:18:21');
INSERT INTO `model` VALUES ('144', 'N8', null, '2016-06-07 20:18:21');
INSERT INTO `model` VALUES ('145', 'N6', null, '2016-06-07 20:18:22');
INSERT INTO `model` VALUES ('146', 'US68C', null, '2016-06-07 20:18:22');
INSERT INTO `model` VALUES ('147', 'WPA1', null, '2016-06-07 20:18:22');
INSERT INTO `model` VALUES ('148', 'TK300A', null, '2016-06-07 20:18:22');
INSERT INTO `model` VALUES ('149', 'F633', null, '2016-06-07 20:18:22');
INSERT INTO `model` VALUES ('150', 'AE302', null, '2016-06-07 20:18:23');
INSERT INTO `model` VALUES ('151', 'D137', null, '2016-06-07 20:18:23');
INSERT INTO `model` VALUES ('152', 'TSCSL', null, '2016-06-07 20:18:23');
INSERT INTO `model` VALUES ('153', 'Z166P', null, '2016-06-07 20:18:24');
INSERT INTO `model` VALUES ('154', '荣耀7', null, '2016-06-07 20:18:24');
INSERT INTO `model` VALUES ('155', 'X6S(64G)', null, '2016-06-07 20:18:25');
INSERT INTO `model` VALUES ('158', 'A37m', null, '2016-06-13 09:33:04');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_id` int(11) DEFAULT NULL COMMENT '手机Id',
  `saler_id` int(11) NOT NULL COMMENT '销售员Id',
  `shop_id` int(11) NOT NULL COMMENT '卖出店铺Id',
  `order_time` date NOT NULL COMMENT '卖出日期',
  `bill_no` int(11) DEFAULT NULL COMMENT '发票流水号',
  `bill_price` decimal(10,2) DEFAULT NULL COMMENT '销售单总价',
  `order_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `buyer_name` varchar(255) DEFAULT NULL COMMENT '顾客姓名',
  `buyer_phone` varchar(255) DEFAULT NULL COMMENT '顾客手机',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售单主表';

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for phone
-- ----------------------------
DROP TABLE IF EXISTS `phone`;
CREATE TABLE `phone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imei_no` varchar(50) NOT NULL COMMENT '手机串号',
  `color_id` int(11) DEFAULT NULL COMMENT '手机颜色',
  `brand_id` int(11) DEFAULT NULL COMMENT '手机牌子',
  `phone_type` varchar(10) DEFAULT NULL COMMENT '机型(下拉框：智能机、按键机)',
  `pur_price` decimal(10,2) DEFAULT NULL COMMENT '手机采购(进货)价格',
  `sale_price` decimal(10,2) DEFAULT NULL COMMENT '手机建议销售价格',
  `model_id` int(11) DEFAULT NULL COMMENT '手机型号',
  `current_shop_id` int(11) DEFAULT NULL COMMENT '当前所属店铺',
  `is_sold` bit(1) DEFAULT b'0' COMMENT '是否卖出(0:否;1:是)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '是否被删除(0:否;1:是)',
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `imei_no` (`imei_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1023 DEFAULT CHARSET=utf8 COMMENT='手机产品表';

-- ----------------------------
-- Records of phone
-- ----------------------------
INSERT INTO `phone` VALUES ('1', '358686070163286', '1', '1', '智能机', '2850.00', null, '1', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('2', '355967063886551', '1', '1', '智能机', '1180.00', null, '2', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('3', '353822061636155', '1', '1', '智能机', '390.00', null, '3', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('4', '352956067723764', '2', '1', '智能机', '790.00', null, '4', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('5', '354728070861586', '4', '1', '智能机', '750.00', null, '5', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('6', '868586025087387', '1', '2', '智能机', '810.00', null, '6', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('7', '868800029029760', '1', '2', '智能机', '810.00', null, '6', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('8', '868512020867516', '1', '3', '智能机', '575.00', null, '6', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('9', '869336021606270', '1', '4', '智能机', '820.00', null, '7', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('10', '868090021505088', '2', '5', '智能机', '878.00', null, '8', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('11', '869637028603552', '1', '5', '智能机', '620.00', null, '9', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('12', '866940022302152', '1', '5', '智能机', '850.00', null, '10', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('13', '869265026902998', '1', '6', '智能机', '299.00', null, '11', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('14', '869265026917822', '1', '6', '智能机', '299.00', null, '11', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('15', '869265026927326', '1', '6', '智能机', '299.00', null, '11', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('16', '865951025552280', '1', '7', '智能机', '320.00', null, '12', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('17', '867577024749136', '2', '7', '智能机', '225.00', null, '13', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('18', '867577024736943', '2', '7', '智能机', '225.00', null, '13', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('19', '866583025121177', '2', '7', '智能机', '275.00', null, '14', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('20', '865517020087760', '1', '8', '智能机', '450.00', null, '15', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('21', '867688021078740', '4', '10', '智能机', '330.00', null, '16', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('22', '865840024004239', '4', '11', '智能机', '260.00', null, '17', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('23', '866050028197810', '1', '12', '智能机', '1600.00', null, '18', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('24', '861075036871655', '1', '12', '智能机', '810.00', null, '19', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('25', '867368021338291', '1', '13', '智能机', '1630.00', null, '20', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('26', '867894025174952', '1', '14', '智能机', '549.00', null, '21', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('27', '868618022691984', '4', '14', '智能机', '899.00', null, '22', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('28', '867798020556792', '5', '14', '智能机', '1999.00', null, '23', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('29', '866701010036974', '2', '15', '智能机', '300.00', null, '24', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('30', '869445020076813', '4', '16', '智能机', '300.00', null, '25', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('31', '868948025040487', '6', '17', '智能机', '300.00', null, '26', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('32', '867709020840409', '6', '18', '智能机', '300.00', null, null, '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('33', '867709020840730', '1', '18', '智能机', '300.00', null, null, '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('34', '868564001153556', '7', '19', '按键机', '80.00', null, '28', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('35', '862677022964292', '6', '19', '按键机', '69.00', null, '29', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('36', '862677022636296', '1', '19', '按键机', '69.00', null, '29', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('37', '862677022649810', '1', '19', '按键机', '69.00', null, '29', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('38', '869274000514720', '8', '19', '按键机', '110.00', null, '30', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('39', '860609010695416', '1', '19', '按键机', '85.00', null, '31', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('40', '862145781429279', '2', '20', '按键机', '130.00', null, '32', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('41', '862145781701420', '2', '20', '按键机', '130.00', null, '32', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('42', '866677002182051', '6', '20', '按键机', '160.00', null, '33', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('43', '863104010166888', '9', '21', '按键机', '80.00', null, '34', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('44', '862064021404226', '2', '22', '按键机', '115.00', null, '35', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('45', '864943022784117', '10', '23', '按键机', '99.00', null, '36', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('46', '864943022785017', '10', '23', '按键机', '160.00', null, '37', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('47', '864943022145848', '11', '23', '按键机', '99.00', null, '36', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('48', '864943022756691', '12', '23', '按键机', '99.00', null, '36', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('49', '864943022697101', '13', '23', '按键机', '99.00', null, '36', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('50', '864943024011327', '11', '23', '按键机', '160.00', null, '37', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('51', '862713026361704', '8', '24', '按键机', '85.00', null, '38', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('52', '867434022035098', '14', '25', '按键机', '135.00', null, '39', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('53', '867434022009653', '15', '25', '按键机', '135.00', null, '39', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('54', '865111000811579', '16', '26', '按键机', '95.00', null, '40', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('55', '866541021287400', '2', '27', '按键机', '120.00', null, '41', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('56', '866541021247008', '9', '27', '按键机', '120.00', null, '41', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('57', 'A200009310FB234', '8', '27', '按键机', '120.00', null, '42', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('58', 'A20000900EAA350', '2', '27', '按键机', '120.00', null, '43', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('59', 'A200009303C210C', '8', '27', '按键机', '120.00', null, '43', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('60', '866541026508602', '17', '27', '按键机', '120.00', null, '44', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('61', '866541026499497', '1', '27', '按键机', '110.00', null, '44', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('62', '865058002812370', '1', '28', '按键机', '110.00', null, '45', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('63', '868981016773303', '4', '22', '按键机', '90.00', null, '46', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('64', '861778003801387', '2', '29', '按键机', '100.00', null, '47', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('65', '356269020057601', '7', '30', '按键机', '80.00', null, '48', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('66', '863104010158562', '2', '21', '按键机', '80.00', null, '34', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('67', '862518020961148', '2', '31', '按键机', '90.00', null, '49', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('68', '865899010759411', '6', '32', '按键机', '95.00', null, '50', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('69', '863396010512240', '2', '33', '按键机', '85.00', null, '51', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('70', '866860021378963', '2', '34', '按键机', '70.00', null, '52', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('71', '355053044080182', '18', '1', '按键机', '120.00', null, '53', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('72', '862249000112896', '8', '35', '按键机', '95.00', null, '54', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('73', '860171015104985', '8', '36', '按键机', '50.00', null, '55', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('74', '862273010051209', '19', '37', '按键机', '99.00', null, '56', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('75', '862273010016590', '8', '37', '按键机', '99.00', null, '56', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('76', '862273010009579', '17', '37', '按键机', '99.00', null, '56', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('77', '357156063872906', '2', '38', '按键机', '150.00', null, '57', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('78', '355771066111904', '8', '38', '按键机', '180.00', null, '58', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('79', '355521074658119', '1', '1', '智能机', '1485.00', null, '59', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('80', '356725071258091', '4', '1', '智能机', '1885.00', null, '60', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('81', '861270035465717', '4', '5', '智能机', '988.00', null, '61', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('82', '026718', '4', '39', '按键机', '65.00', null, '62', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('83', '869445020073646', '2', '40', '智能机', '300.00', null, '63', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('84', '869735022978002', '4', '14', '智能机', '1399.00', null, '64', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('85', '869271025517373', '4', '3', '智能机', '970.00', null, '65', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('86', '641498', '20', '20', '按键机', '90.00', null, '66', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('87', '866583025088459', '0', '7', '智能机', '275.00', null, '67', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('88', '569028', '4', '27', '按键机', '110.00', null, '68', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('89', '868315028861105', '19', '41', '智能机', '480.00', null, '69', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('90', '869892020811840', '6', '41', '智能机', '480.00', null, '69', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('91', '188743', '0', '1', '智能机', '520.00', null, '70', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('92', '019824', '0', '1', '智能机', '520.00', null, '70', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('93', '860784037114442', '4', '5', '智能机', '1300.00', null, '71', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('94', '861269036318623', '4', '13', '智能机', '1605.00', null, '72', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('95', '601612', '9', '20', '按键机', '130.00', null, '32', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('96', '356156074794173', '0', '1', '智能机', '4720.00', null, '73', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('97', '861467036748928', '4', '13', '智能机', '2098.00', null, '74', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('98', '860440030047614', '4', '13', '智能机', '1025.00', null, '75', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('99', '869952020517050', '1', '42', '智能机', '275.00', null, '76', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('100', '869952020517209', '1', '42', '智能机', '275.00', null, '76', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('101', '862713029383226', '2', '24', '按键机', '65.00', null, '77', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('102', '868563022088809', '1', '14', '智能机', '619.00', null, '78', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('103', '861406038384191', '21', '13', '智能机', '2998.00', null, '79', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('104', '861189032869009', '4', '3', '智能机', '695.00', null, '80', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('105', '860128035213113', '5', '5', '智能机', '912.00', null, '81', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('106', '867374011832671', '8', '43', '按键机', '35.00', null, '82', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('107', '867374010995143', '2', '43', '按键机', '35.00', null, '82', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('108', '860901031156290', '1', '13', '智能机', '799.00', null, '83', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('109', '861752038977496', '4', '13', '智能机', '1265.00', null, '84', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('110', '861730038773792', '4', '12', '智能机', '2699.00', null, '85', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('111', '861728038309971', '4', '12', '智能机', '1299.00', null, '86', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('112', '861516033578066', '1', '12', '智能机', '899.00', null, '87', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('113', '861077033894532', '6', '12', '智能机', '660.00', null, '88', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('114', '861077037931280', '1', '12', '智能机', '660.00', null, '88', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('115', '86188030671008', '1', '14', '智能机', '549.00', null, '89', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('116', '867894025682814', '1', '14', '智能机', '549.00', null, '90', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('117', '355967063806575', '2', '1', '智能机', '1188.00', null, '2', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('118', '353771077535556', '1', '1', '智能机', '825.00', null, '91', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('119', '669049', '2', '5', '智能机', '620.00', null, '9', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('120', '518842', '2', '5', '智能机', '878.00', null, '8', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('121', '824736', '2', '5', '智能机', '878.00', null, '8', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('122', '520954', '2', '5', '智能机', '878.00', null, '8', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('123', '146859', '2', '5', '智能机', '450.00', null, '92', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('124', '408939', '2', '5', '智能机', '350.00', null, '93', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('125', '1680A0', '1', '5', '智能机', '800.00', null, '94', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('126', '329583', '1', '44', '智能机', '1420.00', null, '95', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('127', '217188', '1', '2', '智能机', '810.00', null, '96', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('128', '711762', '1', '2', '智能机', '810.00', null, '96', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('129', '826142', '1', '6', '智能机', '299.00', null, '11', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('130', '865369', '1', '6', '智能机', '299.00', null, '11', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('131', '767809', '1', '6', '智能机', '299.00', null, '11', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('132', '329356', '2', '7', '智能机', '280.00', null, '97', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('133', '302063', '1', '7', '智能机', '530.00', null, '98', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('134', '467533', '1', '7', '智能机', '225.00', null, '13', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('135', '807828', '4', '42', '智能机', '250.00', null, '99', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('136', '806523', '4', '42', '智能机', '250.00', null, '99', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('137', '807885', '4', '42', '智能机', '250.00', null, '99', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('138', '737546', '4', '42', '智能机', '250.00', null, '99', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('139', '798522', '1', '42', '智能机', '250.00', null, '99', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('140', '869897029218798', '21', '13', '智能机', '2499.00', null, '100', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('141', '546537', '4', '13', '智能机', '2499.00', null, '100', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('142', '860576034840262', '21', '13', '智能机', '2155.00', null, '101', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('143', '840221', '21', '13', '智能机', '2155.00', null, '101', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('144', '175981', '4', '13', '智能机', '2155.00', null, '101', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('145', '210891', '2', '13', '智能机', '799.00', null, '83', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('146', '579460', '2', '13', '智能机', '729.00', null, '102', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('147', '032863', '1', '13', '智能机', '729.00', null, '102', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('148', '971986', '4', '12', '智能机', '2499.00', null, '103', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('149', '916311', '1', '12', '智能机', '1999.00', null, '104', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('150', '343588', '4', '14', '智能机', '2099.00', null, '105', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('151', '222394', '4', '14', '智能机', '899.00', null, '106', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('152', '691976', '4', '14', '智能机', '899.00', null, '22', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('153', '507522', '1', '14', '智能机', '1999.00', null, '107', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('154', '485160', '4', '14', '智能机', '799.00', null, '108', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('155', '458884', '4', '14', '智能机', '1299.00', null, '109', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('156', '310107', '17', '14', '智能机', '650.00', null, '110', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('157', '340524', '1', '45', '智能机', '420.00', null, '111', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('158', '272677', '19', '45', '智能机', '420.00', null, '111', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('159', '201584', '4', '45', '智能机', '420.00', null, '111', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('160', '404166', '2', '14', '智能机', '350.00', null, '112', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('161', '672295', '2', '27', '按键机', '160.00', null, '113', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('162', '515755', '6', '27', '按键机', '110.00', null, '114', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('163', '195929', '19', '27', '按键机', '80.00', null, '115', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('164', 'A200093094107C', '0', '27', '按键机', '120.00', null, '116', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('165', '362430', '2', '36', '按键机', '50.00', null, '55', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('166', '212232', '19', '25', '按键机', '135.00', null, '117', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('167', '779053', '16', '29', '按键机', '100.00', null, '47', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('168', '044208', '8', '39', '按键机', '59.00', null, '62', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('169', '860887030966195', '4', '3', '智能机', '970.00', null, '65', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('170', '869735021819587', '4', '14', '智能机', '1399.00', null, '64', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('171', '869735022940655', '4', '14', '智能机', '1399.00', null, '64', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('172', '867798024621535', '4', '14', '智能机', '1999.00', null, '23', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('173', '860708033695237', '5', '5', '智能机', '2006.00', null, '71', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('174', '030876', '2', '39', '按键机', '59.00', null, '62', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('175', '860799037857626', '21', '13', '智能机', '1605.00', null, '72', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('176', '867894025142397', '1', '14', '智能机', '549.00', null, '90', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('177', '862145781665021', '1', '20', '按键机', '120.00', null, '32', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('178', '868403023207464', '5', '5', '智能机', '2890.00', null, '118', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('179', '860440030742180', '4', '13', '智能机', '1025.00', null, '75', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('180', '861270035376562', '4', '5', '智能机', '964.00', null, '61', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('181', '863104010244818', '22', '21', '按键机', '80.00', null, '119', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('182', '860871035100703', '21', '13', '智能机', '1265.00', null, '84', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('183', '861572039600545', '1', '13', '智能机', '899.00', null, '120', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('184', '862713029395220', '2', '24', '按键机', '65.00', null, '77', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('185', '862713029332280', '2', '24', '按键机', '65.00', null, '77', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('186', '862713029396459', '2', '24', '按键机', '65.00', null, '77', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('187', '350816065092458', '1', '1', '智能机', '520.00', null, '121', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('188', '354728074388370', '4', '1', '智能机', '750.00', null, '122', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('189', '861790032416699', '4', '46', '智能机', '1075.00', null, '123', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('190', '861189032862385', '4', '3', '智能机', '695.00', null, '80', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('191', '867374010985848', '2', '43', '按键机', '35.00', null, '82', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('192', '867374011773447', '8', '43', '按键机', '35.00', null, '82', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('193', '869969026802369', '1', '2', '智能机', '638.00', null, '80', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('194', '861602035594218', '21', '12', '智能机', '2699.00', null, '85', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('195', '861728038309112', '4', '12', '智能机', '1299.00', null, '86', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('196', '861729035618133', '1', '12', '智能机', '810.00', null, '19', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('197', '861077034380325', '6', '12', '智能机', '660.00', null, '88', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('198', '861077038713232', '1', '12', '智能机', '660.00', null, '88', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('199', '86188030672055', '1', '14', '智能机', '549.00', null, '89', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('200', '867048023238414', '1', '13', '智能机', '1260.00', null, '124', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('201', '860708033687507', '5', '5', '智能机', '1115.00', null, '125', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('202', '866331027096157', '2', '5', '智能机', '878.00', null, '7', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('203', '861142030415044', '4', '5', '智能机', '620.00', null, '126', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('204', '860162039288250', '1', '3', '智能机', '970.00', null, '65', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('205', '868666022658396', '1', '3', '智能机', '970.00', null, '65', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('206', '862325010074001', '2', '47', '智能机', '450.00', null, '127', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('207', '862325010167680', '1', '47', '智能机', '550.00', null, '95', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('208', '861785010148785', '2', '47', '智能机', '399.00', null, '128', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('209', '868746024278607', '5', '44', '智能机', '1420.00', null, '95', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('210', '869540021620724', '18', '44', '智能机', '710.00', null, '6', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('211', '869265022825474', '1', '6', '智能机', '299.00', null, '11', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('212', '869265026891845', '1', '6', '智能机', '299.00', null, '11', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('213', '867189029596049', '1', '7', '智能机', '280.00', null, '97', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('214', '866583023501602', '2', '7', '智能机', '275.00', null, '14', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('215', '866583026106318', '2', '7', '智能机', '275.00', null, '14', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('216', '867489023151787', '1', '7', '智能机', '300.00', null, '129', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('217', '869288022735667', '4', '14', '智能机', '899.00', null, '106', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('218', '868928021446888', '4', '14', '智能机', '1299.00', null, '130', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('219', '865517020136658', '1', '48', '智能机', '560.00', null, '15', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('220', '864438021249740', '23', '20', '智能机', '299.00', null, '131', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('221', '864570020689169', '1', '20', '智能机', '299.00', null, '132', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('222', '865401020748418', '20', '31', '智能机', '260.00', null, '133', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('223', '867688022465334', '1', '49', '智能机', '330.00', null, '134', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('224', '864760020332130', '2', '50', '智能机', '280.00', null, '135', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('225', '865840026513336', '4', '11', '智能机', '399.00', null, '17', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('226', '867427021807612', '4', '42', '智能机', '250.00', null, '99', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('227', '867632000056905', '2', '42', '智能机', '299.00', null, '136', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('228', '867003020078131', '4', '45', '智能机', '420.00', null, '111', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('229', '863111020334257', '7', '51', '智能机', '450.00', null, '137', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('230', '763397', '8', '23', '按键机', '99.00', null, '36', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('231', '070832', '4', '23', '按键机', '99.00', null, '36', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('232', '270294', '8', '27', '按键机', '95.00', null, '138', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('233', '418246', '2', '27', '按键机', '65.00', null, '41', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('234', '454581', '4', '27', '按键机', '80.00', null, '139', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('235', '894826', '17', '22', '按键机', '100.00', null, '140', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('236', '404291', '2', '22', '按键机', '90.00', null, '141', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('237', '634069', '4', '24', '按键机', '230.00', null, '142', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('238', '007631', '7', '37', '按键机', '99.00', null, '56', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('239', '051548', '20', '37', '按键机', '99.00', null, '56', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('240', '129835', '2', '20', '按键机', '130.00', null, '32', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('241', '635651', '1', '19', '按键机', '99.00', null, '143', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('242', '961213', '4', '33', '按键机', '120.00', null, '144', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('243', '443289', '9', '33', '按键机', '99.00', null, '145', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('244', '7213C4', '1', '52', '按键机', '95.00', null, '146', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('245', 'IEFEA', '4', '52', '按键机', '95.00', null, '146', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('246', '310935', '4', '11', '按键机', '69.00', null, '147', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('247', '300500', '2', '11', '按键机', '69.00', null, '147', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('248', '325671', '9', '11', '按键机', '69.00', null, '147', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('249', '062847', '2', '1', '按键机', '120.00', null, '123', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('250', '112683', '23', '32', '按键机', '90.00', null, '148', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('251', '536681', '2', '53', '按键机', '80.00', null, '149', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('252', '942023', '24', '31', '按键机', '90.00', null, '150', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('253', '330142', '20', '54', '按键机', '80.00', null, '151', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('254', '615693', '2', '55', '按键机', '89.00', null, '152', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('255', '113092', '8', '35', '按键机', '95.00', null, '153', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('256', '868948028534049', '6', '41', '智能机', '300.00', null, '26', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('257', '867709020843924', '0', '18', '智能机', '300.00', null, null, '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('258', '867709020845341', '0', '18', '智能机', '300.00', null, null, '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('259', '860582036470223', '5', '5', '智能机', '2005.00', null, '154', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('260', '048811', '2', '39', '按键机', '59.00', null, '62', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('261', '004426', '8', '39', '按键机', '59.00', null, '62', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('262', '869735022531173', '4', '14', '智能机', '1399.00', null, '64', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('263', '868618029657129', '4', '14', '智能机', '899.00', null, '22', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('264', '860962036248961', '5', '5', '智能机', '946.00', null, '61', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('265', '860576035099249', '21', '13', '智能机', '2155.00', null, '155', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('266', '869892020699286', '6', '41', '智能机', '480.00', null, '69', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('267', '869892020765913', '6', '41', '智能机', '480.00', null, '69', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('268', '869897024694381', '21', '13', '智能机', '2498.00', null, '100', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('269', '861077035058015', '1', '12', '智能机', '660.00', null, '88', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('270', '861247033505251', '4', '13', '智能机', '2098.00', null, '101', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('271', '869055027630064', '1', '3', '智能机', '758.00', null, '80', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('272', '861247033968228', '21', '13', '智能机', '2098.00', null, '74', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('273', '860871035100745', '21', '13', '智能机', '1265.00', null, '84', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('274', '869032024205141', '4', '3', '智能机', '745.00', null, '80', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('275', '861269036515798', '4', '13', '智能机', '1605.00', null, '72', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('276', '861297030684443', '1', '13', '智能机', '799.00', null, '83', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('277', '862713029383259', '2', '24', '按键机', '65.00', null, '77', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('278', '862713029383275', '2', '24', '按键机', '65.00', null, '77', '3', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('279', '862084039015798', '4', '12', '智能机', '1099.00', null, '158', '3', '\0', null, '\0', '1', '2016-06-13 09:38:16');

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pur_no` varchar(255) DEFAULT NULL COMMENT '采购单据编号',
  `pur_time` date DEFAULT NULL,
  `shop_id` int(11) DEFAULT NULL COMMENT '收货单位',
  `supplier_id` int(11) DEFAULT NULL COMMENT '批发商(供应商)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `phone_id` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=768 DEFAULT CHARSET=utf8 COMMENT='采购单';

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES ('1', null, '2016-04-22', '1', null, null, '1', '2850.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('2', null, '2016-04-22', '1', null, null, '2', '1180.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('3', null, '2016-04-22', '1', null, null, '3', '390.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('4', null, '2016-04-22', '1', null, null, '4', '790.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('5', null, '2016-04-22', '1', null, null, '5', '750.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('6', null, '2016-04-22', '1', null, null, '6', '810.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('7', null, '2016-04-22', '1', null, null, '7', '810.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('8', null, '2016-04-22', '1', null, null, '8', '575.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('9', null, '2016-04-22', '1', null, null, '9', '820.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('10', null, '2016-04-22', '1', null, null, '10', '878.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('11', null, '2016-04-22', '1', null, null, '11', '620.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('12', null, '2016-04-22', '1', null, null, '12', '850.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('13', null, '2016-04-22', '1', null, null, '13', '299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('14', null, '2016-04-22', '1', null, null, '14', '299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('15', null, '2016-04-22', '1', null, null, '15', '299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('16', null, '2016-04-22', '1', null, null, '16', '320.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('17', null, '2016-04-22', '1', null, null, '17', '225.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('18', null, '2016-04-22', '1', null, null, '18', '225.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('19', null, '2016-04-22', '1', null, null, '19', '275.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('20', null, '2016-04-22', '1', null, null, '20', '450.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('21', null, '2016-04-22', '1', null, null, '21', '330.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('22', null, '2016-04-22', '1', null, null, '22', '260.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('23', null, '2016-04-22', '1', null, null, '23', '1600.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('24', null, '2016-04-22', '1', null, null, '24', '810.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('25', null, '2016-04-22', '1', null, null, '25', '1630.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('26', null, '2016-04-22', '1', null, null, '26', '549.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('27', null, '2016-04-22', '1', null, null, '27', '899.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('28', null, '2016-04-22', '1', null, null, '28', '1999.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('29', null, '2016-04-22', '1', null, null, '29', '300.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('30', null, '2016-04-22', '1', null, null, '30', '300.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('31', null, '2016-04-22', '1', null, null, '31', '300.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('32', null, '2016-04-22', '1', null, null, '32', '300.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('33', null, '2016-04-22', '1', null, null, '33', '300.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('34', null, '2016-04-22', '1', null, null, '34', '80.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('35', null, '2016-04-22', '1', null, null, '35', '69.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('36', null, '2016-04-22', '1', null, null, '36', '69.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('37', null, '2016-04-22', '1', null, null, '37', '69.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('38', null, '2016-04-22', '1', null, null, '38', '110.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('39', null, '2016-04-22', '1', null, null, '39', '85.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('40', null, '2016-04-22', '1', null, null, '40', '130.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('41', null, '2016-04-22', '1', null, null, '41', '130.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('42', null, '2016-04-22', '1', null, null, '42', '160.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('43', null, '2016-04-22', '1', null, null, '43', '80.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('44', null, '2016-04-22', '1', null, null, '44', '115.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('45', null, '2016-04-22', '1', null, null, '45', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('46', null, '2016-04-22', '1', null, null, '46', '160.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('47', null, '2016-04-22', '1', null, null, '47', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('48', null, '2016-04-22', '1', null, null, '48', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('49', null, '2016-04-22', '1', null, null, '49', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('50', null, '2016-04-22', '1', null, null, '50', '160.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('51', null, '2016-04-22', '1', null, null, '51', '85.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('52', null, '2016-04-22', '1', null, null, '52', '135.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('53', null, '2016-04-22', '1', null, null, '53', '135.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('54', null, '2016-04-22', '1', null, null, '54', '95.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('55', null, '2016-04-22', '1', null, null, '55', '120.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('56', null, '2016-04-22', '1', null, null, '56', '120.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('57', null, '2016-04-22', '1', null, null, '57', '120.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('58', null, '2016-04-22', '1', null, null, '58', '120.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('59', null, '2016-04-22', '1', null, null, '59', '120.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('60', null, '2016-04-22', '1', null, null, '60', '120.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('61', null, '2016-04-22', '1', null, null, '61', '110.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('62', null, '2016-04-22', '1', null, null, '62', '110.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('63', null, '2016-04-22', '1', null, null, '63', '90.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('64', null, '2016-04-22', '1', null, null, '64', '100.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('65', null, '2016-04-22', '1', null, null, '65', '80.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('66', null, '2016-04-22', '1', null, null, '66', '80.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('67', null, '2016-04-22', '1', null, null, '67', '90.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('68', null, '2016-04-22', '1', null, null, '68', '95.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('69', null, '2016-04-22', '1', null, null, '69', '85.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('70', null, '2016-04-22', '1', null, null, '70', '70.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('71', null, '2016-04-22', '1', null, null, '71', '120.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('72', null, '2016-04-22', '1', null, null, '72', '95.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('73', null, '2016-04-22', '1', null, null, '73', '50.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('74', null, '2016-04-22', '1', null, null, '74', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('75', null, '2016-04-22', '1', null, null, '75', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('76', null, '2016-04-22', '1', null, null, '76', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('77', null, '2016-04-22', '1', null, null, '77', '150.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('78', null, '2016-04-22', '1', null, null, '78', '180.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('79', null, '2016-04-23', '1', null, null, '79', '1485.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('80', null, '2016-04-23', '1', null, null, '80', '1885.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('81', null, '2016-04-23', '1', null, null, '81', '988.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('82', null, '2016-04-23', '1', null, null, '82', '65.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('83', null, '2016-04-24', '1', null, null, '83', '300.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('84', null, '2016-04-28', '1', null, null, '84', '1399.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('85', null, '2016-04-29', '1', null, null, '85', '970.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('86', null, '2016-05-01', '1', null, null, '86', '90.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('87', null, '2016-05-01', '1', null, null, '87', '275.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('88', null, '2016-05-03', '1', null, null, '88', '110.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('89', null, '2016-05-09', '1', null, null, '89', '480.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('90', null, '2016-05-09', '1', null, null, '90', '480.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('91', null, '2016-05-11', '1', null, null, '91', '520.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('92', null, '2016-05-11', '1', null, null, '92', '520.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('93', null, '2016-05-13', '1', null, null, '93', '1300.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('94', null, '2016-05-15', '1', null, null, '94', '1605.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('95', null, '2016-05-22', '1', null, null, '95', '130.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('96', null, '2016-05-25', '1', null, null, '96', '4720.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('97', null, '2016-05-26', '1', null, null, '97', '2098.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('98', null, '2016-05-26', '1', null, null, '98', '1025.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('99', null, '2016-05-28', '1', null, null, '99', '275.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('100', null, '2016-05-28', '1', null, null, '100', '275.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('101', null, '2016-05-28', '1', null, null, '101', '65.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('102', null, '2016-05-29', '1', null, null, '102', '619.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('103', null, '2016-05-30', '1', null, null, '103', '2998.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('104', null, '2016-05-30', '1', null, null, '104', '695.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('105', null, '2016-05-30', '1', null, null, '105', '912.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('106', null, '2016-05-30', '1', null, null, '106', '35.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('107', null, '2016-05-30', '1', null, null, '107', '35.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('108', null, '2016-05-30', '1', null, null, '108', '799.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('109', null, '2016-05-30', '1', null, null, '109', '1265.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('110', null, '2016-05-31', '1', null, null, '110', '2699.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('111', null, '2016-05-31', '1', null, null, '111', '1299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('112', null, '2016-05-31', '1', null, null, '112', '899.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('113', null, '2016-05-31', '1', null, null, '113', '660.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('114', null, '2016-05-31', '1', null, null, '114', '660.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('115', null, '2016-05-31', '1', null, null, '115', '549.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('116', null, '2016-05-31', '1', null, null, '116', '549.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('117', null, '2016-04-22', '2', null, null, '117', '1188.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('118', null, '2016-04-22', '2', null, null, '118', '825.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('119', null, '2016-04-22', '2', null, null, '119', '620.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('120', null, '2016-04-22', '2', null, null, '120', '878.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('121', null, '2016-04-22', '2', null, null, '121', '878.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('122', null, '2016-04-22', '2', null, null, '122', '878.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('123', null, '2016-04-22', '2', null, null, '123', '450.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('124', null, '2016-04-22', '2', null, null, '124', '350.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('125', null, '2016-04-22', '2', null, null, '125', '800.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('126', null, '2016-04-22', '2', null, null, '126', '1420.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('127', null, '2016-04-22', '2', null, null, '127', '810.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('128', null, '2016-04-22', '2', null, null, '128', '810.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('129', null, '2016-04-22', '2', null, null, '129', '299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('130', null, '2016-04-22', '2', null, null, '130', '299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('131', null, '2016-04-22', '2', null, null, '131', '299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('132', null, '2016-04-22', '2', null, null, '132', '280.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('133', null, '2016-04-22', '2', null, null, '133', '530.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('134', null, '2016-04-22', '2', null, null, '134', '225.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('135', null, '2016-04-22', '2', null, null, '135', '250.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('136', null, '2016-04-22', '2', null, null, '136', '250.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('137', null, '2016-04-22', '2', null, null, '137', '250.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('138', null, '2016-04-22', '2', null, null, '138', '250.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('139', null, '2016-04-22', '2', null, null, '139', '250.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('140', null, '2016-04-22', '2', null, null, '140', '2499.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('141', null, '2016-04-22', '2', null, null, '141', '2499.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('142', null, '2016-04-22', '2', null, null, '142', '2155.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('143', null, '2016-04-22', '2', null, null, '143', '2155.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('144', null, '2016-04-22', '2', null, null, '144', '2155.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('145', null, '2016-04-22', '2', null, null, '145', '799.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('146', null, '2016-04-22', '2', null, null, '146', '729.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('147', null, '2016-04-22', '2', null, null, '147', '729.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('148', null, '2016-04-22', '2', null, null, '148', '2499.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('149', null, '2016-04-22', '2', null, null, '149', '1999.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('150', null, '2016-04-22', '2', null, null, '150', '2099.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('151', null, '2016-04-22', '2', null, null, '151', '899.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('152', null, '2016-04-22', '2', null, null, '152', '899.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('153', null, '2016-04-22', '2', null, null, '153', '1999.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('154', null, '2016-04-22', '2', null, null, '154', '799.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('155', null, '2016-04-22', '2', null, null, '155', '1299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('156', null, '2016-04-22', '2', null, null, '156', '650.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('157', null, '2016-04-22', '2', null, null, '157', '420.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('158', null, '2016-04-22', '2', null, null, '158', '420.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('159', null, '2016-04-22', '2', null, null, '159', '420.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('160', null, '2016-04-22', '2', null, null, '160', '350.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('161', null, '2016-04-22', '2', null, null, '161', '160.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('162', null, '2016-04-22', '2', null, null, '162', '110.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('163', null, '2016-04-22', '2', null, null, '163', '80.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('164', null, '2016-04-22', '2', null, null, '164', '120.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('165', null, '2016-04-22', '2', null, null, '165', '50.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('166', null, '2016-04-22', '2', null, null, '166', '135.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('167', null, '2016-04-22', '2', null, null, '167', '100.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('168', null, '2016-04-23', '2', null, null, '168', '59.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('169', null, '2016-04-24', '2', null, null, '169', '970.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('170', null, '2016-04-28', '2', null, null, '170', '1399.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('171', null, '2016-04-28', '2', null, null, '171', '1399.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('172', null, '2016-04-28', '2', null, null, '172', '1999.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('173', null, '2016-05-07', '2', null, null, '173', '2006.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('174', null, '2016-05-12', '2', null, null, '174', '59.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('175', null, '2016-05-12', '2', null, null, '175', '1605.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('176', null, '2016-05-15', '2', null, null, '176', '549.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('177', null, '2016-05-18', '2', null, null, '177', '120.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('178', null, '2016-05-18', '2', null, null, '178', '2890.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('179', null, '2016-05-24', '2', null, null, '179', '1025.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('180', null, '2016-05-26', '2', null, null, '180', '964.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('181', null, '2016-05-26', '2', null, null, '181', '80.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('182', null, '2016-05-27', '2', null, null, '182', '1265.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('183', null, '2016-05-27', '2', null, null, '183', '899.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('184', null, '2016-05-28', '2', null, null, '184', '65.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('185', null, '2016-05-28', '2', null, null, '185', '65.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('186', null, '2016-05-28', '2', null, null, '186', '65.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('187', null, '2016-05-30', '2', null, null, '187', '520.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('188', null, '2016-05-30', '2', null, null, '188', '750.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('189', null, '2016-05-30', '2', null, null, '189', '1075.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('190', null, '2016-05-30', '2', null, null, '190', '695.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('191', null, '2016-05-30', '2', null, null, '191', '35.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('192', null, '2016-05-30', '2', null, null, '192', '35.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('193', null, '2016-05-30', '2', null, null, '193', '638.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('194', null, '2016-05-31', '2', null, null, '194', '2699.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('195', null, '2016-05-31', '2', null, null, '195', '1299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('196', null, '2016-05-31', '2', null, null, '196', '810.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('197', null, '2016-05-31', '2', null, null, '197', '660.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('198', null, '2016-05-31', '2', null, null, '198', '660.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('199', null, '2016-05-31', '2', null, null, '199', '549.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('200', null, '2016-04-22', '3', null, null, '200', '1260.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('201', null, '2016-04-22', '3', null, null, '201', '1115.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('202', null, '2016-04-22', '3', null, null, '202', '878.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('203', null, '2016-04-22', '3', null, null, '203', '620.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('204', null, '2016-04-22', '3', null, null, '204', '970.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('205', null, '2016-04-22', '3', null, null, '205', '970.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('206', null, '2016-04-22', '3', null, null, '206', '450.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('207', null, '2016-04-22', '3', null, null, '207', '550.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('208', null, '2016-04-22', '3', null, null, '208', '399.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('209', null, '2016-04-22', '3', null, null, '209', '1420.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('210', null, '2016-04-22', '3', null, null, '210', '710.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('211', null, '2016-04-22', '3', null, null, '211', '299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('212', null, '2016-04-22', '3', null, null, '212', '299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('213', null, '2016-04-22', '3', null, null, '213', '280.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('214', null, '2016-04-22', '3', null, null, '214', '275.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('215', null, '2016-04-22', '3', null, null, '215', '275.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('216', null, '2016-04-22', '3', null, null, '216', '300.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('217', null, '2016-04-22', '3', null, null, '217', '899.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('218', null, '2016-04-22', '3', null, null, '218', '1299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('219', null, '2016-04-22', '3', null, null, '219', '560.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('220', null, '2016-04-22', '3', null, null, '220', '299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('221', null, '2016-04-22', '3', null, null, '221', '299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('222', null, '2016-04-22', '3', null, null, '222', '260.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('223', null, '2016-04-22', '3', null, null, '223', '330.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('224', null, '2016-04-22', '3', null, null, '224', '280.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('225', null, '2016-04-22', '3', null, null, '225', '399.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('226', null, '2016-04-22', '3', null, null, '226', '250.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('227', null, '2016-04-22', '3', null, null, '227', '299.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('228', null, '2016-04-22', '3', null, null, '228', '420.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('229', null, '2016-04-22', '3', null, null, '229', '450.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('230', null, '2016-04-22', '3', null, null, '230', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('231', null, '2016-04-22', '3', null, null, '231', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('232', null, '2016-04-22', '3', null, null, '232', '95.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('233', null, '2016-04-22', '3', null, null, '233', '65.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('234', null, '2016-04-22', '3', null, null, '234', '80.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('235', null, '2016-04-22', '3', null, null, '235', '100.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('236', null, '2016-04-22', '3', null, null, '236', '90.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('237', null, '2016-04-22', '3', null, null, '237', '230.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('238', null, '2016-04-22', '3', null, null, '238', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('239', null, '2016-04-22', '3', null, null, '239', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('240', null, '2016-04-22', '3', null, null, '240', '130.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('241', null, '2016-04-22', '3', null, null, '241', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('242', null, '2016-04-22', '3', null, null, '242', '120.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('243', null, '2016-04-22', '3', null, null, '243', '99.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('244', null, '2016-04-22', '3', null, null, '244', '95.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('245', null, '2016-04-22', '3', null, null, '245', '95.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('246', null, '2016-04-22', '3', null, null, '246', '69.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('247', null, '2016-04-22', '3', null, null, '247', '69.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('248', null, '2016-04-22', '3', null, null, '248', '69.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('249', null, '2016-04-22', '3', null, null, '249', '120.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('250', null, '2016-04-22', '3', null, null, '250', '90.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('251', null, '2016-04-22', '3', null, null, '251', '80.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('252', null, '2016-04-22', '3', null, null, '252', '90.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('253', null, '2016-04-22', '3', null, null, '253', '80.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('254', null, '2016-04-22', '3', null, null, '254', '89.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('255', null, '2016-04-22', '3', null, null, '255', '95.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('256', null, '2016-04-22', '3', null, null, '256', '300.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('257', null, '2016-04-22', '3', null, null, '257', '300.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('258', null, '2016-04-22', '3', null, null, '258', '300.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('259', null, '2016-04-23', '3', null, null, '259', '2005.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('260', null, '2016-04-23', '3', null, null, '260', '59.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('261', null, '2016-04-23', '3', null, null, '261', '59.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('262', null, '2016-04-28', '3', null, null, '262', '1399.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('263', null, '2016-04-28', '3', null, null, '263', '899.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('264', null, '2016-04-30', '3', null, null, '264', '946.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('265', null, '2016-05-03', '3', null, null, '265', '2155.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('266', null, '2016-05-09', '3', null, null, '266', '480.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('267', null, '2016-05-09', '3', null, null, '267', '480.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('268', null, '2016-05-13', '3', null, null, '268', '2498.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('269', null, '2016-05-15', '3', null, null, '269', '660.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('270', null, '2016-05-15', '3', null, null, '270', '2098.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('271', null, '2016-05-16', '3', null, null, '271', '758.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('272', null, '2016-05-22', '3', null, null, '272', '2098.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('273', null, '2016-05-22', '3', null, null, '273', '1265.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('274', null, '2016-05-23', '3', null, null, '274', '745.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('275', null, '2016-05-25', '3', null, null, '275', '1605.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('276', null, '2016-05-26', '3', null, null, '276', '799.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('277', null, '2016-05-28', '3', null, null, '277', '65.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('278', null, '2016-05-28', '3', null, null, '278', '65.00', '2016-06-07 22:43:14');
INSERT INTO `purchase` VALUES ('279', '123', '2016-06-12', '3', '1', null, '279', '1099.00', '2016-06-13 09:38:18');

-- ----------------------------
-- Table structure for saler
-- ----------------------------
DROP TABLE IF EXISTS `saler`;
CREATE TABLE `saler` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saler_name` varchar(10) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `saler_name` (`saler_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='销售员表';

-- ----------------------------
-- Records of saler
-- ----------------------------
INSERT INTO `saler` VALUES ('1', '欧阳', '2016-06-13 12:03:56');
INSERT INTO `saler` VALUES ('2', '丽蕾', '2016-06-13 12:04:13');
INSERT INTO `saler` VALUES ('3', '苏梦兰', '2016-06-13 12:04:31');
INSERT INTO `saler` VALUES ('4', '陈月珍', '2016-06-13 12:05:18');
INSERT INTO `saler` VALUES ('5', '杨丽珊', '2016-06-13 12:05:40');
INSERT INTO `saler` VALUES ('6', '郑巧惠', '2016-06-13 12:05:58');
INSERT INTO `saler` VALUES ('7', '陈仙凤', '2016-06-13 12:07:25');
INSERT INTO `saler` VALUES ('8', '范丽菊', '2016-06-13 12:07:48');
INSERT INTO `saler` VALUES ('9', '严玉兰', '2016-06-13 12:08:22');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(20) DEFAULT NULL,
  `shop_address` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `shop_name` (`shop_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='店铺表';

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '一店', '一店地址', '2016-06-07 19:51:29');
INSERT INTO `shop` VALUES ('2', '二店', '二店地址', '2016-06-07 19:51:48');
INSERT INTO `shop` VALUES ('3', '三店', '三店地址', '2016-06-07 19:51:59');
INSERT INTO `shop` VALUES ('4', '总仓库', '总部', '2016-06-13 12:02:55');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(10) DEFAULT NULL,
  `supplier_address` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `supplier_name` (`supplier_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='供应商表';

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', 'OPPO', 'OPPO地址', '2016-06-13 09:29:28');
INSERT INTO `supplier` VALUES ('2', '金立', '123', '2016-06-13 10:37:57');
INSERT INTO `supplier` VALUES ('3', 'Vivo', 'Vivo', '2016-06-13 10:37:58');
