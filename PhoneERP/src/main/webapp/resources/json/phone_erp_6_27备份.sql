/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : phone_erp

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-06-27 22:14:07
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='调拨单';

-- ----------------------------
-- Records of allot
-- ----------------------------
INSERT INTO `allot` VALUES ('1', '2', '1', '2016-06-06', '48', '2016-06-14 09:25:43');
INSERT INTO `allot` VALUES ('2', '2', '4', '2016-06-13', '1033', '2016-06-14 10:13:33');
INSERT INTO `allot` VALUES ('3', '2', '4', '2016-06-13', '1045', '2016-06-14 10:14:37');
INSERT INTO `allot` VALUES ('4', '2', '4', '2016-06-13', '1044', '2016-06-14 10:14:52');
INSERT INTO `allot` VALUES ('5', '2', '4', '2016-06-13', '1046', '2016-06-14 10:15:36');
INSERT INTO `allot` VALUES ('6', '2', '4', '2016-06-13', '1047', '2016-06-14 10:16:01');
INSERT INTO `allot` VALUES ('7', '2', '4', '2016-06-13', '1050', '2016-06-14 10:16:22');
INSERT INTO `allot` VALUES ('8', '2', '4', '2016-06-13', '1052', '2016-06-14 10:16:40');
INSERT INTO `allot` VALUES ('9', '1', '4', '2016-06-13', '1042', '2016-06-14 10:19:40');
INSERT INTO `allot` VALUES ('10', '1', '4', '2016-06-13', '1049', '2016-06-14 10:20:35');
INSERT INTO `allot` VALUES ('11', '1', '4', '2016-06-13', '1051', '2016-06-14 10:20:52');
INSERT INTO `allot` VALUES ('12', '3', '4', '2016-06-13', '1034', '2016-06-14 10:21:24');
INSERT INTO `allot` VALUES ('13', '3', '4', '2016-06-13', '1035', '2016-06-14 10:21:40');
INSERT INTO `allot` VALUES ('14', '3', '4', '2016-06-13', '1041', '2016-06-14 10:22:01');
INSERT INTO `allot` VALUES ('15', '3', '4', '2016-06-13', '1048', '2016-06-14 10:22:32');
INSERT INTO `allot` VALUES ('16', '3', '4', '2016-06-13', '1053', '2016-06-14 10:23:21');
INSERT INTO `allot` VALUES ('17', '2', '4', '2016-06-13', '1043', '2016-06-14 10:28:59');
INSERT INTO `allot` VALUES ('18', '2', '3', '2016-06-07', '1170', '2016-06-15 14:41:24');
INSERT INTO `allot` VALUES ('19', '2', '1', '2016-06-09', '1070', '2016-06-15 15:11:01');
INSERT INTO `allot` VALUES ('20', '2', '3', '2016-06-08', '1165', '2016-06-16 10:26:47');
INSERT INTO `allot` VALUES ('21', '2', '1', '2016-06-09', '1114', '2016-06-16 10:29:51');
INSERT INTO `allot` VALUES ('22', '2', '1', '2016-06-09', '1074', '2016-06-16 10:34:58');
INSERT INTO `allot` VALUES ('23', '3', '1', '2016-06-08', '1106', '2016-06-24 11:55:57');

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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone_id` (`phone_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='销售单主表';

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '167', '9', '2', '2016-06-05', '203', '280.00', '0', '123', '13959070116', '2016-06-14 09:22:56');
INSERT INTO `orders` VALUES ('2', '48', '9', '2', '2016-06-06', '205', '160.00', '0', '123', '123', '2016-06-14 09:27:28');
INSERT INTO `orders` VALUES ('3', '182', '9', '2', '2016-06-07', '207', '1300.00', '0', '123', '13559990837', '2016-06-14 09:38:22');
INSERT INTO `orders` VALUES ('4', '114', '2', '1', '2016-06-01', '1623', '799.00', '0', '123', '15059932684', '2016-06-14 10:31:27');
INSERT INTO `orders` VALUES ('5', '109', '1', '1', '2016-06-02', '1634', '1598.00', '0', '123', '15080236187', '2016-06-14 10:33:03');
INSERT INTO `orders` VALUES ('6', '1067', '1', '1', '2016-06-02', '1638', '2280.00', '0', '123', '13906073669', '2016-06-14 10:34:45');
INSERT INTO `orders` VALUES ('7', '27', '3', '1', '2016-06-05', '1366', '999.00', '0', '123', '18850815585', '2016-06-15 11:44:52');
INSERT INTO `orders` VALUES ('8', '1064', '1', '1', '2016-06-05', '1362', '1399.00', '0', '123', '15059933857', '2016-06-15 11:49:17');
INSERT INTO `orders` VALUES ('9', '1170', '7', '2', '2016-06-07', '209', '1280.00', '0', '123', '15080267176', '2016-06-15 14:42:40');
INSERT INTO `orders` VALUES ('10', '142', '8', '2', '2016-06-08', '210', '2298.00', '0', '123', '157590', '2016-06-15 14:44:26');
INSERT INTO `orders` VALUES ('11', '1142', '7', '2', '2016-06-08', '213', '2598.00', '0', '123', '0', '2016-06-15 15:01:55');
INSERT INTO `orders` VALUES ('12', '169', '8', '2', '2016-06-08', '215', '1100.00', '0', '0', '13887112841', '2016-06-15 15:03:42');
INSERT INTO `orders` VALUES ('13', '1141', '9', '2', '2016-06-09', '217', '2798.00', '0', '0', '0', '2016-06-15 15:09:29');
INSERT INTO `orders` VALUES ('14', '1070', '8', '2', '2016-06-09', '218', '2799.00', '0', '0', '0', '2016-06-15 15:13:21');
INSERT INTO `orders` VALUES ('15', '1136', '8', '2', '2016-06-09', '219', '1398.00', '0', '0', '0', '2016-06-15 15:14:38');
INSERT INTO `orders` VALUES ('16', '132', '8', '2', '2016-06-05', '10202', '550.00', '0', '0', '0', '2016-06-16 10:16:30');
INSERT INTO `orders` VALUES ('17', '1295', '7', '2', '2016-06-07', '10208', '1199.00', '0', '0', '0', '2016-06-16 10:22:17');
INSERT INTO `orders` VALUES ('18', '1165', '9', '2', '2016-06-08', '10212', '1398.00', '0', '0', '0', '2016-06-16 10:27:32');
INSERT INTO `orders` VALUES ('19', '1114', '9', '2', '2016-06-09', '10221', '2100.00', '0', '0', '0', '2016-06-16 10:30:51');
INSERT INTO `orders` VALUES ('21', '1074', '9', '2', '2016-06-09', '10222', '2598.00', '0', '0', '0', '2016-06-16 10:35:56');
INSERT INTO `orders` VALUES ('22', '210', '4', '3', '2016-06-07', '404', '900.00', '0', '123', '123', '2016-06-24 11:53:02');
INSERT INTO `orders` VALUES ('23', '1106', '5', '3', '2016-06-08', '415', '950.00', '0', '00', '13950845834', '2016-06-24 11:56:53');
INSERT INTO `orders` VALUES ('24', '265', '4', '3', '2016-06-01', '365', '2298.00', '0', '123', '13799083725', '2016-06-24 11:59:40');
INSERT INTO `orders` VALUES ('25', '222', '4', '3', '2016-06-01', '366', '350.00', '0', '0', '138', '2016-06-24 12:00:45');

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
) ENGINE=InnoDB AUTO_INCREMENT=1296 DEFAULT CHARSET=utf8 COMMENT='手机产品表';

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
INSERT INTO `phone` VALUES ('27', '868618022691984', '4', '14', '智能机', '899.00', '999.00', '22', '1', '', null, '\0', '0', '2016-06-07 22:38:23');
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
INSERT INTO `phone` VALUES ('48', '864943022756691', '12', '23', '按键机', '99.00', '160.00', '36', '2', '', null, '\0', '0', '2016-06-07 22:38:23');
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
INSERT INTO `phone` VALUES ('109', '861752038977496', '4', '13', '智能机', '1265.00', '1598.00', '84', '1', '', null, '\0', '0', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('110', '861730038773792', '4', '12', '智能机', '2699.00', null, '85', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('111', '861728038309971', '4', '12', '智能机', '1299.00', null, '86', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('112', '861516033578066', '1', '12', '智能机', '899.00', null, '87', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('113', '861077033894532', '6', '12', '智能机', '660.00', null, '88', '1', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('114', '861077037931280', '1', '12', '智能机', '660.00', '799.00', '88', '1', '', null, '\0', '0', '2016-06-07 22:38:23');
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
INSERT INTO `phone` VALUES ('132', '329356', '2', '7', '智能机', '280.00', '550.00', '97', '2', '', null, '\0', '0', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('133', '302063', '1', '7', '智能机', '530.00', null, '98', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('134', '467533', '1', '7', '智能机', '225.00', null, '13', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('135', '807828', '4', '42', '智能机', '250.00', null, '99', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('136', '806523', '4', '42', '智能机', '250.00', null, '99', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('137', '807885', '4', '42', '智能机', '250.00', null, '99', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('138', '737546', '4', '42', '智能机', '250.00', null, '99', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('139', '798522', '1', '42', '智能机', '250.00', null, '99', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('140', '869897029218798', '21', '13', '智能机', '2499.00', null, '100', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('141', '546537', '4', '13', '智能机', '2499.00', null, '100', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('142', '860576034840262', '21', '13', '智能机', '2155.00', '2298.00', '101', '2', '', null, '\0', '0', '2016-06-07 22:38:23');
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
INSERT INTO `phone` VALUES ('167', '779053', '16', '29', '按键机', '100.00', '280.00', '47', '2', '', null, '\0', '0', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('168', '044208', '8', '39', '按键机', '59.00', null, '62', '2', '\0', null, '\0', '1', '2016-06-07 22:38:23');
INSERT INTO `phone` VALUES ('169', '860887030966195', '4', '3', '智能机', '970.00', '1100.00', '65', '2', '', null, '\0', '0', '2016-06-07 22:38:23');
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
INSERT INTO `phone` VALUES ('182', '860871035100703', '21', '13', '智能机', '1265.00', '1300.00', '84', '2', '', null, '\0', '0', '2016-06-07 22:38:23');
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
INSERT INTO `phone` VALUES ('210', '869540021620724', '18', '44', '智能机', '710.00', '900.00', '6', '3', '', null, '\0', '0', '2016-06-07 22:38:23');
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
INSERT INTO `phone` VALUES ('222', '865401020748418', '20', '31', '智能机', '260.00', '350.00', '133', '3', '', null, '\0', '0', '2016-06-07 22:38:23');
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
INSERT INTO `phone` VALUES ('265', '860576035099249', '21', '13', '智能机', '2155.00', '2298.00', '155', '3', '', null, '\0', '0', '2016-06-07 22:38:23');
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
INSERT INTO `phone` VALUES ('1023', '869265026897909', '1', '6', '智能机', '299.00', null, '11', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1024', '869265026888635', '1', '6', '智能机', '299.00', null, '11', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1025', '866583025130061', '3', '7', '智能机', '275.00', null, '14', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1026', '004392', '8', '39', '按键机', '59.00', null, '62', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1027', '044109', '8', '39', '按键机', '59.00', null, '62', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1028', '865300029984935', '3', '7', '智能机', '275.00', null, '14', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1029', '866583020138721', '3', '7', '智能机', '275.00', null, '14', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1030', '866583025238807', '3', '7', '智能机', '275.00', null, '14', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1031', '861064031310057', '4', '3', '智能机', '941.00', null, '65', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1032', '861189032855917', '4', '3', '智能机', '695.00', null, '80', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1033', '861084032180319', '4', '3', '智能机', '870.00', null, '65', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1034', '861735037789756', '4', '3', '智能机', '1040.00', null, '65', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1035', '861946031349006', '4', '4', '智能机', '862.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1036', '861888030991232', '1', '14', '智能机', '549.00', null, '89', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1037', '861888030990630', '1', '14', '智能机', '549.00', null, '89', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1038', '861888030990382', '1', '14', '智能机', '549.00', null, '89', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1039', '861888030991117', '1', '14', '智能机', '549.00', null, '89', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1040', '861888030990911', '1', '14', '智能机', '549.00', null, '89', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1041', '861888030991158', '1', '14', '智能机', '549.00', null, '89', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1042', '861888030990622', '1', '14', '智能机', '549.00', null, '89', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1043', '861888030991042', '1', '14', '智能机', '549.00', null, '89', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1044', '861888030990655', '1', '14', '智能机', '549.00', null, '89', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1045', '861888030990960', '1', '14', '智能机', '549.00', null, '89', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1046', '861257030680049', '4', '14', '智能机', '799.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1047', '861257030427425', '1', '14', '智能机', '799.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1048', '861257030680320', '4', '14', '智能机', '799.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1049', '861257030427516', '1', '14', '智能机', '799.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1050', '861760031721944', '4', '14', '智能机', '899.00', null, '22', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1051', '861760031721951', '4', '14', '智能机', '899.00', null, '22', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1052', '861760031722025', '4', '14', '智能机', '899.00', null, '22', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1053', '861760031719484', '4', '14', '智能机', '899.00', null, '22', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1054', '861760031719518', '4', '14', '智能机', '899.00', null, '22', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1055', '861492032220664', '1', '13', '智能机', '799.00', null, '83', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1056', '861752030917565', '4', '13', '智能机', '1125.00', null, '84', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1057', '861752030917524', '4', '13', '智能机', '1125.00', null, '84', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1058', '861247039060194', '21', '13', '智能机', '1905.00', null, '74', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1059', '860576030244394', '4', '13', '智能机', '1905.00', null, '74', '4', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1060', '007197', '8', '39', '按键机', '59.00', null, '62', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1061', '356722071162977', '4', '1', '智能机', '1485.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1062', '862713029395246', '3', '24', '按键机', '65.00', null, '77', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1063', '861873035516556', '21', '12', '智能机', '1099.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1064', '860789031851582', '4', '12', '智能机', '1099.00', '1399.00', null, '1', '', null, '\0', '0', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1065', '860789031851410', '4', '12', '智能机', '1099.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1066', '861516030174448', '1', '12', '智能机', '810.00', null, '19', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1067', '861626030524482', '4', '5', '智能机', '1888.00', '2280.00', '154', '1', '', null, '\0', '0', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1068', '861790032425377', null, '46', '智能机', '1073.00', null, '123', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1069', '861916034100656', '21', '12', '智能机', '2349.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1070', '861916039633735', '4', '12', '智能机', '2349.00', '2799.00', null, '2', '', null, '\0', '0', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1071', '355751070972574', '4', null, '智能机', '6130.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1072', '861405036133204', '21', '13', '智能机', '2298.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1073', '861405035996932', '21', '13', '智能机', '2298.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1074', '861405035300499', '4', '13', '智能机', '2298.00', '2598.00', null, '2', '', null, '\0', '0', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1075', '861297039765292', '1', '13', '智能机', '799.00', null, '83', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1076', '861297039765474', '1', '13', '智能机', '799.00', null, '83', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1077', '860871033386742', '4', '13', '智能机', '1265.00', null, '84', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1078', '861752030057917', '21', '13', '智能机', '1265.00', null, '84', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1079', '860440030311010', '4', '13', '智能机', '1025.00', null, '75', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1080', '861407039993618', '4', '13', '智能机', '1025.00', null, '75', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1081', '860440030356791', '4', '13', '智能机', '1025.00', null, '75', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1082', '861406034948817', '21', '13', '智能机', '2998.00', null, '79', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1083', '861617037285375', '21', '13', '智能机', '1905.00', null, '74', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1084', '861617033050245', '4', '13', '智能机', '1905.00', null, '74', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1085', '861247039060731', '4', '13', '智能机', '1905.00', null, '74', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1086', '861916034018791', '21', '12', '智能机', '2349.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1087', '861916034020995', '21', '12', '智能机', '2349.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1088', '8605982038588691', '5', '5', '智能机', '1895.00', null, '154', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1089', '356725071680211', '4', '1', '智能机', '1875.00', null, '60', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1090', '351702077716823', '4', '1', '智能机', '1135.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1091', '353771076506293', '4', '1', '智能机', '868.00', null, '91', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1092', '860708037696132', '5', '5', '智能机', '984.00', null, '71', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1093', '35833064421944', null, null, '智能机', '4820.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1094', '355708072106007', '21', null, '智能机', '5360.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1095', '861270033997187', '5', '5', '智能机', '870.00', null, '61', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1096', 'F9FQWRDSFCM8', '5', null, '智能机', '1670.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1097', '861257030374775', '4', '14', '智能机', '799.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1098', '861888031870740', '1', '14', '智能机', '549.00', null, '89', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1099', '861888031870807', '1', '14', '智能机', '549.00', null, '89', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1100', '861888031870708', '1', '14', '智能机', '549.00', null, '89', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1101', '861519034414521', '4', '14', '智能机', '899.00', null, '22', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1102', '356725071717385', '4', '1', '智能机', '1875.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1103', '359583075608176', '4', '1', '智能机', '4820.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1104', '351702079739021', '4', '1', '智能机', '1110.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1105', '861575030707268', '5', '5', '智能机', '870.00', null, '61', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1106', '868192022305052', '1', '3', '智能机', '840.00', '950.00', '6', '3', '', null, '\0', '0', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1107', '358623069785043', '3', '38', '按键机', '123.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1108', '861492036849443', '1', '13', '智能机', '799.00', null, '83', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1109', '861752030917540', '4', '13', '智能机', '1125.00', null, '84', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1110', '861752030170017', '21', '13', '智能机', '1125.00', null, '84', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1111', '861752030169977', '21', '13', '智能机', '1125.00', null, '84', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1112', '861752030156438', '21', '13', '智能机', '1125.00', null, '84', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1113', '861247039934521', '21', '13', '智能机', '1905.00', null, '74', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1114', '861467031234692', '4', '13', '智能机', '1905.00', '2100.00', '74', '2', '', null, '\0', '0', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1115', '861916032345816', '4', '12', '智能机', '2349.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1116', '861730031364177', '21', '12', '智能机', '2699.00', null, '85', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1117', '862084039014478', '4', '12', '智能机', '1099.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1118', '860779037265673', '1', '12', '智能机', '660.00', null, '88', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1119', '356725071711941', '4', '1', '智能机', '1875.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1120', '861945031745205', '1', '4', '智能机', '1955.00', null, null, '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1121', '861626031466964', '4', '5', '智能机', '1910.00', null, '154', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1122', '86164703665044', '4', '2', '智能机', '770.00', null, '80', '1', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1123', '866583025357433', '3', '7', '智能机', '275.00', null, '14', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1124', '053084', '3', '39', '按键机', '59.00', null, '62', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1125', '007114', '8', '39', '按键机', '59.00', null, '62', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1126', '867577029631982', '3', '7', '智能机', '275.00', null, '13', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1127', '866475023286039', '3', '7', '智能机', '275.00', null, '13', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1128', '861269036576808', '4', '13', '智能机', '1605.00', null, '72', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1129', '862713029395212', '3', '24', '按键机', '65.00', null, '77', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1130', '862713029383283', '3', '24', '按键机', '65.00', null, '77', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1131', '860462030383559', '21', null, '智能机', '480.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1132', '860462030390414', '4', null, '智能机', '480.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1133', '860901031155912', '1', '13', '智能机', '799.00', null, '83', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1134', '860901030070385', '1', '13', '智能机', '799.00', null, '83', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1135', '861752039009950', '4', '13', '智能机', '1265.00', null, '84', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1136', '861752034652457', '4', '13', '智能机', '1265.00', '1398.00', '84', '2', '', null, '\0', '0', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1137', '861873035518115', '21', '12', '智能机', '1099.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1138', '860789031741314', '4', '12', '智能机', '1099.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1139', '861516030888799', '1', '12', '智能机', '810.00', null, '19', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1140', '861916034100797', '21', '12', '智能机', '2349.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1141', '861916039635714', '4', '12', '智能机', '2349.00', '2798.00', null, '2', '', null, '\0', '0', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1142', '861405035231157', '4', '13', '智能机', '2298.00', '2598.00', null, '2', '', null, '\0', '0', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1143', '507380', null, '27', '按键机', '95.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1144', '959644', null, '27', '按键机', '65.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1145', '048319', null, '27', '按键机', '65.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1146', '35183', null, '27', '按键机', '65.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1147', '11523', null, '27', '按键机', '65.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1148', '10517', null, '27', '按键机', '65.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1149', '95887', null, '27', '按键机', '65.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1150', '861257030269561', '4', '14', '智能机', '799.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1151', '861888031870716', '1', '14', '智能机', '549.00', null, '89', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1152', '861519034414547', '4', '14', '智能机', '899.00', null, '22', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1153', '861946030537445', '4', '3', '智能机', '870.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1154', '861492032220623', '1', '13', '智能机', '799.00', null, '83', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1155', '861916032301470', '4', '12', '智能机', '2349.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1156', '862017038277597', '4', '12', '智能机', '2349.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1157', '861744035913376', '21', '12', '智能机', '2349.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1158', '861744035914614', '21', '12', '智能机', '2349.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1159', '862084039516118', '21', '12', '智能机', '1099.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1160', '862084039519575', '21', '12', '智能机', '1099.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1161', '862084039013371', '4', '12', '智能机', '1099.00', null, null, '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1162', '860779037264122', '1', '12', '智能机', '660.00', null, '88', '2', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1163', '868089023803889', '1', '5', '智能机', '878.00', null, '7', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1164', '861142031894353', '1', '5', '智能机', '606.00', null, '9', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1165', '860871035456089', '21', '13', '智能机', '1265.00', '1398.00', '84', '2', '', null, '\0', '0', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1166', '861516032735436', '1', '12', '智能机', '810.00', null, '19', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1167', '861916039634394', '4', '12', '智能机', '2349.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1168', '861297039748934', '1', '13', '智能机', '799.00', null, '83', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1169', '860901030363988', '1', '13', '智能机', '799.00', null, '83', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1170', '861752039007772', '4', '13', '智能机', '1265.00', '1280.00', '84', '2', '', null, '\0', '0', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1171', '860871033518914', '4', '13', '智能机', '1265.00', null, '84', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1172', '861752032968764', '21', '13', '智能机', '1265.00', null, '84', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1173', '860440030358532', '4', '13', '智能机', '1025.00', null, '75', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1174', '860440030311093', '4', '13', '智能机', '1025.00', null, '75', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1175', '861617038053541', '21', '13', '智能机', '1905.00', null, '74', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1176', '861916034094750', '21', '12', '智能机', '2349.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1177', '238010', null, '27', '按键机', '96.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1178', '500906', null, '27', '按键机', '97.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1179', '957267', null, '27', '按键机', '65.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1180', '4772', null, '27', '按键机', '65.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1181', '26687', null, '27', '按键机', '65.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1182', '001466', null, '27', '按键机', '65.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1183', '4148', null, '27', '按键机', '65.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1184', '54066', null, '27', '按键机', '65.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1185', '861647032680361', '4', '2', '智能机', '635.00', null, '80', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1186', '861189033702084', '1', '3', '智能机', '688.00', null, '80', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1187', '79946', null, '34', '按键机', '60.00', null, '52', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1188', '94671', null, '34', '按键机', '60.00', null, '52', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1189', '93988', null, '34', '按键机', '60.00', null, '52', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1190', '16304', null, '34', '按键机', '60.00', null, '52', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1191', '16627', null, '34', '按键机', '60.00', null, '52', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1192', '986437', null, null, '智能机', '600.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1193', '75919', null, null, '智能机', '600.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1194', '355714072688341', '19', null, '智能机', '5380.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1195', '353347070112097', '5', null, '智能机', '5330.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1196', '861257030269553', '4', '14', '智能机', '799.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1197', '861888031870732', '1', '14', '智能机', '549.00', null, '89', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1198', '861519034414554', '4', '14', '智能机', '899.00', null, '22', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1199', '355107070184415', '3', '38', '按键机', '123.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1200', '356897071784226', '3', '38', '按键机', '123.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1201', '861492032220524', '1', '13', '智能机', '799.00', null, '83', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1202', '861492031944686', '1', '13', '智能机', '799.00', null, '83', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1203', '861247039089656', '21', '13', '智能机', '1905.00', null, '74', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1204', '860576030243933', '4', '13', '智能机', '1905.00', null, '74', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1205', '861744035915157', '21', '12', '智能机', '2349.00', null, null, '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1206', '860779037262282', '1', '12', '智能机', '660.00', null, '88', '3', '\0', null, '\0', '1', '2016-06-13 22:54:53');
INSERT INTO `phone` VALUES ('1278', '861617033484956', '4', '13', '智能机', '1905.00', null, '101', '4', '\0', null, '\0', '1', '2016-06-14 10:08:16');
INSERT INTO `phone` VALUES ('1279', '861405039686638', '21', '13', '智能机', '1905.00', null, '101', '4', '\0', null, '\0', '1', '2016-06-14 10:10:09');
INSERT INTO `phone` VALUES ('1280', '861749033164161', '21', '13', '智能机', '1905.00', null, '101', '4', '\0', null, '\0', '1', '2016-06-14 10:11:31');
INSERT INTO `phone` VALUES ('1281', '861749038557104', '4', '13', '智能机', '1905.00', null, '74', '3', '\0', null, '\0', '1', '2016-06-14 10:57:35');
INSERT INTO `phone` VALUES ('1282', '861405037039673', '4', '13', '智能机', '2298.00', null, '100', '3', '\0', null, '\0', '1', '2016-06-14 11:00:04');
INSERT INTO `phone` VALUES ('1294', '861749033164328', '4', '13', '智能机', '1905.00', null, '74', '1', '\0', null, '\0', '1', '2016-06-14 11:04:02');
INSERT INTO `phone` VALUES ('1295', '868618029683539', '4', '14', '智能机', '899.00', '1199.00', '22', '2', '', null, '\0', '0', '2016-06-16 10:21:02');

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
) ENGINE=InnoDB AUTO_INCREMENT=1030 DEFAULT CHARSET=utf8 COMMENT='采购单';

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
INSERT INTO `purchase` VALUES ('768', null, '2016-04-22', '4', null, null, '1023', '299.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('769', null, '2016-04-22', '4', null, null, '1024', '299.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('770', null, '2016-04-22', '4', null, null, '1025', '275.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('771', null, '2016-04-23', '4', null, null, '1026', '59.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('772', null, '2016-04-23', '4', null, null, '1027', '59.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('773', null, '2016-04-29', '4', null, null, '1028', '275.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('774', null, '2016-04-29', '4', null, null, '1029', '275.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('775', null, '2016-04-29', '4', null, null, '1030', '275.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('776', null, '2016-04-30', '4', null, null, '1031', '941.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('777', null, '2016-05-30', '4', null, null, '1032', '695.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('778', null, '2016-05-30', '4', null, null, '1033', '870.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('779', null, '2016-06-08', '4', null, null, '1034', '1040.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('780', null, '2016-06-12', '4', null, null, '1035', '862.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('781', null, '2016-06-13', '4', null, null, '1036', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('782', null, '2016-06-13', '4', null, null, '1037', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('783', null, '2016-06-13', '4', null, null, '1038', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('784', null, '2016-06-13', '4', null, null, '1039', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('785', null, '2016-06-13', '4', null, null, '1040', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('786', null, '2016-06-13', '4', null, null, '1041', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('787', null, '2016-06-13', '4', null, null, '1042', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('788', null, '2016-06-13', '4', null, null, '1043', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('789', null, '2016-06-13', '4', null, null, '1044', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('790', null, '2016-06-13', '4', null, null, '1045', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('791', null, '2016-06-13', '4', null, null, '1046', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('792', null, '2016-06-13', '4', null, null, '1047', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('793', null, '2016-06-13', '4', null, null, '1048', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('794', null, '2016-06-13', '4', null, null, '1049', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('795', null, '2016-06-13', '4', null, null, '1050', '899.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('796', null, '2016-06-13', '4', null, null, '1051', '899.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('797', null, '2016-06-13', '4', null, null, '1052', '899.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('798', null, '2016-06-13', '4', null, null, '1053', '899.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('799', null, '2016-06-13', '4', null, null, '1054', '899.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('800', null, '2016-06-09', '4', null, null, '1055', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('801', null, '2016-06-09', '4', null, null, '1056', '1125.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('802', null, '2016-06-09', '4', null, null, '1057', '1125.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('803', null, '2016-06-09', '4', null, null, '1058', '1905.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('804', null, '2016-06-09', '4', null, null, '1059', '1905.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('805', null, '2016-06-08', '1', null, null, '1060', '59.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('806', null, '2016-06-08', '1', null, null, '1061', '1485.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('807', null, '2016-06-08', '1', null, null, '1062', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('808', null, '2016-06-01', '1', null, null, '1063', '1099.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('809', null, '2016-06-01', '1', null, null, '1064', '1099.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('810', null, '2016-06-05', '1', null, null, '1065', '1099.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('811', null, '2016-06-01', '1', null, null, '1066', '810.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('812', null, '2016-06-01', '1', null, null, '1067', '1888.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('813', null, '2016-06-01', '1', null, null, '1068', '1073.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('814', null, '2016-06-02', '1', null, null, '1069', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('815', null, '2016-06-02', '1', null, null, '1070', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('816', null, '2016-06-03', '1', null, null, '1071', '6130.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('817', null, '2016-06-10', '1', null, null, '1072', '2298.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('818', null, '2016-06-03', '1', null, null, '1073', '2298.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('819', null, '2016-06-03', '1', null, null, '1074', '2298.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('820', null, '2016-06-08', '1', null, null, '1075', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('821', null, '2016-06-03', '1', null, null, '1076', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('822', null, '2016-06-03', '1', null, null, '1077', '1265.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('823', null, '2016-06-05', '1', null, null, '1078', '1265.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('824', null, '2016-06-05', '1', null, null, '1079', '1025.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('825', null, '2016-06-12', '1', null, null, '1080', '1025.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('826', null, '2016-06-10', '1', null, null, '1081', '1025.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('827', null, '2016-06-03', '1', null, null, '1082', '2998.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('828', null, '2016-06-03', '1', null, null, '1083', '1905.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('829', null, '2016-06-05', '1', null, null, '1084', '1905.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('830', null, '2016-06-03', '1', null, null, '1085', '1905.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('831', null, '2016-06-06', '1', null, null, '1086', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('832', null, '2016-06-05', '1', null, null, '1087', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('833', null, '2016-06-04', '1', null, null, '1088', '1895.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('834', null, '2016-06-04', '1', null, null, '1089', '1875.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('835', null, '2016-06-04', '1', null, null, '1090', '1135.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('836', null, '2016-06-04', '1', null, null, '1091', '868.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('837', null, '2016-06-04', '1', null, null, '1092', '984.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('838', null, '2016-06-05', '1', null, null, '1093', '4820.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('839', null, '2016-06-06', '1', null, null, '1094', '5360.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('840', null, '2016-06-06', '1', null, null, '1095', '870.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('841', null, '2016-06-07', '1', null, null, '1096', '1670.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('842', null, '2016-06-08', '1', null, null, '1097', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('843', null, '2016-06-08', '1', null, null, '1098', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('844', null, '2016-06-12', '1', null, null, '1099', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('845', null, '2016-06-11', '1', null, null, '1100', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('846', null, '2016-06-08', '1', null, null, '1101', '899.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('847', null, '2016-06-08', '1', null, null, '1102', '1875.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('848', null, '2016-06-08', '1', null, null, '1103', '4820.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('849', null, '2016-06-08', '1', null, null, '1104', '1110.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('850', null, '2016-06-12', '1', null, null, '1105', '870.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('851', null, '2016-06-08', '1', null, null, '1106', '840.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('852', null, '2016-06-08', '1', null, null, '1107', '123.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('853', null, '2016-06-10', '1', null, null, '1108', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('854', null, '2016-06-10', '1', null, null, '1109', '1125.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('855', null, '2016-06-10', '1', null, null, '1110', '1125.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('856', null, '2016-06-11', '1', null, null, '1111', '1125.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('857', null, '2016-06-10', '1', null, null, '1112', '1125.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('858', null, '2016-06-09', '1', null, null, '1113', '1905.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('859', null, '2016-06-09', '1', null, null, '1114', '1905.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('860', null, '2016-06-12', '1', null, null, '1115', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('861', null, '2016-06-12', '1', null, null, '1116', '2699.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('862', null, '2016-06-12', '1', null, null, '1117', '1099.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('863', null, '2016-06-12', '1', null, null, '1118', '660.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('864', null, '2016-06-12', '1', null, null, '1119', '1875.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('865', null, '2016-06-12', '1', null, null, '1120', '1955.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('866', null, '2016-06-12', '1', null, null, '1121', '1910.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('867', null, '2016-06-12', '1', null, null, '1122', '770.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('868', null, '2016-06-09', '2', null, null, '1123', '275.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('869', null, '2016-06-06', '2', null, null, '1124', '59.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('870', null, '2016-06-06', '2', null, null, '1125', '59.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('871', null, '2016-06-12', '2', null, null, '1126', '275.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('872', null, '2016-06-12', '2', null, null, '1127', '275.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('873', null, '2016-06-01', '2', null, null, '1128', '1605.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('874', null, '2016-06-06', '2', null, null, '1129', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('875', null, '2016-06-06', '2', null, null, '1130', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('876', null, '2016-06-02', '2', null, null, '1131', '480.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('877', null, '2016-06-02', '2', null, null, '1132', '480.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('878', null, '2016-06-01', '2', null, null, '1133', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('879', null, '2016-06-01', '2', null, null, '1134', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('880', null, '2016-06-01', '2', null, null, '1135', '1265.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('881', null, '2016-06-09', '2', null, null, '1136', '1265.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('882', null, '2016-06-01', '2', null, null, '1137', '1099.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('883', null, '2016-06-01', '2', null, null, '1138', '1099.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('884', null, '2016-06-01', '2', null, null, '1139', '810.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('885', null, '2016-06-02', '2', null, null, '1140', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('886', null, '2016-06-02', '2', null, null, '1141', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('887', null, '2016-06-08', '2', null, null, '1142', '2298.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('888', null, '2016-06-05', '2', null, null, '1143', '95.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('889', null, '2016-06-05', '2', null, null, '1144', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('890', null, '2016-06-05', '2', null, null, '1145', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('891', null, '2016-06-05', '2', null, null, '1146', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('892', null, '2016-06-05', '2', null, null, '1147', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('893', null, '2016-06-05', '2', null, null, '1148', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('894', null, '2016-06-05', '2', null, null, '1149', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('895', null, '2016-06-08', '2', null, null, '1150', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('896', null, '2016-06-08', '2', null, null, '1151', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('897', null, '2016-06-08', '2', null, null, '1152', '899.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('898', null, '2016-06-11', '2', null, null, '1153', '870.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('899', null, '2016-06-09', '2', null, null, '1154', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('900', null, '2016-06-12', '2', null, null, '1155', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('901', null, '2016-06-12', '2', null, null, '1156', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('902', null, '2016-06-12', '2', null, null, '1157', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('903', null, '2016-06-12', '2', null, null, '1158', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('904', null, '2016-06-12', '2', null, null, '1159', '1099.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('905', null, '2016-06-12', '2', null, null, '1160', '1099.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('906', null, '2016-06-12', '2', null, null, '1161', '1099.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('907', null, '2016-06-12', '2', null, null, '1162', '660.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('908', null, '2016-06-08', '3', null, null, '1163', '878.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('909', null, '2016-06-08', '3', null, null, '1164', '606.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('910', null, '2016-06-06', '3', null, null, '1165', '1265.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('911', null, '2016-06-08', '3', null, null, '1166', '810.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('912', null, '2016-06-02', '3', null, null, '1167', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('913', null, '2016-06-05', '3', null, null, '1168', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('914', null, '2016-06-03', '3', null, null, '1169', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('915', null, '2016-06-06', '3', null, null, '1170', '1265.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('916', null, '2016-06-03', '3', null, null, '1171', '1265.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('917', null, '2016-06-03', '3', null, null, '1172', '1265.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('918', null, '2016-06-03', '3', null, null, '1173', '1025.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('919', null, '2016-06-03', '3', null, null, '1174', '1025.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('920', null, '2016-06-03', '3', null, null, '1175', '1905.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('921', null, '2016-06-05', '3', null, null, '1176', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('922', null, '2016-06-05', '3', null, null, '1177', '96.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('923', null, '2016-06-05', '3', null, null, '1178', '97.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('924', null, '2016-06-05', '3', null, null, '1179', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('925', null, '2016-06-05', '3', null, null, '1180', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('926', null, '2016-06-05', '3', null, null, '1181', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('927', null, '2016-06-05', '3', null, null, '1182', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('928', null, '2016-06-05', '3', null, null, '1183', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('929', null, '2016-06-05', '3', null, null, '1184', '65.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('930', null, '2016-06-05', '3', null, null, '1185', '635.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('931', null, '2016-06-06', '3', null, null, '1186', '688.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('932', null, '2016-06-07', '3', null, null, '1187', '60.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('933', null, '2016-06-07', '3', null, null, '1188', '60.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('934', null, '2016-06-07', '3', null, null, '1189', '60.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('935', null, '2016-06-07', '3', null, null, '1190', '60.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('936', null, '2016-06-07', '3', null, null, '1191', '60.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('937', null, '2016-06-07', '3', null, null, '1192', '600.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('938', null, '2016-06-07', '3', null, null, '1193', '600.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('939', null, '2016-06-07', '3', null, null, '1194', '5380.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('940', null, '2016-06-07', '3', null, null, '1195', '5330.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('941', null, '2016-06-08', '3', null, null, '1196', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('942', null, '2016-06-08', '3', null, null, '1197', '549.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('943', null, '2016-06-08', '3', null, null, '1198', '899.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('944', null, '2016-06-10', '3', null, null, '1199', '123.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('945', null, '2016-06-10', '3', null, null, '1200', '123.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('946', null, '2016-06-09', '3', null, null, '1201', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('947', null, '2016-06-09', '3', null, null, '1202', '799.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('948', null, '2016-06-09', '3', null, null, '1203', '1905.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('949', null, '2016-06-09', '3', null, null, '1204', '1905.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('950', null, '2016-06-12', '3', null, null, '1205', '2349.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('951', null, '2016-06-12', '3', null, null, '1206', '660.00', '2016-06-13 22:54:53');
INSERT INTO `purchase` VALUES ('1023', '123', '2016-06-12', '4', '3', null, '1278', '1905.00', '2016-06-14 10:08:18');
INSERT INTO `purchase` VALUES ('1024', '123', '2016-06-12', '4', '3', null, '1279', '1905.00', '2016-06-14 10:10:09');
INSERT INTO `purchase` VALUES ('1025', '123', '2016-06-12', '4', '3', null, '1280', '1905.00', '2016-06-14 10:11:32');
INSERT INTO `purchase` VALUES ('1026', '123', '2016-06-13', '3', '3', null, '1281', '1905.00', '2016-06-14 10:57:37');
INSERT INTO `purchase` VALUES ('1027', '123', '2016-06-13', '3', '3', null, '1282', '2298.00', '2016-06-14 11:00:04');
INSERT INTO `purchase` VALUES ('1028', '123', '2016-06-13', '1', '3', null, '1294', '1905.00', '2016-06-14 11:04:03');
INSERT INTO `purchase` VALUES ('1029', '123', '2016-06-07', '2', '2', null, '1295', '899.00', '2016-06-16 10:21:04');

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
INSERT INTO `saler` VALUES ('1', '欧阳少燕', '2016-06-13 12:03:56');
INSERT INTO `saler` VALUES ('2', '林丽蕾', '2016-06-13 12:04:13');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='店铺表';

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
