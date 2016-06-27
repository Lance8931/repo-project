/*
Navicat MySQL Data Transfer

Source Server         : 192.168.10.68
Source Server Version : 50505
Source Host           : 192.168.10.68:3306
Source Database       : hrip

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-05-20 18:02:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `title` varchar(40) DEFAULT NULL COMMENT '标题',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `type` varchar(10) DEFAULT NULL COMMENT '文章类型：001通知，002公告，101园区动态，102行业资讯，103媒体关注',
  `msg_type_id` int(11) DEFAULT NULL COMMENT '消息公告类型id',
  `pic_path` varchar(30) DEFAULT NULL COMMENT '首页显示图片的路径',
  `display_position` varchar(6) DEFAULT NULL COMMENT '显示位置，top1- top5可选',
  `enabled` bit(1) DEFAULT NULL COMMENT '是否启用，0不启用，1启用',
  `is_delete` bit(1) NOT NULL COMMENT '是否已删除，0已删除，1未删除',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `content` longtext COMMENT '内容详情',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` int(11) NOT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='发布的消息、通知、文章';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '是的发送到', '是的发生', '101', '1', null, null, '', '', '2016-05-16 15:19:03', '<p>水电费水电费水电费三分<br/></p>', '2016-05-16 15:18:12', '1', '2016-05-19 10:38:10', null);
INSERT INTO `article` VALUES ('2', '是的发送到', '是打发', '1', '2', null, null, '\0', '', '2016-05-16 15:26:47', '<p>士大夫士大夫士大夫士大夫<br/></p>', '2016-05-16 15:25:56', '1', '2016-05-19 10:38:10', null);
INSERT INTO `article` VALUES ('3', '斯蒂sdf', '23', '001', '1', null, null, '\0', '', '2016-05-16 15:29:46', '<p>是打发是打发是<br/></p>', '2016-05-16 15:28:55', '1', '2016-05-19 14:07:29', null);
INSERT INTO `article` VALUES ('5', 'cbcvb', 'cvb', '001', '1', null, '3', '', '\0', '2016-05-16 15:44:26', '<p>dfgdfgdfgdfsdsdfsfd<br/></p>', '2016-05-16 15:43:28', '1', null, null);
INSERT INTO `article` VALUES ('6', '是的发送到发', '是的发生', '102', '1', null, '', '', '', '2016-05-16 15:48:17', '<p>阿斯顿发送到发送到发顺丰的<br/></p>', '2016-05-16 15:47:26', '1', '2016-05-19 14:07:29', null);
INSERT INTO `article` VALUES ('7', 'cbcvb', 'cvb', '001', '1', null, '2', '', '', '2016-05-16 15:48:46', '<p>dfgdfgdfgdf<br/></p>', '2016-05-16 15:47:48', '1', '2016-05-19 14:47:11', null);
INSERT INTO `article` VALUES ('8', 'hfghfg', 'fgh', '001', '1', null, null, '', '', '2016-05-16 15:51:33', '<p>jghjfgjgh<br/></p>', '2016-05-16 15:50:35', '1', null, null);
INSERT INTO `article` VALUES ('9', 'bcb', 'dfg', '1', '1', null, null, '\0', '', '2016-05-16 15:53:33', '<p>dfgdfgfd<br/></p>', '2016-05-16 15:52:40', '1', null, null);
INSERT INTO `article` VALUES ('10', '啥打法是否', '是打发', '103', null, null, null, '', '', '2016-05-16 15:54:09', '<p>是打发是打发地方<br/></p>', '2016-05-16 15:53:19', '1', '2016-05-19 10:38:10', null);
INSERT INTO `article` VALUES ('11', 'dgd', 'gdf', '1', '1', null, null, '', '', '2016-05-16 15:56:31', '<p>dfgdfgdfgddfg<br/></p>', '2016-05-16 15:55:33', '1', '2016-05-19 14:07:29', null);
INSERT INTO `article` VALUES ('12', 'asdfasdf', 'sdfs', '002', '2', null, '3', '', '', '2016-05-16 16:38:36', '<p>sdfsdf<br/></p>', '2016-05-16 16:37:38', '1', null, null);
INSERT INTO `article` VALUES ('13', 'asdfasdf', 'sadf', '103', null, null, null, '', '', '2016-05-16 16:59:10', '<p>sadfasdf<br/></p>', '2016-05-16 16:58:19', '1', null, null);
INSERT INTO `article` VALUES ('14', 'sdfsadf', 'sadfasdf', '101', null, null, null, '', '', '2016-05-16 17:03:55', '<p>sdfasdf<br/></p>', '2016-05-16 17:03:04', '1', '2016-05-19 10:38:10', null);
INSERT INTO `article` VALUES ('15', 'fsdfsd', 'sdfsd', '002', '1', null, '1', '', '', '2016-05-16 17:10:28', '<p>sdfsd<br/></p>', '2016-05-16 17:09:30', '1', '2016-05-17 10:45:38', '1');
INSERT INTO `article` VALUES ('16', '654654', '65465', '002', '1', null, '2', '', '', '2016-05-16 17:11:48', '<p>dsfsdfsd<br/></p>', '2016-05-16 17:10:50', '1', '2016-05-17 10:45:50', '1');
INSERT INTO `article` VALUES ('17', 'SDFS', 'SDFS', '101', null, 'SDF', null, '', '', '2016-05-18 15:38:04', '<p>fsd<br/></p>', '2016-05-18 15:36:55', '1', null, null);
INSERT INTO `article` VALUES ('18', 'sdf', 'sdf', '101', null, '1463557345028.jpg', '3', '\0', '', '2016-05-18 15:42:25', '<p>sdf<br/></p>', '2016-05-18 15:41:16', '1', '2016-05-19 14:09:46', null);
INSERT INTO `article` VALUES ('19', 'fs', 'sdf', '101', null, '1463625496445.jpg', '4', '\0', '', '2016-05-18 17:09:29', '<p>fsd<br/></p>', '2016-05-18 17:08:20', '1', '2016-05-19 14:49:55', null);
INSERT INTO `article` VALUES ('20', 'ffsssddd', 'fdd', '101', null, '1463562712095.jpg', '2', '', '', '2016-05-18 17:11:52', '<p>fsdf<br/></p>', '2016-05-18 17:10:43', '1', null, null);
INSERT INTO `article` VALUES ('21', 'fsd', 'sdf', '101', null, '1463562753993.jpg', '5', '', '', '2016-05-18 17:12:33', '<p>fs<br/></p>', '2016-05-18 17:11:24', '1', '2016-05-19 14:07:29', null);
INSERT INTO `article` VALUES ('22', 'sdf', 'fssdf', '101', null, '1463564203052.jpg', null, '', '', '2016-05-18 17:36:43', '<p>fsdfsdfsdf<br/></p>', '2016-05-18 17:35:33', '1', '2016-05-19 10:38:10', null);
INSERT INTO `article` VALUES ('23', 'sdf', 'fsd', '101', null, '1463564418741.jpg', null, '', '', '2016-05-18 17:40:18', '<p>fsd<br/></p>', '2016-05-18 17:39:09', '1', null, null);
INSERT INTO `article` VALUES ('24', 'fsd', 'sdff', '101', null, '1463636642710.jpg', '1', '', '', '2016-05-19 13:43:56', '<p>fsdfsd<br/></p>', '2016-05-19 13:43:05', '1', null, null);
INSERT INTO `article` VALUES ('25', 'fsd', 'sdf', '001', null, null, null, '', '', '2016-05-20 13:49:51', '<p>sfsd<br/></p>', '2016-05-20 13:48:31', '1', null, null);
INSERT INTO `article` VALUES ('26', 'hfgh', 'fh', '001', null, null, null, '', '', '2016-05-20 13:51:11', '<p>hfghfg<br/></p>', '2016-05-20 13:49:51', '1', null, null);
INSERT INTO `article` VALUES ('27', 'gdfg', 'sdfff', '001', null, null, null, '', '', '2016-05-20 13:53:09', '<p>fsdfsd<br/></p>', '2016-05-20 13:51:49', '1', null, null);
INSERT INTO `article` VALUES ('28', 'dfgdf', 'dfg', '001', null, null, null, '', '', '2016-05-20 13:54:35', '<p>gdfgdf<br/></p>', '2016-05-20 13:53:15', '1', null, null);
INSERT INTO `article` VALUES ('29', 'gfgf', 'fggf', '001', null, null, '1', '', '', '2016-05-20 13:55:30', '<p>fgfgfg<br/></p>', '2016-05-20 13:54:10', '1', null, null);

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `group_name` varchar(30) NOT NULL COMMENT '组名',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组表，is_delete：0或false表示未删除，1或true表示已删除';

-- ----------------------------
-- Records of groups
-- ----------------------------

-- ----------------------------
-- Table structure for hr_annual_achieve
-- ----------------------------
DROP TABLE IF EXISTS `hr_annual_achieve`;
CREATE TABLE `hr_annual_achieve` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `years` int(4) DEFAULT NULL COMMENT '年份',
  `patents_home` int(11) DEFAULT NULL COMMENT '国内获得专利数',
  `patents_abroad` int(11) DEFAULT NULL COMMENT '国外获得专利数',
  `thesis_home` int(11) DEFAULT NULL COMMENT '国内重要期刊发表论文数',
  `thesis_abroad` int(11) DEFAULT NULL COMMENT '国外重要期刊发表论文数',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='获得的荣誉、成就情况';

-- ----------------------------
-- Records of hr_annual_achieve
-- ----------------------------

-- ----------------------------
-- Table structure for hr_cv
-- ----------------------------
DROP TABLE IF EXISTS `hr_cv`;
CREATE TABLE `hr_cv` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `self_assessment` varchar(800) DEFAULT NULL COMMENT '自我评价',
  `job_objective` varchar(5) DEFAULT NULL COMMENT '求职意向',
  `expect_location` varchar(40) DEFAULT NULL COMMENT '期望工作地点，多个以英文逗号隔开',
  `expect_industry` varchar(40) DEFAULT NULL COMMENT '期望从事行业，多个以英文逗号隔开',
  `expect_occupation` varchar(40) DEFAULT NULL COMMENT '期望从事职业，多个以英文逗号隔开',
  `expect_salary` varchar(20) DEFAULT NULL COMMENT '期望月薪',
  `cv_doc` varchar(50) DEFAULT NULL COMMENT '附件文档',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个人简历表';

-- ----------------------------
-- Records of hr_cv
-- ----------------------------

-- ----------------------------
-- Table structure for hr_cv_download
-- ----------------------------
DROP TABLE IF EXISTS `hr_cv_download`;
CREATE TABLE `hr_cv_download` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `cv_id` int(10) DEFAULT NULL COMMENT '简历id',
  `download_time` datetime DEFAULT NULL COMMENT '简历下载时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历下载记录表';

-- ----------------------------
-- Records of hr_cv_download
-- ----------------------------

-- ----------------------------
-- Table structure for hr_education
-- ----------------------------
DROP TABLE IF EXISTS `hr_education`;
CREATE TABLE `hr_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `cv_id` int(11) DEFAULT NULL COMMENT '个人简历id，此字段针对普通求职者',
  `nationality` varchar(30) DEFAULT NULL COMMENT '国家',
  `college` varchar(30) DEFAULT NULL COMMENT '院校',
  `major` varchar(30) DEFAULT NULL COMMENT '专业',
  `degree` varchar(30) DEFAULT NULL COMMENT '学位',
  `date_from` date DEFAULT NULL COMMENT '入学日期',
  `date_to` date DEFAULT NULL COMMENT '毕业日期',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教育经历';

-- ----------------------------
-- Records of hr_education
-- ----------------------------

-- ----------------------------
-- Table structure for hr_employee
-- ----------------------------
DROP TABLE IF EXISTS `hr_employee`;
CREATE TABLE `hr_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `emp_no` int(10) DEFAULT NULL COMMENT '员工编号',
  `emp_name` varchar(40) DEFAULT NULL COMMENT '员工姓名',
  `position` varchar(15) DEFAULT NULL COMMENT '职位',
  `telephone` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `cellphone` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `sex` bit(1) DEFAULT NULL COMMENT '性别，0女，1男',
  `department` varchar(20) DEFAULT NULL COMMENT '部门',
  `is_delete` bit(1) DEFAULT NULL COMMENT '是否删除，0未删除，1已删除',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of hr_employee
-- ----------------------------
INSERT INTO `hr_employee` VALUES ('1', 'zzzzzzz', '111111', '就是光棍', '码农', '', '13212313129', '3333333@qq.com', '', 'java', '\0', '2016-05-05 17:21:29', null, '2016-05-06 15:30:25', null);
INSERT INTO `hr_employee` VALUES ('2', 'zzzzzzzz', '2222222', '屌丝', '码农', '', '13212314514', null, '', 'ios', '\0', '2016-05-06 11:16:13', null, null, null);
INSERT INTO `hr_employee` VALUES ('3', 'qweqweqw', '1231231', 'xcvx', 'xcv', '', '13512312332', '33131@qq.com', '', 'xcv', '\0', '2016-05-06 11:39:03', null, null, null);
INSERT INTO `hr_employee` VALUES ('4', 'xcvxcvxv', '1222222', '321', '123', '6452457', '13512312312', '1312@qq.cjom', '', '123', '\0', '2016-05-20 13:29:36', null, null, null);

-- ----------------------------
-- Table structure for hr_enterprise_annals
-- ----------------------------
DROP TABLE IF EXISTS `hr_enterprise_annals`;
CREATE TABLE `hr_enterprise_annals` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `years` int(4) DEFAULT NULL COMMENT '年份',
  `sales` double DEFAULT NULL COMMENT '销售额(万元)',
  `profit` double DEFAULT NULL COMMENT '利润(万元)',
  `tax_revenue` double DEFAULT NULL COMMENT '税收(万元)',
  `work_plan` varchar(5000) DEFAULT NULL COMMENT '工作计划',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业年报情况';

-- ----------------------------
-- Records of hr_enterprise_annals
-- ----------------------------

-- ----------------------------
-- Table structure for hr_job
-- ----------------------------
DROP TABLE IF EXISTS `hr_job`;
CREATE TABLE `hr_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `post_nature` varchar(4) DEFAULT NULL COMMENT '职位性质',
  `post_name` varchar(30) DEFAULT NULL COMMENT '职位名称',
  `post_category` varchar(20) DEFAULT NULL COMMENT '职位类别',
  `require_number` int(5) DEFAULT NULL COMMENT '招聘人数',
  `education` varchar(10) DEFAULT NULL COMMENT '学历要求',
  `experience` varchar(10) DEFAULT NULL COMMENT '经验要求',
  `post_salary` varchar(16) DEFAULT NULL COMMENT '职位月薪范围',
  `show_salary` bit(1) DEFAULT NULL COMMENT '是否显示月薪，0不显示，1显示',
  `description` text COMMENT '职位描述',
  `welfare` varchar(40) DEFAULT NULL COMMENT '职位亮点、员工福利(存数组对象，对应关系：1五险一金2年底双薪3绩效奖金4年终分红5股票期权6加班补助7全勤奖8包吃9包住10交通补助11餐补12房补13通讯补贴14采暖补贴15带薪年假16弹性工作17补充医疗保险18定期体检19免费班车20员工旅游21高温补贴22节日福利)',
  `job_site` varchar(6) DEFAULT NULL COMMENT '职位发布地点',
  `work_address` varchar(60) DEFAULT NULL COMMENT '工作地址',
  `coordinates` varchar(30) DEFAULT NULL COMMENT '工作地址的地理坐标，经度纬度用英文逗号隔开',
  `release_date` date DEFAULT NULL COMMENT '发布日期',
  `end_date` date DEFAULT NULL COMMENT '发布截止日期',
  `auto_reply` bit(1) DEFAULT NULL COMMENT '是否自动回复求职者，0不回复，1自动回复',
  `refresh_date` date DEFAULT NULL COMMENT '刷新日期',
  `status` varchar(3) DEFAULT NULL COMMENT '职位状态：1发布中，2未发布，3已暂停，4审核中，5审核未通过，0已结束',
  `suspend_date` date DEFAULT NULL COMMENT '暂停日期',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  `is_delete` bit(1) NOT NULL COMMENT '是否已删除，0已删除，1未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=' 招聘职位';

-- ----------------------------
-- Records of hr_job
-- ----------------------------

-- ----------------------------
-- Table structure for hr_job_apply
-- ----------------------------
DROP TABLE IF EXISTS `hr_job_apply`;
CREATE TABLE `hr_job_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `cv_id` int(10) DEFAULT NULL COMMENT '简历id',
  `job_id` int(10) DEFAULT NULL COMMENT '职位id',
  `apply_time` datetime DEFAULT NULL COMMENT '申请时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位申请表';

-- ----------------------------
-- Records of hr_job_apply
-- ----------------------------

-- ----------------------------
-- Table structure for hr_job_favor
-- ----------------------------
DROP TABLE IF EXISTS `hr_job_favor`;
CREATE TABLE `hr_job_favor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `invite_user` varchar(20) NOT NULL COMMENT '邀请者用户名',
  `invited_user` varchar(20) NOT NULL COMMENT '被邀请者用户名',
  `cv_id` int(10) DEFAULT NULL COMMENT '简历id',
  `job_id` int(10) DEFAULT NULL COMMENT '职位id',
  `invite_time` datetime DEFAULT NULL COMMENT '邀请时间',
  `reply_time` datetime DEFAULT NULL COMMENT '答复时间',
  `status` smallint(1) DEFAULT NULL COMMENT '0待处理、1待沟通、2已接受、3不合适',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位邀请信息表';

-- ----------------------------
-- Records of hr_job_favor
-- ----------------------------

-- ----------------------------
-- Table structure for hr_patent
-- ----------------------------
DROP TABLE IF EXISTS `hr_patent`;
CREATE TABLE `hr_patent` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `patent_name` varchar(30) DEFAULT NULL COMMENT '专利名称',
  `patent_type` varchar(20) DEFAULT NULL COMMENT '专利类型',
  `get_date` date DEFAULT NULL COMMENT '获取专利时间',
  `grant_no` varchar(30) DEFAULT NULL COMMENT '批准号',
  `review_date` date DEFAULT NULL COMMENT '评审时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='获得的专利情况';

-- ----------------------------
-- Records of hr_patent
-- ----------------------------

-- ----------------------------
-- Table structure for hr_project_research
-- ----------------------------
DROP TABLE IF EXISTS `hr_project_research`;
CREATE TABLE `hr_project_research` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `project_name` varchar(40) DEFAULT NULL COMMENT '项目名称',
  `duration` varchar(30) DEFAULT NULL COMMENT '项目时间',
  `funds` double DEFAULT NULL COMMENT '经费',
  `role` varchar(10) DEFAULT NULL COMMENT '参与或主持',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参与科研项目情况';

-- ----------------------------
-- Records of hr_project_research
-- ----------------------------

-- ----------------------------
-- Table structure for hr_relationship
-- ----------------------------
DROP TABLE IF EXISTS `hr_relationship`;
CREATE TABLE `hr_relationship` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `age` smallint(3) DEFAULT NULL COMMENT '年龄',
  `realname` varchar(15) DEFAULT NULL COMMENT '真实姓名',
  `nationality` varchar(30) DEFAULT NULL COMMENT '国籍',
  `duty` varchar(15) DEFAULT NULL COMMENT '在企业担任的职务',
  `company_name` varchar(30) DEFAULT NULL COMMENT '工作企业名称',
  `relation` varchar(20) DEFAULT NULL COMMENT '与本人何种关系',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='家庭主要成员及重要社会关系';

-- ----------------------------
-- Records of hr_relationship
-- ----------------------------

-- ----------------------------
-- Table structure for hr_review
-- ----------------------------
DROP TABLE IF EXISTS `hr_review`;
CREATE TABLE `hr_review` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `review_name` varchar(30) DEFAULT NULL COMMENT '评审名称',
  `review_date` date DEFAULT NULL COMMENT '评审时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='重要评审工作情况';

-- ----------------------------
-- Records of hr_review
-- ----------------------------

-- ----------------------------
-- Table structure for hr_senior_talent
-- ----------------------------
DROP TABLE IF EXISTS `hr_senior_talent`;
CREATE TABLE `hr_senior_talent` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `nationality` varchar(30) DEFAULT NULL COMMENT '国籍',
  `realname` varchar(15) DEFAULT NULL COMMENT '真实姓名',
  `foreign_name` varchar(25) DEFAULT NULL COMMENT '外文名字',
  `birthplace` varchar(30) DEFAULT NULL COMMENT '出生地',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `photo` varchar(30) DEFAULT NULL COMMENT '照片路径',
  `sex` bit(1) DEFAULT NULL COMMENT '性别，0女，1男',
  `identity_name` varchar(10) DEFAULT NULL COMMENT '有效身份证件名称',
  `identity_no` varchar(30) DEFAULT NULL COMMENT '有效身份证件号码',
  `graduate_from_ch` varchar(60) DEFAULT NULL COMMENT '毕业院校、专业及学位(中文)',
  `graduate_from_en` varchar(60) DEFAULT NULL COMMENT '毕业院校、专业及学位(英文)',
  `company_name` varchar(30) DEFAULT NULL COMMENT '创办企业名称',
  `company_address` varchar(40) DEFAULT NULL COMMENT '创办企业地址',
  `duty` varchar(15) DEFAULT NULL COMMENT '在企业担任的职务',
  `postcode` varchar(10) DEFAULT NULL COMMENT '企业所在地邮编',
  `address_home` varchar(50) DEFAULT NULL COMMENT '国内住址',
  `address_abroad` varchar(50) DEFAULT NULL COMMENT '国外住址',
  `phone_home` varchar(15) DEFAULT NULL COMMENT '国内联系电话',
  `phone_abroad` varchar(15) DEFAULT NULL COMMENT '国外联系电话',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `major_field` varchar(60) DEFAULT NULL COMMENT '专业领域',
  `speciality` varchar(60) DEFAULT NULL COMMENT '专业方向',
  `postdoctor_experience` varchar(255) DEFAULT NULL COMMENT '学位及博士后经历',
  `worktime_per_year` varchar(10) DEFAULT NULL COMMENT '承诺每年在蓉工作时限',
  `settle_county` varchar(30) DEFAULT NULL COMMENT '落地区县',
  `company_before` varchar(40) DEFAULT NULL COMMENT '回国前单位',
  `duty_before` varchar(30) DEFAULT NULL COMMENT '回国前职务职称',
  `date_to_chengdu` date DEFAULT NULL COMMENT '回国来蓉时间',
  `apply_county` varchar(30) DEFAULT NULL COMMENT '申报区（市）县',
  `introduction_type` varchar(5) DEFAULT NULL COMMENT '人才引进类别',
  `apply_org` varchar(50) DEFAULT NULL COMMENT '填报单位',
  `apply_date` date DEFAULT NULL COMMENT '填报时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` smallint(1) DEFAULT NULL COMMENT '0申请中，1已同意，2已拒绝',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  `is_delete` bit(1) DEFAULT NULL COMMENT '是否已删除，0已删除，1未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='高层次人才信息';

-- ----------------------------
-- Records of hr_senior_talent
-- ----------------------------

-- ----------------------------
-- Table structure for hr_talent_innovation
-- ----------------------------
DROP TABLE IF EXISTS `hr_talent_innovation`;
CREATE TABLE `hr_talent_innovation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `regist_year` int(4) DEFAULT NULL COMMENT '登记年份',
  `talent_name` varchar(30) DEFAULT NULL COMMENT '专家姓名团队名称',
  `nationality` varchar(30) DEFAULT NULL COMMENT '国籍',
  `birthday` date DEFAULT NULL COMMENT '出生年月',
  `sex` bit(1) DEFAULT NULL COMMENT '性别，0女，1男',
  `selected_date` date DEFAULT NULL COMMENT '入选时间',
  `selected_type` varchar(20) DEFAULT NULL COMMENT '入选类型',
  `major_field` varchar(60) DEFAULT NULL COMMENT '专业领域',
  `company_name` varchar(30) DEFAULT NULL COMMENT '用人单位',
  `duty` varchar(15) DEFAULT NULL COMMENT '职务职称',
  `registered_capital` float DEFAULT NULL COMMENT '注册资金(万元)',
  `bellow_bachelor_num` int(11) DEFAULT NULL COMMENT '本科以下员工人数',
  `bachelor_num` int(11) DEFAULT NULL COMMENT '本科员工人数',
  `master_num` int(11) DEFAULT NULL COMMENT '硕士研究生人数',
  `doctor_num` int(11) DEFAULT NULL COMMENT '博士研究生人数',
  `total_emp_num` int(11) DEFAULT NULL COMMENT '总的员工人数',
  `used_grants` varchar(150) DEFAULT NULL COMMENT '已使用资助资金情况',
  `unused_grants` double DEFAULT NULL COMMENT '未使用资助资金额',
  `total_grants` double DEFAULT NULL COMMENT '总资助资金额',
  `suggestion` varchar(255) DEFAULT NULL COMMENT '工作中存在的困难、意见建议',
  `registrant` varchar(30) DEFAULT NULL COMMENT '填报者',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `telephone` varchar(30) DEFAULT NULL COMMENT '办公电话',
  `cellphone` varchar(30) DEFAULT NULL COMMENT '手机',
  `is_delete` bit(1) DEFAULT NULL COMMENT '是否已删除，0已删除，1未删除',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家人才创新创业情况';

-- ----------------------------
-- Records of hr_talent_innovation
-- ----------------------------

-- ----------------------------
-- Table structure for hr_working_achieve
-- ----------------------------
DROP TABLE IF EXISTS `hr_working_achieve`;
CREATE TABLE `hr_working_achieve` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `realname` varchar(15) DEFAULT NULL COMMENT '真实姓名',
  `company_name` varchar(30) DEFAULT NULL COMMENT '创办企业名称',
  `duty` varchar(15) DEFAULT NULL COMMENT '职务职称',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `working_field` varchar(800) DEFAULT NULL COMMENT '工作领域',
  `main_work` varchar(1000) DEFAULT NULL COMMENT '回国后的主要工作、贡献及评价（包括正在进行的工作及预期贡献）',
  `achievement` varchar(1000) DEFAULT NULL COMMENT '回国后取得的重大科研成果（帮助企业自主创新、技术产品升级等情况）',
  `startup_fund` double DEFAULT NULL COMMENT '回国后启动经费',
  `total_fund` double DEFAULT NULL COMMENT '回国后经费总额',
  `honor` varchar(500) DEFAULT NULL COMMENT '回国后所获奖励或荣誉',
  `team_building` varchar(500) DEFAULT NULL COMMENT '回国后团队建设情况',
  `suggestion` varchar(1000) DEFAULT NULL COMMENT '回国遇到的问题或困难及对“千人计划”工作的意见和建议',
  `opinions` varchar(200) DEFAULT NULL COMMENT '用人单位意见',
  `is_delete` bit(1) DEFAULT NULL COMMENT '是否已删除，0已删除，1未删除',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家工作成果调查情况';

-- ----------------------------
-- Records of hr_working_achieve
-- ----------------------------

-- ----------------------------
-- Table structure for hr_work_experience
-- ----------------------------
DROP TABLE IF EXISTS `hr_work_experience`;
CREATE TABLE `hr_work_experience` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `cv_id` int(11) DEFAULT NULL COMMENT '个人简历id，此字段针对普通求职者',
  `duty` varchar(15) DEFAULT NULL COMMENT '在企业担任的职务',
  `company_name` varchar(30) DEFAULT NULL COMMENT '企业名称',
  `industry` int(10) DEFAULT NULL COMMENT '企业所属行业类型',
  `date_from` date DEFAULT NULL COMMENT '开始工作日期',
  `date_to` date DEFAULT NULL COMMENT '结束工作日期',
  `nationality` varchar(30) DEFAULT NULL COMMENT '国家',
  `description` varchar(800) DEFAULT NULL COMMENT '工作描述',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作经历';

-- ----------------------------
-- Records of hr_work_experience
-- ----------------------------

-- ----------------------------
-- Table structure for intro_article
-- ----------------------------
DROP TABLE IF EXISTS `intro_article`;
CREATE TABLE `intro_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `title` varchar(20) DEFAULT NULL COMMENT 'park-info园区概况，org-incoming企业入区，innovative创新创业，oversea-innovative离岸创新创业',
  `sub_title` varchar(5) DEFAULT NULL COMMENT '201园区简介、202园区风貌、203地理区位、204园区管理机构、205园区导引，301入区优势、302入区政策、303入区指南、304入驻企业，401创新创业优势、402优惠政策、403创新创业指南',
  `content` longtext COMMENT '内容详情',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='发布的园区介绍性说明文';

-- ----------------------------
-- Records of intro_article
-- ----------------------------
INSERT INTO `intro_article` VALUES ('1', 'park-info', '201', '<p>园区介绍12</p>', '2016-05-18 14:30:36', null);
INSERT INTO `intro_article` VALUES ('2', 'park-info', '202', '<p>园区风貌2</p>', '2016-05-18 14:27:46', null);
INSERT INTO `intro_article` VALUES ('3', 'park-info', '203', '<p>地理区位3</p>', '2016-05-18 14:27:50', null);
INSERT INTO `intro_article` VALUES ('4', 'park-info', '204', '<p>园区管理机构4</p>', '2016-05-18 14:27:54', null);
INSERT INTO `intro_article` VALUES ('5', 'park-info', '205', '<p>园区导引5</p>', '2016-05-18 14:27:38', null);
INSERT INTO `intro_article` VALUES ('6', 'org-incoming', '301', '<p>入区优势</p>', '2016-05-18 14:16:32', null);
INSERT INTO `intro_article` VALUES ('7', 'org-incoming', '302', '<p>入区政策</p>', '2016-05-18 14:16:40', null);
INSERT INTO `intro_article` VALUES ('8', 'org-incoming', '303', '<p>入区指南</p>', '2016-05-18 14:16:47', null);
INSERT INTO `intro_article` VALUES ('9', 'org-incoming', '304', '<p>入驻企业</p>', '2016-05-18 14:16:54', null);
INSERT INTO `intro_article` VALUES ('10', 'innovative', '401', '<p>创新创业优势</p>', '2016-05-18 14:17:05', null);
INSERT INTO `intro_article` VALUES ('11', 'innovative', '402', '<p>优惠政策</p>', '2016-05-18 14:17:12', null);
INSERT INTO `intro_article` VALUES ('12', 'innovative', '403', '<p>创新创业指南</p>', '2016-05-18 14:17:22', null);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `menu_name` int(11) DEFAULT NULL COMMENT '菜单名字',
  `menu_url` varchar(30) DEFAULT NULL COMMENT '菜单链接地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  `oder_no` int(11) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for msg_type
-- ----------------------------
DROP TABLE IF EXISTS `msg_type`;
CREATE TABLE `msg_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type_name` varchar(20) DEFAULT NULL COMMENT '类型名称',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='公告消息类型';

-- ----------------------------
-- Records of msg_type
-- ----------------------------
INSERT INTO `msg_type` VALUES ('1', '培训', '2016-05-16 13:54:57', null, null, null);
INSERT INTO `msg_type` VALUES ('2', '活动', '2016-05-16 13:55:15', null, null, null);

-- ----------------------------
-- Table structure for org_type
-- ----------------------------
DROP TABLE IF EXISTS `org_type`;
CREATE TABLE `org_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `type_name` varchar(20) DEFAULT NULL COMMENT '企业类型名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='企业类型';

-- ----------------------------
-- Records of org_type
-- ----------------------------
INSERT INTO `org_type` VALUES ('1', '国企', '2016-04-26 11:33:25', '1', '2016-04-26 11:33:27', '1');
INSERT INTO `org_type` VALUES ('2', '外商独资', '2016-04-26 11:33:45', '1', '2016-04-26 11:33:48', '1');
INSERT INTO `org_type` VALUES ('3', '代表处', '2016-04-26 11:34:01', '1', '2016-04-26 11:34:03', '1');
INSERT INTO `org_type` VALUES ('4', '合资', '2016-04-26 11:34:14', '1', '2016-04-26 11:34:17', '1');
INSERT INTO `org_type` VALUES ('5', '民营', '2016-04-26 11:34:31', '1', '2016-04-26 11:34:33', '1');
INSERT INTO `org_type` VALUES ('6', '股份制企业', '2016-04-26 11:34:44', '1', '2016-04-26 11:34:46', '1');
INSERT INTO `org_type` VALUES ('7', '上市公司', '2016-04-26 11:34:56', '1', '2016-04-26 11:34:59', '1');
INSERT INTO `org_type` VALUES ('8', '国家机关', '2016-04-26 11:35:10', '1', '2016-04-26 11:35:12', '1');
INSERT INTO `org_type` VALUES ('9', '事业单位', '2016-04-26 11:35:23', '1', '2016-04-26 11:35:25', '1');
INSERT INTO `org_type` VALUES ('10', '其他', '2016-04-26 11:35:33', '1', '2016-04-26 11:35:35', '1');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `group_id` int(11) DEFAULT NULL COMMENT '组id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  `addible` bit(1) DEFAULT NULL COMMENT '是否有新增权限，0没有，1有',
  `editable` bit(1) DEFAULT NULL COMMENT '是否有编辑权限，0没有，1有',
  `deletable` bit(1) DEFAULT NULL COMMENT '是否有删除权限，0没有，1有',
  `readable` bit(1) DEFAULT NULL COMMENT '是否有读取权限，0没有，1有',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组权限';

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for siping_city
-- ----------------------------
DROP TABLE IF EXISTS `siping_city`;
CREATE TABLE `siping_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(6) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `parent_id` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=334 DEFAULT CHARSET=utf8 COMMENT='市/州';

-- ----------------------------
-- Records of siping_city
-- ----------------------------
INSERT INTO `siping_city` VALUES ('1', '340100', '合肥市', '340000');
INSERT INTO `siping_city` VALUES ('2', '340200', '芜湖市', '340000');
INSERT INTO `siping_city` VALUES ('3', '340300', '蚌埠市', '340000');
INSERT INTO `siping_city` VALUES ('4', '340400', '淮南市', '340000');
INSERT INTO `siping_city` VALUES ('5', '340500', '马鞍山市', '340000');
INSERT INTO `siping_city` VALUES ('6', '340600', '淮北市', '340000');
INSERT INTO `siping_city` VALUES ('7', '340700', '铜陵市', '340000');
INSERT INTO `siping_city` VALUES ('8', '340800', '安庆市', '340000');
INSERT INTO `siping_city` VALUES ('9', '341000', '黄山市', '340000');
INSERT INTO `siping_city` VALUES ('10', '341100', '滁州市', '340000');
INSERT INTO `siping_city` VALUES ('11', '341200', '阜阳市', '340000');
INSERT INTO `siping_city` VALUES ('12', '341300', '宿州市', '340000');
INSERT INTO `siping_city` VALUES ('13', '341500', '六安市', '340000');
INSERT INTO `siping_city` VALUES ('14', '341600', '亳州市', '340000');
INSERT INTO `siping_city` VALUES ('15', '341700', '池州市', '340000');
INSERT INTO `siping_city` VALUES ('16', '341800', '宣城市', '340000');
INSERT INTO `siping_city` VALUES ('17', '350100', '福州市', '350000');
INSERT INTO `siping_city` VALUES ('18', '350200', '厦门市', '350000');
INSERT INTO `siping_city` VALUES ('19', '350300', '莆田市', '350000');
INSERT INTO `siping_city` VALUES ('20', '350400', '三明市', '350000');
INSERT INTO `siping_city` VALUES ('21', '350500', '泉州市', '350000');
INSERT INTO `siping_city` VALUES ('22', '350600', '漳州市', '350000');
INSERT INTO `siping_city` VALUES ('23', '350700', '南平市', '350000');
INSERT INTO `siping_city` VALUES ('24', '350800', '龙岩市', '350000');
INSERT INTO `siping_city` VALUES ('25', '350900', '宁德市', '350000');
INSERT INTO `siping_city` VALUES ('26', '620100', '兰州市', '620000');
INSERT INTO `siping_city` VALUES ('27', '620200', '嘉峪关市', '620000');
INSERT INTO `siping_city` VALUES ('28', '620300', '金昌市', '620000');
INSERT INTO `siping_city` VALUES ('29', '620400', '白银市', '620000');
INSERT INTO `siping_city` VALUES ('30', '620500', '天水市', '620000');
INSERT INTO `siping_city` VALUES ('31', '620600', '武威市', '620000');
INSERT INTO `siping_city` VALUES ('32', '620700', '张掖市', '620000');
INSERT INTO `siping_city` VALUES ('33', '620800', '平凉市', '620000');
INSERT INTO `siping_city` VALUES ('34', '620900', '酒泉市', '620000');
INSERT INTO `siping_city` VALUES ('35', '621000', '庆阳市', '620000');
INSERT INTO `siping_city` VALUES ('36', '621100', '定西市', '620000');
INSERT INTO `siping_city` VALUES ('37', '621200', '陇南市', '620000');
INSERT INTO `siping_city` VALUES ('38', '622900', '临夏回族自治州', '620000');
INSERT INTO `siping_city` VALUES ('39', '623000', '甘南藏族自治州', '620000');
INSERT INTO `siping_city` VALUES ('40', '440100', '广州市', '440000');
INSERT INTO `siping_city` VALUES ('41', '440200', '韶关市', '440000');
INSERT INTO `siping_city` VALUES ('42', '440300', '深圳市', '440000');
INSERT INTO `siping_city` VALUES ('43', '440400', '珠海市', '440000');
INSERT INTO `siping_city` VALUES ('44', '440500', '汕头市', '440000');
INSERT INTO `siping_city` VALUES ('45', '440600', '佛山市', '440000');
INSERT INTO `siping_city` VALUES ('46', '440700', '江门市', '440000');
INSERT INTO `siping_city` VALUES ('47', '440800', '湛江市', '440000');
INSERT INTO `siping_city` VALUES ('48', '440900', '茂名市', '440000');
INSERT INTO `siping_city` VALUES ('49', '441200', '肇庆市', '440000');
INSERT INTO `siping_city` VALUES ('50', '441300', '惠州市', '440000');
INSERT INTO `siping_city` VALUES ('51', '441400', '梅州市', '440000');
INSERT INTO `siping_city` VALUES ('52', '441500', '汕尾市', '440000');
INSERT INTO `siping_city` VALUES ('53', '441600', '河源市', '440000');
INSERT INTO `siping_city` VALUES ('54', '441700', '阳江市', '440000');
INSERT INTO `siping_city` VALUES ('55', '441800', '清远市', '440000');
INSERT INTO `siping_city` VALUES ('56', '441900', '东莞市', '440000');
INSERT INTO `siping_city` VALUES ('57', '442000', '中山市', '440000');
INSERT INTO `siping_city` VALUES ('58', '445100', '潮州市', '440000');
INSERT INTO `siping_city` VALUES ('59', '445200', '揭阳市', '440000');
INSERT INTO `siping_city` VALUES ('60', '445300', '云浮市', '440000');
INSERT INTO `siping_city` VALUES ('61', '450100', '南宁市', '450000');
INSERT INTO `siping_city` VALUES ('62', '450200', '柳州市', '450000');
INSERT INTO `siping_city` VALUES ('63', '450300', '桂林市', '450000');
INSERT INTO `siping_city` VALUES ('64', '450400', '梧州市', '450000');
INSERT INTO `siping_city` VALUES ('65', '450500', '北海市', '450000');
INSERT INTO `siping_city` VALUES ('66', '450600', '防城港市', '450000');
INSERT INTO `siping_city` VALUES ('67', '450700', '钦州市', '450000');
INSERT INTO `siping_city` VALUES ('68', '450800', '贵港市', '450000');
INSERT INTO `siping_city` VALUES ('69', '450900', '玉林市', '450000');
INSERT INTO `siping_city` VALUES ('70', '451000', '百色市', '450000');
INSERT INTO `siping_city` VALUES ('71', '451100', '贺州市', '450000');
INSERT INTO `siping_city` VALUES ('72', '451200', '河池市', '450000');
INSERT INTO `siping_city` VALUES ('73', '451300', '来宾市', '450000');
INSERT INTO `siping_city` VALUES ('74', '451400', '崇左市', '450000');
INSERT INTO `siping_city` VALUES ('75', '520100', '贵阳市', '520000');
INSERT INTO `siping_city` VALUES ('76', '520200', '六盘水市', '520000');
INSERT INTO `siping_city` VALUES ('77', '520300', '遵义市', '520000');
INSERT INTO `siping_city` VALUES ('78', '520400', '安顺市', '520000');
INSERT INTO `siping_city` VALUES ('79', '520500', '毕节市', '520000');
INSERT INTO `siping_city` VALUES ('80', '520600', '铜仁市', '520000');
INSERT INTO `siping_city` VALUES ('81', '522300', '黔西南布依族苗族自治州', '520000');
INSERT INTO `siping_city` VALUES ('82', '522600', '黔东南苗族侗族自治州', '520000');
INSERT INTO `siping_city` VALUES ('83', '522700', '黔南布依族苗族自治州', '520000');
INSERT INTO `siping_city` VALUES ('84', '460100', '海口市', '460000');
INSERT INTO `siping_city` VALUES ('85', '460200', '三亚市', '460000');
INSERT INTO `siping_city` VALUES ('86', '460300', '三沙市', '460000');
INSERT INTO `siping_city` VALUES ('87', '130100', '石家庄市', '130000');
INSERT INTO `siping_city` VALUES ('88', '130200', '唐山市', '130000');
INSERT INTO `siping_city` VALUES ('89', '130300', '秦皇岛市', '130000');
INSERT INTO `siping_city` VALUES ('90', '130400', '邯郸市', '130000');
INSERT INTO `siping_city` VALUES ('91', '130500', '邢台市', '130000');
INSERT INTO `siping_city` VALUES ('92', '130600', '保定市', '130000');
INSERT INTO `siping_city` VALUES ('93', '130700', '张家口市', '130000');
INSERT INTO `siping_city` VALUES ('94', '130800', '承德市', '130000');
INSERT INTO `siping_city` VALUES ('95', '130900', '沧州市', '130000');
INSERT INTO `siping_city` VALUES ('96', '131000', '廊坊市', '130000');
INSERT INTO `siping_city` VALUES ('97', '131100', '衡水市', '130000');
INSERT INTO `siping_city` VALUES ('98', '230100', '哈尔滨市', '230000');
INSERT INTO `siping_city` VALUES ('99', '230200', '齐齐哈尔市', '230000');
INSERT INTO `siping_city` VALUES ('100', '230300', '鸡西市', '230000');
INSERT INTO `siping_city` VALUES ('101', '230400', '鹤岗市', '230000');
INSERT INTO `siping_city` VALUES ('102', '230500', '双鸭山市', '230000');
INSERT INTO `siping_city` VALUES ('103', '230600', '大庆市', '230000');
INSERT INTO `siping_city` VALUES ('104', '230700', '伊春市', '230000');
INSERT INTO `siping_city` VALUES ('105', '230800', '佳木斯市', '230000');
INSERT INTO `siping_city` VALUES ('106', '230900', '七台河市', '230000');
INSERT INTO `siping_city` VALUES ('107', '231000', '牡丹江市', '230000');
INSERT INTO `siping_city` VALUES ('108', '231100', '黑河市', '230000');
INSERT INTO `siping_city` VALUES ('109', '231200', '绥化市', '230000');
INSERT INTO `siping_city` VALUES ('110', '232700', '大兴安岭地区', '230000');
INSERT INTO `siping_city` VALUES ('111', '410100', '郑州市', '410000');
INSERT INTO `siping_city` VALUES ('112', '410200', '开封市', '410000');
INSERT INTO `siping_city` VALUES ('113', '410300', '洛阳市', '410000');
INSERT INTO `siping_city` VALUES ('114', '410400', '平顶山市', '410000');
INSERT INTO `siping_city` VALUES ('115', '410500', '安阳市', '410000');
INSERT INTO `siping_city` VALUES ('116', '410600', '鹤壁市', '410000');
INSERT INTO `siping_city` VALUES ('117', '410700', '新乡市', '410000');
INSERT INTO `siping_city` VALUES ('118', '410800', '焦作市', '410000');
INSERT INTO `siping_city` VALUES ('119', '410900', '濮阳市', '410000');
INSERT INTO `siping_city` VALUES ('120', '411000', '许昌市', '410000');
INSERT INTO `siping_city` VALUES ('121', '411100', '漯河市', '410000');
INSERT INTO `siping_city` VALUES ('122', '411200', '三门峡市', '410000');
INSERT INTO `siping_city` VALUES ('123', '411300', '南阳市', '410000');
INSERT INTO `siping_city` VALUES ('124', '411400', '商丘市', '410000');
INSERT INTO `siping_city` VALUES ('125', '411500', '信阳市', '410000');
INSERT INTO `siping_city` VALUES ('126', '411600', '周口市', '410000');
INSERT INTO `siping_city` VALUES ('127', '411700', '驻马店市', '410000');
INSERT INTO `siping_city` VALUES ('128', '420100', '武汉市', '420000');
INSERT INTO `siping_city` VALUES ('129', '420200', '黄石市', '420000');
INSERT INTO `siping_city` VALUES ('130', '420300', '十堰市', '420000');
INSERT INTO `siping_city` VALUES ('131', '420500', '宜昌市', '420000');
INSERT INTO `siping_city` VALUES ('132', '420600', '襄阳市', '420000');
INSERT INTO `siping_city` VALUES ('133', '420700', '鄂州市', '420000');
INSERT INTO `siping_city` VALUES ('134', '420800', '荆门市', '420000');
INSERT INTO `siping_city` VALUES ('135', '420900', '孝感市', '420000');
INSERT INTO `siping_city` VALUES ('136', '421000', '荆州市', '420000');
INSERT INTO `siping_city` VALUES ('137', '421100', '黄冈市', '420000');
INSERT INTO `siping_city` VALUES ('138', '421200', '咸宁市', '420000');
INSERT INTO `siping_city` VALUES ('139', '421300', '随州市', '420000');
INSERT INTO `siping_city` VALUES ('140', '422800', '恩施土家族苗族自治州', '420000');
INSERT INTO `siping_city` VALUES ('141', '430100', '长沙市', '430000');
INSERT INTO `siping_city` VALUES ('142', '430200', '株洲市', '430000');
INSERT INTO `siping_city` VALUES ('143', '430300', '湘潭市', '430000');
INSERT INTO `siping_city` VALUES ('144', '430400', '衡阳市', '430000');
INSERT INTO `siping_city` VALUES ('145', '430500', '邵阳市', '430000');
INSERT INTO `siping_city` VALUES ('146', '430600', '岳阳市', '430000');
INSERT INTO `siping_city` VALUES ('147', '430700', '常德市', '430000');
INSERT INTO `siping_city` VALUES ('148', '430800', '张家界市', '430000');
INSERT INTO `siping_city` VALUES ('149', '430900', '益阳市', '430000');
INSERT INTO `siping_city` VALUES ('150', '431000', '郴州市', '430000');
INSERT INTO `siping_city` VALUES ('151', '431100', '永州市', '430000');
INSERT INTO `siping_city` VALUES ('152', '431200', '怀化市', '430000');
INSERT INTO `siping_city` VALUES ('153', '431300', '娄底市', '430000');
INSERT INTO `siping_city` VALUES ('154', '433100', '湘西土家族苗族自治州', '430000');
INSERT INTO `siping_city` VALUES ('155', '320100', '南京市', '320000');
INSERT INTO `siping_city` VALUES ('156', '320200', '无锡市', '320000');
INSERT INTO `siping_city` VALUES ('157', '320300', '徐州市', '320000');
INSERT INTO `siping_city` VALUES ('158', '320400', '常州市', '320000');
INSERT INTO `siping_city` VALUES ('159', '320500', '苏州市', '320000');
INSERT INTO `siping_city` VALUES ('160', '320600', '南通市', '320000');
INSERT INTO `siping_city` VALUES ('161', '320700', '连云港市', '320000');
INSERT INTO `siping_city` VALUES ('162', '320800', '淮安市', '320000');
INSERT INTO `siping_city` VALUES ('163', '320900', '盐城市', '320000');
INSERT INTO `siping_city` VALUES ('164', '321000', '扬州市', '320000');
INSERT INTO `siping_city` VALUES ('165', '321100', '镇江市', '320000');
INSERT INTO `siping_city` VALUES ('166', '321200', '泰州市', '320000');
INSERT INTO `siping_city` VALUES ('167', '321300', '宿迁市', '320000');
INSERT INTO `siping_city` VALUES ('168', '360100', '南昌市', '360000');
INSERT INTO `siping_city` VALUES ('169', '360200', '景德镇市', '360000');
INSERT INTO `siping_city` VALUES ('170', '360300', '萍乡市', '360000');
INSERT INTO `siping_city` VALUES ('171', '360400', '九江市', '360000');
INSERT INTO `siping_city` VALUES ('172', '360500', '新余市', '360000');
INSERT INTO `siping_city` VALUES ('173', '360600', '鹰潭市', '360000');
INSERT INTO `siping_city` VALUES ('174', '360700', '赣州市', '360000');
INSERT INTO `siping_city` VALUES ('175', '360800', '吉安市', '360000');
INSERT INTO `siping_city` VALUES ('176', '360900', '宜春市', '360000');
INSERT INTO `siping_city` VALUES ('177', '361000', '抚州市', '360000');
INSERT INTO `siping_city` VALUES ('178', '361100', '上饶市', '360000');
INSERT INTO `siping_city` VALUES ('179', '220100', '长春市', '220000');
INSERT INTO `siping_city` VALUES ('180', '220200', '吉林市', '220000');
INSERT INTO `siping_city` VALUES ('181', '220300', '四平市', '220000');
INSERT INTO `siping_city` VALUES ('182', '220400', '辽源市', '220000');
INSERT INTO `siping_city` VALUES ('183', '220500', '通化市', '220000');
INSERT INTO `siping_city` VALUES ('184', '220600', '白山市', '220000');
INSERT INTO `siping_city` VALUES ('185', '220700', '松原市', '220000');
INSERT INTO `siping_city` VALUES ('186', '220800', '白城市', '220000');
INSERT INTO `siping_city` VALUES ('187', '222400', '延边朝鲜族自治州', '220000');
INSERT INTO `siping_city` VALUES ('188', '210100', '沈阳市', '210000');
INSERT INTO `siping_city` VALUES ('189', '210200', '大连市', '210000');
INSERT INTO `siping_city` VALUES ('190', '210300', '鞍山市', '210000');
INSERT INTO `siping_city` VALUES ('191', '210400', '抚顺市', '210000');
INSERT INTO `siping_city` VALUES ('192', '210500', '本溪市', '210000');
INSERT INTO `siping_city` VALUES ('193', '210600', '丹东市', '210000');
INSERT INTO `siping_city` VALUES ('194', '210700', '锦州市', '210000');
INSERT INTO `siping_city` VALUES ('195', '210800', '营口市', '210000');
INSERT INTO `siping_city` VALUES ('196', '210900', '阜新市', '210000');
INSERT INTO `siping_city` VALUES ('197', '211000', '辽阳市', '210000');
INSERT INTO `siping_city` VALUES ('198', '211100', '盘锦市', '210000');
INSERT INTO `siping_city` VALUES ('199', '211200', '铁岭市', '210000');
INSERT INTO `siping_city` VALUES ('200', '211300', '朝阳市', '210000');
INSERT INTO `siping_city` VALUES ('201', '211400', '葫芦岛市', '210000');
INSERT INTO `siping_city` VALUES ('202', '150100', '呼和浩特市', '150000');
INSERT INTO `siping_city` VALUES ('203', '150200', '包头市', '150000');
INSERT INTO `siping_city` VALUES ('204', '150300', '乌海市', '150000');
INSERT INTO `siping_city` VALUES ('205', '150400', '赤峰市', '150000');
INSERT INTO `siping_city` VALUES ('206', '150500', '通辽市', '150000');
INSERT INTO `siping_city` VALUES ('207', '150600', '鄂尔多斯市', '150000');
INSERT INTO `siping_city` VALUES ('208', '150700', '呼伦贝尔市', '150000');
INSERT INTO `siping_city` VALUES ('209', '150800', '巴彦淖尔市', '150000');
INSERT INTO `siping_city` VALUES ('210', '150900', '乌兰察布市', '150000');
INSERT INTO `siping_city` VALUES ('211', '152200', '兴安盟', '150000');
INSERT INTO `siping_city` VALUES ('212', '152500', '锡林郭勒盟', '150000');
INSERT INTO `siping_city` VALUES ('213', '152900', '阿拉善盟', '150000');
INSERT INTO `siping_city` VALUES ('214', '640100', '银川市', '640000');
INSERT INTO `siping_city` VALUES ('215', '640200', '石嘴山市', '640000');
INSERT INTO `siping_city` VALUES ('216', '640300', '吴忠市', '640000');
INSERT INTO `siping_city` VALUES ('217', '640400', '固原市', '640000');
INSERT INTO `siping_city` VALUES ('218', '640500', '中卫市', '640000');
INSERT INTO `siping_city` VALUES ('219', '630100', '西宁市', '630000');
INSERT INTO `siping_city` VALUES ('220', '630200', '海东市', '630000');
INSERT INTO `siping_city` VALUES ('221', '632200', '海北藏族自治州', '630000');
INSERT INTO `siping_city` VALUES ('222', '632300', '黄南藏族自治州', '630000');
INSERT INTO `siping_city` VALUES ('223', '632500', '海南藏族自治州', '630000');
INSERT INTO `siping_city` VALUES ('224', '632600', '果洛藏族自治州', '630000');
INSERT INTO `siping_city` VALUES ('225', '632700', '玉树藏族自治州', '630000');
INSERT INTO `siping_city` VALUES ('226', '632800', '海西蒙古族藏族自治州', '630000');
INSERT INTO `siping_city` VALUES ('227', '370100', '济南市', '370000');
INSERT INTO `siping_city` VALUES ('228', '370200', '青岛市', '370000');
INSERT INTO `siping_city` VALUES ('229', '370300', '淄博市', '370000');
INSERT INTO `siping_city` VALUES ('230', '370400', '枣庄市', '370000');
INSERT INTO `siping_city` VALUES ('231', '370500', '东营市', '370000');
INSERT INTO `siping_city` VALUES ('232', '370600', '烟台市', '370000');
INSERT INTO `siping_city` VALUES ('233', '370700', '潍坊市', '370000');
INSERT INTO `siping_city` VALUES ('234', '370800', '济宁市', '370000');
INSERT INTO `siping_city` VALUES ('235', '370900', '泰安市', '370000');
INSERT INTO `siping_city` VALUES ('236', '371000', '威海市', '370000');
INSERT INTO `siping_city` VALUES ('237', '371100', '日照市', '370000');
INSERT INTO `siping_city` VALUES ('238', '371200', '莱芜市', '370000');
INSERT INTO `siping_city` VALUES ('239', '371300', '临沂市', '370000');
INSERT INTO `siping_city` VALUES ('240', '371400', '德州市', '370000');
INSERT INTO `siping_city` VALUES ('241', '371500', '聊城市', '370000');
INSERT INTO `siping_city` VALUES ('242', '371600', '滨州市', '370000');
INSERT INTO `siping_city` VALUES ('243', '371700', '菏泽市', '370000');
INSERT INTO `siping_city` VALUES ('244', '140100', '太原市', '140000');
INSERT INTO `siping_city` VALUES ('245', '140200', '大同市', '140000');
INSERT INTO `siping_city` VALUES ('246', '140300', '阳泉市', '140000');
INSERT INTO `siping_city` VALUES ('247', '140400', '长治市', '140000');
INSERT INTO `siping_city` VALUES ('248', '140500', '晋城市', '140000');
INSERT INTO `siping_city` VALUES ('249', '140600', '朔州市', '140000');
INSERT INTO `siping_city` VALUES ('250', '140700', '晋中市', '140000');
INSERT INTO `siping_city` VALUES ('251', '140800', '运城市', '140000');
INSERT INTO `siping_city` VALUES ('252', '140900', '忻州市', '140000');
INSERT INTO `siping_city` VALUES ('253', '141000', '临汾市', '140000');
INSERT INTO `siping_city` VALUES ('254', '141100', '吕梁市', '140000');
INSERT INTO `siping_city` VALUES ('255', '610100', '西安市', '610000');
INSERT INTO `siping_city` VALUES ('256', '610200', '铜川市', '610000');
INSERT INTO `siping_city` VALUES ('257', '610300', '宝鸡市', '610000');
INSERT INTO `siping_city` VALUES ('258', '610400', '咸阳市', '610000');
INSERT INTO `siping_city` VALUES ('259', '610500', '渭南市', '610000');
INSERT INTO `siping_city` VALUES ('260', '610600', '延安市', '610000');
INSERT INTO `siping_city` VALUES ('261', '610700', '汉中市', '610000');
INSERT INTO `siping_city` VALUES ('262', '610800', '榆林市', '610000');
INSERT INTO `siping_city` VALUES ('263', '610900', '安康市', '610000');
INSERT INTO `siping_city` VALUES ('264', '611000', '商洛市', '610000');
INSERT INTO `siping_city` VALUES ('265', '510100', '成都市', '510000');
INSERT INTO `siping_city` VALUES ('266', '510300', '自贡市', '510000');
INSERT INTO `siping_city` VALUES ('267', '510400', '攀枝花市', '510000');
INSERT INTO `siping_city` VALUES ('268', '510500', '泸州市', '510000');
INSERT INTO `siping_city` VALUES ('269', '510600', '德阳市', '510000');
INSERT INTO `siping_city` VALUES ('270', '510700', '绵阳市', '510000');
INSERT INTO `siping_city` VALUES ('271', '510800', '广元市', '510000');
INSERT INTO `siping_city` VALUES ('272', '510900', '遂宁市', '510000');
INSERT INTO `siping_city` VALUES ('273', '511000', '内江市', '510000');
INSERT INTO `siping_city` VALUES ('274', '511100', '乐山市', '510000');
INSERT INTO `siping_city` VALUES ('275', '511300', '南充市', '510000');
INSERT INTO `siping_city` VALUES ('276', '511400', '眉山市', '510000');
INSERT INTO `siping_city` VALUES ('277', '511500', '宜宾市', '510000');
INSERT INTO `siping_city` VALUES ('278', '511600', '广安市', '510000');
INSERT INTO `siping_city` VALUES ('279', '511700', '达州市', '510000');
INSERT INTO `siping_city` VALUES ('280', '511800', '雅安市', '510000');
INSERT INTO `siping_city` VALUES ('281', '511900', '巴中市', '510000');
INSERT INTO `siping_city` VALUES ('282', '512000', '资阳市', '510000');
INSERT INTO `siping_city` VALUES ('283', '513200', '阿坝藏族羌族自治州', '510000');
INSERT INTO `siping_city` VALUES ('284', '513300', '甘孜藏族自治州', '510000');
INSERT INTO `siping_city` VALUES ('285', '513400', '凉山彝族自治州', '510000');
INSERT INTO `siping_city` VALUES ('286', '650100', '乌鲁木齐市', '650000');
INSERT INTO `siping_city` VALUES ('287', '650200', '克拉玛依市', '650000');
INSERT INTO `siping_city` VALUES ('288', '652100', '吐鲁番地区', '650000');
INSERT INTO `siping_city` VALUES ('289', '652200', '哈密地区', '650000');
INSERT INTO `siping_city` VALUES ('290', '652300', '昌吉回族自治州', '650000');
INSERT INTO `siping_city` VALUES ('291', '652700', '博尔塔拉蒙古自治州', '650000');
INSERT INTO `siping_city` VALUES ('292', '652800', '巴音郭楞蒙古自治州', '650000');
INSERT INTO `siping_city` VALUES ('293', '652900', '阿克苏地区', '650000');
INSERT INTO `siping_city` VALUES ('294', '653000', '克孜勒苏柯尔克孜自治州', '650000');
INSERT INTO `siping_city` VALUES ('295', '653100', '喀什地区', '650000');
INSERT INTO `siping_city` VALUES ('296', '653200', '和田地区', '650000');
INSERT INTO `siping_city` VALUES ('297', '654000', '伊犁哈萨克自治州', '650000');
INSERT INTO `siping_city` VALUES ('298', '654200', '塔城地区', '650000');
INSERT INTO `siping_city` VALUES ('299', '654300', '阿勒泰地区', '650000');
INSERT INTO `siping_city` VALUES ('300', '540100', '拉萨市', '540000');
INSERT INTO `siping_city` VALUES ('301', '540200', '日喀则市', '540000');
INSERT INTO `siping_city` VALUES ('302', '542100', '昌都地区', '540000');
INSERT INTO `siping_city` VALUES ('303', '542200', '山南地区', '540000');
INSERT INTO `siping_city` VALUES ('304', '542400', '那曲地区', '540000');
INSERT INTO `siping_city` VALUES ('305', '542500', '阿里地区', '540000');
INSERT INTO `siping_city` VALUES ('306', '542600', '林芝地区', '540000');
INSERT INTO `siping_city` VALUES ('307', '530100', '昆明市', '530000');
INSERT INTO `siping_city` VALUES ('308', '530300', '曲靖市', '530000');
INSERT INTO `siping_city` VALUES ('309', '530400', '玉溪市', '530000');
INSERT INTO `siping_city` VALUES ('310', '530500', '保山市', '530000');
INSERT INTO `siping_city` VALUES ('311', '530600', '昭通市', '530000');
INSERT INTO `siping_city` VALUES ('312', '530700', '丽江市', '530000');
INSERT INTO `siping_city` VALUES ('313', '530800', '普洱市', '530000');
INSERT INTO `siping_city` VALUES ('314', '530900', '临沧市', '530000');
INSERT INTO `siping_city` VALUES ('315', '532300', '楚雄彝族自治州', '530000');
INSERT INTO `siping_city` VALUES ('316', '532500', '红河哈尼族彝族自治州', '530000');
INSERT INTO `siping_city` VALUES ('317', '532600', '文山壮族苗族自治州', '530000');
INSERT INTO `siping_city` VALUES ('318', '532800', '西双版纳傣族自治州', '530000');
INSERT INTO `siping_city` VALUES ('319', '532900', '大理白族自治州', '530000');
INSERT INTO `siping_city` VALUES ('320', '533100', '德宏傣族景颇族自治州', '530000');
INSERT INTO `siping_city` VALUES ('321', '533300', '怒江傈僳族自治州', '530000');
INSERT INTO `siping_city` VALUES ('322', '533400', '迪庆藏族自治州', '530000');
INSERT INTO `siping_city` VALUES ('323', '330100', '杭州市', '330000');
INSERT INTO `siping_city` VALUES ('324', '330200', '宁波市', '330000');
INSERT INTO `siping_city` VALUES ('325', '330300', '温州市', '330000');
INSERT INTO `siping_city` VALUES ('326', '330400', '嘉兴市', '330000');
INSERT INTO `siping_city` VALUES ('327', '330500', '湖州市', '330000');
INSERT INTO `siping_city` VALUES ('328', '330600', '绍兴市', '330000');
INSERT INTO `siping_city` VALUES ('329', '330700', '金华市', '330000');
INSERT INTO `siping_city` VALUES ('330', '330800', '衢州市', '330000');
INSERT INTO `siping_city` VALUES ('331', '330900', '舟山市', '330000');
INSERT INTO `siping_city` VALUES ('332', '331000', '台州市', '330000');
INSERT INTO `siping_city` VALUES ('333', '331100', '丽水市', '330000');

-- ----------------------------
-- Table structure for siping_county
-- ----------------------------
DROP TABLE IF EXISTS `siping_county`;
CREATE TABLE `siping_county` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `county_id` int(50) DEFAULT NULL,
  `county` varchar(60) DEFAULT NULL,
  `parent_id` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2853 DEFAULT CHARSET=utf8 COMMENT='地区/县';

-- ----------------------------
-- Records of siping_county
-- ----------------------------
INSERT INTO `siping_county` VALUES ('1', '340103', '庐阳区', '340100');
INSERT INTO `siping_county` VALUES ('2', '340102', '瑶海区', '340100');
INSERT INTO `siping_county` VALUES ('3', '340111', '包河区', '340100');
INSERT INTO `siping_county` VALUES ('4', '340104', '蜀山区', '340100');
INSERT INTO `siping_county` VALUES ('5', '340122', '肥东县', '340100');
INSERT INTO `siping_county` VALUES ('6', '340121', '长丰县', '340100');
INSERT INTO `siping_county` VALUES ('7', '340123', '肥西县', '340100');
INSERT INTO `siping_county` VALUES ('8', '340124', '庐江县', '340100');
INSERT INTO `siping_county` VALUES ('9', '340202', '镜湖区', '340200');
INSERT INTO `siping_county` VALUES ('10', '340181', '巢湖市', '340100');
INSERT INTO `siping_county` VALUES ('11', '340208', '三山区', '340200');
INSERT INTO `siping_county` VALUES ('12', '340221', '芜湖县', '340200');
INSERT INTO `siping_county` VALUES ('13', '340203', '弋江区', '340200');
INSERT INTO `siping_county` VALUES ('14', '340207', '鸠江区', '340200');
INSERT INTO `siping_county` VALUES ('15', '340222', '繁昌县', '340200');
INSERT INTO `siping_county` VALUES ('16', '340223', '南陵县', '340200');
INSERT INTO `siping_county` VALUES ('17', '340225', '无为县', '340200');
INSERT INTO `siping_county` VALUES ('18', '340303', '蚌山区', '340300');
INSERT INTO `siping_county` VALUES ('19', '340321', '怀远县', '340300');
INSERT INTO `siping_county` VALUES ('20', '340304', '禹会区', '340300');
INSERT INTO `siping_county` VALUES ('21', '340311', '淮上区', '340300');
INSERT INTO `siping_county` VALUES ('22', '340302', '龙子湖区', '340300');
INSERT INTO `siping_county` VALUES ('23', '340323', '固镇县', '340300');
INSERT INTO `siping_county` VALUES ('24', '340322', '五河县', '340300');
INSERT INTO `siping_county` VALUES ('25', '340402', '大通区', '340400');
INSERT INTO `siping_county` VALUES ('26', '340406', '潘集区', '340400');
INSERT INTO `siping_county` VALUES ('27', '340405', '八公山区', '340400');
INSERT INTO `siping_county` VALUES ('28', '340403', '田家庵区', '340400');
INSERT INTO `siping_county` VALUES ('29', '340404', '谢家集区', '340400');
INSERT INTO `siping_county` VALUES ('30', '340421', '凤台县', '340400');
INSERT INTO `siping_county` VALUES ('31', '340504', '雨山区', '340500');
INSERT INTO `siping_county` VALUES ('32', '340503', '花山区', '340500');
INSERT INTO `siping_county` VALUES ('33', '340506', '博望区', '340500');
INSERT INTO `siping_county` VALUES ('34', '340522', '含山县', '340500');
INSERT INTO `siping_county` VALUES ('35', '340521', '当涂县', '340500');
INSERT INTO `siping_county` VALUES ('36', '340523', '和县', '340500');
INSERT INTO `siping_county` VALUES ('37', '340602', '杜集区', '340600');
INSERT INTO `siping_county` VALUES ('38', '340603', '相山区', '340600');
INSERT INTO `siping_county` VALUES ('39', '340604', '烈山区', '340600');
INSERT INTO `siping_county` VALUES ('40', '340621', '濉溪县', '340600');
INSERT INTO `siping_county` VALUES ('41', '340702', '铜官山区', '340700');
INSERT INTO `siping_county` VALUES ('42', '340703', '狮子山区', '340700');
INSERT INTO `siping_county` VALUES ('43', '340711', '郊区', '340700');
INSERT INTO `siping_county` VALUES ('44', '340721', '铜陵县', '340700');
INSERT INTO `siping_county` VALUES ('45', '340802', '迎江区', '340800');
INSERT INTO `siping_county` VALUES ('46', '340803', '大观区', '340800');
INSERT INTO `siping_county` VALUES ('47', '340811', '宜秀区', '340800');
INSERT INTO `siping_county` VALUES ('48', '340822', '怀宁县', '340800');
INSERT INTO `siping_county` VALUES ('49', '340823', '枞阳县', '340800');
INSERT INTO `siping_county` VALUES ('50', '340824', '潜山县', '340800');
INSERT INTO `siping_county` VALUES ('51', '340825', '太湖县', '340800');
INSERT INTO `siping_county` VALUES ('52', '340826', '宿松县', '340800');
INSERT INTO `siping_county` VALUES ('53', '340827', '望江县', '340800');
INSERT INTO `siping_county` VALUES ('54', '340828', '岳西县', '340800');
INSERT INTO `siping_county` VALUES ('55', '340881', '桐城市', '340800');
INSERT INTO `siping_county` VALUES ('56', '341002', '屯溪区', '341000');
INSERT INTO `siping_county` VALUES ('57', '341003', '黄山区', '341000');
INSERT INTO `siping_county` VALUES ('58', '341004', '徽州区', '341000');
INSERT INTO `siping_county` VALUES ('59', '341021', '歙县', '341000');
INSERT INTO `siping_county` VALUES ('60', '341022', '休宁县', '341000');
INSERT INTO `siping_county` VALUES ('61', '341023', '黟县', '341000');
INSERT INTO `siping_county` VALUES ('62', '341024', '祁门县', '341000');
INSERT INTO `siping_county` VALUES ('63', '341102', '琅琊区', '341100');
INSERT INTO `siping_county` VALUES ('64', '341125', '定远县', '341100');
INSERT INTO `siping_county` VALUES ('65', '341126', '凤阳县', '341100');
INSERT INTO `siping_county` VALUES ('66', '341122', '来安县', '341100');
INSERT INTO `siping_county` VALUES ('67', '341103', '南谯区', '341100');
INSERT INTO `siping_county` VALUES ('68', '341124', '全椒县', '341100');
INSERT INTO `siping_county` VALUES ('69', '341181', '天长市', '341100');
INSERT INTO `siping_county` VALUES ('70', '341182', '明光市', '341100');
INSERT INTO `siping_county` VALUES ('71', '341202', '颍州区', '341200');
INSERT INTO `siping_county` VALUES ('72', '341203', '颍东区', '341200');
INSERT INTO `siping_county` VALUES ('73', '341221', '临泉县', '341200');
INSERT INTO `siping_county` VALUES ('74', '341225', '阜南县', '341200');
INSERT INTO `siping_county` VALUES ('75', '341204', '颍泉区', '341200');
INSERT INTO `siping_county` VALUES ('76', '341222', '太和县', '341200');
INSERT INTO `siping_county` VALUES ('77', '341226', '颍上县', '341200');
INSERT INTO `siping_county` VALUES ('78', '341302', '埇桥区', '341300');
INSERT INTO `siping_county` VALUES ('79', '341322', '萧县', '341300');
INSERT INTO `siping_county` VALUES ('80', '341323', '灵璧县', '341300');
INSERT INTO `siping_county` VALUES ('81', '341282', '界首市', '341200');
INSERT INTO `siping_county` VALUES ('82', '341324', '泗县', '341300');
INSERT INTO `siping_county` VALUES ('83', '341321', '砀山县', '341300');
INSERT INTO `siping_county` VALUES ('84', '341502', '金安区', '341500');
INSERT INTO `siping_county` VALUES ('85', '341503', '裕安区', '341500');
INSERT INTO `siping_county` VALUES ('86', '341521', '寿县', '341500');
INSERT INTO `siping_county` VALUES ('87', '341522', '霍邱县', '341500');
INSERT INTO `siping_county` VALUES ('88', '341523', '舒城县', '341500');
INSERT INTO `siping_county` VALUES ('89', '341524', '金寨县', '341500');
INSERT INTO `siping_county` VALUES ('90', '341525', '霍山县', '341500');
INSERT INTO `siping_county` VALUES ('91', '341602', '谯城区', '341600');
INSERT INTO `siping_county` VALUES ('92', '341621', '涡阳县', '341600');
INSERT INTO `siping_county` VALUES ('93', '341622', '蒙城县', '341600');
INSERT INTO `siping_county` VALUES ('94', '341623', '利辛县', '341600');
INSERT INTO `siping_county` VALUES ('95', '341702', '贵池区', '341700');
INSERT INTO `siping_county` VALUES ('96', '341721', '东至县', '341700');
INSERT INTO `siping_county` VALUES ('97', '341722', '石台县', '341700');
INSERT INTO `siping_county` VALUES ('98', '341723', '青阳县', '341700');
INSERT INTO `siping_county` VALUES ('99', '341802', '宣州区', '341800');
INSERT INTO `siping_county` VALUES ('100', '341822', '广德县', '341800');
INSERT INTO `siping_county` VALUES ('101', '341821', '郎溪县', '341800');
INSERT INTO `siping_county` VALUES ('102', '341823', '泾县', '341800');
INSERT INTO `siping_county` VALUES ('103', '341824', '绩溪县', '341800');
INSERT INTO `siping_county` VALUES ('104', '341825', '旌德县', '341800');
INSERT INTO `siping_county` VALUES ('105', '341881', '宁国市', '341800');
INSERT INTO `siping_county` VALUES ('106', '110101', '东城区', '110000');
INSERT INTO `siping_county` VALUES ('107', '110102', '西城区', '110000');
INSERT INTO `siping_county` VALUES ('108', '110105', '朝阳区', '110000');
INSERT INTO `siping_county` VALUES ('109', '110106', '丰台区', '110000');
INSERT INTO `siping_county` VALUES ('110', '110108', '海淀区', '110000');
INSERT INTO `siping_county` VALUES ('111', '110107', '石景山区', '110000');
INSERT INTO `siping_county` VALUES ('112', '110109', '门头沟区', '110000');
INSERT INTO `siping_county` VALUES ('113', '110111', '房山区', '110000');
INSERT INTO `siping_county` VALUES ('114', '110112', '通州区', '110000');
INSERT INTO `siping_county` VALUES ('115', '110113', '顺义区', '110000');
INSERT INTO `siping_county` VALUES ('116', '110114', '昌平区', '110000');
INSERT INTO `siping_county` VALUES ('117', '110115', '大兴区', '110000');
INSERT INTO `siping_county` VALUES ('118', '110116', '怀柔区', '110000');
INSERT INTO `siping_county` VALUES ('119', '110117', '平谷区', '110000');
INSERT INTO `siping_county` VALUES ('120', '110228', '密云县', '110000');
INSERT INTO `siping_county` VALUES ('121', '110229', '延庆县', '110000');
INSERT INTO `siping_county` VALUES ('122', '500101', '万州区', '500000');
INSERT INTO `siping_county` VALUES ('123', '500102', '涪陵区', '500000');
INSERT INTO `siping_county` VALUES ('124', '500103', '渝中区', '500000');
INSERT INTO `siping_county` VALUES ('125', '500104', '大渡口区', '500000');
INSERT INTO `siping_county` VALUES ('126', '500105', '江北区', '500000');
INSERT INTO `siping_county` VALUES ('127', '500106', '沙坪坝区', '500000');
INSERT INTO `siping_county` VALUES ('128', '500107', '九龙坡区', '500000');
INSERT INTO `siping_county` VALUES ('129', '500108', '南岸区', '500000');
INSERT INTO `siping_county` VALUES ('130', '500109', '北碚区', '500000');
INSERT INTO `siping_county` VALUES ('131', '500110', '綦江区', '500000');
INSERT INTO `siping_county` VALUES ('132', '500111', '大足区', '500000');
INSERT INTO `siping_county` VALUES ('133', '500112', '渝北区', '500000');
INSERT INTO `siping_county` VALUES ('134', '500113', '巴南区', '500000');
INSERT INTO `siping_county` VALUES ('135', '500114', '黔江区', '500000');
INSERT INTO `siping_county` VALUES ('136', '500115', '长寿区', '500000');
INSERT INTO `siping_county` VALUES ('137', '500116', '江津区', '500000');
INSERT INTO `siping_county` VALUES ('138', '500117', '合川区', '500000');
INSERT INTO `siping_county` VALUES ('139', '500118', '永川区', '500000');
INSERT INTO `siping_county` VALUES ('140', '500119', '南川区', '500000');
INSERT INTO `siping_county` VALUES ('141', '500120', '璧山区', '500000');
INSERT INTO `siping_county` VALUES ('142', '500151', '铜梁区', '500000');
INSERT INTO `siping_county` VALUES ('143', '500226', '荣昌县', '500000');
INSERT INTO `siping_county` VALUES ('144', '500228', '梁平县', '500000');
INSERT INTO `siping_county` VALUES ('145', '500223', '潼南县', '500000');
INSERT INTO `siping_county` VALUES ('146', '500229', '城口县', '500000');
INSERT INTO `siping_county` VALUES ('147', '500230', '丰都县', '500000');
INSERT INTO `siping_county` VALUES ('148', '500231', '垫江县', '500000');
INSERT INTO `siping_county` VALUES ('149', '500232', '武隆县', '500000');
INSERT INTO `siping_county` VALUES ('150', '500233', '忠县', '500000');
INSERT INTO `siping_county` VALUES ('151', '500234', '开县', '500000');
INSERT INTO `siping_county` VALUES ('152', '500235', '云阳县', '500000');
INSERT INTO `siping_county` VALUES ('153', '500237', '巫山县', '500000');
INSERT INTO `siping_county` VALUES ('154', '500238', '巫溪县', '500000');
INSERT INTO `siping_county` VALUES ('155', '500236', '奉节县', '500000');
INSERT INTO `siping_county` VALUES ('156', '500240', '石柱土家族自治县', '500000');
INSERT INTO `siping_county` VALUES ('157', '500241', '秀山土家族苗族自治县', '500000');
INSERT INTO `siping_county` VALUES ('158', '500242', '酉阳土家族苗族自治县', '500000');
INSERT INTO `siping_county` VALUES ('159', '500243', '彭水苗族土家族自治县', '500000');
INSERT INTO `siping_county` VALUES ('160', '350102', '鼓楼区', '350100');
INSERT INTO `siping_county` VALUES ('161', '350103', '台江区', '350100');
INSERT INTO `siping_county` VALUES ('162', '350104', '仓山区', '350100');
INSERT INTO `siping_county` VALUES ('163', '350105', '马尾区', '350100');
INSERT INTO `siping_county` VALUES ('164', '350121', '闽侯县', '350100');
INSERT INTO `siping_county` VALUES ('165', '350111', '晋安区', '350100');
INSERT INTO `siping_county` VALUES ('166', '350122', '连江县', '350100');
INSERT INTO `siping_county` VALUES ('167', '350123', '罗源县', '350100');
INSERT INTO `siping_county` VALUES ('168', '350124', '闽清县', '350100');
INSERT INTO `siping_county` VALUES ('169', '350125', '永泰县', '350100');
INSERT INTO `siping_county` VALUES ('170', '350128', '平潭县', '350100');
INSERT INTO `siping_county` VALUES ('171', '350181', '福清市', '350100');
INSERT INTO `siping_county` VALUES ('172', '350182', '长乐市', '350100');
INSERT INTO `siping_county` VALUES ('173', '350203', '思明区', '350200');
INSERT INTO `siping_county` VALUES ('174', '350205', '海沧区', '350200');
INSERT INTO `siping_county` VALUES ('175', '350206', '湖里区', '350200');
INSERT INTO `siping_county` VALUES ('176', '350211', '集美区', '350200');
INSERT INTO `siping_county` VALUES ('177', '350212', '同安区', '350200');
INSERT INTO `siping_county` VALUES ('178', '350213', '翔安区', '350200');
INSERT INTO `siping_county` VALUES ('179', '350302', '城厢区', '350300');
INSERT INTO `siping_county` VALUES ('180', '350303', '涵江区', '350300');
INSERT INTO `siping_county` VALUES ('181', '350305', '秀屿区', '350300');
INSERT INTO `siping_county` VALUES ('182', '350304', '荔城区', '350300');
INSERT INTO `siping_county` VALUES ('183', '350322', '仙游县', '350300');
INSERT INTO `siping_county` VALUES ('184', '350402', '梅列区', '350400');
INSERT INTO `siping_county` VALUES ('185', '350403', '三元区', '350400');
INSERT INTO `siping_county` VALUES ('186', '350421', '明溪县', '350400');
INSERT INTO `siping_county` VALUES ('187', '350423', '清流县', '350400');
INSERT INTO `siping_county` VALUES ('188', '350424', '宁化县', '350400');
INSERT INTO `siping_county` VALUES ('189', '350425', '大田县', '350400');
INSERT INTO `siping_county` VALUES ('190', '350426', '尤溪县', '350400');
INSERT INTO `siping_county` VALUES ('191', '350427', '沙县', '350400');
INSERT INTO `siping_county` VALUES ('192', '350428', '将乐县', '350400');
INSERT INTO `siping_county` VALUES ('193', '350430', '建宁县', '350400');
INSERT INTO `siping_county` VALUES ('194', '350429', '泰宁县', '350400');
INSERT INTO `siping_county` VALUES ('195', '350481', '永安市', '350400');
INSERT INTO `siping_county` VALUES ('196', '350502', '鲤城区', '350500');
INSERT INTO `siping_county` VALUES ('197', '350503', '丰泽区', '350500');
INSERT INTO `siping_county` VALUES ('198', '350504', '洛江区', '350500');
INSERT INTO `siping_county` VALUES ('199', '350505', '泉港区', '350500');
INSERT INTO `siping_county` VALUES ('200', '350521', '惠安县', '350500');
INSERT INTO `siping_county` VALUES ('201', '350524', '安溪县', '350500');
INSERT INTO `siping_county` VALUES ('202', '350525', '永春县', '350500');
INSERT INTO `siping_county` VALUES ('203', '350526', '德化县', '350500');
INSERT INTO `siping_county` VALUES ('204', '350527', '金门县', '350500');
INSERT INTO `siping_county` VALUES ('205', '350581', '石狮市', '350500');
INSERT INTO `siping_county` VALUES ('206', '350582', '晋江市', '350500');
INSERT INTO `siping_county` VALUES ('207', '350583', '南安市', '350500');
INSERT INTO `siping_county` VALUES ('208', '350602', '芗城区', '350600');
INSERT INTO `siping_county` VALUES ('209', '350603', '龙文区', '350600');
INSERT INTO `siping_county` VALUES ('210', '350623', '漳浦县', '350600');
INSERT INTO `siping_county` VALUES ('211', '350622', '云霄县', '350600');
INSERT INTO `siping_county` VALUES ('212', '350624', '诏安县', '350600');
INSERT INTO `siping_county` VALUES ('213', '350626', '东山县', '350600');
INSERT INTO `siping_county` VALUES ('214', '350625', '长泰县', '350600');
INSERT INTO `siping_county` VALUES ('215', '350627', '南靖县', '350600');
INSERT INTO `siping_county` VALUES ('216', '350628', '平和县', '350600');
INSERT INTO `siping_county` VALUES ('217', '350629', '华安县', '350600');
INSERT INTO `siping_county` VALUES ('218', '350681', '龙海市', '350600');
INSERT INTO `siping_county` VALUES ('219', '350702', '延平区', '350700');
INSERT INTO `siping_county` VALUES ('220', '350721', '顺昌县', '350700');
INSERT INTO `siping_county` VALUES ('221', '350722', '浦城县', '350700');
INSERT INTO `siping_county` VALUES ('222', '350724', '松溪县', '350700');
INSERT INTO `siping_county` VALUES ('223', '350725', '政和县', '350700');
INSERT INTO `siping_county` VALUES ('224', '350781', '邵武市', '350700');
INSERT INTO `siping_county` VALUES ('225', '350723', '光泽县', '350700');
INSERT INTO `siping_county` VALUES ('226', '350782', '武夷山市', '350700');
INSERT INTO `siping_county` VALUES ('227', '350821', '长汀县', '350800');
INSERT INTO `siping_county` VALUES ('228', '350822', '永定县', '350800');
INSERT INTO `siping_county` VALUES ('229', '350783', '建瓯市', '350700');
INSERT INTO `siping_county` VALUES ('230', '350802', '新罗区', '350800');
INSERT INTO `siping_county` VALUES ('231', '350784', '建阳市', '350700');
INSERT INTO `siping_county` VALUES ('232', '350823', '上杭县', '350800');
INSERT INTO `siping_county` VALUES ('233', '350824', '武平县', '350800');
INSERT INTO `siping_county` VALUES ('234', '350902', '蕉城区', '350900');
INSERT INTO `siping_county` VALUES ('235', '350825', '连城县', '350800');
INSERT INTO `siping_county` VALUES ('236', '350881', '漳平市', '350800');
INSERT INTO `siping_county` VALUES ('237', '350921', '霞浦县', '350900');
INSERT INTO `siping_county` VALUES ('238', '350922', '古田县', '350900');
INSERT INTO `siping_county` VALUES ('239', '350923', '屏南县', '350900');
INSERT INTO `siping_county` VALUES ('240', '350924', '寿宁县', '350900');
INSERT INTO `siping_county` VALUES ('241', '350925', '周宁县', '350900');
INSERT INTO `siping_county` VALUES ('242', '350982', '福鼎市', '350900');
INSERT INTO `siping_county` VALUES ('243', '350926', '柘荣县', '350900');
INSERT INTO `siping_county` VALUES ('244', '350981', '福安市', '350900');
INSERT INTO `siping_county` VALUES ('245', '620103', '七里河区', '620100');
INSERT INTO `siping_county` VALUES ('246', '620102', '城关区', '620100');
INSERT INTO `siping_county` VALUES ('247', '620104', '西固区', '620100');
INSERT INTO `siping_county` VALUES ('248', '620105', '安宁区', '620100');
INSERT INTO `siping_county` VALUES ('249', '620121', '永登县', '620100');
INSERT INTO `siping_county` VALUES ('250', '620111', '红古区', '620100');
INSERT INTO `siping_county` VALUES ('251', '620122', '皋兰县', '620100');
INSERT INTO `siping_county` VALUES ('252', '620123', '榆中县', '620100');
INSERT INTO `siping_county` VALUES ('253', '620302', '金川区', '620300');
INSERT INTO `siping_county` VALUES ('254', '620321', '永昌县', '620300');
INSERT INTO `siping_county` VALUES ('255', '620402', '白银区', '620400');
INSERT INTO `siping_county` VALUES ('256', '620403', '平川区', '620400');
INSERT INTO `siping_county` VALUES ('257', '620421', '靖远县', '620400');
INSERT INTO `siping_county` VALUES ('258', '620422', '会宁县', '620400');
INSERT INTO `siping_county` VALUES ('259', '620423', '景泰县', '620400');
INSERT INTO `siping_county` VALUES ('260', '620502', '秦州区', '620500');
INSERT INTO `siping_county` VALUES ('261', '620503', '麦积区', '620500');
INSERT INTO `siping_county` VALUES ('262', '620521', '清水县', '620500');
INSERT INTO `siping_county` VALUES ('263', '620522', '秦安县', '620500');
INSERT INTO `siping_county` VALUES ('264', '620523', '甘谷县', '620500');
INSERT INTO `siping_county` VALUES ('265', '620524', '武山县', '620500');
INSERT INTO `siping_county` VALUES ('266', '620525', '张家川回族自治县', '620500');
INSERT INTO `siping_county` VALUES ('267', '620602', '凉州区', '620600');
INSERT INTO `siping_county` VALUES ('268', '620622', '古浪县', '620600');
INSERT INTO `siping_county` VALUES ('269', '620621', '民勤县', '620600');
INSERT INTO `siping_county` VALUES ('270', '620623', '天祝藏族自治县', '620600');
INSERT INTO `siping_county` VALUES ('271', '620702', '甘州区', '620700');
INSERT INTO `siping_county` VALUES ('272', '620721', '肃南裕固族自治县', '620700');
INSERT INTO `siping_county` VALUES ('273', '620722', '民乐县', '620700');
INSERT INTO `siping_county` VALUES ('274', '620723', '临泽县', '620700');
INSERT INTO `siping_county` VALUES ('275', '620724', '高台县', '620700');
INSERT INTO `siping_county` VALUES ('276', '620725', '山丹县', '620700');
INSERT INTO `siping_county` VALUES ('277', '620802', '崆峒区', '620800');
INSERT INTO `siping_county` VALUES ('278', '620821', '泾川县', '620800');
INSERT INTO `siping_county` VALUES ('279', '620822', '灵台县', '620800');
INSERT INTO `siping_county` VALUES ('280', '620823', '崇信县', '620800');
INSERT INTO `siping_county` VALUES ('281', '620824', '华亭县', '620800');
INSERT INTO `siping_county` VALUES ('282', '620825', '庄浪县', '620800');
INSERT INTO `siping_county` VALUES ('283', '620826', '静宁县', '620800');
INSERT INTO `siping_county` VALUES ('284', '620902', '肃州区', '620900');
INSERT INTO `siping_county` VALUES ('285', '620921', '金塔县', '620900');
INSERT INTO `siping_county` VALUES ('286', '620922', '瓜州县', '620900');
INSERT INTO `siping_county` VALUES ('287', '620923', '肃北蒙古族自治县', '620900');
INSERT INTO `siping_county` VALUES ('288', '620924', '阿克塞哈萨克族自治县', '620900');
INSERT INTO `siping_county` VALUES ('289', '620981', '玉门市', '620900');
INSERT INTO `siping_county` VALUES ('290', '620982', '敦煌市', '620900');
INSERT INTO `siping_county` VALUES ('291', '621002', '西峰区', '621000');
INSERT INTO `siping_county` VALUES ('292', '621021', '庆城县', '621000');
INSERT INTO `siping_county` VALUES ('293', '621022', '环县', '621000');
INSERT INTO `siping_county` VALUES ('294', '621023', '华池县', '621000');
INSERT INTO `siping_county` VALUES ('295', '621024', '合水县', '621000');
INSERT INTO `siping_county` VALUES ('296', '621025', '正宁县', '621000');
INSERT INTO `siping_county` VALUES ('297', '621026', '宁县', '621000');
INSERT INTO `siping_county` VALUES ('298', '621027', '镇原县', '621000');
INSERT INTO `siping_county` VALUES ('299', '621102', '安定区', '621100');
INSERT INTO `siping_county` VALUES ('300', '621121', '通渭县', '621100');
INSERT INTO `siping_county` VALUES ('301', '621122', '陇西县', '621100');
INSERT INTO `siping_county` VALUES ('302', '621124', '临洮县', '621100');
INSERT INTO `siping_county` VALUES ('303', '621123', '渭源县', '621100');
INSERT INTO `siping_county` VALUES ('304', '621125', '漳县', '621100');
INSERT INTO `siping_county` VALUES ('305', '621126', '岷县', '621100');
INSERT INTO `siping_county` VALUES ('306', '621202', '武都区', '621200');
INSERT INTO `siping_county` VALUES ('307', '621221', '成县', '621200');
INSERT INTO `siping_county` VALUES ('308', '621222', '文县', '621200');
INSERT INTO `siping_county` VALUES ('309', '621223', '宕昌县', '621200');
INSERT INTO `siping_county` VALUES ('310', '621224', '康县', '621200');
INSERT INTO `siping_county` VALUES ('311', '621225', '西和县', '621200');
INSERT INTO `siping_county` VALUES ('312', '621226', '礼县', '621200');
INSERT INTO `siping_county` VALUES ('313', '622901', '临夏市', '622900');
INSERT INTO `siping_county` VALUES ('314', '621228', '两当县', '621200');
INSERT INTO `siping_county` VALUES ('315', '622921', '临夏县', '622900');
INSERT INTO `siping_county` VALUES ('316', '621227', '徽县', '621200');
INSERT INTO `siping_county` VALUES ('317', '622922', '康乐县', '622900');
INSERT INTO `siping_county` VALUES ('318', '622923', '永靖县', '622900');
INSERT INTO `siping_county` VALUES ('319', '622924', '广河县', '622900');
INSERT INTO `siping_county` VALUES ('320', '622925', '和政县', '622900');
INSERT INTO `siping_county` VALUES ('321', '622926', '东乡族自治县', '622900');
INSERT INTO `siping_county` VALUES ('322', '622927', '积石山保安族东乡族撒拉族自治县', '622900');
INSERT INTO `siping_county` VALUES ('323', '623022', '卓尼县', '623000');
INSERT INTO `siping_county` VALUES ('324', '623001', '合作市', '623000');
INSERT INTO `siping_county` VALUES ('325', '623023', '舟曲县', '623000');
INSERT INTO `siping_county` VALUES ('326', '623021', '临潭县', '623000');
INSERT INTO `siping_county` VALUES ('327', '623024', '迭部县', '623000');
INSERT INTO `siping_county` VALUES ('328', '623025', '玛曲县', '623000');
INSERT INTO `siping_county` VALUES ('329', '623026', '碌曲县', '623000');
INSERT INTO `siping_county` VALUES ('330', '623027', '夏河县', '623000');
INSERT INTO `siping_county` VALUES ('331', '440103', '荔湾区', '440100');
INSERT INTO `siping_county` VALUES ('332', '440112', '黄埔区', '440100');
INSERT INTO `siping_county` VALUES ('333', '440104', '越秀区', '440100');
INSERT INTO `siping_county` VALUES ('334', '440105', '海珠区', '440100');
INSERT INTO `siping_county` VALUES ('335', '440111', '白云区', '440100');
INSERT INTO `siping_county` VALUES ('336', '440106', '天河区', '440100');
INSERT INTO `siping_county` VALUES ('337', '440113', '番禺区', '440100');
INSERT INTO `siping_county` VALUES ('338', '440114', '花都区', '440100');
INSERT INTO `siping_county` VALUES ('339', '440115', '南沙区', '440100');
INSERT INTO `siping_county` VALUES ('340', '440116', '萝岗区', '440100');
INSERT INTO `siping_county` VALUES ('341', '440117', '从化区', '440100');
INSERT INTO `siping_county` VALUES ('342', '440118', '增城区', '440100');
INSERT INTO `siping_county` VALUES ('343', '440203', '武江区', '440200');
INSERT INTO `siping_county` VALUES ('344', '440204', '浈江区', '440200');
INSERT INTO `siping_county` VALUES ('345', '440205', '曲江区', '440200');
INSERT INTO `siping_county` VALUES ('346', '440222', '始兴县', '440200');
INSERT INTO `siping_county` VALUES ('347', '440224', '仁化县', '440200');
INSERT INTO `siping_county` VALUES ('348', '440229', '翁源县', '440200');
INSERT INTO `siping_county` VALUES ('349', '440232', '乳源瑶族自治县', '440200');
INSERT INTO `siping_county` VALUES ('350', '440233', '新丰县', '440200');
INSERT INTO `siping_county` VALUES ('351', '440281', '乐昌市', '440200');
INSERT INTO `siping_county` VALUES ('352', '440282', '南雄市', '440200');
INSERT INTO `siping_county` VALUES ('353', '440303', '罗湖区', '440300');
INSERT INTO `siping_county` VALUES ('354', '440304', '福田区', '440300');
INSERT INTO `siping_county` VALUES ('355', '440305', '南山区', '440300');
INSERT INTO `siping_county` VALUES ('356', '440306', '宝安区', '440300');
INSERT INTO `siping_county` VALUES ('357', '440307', '龙岗区', '440300');
INSERT INTO `siping_county` VALUES ('358', '440308', '盐田区', '440300');
INSERT INTO `siping_county` VALUES ('359', '440402', '香洲区', '440400');
INSERT INTO `siping_county` VALUES ('360', '440403', '斗门区', '440400');
INSERT INTO `siping_county` VALUES ('361', '440404', '金湾区', '440400');
INSERT INTO `siping_county` VALUES ('362', '440507', '龙湖区', '440500');
INSERT INTO `siping_county` VALUES ('363', '440511', '金平区', '440500');
INSERT INTO `siping_county` VALUES ('364', '440512', '濠江区', '440500');
INSERT INTO `siping_county` VALUES ('365', '440513', '潮阳区', '440500');
INSERT INTO `siping_county` VALUES ('366', '440514', '潮南区', '440500');
INSERT INTO `siping_county` VALUES ('367', '440515', '澄海区', '440500');
INSERT INTO `siping_county` VALUES ('368', '440523', '南澳县', '440500');
INSERT INTO `siping_county` VALUES ('369', '440604', '禅城区', '440600');
INSERT INTO `siping_county` VALUES ('370', '440605', '南海区', '440600');
INSERT INTO `siping_county` VALUES ('371', '440606', '顺德区', '440600');
INSERT INTO `siping_county` VALUES ('372', '440607', '三水区', '440600');
INSERT INTO `siping_county` VALUES ('373', '440608', '高明区', '440600');
INSERT INTO `siping_county` VALUES ('374', '440703', '蓬江区', '440700');
INSERT INTO `siping_county` VALUES ('375', '440704', '江海区', '440700');
INSERT INTO `siping_county` VALUES ('376', '440781', '台山市', '440700');
INSERT INTO `siping_county` VALUES ('377', '440705', '新会区', '440700');
INSERT INTO `siping_county` VALUES ('378', '440783', '开平市', '440700');
INSERT INTO `siping_county` VALUES ('379', '440784', '鹤山市', '440700');
INSERT INTO `siping_county` VALUES ('380', '440785', '恩平市', '440700');
INSERT INTO `siping_county` VALUES ('381', '440802', '赤坎区', '440800');
INSERT INTO `siping_county` VALUES ('382', '440804', '坡头区', '440800');
INSERT INTO `siping_county` VALUES ('383', '440803', '霞山区', '440800');
INSERT INTO `siping_county` VALUES ('384', '440811', '麻章区', '440800');
INSERT INTO `siping_county` VALUES ('385', '440823', '遂溪县', '440800');
INSERT INTO `siping_county` VALUES ('386', '440825', '徐闻县', '440800');
INSERT INTO `siping_county` VALUES ('387', '440881', '廉江市', '440800');
INSERT INTO `siping_county` VALUES ('388', '440882', '雷州市', '440800');
INSERT INTO `siping_county` VALUES ('389', '440883', '吴川市', '440800');
INSERT INTO `siping_county` VALUES ('390', '440902', '茂南区', '440900');
INSERT INTO `siping_county` VALUES ('391', '440904', '电白区', '440900');
INSERT INTO `siping_county` VALUES ('392', '440981', '高州市', '440900');
INSERT INTO `siping_county` VALUES ('393', '440982', '化州市', '440900');
INSERT INTO `siping_county` VALUES ('394', '440983', '信宜市', '440900');
INSERT INTO `siping_county` VALUES ('395', '441202', '端州区', '441200');
INSERT INTO `siping_county` VALUES ('396', '441203', '鼎湖区', '441200');
INSERT INTO `siping_county` VALUES ('397', '441223', '广宁县', '441200');
INSERT INTO `siping_county` VALUES ('398', '441224', '怀集县', '441200');
INSERT INTO `siping_county` VALUES ('399', '441225', '封开县', '441200');
INSERT INTO `siping_county` VALUES ('400', '441226', '德庆县', '441200');
INSERT INTO `siping_county` VALUES ('401', '441283', '高要市', '441200');
INSERT INTO `siping_county` VALUES ('402', '441284', '四会市', '441200');
INSERT INTO `siping_county` VALUES ('403', '441302', '惠城区', '441300');
INSERT INTO `siping_county` VALUES ('404', '441303', '惠阳区', '441300');
INSERT INTO `siping_county` VALUES ('405', '441322', '博罗县', '441300');
INSERT INTO `siping_county` VALUES ('406', '441323', '惠东县', '441300');
INSERT INTO `siping_county` VALUES ('407', '441324', '龙门县', '441300');
INSERT INTO `siping_county` VALUES ('408', '441402', '梅江区', '441400');
INSERT INTO `siping_county` VALUES ('409', '441403', '梅县区', '441400');
INSERT INTO `siping_county` VALUES ('410', '441422', '大埔县', '441400');
INSERT INTO `siping_county` VALUES ('411', '441424', '五华县', '441400');
INSERT INTO `siping_county` VALUES ('412', '441426', '平远县', '441400');
INSERT INTO `siping_county` VALUES ('413', '441427', '蕉岭县', '441400');
INSERT INTO `siping_county` VALUES ('414', '441481', '兴宁市', '441400');
INSERT INTO `siping_county` VALUES ('415', '441423', '丰顺县', '441400');
INSERT INTO `siping_county` VALUES ('416', '441581', '陆丰市', '441500');
INSERT INTO `siping_county` VALUES ('417', '441523', '陆河县', '441500');
INSERT INTO `siping_county` VALUES ('418', '441502', '城区', '441500');
INSERT INTO `siping_county` VALUES ('419', '441521', '海丰县', '441500');
INSERT INTO `siping_county` VALUES ('420', '441602', '源城区', '441600');
INSERT INTO `siping_county` VALUES ('421', '441621', '紫金县', '441600');
INSERT INTO `siping_county` VALUES ('422', '441624', '和平县', '441600');
INSERT INTO `siping_county` VALUES ('423', '441622', '龙川县', '441600');
INSERT INTO `siping_county` VALUES ('424', '441625', '东源县', '441600');
INSERT INTO `siping_county` VALUES ('425', '441623', '连平县', '441600');
INSERT INTO `siping_county` VALUES ('426', '441702', '江城区', '441700');
INSERT INTO `siping_county` VALUES ('427', '441721', '阳西县', '441700');
INSERT INTO `siping_county` VALUES ('428', '441723', '阳东县', '441700');
INSERT INTO `siping_county` VALUES ('429', '441781', '阳春市', '441700');
INSERT INTO `siping_county` VALUES ('430', '441802', '清城区', '441800');
INSERT INTO `siping_county` VALUES ('431', '441803', '清新区', '441800');
INSERT INTO `siping_county` VALUES ('432', '441821', '佛冈县', '441800');
INSERT INTO `siping_county` VALUES ('433', '441823', '阳山县', '441800');
INSERT INTO `siping_county` VALUES ('434', '441825', '连山壮族瑶族自治县', '441800');
INSERT INTO `siping_county` VALUES ('435', '441826', '连南瑶族自治县', '441800');
INSERT INTO `siping_county` VALUES ('436', '441881', '英德市', '441800');
INSERT INTO `siping_county` VALUES ('437', '441882', '连州市', '441800');
INSERT INTO `siping_county` VALUES ('438', '445102', '湘桥区', '445100');
INSERT INTO `siping_county` VALUES ('439', '445103', '潮安区', '445100');
INSERT INTO `siping_county` VALUES ('440', '445122', '饶平县', '445100');
INSERT INTO `siping_county` VALUES ('441', '445202', '榕城区', '445200');
INSERT INTO `siping_county` VALUES ('442', '445203', '揭东区', '445200');
INSERT INTO `siping_county` VALUES ('443', '445222', '揭西县', '445200');
INSERT INTO `siping_county` VALUES ('444', '445224', '惠来县', '445200');
INSERT INTO `siping_county` VALUES ('445', '445281', '普宁市', '445200');
INSERT INTO `siping_county` VALUES ('446', '445302', '云城区', '445300');
INSERT INTO `siping_county` VALUES ('447', '445303', '云安区', '445300');
INSERT INTO `siping_county` VALUES ('448', '445321', '新兴县', '445300');
INSERT INTO `siping_county` VALUES ('449', '445322', '郁南县', '445300');
INSERT INTO `siping_county` VALUES ('450', '445381', '罗定市', '445300');
INSERT INTO `siping_county` VALUES ('451', '450102', '兴宁区', '450100');
INSERT INTO `siping_county` VALUES ('452', '450103', '青秀区', '450100');
INSERT INTO `siping_county` VALUES ('453', '450105', '江南区', '450100');
INSERT INTO `siping_county` VALUES ('454', '450107', '西乡塘区', '450100');
INSERT INTO `siping_county` VALUES ('455', '450108', '良庆区', '450100');
INSERT INTO `siping_county` VALUES ('456', '450109', '邕宁区', '450100');
INSERT INTO `siping_county` VALUES ('457', '450122', '武鸣县', '450100');
INSERT INTO `siping_county` VALUES ('458', '450123', '隆安县', '450100');
INSERT INTO `siping_county` VALUES ('459', '450124', '马山县', '450100');
INSERT INTO `siping_county` VALUES ('460', '450125', '上林县', '450100');
INSERT INTO `siping_county` VALUES ('461', '450126', '宾阳县', '450100');
INSERT INTO `siping_county` VALUES ('462', '450127', '横县', '450100');
INSERT INTO `siping_county` VALUES ('463', '450202', '城中区', '450200');
INSERT INTO `siping_county` VALUES ('464', '450203', '鱼峰区', '450200');
INSERT INTO `siping_county` VALUES ('465', '450204', '柳南区', '450200');
INSERT INTO `siping_county` VALUES ('466', '450205', '柳北区', '450200');
INSERT INTO `siping_county` VALUES ('467', '450221', '柳江县', '450200');
INSERT INTO `siping_county` VALUES ('468', '450222', '柳城县', '450200');
INSERT INTO `siping_county` VALUES ('469', '450223', '鹿寨县', '450200');
INSERT INTO `siping_county` VALUES ('470', '450224', '融安县', '450200');
INSERT INTO `siping_county` VALUES ('471', '450225', '融水苗族自治县', '450200');
INSERT INTO `siping_county` VALUES ('472', '450226', '三江侗族自治县', '450200');
INSERT INTO `siping_county` VALUES ('473', '450302', '秀峰区', '450300');
INSERT INTO `siping_county` VALUES ('474', '450303', '叠彩区', '450300');
INSERT INTO `siping_county` VALUES ('475', '450304', '象山区', '450300');
INSERT INTO `siping_county` VALUES ('476', '450305', '七星区', '450300');
INSERT INTO `siping_county` VALUES ('477', '450311', '雁山区', '450300');
INSERT INTO `siping_county` VALUES ('478', '450312', '临桂区', '450300');
INSERT INTO `siping_county` VALUES ('479', '450321', '阳朔县', '450300');
INSERT INTO `siping_county` VALUES ('480', '450323', '灵川县', '450300');
INSERT INTO `siping_county` VALUES ('481', '450324', '全州县', '450300');
INSERT INTO `siping_county` VALUES ('482', '450325', '兴安县', '450300');
INSERT INTO `siping_county` VALUES ('483', '450326', '永福县', '450300');
INSERT INTO `siping_county` VALUES ('484', '450327', '灌阳县', '450300');
INSERT INTO `siping_county` VALUES ('485', '450328', '龙胜各族自治县', '450300');
INSERT INTO `siping_county` VALUES ('486', '450329', '资源县', '450300');
INSERT INTO `siping_county` VALUES ('487', '450330', '平乐县', '450300');
INSERT INTO `siping_county` VALUES ('488', '450331', '荔浦县', '450300');
INSERT INTO `siping_county` VALUES ('489', '450332', '恭城瑶族自治县', '450300');
INSERT INTO `siping_county` VALUES ('490', '450403', '万秀区', '450400');
INSERT INTO `siping_county` VALUES ('491', '450405', '长洲区', '450400');
INSERT INTO `siping_county` VALUES ('492', '450406', '龙圩区', '450400');
INSERT INTO `siping_county` VALUES ('493', '450421', '苍梧县', '450400');
INSERT INTO `siping_county` VALUES ('494', '450422', '藤县', '450400');
INSERT INTO `siping_county` VALUES ('495', '450423', '蒙山县', '450400');
INSERT INTO `siping_county` VALUES ('496', '450481', '岑溪市', '450400');
INSERT INTO `siping_county` VALUES ('497', '450502', '海城区', '450500');
INSERT INTO `siping_county` VALUES ('498', '450503', '银海区', '450500');
INSERT INTO `siping_county` VALUES ('499', '450512', '铁山港区', '450500');
INSERT INTO `siping_county` VALUES ('500', '450521', '合浦县', '450500');
INSERT INTO `siping_county` VALUES ('501', '450602', '港口区', '450600');
INSERT INTO `siping_county` VALUES ('502', '450603', '防城区', '450600');
INSERT INTO `siping_county` VALUES ('503', '450621', '上思县', '450600');
INSERT INTO `siping_county` VALUES ('504', '450681', '东兴市', '450600');
INSERT INTO `siping_county` VALUES ('505', '450702', '钦南区', '450700');
INSERT INTO `siping_county` VALUES ('506', '450703', '钦北区', '450700');
INSERT INTO `siping_county` VALUES ('507', '450721', '灵山县', '450700');
INSERT INTO `siping_county` VALUES ('508', '450722', '浦北县', '450700');
INSERT INTO `siping_county` VALUES ('509', '450802', '港北区', '450800');
INSERT INTO `siping_county` VALUES ('510', '450803', '港南区', '450800');
INSERT INTO `siping_county` VALUES ('511', '450821', '平南县', '450800');
INSERT INTO `siping_county` VALUES ('512', '450902', '玉州区', '450900');
INSERT INTO `siping_county` VALUES ('513', '450804', '覃塘区', '450800');
INSERT INTO `siping_county` VALUES ('514', '450881', '桂平市', '450800');
INSERT INTO `siping_county` VALUES ('515', '450921', '容县', '450900');
INSERT INTO `siping_county` VALUES ('516', '450903', '福绵区', '450900');
INSERT INTO `siping_county` VALUES ('517', '450922', '陆川县', '450900');
INSERT INTO `siping_county` VALUES ('518', '450923', '博白县', '450900');
INSERT INTO `siping_county` VALUES ('519', '450924', '兴业县', '450900');
INSERT INTO `siping_county` VALUES ('520', '450981', '北流市', '450900');
INSERT INTO `siping_county` VALUES ('521', '451002', '右江区', '451000');
INSERT INTO `siping_county` VALUES ('522', '451021', '田阳县', '451000');
INSERT INTO `siping_county` VALUES ('523', '451022', '田东县', '451000');
INSERT INTO `siping_county` VALUES ('524', '451023', '平果县', '451000');
INSERT INTO `siping_county` VALUES ('525', '451024', '德保县', '451000');
INSERT INTO `siping_county` VALUES ('526', '451025', '靖西县', '451000');
INSERT INTO `siping_county` VALUES ('527', '451026', '那坡县', '451000');
INSERT INTO `siping_county` VALUES ('528', '451028', '乐业县', '451000');
INSERT INTO `siping_county` VALUES ('529', '451027', '凌云县', '451000');
INSERT INTO `siping_county` VALUES ('530', '451029', '田林县', '451000');
INSERT INTO `siping_county` VALUES ('531', '451030', '西林县', '451000');
INSERT INTO `siping_county` VALUES ('532', '451031', '隆林各族自治县', '451000');
INSERT INTO `siping_county` VALUES ('533', '451121', '昭平县', '451100');
INSERT INTO `siping_county` VALUES ('534', '451102', '八步区', '451100');
INSERT INTO `siping_county` VALUES ('535', '451122', '钟山县', '451100');
INSERT INTO `siping_county` VALUES ('536', '451123', '富川瑶族自治县', '451100');
INSERT INTO `siping_county` VALUES ('537', '451202', '金城江区', '451200');
INSERT INTO `siping_county` VALUES ('538', '451221', '南丹县', '451200');
INSERT INTO `siping_county` VALUES ('539', '451222', '天峨县', '451200');
INSERT INTO `siping_county` VALUES ('540', '451223', '凤山县', '451200');
INSERT INTO `siping_county` VALUES ('541', '451224', '东兰县', '451200');
INSERT INTO `siping_county` VALUES ('542', '451225', '罗城仫佬族自治县', '451200');
INSERT INTO `siping_county` VALUES ('543', '451226', '环江毛南族自治县', '451200');
INSERT INTO `siping_county` VALUES ('544', '451227', '巴马瑶族自治县', '451200');
INSERT INTO `siping_county` VALUES ('545', '451228', '都安瑶族自治县', '451200');
INSERT INTO `siping_county` VALUES ('546', '451229', '大化瑶族自治县', '451200');
INSERT INTO `siping_county` VALUES ('547', '451281', '宜州市', '451200');
INSERT INTO `siping_county` VALUES ('548', '451302', '兴宾区', '451300');
INSERT INTO `siping_county` VALUES ('549', '451321', '忻城县', '451300');
INSERT INTO `siping_county` VALUES ('550', '451322', '象州县', '451300');
INSERT INTO `siping_county` VALUES ('551', '451323', '武宣县', '451300');
INSERT INTO `siping_county` VALUES ('552', '451324', '金秀瑶族自治县', '451300');
INSERT INTO `siping_county` VALUES ('553', '451381', '合山市', '451300');
INSERT INTO `siping_county` VALUES ('554', '451402', '江州区', '451400');
INSERT INTO `siping_county` VALUES ('555', '451422', '宁明县', '451400');
INSERT INTO `siping_county` VALUES ('556', '451424', '大新县', '451400');
INSERT INTO `siping_county` VALUES ('557', '451425', '天等县', '451400');
INSERT INTO `siping_county` VALUES ('558', '451421', '扶绥县', '451400');
INSERT INTO `siping_county` VALUES ('559', '451423', '龙州县', '451400');
INSERT INTO `siping_county` VALUES ('560', '451481', '凭祥市', '451400');
INSERT INTO `siping_county` VALUES ('561', '520102', '南明区', '520100');
INSERT INTO `siping_county` VALUES ('562', '520103', '云岩区', '520100');
INSERT INTO `siping_county` VALUES ('563', '520111', '花溪区', '520100');
INSERT INTO `siping_county` VALUES ('564', '520112', '乌当区', '520100');
INSERT INTO `siping_county` VALUES ('565', '520113', '白云区', '520100');
INSERT INTO `siping_county` VALUES ('566', '520115', '观山湖区', '520100');
INSERT INTO `siping_county` VALUES ('567', '520121', '开阳县', '520100');
INSERT INTO `siping_county` VALUES ('568', '520122', '息烽县', '520100');
INSERT INTO `siping_county` VALUES ('569', '520123', '修文县', '520100');
INSERT INTO `siping_county` VALUES ('570', '520181', '清镇市', '520100');
INSERT INTO `siping_county` VALUES ('571', '520201', '钟山区', '520200');
INSERT INTO `siping_county` VALUES ('572', '520203', '六枝特区', '520200');
INSERT INTO `siping_county` VALUES ('573', '520221', '水城县', '520200');
INSERT INTO `siping_county` VALUES ('574', '520222', '盘县', '520200');
INSERT INTO `siping_county` VALUES ('575', '520321', '遵义县', '520300');
INSERT INTO `siping_county` VALUES ('576', '520302', '红花岗区', '520300');
INSERT INTO `siping_county` VALUES ('577', '520322', '桐梓县', '520300');
INSERT INTO `siping_county` VALUES ('578', '520303', '汇川区', '520300');
INSERT INTO `siping_county` VALUES ('579', '520323', '绥阳县', '520300');
INSERT INTO `siping_county` VALUES ('580', '520324', '正安县', '520300');
INSERT INTO `siping_county` VALUES ('581', '520325', '道真仡佬族苗族自治县', '520300');
INSERT INTO `siping_county` VALUES ('582', '520326', '务川仡佬族苗族自治县', '520300');
INSERT INTO `siping_county` VALUES ('583', '520327', '凤冈县', '520300');
INSERT INTO `siping_county` VALUES ('584', '520328', '湄潭县', '520300');
INSERT INTO `siping_county` VALUES ('585', '520329', '余庆县', '520300');
INSERT INTO `siping_county` VALUES ('586', '520330', '习水县', '520300');
INSERT INTO `siping_county` VALUES ('587', '520381', '赤水市', '520300');
INSERT INTO `siping_county` VALUES ('588', '520382', '仁怀市', '520300');
INSERT INTO `siping_county` VALUES ('589', '520402', '西秀区', '520400');
INSERT INTO `siping_county` VALUES ('590', '520421', '平坝县', '520400');
INSERT INTO `siping_county` VALUES ('591', '520422', '普定县', '520400');
INSERT INTO `siping_county` VALUES ('592', '520423', '镇宁布依族苗族自治县', '520400');
INSERT INTO `siping_county` VALUES ('593', '520424', '关岭布依族苗族自治县', '520400');
INSERT INTO `siping_county` VALUES ('594', '520425', '紫云苗族布依族自治县', '520400');
INSERT INTO `siping_county` VALUES ('595', '520502', '七星关区', '520500');
INSERT INTO `siping_county` VALUES ('596', '520521', '大方县', '520500');
INSERT INTO `siping_county` VALUES ('597', '520522', '黔西县', '520500');
INSERT INTO `siping_county` VALUES ('598', '520523', '金沙县', '520500');
INSERT INTO `siping_county` VALUES ('599', '520526', '威宁彝族回族苗族自治县', '520500');
INSERT INTO `siping_county` VALUES ('600', '520524', '织金县', '520500');
INSERT INTO `siping_county` VALUES ('601', '520527', '赫章县', '520500');
INSERT INTO `siping_county` VALUES ('602', '520525', '纳雍县', '520500');
INSERT INTO `siping_county` VALUES ('603', '520602', '碧江区', '520600');
INSERT INTO `siping_county` VALUES ('604', '520603', '万山区', '520600');
INSERT INTO `siping_county` VALUES ('605', '520621', '江口县', '520600');
INSERT INTO `siping_county` VALUES ('606', '520622', '玉屏侗族自治县', '520600');
INSERT INTO `siping_county` VALUES ('607', '520623', '石阡县', '520600');
INSERT INTO `siping_county` VALUES ('608', '520624', '思南县', '520600');
INSERT INTO `siping_county` VALUES ('609', '520625', '印江土家族苗族自治县', '520600');
INSERT INTO `siping_county` VALUES ('610', '520626', '德江县', '520600');
INSERT INTO `siping_county` VALUES ('611', '520628', '松桃苗族自治县', '520600');
INSERT INTO `siping_county` VALUES ('612', '520627', '沿河土家族自治县', '520600');
INSERT INTO `siping_county` VALUES ('613', '522301', '兴义市', '522300');
INSERT INTO `siping_county` VALUES ('614', '522322', '兴仁县', '522300');
INSERT INTO `siping_county` VALUES ('615', '522326', '望谟县', '522300');
INSERT INTO `siping_county` VALUES ('616', '522324', '晴隆县', '522300');
INSERT INTO `siping_county` VALUES ('617', '522325', '贞丰县', '522300');
INSERT INTO `siping_county` VALUES ('618', '522323', '普安县', '522300');
INSERT INTO `siping_county` VALUES ('619', '522327', '册亨县', '522300');
INSERT INTO `siping_county` VALUES ('620', '522328', '安龙县', '522300');
INSERT INTO `siping_county` VALUES ('621', '522601', '凯里市', '522600');
INSERT INTO `siping_county` VALUES ('622', '522622', '黄平县', '522600');
INSERT INTO `siping_county` VALUES ('623', '522623', '施秉县', '522600');
INSERT INTO `siping_county` VALUES ('624', '522624', '三穗县', '522600');
INSERT INTO `siping_county` VALUES ('625', '522625', '镇远县', '522600');
INSERT INTO `siping_county` VALUES ('626', '522626', '岑巩县', '522600');
INSERT INTO `siping_county` VALUES ('627', '522627', '天柱县', '522600');
INSERT INTO `siping_county` VALUES ('628', '522628', '锦屏县', '522600');
INSERT INTO `siping_county` VALUES ('629', '522629', '剑河县', '522600');
INSERT INTO `siping_county` VALUES ('630', '522630', '台江县', '522600');
INSERT INTO `siping_county` VALUES ('631', '522631', '黎平县', '522600');
INSERT INTO `siping_county` VALUES ('632', '522632', '榕江县', '522600');
INSERT INTO `siping_county` VALUES ('633', '522633', '从江县', '522600');
INSERT INTO `siping_county` VALUES ('634', '522634', '雷山县', '522600');
INSERT INTO `siping_county` VALUES ('635', '522635', '麻江县', '522600');
INSERT INTO `siping_county` VALUES ('636', '522636', '丹寨县', '522600');
INSERT INTO `siping_county` VALUES ('637', '522701', '都匀市', '522700');
INSERT INTO `siping_county` VALUES ('638', '522702', '福泉市', '522700');
INSERT INTO `siping_county` VALUES ('639', '522723', '贵定县', '522700');
INSERT INTO `siping_county` VALUES ('640', '522722', '荔波县', '522700');
INSERT INTO `siping_county` VALUES ('641', '522725', '瓮安县', '522700');
INSERT INTO `siping_county` VALUES ('642', '522726', '独山县', '522700');
INSERT INTO `siping_county` VALUES ('643', '522727', '平塘县', '522700');
INSERT INTO `siping_county` VALUES ('644', '522728', '罗甸县', '522700');
INSERT INTO `siping_county` VALUES ('645', '522730', '龙里县', '522700');
INSERT INTO `siping_county` VALUES ('646', '522729', '长顺县', '522700');
INSERT INTO `siping_county` VALUES ('647', '522731', '惠水县', '522700');
INSERT INTO `siping_county` VALUES ('648', '522732', '三都水族自治县', '522700');
INSERT INTO `siping_county` VALUES ('649', '460105', '秀英区', '460100');
INSERT INTO `siping_county` VALUES ('650', '460106', '龙华区', '460100');
INSERT INTO `siping_county` VALUES ('651', '460107', '琼山区', '460100');
INSERT INTO `siping_county` VALUES ('652', '460108', '美兰区', '460100');
INSERT INTO `siping_county` VALUES ('653', '460202', '海棠区', '460200');
INSERT INTO `siping_county` VALUES ('654', '460203', '吉阳区', '460200');
INSERT INTO `siping_county` VALUES ('655', '460204', '天涯区', '460200');
INSERT INTO `siping_county` VALUES ('656', '460205', '崖州区', '460200');
INSERT INTO `siping_county` VALUES ('657', '469001', '五指山市', '469000');
INSERT INTO `siping_county` VALUES ('658', '469002', '琼海市', '469000');
INSERT INTO `siping_county` VALUES ('659', '469003', '儋州市', '469000');
INSERT INTO `siping_county` VALUES ('660', '469005', '文昌市', '469000');
INSERT INTO `siping_county` VALUES ('661', '469006', '万宁市', '469000');
INSERT INTO `siping_county` VALUES ('662', '469007', '东方市', '469000');
INSERT INTO `siping_county` VALUES ('663', '469021', '定安县', '469000');
INSERT INTO `siping_county` VALUES ('664', '469022', '屯昌县', '469000');
INSERT INTO `siping_county` VALUES ('665', '469023', '澄迈县', '469000');
INSERT INTO `siping_county` VALUES ('666', '469024', '临高县', '469000');
INSERT INTO `siping_county` VALUES ('667', '469025', '白沙黎族自治县', '469000');
INSERT INTO `siping_county` VALUES ('668', '469026', '昌江黎族自治县', '469000');
INSERT INTO `siping_county` VALUES ('669', '469027', '乐东黎族自治县', '469000');
INSERT INTO `siping_county` VALUES ('670', '469028', '陵水黎族自治县', '469000');
INSERT INTO `siping_county` VALUES ('671', '469029', '保亭黎族苗族自治县', '469000');
INSERT INTO `siping_county` VALUES ('672', '469030', '琼中黎族苗族自治县', '469000');
INSERT INTO `siping_county` VALUES ('673', '130102', '长安区', '130100');
INSERT INTO `siping_county` VALUES ('674', '130104', '桥西区', '130100');
INSERT INTO `siping_county` VALUES ('675', '130105', '新华区', '130100');
INSERT INTO `siping_county` VALUES ('676', '130107', '井陉矿区', '130100');
INSERT INTO `siping_county` VALUES ('677', '130108', '裕华区', '130100');
INSERT INTO `siping_county` VALUES ('678', '130109', '藁城区', '130100');
INSERT INTO `siping_county` VALUES ('679', '130110', '鹿泉区', '130100');
INSERT INTO `siping_county` VALUES ('680', '130111', '栾城区', '130100');
INSERT INTO `siping_county` VALUES ('681', '130121', '井陉县', '130100');
INSERT INTO `siping_county` VALUES ('682', '130123', '正定县', '130100');
INSERT INTO `siping_county` VALUES ('683', '130125', '行唐县', '130100');
INSERT INTO `siping_county` VALUES ('684', '130126', '灵寿县', '130100');
INSERT INTO `siping_county` VALUES ('685', '130127', '高邑县', '130100');
INSERT INTO `siping_county` VALUES ('686', '130128', '深泽县', '130100');
INSERT INTO `siping_county` VALUES ('687', '130129', '赞皇县', '130100');
INSERT INTO `siping_county` VALUES ('688', '130132', '元氏县', '130100');
INSERT INTO `siping_county` VALUES ('689', '130131', '平山县', '130100');
INSERT INTO `siping_county` VALUES ('690', '130130', '无极县', '130100');
INSERT INTO `siping_county` VALUES ('691', '130133', '赵县', '130100');
INSERT INTO `siping_county` VALUES ('692', '130181', '辛集市', '130100');
INSERT INTO `siping_county` VALUES ('693', '130183', '晋州市', '130100');
INSERT INTO `siping_county` VALUES ('694', '130184', '新乐市', '130100');
INSERT INTO `siping_county` VALUES ('695', '130203', '路北区', '130200');
INSERT INTO `siping_county` VALUES ('696', '130202', '路南区', '130200');
INSERT INTO `siping_county` VALUES ('697', '130204', '古冶区', '130200');
INSERT INTO `siping_county` VALUES ('698', '130207', '丰南区', '130200');
INSERT INTO `siping_county` VALUES ('699', '130205', '开平区', '130200');
INSERT INTO `siping_county` VALUES ('700', '130208', '丰润区', '130200');
INSERT INTO `siping_county` VALUES ('701', '130209', '曹妃甸区', '130200');
INSERT INTO `siping_county` VALUES ('702', '130223', '滦县', '130200');
INSERT INTO `siping_county` VALUES ('703', '130224', '滦南县', '130200');
INSERT INTO `siping_county` VALUES ('704', '130227', '迁西县', '130200');
INSERT INTO `siping_county` VALUES ('705', '130225', '乐亭县', '130200');
INSERT INTO `siping_county` VALUES ('706', '130229', '玉田县', '130200');
INSERT INTO `siping_county` VALUES ('707', '130281', '遵化市', '130200');
INSERT INTO `siping_county` VALUES ('708', '130283', '迁安市', '130200');
INSERT INTO `siping_county` VALUES ('709', '130302', '海港区', '130300');
INSERT INTO `siping_county` VALUES ('710', '130303', '山海关区', '130300');
INSERT INTO `siping_county` VALUES ('711', '130304', '北戴河区', '130300');
INSERT INTO `siping_county` VALUES ('712', '130321', '青龙满族自治县', '130300');
INSERT INTO `siping_county` VALUES ('713', '130322', '昌黎县', '130300');
INSERT INTO `siping_county` VALUES ('714', '130323', '抚宁县', '130300');
INSERT INTO `siping_county` VALUES ('715', '130324', '卢龙县', '130300');
INSERT INTO `siping_county` VALUES ('716', '130402', '邯山区', '130400');
INSERT INTO `siping_county` VALUES ('717', '130403', '丛台区', '130400');
INSERT INTO `siping_county` VALUES ('718', '130406', '峰峰矿区', '130400');
INSERT INTO `siping_county` VALUES ('719', '130404', '复兴区', '130400');
INSERT INTO `siping_county` VALUES ('720', '130423', '临漳县', '130400');
INSERT INTO `siping_county` VALUES ('721', '130424', '成安县', '130400');
INSERT INTO `siping_county` VALUES ('722', '130425', '大名县', '130400');
INSERT INTO `siping_county` VALUES ('723', '130421', '邯郸县', '130400');
INSERT INTO `siping_county` VALUES ('724', '130426', '涉县', '130400');
INSERT INTO `siping_county` VALUES ('725', '130427', '磁县', '130400');
INSERT INTO `siping_county` VALUES ('726', '130428', '肥乡县', '130400');
INSERT INTO `siping_county` VALUES ('727', '130429', '永年县', '130400');
INSERT INTO `siping_county` VALUES ('728', '130431', '鸡泽县', '130400');
INSERT INTO `siping_county` VALUES ('729', '130432', '广平县', '130400');
INSERT INTO `siping_county` VALUES ('730', '130430', '邱县', '130400');
INSERT INTO `siping_county` VALUES ('731', '130433', '馆陶县', '130400');
INSERT INTO `siping_county` VALUES ('732', '130434', '魏县', '130400');
INSERT INTO `siping_county` VALUES ('733', '130481', '武安市', '130400');
INSERT INTO `siping_county` VALUES ('734', '130435', '曲周县', '130400');
INSERT INTO `siping_county` VALUES ('735', '130502', '桥东区', '130500');
INSERT INTO `siping_county` VALUES ('736', '130503', '桥西区', '130500');
INSERT INTO `siping_county` VALUES ('737', '130521', '邢台县', '130500');
INSERT INTO `siping_county` VALUES ('738', '130525', '隆尧县', '130500');
INSERT INTO `siping_county` VALUES ('739', '130526', '任县', '130500');
INSERT INTO `siping_county` VALUES ('740', '130523', '内丘县', '130500');
INSERT INTO `siping_county` VALUES ('741', '130524', '柏乡县', '130500');
INSERT INTO `siping_county` VALUES ('742', '130527', '南和县', '130500');
INSERT INTO `siping_county` VALUES ('743', '130522', '临城县', '130500');
INSERT INTO `siping_county` VALUES ('744', '130528', '宁晋县', '130500');
INSERT INTO `siping_county` VALUES ('745', '130529', '巨鹿县', '130500');
INSERT INTO `siping_county` VALUES ('746', '130530', '新河县', '130500');
INSERT INTO `siping_county` VALUES ('747', '130533', '威县', '130500');
INSERT INTO `siping_county` VALUES ('748', '130532', '平乡县', '130500');
INSERT INTO `siping_county` VALUES ('749', '130531', '广宗县', '130500');
INSERT INTO `siping_county` VALUES ('750', '130534', '清河县', '130500');
INSERT INTO `siping_county` VALUES ('751', '130535', '临西县', '130500');
INSERT INTO `siping_county` VALUES ('752', '130602', '新市区', '130600');
INSERT INTO `siping_county` VALUES ('753', '130603', '北市区', '130600');
INSERT INTO `siping_county` VALUES ('754', '130604', '南市区', '130600');
INSERT INTO `siping_county` VALUES ('755', '130581', '南宫市', '130500');
INSERT INTO `siping_county` VALUES ('756', '130582', '沙河市', '130500');
INSERT INTO `siping_county` VALUES ('757', '130623', '涞水县', '130600');
INSERT INTO `siping_county` VALUES ('758', '130621', '满城县', '130600');
INSERT INTO `siping_county` VALUES ('759', '130622', '清苑县', '130600');
INSERT INTO `siping_county` VALUES ('760', '130624', '阜平县', '130600');
INSERT INTO `siping_county` VALUES ('761', '130625', '徐水县', '130600');
INSERT INTO `siping_county` VALUES ('762', '130626', '定兴县', '130600');
INSERT INTO `siping_county` VALUES ('763', '130627', '唐县', '130600');
INSERT INTO `siping_county` VALUES ('764', '130628', '高阳县', '130600');
INSERT INTO `siping_county` VALUES ('765', '130629', '容城县', '130600');
INSERT INTO `siping_county` VALUES ('766', '130630', '涞源县', '130600');
INSERT INTO `siping_county` VALUES ('767', '130632', '安新县', '130600');
INSERT INTO `siping_county` VALUES ('768', '130634', '曲阳县', '130600');
INSERT INTO `siping_county` VALUES ('769', '130631', '望都县', '130600');
INSERT INTO `siping_county` VALUES ('770', '130635', '蠡县', '130600');
INSERT INTO `siping_county` VALUES ('771', '130633', '易县', '130600');
INSERT INTO `siping_county` VALUES ('772', '130638', '雄县', '130600');
INSERT INTO `siping_county` VALUES ('773', '130636', '顺平县', '130600');
INSERT INTO `siping_county` VALUES ('774', '130637', '博野县', '130600');
INSERT INTO `siping_county` VALUES ('775', '130681', '涿州市', '130600');
INSERT INTO `siping_county` VALUES ('776', '130682', '定州市', '130600');
INSERT INTO `siping_county` VALUES ('777', '130684', '高碑店市', '130600');
INSERT INTO `siping_county` VALUES ('778', '130705', '宣化区', '130700');
INSERT INTO `siping_county` VALUES ('779', '130683', '安国市', '130600');
INSERT INTO `siping_county` VALUES ('780', '130702', '桥东区', '130700');
INSERT INTO `siping_county` VALUES ('781', '130703', '桥西区', '130700');
INSERT INTO `siping_county` VALUES ('782', '130706', '下花园区', '130700');
INSERT INTO `siping_county` VALUES ('783', '130721', '宣化县', '130700');
INSERT INTO `siping_county` VALUES ('784', '130722', '张北县', '130700');
INSERT INTO `siping_county` VALUES ('785', '130723', '康保县', '130700');
INSERT INTO `siping_county` VALUES ('786', '130725', '尚义县', '130700');
INSERT INTO `siping_county` VALUES ('787', '130724', '沽源县', '130700');
INSERT INTO `siping_county` VALUES ('788', '130726', '蔚县', '130700');
INSERT INTO `siping_county` VALUES ('789', '130727', '阳原县', '130700');
INSERT INTO `siping_county` VALUES ('790', '130728', '怀安县', '130700');
INSERT INTO `siping_county` VALUES ('791', '130729', '万全县', '130700');
INSERT INTO `siping_county` VALUES ('792', '130730', '怀来县', '130700');
INSERT INTO `siping_county` VALUES ('793', '130731', '涿鹿县', '130700');
INSERT INTO `siping_county` VALUES ('794', '130732', '赤城县', '130700');
INSERT INTO `siping_county` VALUES ('795', '130733', '崇礼县', '130700');
INSERT INTO `siping_county` VALUES ('796', '130802', '双桥区', '130800');
INSERT INTO `siping_county` VALUES ('797', '130804', '鹰手营子矿区', '130800');
INSERT INTO `siping_county` VALUES ('798', '130803', '双滦区', '130800');
INSERT INTO `siping_county` VALUES ('799', '130821', '承德县', '130800');
INSERT INTO `siping_county` VALUES ('800', '130822', '兴隆县', '130800');
INSERT INTO `siping_county` VALUES ('801', '130823', '平泉县', '130800');
INSERT INTO `siping_county` VALUES ('802', '130824', '滦平县', '130800');
INSERT INTO `siping_county` VALUES ('803', '130825', '隆化县', '130800');
INSERT INTO `siping_county` VALUES ('804', '130826', '丰宁满族自治县', '130800');
INSERT INTO `siping_county` VALUES ('805', '130827', '宽城满族自治县', '130800');
INSERT INTO `siping_county` VALUES ('806', '130828', '围场满族蒙古族自治县', '130800');
INSERT INTO `siping_county` VALUES ('807', '130902', '新华区', '130900');
INSERT INTO `siping_county` VALUES ('808', '130903', '运河区', '130900');
INSERT INTO `siping_county` VALUES ('809', '130921', '沧县', '130900');
INSERT INTO `siping_county` VALUES ('810', '130922', '青县', '130900');
INSERT INTO `siping_county` VALUES ('811', '130923', '东光县', '130900');
INSERT INTO `siping_county` VALUES ('812', '130925', '盐山县', '130900');
INSERT INTO `siping_county` VALUES ('813', '130924', '海兴县', '130900');
INSERT INTO `siping_county` VALUES ('814', '130926', '肃宁县', '130900');
INSERT INTO `siping_county` VALUES ('815', '130927', '南皮县', '130900');
INSERT INTO `siping_county` VALUES ('816', '130928', '吴桥县', '130900');
INSERT INTO `siping_county` VALUES ('817', '130929', '献县', '130900');
INSERT INTO `siping_county` VALUES ('818', '130930', '孟村回族自治县', '130900');
INSERT INTO `siping_county` VALUES ('819', '130982', '任丘市', '130900');
INSERT INTO `siping_county` VALUES ('820', '130981', '泊头市', '130900');
INSERT INTO `siping_county` VALUES ('821', '130983', '黄骅市', '130900');
INSERT INTO `siping_county` VALUES ('822', '130984', '河间市', '130900');
INSERT INTO `siping_county` VALUES ('823', '131002', '安次区', '131000');
INSERT INTO `siping_county` VALUES ('824', '131003', '广阳区', '131000');
INSERT INTO `siping_county` VALUES ('825', '131022', '固安县', '131000');
INSERT INTO `siping_county` VALUES ('826', '131023', '永清县', '131000');
INSERT INTO `siping_county` VALUES ('827', '131024', '香河县', '131000');
INSERT INTO `siping_county` VALUES ('828', '131025', '大城县', '131000');
INSERT INTO `siping_county` VALUES ('829', '131026', '文安县', '131000');
INSERT INTO `siping_county` VALUES ('830', '131028', '大厂回族自治县', '131000');
INSERT INTO `siping_county` VALUES ('831', '131081', '霸州市', '131000');
INSERT INTO `siping_county` VALUES ('832', '131082', '三河市', '131000');
INSERT INTO `siping_county` VALUES ('833', '131102', '桃城区', '131100');
INSERT INTO `siping_county` VALUES ('834', '131121', '枣强县', '131100');
INSERT INTO `siping_county` VALUES ('835', '131122', '武邑县', '131100');
INSERT INTO `siping_county` VALUES ('836', '131123', '武强县', '131100');
INSERT INTO `siping_county` VALUES ('837', '131124', '饶阳县', '131100');
INSERT INTO `siping_county` VALUES ('838', '131125', '安平县', '131100');
INSERT INTO `siping_county` VALUES ('839', '131126', '故城县', '131100');
INSERT INTO `siping_county` VALUES ('840', '131127', '景县', '131100');
INSERT INTO `siping_county` VALUES ('841', '131128', '阜城县', '131100');
INSERT INTO `siping_county` VALUES ('842', '131181', '冀州市', '131100');
INSERT INTO `siping_county` VALUES ('843', '131182', '深州市', '131100');
INSERT INTO `siping_county` VALUES ('844', '230104', '道外区', '230100');
INSERT INTO `siping_county` VALUES ('845', '230102', '道里区', '230100');
INSERT INTO `siping_county` VALUES ('846', '230103', '南岗区', '230100');
INSERT INTO `siping_county` VALUES ('847', '230108', '平房区', '230100');
INSERT INTO `siping_county` VALUES ('848', '230109', '松北区', '230100');
INSERT INTO `siping_county` VALUES ('849', '230110', '香坊区', '230100');
INSERT INTO `siping_county` VALUES ('850', '230111', '呼兰区', '230100');
INSERT INTO `siping_county` VALUES ('851', '230112', '阿城区', '230100');
INSERT INTO `siping_county` VALUES ('852', '230123', '依兰县', '230100');
INSERT INTO `siping_county` VALUES ('853', '230124', '方正县', '230100');
INSERT INTO `siping_county` VALUES ('854', '230125', '宾县', '230100');
INSERT INTO `siping_county` VALUES ('855', '230126', '巴彦县', '230100');
INSERT INTO `siping_county` VALUES ('856', '230127', '木兰县', '230100');
INSERT INTO `siping_county` VALUES ('857', '230128', '通河县', '230100');
INSERT INTO `siping_county` VALUES ('858', '230129', '延寿县', '230100');
INSERT INTO `siping_county` VALUES ('859', '230183', '尚志市', '230100');
INSERT INTO `siping_county` VALUES ('860', '230182', '双城市', '230100');
INSERT INTO `siping_county` VALUES ('861', '230184', '五常市', '230100');
INSERT INTO `siping_county` VALUES ('862', '230202', '龙沙区', '230200');
INSERT INTO `siping_county` VALUES ('863', '230203', '建华区', '230200');
INSERT INTO `siping_county` VALUES ('864', '230204', '铁锋区', '230200');
INSERT INTO `siping_county` VALUES ('865', '230205', '昂昂溪区', '230200');
INSERT INTO `siping_county` VALUES ('866', '230206', '富拉尔基区', '230200');
INSERT INTO `siping_county` VALUES ('867', '230207', '碾子山区', '230200');
INSERT INTO `siping_county` VALUES ('868', '230208', '梅里斯达斡尔族区', '230200');
INSERT INTO `siping_county` VALUES ('869', '230221', '龙江县', '230200');
INSERT INTO `siping_county` VALUES ('870', '230223', '依安县', '230200');
INSERT INTO `siping_county` VALUES ('871', '230224', '泰来县', '230200');
INSERT INTO `siping_county` VALUES ('872', '230225', '甘南县', '230200');
INSERT INTO `siping_county` VALUES ('873', '230227', '富裕县', '230200');
INSERT INTO `siping_county` VALUES ('874', '230229', '克山县', '230200');
INSERT INTO `siping_county` VALUES ('875', '230230', '克东县', '230200');
INSERT INTO `siping_county` VALUES ('876', '230231', '拜泉县', '230200');
INSERT INTO `siping_county` VALUES ('877', '230281', '讷河市', '230200');
INSERT INTO `siping_county` VALUES ('878', '230303', '恒山区', '230300');
INSERT INTO `siping_county` VALUES ('879', '230302', '鸡冠区', '230300');
INSERT INTO `siping_county` VALUES ('880', '230304', '滴道区', '230300');
INSERT INTO `siping_county` VALUES ('881', '230305', '梨树区', '230300');
INSERT INTO `siping_county` VALUES ('882', '230306', '城子河区', '230300');
INSERT INTO `siping_county` VALUES ('883', '230307', '麻山区', '230300');
INSERT INTO `siping_county` VALUES ('884', '230321', '鸡东县', '230300');
INSERT INTO `siping_county` VALUES ('885', '230381', '虎林市', '230300');
INSERT INTO `siping_county` VALUES ('886', '230382', '密山市', '230300');
INSERT INTO `siping_county` VALUES ('887', '230402', '向阳区', '230400');
INSERT INTO `siping_county` VALUES ('888', '230403', '工农区', '230400');
INSERT INTO `siping_county` VALUES ('889', '230404', '南山区', '230400');
INSERT INTO `siping_county` VALUES ('890', '230405', '兴安区', '230400');
INSERT INTO `siping_county` VALUES ('891', '230406', '东山区', '230400');
INSERT INTO `siping_county` VALUES ('892', '230407', '兴山区', '230400');
INSERT INTO `siping_county` VALUES ('893', '230421', '萝北县', '230400');
INSERT INTO `siping_county` VALUES ('894', '230422', '绥滨县', '230400');
INSERT INTO `siping_county` VALUES ('895', '230502', '尖山区', '230500');
INSERT INTO `siping_county` VALUES ('896', '230503', '岭东区', '230500');
INSERT INTO `siping_county` VALUES ('897', '230505', '四方台区', '230500');
INSERT INTO `siping_county` VALUES ('898', '230506', '宝山区', '230500');
INSERT INTO `siping_county` VALUES ('899', '230521', '集贤县', '230500');
INSERT INTO `siping_county` VALUES ('900', '230523', '宝清县', '230500');
INSERT INTO `siping_county` VALUES ('901', '230522', '友谊县', '230500');
INSERT INTO `siping_county` VALUES ('902', '230524', '饶河县', '230500');
INSERT INTO `siping_county` VALUES ('903', '230602', '萨尔图区', '230600');
INSERT INTO `siping_county` VALUES ('904', '230603', '龙凤区', '230600');
INSERT INTO `siping_county` VALUES ('905', '230604', '让胡路区', '230600');
INSERT INTO `siping_county` VALUES ('906', '230606', '大同区', '230600');
INSERT INTO `siping_county` VALUES ('907', '230621', '肇州县', '230600');
INSERT INTO `siping_county` VALUES ('908', '230605', '红岗区', '230600');
INSERT INTO `siping_county` VALUES ('909', '230622', '肇源县', '230600');
INSERT INTO `siping_county` VALUES ('910', '230623', '林甸县', '230600');
INSERT INTO `siping_county` VALUES ('911', '230624', '杜尔伯特蒙古族自治县', '230600');
INSERT INTO `siping_county` VALUES ('912', '230704', '友好区', '230700');
INSERT INTO `siping_county` VALUES ('913', '230702', '伊春区', '230700');
INSERT INTO `siping_county` VALUES ('914', '230703', '南岔区', '230700');
INSERT INTO `siping_county` VALUES ('915', '230705', '西林区', '230700');
INSERT INTO `siping_county` VALUES ('916', '230706', '翠峦区', '230700');
INSERT INTO `siping_county` VALUES ('917', '230707', '新青区', '230700');
INSERT INTO `siping_county` VALUES ('918', '230708', '美溪区', '230700');
INSERT INTO `siping_county` VALUES ('919', '230709', '金山屯区', '230700');
INSERT INTO `siping_county` VALUES ('920', '230710', '五营区', '230700');
INSERT INTO `siping_county` VALUES ('921', '230711', '乌马河区', '230700');
INSERT INTO `siping_county` VALUES ('922', '230712', '汤旺河区', '230700');
INSERT INTO `siping_county` VALUES ('923', '230713', '带岭区', '230700');
INSERT INTO `siping_county` VALUES ('924', '230714', '乌伊岭区', '230700');
INSERT INTO `siping_county` VALUES ('925', '230716', '上甘岭区', '230700');
INSERT INTO `siping_county` VALUES ('926', '230781', '铁力市', '230700');
INSERT INTO `siping_county` VALUES ('927', '230722', '嘉荫县', '230700');
INSERT INTO `siping_county` VALUES ('928', '230715', '红星区', '230700');
INSERT INTO `siping_county` VALUES ('929', '230803', '向阳区', '230800');
INSERT INTO `siping_county` VALUES ('930', '230804', '前进区', '230800');
INSERT INTO `siping_county` VALUES ('931', '230805', '东风区', '230800');
INSERT INTO `siping_county` VALUES ('932', '230811', '郊区', '230800');
INSERT INTO `siping_county` VALUES ('933', '230826', '桦川县', '230800');
INSERT INTO `siping_county` VALUES ('934', '230822', '桦南县', '230800');
INSERT INTO `siping_county` VALUES ('935', '230828', '汤原县', '230800');
INSERT INTO `siping_county` VALUES ('936', '230833', '抚远县', '230800');
INSERT INTO `siping_county` VALUES ('937', '230881', '同江市', '230800');
INSERT INTO `siping_county` VALUES ('938', '230882', '富锦市', '230800');
INSERT INTO `siping_county` VALUES ('939', '230902', '新兴区', '230900');
INSERT INTO `siping_county` VALUES ('940', '230903', '桃山区', '230900');
INSERT INTO `siping_county` VALUES ('941', '230904', '茄子河区', '230900');
INSERT INTO `siping_county` VALUES ('942', '230921', '勃利县', '230900');
INSERT INTO `siping_county` VALUES ('943', '231002', '东安区', '231000');
INSERT INTO `siping_county` VALUES ('944', '231003', '阳明区', '231000');
INSERT INTO `siping_county` VALUES ('945', '231004', '爱民区', '231000');
INSERT INTO `siping_county` VALUES ('946', '231005', '西安区', '231000');
INSERT INTO `siping_county` VALUES ('947', '231024', '东宁县', '231000');
INSERT INTO `siping_county` VALUES ('948', '231025', '林口县', '231000');
INSERT INTO `siping_county` VALUES ('949', '231081', '绥芬河市', '231000');
INSERT INTO `siping_county` VALUES ('950', '231083', '海林市', '231000');
INSERT INTO `siping_county` VALUES ('951', '231084', '宁安市', '231000');
INSERT INTO `siping_county` VALUES ('952', '231085', '穆棱市', '231000');
INSERT INTO `siping_county` VALUES ('953', '231102', '爱辉区', '231100');
INSERT INTO `siping_county` VALUES ('954', '231123', '逊克县', '231100');
INSERT INTO `siping_county` VALUES ('955', '231121', '嫩江县', '231100');
INSERT INTO `siping_county` VALUES ('956', '231182', '五大连池市', '231100');
INSERT INTO `siping_county` VALUES ('957', '231124', '孙吴县', '231100');
INSERT INTO `siping_county` VALUES ('958', '231181', '北安市', '231100');
INSERT INTO `siping_county` VALUES ('959', '231202', '北林区', '231200');
INSERT INTO `siping_county` VALUES ('960', '231221', '望奎县', '231200');
INSERT INTO `siping_county` VALUES ('961', '231222', '兰西县', '231200');
INSERT INTO `siping_county` VALUES ('962', '231223', '青冈县', '231200');
INSERT INTO `siping_county` VALUES ('963', '231224', '庆安县', '231200');
INSERT INTO `siping_county` VALUES ('964', '231225', '明水县', '231200');
INSERT INTO `siping_county` VALUES ('965', '231226', '绥棱县', '231200');
INSERT INTO `siping_county` VALUES ('966', '231281', '安达市', '231200');
INSERT INTO `siping_county` VALUES ('967', '231282', '肇东市', '231200');
INSERT INTO `siping_county` VALUES ('968', '231283', '海伦市', '231200');
INSERT INTO `siping_county` VALUES ('969', '232721', '呼玛县', '232700');
INSERT INTO `siping_county` VALUES ('970', '232722', '塔河县', '232700');
INSERT INTO `siping_county` VALUES ('971', '232723', '漠河县', '232700');
INSERT INTO `siping_county` VALUES ('972', '410102', '中原区', '410100');
INSERT INTO `siping_county` VALUES ('973', '410105', '金水区', '410100');
INSERT INTO `siping_county` VALUES ('974', '410104', '管城回族区', '410100');
INSERT INTO `siping_county` VALUES ('975', '410103', '二七区', '410100');
INSERT INTO `siping_county` VALUES ('976', '410106', '上街区', '410100');
INSERT INTO `siping_county` VALUES ('977', '410181', '巩义市', '410100');
INSERT INTO `siping_county` VALUES ('978', '410182', '荥阳市', '410100');
INSERT INTO `siping_county` VALUES ('979', '410108', '惠济区', '410100');
INSERT INTO `siping_county` VALUES ('980', '410122', '中牟县', '410100');
INSERT INTO `siping_county` VALUES ('981', '410183', '新密市', '410100');
INSERT INTO `siping_county` VALUES ('982', '410184', '新郑市', '410100');
INSERT INTO `siping_county` VALUES ('983', '410185', '登封市', '410100');
INSERT INTO `siping_county` VALUES ('984', '410205', '禹王台区', '410200');
INSERT INTO `siping_county` VALUES ('985', '410204', '鼓楼区', '410200');
INSERT INTO `siping_county` VALUES ('986', '410202', '龙亭区', '410200');
INSERT INTO `siping_county` VALUES ('987', '410203', '顺河回族区', '410200');
INSERT INTO `siping_county` VALUES ('988', '410211', '金明区', '410200');
INSERT INTO `siping_county` VALUES ('989', '410221', '杞县', '410200');
INSERT INTO `siping_county` VALUES ('990', '410224', '开封县', '410200');
INSERT INTO `siping_county` VALUES ('991', '410222', '通许县', '410200');
INSERT INTO `siping_county` VALUES ('992', '410225', '兰考县', '410200');
INSERT INTO `siping_county` VALUES ('993', '410223', '尉氏县', '410200');
INSERT INTO `siping_county` VALUES ('994', '410303', '西工区', '410300');
INSERT INTO `siping_county` VALUES ('995', '410302', '老城区', '410300');
INSERT INTO `siping_county` VALUES ('996', '410304', '瀍河回族区', '410300');
INSERT INTO `siping_county` VALUES ('997', '410305', '涧西区', '410300');
INSERT INTO `siping_county` VALUES ('998', '410306', '吉利区', '410300');
INSERT INTO `siping_county` VALUES ('999', '410311', '洛龙区', '410300');
INSERT INTO `siping_county` VALUES ('1000', '410322', '孟津县', '410300');
INSERT INTO `siping_county` VALUES ('1001', '410323', '新安县', '410300');
INSERT INTO `siping_county` VALUES ('1002', '410324', '栾川县', '410300');
INSERT INTO `siping_county` VALUES ('1003', '410325', '嵩县', '410300');
INSERT INTO `siping_county` VALUES ('1004', '410326', '汝阳县', '410300');
INSERT INTO `siping_county` VALUES ('1005', '410327', '宜阳县', '410300');
INSERT INTO `siping_county` VALUES ('1006', '410328', '洛宁县', '410300');
INSERT INTO `siping_county` VALUES ('1007', '410381', '偃师市', '410300');
INSERT INTO `siping_county` VALUES ('1008', '410329', '伊川县', '410300');
INSERT INTO `siping_county` VALUES ('1009', '410402', '新华区', '410400');
INSERT INTO `siping_county` VALUES ('1010', '410403', '卫东区', '410400');
INSERT INTO `siping_county` VALUES ('1011', '410411', '湛河区', '410400');
INSERT INTO `siping_county` VALUES ('1012', '410404', '石龙区', '410400');
INSERT INTO `siping_county` VALUES ('1013', '410421', '宝丰县', '410400');
INSERT INTO `siping_county` VALUES ('1014', '410422', '叶县', '410400');
INSERT INTO `siping_county` VALUES ('1015', '410423', '鲁山县', '410400');
INSERT INTO `siping_county` VALUES ('1016', '410425', '郏县', '410400');
INSERT INTO `siping_county` VALUES ('1017', '410481', '舞钢市', '410400');
INSERT INTO `siping_county` VALUES ('1018', '410482', '汝州市', '410400');
INSERT INTO `siping_county` VALUES ('1019', '410502', '文峰区', '410500');
INSERT INTO `siping_county` VALUES ('1020', '410503', '北关区', '410500');
INSERT INTO `siping_county` VALUES ('1021', '410505', '殷都区', '410500');
INSERT INTO `siping_county` VALUES ('1022', '410522', '安阳县', '410500');
INSERT INTO `siping_county` VALUES ('1023', '410506', '龙安区', '410500');
INSERT INTO `siping_county` VALUES ('1024', '410526', '滑县', '410500');
INSERT INTO `siping_county` VALUES ('1025', '410523', '汤阴县', '410500');
INSERT INTO `siping_county` VALUES ('1026', '410527', '内黄县', '410500');
INSERT INTO `siping_county` VALUES ('1027', '410581', '林州市', '410500');
INSERT INTO `siping_county` VALUES ('1028', '410603', '山城区', '410600');
INSERT INTO `siping_county` VALUES ('1029', '410602', '鹤山区', '410600');
INSERT INTO `siping_county` VALUES ('1030', '410611', '淇滨区', '410600');
INSERT INTO `siping_county` VALUES ('1031', '410621', '浚县', '410600');
INSERT INTO `siping_county` VALUES ('1032', '410622', '淇县', '410600');
INSERT INTO `siping_county` VALUES ('1033', '410702', '红旗区', '410700');
INSERT INTO `siping_county` VALUES ('1034', '410703', '卫滨区', '410700');
INSERT INTO `siping_county` VALUES ('1035', '410704', '凤泉区', '410700');
INSERT INTO `siping_county` VALUES ('1036', '410711', '牧野区', '410700');
INSERT INTO `siping_county` VALUES ('1037', '410721', '新乡县', '410700');
INSERT INTO `siping_county` VALUES ('1038', '410724', '获嘉县', '410700');
INSERT INTO `siping_county` VALUES ('1039', '410725', '原阳县', '410700');
INSERT INTO `siping_county` VALUES ('1040', '410726', '延津县', '410700');
INSERT INTO `siping_county` VALUES ('1041', '410727', '封丘县', '410700');
INSERT INTO `siping_county` VALUES ('1042', '410728', '长垣县', '410700');
INSERT INTO `siping_county` VALUES ('1043', '410781', '卫辉市', '410700');
INSERT INTO `siping_county` VALUES ('1044', '410782', '辉县市', '410700');
INSERT INTO `siping_county` VALUES ('1045', '410802', '解放区', '410800');
INSERT INTO `siping_county` VALUES ('1046', '410804', '马村区', '410800');
INSERT INTO `siping_county` VALUES ('1047', '410803', '中站区', '410800');
INSERT INTO `siping_county` VALUES ('1048', '410811', '山阳区', '410800');
INSERT INTO `siping_county` VALUES ('1049', '410821', '修武县', '410800');
INSERT INTO `siping_county` VALUES ('1050', '410822', '博爱县', '410800');
INSERT INTO `siping_county` VALUES ('1051', '410823', '武陟县', '410800');
INSERT INTO `siping_county` VALUES ('1052', '410825', '温县', '410800');
INSERT INTO `siping_county` VALUES ('1053', '410882', '沁阳市', '410800');
INSERT INTO `siping_county` VALUES ('1054', '410883', '孟州市', '410800');
INSERT INTO `siping_county` VALUES ('1055', '410902', '华龙区', '410900');
INSERT INTO `siping_county` VALUES ('1056', '410922', '清丰县', '410900');
INSERT INTO `siping_county` VALUES ('1057', '410923', '南乐县', '410900');
INSERT INTO `siping_county` VALUES ('1058', '410926', '范县', '410900');
INSERT INTO `siping_county` VALUES ('1059', '410927', '台前县', '410900');
INSERT INTO `siping_county` VALUES ('1060', '410928', '濮阳县', '410900');
INSERT INTO `siping_county` VALUES ('1061', '411002', '魏都区', '411000');
INSERT INTO `siping_county` VALUES ('1062', '411023', '许昌县', '411000');
INSERT INTO `siping_county` VALUES ('1063', '411024', '鄢陵县', '411000');
INSERT INTO `siping_county` VALUES ('1064', '411025', '襄城县', '411000');
INSERT INTO `siping_county` VALUES ('1065', '411081', '禹州市', '411000');
INSERT INTO `siping_county` VALUES ('1066', '411082', '长葛市', '411000');
INSERT INTO `siping_county` VALUES ('1067', '411102', '源汇区', '411100');
INSERT INTO `siping_county` VALUES ('1068', '411103', '郾城区', '411100');
INSERT INTO `siping_county` VALUES ('1069', '411104', '召陵区', '411100');
INSERT INTO `siping_county` VALUES ('1070', '411121', '舞阳县', '411100');
INSERT INTO `siping_county` VALUES ('1071', '411122', '临颍县', '411100');
INSERT INTO `siping_county` VALUES ('1072', '411202', '湖滨区', '411200');
INSERT INTO `siping_county` VALUES ('1073', '411221', '渑池县', '411200');
INSERT INTO `siping_county` VALUES ('1074', '411222', '陕县', '411200');
INSERT INTO `siping_county` VALUES ('1075', '411224', '卢氏县', '411200');
INSERT INTO `siping_county` VALUES ('1076', '411281', '义马市', '411200');
INSERT INTO `siping_county` VALUES ('1077', '411282', '灵宝市', '411200');
INSERT INTO `siping_county` VALUES ('1078', '411302', '宛城区', '411300');
INSERT INTO `siping_county` VALUES ('1079', '411303', '卧龙区', '411300');
INSERT INTO `siping_county` VALUES ('1080', '411321', '南召县', '411300');
INSERT INTO `siping_county` VALUES ('1081', '411322', '方城县', '411300');
INSERT INTO `siping_county` VALUES ('1082', '411323', '西峡县', '411300');
INSERT INTO `siping_county` VALUES ('1083', '411324', '镇平县', '411300');
INSERT INTO `siping_county` VALUES ('1084', '411325', '内乡县', '411300');
INSERT INTO `siping_county` VALUES ('1085', '411326', '淅川县', '411300');
INSERT INTO `siping_county` VALUES ('1086', '411327', '社旗县', '411300');
INSERT INTO `siping_county` VALUES ('1087', '411328', '唐河县', '411300');
INSERT INTO `siping_county` VALUES ('1088', '411329', '新野县', '411300');
INSERT INTO `siping_county` VALUES ('1089', '411330', '桐柏县', '411300');
INSERT INTO `siping_county` VALUES ('1090', '411381', '邓州市', '411300');
INSERT INTO `siping_county` VALUES ('1091', '411402', '梁园区', '411400');
INSERT INTO `siping_county` VALUES ('1092', '411403', '睢阳区', '411400');
INSERT INTO `siping_county` VALUES ('1093', '411421', '民权县', '411400');
INSERT INTO `siping_county` VALUES ('1094', '411422', '睢县', '411400');
INSERT INTO `siping_county` VALUES ('1095', '411423', '宁陵县', '411400');
INSERT INTO `siping_county` VALUES ('1096', '411424', '柘城县', '411400');
INSERT INTO `siping_county` VALUES ('1097', '411425', '虞城县', '411400');
INSERT INTO `siping_county` VALUES ('1098', '411426', '夏邑县', '411400');
INSERT INTO `siping_county` VALUES ('1099', '411481', '永城市', '411400');
INSERT INTO `siping_county` VALUES ('1100', '411503', '平桥区', '411500');
INSERT INTO `siping_county` VALUES ('1101', '411502', '浉河区', '411500');
INSERT INTO `siping_county` VALUES ('1102', '411521', '罗山县', '411500');
INSERT INTO `siping_county` VALUES ('1103', '411522', '光山县', '411500');
INSERT INTO `siping_county` VALUES ('1104', '411523', '新县', '411500');
INSERT INTO `siping_county` VALUES ('1105', '411524', '商城县', '411500');
INSERT INTO `siping_county` VALUES ('1106', '411525', '固始县', '411500');
INSERT INTO `siping_county` VALUES ('1107', '411526', '潢川县', '411500');
INSERT INTO `siping_county` VALUES ('1108', '411527', '淮滨县', '411500');
INSERT INTO `siping_county` VALUES ('1109', '411602', '川汇区', '411600');
INSERT INTO `siping_county` VALUES ('1110', '411528', '息县', '411500');
INSERT INTO `siping_county` VALUES ('1111', '411621', '扶沟县', '411600');
INSERT INTO `siping_county` VALUES ('1112', '411622', '西华县', '411600');
INSERT INTO `siping_county` VALUES ('1113', '411623', '商水县', '411600');
INSERT INTO `siping_county` VALUES ('1114', '411624', '沈丘县', '411600');
INSERT INTO `siping_county` VALUES ('1115', '411625', '郸城县', '411600');
INSERT INTO `siping_county` VALUES ('1116', '411626', '淮阳县', '411600');
INSERT INTO `siping_county` VALUES ('1117', '411627', '太康县', '411600');
INSERT INTO `siping_county` VALUES ('1118', '411628', '鹿邑县', '411600');
INSERT INTO `siping_county` VALUES ('1119', '411681', '项城市', '411600');
INSERT INTO `siping_county` VALUES ('1120', '411702', '驿城区', '411700');
INSERT INTO `siping_county` VALUES ('1121', '411721', '西平县', '411700');
INSERT INTO `siping_county` VALUES ('1122', '411722', '上蔡县', '411700');
INSERT INTO `siping_county` VALUES ('1123', '411723', '平舆县', '411700');
INSERT INTO `siping_county` VALUES ('1124', '411724', '正阳县', '411700');
INSERT INTO `siping_county` VALUES ('1125', '411725', '确山县', '411700');
INSERT INTO `siping_county` VALUES ('1126', '411726', '泌阳县', '411700');
INSERT INTO `siping_county` VALUES ('1127', '411727', '汝南县', '411700');
INSERT INTO `siping_county` VALUES ('1128', '411728', '遂平县', '411700');
INSERT INTO `siping_county` VALUES ('1129', '411729', '新蔡县', '411700');
INSERT INTO `siping_county` VALUES ('1130', '419001', '济源市', '419000');
INSERT INTO `siping_county` VALUES ('1131', '420102', '江岸区', '420100');
INSERT INTO `siping_county` VALUES ('1132', '420103', '江汉区', '420100');
INSERT INTO `siping_county` VALUES ('1133', '420104', '硚口区', '420100');
INSERT INTO `siping_county` VALUES ('1134', '420105', '汉阳区', '420100');
INSERT INTO `siping_county` VALUES ('1135', '420106', '武昌区', '420100');
INSERT INTO `siping_county` VALUES ('1136', '420107', '青山区', '420100');
INSERT INTO `siping_county` VALUES ('1137', '420112', '东西湖区', '420100');
INSERT INTO `siping_county` VALUES ('1138', '420111', '洪山区', '420100');
INSERT INTO `siping_county` VALUES ('1139', '420113', '汉南区', '420100');
INSERT INTO `siping_county` VALUES ('1140', '420114', '蔡甸区', '420100');
INSERT INTO `siping_county` VALUES ('1141', '420115', '江夏区', '420100');
INSERT INTO `siping_county` VALUES ('1142', '420116', '黄陂区', '420100');
INSERT INTO `siping_county` VALUES ('1143', '420117', '新洲区', '420100');
INSERT INTO `siping_county` VALUES ('1144', '420202', '黄石港区', '420200');
INSERT INTO `siping_county` VALUES ('1145', '420203', '西塞山区', '420200');
INSERT INTO `siping_county` VALUES ('1146', '420205', '铁山区', '420200');
INSERT INTO `siping_county` VALUES ('1147', '420222', '阳新县', '420200');
INSERT INTO `siping_county` VALUES ('1148', '420204', '下陆区', '420200');
INSERT INTO `siping_county` VALUES ('1149', '420281', '大冶市', '420200');
INSERT INTO `siping_county` VALUES ('1150', '420302', '茅箭区', '420300');
INSERT INTO `siping_county` VALUES ('1151', '420303', '张湾区', '420300');
INSERT INTO `siping_county` VALUES ('1152', '420304', '郧阳区', '420300');
INSERT INTO `siping_county` VALUES ('1153', '420322', '郧西县', '420300');
INSERT INTO `siping_county` VALUES ('1154', '420323', '竹山县', '420300');
INSERT INTO `siping_county` VALUES ('1155', '420324', '竹溪县', '420300');
INSERT INTO `siping_county` VALUES ('1156', '420325', '房县', '420300');
INSERT INTO `siping_county` VALUES ('1157', '420381', '丹江口市', '420300');
INSERT INTO `siping_county` VALUES ('1158', '420502', '西陵区', '420500');
INSERT INTO `siping_county` VALUES ('1159', '420503', '伍家岗区', '420500');
INSERT INTO `siping_county` VALUES ('1160', '420505', '猇亭区', '420500');
INSERT INTO `siping_county` VALUES ('1161', '420506', '夷陵区', '420500');
INSERT INTO `siping_county` VALUES ('1162', '420504', '点军区', '420500');
INSERT INTO `siping_county` VALUES ('1163', '420525', '远安县', '420500');
INSERT INTO `siping_county` VALUES ('1164', '420526', '兴山县', '420500');
INSERT INTO `siping_county` VALUES ('1165', '420527', '秭归县', '420500');
INSERT INTO `siping_county` VALUES ('1166', '420528', '长阳土家族自治县', '420500');
INSERT INTO `siping_county` VALUES ('1167', '420529', '五峰土家族自治县', '420500');
INSERT INTO `siping_county` VALUES ('1168', '420581', '宜都市', '420500');
INSERT INTO `siping_county` VALUES ('1169', '420582', '当阳市', '420500');
INSERT INTO `siping_county` VALUES ('1170', '420583', '枝江市', '420500');
INSERT INTO `siping_county` VALUES ('1171', '420602', '襄城区', '420600');
INSERT INTO `siping_county` VALUES ('1172', '420606', '樊城区', '420600');
INSERT INTO `siping_county` VALUES ('1173', '420607', '襄州区', '420600');
INSERT INTO `siping_county` VALUES ('1174', '420624', '南漳县', '420600');
INSERT INTO `siping_county` VALUES ('1175', '420625', '谷城县', '420600');
INSERT INTO `siping_county` VALUES ('1176', '420682', '老河口市', '420600');
INSERT INTO `siping_county` VALUES ('1177', '420684', '宜城市', '420600');
INSERT INTO `siping_county` VALUES ('1178', '420626', '保康县', '420600');
INSERT INTO `siping_county` VALUES ('1179', '420683', '枣阳市', '420600');
INSERT INTO `siping_county` VALUES ('1180', '420702', '梁子湖区', '420700');
INSERT INTO `siping_county` VALUES ('1181', '420703', '华容区', '420700');
INSERT INTO `siping_county` VALUES ('1182', '420704', '鄂城区', '420700');
INSERT INTO `siping_county` VALUES ('1183', '420802', '东宝区', '420800');
INSERT INTO `siping_county` VALUES ('1184', '420804', '掇刀区', '420800');
INSERT INTO `siping_county` VALUES ('1185', '420821', '京山县', '420800');
INSERT INTO `siping_county` VALUES ('1186', '420822', '沙洋县', '420800');
INSERT INTO `siping_county` VALUES ('1187', '420881', '钟祥市', '420800');
INSERT INTO `siping_county` VALUES ('1188', '420902', '孝南区', '420900');
INSERT INTO `siping_county` VALUES ('1189', '420921', '孝昌县', '420900');
INSERT INTO `siping_county` VALUES ('1190', '420923', '云梦县', '420900');
INSERT INTO `siping_county` VALUES ('1191', '420922', '大悟县', '420900');
INSERT INTO `siping_county` VALUES ('1192', '420981', '应城市', '420900');
INSERT INTO `siping_county` VALUES ('1193', '420982', '安陆市', '420900');
INSERT INTO `siping_county` VALUES ('1194', '420984', '汉川市', '420900');
INSERT INTO `siping_county` VALUES ('1195', '421002', '沙市区', '421000');
INSERT INTO `siping_county` VALUES ('1196', '421024', '江陵县', '421000');
INSERT INTO `siping_county` VALUES ('1197', '421022', '公安县', '421000');
INSERT INTO `siping_county` VALUES ('1198', '421023', '监利县', '421000');
INSERT INTO `siping_county` VALUES ('1199', '421003', '荆州区', '421000');
INSERT INTO `siping_county` VALUES ('1200', '421081', '石首市', '421000');
INSERT INTO `siping_county` VALUES ('1201', '421083', '洪湖市', '421000');
INSERT INTO `siping_county` VALUES ('1202', '421087', '松滋市', '421000');
INSERT INTO `siping_county` VALUES ('1203', '421102', '黄州区', '421100');
INSERT INTO `siping_county` VALUES ('1204', '421121', '团风县', '421100');
INSERT INTO `siping_county` VALUES ('1205', '421122', '红安县', '421100');
INSERT INTO `siping_county` VALUES ('1206', '421123', '罗田县', '421100');
INSERT INTO `siping_county` VALUES ('1207', '421125', '浠水县', '421100');
INSERT INTO `siping_county` VALUES ('1208', '421124', '英山县', '421100');
INSERT INTO `siping_county` VALUES ('1209', '421126', '蕲春县', '421100');
INSERT INTO `siping_county` VALUES ('1210', '421127', '黄梅县', '421100');
INSERT INTO `siping_county` VALUES ('1211', '421181', '麻城市', '421100');
INSERT INTO `siping_county` VALUES ('1212', '421202', '咸安区', '421200');
INSERT INTO `siping_county` VALUES ('1213', '421182', '武穴市', '421100');
INSERT INTO `siping_county` VALUES ('1214', '421221', '嘉鱼县', '421200');
INSERT INTO `siping_county` VALUES ('1215', '421222', '通城县', '421200');
INSERT INTO `siping_county` VALUES ('1216', '421223', '崇阳县', '421200');
INSERT INTO `siping_county` VALUES ('1217', '421224', '通山县', '421200');
INSERT INTO `siping_county` VALUES ('1218', '421303', '曾都区', '421300');
INSERT INTO `siping_county` VALUES ('1219', '421321', '随县', '421300');
INSERT INTO `siping_county` VALUES ('1220', '421281', '赤壁市', '421200');
INSERT INTO `siping_county` VALUES ('1221', '422801', '恩施市', '422800');
INSERT INTO `siping_county` VALUES ('1222', '421381', '广水市', '421300');
INSERT INTO `siping_county` VALUES ('1223', '422822', '建始县', '422800');
INSERT INTO `siping_county` VALUES ('1224', '422823', '巴东县', '422800');
INSERT INTO `siping_county` VALUES ('1225', '422802', '利川市', '422800');
INSERT INTO `siping_county` VALUES ('1226', '422825', '宣恩县', '422800');
INSERT INTO `siping_county` VALUES ('1227', '422826', '咸丰县', '422800');
INSERT INTO `siping_county` VALUES ('1228', '422827', '来凤县', '422800');
INSERT INTO `siping_county` VALUES ('1229', '429004', '仙桃市', '429000');
INSERT INTO `siping_county` VALUES ('1230', '422828', '鹤峰县', '422800');
INSERT INTO `siping_county` VALUES ('1231', '429005', '潜江市', '429000');
INSERT INTO `siping_county` VALUES ('1232', '429006', '天门市', '429000');
INSERT INTO `siping_county` VALUES ('1233', '429021', '神农架林区', '429000');
INSERT INTO `siping_county` VALUES ('1234', '430102', '芙蓉区', '430100');
INSERT INTO `siping_county` VALUES ('1235', '430103', '天心区', '430100');
INSERT INTO `siping_county` VALUES ('1236', '430104', '岳麓区', '430100');
INSERT INTO `siping_county` VALUES ('1237', '430105', '开福区', '430100');
INSERT INTO `siping_county` VALUES ('1238', '430111', '雨花区', '430100');
INSERT INTO `siping_county` VALUES ('1239', '430121', '长沙县', '430100');
INSERT INTO `siping_county` VALUES ('1240', '430112', '望城区', '430100');
INSERT INTO `siping_county` VALUES ('1241', '430124', '宁乡县', '430100');
INSERT INTO `siping_county` VALUES ('1242', '430181', '浏阳市', '430100');
INSERT INTO `siping_county` VALUES ('1243', '430202', '荷塘区', '430200');
INSERT INTO `siping_county` VALUES ('1244', '430203', '芦淞区', '430200');
INSERT INTO `siping_county` VALUES ('1245', '430204', '石峰区', '430200');
INSERT INTO `siping_county` VALUES ('1246', '430211', '天元区', '430200');
INSERT INTO `siping_county` VALUES ('1247', '430221', '株洲县', '430200');
INSERT INTO `siping_county` VALUES ('1248', '430223', '攸县', '430200');
INSERT INTO `siping_county` VALUES ('1249', '430224', '茶陵县', '430200');
INSERT INTO `siping_county` VALUES ('1250', '430225', '炎陵县', '430200');
INSERT INTO `siping_county` VALUES ('1251', '430281', '醴陵市', '430200');
INSERT INTO `siping_county` VALUES ('1252', '430302', '雨湖区', '430300');
INSERT INTO `siping_county` VALUES ('1253', '430304', '岳塘区', '430300');
INSERT INTO `siping_county` VALUES ('1254', '430321', '湘潭县', '430300');
INSERT INTO `siping_county` VALUES ('1255', '430381', '湘乡市', '430300');
INSERT INTO `siping_county` VALUES ('1256', '430382', '韶山市', '430300');
INSERT INTO `siping_county` VALUES ('1257', '430405', '珠晖区', '430400');
INSERT INTO `siping_county` VALUES ('1258', '430406', '雁峰区', '430400');
INSERT INTO `siping_county` VALUES ('1259', '430407', '石鼓区', '430400');
INSERT INTO `siping_county` VALUES ('1260', '430408', '蒸湘区', '430400');
INSERT INTO `siping_county` VALUES ('1261', '430412', '南岳区', '430400');
INSERT INTO `siping_county` VALUES ('1262', '430421', '衡阳县', '430400');
INSERT INTO `siping_county` VALUES ('1263', '430422', '衡南县', '430400');
INSERT INTO `siping_county` VALUES ('1264', '430423', '衡山县', '430400');
INSERT INTO `siping_county` VALUES ('1265', '430424', '衡东县', '430400');
INSERT INTO `siping_county` VALUES ('1266', '430426', '祁东县', '430400');
INSERT INTO `siping_county` VALUES ('1267', '430481', '耒阳市', '430400');
INSERT INTO `siping_county` VALUES ('1268', '430482', '常宁市', '430400');
INSERT INTO `siping_county` VALUES ('1269', '430502', '双清区', '430500');
INSERT INTO `siping_county` VALUES ('1270', '430503', '大祥区', '430500');
INSERT INTO `siping_county` VALUES ('1271', '430511', '北塔区', '430500');
INSERT INTO `siping_county` VALUES ('1272', '430521', '邵东县', '430500');
INSERT INTO `siping_county` VALUES ('1273', '430522', '新邵县', '430500');
INSERT INTO `siping_county` VALUES ('1274', '430523', '邵阳县', '430500');
INSERT INTO `siping_county` VALUES ('1275', '430524', '隆回县', '430500');
INSERT INTO `siping_county` VALUES ('1276', '430525', '洞口县', '430500');
INSERT INTO `siping_county` VALUES ('1277', '430527', '绥宁县', '430500');
INSERT INTO `siping_county` VALUES ('1278', '430528', '新宁县', '430500');
INSERT INTO `siping_county` VALUES ('1279', '430581', '武冈市', '430500');
INSERT INTO `siping_county` VALUES ('1280', '430529', '城步苗族自治县', '430500');
INSERT INTO `siping_county` VALUES ('1281', '430602', '岳阳楼区', '430600');
INSERT INTO `siping_county` VALUES ('1282', '430603', '云溪区', '430600');
INSERT INTO `siping_county` VALUES ('1283', '430621', '岳阳县', '430600');
INSERT INTO `siping_county` VALUES ('1284', '430623', '华容县', '430600');
INSERT INTO `siping_county` VALUES ('1285', '430611', '君山区', '430600');
INSERT INTO `siping_county` VALUES ('1286', '430624', '湘阴县', '430600');
INSERT INTO `siping_county` VALUES ('1287', '430626', '平江县', '430600');
INSERT INTO `siping_county` VALUES ('1288', '430681', '汨罗市', '430600');
INSERT INTO `siping_county` VALUES ('1289', '430682', '临湘市', '430600');
INSERT INTO `siping_county` VALUES ('1290', '430702', '武陵区', '430700');
INSERT INTO `siping_county` VALUES ('1291', '430703', '鼎城区', '430700');
INSERT INTO `siping_county` VALUES ('1292', '430721', '安乡县', '430700');
INSERT INTO `siping_county` VALUES ('1293', '430722', '汉寿县', '430700');
INSERT INTO `siping_county` VALUES ('1294', '430723', '澧县', '430700');
INSERT INTO `siping_county` VALUES ('1295', '430724', '临澧县', '430700');
INSERT INTO `siping_county` VALUES ('1296', '430725', '桃源县', '430700');
INSERT INTO `siping_county` VALUES ('1297', '430781', '津市市', '430700');
INSERT INTO `siping_county` VALUES ('1298', '430811', '武陵源区', '430800');
INSERT INTO `siping_county` VALUES ('1299', '430726', '石门县', '430700');
INSERT INTO `siping_county` VALUES ('1300', '430802', '永定区', '430800');
INSERT INTO `siping_county` VALUES ('1301', '430821', '慈利县', '430800');
INSERT INTO `siping_county` VALUES ('1302', '430822', '桑植县', '430800');
INSERT INTO `siping_county` VALUES ('1303', '430902', '资阳区', '430900');
INSERT INTO `siping_county` VALUES ('1304', '430903', '赫山区', '430900');
INSERT INTO `siping_county` VALUES ('1305', '430921', '南县', '430900');
INSERT INTO `siping_county` VALUES ('1306', '430923', '安化县', '430900');
INSERT INTO `siping_county` VALUES ('1307', '430922', '桃江县', '430900');
INSERT INTO `siping_county` VALUES ('1308', '431002', '北湖区', '431000');
INSERT INTO `siping_county` VALUES ('1309', '431003', '苏仙区', '431000');
INSERT INTO `siping_county` VALUES ('1310', '430981', '沅江市', '430900');
INSERT INTO `siping_county` VALUES ('1311', '431021', '桂阳县', '431000');
INSERT INTO `siping_county` VALUES ('1312', '431022', '宜章县', '431000');
INSERT INTO `siping_county` VALUES ('1313', '431023', '永兴县', '431000');
INSERT INTO `siping_county` VALUES ('1314', '431024', '嘉禾县', '431000');
INSERT INTO `siping_county` VALUES ('1315', '431025', '临武县', '431000');
INSERT INTO `siping_county` VALUES ('1316', '431026', '汝城县', '431000');
INSERT INTO `siping_county` VALUES ('1317', '431028', '安仁县', '431000');
INSERT INTO `siping_county` VALUES ('1318', '431027', '桂东县', '431000');
INSERT INTO `siping_county` VALUES ('1319', '431081', '资兴市', '431000');
INSERT INTO `siping_county` VALUES ('1320', '431102', '零陵区', '431100');
INSERT INTO `siping_county` VALUES ('1321', '431103', '冷水滩区', '431100');
INSERT INTO `siping_county` VALUES ('1322', '431121', '祁阳县', '431100');
INSERT INTO `siping_county` VALUES ('1323', '431122', '东安县', '431100');
INSERT INTO `siping_county` VALUES ('1324', '431123', '双牌县', '431100');
INSERT INTO `siping_county` VALUES ('1325', '431124', '道县', '431100');
INSERT INTO `siping_county` VALUES ('1326', '431125', '江永县', '431100');
INSERT INTO `siping_county` VALUES ('1327', '431126', '宁远县', '431100');
INSERT INTO `siping_county` VALUES ('1328', '431127', '蓝山县', '431100');
INSERT INTO `siping_county` VALUES ('1329', '431128', '新田县', '431100');
INSERT INTO `siping_county` VALUES ('1330', '431129', '江华瑶族自治县', '431100');
INSERT INTO `siping_county` VALUES ('1331', '431202', '鹤城区', '431200');
INSERT INTO `siping_county` VALUES ('1332', '431221', '中方县', '431200');
INSERT INTO `siping_county` VALUES ('1333', '431223', '辰溪县', '431200');
INSERT INTO `siping_county` VALUES ('1334', '431222', '沅陵县', '431200');
INSERT INTO `siping_county` VALUES ('1335', '431224', '溆浦县', '431200');
INSERT INTO `siping_county` VALUES ('1336', '431225', '会同县', '431200');
INSERT INTO `siping_county` VALUES ('1337', '431227', '新晃侗族自治县', '431200');
INSERT INTO `siping_county` VALUES ('1338', '431226', '麻阳苗族自治县', '431200');
INSERT INTO `siping_county` VALUES ('1339', '431228', '芷江侗族自治县', '431200');
INSERT INTO `siping_county` VALUES ('1340', '431229', '靖州苗族侗族自治县', '431200');
INSERT INTO `siping_county` VALUES ('1341', '431230', '通道侗族自治县', '431200');
INSERT INTO `siping_county` VALUES ('1342', '431281', '洪江市', '431200');
INSERT INTO `siping_county` VALUES ('1343', '431302', '娄星区', '431300');
INSERT INTO `siping_county` VALUES ('1344', '431321', '双峰县', '431300');
INSERT INTO `siping_county` VALUES ('1345', '431322', '新化县', '431300');
INSERT INTO `siping_county` VALUES ('1346', '431381', '冷水江市', '431300');
INSERT INTO `siping_county` VALUES ('1347', '431382', '涟源市', '431300');
INSERT INTO `siping_county` VALUES ('1348', '433123', '凤凰县', '433100');
INSERT INTO `siping_county` VALUES ('1349', '433122', '泸溪县', '433100');
INSERT INTO `siping_county` VALUES ('1350', '433101', '吉首市', '433100');
INSERT INTO `siping_county` VALUES ('1351', '433124', '花垣县', '433100');
INSERT INTO `siping_county` VALUES ('1352', '433125', '保靖县', '433100');
INSERT INTO `siping_county` VALUES ('1353', '433126', '古丈县', '433100');
INSERT INTO `siping_county` VALUES ('1354', '433127', '永顺县', '433100');
INSERT INTO `siping_county` VALUES ('1355', '433130', '龙山县', '433100');
INSERT INTO `siping_county` VALUES ('1356', '320102', '玄武区', '320100');
INSERT INTO `siping_county` VALUES ('1357', '320106', '鼓楼区', '320100');
INSERT INTO `siping_county` VALUES ('1358', '320111', '浦口区', '320100');
INSERT INTO `siping_county` VALUES ('1359', '320104', '秦淮区', '320100');
INSERT INTO `siping_county` VALUES ('1360', '320105', '建邺区', '320100');
INSERT INTO `siping_county` VALUES ('1361', '320113', '栖霞区', '320100');
INSERT INTO `siping_county` VALUES ('1362', '320114', '雨花台区', '320100');
INSERT INTO `siping_county` VALUES ('1363', '320115', '江宁区', '320100');
INSERT INTO `siping_county` VALUES ('1364', '320116', '六合区', '320100');
INSERT INTO `siping_county` VALUES ('1365', '320118', '高淳区', '320100');
INSERT INTO `siping_county` VALUES ('1366', '320117', '溧水区', '320100');
INSERT INTO `siping_county` VALUES ('1367', '320202', '崇安区', '320200');
INSERT INTO `siping_county` VALUES ('1368', '320203', '南长区', '320200');
INSERT INTO `siping_county` VALUES ('1369', '320204', '北塘区', '320200');
INSERT INTO `siping_county` VALUES ('1370', '320205', '锡山区', '320200');
INSERT INTO `siping_county` VALUES ('1371', '320206', '惠山区', '320200');
INSERT INTO `siping_county` VALUES ('1372', '320211', '滨湖区', '320200');
INSERT INTO `siping_county` VALUES ('1373', '320282', '宜兴市', '320200');
INSERT INTO `siping_county` VALUES ('1374', '320281', '江阴市', '320200');
INSERT INTO `siping_county` VALUES ('1375', '320302', '鼓楼区', '320300');
INSERT INTO `siping_county` VALUES ('1376', '320303', '云龙区', '320300');
INSERT INTO `siping_county` VALUES ('1377', '320305', '贾汪区', '320300');
INSERT INTO `siping_county` VALUES ('1378', '320311', '泉山区', '320300');
INSERT INTO `siping_county` VALUES ('1379', '320312', '铜山区', '320300');
INSERT INTO `siping_county` VALUES ('1380', '320321', '丰县', '320300');
INSERT INTO `siping_county` VALUES ('1381', '320322', '沛县', '320300');
INSERT INTO `siping_county` VALUES ('1382', '320324', '睢宁县', '320300');
INSERT INTO `siping_county` VALUES ('1383', '320404', '钟楼区', '320400');
INSERT INTO `siping_county` VALUES ('1384', '320381', '新沂市', '320300');
INSERT INTO `siping_county` VALUES ('1385', '320405', '戚墅堰区', '320400');
INSERT INTO `siping_county` VALUES ('1386', '320402', '天宁区', '320400');
INSERT INTO `siping_county` VALUES ('1387', '320382', '邳州市', '320300');
INSERT INTO `siping_county` VALUES ('1388', '320411', '新北区', '320400');
INSERT INTO `siping_county` VALUES ('1389', '320412', '武进区', '320400');
INSERT INTO `siping_county` VALUES ('1390', '320481', '溧阳市', '320400');
INSERT INTO `siping_county` VALUES ('1391', '320482', '金坛市', '320400');
INSERT INTO `siping_county` VALUES ('1392', '320505', '虎丘区', '320500');
INSERT INTO `siping_county` VALUES ('1393', '320506', '吴中区', '320500');
INSERT INTO `siping_county` VALUES ('1394', '320507', '相城区', '320500');
INSERT INTO `siping_county` VALUES ('1395', '320581', '常熟市', '320500');
INSERT INTO `siping_county` VALUES ('1396', '320509', '吴江区', '320500');
INSERT INTO `siping_county` VALUES ('1397', '320508', '姑苏区', '320500');
INSERT INTO `siping_county` VALUES ('1398', '320582', '张家港市', '320500');
INSERT INTO `siping_county` VALUES ('1399', '320583', '昆山市', '320500');
INSERT INTO `siping_county` VALUES ('1400', '320585', '太仓市', '320500');
INSERT INTO `siping_county` VALUES ('1401', '320602', '崇川区', '320600');
INSERT INTO `siping_county` VALUES ('1402', '320611', '港闸区', '320600');
INSERT INTO `siping_county` VALUES ('1403', '320612', '通州区', '320600');
INSERT INTO `siping_county` VALUES ('1404', '320621', '海安县', '320600');
INSERT INTO `siping_county` VALUES ('1405', '320623', '如东县', '320600');
INSERT INTO `siping_county` VALUES ('1406', '320681', '启东市', '320600');
INSERT INTO `siping_county` VALUES ('1407', '320682', '如皋市', '320600');
INSERT INTO `siping_county` VALUES ('1408', '320684', '海门市', '320600');
INSERT INTO `siping_county` VALUES ('1409', '320703', '连云区', '320700');
INSERT INTO `siping_county` VALUES ('1410', '320707', '赣榆区', '320700');
INSERT INTO `siping_county` VALUES ('1411', '320706', '海州区', '320700');
INSERT INTO `siping_county` VALUES ('1412', '320722', '东海县', '320700');
INSERT INTO `siping_county` VALUES ('1413', '320723', '灌云县', '320700');
INSERT INTO `siping_county` VALUES ('1414', '320724', '灌南县', '320700');
INSERT INTO `siping_county` VALUES ('1415', '320802', '清河区', '320800');
INSERT INTO `siping_county` VALUES ('1416', '320804', '淮阴区', '320800');
INSERT INTO `siping_county` VALUES ('1417', '320803', '淮安区', '320800');
INSERT INTO `siping_county` VALUES ('1418', '320826', '涟水县', '320800');
INSERT INTO `siping_county` VALUES ('1419', '320811', '清浦区', '320800');
INSERT INTO `siping_county` VALUES ('1420', '320829', '洪泽县', '320800');
INSERT INTO `siping_county` VALUES ('1421', '320830', '盱眙县', '320800');
INSERT INTO `siping_county` VALUES ('1422', '320831', '金湖县', '320800');
INSERT INTO `siping_county` VALUES ('1423', '320902', '亭湖区', '320900');
INSERT INTO `siping_county` VALUES ('1424', '320903', '盐都区', '320900');
INSERT INTO `siping_county` VALUES ('1425', '320921', '响水县', '320900');
INSERT INTO `siping_county` VALUES ('1426', '320922', '滨海县', '320900');
INSERT INTO `siping_county` VALUES ('1427', '320923', '阜宁县', '320900');
INSERT INTO `siping_county` VALUES ('1428', '320925', '建湖县', '320900');
INSERT INTO `siping_county` VALUES ('1429', '320924', '射阳县', '320900');
INSERT INTO `siping_county` VALUES ('1430', '320981', '东台市', '320900');
INSERT INTO `siping_county` VALUES ('1431', '320982', '大丰市', '320900');
INSERT INTO `siping_county` VALUES ('1432', '321002', '广陵区', '321000');
INSERT INTO `siping_county` VALUES ('1433', '321003', '邗江区', '321000');
INSERT INTO `siping_county` VALUES ('1434', '321012', '江都区', '321000');
INSERT INTO `siping_county` VALUES ('1435', '321023', '宝应县', '321000');
INSERT INTO `siping_county` VALUES ('1436', '321081', '仪征市', '321000');
INSERT INTO `siping_county` VALUES ('1437', '321084', '高邮市', '321000');
INSERT INTO `siping_county` VALUES ('1438', '321102', '京口区', '321100');
INSERT INTO `siping_county` VALUES ('1439', '321111', '润州区', '321100');
INSERT INTO `siping_county` VALUES ('1440', '321112', '丹徒区', '321100');
INSERT INTO `siping_county` VALUES ('1441', '321181', '丹阳市', '321100');
INSERT INTO `siping_county` VALUES ('1442', '321182', '扬中市', '321100');
INSERT INTO `siping_county` VALUES ('1443', '321183', '句容市', '321100');
INSERT INTO `siping_county` VALUES ('1444', '321202', '海陵区', '321200');
INSERT INTO `siping_county` VALUES ('1445', '321203', '高港区', '321200');
INSERT INTO `siping_county` VALUES ('1446', '321204', '姜堰区', '321200');
INSERT INTO `siping_county` VALUES ('1447', '321281', '兴化市', '321200');
INSERT INTO `siping_county` VALUES ('1448', '321282', '靖江市', '321200');
INSERT INTO `siping_county` VALUES ('1449', '321283', '泰兴市', '321200');
INSERT INTO `siping_county` VALUES ('1450', '321311', '宿豫区', '321300');
INSERT INTO `siping_county` VALUES ('1451', '321322', '沭阳县', '321300');
INSERT INTO `siping_county` VALUES ('1452', '321302', '宿城区', '321300');
INSERT INTO `siping_county` VALUES ('1453', '321323', '泗阳县', '321300');
INSERT INTO `siping_county` VALUES ('1454', '321324', '泗洪县', '321300');
INSERT INTO `siping_county` VALUES ('1455', '360102', '东湖区', '360100');
INSERT INTO `siping_county` VALUES ('1456', '360103', '西湖区', '360100');
INSERT INTO `siping_county` VALUES ('1457', '360104', '青云谱区', '360100');
INSERT INTO `siping_county` VALUES ('1458', '360105', '湾里区', '360100');
INSERT INTO `siping_county` VALUES ('1459', '360111', '青山湖区', '360100');
INSERT INTO `siping_county` VALUES ('1460', '360121', '南昌县', '360100');
INSERT INTO `siping_county` VALUES ('1461', '360122', '新建县', '360100');
INSERT INTO `siping_county` VALUES ('1462', '360123', '安义县', '360100');
INSERT INTO `siping_county` VALUES ('1463', '360124', '进贤县', '360100');
INSERT INTO `siping_county` VALUES ('1464', '360202', '昌江区', '360200');
INSERT INTO `siping_county` VALUES ('1465', '360203', '珠山区', '360200');
INSERT INTO `siping_county` VALUES ('1466', '360222', '浮梁县', '360200');
INSERT INTO `siping_county` VALUES ('1467', '360281', '乐平市', '360200');
INSERT INTO `siping_county` VALUES ('1468', '360302', '安源区', '360300');
INSERT INTO `siping_county` VALUES ('1469', '360313', '湘东区', '360300');
INSERT INTO `siping_county` VALUES ('1470', '360321', '莲花县', '360300');
INSERT INTO `siping_county` VALUES ('1471', '360322', '上栗县', '360300');
INSERT INTO `siping_county` VALUES ('1472', '360323', '芦溪县', '360300');
INSERT INTO `siping_county` VALUES ('1473', '360402', '庐山区', '360400');
INSERT INTO `siping_county` VALUES ('1474', '360421', '九江县', '360400');
INSERT INTO `siping_county` VALUES ('1475', '360403', '浔阳区', '360400');
INSERT INTO `siping_county` VALUES ('1476', '360423', '武宁县', '360400');
INSERT INTO `siping_county` VALUES ('1477', '360424', '修水县', '360400');
INSERT INTO `siping_county` VALUES ('1478', '360425', '永修县', '360400');
INSERT INTO `siping_county` VALUES ('1479', '360426', '德安县', '360400');
INSERT INTO `siping_county` VALUES ('1480', '360427', '星子县', '360400');
INSERT INTO `siping_county` VALUES ('1481', '360428', '都昌县', '360400');
INSERT INTO `siping_county` VALUES ('1482', '360429', '湖口县', '360400');
INSERT INTO `siping_county` VALUES ('1483', '360430', '彭泽县', '360400');
INSERT INTO `siping_county` VALUES ('1484', '360481', '瑞昌市', '360400');
INSERT INTO `siping_county` VALUES ('1485', '360482', '共青城市', '360400');
INSERT INTO `siping_county` VALUES ('1486', '360502', '渝水区', '360500');
INSERT INTO `siping_county` VALUES ('1487', '360521', '分宜县', '360500');
INSERT INTO `siping_county` VALUES ('1488', '360602', '月湖区', '360600');
INSERT INTO `siping_county` VALUES ('1489', '360622', '余江县', '360600');
INSERT INTO `siping_county` VALUES ('1490', '360681', '贵溪市', '360600');
INSERT INTO `siping_county` VALUES ('1491', '360702', '章贡区', '360700');
INSERT INTO `siping_county` VALUES ('1492', '360703', '南康区', '360700');
INSERT INTO `siping_county` VALUES ('1493', '360721', '赣县', '360700');
INSERT INTO `siping_county` VALUES ('1494', '360722', '信丰县', '360700');
INSERT INTO `siping_county` VALUES ('1495', '360724', '上犹县', '360700');
INSERT INTO `siping_county` VALUES ('1496', '360723', '大余县', '360700');
INSERT INTO `siping_county` VALUES ('1497', '360725', '崇义县', '360700');
INSERT INTO `siping_county` VALUES ('1498', '360727', '龙南县', '360700');
INSERT INTO `siping_county` VALUES ('1499', '360726', '安远县', '360700');
INSERT INTO `siping_county` VALUES ('1500', '360728', '定南县', '360700');
INSERT INTO `siping_county` VALUES ('1501', '360729', '全南县', '360700');
INSERT INTO `siping_county` VALUES ('1502', '360730', '宁都县', '360700');
INSERT INTO `siping_county` VALUES ('1503', '360731', '于都县', '360700');
INSERT INTO `siping_county` VALUES ('1504', '360732', '兴国县', '360700');
INSERT INTO `siping_county` VALUES ('1505', '360733', '会昌县', '360700');
INSERT INTO `siping_county` VALUES ('1506', '360734', '寻乌县', '360700');
INSERT INTO `siping_county` VALUES ('1507', '360735', '石城县', '360700');
INSERT INTO `siping_county` VALUES ('1508', '360781', '瑞金市', '360700');
INSERT INTO `siping_county` VALUES ('1509', '360802', '吉州区', '360800');
INSERT INTO `siping_county` VALUES ('1510', '360803', '青原区', '360800');
INSERT INTO `siping_county` VALUES ('1511', '360821', '吉安县', '360800');
INSERT INTO `siping_county` VALUES ('1512', '360822', '吉水县', '360800');
INSERT INTO `siping_county` VALUES ('1513', '360823', '峡江县', '360800');
INSERT INTO `siping_county` VALUES ('1514', '360824', '新干县', '360800');
INSERT INTO `siping_county` VALUES ('1515', '360825', '永丰县', '360800');
INSERT INTO `siping_county` VALUES ('1516', '360826', '泰和县', '360800');
INSERT INTO `siping_county` VALUES ('1517', '360827', '遂川县', '360800');
INSERT INTO `siping_county` VALUES ('1518', '360828', '万安县', '360800');
INSERT INTO `siping_county` VALUES ('1519', '360829', '安福县', '360800');
INSERT INTO `siping_county` VALUES ('1520', '360830', '永新县', '360800');
INSERT INTO `siping_county` VALUES ('1521', '360881', '井冈山市', '360800');
INSERT INTO `siping_county` VALUES ('1522', '360902', '袁州区', '360900');
INSERT INTO `siping_county` VALUES ('1523', '360921', '奉新县', '360900');
INSERT INTO `siping_county` VALUES ('1524', '360922', '万载县', '360900');
INSERT INTO `siping_county` VALUES ('1525', '360923', '上高县', '360900');
INSERT INTO `siping_county` VALUES ('1526', '360924', '宜丰县', '360900');
INSERT INTO `siping_county` VALUES ('1527', '360926', '铜鼓县', '360900');
INSERT INTO `siping_county` VALUES ('1528', '360925', '靖安县', '360900');
INSERT INTO `siping_county` VALUES ('1529', '360982', '樟树市', '360900');
INSERT INTO `siping_county` VALUES ('1530', '360981', '丰城市', '360900');
INSERT INTO `siping_county` VALUES ('1531', '360983', '高安市', '360900');
INSERT INTO `siping_county` VALUES ('1532', '361002', '临川区', '361000');
INSERT INTO `siping_county` VALUES ('1533', '361021', '南城县', '361000');
INSERT INTO `siping_county` VALUES ('1534', '361022', '黎川县', '361000');
INSERT INTO `siping_county` VALUES ('1535', '361023', '南丰县', '361000');
INSERT INTO `siping_county` VALUES ('1536', '361025', '乐安县', '361000');
INSERT INTO `siping_county` VALUES ('1537', '361024', '崇仁县', '361000');
INSERT INTO `siping_county` VALUES ('1538', '361026', '宜黄县', '361000');
INSERT INTO `siping_county` VALUES ('1539', '361027', '金溪县', '361000');
INSERT INTO `siping_county` VALUES ('1540', '361028', '资溪县', '361000');
INSERT INTO `siping_county` VALUES ('1541', '361029', '东乡县', '361000');
INSERT INTO `siping_county` VALUES ('1542', '361102', '信州区', '361100');
INSERT INTO `siping_county` VALUES ('1543', '361030', '广昌县', '361000');
INSERT INTO `siping_county` VALUES ('1544', '361121', '上饶县', '361100');
INSERT INTO `siping_county` VALUES ('1545', '361122', '广丰县', '361100');
INSERT INTO `siping_county` VALUES ('1546', '361124', '铅山县', '361100');
INSERT INTO `siping_county` VALUES ('1547', '361125', '横峰县', '361100');
INSERT INTO `siping_county` VALUES ('1548', '361127', '余干县', '361100');
INSERT INTO `siping_county` VALUES ('1549', '361123', '玉山县', '361100');
INSERT INTO `siping_county` VALUES ('1550', '361126', '弋阳县', '361100');
INSERT INTO `siping_county` VALUES ('1551', '361128', '鄱阳县', '361100');
INSERT INTO `siping_county` VALUES ('1552', '361129', '万年县', '361100');
INSERT INTO `siping_county` VALUES ('1553', '361181', '德兴市', '361100');
INSERT INTO `siping_county` VALUES ('1554', '361130', '婺源县', '361100');
INSERT INTO `siping_county` VALUES ('1555', '220102', '南关区', '220100');
INSERT INTO `siping_county` VALUES ('1556', '220103', '宽城区', '220100');
INSERT INTO `siping_county` VALUES ('1557', '220104', '朝阳区', '220100');
INSERT INTO `siping_county` VALUES ('1558', '220105', '二道区', '220100');
INSERT INTO `siping_county` VALUES ('1559', '220106', '绿园区', '220100');
INSERT INTO `siping_county` VALUES ('1560', '220112', '双阳区', '220100');
INSERT INTO `siping_county` VALUES ('1561', '220113', '九台区', '220100');
INSERT INTO `siping_county` VALUES ('1562', '220122', '农安县', '220100');
INSERT INTO `siping_county` VALUES ('1563', '220182', '榆树市', '220100');
INSERT INTO `siping_county` VALUES ('1564', '220183', '德惠市', '220100');
INSERT INTO `siping_county` VALUES ('1565', '220202', '昌邑区', '220200');
INSERT INTO `siping_county` VALUES ('1566', '220203', '龙潭区', '220200');
INSERT INTO `siping_county` VALUES ('1567', '220204', '船营区', '220200');
INSERT INTO `siping_county` VALUES ('1568', '220211', '丰满区', '220200');
INSERT INTO `siping_county` VALUES ('1569', '220221', '永吉县', '220200');
INSERT INTO `siping_county` VALUES ('1570', '220281', '蛟河市', '220200');
INSERT INTO `siping_county` VALUES ('1571', '220282', '桦甸市', '220200');
INSERT INTO `siping_county` VALUES ('1572', '220283', '舒兰市', '220200');
INSERT INTO `siping_county` VALUES ('1573', '220284', '磐石市', '220200');
INSERT INTO `siping_county` VALUES ('1574', '220302', '铁西区', '220300');
INSERT INTO `siping_county` VALUES ('1575', '220303', '铁东区', '220300');
INSERT INTO `siping_county` VALUES ('1576', '220322', '梨树县', '220300');
INSERT INTO `siping_county` VALUES ('1577', '220323', '伊通满族自治县', '220300');
INSERT INTO `siping_county` VALUES ('1578', '220381', '公主岭市', '220300');
INSERT INTO `siping_county` VALUES ('1579', '220382', '双辽市', '220300');
INSERT INTO `siping_county` VALUES ('1580', '220402', '龙山区', '220400');
INSERT INTO `siping_county` VALUES ('1581', '220421', '东丰县', '220400');
INSERT INTO `siping_county` VALUES ('1582', '220502', '东昌区', '220500');
INSERT INTO `siping_county` VALUES ('1583', '220422', '东辽县', '220400');
INSERT INTO `siping_county` VALUES ('1584', '220403', '西安区', '220400');
INSERT INTO `siping_county` VALUES ('1585', '220503', '二道江区', '220500');
INSERT INTO `siping_county` VALUES ('1586', '220521', '通化县', '220500');
INSERT INTO `siping_county` VALUES ('1587', '220523', '辉南县', '220500');
INSERT INTO `siping_county` VALUES ('1588', '220524', '柳河县', '220500');
INSERT INTO `siping_county` VALUES ('1589', '220581', '梅河口市', '220500');
INSERT INTO `siping_county` VALUES ('1590', '220582', '集安市', '220500');
INSERT INTO `siping_county` VALUES ('1591', '220602', '浑江区', '220600');
INSERT INTO `siping_county` VALUES ('1592', '220605', '江源区', '220600');
INSERT INTO `siping_county` VALUES ('1593', '220621', '抚松县', '220600');
INSERT INTO `siping_county` VALUES ('1594', '220622', '靖宇县', '220600');
INSERT INTO `siping_county` VALUES ('1595', '220623', '长白朝鲜族自治县', '220600');
INSERT INTO `siping_county` VALUES ('1596', '220681', '临江市', '220600');
INSERT INTO `siping_county` VALUES ('1597', '220702', '宁江区', '220700');
INSERT INTO `siping_county` VALUES ('1598', '220721', '前郭尔罗斯蒙古族自治县', '220700');
INSERT INTO `siping_county` VALUES ('1599', '220722', '长岭县', '220700');
INSERT INTO `siping_county` VALUES ('1600', '220723', '乾安县', '220700');
INSERT INTO `siping_county` VALUES ('1601', '220781', '扶余市', '220700');
INSERT INTO `siping_county` VALUES ('1602', '220802', '洮北区', '220800');
INSERT INTO `siping_county` VALUES ('1603', '220822', '通榆县', '220800');
INSERT INTO `siping_county` VALUES ('1604', '220821', '镇赉县', '220800');
INSERT INTO `siping_county` VALUES ('1605', '220881', '洮南市', '220800');
INSERT INTO `siping_county` VALUES ('1606', '220882', '大安市', '220800');
INSERT INTO `siping_county` VALUES ('1607', '222401', '延吉市', '222400');
INSERT INTO `siping_county` VALUES ('1608', '222402', '图们市', '222400');
INSERT INTO `siping_county` VALUES ('1609', '222403', '敦化市', '222400');
INSERT INTO `siping_county` VALUES ('1610', '222404', '珲春市', '222400');
INSERT INTO `siping_county` VALUES ('1611', '222405', '龙井市', '222400');
INSERT INTO `siping_county` VALUES ('1612', '222406', '和龙市', '222400');
INSERT INTO `siping_county` VALUES ('1613', '222424', '汪清县', '222400');
INSERT INTO `siping_county` VALUES ('1614', '222426', '安图县', '222400');
INSERT INTO `siping_county` VALUES ('1615', '210102', '和平区', '210100');
INSERT INTO `siping_county` VALUES ('1616', '210103', '沈河区', '210100');
INSERT INTO `siping_county` VALUES ('1617', '210104', '大东区', '210100');
INSERT INTO `siping_county` VALUES ('1618', '210105', '皇姑区', '210100');
INSERT INTO `siping_county` VALUES ('1619', '210106', '铁西区', '210100');
INSERT INTO `siping_county` VALUES ('1620', '210112', '浑南区', '210100');
INSERT INTO `siping_county` VALUES ('1621', '210113', '沈北新区', '210100');
INSERT INTO `siping_county` VALUES ('1622', '210111', '苏家屯区', '210100');
INSERT INTO `siping_county` VALUES ('1623', '210114', '于洪区', '210100');
INSERT INTO `siping_county` VALUES ('1624', '210122', '辽中县', '210100');
INSERT INTO `siping_county` VALUES ('1625', '210123', '康平县', '210100');
INSERT INTO `siping_county` VALUES ('1626', '210181', '新民市', '210100');
INSERT INTO `siping_county` VALUES ('1627', '210124', '法库县', '210100');
INSERT INTO `siping_county` VALUES ('1628', '210202', '中山区', '210200');
INSERT INTO `siping_county` VALUES ('1629', '210203', '西岗区', '210200');
INSERT INTO `siping_county` VALUES ('1630', '210204', '沙河口区', '210200');
INSERT INTO `siping_county` VALUES ('1631', '210211', '甘井子区', '210200');
INSERT INTO `siping_county` VALUES ('1632', '210212', '旅顺口区', '210200');
INSERT INTO `siping_county` VALUES ('1633', '210213', '金州区', '210200');
INSERT INTO `siping_county` VALUES ('1634', '210281', '瓦房店市', '210200');
INSERT INTO `siping_county` VALUES ('1635', '210224', '长海县', '210200');
INSERT INTO `siping_county` VALUES ('1636', '210282', '普兰店市', '210200');
INSERT INTO `siping_county` VALUES ('1637', '210283', '庄河市', '210200');
INSERT INTO `siping_county` VALUES ('1638', '210303', '铁西区', '210300');
INSERT INTO `siping_county` VALUES ('1639', '210311', '千山区', '210300');
INSERT INTO `siping_county` VALUES ('1640', '210321', '台安县', '210300');
INSERT INTO `siping_county` VALUES ('1641', '210323', '岫岩满族自治县', '210300');
INSERT INTO `siping_county` VALUES ('1642', '210302', '铁东区', '210300');
INSERT INTO `siping_county` VALUES ('1643', '210304', '立山区', '210300');
INSERT INTO `siping_county` VALUES ('1644', '210381', '海城市', '210300');
INSERT INTO `siping_county` VALUES ('1645', '210402', '新抚区', '210400');
INSERT INTO `siping_county` VALUES ('1646', '210403', '东洲区', '210400');
INSERT INTO `siping_county` VALUES ('1647', '210404', '望花区', '210400');
INSERT INTO `siping_county` VALUES ('1648', '210411', '顺城区', '210400');
INSERT INTO `siping_county` VALUES ('1649', '210421', '抚顺县', '210400');
INSERT INTO `siping_county` VALUES ('1650', '210422', '新宾满族自治县', '210400');
INSERT INTO `siping_county` VALUES ('1651', '210423', '清原满族自治县', '210400');
INSERT INTO `siping_county` VALUES ('1652', '210503', '溪湖区', '210500');
INSERT INTO `siping_county` VALUES ('1653', '210502', '平山区', '210500');
INSERT INTO `siping_county` VALUES ('1654', '210504', '明山区', '210500');
INSERT INTO `siping_county` VALUES ('1655', '210522', '桓仁满族自治县', '210500');
INSERT INTO `siping_county` VALUES ('1656', '210505', '南芬区', '210500');
INSERT INTO `siping_county` VALUES ('1657', '210521', '本溪满族自治县', '210500');
INSERT INTO `siping_county` VALUES ('1658', '210602', '元宝区', '210600');
INSERT INTO `siping_county` VALUES ('1659', '210604', '振安区', '210600');
INSERT INTO `siping_county` VALUES ('1660', '210603', '振兴区', '210600');
INSERT INTO `siping_county` VALUES ('1661', '210681', '东港市', '210600');
INSERT INTO `siping_county` VALUES ('1662', '210624', '宽甸满族自治县', '210600');
INSERT INTO `siping_county` VALUES ('1663', '210682', '凤城市', '210600');
INSERT INTO `siping_county` VALUES ('1664', '210702', '古塔区', '210700');
INSERT INTO `siping_county` VALUES ('1665', '210703', '凌河区', '210700');
INSERT INTO `siping_county` VALUES ('1666', '210711', '太和区', '210700');
INSERT INTO `siping_county` VALUES ('1667', '210726', '黑山县', '210700');
INSERT INTO `siping_county` VALUES ('1668', '210727', '义县', '210700');
INSERT INTO `siping_county` VALUES ('1669', '210781', '凌海市', '210700');
INSERT INTO `siping_county` VALUES ('1670', '210782', '北镇市', '210700');
INSERT INTO `siping_county` VALUES ('1671', '210802', '站前区', '210800');
INSERT INTO `siping_county` VALUES ('1672', '210803', '西市区', '210800');
INSERT INTO `siping_county` VALUES ('1673', '210804', '鲅鱼圈区', '210800');
INSERT INTO `siping_county` VALUES ('1674', '210811', '老边区', '210800');
INSERT INTO `siping_county` VALUES ('1675', '210881', '盖州市', '210800');
INSERT INTO `siping_county` VALUES ('1676', '210882', '大石桥市', '210800');
INSERT INTO `siping_county` VALUES ('1677', '210902', '海州区', '210900');
INSERT INTO `siping_county` VALUES ('1678', '210903', '新邱区', '210900');
INSERT INTO `siping_county` VALUES ('1679', '210905', '清河门区', '210900');
INSERT INTO `siping_county` VALUES ('1680', '210904', '太平区', '210900');
INSERT INTO `siping_county` VALUES ('1681', '210911', '细河区', '210900');
INSERT INTO `siping_county` VALUES ('1682', '210922', '彰武县', '210900');
INSERT INTO `siping_county` VALUES ('1683', '210921', '阜新蒙古族自治县', '210900');
INSERT INTO `siping_county` VALUES ('1684', '211002', '白塔区', '211000');
INSERT INTO `siping_county` VALUES ('1685', '211003', '文圣区', '211000');
INSERT INTO `siping_county` VALUES ('1686', '211004', '宏伟区', '211000');
INSERT INTO `siping_county` VALUES ('1687', '211005', '弓长岭区', '211000');
INSERT INTO `siping_county` VALUES ('1688', '211011', '太子河区', '211000');
INSERT INTO `siping_county` VALUES ('1689', '211021', '辽阳县', '211000');
INSERT INTO `siping_county` VALUES ('1690', '211081', '灯塔市', '211000');
INSERT INTO `siping_county` VALUES ('1691', '211102', '双台子区', '211100');
INSERT INTO `siping_county` VALUES ('1692', '211103', '兴隆台区', '211100');
INSERT INTO `siping_county` VALUES ('1693', '211121', '大洼县', '211100');
INSERT INTO `siping_county` VALUES ('1694', '211122', '盘山县', '211100');
INSERT INTO `siping_county` VALUES ('1695', '211204', '清河区', '211200');
INSERT INTO `siping_county` VALUES ('1696', '211221', '铁岭县', '211200');
INSERT INTO `siping_county` VALUES ('1697', '211202', '银州区', '211200');
INSERT INTO `siping_county` VALUES ('1698', '211223', '西丰县', '211200');
INSERT INTO `siping_county` VALUES ('1699', '211224', '昌图县', '211200');
INSERT INTO `siping_county` VALUES ('1700', '211281', '调兵山市', '211200');
INSERT INTO `siping_county` VALUES ('1701', '211282', '开原市', '211200');
INSERT INTO `siping_county` VALUES ('1702', '211302', '双塔区', '211300');
INSERT INTO `siping_county` VALUES ('1703', '211321', '朝阳县', '211300');
INSERT INTO `siping_county` VALUES ('1704', '211303', '龙城区', '211300');
INSERT INTO `siping_county` VALUES ('1705', '211322', '建平县', '211300');
INSERT INTO `siping_county` VALUES ('1706', '211324', '喀喇沁左翼蒙古族自治县', '211300');
INSERT INTO `siping_county` VALUES ('1707', '211381', '北票市', '211300');
INSERT INTO `siping_county` VALUES ('1708', '211382', '凌源市', '211300');
INSERT INTO `siping_county` VALUES ('1709', '211402', '连山区', '211400');
INSERT INTO `siping_county` VALUES ('1710', '211403', '龙港区', '211400');
INSERT INTO `siping_county` VALUES ('1711', '211404', '南票区', '211400');
INSERT INTO `siping_county` VALUES ('1712', '211421', '绥中县', '211400');
INSERT INTO `siping_county` VALUES ('1713', '211422', '建昌县', '211400');
INSERT INTO `siping_county` VALUES ('1714', '211481', '兴城市', '211400');
INSERT INTO `siping_county` VALUES ('1715', '150102', '新城区', '150100');
INSERT INTO `siping_county` VALUES ('1716', '150103', '回民区', '150100');
INSERT INTO `siping_county` VALUES ('1717', '150104', '玉泉区', '150100');
INSERT INTO `siping_county` VALUES ('1718', '150105', '赛罕区', '150100');
INSERT INTO `siping_county` VALUES ('1719', '150121', '土默特左旗', '150100');
INSERT INTO `siping_county` VALUES ('1720', '150122', '托克托县', '150100');
INSERT INTO `siping_county` VALUES ('1721', '150123', '和林格尔县', '150100');
INSERT INTO `siping_county` VALUES ('1722', '150124', '清水河县', '150100');
INSERT INTO `siping_county` VALUES ('1723', '150125', '武川县', '150100');
INSERT INTO `siping_county` VALUES ('1724', '150202', '东河区', '150200');
INSERT INTO `siping_county` VALUES ('1725', '150203', '昆都仑区', '150200');
INSERT INTO `siping_county` VALUES ('1726', '150204', '青山区', '150200');
INSERT INTO `siping_county` VALUES ('1727', '150205', '石拐区', '150200');
INSERT INTO `siping_county` VALUES ('1728', '150206', '白云鄂博矿区', '150200');
INSERT INTO `siping_county` VALUES ('1729', '150207', '九原区', '150200');
INSERT INTO `siping_county` VALUES ('1730', '150221', '土默特右旗', '150200');
INSERT INTO `siping_county` VALUES ('1731', '150222', '固阳县', '150200');
INSERT INTO `siping_county` VALUES ('1732', '150223', '达尔罕茂明安联合旗', '150200');
INSERT INTO `siping_county` VALUES ('1733', '150302', '海勃湾区', '150300');
INSERT INTO `siping_county` VALUES ('1734', '150303', '海南区', '150300');
INSERT INTO `siping_county` VALUES ('1735', '150304', '乌达区', '150300');
INSERT INTO `siping_county` VALUES ('1736', '150402', '红山区', '150400');
INSERT INTO `siping_county` VALUES ('1737', '150403', '元宝山区', '150400');
INSERT INTO `siping_county` VALUES ('1738', '150404', '松山区', '150400');
INSERT INTO `siping_county` VALUES ('1739', '150421', '阿鲁科尔沁旗', '150400');
INSERT INTO `siping_county` VALUES ('1740', '150422', '巴林左旗', '150400');
INSERT INTO `siping_county` VALUES ('1741', '150423', '巴林右旗', '150400');
INSERT INTO `siping_county` VALUES ('1742', '150424', '林西县', '150400');
INSERT INTO `siping_county` VALUES ('1743', '150425', '克什克腾旗', '150400');
INSERT INTO `siping_county` VALUES ('1744', '150426', '翁牛特旗', '150400');
INSERT INTO `siping_county` VALUES ('1745', '150428', '喀喇沁旗', '150400');
INSERT INTO `siping_county` VALUES ('1746', '150429', '宁城县', '150400');
INSERT INTO `siping_county` VALUES ('1747', '150430', '敖汉旗', '150400');
INSERT INTO `siping_county` VALUES ('1748', '150502', '科尔沁区', '150500');
INSERT INTO `siping_county` VALUES ('1749', '150521', '科尔沁左翼中旗', '150500');
INSERT INTO `siping_county` VALUES ('1750', '150522', '科尔沁左翼后旗', '150500');
INSERT INTO `siping_county` VALUES ('1751', '150525', '奈曼旗', '150500');
INSERT INTO `siping_county` VALUES ('1752', '150523', '开鲁县', '150500');
INSERT INTO `siping_county` VALUES ('1753', '150524', '库伦旗', '150500');
INSERT INTO `siping_county` VALUES ('1754', '150526', '扎鲁特旗', '150500');
INSERT INTO `siping_county` VALUES ('1755', '150581', '霍林郭勒市', '150500');
INSERT INTO `siping_county` VALUES ('1756', '150602', '东胜区', '150600');
INSERT INTO `siping_county` VALUES ('1757', '150621', '达拉特旗', '150600');
INSERT INTO `siping_county` VALUES ('1758', '150622', '准格尔旗', '150600');
INSERT INTO `siping_county` VALUES ('1759', '150623', '鄂托克前旗', '150600');
INSERT INTO `siping_county` VALUES ('1760', '150624', '鄂托克旗', '150600');
INSERT INTO `siping_county` VALUES ('1761', '150625', '杭锦旗', '150600');
INSERT INTO `siping_county` VALUES ('1762', '150627', '伊金霍洛旗', '150600');
INSERT INTO `siping_county` VALUES ('1763', '150626', '乌审旗', '150600');
INSERT INTO `siping_county` VALUES ('1764', '150703', '扎赉诺尔区', '150700');
INSERT INTO `siping_county` VALUES ('1765', '150702', '海拉尔区', '150700');
INSERT INTO `siping_county` VALUES ('1766', '150721', '阿荣旗', '150700');
INSERT INTO `siping_county` VALUES ('1767', '150722', '莫力达瓦达斡尔族自治旗', '150700');
INSERT INTO `siping_county` VALUES ('1768', '150723', '鄂伦春自治旗', '150700');
INSERT INTO `siping_county` VALUES ('1769', '150724', '鄂温克族自治旗', '150700');
INSERT INTO `siping_county` VALUES ('1770', '150725', '陈巴尔虎旗', '150700');
INSERT INTO `siping_county` VALUES ('1771', '150726', '新巴尔虎左旗', '150700');
INSERT INTO `siping_county` VALUES ('1772', '150781', '满洲里市', '150700');
INSERT INTO `siping_county` VALUES ('1773', '150727', '新巴尔虎右旗', '150700');
INSERT INTO `siping_county` VALUES ('1774', '150782', '牙克石市', '150700');
INSERT INTO `siping_county` VALUES ('1775', '150783', '扎兰屯市', '150700');
INSERT INTO `siping_county` VALUES ('1776', '150785', '根河市', '150700');
INSERT INTO `siping_county` VALUES ('1777', '150784', '额尔古纳市', '150700');
INSERT INTO `siping_county` VALUES ('1778', '150821', '五原县', '150800');
INSERT INTO `siping_county` VALUES ('1779', '150802', '临河区', '150800');
INSERT INTO `siping_county` VALUES ('1780', '150823', '乌拉特前旗', '150800');
INSERT INTO `siping_county` VALUES ('1781', '150822', '磴口县', '150800');
INSERT INTO `siping_county` VALUES ('1782', '150824', '乌拉特中旗', '150800');
INSERT INTO `siping_county` VALUES ('1783', '150825', '乌拉特后旗', '150800');
INSERT INTO `siping_county` VALUES ('1784', '150826', '杭锦后旗', '150800');
INSERT INTO `siping_county` VALUES ('1785', '150902', '集宁区', '150900');
INSERT INTO `siping_county` VALUES ('1786', '150921', '卓资县', '150900');
INSERT INTO `siping_county` VALUES ('1787', '150922', '化德县', '150900');
INSERT INTO `siping_county` VALUES ('1788', '150923', '商都县', '150900');
INSERT INTO `siping_county` VALUES ('1789', '150924', '兴和县', '150900');
INSERT INTO `siping_county` VALUES ('1790', '150925', '凉城县', '150900');
INSERT INTO `siping_county` VALUES ('1791', '150926', '察哈尔右翼前旗', '150900');
INSERT INTO `siping_county` VALUES ('1792', '150927', '察哈尔右翼中旗', '150900');
INSERT INTO `siping_county` VALUES ('1793', '150929', '四子王旗', '150900');
INSERT INTO `siping_county` VALUES ('1794', '150981', '丰镇市', '150900');
INSERT INTO `siping_county` VALUES ('1795', '150928', '察哈尔右翼后旗', '150900');
INSERT INTO `siping_county` VALUES ('1796', '152201', '乌兰浩特市', '152200');
INSERT INTO `siping_county` VALUES ('1797', '152202', '阿尔山市', '152200');
INSERT INTO `siping_county` VALUES ('1798', '152221', '科尔沁右翼前旗', '152200');
INSERT INTO `siping_county` VALUES ('1799', '152222', '科尔沁右翼中旗', '152200');
INSERT INTO `siping_county` VALUES ('1800', '152224', '突泉县', '152200');
INSERT INTO `siping_county` VALUES ('1801', '152223', '扎赉特旗', '152200');
INSERT INTO `siping_county` VALUES ('1802', '152502', '锡林浩特市', '152500');
INSERT INTO `siping_county` VALUES ('1803', '152522', '阿巴嘎旗', '152500');
INSERT INTO `siping_county` VALUES ('1804', '152501', '二连浩特市', '152500');
INSERT INTO `siping_county` VALUES ('1805', '152523', '苏尼特左旗', '152500');
INSERT INTO `siping_county` VALUES ('1806', '152524', '苏尼特右旗', '152500');
INSERT INTO `siping_county` VALUES ('1807', '152526', '西乌珠穆沁旗', '152500');
INSERT INTO `siping_county` VALUES ('1808', '152525', '东乌珠穆沁旗', '152500');
INSERT INTO `siping_county` VALUES ('1809', '152528', '镶黄旗', '152500');
INSERT INTO `siping_county` VALUES ('1810', '152527', '太仆寺旗', '152500');
INSERT INTO `siping_county` VALUES ('1811', '152530', '正蓝旗', '152500');
INSERT INTO `siping_county` VALUES ('1812', '152529', '正镶白旗', '152500');
INSERT INTO `siping_county` VALUES ('1813', '152531', '多伦县', '152500');
INSERT INTO `siping_county` VALUES ('1814', '152921', '阿拉善左旗', '152900');
INSERT INTO `siping_county` VALUES ('1815', '152922', '阿拉善右旗', '152900');
INSERT INTO `siping_county` VALUES ('1816', '152923', '额济纳旗', '152900');
INSERT INTO `siping_county` VALUES ('1817', '640121', '永宁县', '640100');
INSERT INTO `siping_county` VALUES ('1818', '640105', '西夏区', '640100');
INSERT INTO `siping_county` VALUES ('1819', '640106', '金凤区', '640100');
INSERT INTO `siping_county` VALUES ('1820', '640104', '兴庆区', '640100');
INSERT INTO `siping_county` VALUES ('1821', '640122', '贺兰县', '640100');
INSERT INTO `siping_county` VALUES ('1822', '640181', '灵武市', '640100');
INSERT INTO `siping_county` VALUES ('1823', '640202', '大武口区', '640200');
INSERT INTO `siping_county` VALUES ('1824', '640205', '惠农区', '640200');
INSERT INTO `siping_county` VALUES ('1825', '640221', '平罗县', '640200');
INSERT INTO `siping_county` VALUES ('1826', '640303', '红寺堡区', '640300');
INSERT INTO `siping_county` VALUES ('1827', '640323', '盐池县', '640300');
INSERT INTO `siping_county` VALUES ('1828', '640302', '利通区', '640300');
INSERT INTO `siping_county` VALUES ('1829', '640381', '青铜峡市', '640300');
INSERT INTO `siping_county` VALUES ('1830', '640324', '同心县', '640300');
INSERT INTO `siping_county` VALUES ('1831', '640422', '西吉县', '640400');
INSERT INTO `siping_county` VALUES ('1832', '640402', '原州区', '640400');
INSERT INTO `siping_county` VALUES ('1833', '640425', '彭阳县', '640400');
INSERT INTO `siping_county` VALUES ('1834', '640423', '隆德县', '640400');
INSERT INTO `siping_county` VALUES ('1835', '640424', '泾源县', '640400');
INSERT INTO `siping_county` VALUES ('1836', '640521', '中宁县', '640500');
INSERT INTO `siping_county` VALUES ('1837', '640502', '沙坡头区', '640500');
INSERT INTO `siping_county` VALUES ('1838', '640522', '海原县', '640500');
INSERT INTO `siping_county` VALUES ('1839', '630102', '城东区', '630100');
INSERT INTO `siping_county` VALUES ('1840', '630103', '城中区', '630100');
INSERT INTO `siping_county` VALUES ('1841', '630105', '城北区', '630100');
INSERT INTO `siping_county` VALUES ('1842', '630121', '大通回族土族自治县', '630100');
INSERT INTO `siping_county` VALUES ('1843', '630104', '城西区', '630100');
INSERT INTO `siping_county` VALUES ('1844', '630122', '湟中县', '630100');
INSERT INTO `siping_county` VALUES ('1845', '630123', '湟源县', '630100');
INSERT INTO `siping_county` VALUES ('1846', '630202', '乐都区', '630200');
INSERT INTO `siping_county` VALUES ('1847', '630222', '民和回族土族自治县', '630200');
INSERT INTO `siping_county` VALUES ('1848', '630223', '互助土族自治县', '630200');
INSERT INTO `siping_county` VALUES ('1849', '630221', '平安县', '630200');
INSERT INTO `siping_county` VALUES ('1850', '630224', '化隆回族自治县', '630200');
INSERT INTO `siping_county` VALUES ('1851', '630225', '循化撒拉族自治县', '630200');
INSERT INTO `siping_county` VALUES ('1852', '632222', '祁连县', '632200');
INSERT INTO `siping_county` VALUES ('1853', '632224', '刚察县', '632200');
INSERT INTO `siping_county` VALUES ('1854', '632223', '海晏县', '632200');
INSERT INTO `siping_county` VALUES ('1855', '632221', '门源回族自治县', '632200');
INSERT INTO `siping_county` VALUES ('1856', '632322', '尖扎县', '632300');
INSERT INTO `siping_county` VALUES ('1857', '632321', '同仁县', '632300');
INSERT INTO `siping_county` VALUES ('1858', '632323', '泽库县', '632300');
INSERT INTO `siping_county` VALUES ('1859', '632324', '河南蒙古族自治县', '632300');
INSERT INTO `siping_county` VALUES ('1860', '632521', '共和县', '632500');
INSERT INTO `siping_county` VALUES ('1861', '632522', '同德县', '632500');
INSERT INTO `siping_county` VALUES ('1862', '632523', '贵德县', '632500');
INSERT INTO `siping_county` VALUES ('1863', '632524', '兴海县', '632500');
INSERT INTO `siping_county` VALUES ('1864', '632525', '贵南县', '632500');
INSERT INTO `siping_county` VALUES ('1865', '632621', '玛沁县', '632600');
INSERT INTO `siping_county` VALUES ('1866', '632622', '班玛县', '632600');
INSERT INTO `siping_county` VALUES ('1867', '632623', '甘德县', '632600');
INSERT INTO `siping_county` VALUES ('1868', '632625', '久治县', '632600');
INSERT INTO `siping_county` VALUES ('1869', '632626', '玛多县', '632600');
INSERT INTO `siping_county` VALUES ('1870', '632624', '达日县', '632600');
INSERT INTO `siping_county` VALUES ('1871', '632701', '玉树市', '632700');
INSERT INTO `siping_county` VALUES ('1872', '632722', '杂多县', '632700');
INSERT INTO `siping_county` VALUES ('1873', '632723', '称多县', '632700');
INSERT INTO `siping_county` VALUES ('1874', '632724', '治多县', '632700');
INSERT INTO `siping_county` VALUES ('1875', '632725', '囊谦县', '632700');
INSERT INTO `siping_county` VALUES ('1876', '632726', '曲麻莱县', '632700');
INSERT INTO `siping_county` VALUES ('1877', '632801', '格尔木市', '632800');
INSERT INTO `siping_county` VALUES ('1878', '632802', '德令哈市', '632800');
INSERT INTO `siping_county` VALUES ('1879', '632821', '乌兰县', '632800');
INSERT INTO `siping_county` VALUES ('1880', '632822', '都兰县', '632800');
INSERT INTO `siping_county` VALUES ('1881', '632823', '天峻县', '632800');
INSERT INTO `siping_county` VALUES ('1882', '370102', '历下区', '370100');
INSERT INTO `siping_county` VALUES ('1883', '370103', '市中区', '370100');
INSERT INTO `siping_county` VALUES ('1884', '370104', '槐荫区', '370100');
INSERT INTO `siping_county` VALUES ('1885', '370112', '历城区', '370100');
INSERT INTO `siping_county` VALUES ('1886', '370105', '天桥区', '370100');
INSERT INTO `siping_county` VALUES ('1887', '370113', '长清区', '370100');
INSERT INTO `siping_county` VALUES ('1888', '370124', '平阴县', '370100');
INSERT INTO `siping_county` VALUES ('1889', '370125', '济阳县', '370100');
INSERT INTO `siping_county` VALUES ('1890', '370126', '商河县', '370100');
INSERT INTO `siping_county` VALUES ('1891', '370181', '章丘市', '370100');
INSERT INTO `siping_county` VALUES ('1892', '370202', '市南区', '370200');
INSERT INTO `siping_county` VALUES ('1893', '370203', '市北区', '370200');
INSERT INTO `siping_county` VALUES ('1894', '370211', '黄岛区', '370200');
INSERT INTO `siping_county` VALUES ('1895', '370212', '崂山区', '370200');
INSERT INTO `siping_county` VALUES ('1896', '370281', '胶州市', '370200');
INSERT INTO `siping_county` VALUES ('1897', '370213', '李沧区', '370200');
INSERT INTO `siping_county` VALUES ('1898', '370283', '平度市', '370200');
INSERT INTO `siping_county` VALUES ('1899', '370214', '城阳区', '370200');
INSERT INTO `siping_county` VALUES ('1900', '370282', '即墨市', '370200');
INSERT INTO `siping_county` VALUES ('1901', '370285', '莱西市', '370200');
INSERT INTO `siping_county` VALUES ('1902', '370302', '淄川区', '370300');
INSERT INTO `siping_county` VALUES ('1903', '370303', '张店区', '370300');
INSERT INTO `siping_county` VALUES ('1904', '370304', '博山区', '370300');
INSERT INTO `siping_county` VALUES ('1905', '370305', '临淄区', '370300');
INSERT INTO `siping_county` VALUES ('1906', '370306', '周村区', '370300');
INSERT INTO `siping_county` VALUES ('1907', '370321', '桓台县', '370300');
INSERT INTO `siping_county` VALUES ('1908', '370322', '高青县', '370300');
INSERT INTO `siping_county` VALUES ('1909', '370323', '沂源县', '370300');
INSERT INTO `siping_county` VALUES ('1910', '370402', '市中区', '370400');
INSERT INTO `siping_county` VALUES ('1911', '370403', '薛城区', '370400');
INSERT INTO `siping_county` VALUES ('1912', '370404', '峄城区', '370400');
INSERT INTO `siping_county` VALUES ('1913', '370405', '台儿庄区', '370400');
INSERT INTO `siping_county` VALUES ('1914', '370406', '山亭区', '370400');
INSERT INTO `siping_county` VALUES ('1915', '370481', '滕州市', '370400');
INSERT INTO `siping_county` VALUES ('1916', '370502', '东营区', '370500');
INSERT INTO `siping_county` VALUES ('1917', '370503', '河口区', '370500');
INSERT INTO `siping_county` VALUES ('1918', '370521', '垦利县', '370500');
INSERT INTO `siping_county` VALUES ('1919', '370522', '利津县', '370500');
INSERT INTO `siping_county` VALUES ('1920', '370523', '广饶县', '370500');
INSERT INTO `siping_county` VALUES ('1921', '370602', '芝罘区', '370600');
INSERT INTO `siping_county` VALUES ('1922', '370611', '福山区', '370600');
INSERT INTO `siping_county` VALUES ('1923', '370612', '牟平区', '370600');
INSERT INTO `siping_county` VALUES ('1924', '370613', '莱山区', '370600');
INSERT INTO `siping_county` VALUES ('1925', '370681', '龙口市', '370600');
INSERT INTO `siping_county` VALUES ('1926', '370682', '莱阳市', '370600');
INSERT INTO `siping_county` VALUES ('1927', '370634', '长岛县', '370600');
INSERT INTO `siping_county` VALUES ('1928', '370683', '莱州市', '370600');
INSERT INTO `siping_county` VALUES ('1929', '370684', '蓬莱市', '370600');
INSERT INTO `siping_county` VALUES ('1930', '370686', '栖霞市', '370600');
INSERT INTO `siping_county` VALUES ('1931', '370687', '海阳市', '370600');
INSERT INTO `siping_county` VALUES ('1932', '370685', '招远市', '370600');
INSERT INTO `siping_county` VALUES ('1933', '370702', '潍城区', '370700');
INSERT INTO `siping_county` VALUES ('1934', '370703', '寒亭区', '370700');
INSERT INTO `siping_county` VALUES ('1935', '370704', '坊子区', '370700');
INSERT INTO `siping_county` VALUES ('1936', '370724', '临朐县', '370700');
INSERT INTO `siping_county` VALUES ('1937', '370705', '奎文区', '370700');
INSERT INTO `siping_county` VALUES ('1938', '370781', '青州市', '370700');
INSERT INTO `siping_county` VALUES ('1939', '370725', '昌乐县', '370700');
INSERT INTO `siping_county` VALUES ('1940', '370782', '诸城市', '370700');
INSERT INTO `siping_county` VALUES ('1941', '370785', '高密市', '370700');
INSERT INTO `siping_county` VALUES ('1942', '370784', '安丘市', '370700');
INSERT INTO `siping_county` VALUES ('1943', '370786', '昌邑市', '370700');
INSERT INTO `siping_county` VALUES ('1944', '370783', '寿光市', '370700');
INSERT INTO `siping_county` VALUES ('1945', '370811', '任城区', '370800');
INSERT INTO `siping_county` VALUES ('1946', '370812', '兖州区', '370800');
INSERT INTO `siping_county` VALUES ('1947', '370826', '微山县', '370800');
INSERT INTO `siping_county` VALUES ('1948', '370828', '金乡县', '370800');
INSERT INTO `siping_county` VALUES ('1949', '370829', '嘉祥县', '370800');
INSERT INTO `siping_county` VALUES ('1950', '370827', '鱼台县', '370800');
INSERT INTO `siping_county` VALUES ('1951', '370830', '汶上县', '370800');
INSERT INTO `siping_county` VALUES ('1952', '370831', '泗水县', '370800');
INSERT INTO `siping_county` VALUES ('1953', '370832', '梁山县', '370800');
INSERT INTO `siping_county` VALUES ('1954', '370881', '曲阜市', '370800');
INSERT INTO `siping_county` VALUES ('1955', '370883', '邹城市', '370800');
INSERT INTO `siping_county` VALUES ('1956', '370911', '岱岳区', '370900');
INSERT INTO `siping_county` VALUES ('1957', '370921', '宁阳县', '370900');
INSERT INTO `siping_county` VALUES ('1958', '370902', '泰山区', '370900');
INSERT INTO `siping_county` VALUES ('1959', '370923', '东平县', '370900');
INSERT INTO `siping_county` VALUES ('1960', '370982', '新泰市', '370900');
INSERT INTO `siping_county` VALUES ('1961', '370983', '肥城市', '370900');
INSERT INTO `siping_county` VALUES ('1962', '371002', '环翠区', '371000');
INSERT INTO `siping_county` VALUES ('1963', '371003', '文登区', '371000');
INSERT INTO `siping_county` VALUES ('1964', '371082', '荣成市', '371000');
INSERT INTO `siping_county` VALUES ('1965', '371083', '乳山市', '371000');
INSERT INTO `siping_county` VALUES ('1966', '371103', '岚山区', '371100');
INSERT INTO `siping_county` VALUES ('1967', '371102', '东港区', '371100');
INSERT INTO `siping_county` VALUES ('1968', '371121', '五莲县', '371100');
INSERT INTO `siping_county` VALUES ('1969', '371122', '莒县', '371100');
INSERT INTO `siping_county` VALUES ('1970', '371202', '莱城区', '371200');
INSERT INTO `siping_county` VALUES ('1971', '371203', '钢城区', '371200');
INSERT INTO `siping_county` VALUES ('1972', '371302', '兰山区', '371300');
INSERT INTO `siping_county` VALUES ('1973', '371311', '罗庄区', '371300');
INSERT INTO `siping_county` VALUES ('1974', '371312', '河东区', '371300');
INSERT INTO `siping_county` VALUES ('1975', '371321', '沂南县', '371300');
INSERT INTO `siping_county` VALUES ('1976', '371322', '郯城县', '371300');
INSERT INTO `siping_county` VALUES ('1977', '371323', '沂水县', '371300');
INSERT INTO `siping_county` VALUES ('1978', '371324', '兰陵县', '371300');
INSERT INTO `siping_county` VALUES ('1979', '371325', '费县', '371300');
INSERT INTO `siping_county` VALUES ('1980', '371326', '平邑县', '371300');
INSERT INTO `siping_county` VALUES ('1981', '371327', '莒南县', '371300');
INSERT INTO `siping_county` VALUES ('1982', '371328', '蒙阴县', '371300');
INSERT INTO `siping_county` VALUES ('1983', '371329', '临沭县', '371300');
INSERT INTO `siping_county` VALUES ('1984', '371402', '德城区', '371400');
INSERT INTO `siping_county` VALUES ('1985', '371403', '陵城区', '371400');
INSERT INTO `siping_county` VALUES ('1986', '371422', '宁津县', '371400');
INSERT INTO `siping_county` VALUES ('1987', '371424', '临邑县', '371400');
INSERT INTO `siping_county` VALUES ('1988', '371423', '庆云县', '371400');
INSERT INTO `siping_county` VALUES ('1989', '371426', '平原县', '371400');
INSERT INTO `siping_county` VALUES ('1990', '371425', '齐河县', '371400');
INSERT INTO `siping_county` VALUES ('1991', '371427', '夏津县', '371400');
INSERT INTO `siping_county` VALUES ('1992', '371428', '武城县', '371400');
INSERT INTO `siping_county` VALUES ('1993', '371481', '乐陵市', '371400');
INSERT INTO `siping_county` VALUES ('1994', '371482', '禹城市', '371400');
INSERT INTO `siping_county` VALUES ('1995', '371521', '阳谷县', '371500');
INSERT INTO `siping_county` VALUES ('1996', '371502', '东昌府区', '371500');
INSERT INTO `siping_county` VALUES ('1997', '371522', '莘县', '371500');
INSERT INTO `siping_county` VALUES ('1998', '371523', '茌平县', '371500');
INSERT INTO `siping_county` VALUES ('1999', '371524', '东阿县', '371500');
INSERT INTO `siping_county` VALUES ('2000', '371525', '冠县', '371500');
INSERT INTO `siping_county` VALUES ('2001', '371526', '高唐县', '371500');
INSERT INTO `siping_county` VALUES ('2002', '371581', '临清市', '371500');
INSERT INTO `siping_county` VALUES ('2003', '371602', '滨城区', '371600');
INSERT INTO `siping_county` VALUES ('2004', '371621', '惠民县', '371600');
INSERT INTO `siping_county` VALUES ('2005', '371603', '沾化区', '371600');
INSERT INTO `siping_county` VALUES ('2006', '371622', '阳信县', '371600');
INSERT INTO `siping_county` VALUES ('2007', '371623', '无棣县', '371600');
INSERT INTO `siping_county` VALUES ('2008', '371625', '博兴县', '371600');
INSERT INTO `siping_county` VALUES ('2009', '371702', '牡丹区', '371700');
INSERT INTO `siping_county` VALUES ('2010', '371721', '曹县', '371700');
INSERT INTO `siping_county` VALUES ('2011', '371626', '邹平县', '371600');
INSERT INTO `siping_county` VALUES ('2012', '371722', '单县', '371700');
INSERT INTO `siping_county` VALUES ('2013', '371723', '成武县', '371700');
INSERT INTO `siping_county` VALUES ('2014', '371726', '鄄城县', '371700');
INSERT INTO `siping_county` VALUES ('2015', '371724', '巨野县', '371700');
INSERT INTO `siping_county` VALUES ('2016', '371725', '郓城县', '371700');
INSERT INTO `siping_county` VALUES ('2017', '371727', '定陶县', '371700');
INSERT INTO `siping_county` VALUES ('2018', '371728', '东明县', '371700');
INSERT INTO `siping_county` VALUES ('2019', '310101', '黄浦区', '310000');
INSERT INTO `siping_county` VALUES ('2020', '310104', '徐汇区', '310000');
INSERT INTO `siping_county` VALUES ('2021', '310105', '长宁区', '310000');
INSERT INTO `siping_county` VALUES ('2022', '310106', '静安区', '310000');
INSERT INTO `siping_county` VALUES ('2023', '310107', '普陀区', '310000');
INSERT INTO `siping_county` VALUES ('2024', '310109', '虹口区', '310000');
INSERT INTO `siping_county` VALUES ('2025', '310110', '杨浦区', '310000');
INSERT INTO `siping_county` VALUES ('2026', '310108', '闸北区', '310000');
INSERT INTO `siping_county` VALUES ('2027', '310113', '宝山区', '310000');
INSERT INTO `siping_county` VALUES ('2028', '310112', '闵行区', '310000');
INSERT INTO `siping_county` VALUES ('2029', '310114', '嘉定区', '310000');
INSERT INTO `siping_county` VALUES ('2030', '310115', '浦东新区', '310000');
INSERT INTO `siping_county` VALUES ('2031', '310118', '青浦区', '310000');
INSERT INTO `siping_county` VALUES ('2032', '310116', '金山区', '310000');
INSERT INTO `siping_county` VALUES ('2033', '310120', '奉贤区', '310000');
INSERT INTO `siping_county` VALUES ('2034', '310117', '松江区', '310000');
INSERT INTO `siping_county` VALUES ('2035', '310230', '崇明县', '310000');
INSERT INTO `siping_county` VALUES ('2036', '140105', '小店区', '140100');
INSERT INTO `siping_county` VALUES ('2037', '140106', '迎泽区', '140100');
INSERT INTO `siping_county` VALUES ('2038', '140107', '杏花岭区', '140100');
INSERT INTO `siping_county` VALUES ('2039', '140108', '尖草坪区', '140100');
INSERT INTO `siping_county` VALUES ('2040', '140109', '万柏林区', '140100');
INSERT INTO `siping_county` VALUES ('2041', '140110', '晋源区', '140100');
INSERT INTO `siping_county` VALUES ('2042', '140122', '阳曲县', '140100');
INSERT INTO `siping_county` VALUES ('2043', '140121', '清徐县', '140100');
INSERT INTO `siping_county` VALUES ('2044', '140123', '娄烦县', '140100');
INSERT INTO `siping_county` VALUES ('2045', '140181', '古交市', '140100');
INSERT INTO `siping_county` VALUES ('2046', '140202', '城区', '140200');
INSERT INTO `siping_county` VALUES ('2047', '140203', '矿区', '140200');
INSERT INTO `siping_county` VALUES ('2048', '140212', '新荣区', '140200');
INSERT INTO `siping_county` VALUES ('2049', '140211', '南郊区', '140200');
INSERT INTO `siping_county` VALUES ('2050', '140221', '阳高县', '140200');
INSERT INTO `siping_county` VALUES ('2051', '140224', '灵丘县', '140200');
INSERT INTO `siping_county` VALUES ('2052', '140225', '浑源县', '140200');
INSERT INTO `siping_county` VALUES ('2053', '140222', '天镇县', '140200');
INSERT INTO `siping_county` VALUES ('2054', '140223', '广灵县', '140200');
INSERT INTO `siping_county` VALUES ('2055', '140226', '左云县', '140200');
INSERT INTO `siping_county` VALUES ('2056', '140227', '大同县', '140200');
INSERT INTO `siping_county` VALUES ('2057', '140302', '城区', '140300');
INSERT INTO `siping_county` VALUES ('2058', '140303', '矿区', '140300');
INSERT INTO `siping_county` VALUES ('2059', '140311', '郊区', '140300');
INSERT INTO `siping_county` VALUES ('2060', '140321', '平定县', '140300');
INSERT INTO `siping_county` VALUES ('2061', '140322', '盂县', '140300');
INSERT INTO `siping_county` VALUES ('2062', '140402', '城区', '140400');
INSERT INTO `siping_county` VALUES ('2063', '140411', '郊区', '140400');
INSERT INTO `siping_county` VALUES ('2064', '140424', '屯留县', '140400');
INSERT INTO `siping_county` VALUES ('2065', '140426', '黎城县', '140400');
INSERT INTO `siping_county` VALUES ('2066', '140421', '长治县', '140400');
INSERT INTO `siping_county` VALUES ('2067', '140425', '平顺县', '140400');
INSERT INTO `siping_county` VALUES ('2068', '140427', '壶关县', '140400');
INSERT INTO `siping_county` VALUES ('2069', '140423', '襄垣县', '140400');
INSERT INTO `siping_county` VALUES ('2070', '140428', '长子县', '140400');
INSERT INTO `siping_county` VALUES ('2071', '140429', '武乡县', '140400');
INSERT INTO `siping_county` VALUES ('2072', '140430', '沁县', '140400');
INSERT INTO `siping_county` VALUES ('2073', '140431', '沁源县', '140400');
INSERT INTO `siping_county` VALUES ('2074', '140481', '潞城市', '140400');
INSERT INTO `siping_county` VALUES ('2075', '140521', '沁水县', '140500');
INSERT INTO `siping_county` VALUES ('2076', '140502', '城区', '140500');
INSERT INTO `siping_county` VALUES ('2077', '140525', '泽州县', '140500');
INSERT INTO `siping_county` VALUES ('2078', '140581', '高平市', '140500');
INSERT INTO `siping_county` VALUES ('2079', '140603', '平鲁区', '140600');
INSERT INTO `siping_county` VALUES ('2080', '140524', '陵川县', '140500');
INSERT INTO `siping_county` VALUES ('2081', '140602', '朔城区', '140600');
INSERT INTO `siping_county` VALUES ('2082', '140522', '阳城县', '140500');
INSERT INTO `siping_county` VALUES ('2083', '140621', '山阴县', '140600');
INSERT INTO `siping_county` VALUES ('2084', '140622', '应县', '140600');
INSERT INTO `siping_county` VALUES ('2085', '140721', '榆社县', '140700');
INSERT INTO `siping_county` VALUES ('2086', '140623', '右玉县', '140600');
INSERT INTO `siping_county` VALUES ('2087', '140624', '怀仁县', '140600');
INSERT INTO `siping_county` VALUES ('2088', '140722', '左权县', '140700');
INSERT INTO `siping_county` VALUES ('2089', '140723', '和顺县', '140700');
INSERT INTO `siping_county` VALUES ('2090', '140702', '榆次区', '140700');
INSERT INTO `siping_county` VALUES ('2091', '140725', '寿阳县', '140700');
INSERT INTO `siping_county` VALUES ('2092', '140724', '昔阳县', '140700');
INSERT INTO `siping_county` VALUES ('2093', '140726', '太谷县', '140700');
INSERT INTO `siping_county` VALUES ('2094', '140727', '祁县', '140700');
INSERT INTO `siping_county` VALUES ('2095', '140728', '平遥县', '140700');
INSERT INTO `siping_county` VALUES ('2096', '140781', '介休市', '140700');
INSERT INTO `siping_county` VALUES ('2097', '140729', '灵石县', '140700');
INSERT INTO `siping_county` VALUES ('2098', '140802', '盐湖区', '140800');
INSERT INTO `siping_county` VALUES ('2099', '140821', '临猗县', '140800');
INSERT INTO `siping_county` VALUES ('2100', '140822', '万荣县', '140800');
INSERT INTO `siping_county` VALUES ('2101', '140823', '闻喜县', '140800');
INSERT INTO `siping_county` VALUES ('2102', '140824', '稷山县', '140800');
INSERT INTO `siping_county` VALUES ('2103', '140825', '新绛县', '140800');
INSERT INTO `siping_county` VALUES ('2104', '140826', '绛县', '140800');
INSERT INTO `siping_county` VALUES ('2105', '140827', '垣曲县', '140800');
INSERT INTO `siping_county` VALUES ('2106', '140828', '夏县', '140800');
INSERT INTO `siping_county` VALUES ('2107', '140829', '平陆县', '140800');
INSERT INTO `siping_county` VALUES ('2108', '140882', '河津市', '140800');
INSERT INTO `siping_county` VALUES ('2109', '140902', '忻府区', '140900');
INSERT INTO `siping_county` VALUES ('2110', '140922', '五台县', '140900');
INSERT INTO `siping_county` VALUES ('2111', '140925', '宁武县', '140900');
INSERT INTO `siping_county` VALUES ('2112', '140924', '繁峙县', '140900');
INSERT INTO `siping_county` VALUES ('2113', '140921', '定襄县', '140900');
INSERT INTO `siping_county` VALUES ('2114', '140923', '代县', '140900');
INSERT INTO `siping_county` VALUES ('2115', '140926', '静乐县', '140900');
INSERT INTO `siping_county` VALUES ('2116', '140927', '神池县', '140900');
INSERT INTO `siping_county` VALUES ('2117', '140830', '芮城县', '140800');
INSERT INTO `siping_county` VALUES ('2118', '140881', '永济市', '140800');
INSERT INTO `siping_county` VALUES ('2119', '140930', '河曲县', '140900');
INSERT INTO `siping_county` VALUES ('2120', '140928', '五寨县', '140900');
INSERT INTO `siping_county` VALUES ('2121', '140929', '岢岚县', '140900');
INSERT INTO `siping_county` VALUES ('2122', '141002', '尧都区', '141000');
INSERT INTO `siping_county` VALUES ('2123', '140931', '保德县', '140900');
INSERT INTO `siping_county` VALUES ('2124', '141021', '曲沃县', '141000');
INSERT INTO `siping_county` VALUES ('2125', '141023', '襄汾县', '141000');
INSERT INTO `siping_county` VALUES ('2126', '141022', '翼城县', '141000');
INSERT INTO `siping_county` VALUES ('2127', '141024', '洪洞县', '141000');
INSERT INTO `siping_county` VALUES ('2128', '141025', '古县', '141000');
INSERT INTO `siping_county` VALUES ('2129', '141026', '安泽县', '141000');
INSERT INTO `siping_county` VALUES ('2130', '140981', '原平市', '140900');
INSERT INTO `siping_county` VALUES ('2131', '140932', '偏关县', '140900');
INSERT INTO `siping_county` VALUES ('2132', '141028', '吉县', '141000');
INSERT INTO `siping_county` VALUES ('2133', '141027', '浮山县', '141000');
INSERT INTO `siping_county` VALUES ('2134', '141029', '乡宁县', '141000');
INSERT INTO `siping_county` VALUES ('2135', '141031', '隰县', '141000');
INSERT INTO `siping_county` VALUES ('2136', '141030', '大宁县', '141000');
INSERT INTO `siping_county` VALUES ('2137', '141032', '永和县', '141000');
INSERT INTO `siping_county` VALUES ('2138', '141033', '蒲县', '141000');
INSERT INTO `siping_county` VALUES ('2139', '141034', '汾西县', '141000');
INSERT INTO `siping_county` VALUES ('2140', '141081', '侯马市', '141000');
INSERT INTO `siping_county` VALUES ('2141', '141082', '霍州市', '141000');
INSERT INTO `siping_county` VALUES ('2142', '141102', '离石区', '141100');
INSERT INTO `siping_county` VALUES ('2143', '141122', '交城县', '141100');
INSERT INTO `siping_county` VALUES ('2144', '141123', '兴县', '141100');
INSERT INTO `siping_county` VALUES ('2145', '141124', '临县', '141100');
INSERT INTO `siping_county` VALUES ('2146', '141121', '文水县', '141100');
INSERT INTO `siping_county` VALUES ('2147', '141125', '柳林县', '141100');
INSERT INTO `siping_county` VALUES ('2148', '141126', '石楼县', '141100');
INSERT INTO `siping_county` VALUES ('2149', '141127', '岚县', '141100');
INSERT INTO `siping_county` VALUES ('2150', '141130', '交口县', '141100');
INSERT INTO `siping_county` VALUES ('2151', '141128', '方山县', '141100');
INSERT INTO `siping_county` VALUES ('2152', '141129', '中阳县', '141100');
INSERT INTO `siping_county` VALUES ('2153', '141181', '孝义市', '141100');
INSERT INTO `siping_county` VALUES ('2154', '141182', '汾阳市', '141100');
INSERT INTO `siping_county` VALUES ('2155', '610104', '莲湖区', '610100');
INSERT INTO `siping_county` VALUES ('2156', '610102', '新城区', '610100');
INSERT INTO `siping_county` VALUES ('2157', '610112', '未央区', '610100');
INSERT INTO `siping_county` VALUES ('2158', '610103', '碑林区', '610100');
INSERT INTO `siping_county` VALUES ('2159', '610111', '灞桥区', '610100');
INSERT INTO `siping_county` VALUES ('2160', '610113', '雁塔区', '610100');
INSERT INTO `siping_county` VALUES ('2161', '610114', '阎良区', '610100');
INSERT INTO `siping_county` VALUES ('2162', '610124', '周至县', '610100');
INSERT INTO `siping_county` VALUES ('2163', '610125', '户县', '610100');
INSERT INTO `siping_county` VALUES ('2164', '610116', '长安区', '610100');
INSERT INTO `siping_county` VALUES ('2165', '610115', '临潼区', '610100');
INSERT INTO `siping_county` VALUES ('2166', '610126', '高陵县', '610100');
INSERT INTO `siping_county` VALUES ('2167', '610122', '蓝田县', '610100');
INSERT INTO `siping_county` VALUES ('2168', '610202', '王益区', '610200');
INSERT INTO `siping_county` VALUES ('2169', '610203', '印台区', '610200');
INSERT INTO `siping_county` VALUES ('2170', '610204', '耀州区', '610200');
INSERT INTO `siping_county` VALUES ('2171', '610222', '宜君县', '610200');
INSERT INTO `siping_county` VALUES ('2172', '610302', '渭滨区', '610300');
INSERT INTO `siping_county` VALUES ('2173', '610303', '金台区', '610300');
INSERT INTO `siping_county` VALUES ('2174', '610322', '凤翔县', '610300');
INSERT INTO `siping_county` VALUES ('2175', '610323', '岐山县', '610300');
INSERT INTO `siping_county` VALUES ('2176', '610304', '陈仓区', '610300');
INSERT INTO `siping_county` VALUES ('2177', '610324', '扶风县', '610300');
INSERT INTO `siping_county` VALUES ('2178', '610326', '眉县', '610300');
INSERT INTO `siping_county` VALUES ('2179', '610327', '陇县', '610300');
INSERT INTO `siping_county` VALUES ('2180', '610328', '千阳县', '610300');
INSERT INTO `siping_county` VALUES ('2181', '610329', '麟游县', '610300');
INSERT INTO `siping_county` VALUES ('2182', '610330', '凤县', '610300');
INSERT INTO `siping_county` VALUES ('2183', '610331', '太白县', '610300');
INSERT INTO `siping_county` VALUES ('2184', '610402', '秦都区', '610400');
INSERT INTO `siping_county` VALUES ('2185', '610404', '渭城区', '610400');
INSERT INTO `siping_county` VALUES ('2186', '610403', '杨陵区', '610400');
INSERT INTO `siping_county` VALUES ('2187', '610422', '三原县', '610400');
INSERT INTO `siping_county` VALUES ('2188', '610423', '泾阳县', '610400');
INSERT INTO `siping_county` VALUES ('2189', '610425', '礼泉县', '610400');
INSERT INTO `siping_county` VALUES ('2190', '610424', '乾县', '610400');
INSERT INTO `siping_county` VALUES ('2191', '610426', '永寿县', '610400');
INSERT INTO `siping_county` VALUES ('2192', '610427', '彬县', '610400');
INSERT INTO `siping_county` VALUES ('2193', '610428', '长武县', '610400');
INSERT INTO `siping_county` VALUES ('2194', '610430', '淳化县', '610400');
INSERT INTO `siping_county` VALUES ('2195', '610429', '旬邑县', '610400');
INSERT INTO `siping_county` VALUES ('2196', '610481', '兴平市', '610400');
INSERT INTO `siping_county` VALUES ('2197', '610431', '武功县', '610400');
INSERT INTO `siping_county` VALUES ('2198', '610502', '临渭区', '610500');
INSERT INTO `siping_county` VALUES ('2199', '610522', '潼关县', '610500');
INSERT INTO `siping_county` VALUES ('2200', '610521', '华县', '610500');
INSERT INTO `siping_county` VALUES ('2201', '610523', '大荔县', '610500');
INSERT INTO `siping_county` VALUES ('2202', '610524', '合阳县', '610500');
INSERT INTO `siping_county` VALUES ('2203', '610525', '澄城县', '610500');
INSERT INTO `siping_county` VALUES ('2204', '610526', '蒲城县', '610500');
INSERT INTO `siping_county` VALUES ('2205', '610527', '白水县', '610500');
INSERT INTO `siping_county` VALUES ('2206', '610528', '富平县', '610500');
INSERT INTO `siping_county` VALUES ('2207', '610581', '韩城市', '610500');
INSERT INTO `siping_county` VALUES ('2208', '610582', '华阴市', '610500');
INSERT INTO `siping_county` VALUES ('2209', '610602', '宝塔区', '610600');
INSERT INTO `siping_county` VALUES ('2210', '610621', '延长县', '610600');
INSERT INTO `siping_county` VALUES ('2211', '610622', '延川县', '610600');
INSERT INTO `siping_county` VALUES ('2212', '610623', '子长县', '610600');
INSERT INTO `siping_county` VALUES ('2213', '610624', '安塞县', '610600');
INSERT INTO `siping_county` VALUES ('2214', '610625', '志丹县', '610600');
INSERT INTO `siping_county` VALUES ('2215', '610626', '吴起县', '610600');
INSERT INTO `siping_county` VALUES ('2216', '610627', '甘泉县', '610600');
INSERT INTO `siping_county` VALUES ('2217', '610628', '富县', '610600');
INSERT INTO `siping_county` VALUES ('2218', '610629', '洛川县', '610600');
INSERT INTO `siping_county` VALUES ('2219', '610630', '宜川县', '610600');
INSERT INTO `siping_county` VALUES ('2220', '610632', '黄陵县', '610600');
INSERT INTO `siping_county` VALUES ('2221', '610631', '黄龙县', '610600');
INSERT INTO `siping_county` VALUES ('2222', '610702', '汉台区', '610700');
INSERT INTO `siping_county` VALUES ('2223', '610721', '南郑县', '610700');
INSERT INTO `siping_county` VALUES ('2224', '610722', '城固县', '610700');
INSERT INTO `siping_county` VALUES ('2225', '610723', '洋县', '610700');
INSERT INTO `siping_county` VALUES ('2226', '610724', '西乡县', '610700');
INSERT INTO `siping_county` VALUES ('2227', '610725', '勉县', '610700');
INSERT INTO `siping_county` VALUES ('2228', '610726', '宁强县', '610700');
INSERT INTO `siping_county` VALUES ('2229', '610727', '略阳县', '610700');
INSERT INTO `siping_county` VALUES ('2230', '610728', '镇巴县', '610700');
INSERT INTO `siping_county` VALUES ('2231', '610729', '留坝县', '610700');
INSERT INTO `siping_county` VALUES ('2232', '610730', '佛坪县', '610700');
INSERT INTO `siping_county` VALUES ('2233', '610802', '榆阳区', '610800');
INSERT INTO `siping_county` VALUES ('2234', '610821', '神木县', '610800');
INSERT INTO `siping_county` VALUES ('2235', '610822', '府谷县', '610800');
INSERT INTO `siping_county` VALUES ('2236', '610823', '横山县', '610800');
INSERT INTO `siping_county` VALUES ('2237', '610824', '靖边县', '610800');
INSERT INTO `siping_county` VALUES ('2238', '610825', '定边县', '610800');
INSERT INTO `siping_county` VALUES ('2239', '610826', '绥德县', '610800');
INSERT INTO `siping_county` VALUES ('2240', '610827', '米脂县', '610800');
INSERT INTO `siping_county` VALUES ('2241', '610828', '佳县', '610800');
INSERT INTO `siping_county` VALUES ('2242', '610829', '吴堡县', '610800');
INSERT INTO `siping_county` VALUES ('2243', '610830', '清涧县', '610800');
INSERT INTO `siping_county` VALUES ('2244', '610831', '子洲县', '610800');
INSERT INTO `siping_county` VALUES ('2245', '610902', '汉滨区', '610900');
INSERT INTO `siping_county` VALUES ('2246', '610922', '石泉县', '610900');
INSERT INTO `siping_county` VALUES ('2247', '610921', '汉阴县', '610900');
INSERT INTO `siping_county` VALUES ('2248', '610923', '宁陕县', '610900');
INSERT INTO `siping_county` VALUES ('2249', '610924', '紫阳县', '610900');
INSERT INTO `siping_county` VALUES ('2250', '610925', '岚皋县', '610900');
INSERT INTO `siping_county` VALUES ('2251', '610926', '平利县', '610900');
INSERT INTO `siping_county` VALUES ('2252', '610927', '镇坪县', '610900');
INSERT INTO `siping_county` VALUES ('2253', '610928', '旬阳县', '610900');
INSERT INTO `siping_county` VALUES ('2254', '610929', '白河县', '610900');
INSERT INTO `siping_county` VALUES ('2255', '611002', '商州区', '611000');
INSERT INTO `siping_county` VALUES ('2256', '611021', '洛南县', '611000');
INSERT INTO `siping_county` VALUES ('2257', '611022', '丹凤县', '611000');
INSERT INTO `siping_county` VALUES ('2258', '611023', '商南县', '611000');
INSERT INTO `siping_county` VALUES ('2259', '611024', '山阳县', '611000');
INSERT INTO `siping_county` VALUES ('2260', '611025', '镇安县', '611000');
INSERT INTO `siping_county` VALUES ('2261', '611026', '柞水县', '611000');
INSERT INTO `siping_county` VALUES ('2262', '510104', '锦江区', '510100');
INSERT INTO `siping_county` VALUES ('2263', '510106', '金牛区', '510100');
INSERT INTO `siping_county` VALUES ('2264', '510105', '青羊区', '510100');
INSERT INTO `siping_county` VALUES ('2265', '510107', '武侯区', '510100');
INSERT INTO `siping_county` VALUES ('2266', '510108', '成华区', '510100');
INSERT INTO `siping_county` VALUES ('2267', '510112', '龙泉驿区', '510100');
INSERT INTO `siping_county` VALUES ('2268', '510113', '青白江区', '510100');
INSERT INTO `siping_county` VALUES ('2269', '510114', '新都区', '510100');
INSERT INTO `siping_county` VALUES ('2270', '510115', '温江区', '510100');
INSERT INTO `siping_county` VALUES ('2271', '510121', '金堂县', '510100');
INSERT INTO `siping_county` VALUES ('2272', '510122', '双流县', '510100');
INSERT INTO `siping_county` VALUES ('2273', '510124', '郫县', '510100');
INSERT INTO `siping_county` VALUES ('2274', '510129', '大邑县', '510100');
INSERT INTO `siping_county` VALUES ('2275', '510131', '蒲江县', '510100');
INSERT INTO `siping_county` VALUES ('2276', '510132', '新津县', '510100');
INSERT INTO `siping_county` VALUES ('2277', '510181', '都江堰市', '510100');
INSERT INTO `siping_county` VALUES ('2278', '510182', '彭州市', '510100');
INSERT INTO `siping_county` VALUES ('2279', '510183', '邛崃市', '510100');
INSERT INTO `siping_county` VALUES ('2280', '510184', '崇州市', '510100');
INSERT INTO `siping_county` VALUES ('2281', '510303', '贡井区', '510300');
INSERT INTO `siping_county` VALUES ('2282', '510302', '自流井区', '510300');
INSERT INTO `siping_county` VALUES ('2283', '510304', '大安区', '510300');
INSERT INTO `siping_county` VALUES ('2284', '510311', '沿滩区', '510300');
INSERT INTO `siping_county` VALUES ('2285', '510321', '荣县', '510300');
INSERT INTO `siping_county` VALUES ('2286', '510322', '富顺县', '510300');
INSERT INTO `siping_county` VALUES ('2287', '510403', '西区', '510400');
INSERT INTO `siping_county` VALUES ('2288', '510402', '东区', '510400');
INSERT INTO `siping_county` VALUES ('2289', '510411', '仁和区', '510400');
INSERT INTO `siping_county` VALUES ('2290', '510421', '米易县', '510400');
INSERT INTO `siping_county` VALUES ('2291', '510422', '盐边县', '510400');
INSERT INTO `siping_county` VALUES ('2292', '510502', '江阳区', '510500');
INSERT INTO `siping_county` VALUES ('2293', '510503', '纳溪区', '510500');
INSERT INTO `siping_county` VALUES ('2294', '510504', '龙马潭区', '510500');
INSERT INTO `siping_county` VALUES ('2295', '510521', '泸县', '510500');
INSERT INTO `siping_county` VALUES ('2296', '510522', '合江县', '510500');
INSERT INTO `siping_county` VALUES ('2297', '510524', '叙永县', '510500');
INSERT INTO `siping_county` VALUES ('2298', '510525', '古蔺县', '510500');
INSERT INTO `siping_county` VALUES ('2299', '510603', '旌阳区', '510600');
INSERT INTO `siping_county` VALUES ('2300', '510623', '中江县', '510600');
INSERT INTO `siping_county` VALUES ('2301', '510626', '罗江县', '510600');
INSERT INTO `siping_county` VALUES ('2302', '510681', '广汉市', '510600');
INSERT INTO `siping_county` VALUES ('2303', '510682', '什邡市', '510600');
INSERT INTO `siping_county` VALUES ('2304', '510683', '绵竹市', '510600');
INSERT INTO `siping_county` VALUES ('2305', '510703', '涪城区', '510700');
INSERT INTO `siping_county` VALUES ('2306', '510704', '游仙区', '510700');
INSERT INTO `siping_county` VALUES ('2307', '510722', '三台县', '510700');
INSERT INTO `siping_county` VALUES ('2308', '510723', '盐亭县', '510700');
INSERT INTO `siping_county` VALUES ('2309', '510724', '安县', '510700');
INSERT INTO `siping_county` VALUES ('2310', '510725', '梓潼县', '510700');
INSERT INTO `siping_county` VALUES ('2311', '510726', '北川羌族自治县', '510700');
INSERT INTO `siping_county` VALUES ('2312', '510727', '平武县', '510700');
INSERT INTO `siping_county` VALUES ('2313', '510781', '江油市', '510700');
INSERT INTO `siping_county` VALUES ('2314', '510802', '利州区', '510800');
INSERT INTO `siping_county` VALUES ('2315', '510812', '朝天区', '510800');
INSERT INTO `siping_county` VALUES ('2316', '510811', '昭化区', '510800');
INSERT INTO `siping_county` VALUES ('2317', '510821', '旺苍县', '510800');
INSERT INTO `siping_county` VALUES ('2318', '510823', '剑阁县', '510800');
INSERT INTO `siping_county` VALUES ('2319', '510822', '青川县', '510800');
INSERT INTO `siping_county` VALUES ('2320', '510824', '苍溪县', '510800');
INSERT INTO `siping_county` VALUES ('2321', '510903', '船山区', '510900');
INSERT INTO `siping_county` VALUES ('2322', '510904', '安居区', '510900');
INSERT INTO `siping_county` VALUES ('2323', '510921', '蓬溪县', '510900');
INSERT INTO `siping_county` VALUES ('2324', '510922', '射洪县', '510900');
INSERT INTO `siping_county` VALUES ('2325', '510923', '大英县', '510900');
INSERT INTO `siping_county` VALUES ('2326', '511002', '市中区', '511000');
INSERT INTO `siping_county` VALUES ('2327', '511011', '东兴区', '511000');
INSERT INTO `siping_county` VALUES ('2328', '511024', '威远县', '511000');
INSERT INTO `siping_county` VALUES ('2329', '511025', '资中县', '511000');
INSERT INTO `siping_county` VALUES ('2330', '511028', '隆昌县', '511000');
INSERT INTO `siping_county` VALUES ('2331', '511102', '市中区', '511100');
INSERT INTO `siping_county` VALUES ('2332', '511111', '沙湾区', '511100');
INSERT INTO `siping_county` VALUES ('2333', '511112', '五通桥区', '511100');
INSERT INTO `siping_county` VALUES ('2334', '511113', '金口河区', '511100');
INSERT INTO `siping_county` VALUES ('2335', '511123', '犍为县', '511100');
INSERT INTO `siping_county` VALUES ('2336', '511124', '井研县', '511100');
INSERT INTO `siping_county` VALUES ('2337', '511126', '夹江县', '511100');
INSERT INTO `siping_county` VALUES ('2338', '511129', '沐川县', '511100');
INSERT INTO `siping_county` VALUES ('2339', '511132', '峨边彝族自治县', '511100');
INSERT INTO `siping_county` VALUES ('2340', '511133', '马边彝族自治县', '511100');
INSERT INTO `siping_county` VALUES ('2341', '511181', '峨眉山市', '511100');
INSERT INTO `siping_county` VALUES ('2342', '511302', '顺庆区', '511300');
INSERT INTO `siping_county` VALUES ('2343', '511303', '高坪区', '511300');
INSERT INTO `siping_county` VALUES ('2344', '511304', '嘉陵区', '511300');
INSERT INTO `siping_county` VALUES ('2345', '511321', '南部县', '511300');
INSERT INTO `siping_county` VALUES ('2346', '511322', '营山县', '511300');
INSERT INTO `siping_county` VALUES ('2347', '511323', '蓬安县', '511300');
INSERT INTO `siping_county` VALUES ('2348', '511324', '仪陇县', '511300');
INSERT INTO `siping_county` VALUES ('2349', '511325', '西充县', '511300');
INSERT INTO `siping_county` VALUES ('2350', '511381', '阆中市', '511300');
INSERT INTO `siping_county` VALUES ('2351', '511421', '仁寿县', '511400');
INSERT INTO `siping_county` VALUES ('2352', '511402', '东坡区', '511400');
INSERT INTO `siping_county` VALUES ('2353', '511422', '彭山县', '511400');
INSERT INTO `siping_county` VALUES ('2354', '511423', '洪雅县', '511400');
INSERT INTO `siping_county` VALUES ('2355', '511424', '丹棱县', '511400');
INSERT INTO `siping_county` VALUES ('2356', '511425', '青神县', '511400');
INSERT INTO `siping_county` VALUES ('2357', '511502', '翠屏区', '511500');
INSERT INTO `siping_county` VALUES ('2358', '511503', '南溪区', '511500');
INSERT INTO `siping_county` VALUES ('2359', '511521', '宜宾县', '511500');
INSERT INTO `siping_county` VALUES ('2360', '511523', '江安县', '511500');
INSERT INTO `siping_county` VALUES ('2361', '511524', '长宁县', '511500');
INSERT INTO `siping_county` VALUES ('2362', '511525', '高县', '511500');
INSERT INTO `siping_county` VALUES ('2363', '511526', '珙县', '511500');
INSERT INTO `siping_county` VALUES ('2364', '511527', '筠连县', '511500');
INSERT INTO `siping_county` VALUES ('2365', '511528', '兴文县', '511500');
INSERT INTO `siping_county` VALUES ('2366', '511529', '屏山县', '511500');
INSERT INTO `siping_county` VALUES ('2367', '511602', '广安区', '511600');
INSERT INTO `siping_county` VALUES ('2368', '511603', '前锋区', '511600');
INSERT INTO `siping_county` VALUES ('2369', '511621', '岳池县', '511600');
INSERT INTO `siping_county` VALUES ('2370', '511622', '武胜县', '511600');
INSERT INTO `siping_county` VALUES ('2371', '511623', '邻水县', '511600');
INSERT INTO `siping_county` VALUES ('2372', '511681', '华蓥市', '511600');
INSERT INTO `siping_county` VALUES ('2373', '511702', '通川区', '511700');
INSERT INTO `siping_county` VALUES ('2374', '511703', '达川区', '511700');
INSERT INTO `siping_county` VALUES ('2375', '511722', '宣汉县', '511700');
INSERT INTO `siping_county` VALUES ('2376', '511723', '开江县', '511700');
INSERT INTO `siping_county` VALUES ('2377', '511724', '大竹县', '511700');
INSERT INTO `siping_county` VALUES ('2378', '511725', '渠县', '511700');
INSERT INTO `siping_county` VALUES ('2379', '511781', '万源市', '511700');
INSERT INTO `siping_county` VALUES ('2380', '511802', '雨城区', '511800');
INSERT INTO `siping_county` VALUES ('2381', '511803', '名山区', '511800');
INSERT INTO `siping_county` VALUES ('2382', '511822', '荥经县', '511800');
INSERT INTO `siping_county` VALUES ('2383', '511823', '汉源县', '511800');
INSERT INTO `siping_county` VALUES ('2384', '511824', '石棉县', '511800');
INSERT INTO `siping_county` VALUES ('2385', '511825', '天全县', '511800');
INSERT INTO `siping_county` VALUES ('2386', '511826', '芦山县', '511800');
INSERT INTO `siping_county` VALUES ('2387', '511827', '宝兴县', '511800');
INSERT INTO `siping_county` VALUES ('2388', '511902', '巴州区', '511900');
INSERT INTO `siping_county` VALUES ('2389', '511903', '恩阳区', '511900');
INSERT INTO `siping_county` VALUES ('2390', '511921', '通江县', '511900');
INSERT INTO `siping_county` VALUES ('2391', '511922', '南江县', '511900');
INSERT INTO `siping_county` VALUES ('2392', '511923', '平昌县', '511900');
INSERT INTO `siping_county` VALUES ('2393', '512002', '雁江区', '512000');
INSERT INTO `siping_county` VALUES ('2394', '512021', '安岳县', '512000');
INSERT INTO `siping_county` VALUES ('2395', '512022', '乐至县', '512000');
INSERT INTO `siping_county` VALUES ('2396', '512081', '简阳市', '512000');
INSERT INTO `siping_county` VALUES ('2397', '513221', '汶川县', '513200');
INSERT INTO `siping_county` VALUES ('2398', '513222', '理县', '513200');
INSERT INTO `siping_county` VALUES ('2399', '513223', '茂县', '513200');
INSERT INTO `siping_county` VALUES ('2400', '513224', '松潘县', '513200');
INSERT INTO `siping_county` VALUES ('2401', '513225', '九寨沟县', '513200');
INSERT INTO `siping_county` VALUES ('2402', '513226', '金川县', '513200');
INSERT INTO `siping_county` VALUES ('2403', '513227', '小金县', '513200');
INSERT INTO `siping_county` VALUES ('2404', '513228', '黑水县', '513200');
INSERT INTO `siping_county` VALUES ('2405', '513229', '马尔康县', '513200');
INSERT INTO `siping_county` VALUES ('2406', '513230', '壤塘县', '513200');
INSERT INTO `siping_county` VALUES ('2407', '513231', '阿坝县', '513200');
INSERT INTO `siping_county` VALUES ('2408', '513232', '若尔盖县', '513200');
INSERT INTO `siping_county` VALUES ('2409', '513233', '红原县', '513200');
INSERT INTO `siping_county` VALUES ('2410', '513321', '康定县', '513300');
INSERT INTO `siping_county` VALUES ('2411', '513322', '泸定县', '513300');
INSERT INTO `siping_county` VALUES ('2412', '513323', '丹巴县', '513300');
INSERT INTO `siping_county` VALUES ('2413', '513324', '九龙县', '513300');
INSERT INTO `siping_county` VALUES ('2414', '513325', '雅江县', '513300');
INSERT INTO `siping_county` VALUES ('2415', '513326', '道孚县', '513300');
INSERT INTO `siping_county` VALUES ('2416', '513327', '炉霍县', '513300');
INSERT INTO `siping_county` VALUES ('2417', '513328', '甘孜县', '513300');
INSERT INTO `siping_county` VALUES ('2418', '513329', '新龙县', '513300');
INSERT INTO `siping_county` VALUES ('2419', '513330', '德格县', '513300');
INSERT INTO `siping_county` VALUES ('2420', '513331', '白玉县', '513300');
INSERT INTO `siping_county` VALUES ('2421', '513332', '石渠县', '513300');
INSERT INTO `siping_county` VALUES ('2422', '513333', '色达县', '513300');
INSERT INTO `siping_county` VALUES ('2423', '513334', '理塘县', '513300');
INSERT INTO `siping_county` VALUES ('2424', '513335', '巴塘县', '513300');
INSERT INTO `siping_county` VALUES ('2425', '513336', '乡城县', '513300');
INSERT INTO `siping_county` VALUES ('2426', '513337', '稻城县', '513300');
INSERT INTO `siping_county` VALUES ('2427', '513338', '得荣县', '513300');
INSERT INTO `siping_county` VALUES ('2428', '513401', '西昌市', '513400');
INSERT INTO `siping_county` VALUES ('2429', '513422', '木里藏族自治县', '513400');
INSERT INTO `siping_county` VALUES ('2430', '513423', '盐源县', '513400');
INSERT INTO `siping_county` VALUES ('2431', '513424', '德昌县', '513400');
INSERT INTO `siping_county` VALUES ('2432', '513425', '会理县', '513400');
INSERT INTO `siping_county` VALUES ('2433', '513426', '会东县', '513400');
INSERT INTO `siping_county` VALUES ('2434', '513427', '宁南县', '513400');
INSERT INTO `siping_county` VALUES ('2435', '513428', '普格县', '513400');
INSERT INTO `siping_county` VALUES ('2436', '513429', '布拖县', '513400');
INSERT INTO `siping_county` VALUES ('2437', '513430', '金阳县', '513400');
INSERT INTO `siping_county` VALUES ('2438', '513432', '喜德县', '513400');
INSERT INTO `siping_county` VALUES ('2439', '513431', '昭觉县', '513400');
INSERT INTO `siping_county` VALUES ('2440', '513433', '冕宁县', '513400');
INSERT INTO `siping_county` VALUES ('2441', '513435', '甘洛县', '513400');
INSERT INTO `siping_county` VALUES ('2442', '513434', '越西县', '513400');
INSERT INTO `siping_county` VALUES ('2443', '513436', '美姑县', '513400');
INSERT INTO `siping_county` VALUES ('2444', '513437', '雷波县', '513400');
INSERT INTO `siping_county` VALUES ('2445', '120101', '和平区', '120000');
INSERT INTO `siping_county` VALUES ('2446', '120102', '河东区', '120000');
INSERT INTO `siping_county` VALUES ('2447', '120103', '河西区', '120000');
INSERT INTO `siping_county` VALUES ('2448', '120104', '南开区', '120000');
INSERT INTO `siping_county` VALUES ('2449', '120105', '河北区', '120000');
INSERT INTO `siping_county` VALUES ('2450', '120106', '红桥区', '120000');
INSERT INTO `siping_county` VALUES ('2451', '120110', '东丽区', '120000');
INSERT INTO `siping_county` VALUES ('2452', '120111', '西青区', '120000');
INSERT INTO `siping_county` VALUES ('2453', '120112', '津南区', '120000');
INSERT INTO `siping_county` VALUES ('2454', '120113', '北辰区', '120000');
INSERT INTO `siping_county` VALUES ('2455', '120114', '武清区', '120000');
INSERT INTO `siping_county` VALUES ('2456', '120115', '宝坻区', '120000');
INSERT INTO `siping_county` VALUES ('2457', '120116', '滨海新区', '120000');
INSERT INTO `siping_county` VALUES ('2458', '120221', '宁河县', '120000');
INSERT INTO `siping_county` VALUES ('2459', '120223', '静海县', '120000');
INSERT INTO `siping_county` VALUES ('2460', '120225', '蓟县', '120000');
INSERT INTO `siping_county` VALUES ('2461', '650102', '天山区', '650100');
INSERT INTO `siping_county` VALUES ('2462', '650103', '沙依巴克区', '650100');
INSERT INTO `siping_county` VALUES ('2463', '650104', '新市区', '650100');
INSERT INTO `siping_county` VALUES ('2464', '650105', '水磨沟区', '650100');
INSERT INTO `siping_county` VALUES ('2465', '650106', '头屯河区', '650100');
INSERT INTO `siping_county` VALUES ('2466', '650107', '达坂城区', '650100');
INSERT INTO `siping_county` VALUES ('2467', '650109', '米东区', '650100');
INSERT INTO `siping_county` VALUES ('2468', '650121', '乌鲁木齐县', '650100');
INSERT INTO `siping_county` VALUES ('2469', '650202', '独山子区', '650200');
INSERT INTO `siping_county` VALUES ('2470', '650203', '克拉玛依区', '650200');
INSERT INTO `siping_county` VALUES ('2471', '650204', '白碱滩区', '650200');
INSERT INTO `siping_county` VALUES ('2472', '650205', '乌尔禾区', '650200');
INSERT INTO `siping_county` VALUES ('2473', '652101', '吐鲁番市', '652100');
INSERT INTO `siping_county` VALUES ('2474', '652123', '托克逊县', '652100');
INSERT INTO `siping_county` VALUES ('2475', '652122', '鄯善县', '652100');
INSERT INTO `siping_county` VALUES ('2476', '652201', '哈密市', '652200');
INSERT INTO `siping_county` VALUES ('2477', '652222', '巴里坤哈萨克自治县', '652200');
INSERT INTO `siping_county` VALUES ('2478', '652223', '伊吾县', '652200');
INSERT INTO `siping_county` VALUES ('2479', '652301', '昌吉市', '652300');
INSERT INTO `siping_county` VALUES ('2480', '652302', '阜康市', '652300');
INSERT INTO `siping_county` VALUES ('2481', '652323', '呼图壁县', '652300');
INSERT INTO `siping_county` VALUES ('2482', '652324', '玛纳斯县', '652300');
INSERT INTO `siping_county` VALUES ('2483', '652325', '奇台县', '652300');
INSERT INTO `siping_county` VALUES ('2484', '652327', '吉木萨尔县', '652300');
INSERT INTO `siping_county` VALUES ('2485', '652328', '木垒哈萨克自治县', '652300');
INSERT INTO `siping_county` VALUES ('2486', '652701', '博乐市', '652700');
INSERT INTO `siping_county` VALUES ('2487', '652702', '阿拉山口市', '652700');
INSERT INTO `siping_county` VALUES ('2488', '652722', '精河县', '652700');
INSERT INTO `siping_county` VALUES ('2489', '652723', '温泉县', '652700');
INSERT INTO `siping_county` VALUES ('2490', '652801', '库尔勒市', '652800');
INSERT INTO `siping_county` VALUES ('2491', '652822', '轮台县', '652800');
INSERT INTO `siping_county` VALUES ('2492', '652823', '尉犁县', '652800');
INSERT INTO `siping_county` VALUES ('2493', '652824', '若羌县', '652800');
INSERT INTO `siping_county` VALUES ('2494', '652825', '且末县', '652800');
INSERT INTO `siping_county` VALUES ('2495', '652826', '焉耆回族自治县', '652800');
INSERT INTO `siping_county` VALUES ('2496', '652827', '和静县', '652800');
INSERT INTO `siping_county` VALUES ('2497', '652828', '和硕县', '652800');
INSERT INTO `siping_county` VALUES ('2498', '652829', '博湖县', '652800');
INSERT INTO `siping_county` VALUES ('2499', '652901', '阿克苏市', '652900');
INSERT INTO `siping_county` VALUES ('2500', '652922', '温宿县', '652900');
INSERT INTO `siping_county` VALUES ('2501', '652923', '库车县', '652900');
INSERT INTO `siping_county` VALUES ('2502', '652924', '沙雅县', '652900');
INSERT INTO `siping_county` VALUES ('2503', '652925', '新和县', '652900');
INSERT INTO `siping_county` VALUES ('2504', '652926', '拜城县', '652900');
INSERT INTO `siping_county` VALUES ('2505', '652927', '乌什县', '652900');
INSERT INTO `siping_county` VALUES ('2506', '652928', '阿瓦提县', '652900');
INSERT INTO `siping_county` VALUES ('2507', '653001', '阿图什市', '653000');
INSERT INTO `siping_county` VALUES ('2508', '652929', '柯坪县', '652900');
INSERT INTO `siping_county` VALUES ('2509', '653022', '阿克陶县', '653000');
INSERT INTO `siping_county` VALUES ('2510', '653023', '阿合奇县', '653000');
INSERT INTO `siping_county` VALUES ('2511', '653024', '乌恰县', '653000');
INSERT INTO `siping_county` VALUES ('2512', '653101', '喀什市', '653100');
INSERT INTO `siping_county` VALUES ('2513', '653121', '疏附县', '653100');
INSERT INTO `siping_county` VALUES ('2514', '653122', '疏勒县', '653100');
INSERT INTO `siping_county` VALUES ('2515', '653123', '英吉沙县', '653100');
INSERT INTO `siping_county` VALUES ('2516', '653124', '泽普县', '653100');
INSERT INTO `siping_county` VALUES ('2517', '653125', '莎车县', '653100');
INSERT INTO `siping_county` VALUES ('2518', '653126', '叶城县', '653100');
INSERT INTO `siping_county` VALUES ('2519', '653127', '麦盖提县', '653100');
INSERT INTO `siping_county` VALUES ('2520', '653128', '岳普湖县', '653100');
INSERT INTO `siping_county` VALUES ('2521', '653129', '伽师县', '653100');
INSERT INTO `siping_county` VALUES ('2522', '653130', '巴楚县', '653100');
INSERT INTO `siping_county` VALUES ('2523', '653131', '塔什库尔干塔吉克自治县', '653100');
INSERT INTO `siping_county` VALUES ('2524', '653201', '和田市', '653200');
INSERT INTO `siping_county` VALUES ('2525', '653221', '和田县', '653200');
INSERT INTO `siping_county` VALUES ('2526', '653222', '墨玉县', '653200');
INSERT INTO `siping_county` VALUES ('2527', '653223', '皮山县', '653200');
INSERT INTO `siping_county` VALUES ('2528', '653224', '洛浦县', '653200');
INSERT INTO `siping_county` VALUES ('2529', '653225', '策勒县', '653200');
INSERT INTO `siping_county` VALUES ('2530', '653226', '于田县', '653200');
INSERT INTO `siping_county` VALUES ('2531', '653227', '民丰县', '653200');
INSERT INTO `siping_county` VALUES ('2532', '654002', '伊宁市', '654000');
INSERT INTO `siping_county` VALUES ('2533', '654003', '奎屯市', '654000');
INSERT INTO `siping_county` VALUES ('2534', '654021', '伊宁县', '654000');
INSERT INTO `siping_county` VALUES ('2535', '654022', '察布查尔锡伯自治县', '654000');
INSERT INTO `siping_county` VALUES ('2536', '654023', '霍城县', '654000');
INSERT INTO `siping_county` VALUES ('2537', '654024', '巩留县', '654000');
INSERT INTO `siping_county` VALUES ('2538', '654025', '新源县', '654000');
INSERT INTO `siping_county` VALUES ('2539', '654026', '昭苏县', '654000');
INSERT INTO `siping_county` VALUES ('2540', '654027', '特克斯县', '654000');
INSERT INTO `siping_county` VALUES ('2541', '654028', '尼勒克县', '654000');
INSERT INTO `siping_county` VALUES ('2542', '654201', '塔城市', '654200');
INSERT INTO `siping_county` VALUES ('2543', '654202', '乌苏市', '654200');
INSERT INTO `siping_county` VALUES ('2544', '654221', '额敏县', '654200');
INSERT INTO `siping_county` VALUES ('2545', '654223', '沙湾县', '654200');
INSERT INTO `siping_county` VALUES ('2546', '654224', '托里县', '654200');
INSERT INTO `siping_county` VALUES ('2547', '654225', '裕民县', '654200');
INSERT INTO `siping_county` VALUES ('2548', '654226', '和布克赛尔蒙古自治县', '654200');
INSERT INTO `siping_county` VALUES ('2549', '654301', '阿勒泰市', '654300');
INSERT INTO `siping_county` VALUES ('2550', '654321', '布尔津县', '654300');
INSERT INTO `siping_county` VALUES ('2551', '654322', '富蕴县', '654300');
INSERT INTO `siping_county` VALUES ('2552', '654323', '福海县', '654300');
INSERT INTO `siping_county` VALUES ('2553', '654324', '哈巴河县', '654300');
INSERT INTO `siping_county` VALUES ('2554', '654325', '青河县', '654300');
INSERT INTO `siping_county` VALUES ('2555', '654326', '吉木乃县', '654300');
INSERT INTO `siping_county` VALUES ('2556', '659001', '石河子市', '659000');
INSERT INTO `siping_county` VALUES ('2557', '659002', '阿拉尔市', '659000');
INSERT INTO `siping_county` VALUES ('2558', '659003', '图木舒克市', '659000');
INSERT INTO `siping_county` VALUES ('2559', '659004', '五家渠市', '659000');
INSERT INTO `siping_county` VALUES ('2560', '540102', '城关区', '540100');
INSERT INTO `siping_county` VALUES ('2561', '540121', '林周县', '540100');
INSERT INTO `siping_county` VALUES ('2562', '540122', '当雄县', '540100');
INSERT INTO `siping_county` VALUES ('2563', '540123', '尼木县', '540100');
INSERT INTO `siping_county` VALUES ('2564', '540124', '曲水县', '540100');
INSERT INTO `siping_county` VALUES ('2565', '540125', '堆龙德庆县', '540100');
INSERT INTO `siping_county` VALUES ('2566', '540126', '达孜县', '540100');
INSERT INTO `siping_county` VALUES ('2567', '540127', '墨竹工卡县', '540100');
INSERT INTO `siping_county` VALUES ('2568', '540202', '桑珠孜区', '540200');
INSERT INTO `siping_county` VALUES ('2569', '540221', '南木林县', '540200');
INSERT INTO `siping_county` VALUES ('2570', '540222', '江孜县', '540200');
INSERT INTO `siping_county` VALUES ('2571', '540223', '定日县', '540200');
INSERT INTO `siping_county` VALUES ('2572', '540224', '萨迦县', '540200');
INSERT INTO `siping_county` VALUES ('2573', '540225', '拉孜县', '540200');
INSERT INTO `siping_county` VALUES ('2574', '540226', '昂仁县', '540200');
INSERT INTO `siping_county` VALUES ('2575', '540227', '谢通门县', '540200');
INSERT INTO `siping_county` VALUES ('2576', '540228', '白朗县', '540200');
INSERT INTO `siping_county` VALUES ('2577', '540229', '仁布县', '540200');
INSERT INTO `siping_county` VALUES ('2578', '540230', '康马县', '540200');
INSERT INTO `siping_county` VALUES ('2579', '540231', '定结县', '540200');
INSERT INTO `siping_county` VALUES ('2580', '540232', '仲巴县', '540200');
INSERT INTO `siping_county` VALUES ('2581', '540233', '亚东县', '540200');
INSERT INTO `siping_county` VALUES ('2582', '540234', '吉隆县', '540200');
INSERT INTO `siping_county` VALUES ('2583', '540236', '萨嘎县', '540200');
INSERT INTO `siping_county` VALUES ('2584', '540235', '聂拉木县', '540200');
INSERT INTO `siping_county` VALUES ('2585', '542122', '江达县', '542100');
INSERT INTO `siping_county` VALUES ('2586', '542123', '贡觉县', '542100');
INSERT INTO `siping_county` VALUES ('2587', '542124', '类乌齐县', '542100');
INSERT INTO `siping_county` VALUES ('2588', '540237', '岗巴县', '540200');
INSERT INTO `siping_county` VALUES ('2589', '542121', '昌都县', '542100');
INSERT INTO `siping_county` VALUES ('2590', '542125', '丁青县', '542100');
INSERT INTO `siping_county` VALUES ('2591', '542126', '察雅县', '542100');
INSERT INTO `siping_county` VALUES ('2592', '542127', '八宿县', '542100');
INSERT INTO `siping_county` VALUES ('2593', '542128', '左贡县', '542100');
INSERT INTO `siping_county` VALUES ('2594', '542129', '芒康县', '542100');
INSERT INTO `siping_county` VALUES ('2595', '542132', '洛隆县', '542100');
INSERT INTO `siping_county` VALUES ('2596', '542222', '扎囊县', '542200');
INSERT INTO `siping_county` VALUES ('2597', '542133', '边坝县', '542100');
INSERT INTO `siping_county` VALUES ('2598', '542221', '乃东县', '542200');
INSERT INTO `siping_county` VALUES ('2599', '542223', '贡嘎县', '542200');
INSERT INTO `siping_county` VALUES ('2600', '542224', '桑日县', '542200');
INSERT INTO `siping_county` VALUES ('2601', '542225', '琼结县', '542200');
INSERT INTO `siping_county` VALUES ('2602', '542227', '措美县', '542200');
INSERT INTO `siping_county` VALUES ('2603', '542226', '曲松县', '542200');
INSERT INTO `siping_county` VALUES ('2604', '542228', '洛扎县', '542200');
INSERT INTO `siping_county` VALUES ('2605', '542229', '加查县', '542200');
INSERT INTO `siping_county` VALUES ('2606', '542231', '隆子县', '542200');
INSERT INTO `siping_county` VALUES ('2607', '542232', '错那县', '542200');
INSERT INTO `siping_county` VALUES ('2608', '542233', '浪卡子县', '542200');
INSERT INTO `siping_county` VALUES ('2609', '542421', '那曲县', '542400');
INSERT INTO `siping_county` VALUES ('2610', '542422', '嘉黎县', '542400');
INSERT INTO `siping_county` VALUES ('2611', '542423', '比如县', '542400');
INSERT INTO `siping_county` VALUES ('2612', '542424', '聂荣县', '542400');
INSERT INTO `siping_county` VALUES ('2613', '542425', '安多县', '542400');
INSERT INTO `siping_county` VALUES ('2614', '542426', '申扎县', '542400');
INSERT INTO `siping_county` VALUES ('2615', '542427', '索县', '542400');
INSERT INTO `siping_county` VALUES ('2616', '542428', '班戈县', '542400');
INSERT INTO `siping_county` VALUES ('2617', '542429', '巴青县', '542400');
INSERT INTO `siping_county` VALUES ('2618', '542430', '尼玛县', '542400');
INSERT INTO `siping_county` VALUES ('2619', '542431', '双湖县', '542400');
INSERT INTO `siping_county` VALUES ('2620', '542521', '普兰县', '542500');
INSERT INTO `siping_county` VALUES ('2621', '542522', '札达县', '542500');
INSERT INTO `siping_county` VALUES ('2622', '542523', '噶尔县', '542500');
INSERT INTO `siping_county` VALUES ('2623', '542524', '日土县', '542500');
INSERT INTO `siping_county` VALUES ('2624', '542525', '革吉县', '542500');
INSERT INTO `siping_county` VALUES ('2625', '542527', '措勤县', '542500');
INSERT INTO `siping_county` VALUES ('2626', '542526', '改则县', '542500');
INSERT INTO `siping_county` VALUES ('2627', '542621', '林芝县', '542600');
INSERT INTO `siping_county` VALUES ('2628', '542622', '工布江达县', '542600');
INSERT INTO `siping_county` VALUES ('2629', '542623', '米林县', '542600');
INSERT INTO `siping_county` VALUES ('2630', '542624', '墨脱县', '542600');
INSERT INTO `siping_county` VALUES ('2631', '542625', '波密县', '542600');
INSERT INTO `siping_county` VALUES ('2632', '542626', '察隅县', '542600');
INSERT INTO `siping_county` VALUES ('2633', '542627', '朗县', '542600');
INSERT INTO `siping_county` VALUES ('2634', '530102', '五华区', '530100');
INSERT INTO `siping_county` VALUES ('2635', '530103', '盘龙区', '530100');
INSERT INTO `siping_county` VALUES ('2636', '530111', '官渡区', '530100');
INSERT INTO `siping_county` VALUES ('2637', '530112', '西山区', '530100');
INSERT INTO `siping_county` VALUES ('2638', '530114', '呈贡区', '530100');
INSERT INTO `siping_county` VALUES ('2639', '530122', '晋宁县', '530100');
INSERT INTO `siping_county` VALUES ('2640', '530113', '东川区', '530100');
INSERT INTO `siping_county` VALUES ('2641', '530125', '宜良县', '530100');
INSERT INTO `siping_county` VALUES ('2642', '530124', '富民县', '530100');
INSERT INTO `siping_county` VALUES ('2643', '530126', '石林彝族自治县', '530100');
INSERT INTO `siping_county` VALUES ('2644', '530127', '嵩明县', '530100');
INSERT INTO `siping_county` VALUES ('2645', '530128', '禄劝彝族苗族自治县', '530100');
INSERT INTO `siping_county` VALUES ('2646', '530129', '寻甸回族彝族自治县', '530100');
INSERT INTO `siping_county` VALUES ('2647', '530181', '安宁市', '530100');
INSERT INTO `siping_county` VALUES ('2648', '530302', '麒麟区', '530300');
INSERT INTO `siping_county` VALUES ('2649', '530321', '马龙县', '530300');
INSERT INTO `siping_county` VALUES ('2650', '530322', '陆良县', '530300');
INSERT INTO `siping_county` VALUES ('2651', '530323', '师宗县', '530300');
INSERT INTO `siping_county` VALUES ('2652', '530324', '罗平县', '530300');
INSERT INTO `siping_county` VALUES ('2653', '530325', '富源县', '530300');
INSERT INTO `siping_county` VALUES ('2654', '530326', '会泽县', '530300');
INSERT INTO `siping_county` VALUES ('2655', '530381', '宣威市', '530300');
INSERT INTO `siping_county` VALUES ('2656', '530402', '红塔区', '530400');
INSERT INTO `siping_county` VALUES ('2657', '530328', '沾益县', '530300');
INSERT INTO `siping_county` VALUES ('2658', '530421', '江川县', '530400');
INSERT INTO `siping_county` VALUES ('2659', '530422', '澄江县', '530400');
INSERT INTO `siping_county` VALUES ('2660', '530423', '通海县', '530400');
INSERT INTO `siping_county` VALUES ('2661', '530424', '华宁县', '530400');
INSERT INTO `siping_county` VALUES ('2662', '530425', '易门县', '530400');
INSERT INTO `siping_county` VALUES ('2663', '530426', '峨山彝族自治县', '530400');
INSERT INTO `siping_county` VALUES ('2664', '530427', '新平彝族傣族自治县', '530400');
INSERT INTO `siping_county` VALUES ('2665', '530428', '元江哈尼族彝族傣族自治县', '530400');
INSERT INTO `siping_county` VALUES ('2666', '530502', '隆阳区', '530500');
INSERT INTO `siping_county` VALUES ('2667', '530521', '施甸县', '530500');
INSERT INTO `siping_county` VALUES ('2668', '530522', '腾冲县', '530500');
INSERT INTO `siping_county` VALUES ('2669', '530523', '龙陵县', '530500');
INSERT INTO `siping_county` VALUES ('2670', '530524', '昌宁县', '530500');
INSERT INTO `siping_county` VALUES ('2671', '530602', '昭阳区', '530600');
INSERT INTO `siping_county` VALUES ('2672', '530621', '鲁甸县', '530600');
INSERT INTO `siping_county` VALUES ('2673', '530622', '巧家县', '530600');
INSERT INTO `siping_county` VALUES ('2674', '530623', '盐津县', '530600');
INSERT INTO `siping_county` VALUES ('2675', '530624', '大关县', '530600');
INSERT INTO `siping_county` VALUES ('2676', '530625', '永善县', '530600');
INSERT INTO `siping_county` VALUES ('2677', '530626', '绥江县', '530600');
INSERT INTO `siping_county` VALUES ('2678', '530627', '镇雄县', '530600');
INSERT INTO `siping_county` VALUES ('2679', '530628', '彝良县', '530600');
INSERT INTO `siping_county` VALUES ('2680', '530629', '威信县', '530600');
INSERT INTO `siping_county` VALUES ('2681', '530630', '水富县', '530600');
INSERT INTO `siping_county` VALUES ('2682', '530721', '玉龙纳西族自治县', '530700');
INSERT INTO `siping_county` VALUES ('2683', '530702', '古城区', '530700');
INSERT INTO `siping_county` VALUES ('2684', '530722', '永胜县', '530700');
INSERT INTO `siping_county` VALUES ('2685', '530723', '华坪县', '530700');
INSERT INTO `siping_county` VALUES ('2686', '530802', '思茅区', '530800');
INSERT INTO `siping_county` VALUES ('2687', '530821', '宁洱哈尼族彝族自治县', '530800');
INSERT INTO `siping_county` VALUES ('2688', '530724', '宁蒗彝族自治县', '530700');
INSERT INTO `siping_county` VALUES ('2689', '530822', '墨江哈尼族自治县', '530800');
INSERT INTO `siping_county` VALUES ('2690', '530823', '景东彝族自治县', '530800');
INSERT INTO `siping_county` VALUES ('2691', '530824', '景谷傣族彝族自治县', '530800');
INSERT INTO `siping_county` VALUES ('2692', '530825', '镇沅彝族哈尼族拉祜族自治县', '530800');
INSERT INTO `siping_county` VALUES ('2693', '530826', '江城哈尼族彝族自治县', '530800');
INSERT INTO `siping_county` VALUES ('2694', '530827', '孟连傣族拉祜族佤族自治县', '530800');
INSERT INTO `siping_county` VALUES ('2695', '530828', '澜沧拉祜族自治县', '530800');
INSERT INTO `siping_county` VALUES ('2696', '530829', '西盟佤族自治县', '530800');
INSERT INTO `siping_county` VALUES ('2697', '530902', '临翔区', '530900');
INSERT INTO `siping_county` VALUES ('2698', '530921', '凤庆县', '530900');
INSERT INTO `siping_county` VALUES ('2699', '530922', '云县', '530900');
INSERT INTO `siping_county` VALUES ('2700', '530924', '镇康县', '530900');
INSERT INTO `siping_county` VALUES ('2701', '530923', '永德县', '530900');
INSERT INTO `siping_county` VALUES ('2702', '530925', '双江拉祜族佤族布朗族傣族自治县', '530900');
INSERT INTO `siping_county` VALUES ('2703', '530926', '耿马傣族佤族自治县', '530900');
INSERT INTO `siping_county` VALUES ('2704', '530927', '沧源佤族自治县', '530900');
INSERT INTO `siping_county` VALUES ('2705', '532322', '双柏县', '532300');
INSERT INTO `siping_county` VALUES ('2706', '532301', '楚雄市', '532300');
INSERT INTO `siping_county` VALUES ('2707', '532323', '牟定县', '532300');
INSERT INTO `siping_county` VALUES ('2708', '532324', '南华县', '532300');
INSERT INTO `siping_county` VALUES ('2709', '532326', '大姚县', '532300');
INSERT INTO `siping_county` VALUES ('2710', '532325', '姚安县', '532300');
INSERT INTO `siping_county` VALUES ('2711', '532327', '永仁县', '532300');
INSERT INTO `siping_county` VALUES ('2712', '532328', '元谋县', '532300');
INSERT INTO `siping_county` VALUES ('2713', '532329', '武定县', '532300');
INSERT INTO `siping_county` VALUES ('2714', '532331', '禄丰县', '532300');
INSERT INTO `siping_county` VALUES ('2715', '532501', '个旧市', '532500');
INSERT INTO `siping_county` VALUES ('2716', '532502', '开远市', '532500');
INSERT INTO `siping_county` VALUES ('2717', '532503', '蒙自市', '532500');
INSERT INTO `siping_county` VALUES ('2718', '532504', '弥勒市', '532500');
INSERT INTO `siping_county` VALUES ('2719', '532523', '屏边苗族自治县', '532500');
INSERT INTO `siping_county` VALUES ('2720', '532524', '建水县', '532500');
INSERT INTO `siping_county` VALUES ('2721', '532525', '石屏县', '532500');
INSERT INTO `siping_county` VALUES ('2722', '532527', '泸西县', '532500');
INSERT INTO `siping_county` VALUES ('2723', '532528', '元阳县', '532500');
INSERT INTO `siping_county` VALUES ('2724', '532529', '红河县', '532500');
INSERT INTO `siping_county` VALUES ('2725', '532530', '金平苗族瑶族傣族自治县', '532500');
INSERT INTO `siping_county` VALUES ('2726', '532531', '绿春县', '532500');
INSERT INTO `siping_county` VALUES ('2727', '532532', '河口瑶族自治县', '532500');
INSERT INTO `siping_county` VALUES ('2728', '532601', '文山市', '532600');
INSERT INTO `siping_county` VALUES ('2729', '532622', '砚山县', '532600');
INSERT INTO `siping_county` VALUES ('2730', '532623', '西畴县', '532600');
INSERT INTO `siping_county` VALUES ('2731', '532624', '麻栗坡县', '532600');
INSERT INTO `siping_county` VALUES ('2732', '532625', '马关县', '532600');
INSERT INTO `siping_county` VALUES ('2733', '532628', '富宁县', '532600');
INSERT INTO `siping_county` VALUES ('2734', '532626', '丘北县', '532600');
INSERT INTO `siping_county` VALUES ('2735', '532627', '广南县', '532600');
INSERT INTO `siping_county` VALUES ('2736', '532822', '勐海县', '532800');
INSERT INTO `siping_county` VALUES ('2737', '532801', '景洪市', '532800');
INSERT INTO `siping_county` VALUES ('2738', '532823', '勐腊县', '532800');
INSERT INTO `siping_county` VALUES ('2739', '532901', '大理市', '532900');
INSERT INTO `siping_county` VALUES ('2740', '532922', '漾濞彝族自治县', '532900');
INSERT INTO `siping_county` VALUES ('2741', '532923', '祥云县', '532900');
INSERT INTO `siping_county` VALUES ('2742', '532924', '宾川县', '532900');
INSERT INTO `siping_county` VALUES ('2743', '532925', '弥渡县', '532900');
INSERT INTO `siping_county` VALUES ('2744', '532926', '南涧彝族自治县', '532900');
INSERT INTO `siping_county` VALUES ('2745', '532927', '巍山彝族回族自治县', '532900');
INSERT INTO `siping_county` VALUES ('2746', '532928', '永平县', '532900');
INSERT INTO `siping_county` VALUES ('2747', '532929', '云龙县', '532900');
INSERT INTO `siping_county` VALUES ('2748', '532930', '洱源县', '532900');
INSERT INTO `siping_county` VALUES ('2749', '532931', '剑川县', '532900');
INSERT INTO `siping_county` VALUES ('2750', '532932', '鹤庆县', '532900');
INSERT INTO `siping_county` VALUES ('2751', '533102', '瑞丽市', '533100');
INSERT INTO `siping_county` VALUES ('2752', '533103', '芒市', '533100');
INSERT INTO `siping_county` VALUES ('2753', '533122', '梁河县', '533100');
INSERT INTO `siping_county` VALUES ('2754', '533123', '盈江县', '533100');
INSERT INTO `siping_county` VALUES ('2755', '533124', '陇川县', '533100');
INSERT INTO `siping_county` VALUES ('2756', '533321', '泸水县', '533300');
INSERT INTO `siping_county` VALUES ('2757', '533324', '贡山独龙族怒族自治县', '533300');
INSERT INTO `siping_county` VALUES ('2758', '533323', '福贡县', '533300');
INSERT INTO `siping_county` VALUES ('2759', '533325', '兰坪白族普米族自治县', '533300');
INSERT INTO `siping_county` VALUES ('2760', '533421', '香格里拉县', '533400');
INSERT INTO `siping_county` VALUES ('2761', '533422', '德钦县', '533400');
INSERT INTO `siping_county` VALUES ('2762', '533423', '维西傈僳族自治县', '533400');
INSERT INTO `siping_county` VALUES ('2763', '330102', '上城区', '330100');
INSERT INTO `siping_county` VALUES ('2764', '330103', '下城区', '330100');
INSERT INTO `siping_county` VALUES ('2765', '330104', '江干区', '330100');
INSERT INTO `siping_county` VALUES ('2766', '330105', '拱墅区', '330100');
INSERT INTO `siping_county` VALUES ('2767', '330106', '西湖区', '330100');
INSERT INTO `siping_county` VALUES ('2768', '330108', '滨江区', '330100');
INSERT INTO `siping_county` VALUES ('2769', '330109', '萧山区', '330100');
INSERT INTO `siping_county` VALUES ('2770', '330110', '余杭区', '330100');
INSERT INTO `siping_county` VALUES ('2771', '330122', '桐庐县', '330100');
INSERT INTO `siping_county` VALUES ('2772', '330127', '淳安县', '330100');
INSERT INTO `siping_county` VALUES ('2773', '330182', '建德市', '330100');
INSERT INTO `siping_county` VALUES ('2774', '330183', '富阳市', '330100');
INSERT INTO `siping_county` VALUES ('2775', '330185', '临安市', '330100');
INSERT INTO `siping_county` VALUES ('2776', '330203', '海曙区', '330200');
INSERT INTO `siping_county` VALUES ('2777', '330204', '江东区', '330200');
INSERT INTO `siping_county` VALUES ('2778', '330205', '江北区', '330200');
INSERT INTO `siping_county` VALUES ('2779', '330206', '北仑区', '330200');
INSERT INTO `siping_county` VALUES ('2780', '330212', '鄞州区', '330200');
INSERT INTO `siping_county` VALUES ('2781', '330211', '镇海区', '330200');
INSERT INTO `siping_county` VALUES ('2782', '330225', '象山县', '330200');
INSERT INTO `siping_county` VALUES ('2783', '330226', '宁海县', '330200');
INSERT INTO `siping_county` VALUES ('2784', '330281', '余姚市', '330200');
INSERT INTO `siping_county` VALUES ('2785', '330282', '慈溪市', '330200');
INSERT INTO `siping_county` VALUES ('2786', '330283', '奉化市', '330200');
INSERT INTO `siping_county` VALUES ('2787', '330302', '鹿城区', '330300');
INSERT INTO `siping_county` VALUES ('2788', '330303', '龙湾区', '330300');
INSERT INTO `siping_county` VALUES ('2789', '330304', '瓯海区', '330300');
INSERT INTO `siping_county` VALUES ('2790', '330322', '洞头县', '330300');
INSERT INTO `siping_county` VALUES ('2791', '330324', '永嘉县', '330300');
INSERT INTO `siping_county` VALUES ('2792', '330326', '平阳县', '330300');
INSERT INTO `siping_county` VALUES ('2793', '330327', '苍南县', '330300');
INSERT INTO `siping_county` VALUES ('2794', '330328', '文成县', '330300');
INSERT INTO `siping_county` VALUES ('2795', '330329', '泰顺县', '330300');
INSERT INTO `siping_county` VALUES ('2796', '330381', '瑞安市', '330300');
INSERT INTO `siping_county` VALUES ('2797', '330382', '乐清市', '330300');
INSERT INTO `siping_county` VALUES ('2798', '330402', '南湖区', '330400');
INSERT INTO `siping_county` VALUES ('2799', '330411', '秀洲区', '330400');
INSERT INTO `siping_county` VALUES ('2800', '330421', '嘉善县', '330400');
INSERT INTO `siping_county` VALUES ('2801', '330424', '海盐县', '330400');
INSERT INTO `siping_county` VALUES ('2802', '330481', '海宁市', '330400');
INSERT INTO `siping_county` VALUES ('2803', '330482', '平湖市', '330400');
INSERT INTO `siping_county` VALUES ('2804', '330483', '桐乡市', '330400');
INSERT INTO `siping_county` VALUES ('2805', '330502', '吴兴区', '330500');
INSERT INTO `siping_county` VALUES ('2806', '330503', '南浔区', '330500');
INSERT INTO `siping_county` VALUES ('2807', '330521', '德清县', '330500');
INSERT INTO `siping_county` VALUES ('2808', '330522', '长兴县', '330500');
INSERT INTO `siping_county` VALUES ('2809', '330523', '安吉县', '330500');
INSERT INTO `siping_county` VALUES ('2810', '330602', '越城区', '330600');
INSERT INTO `siping_county` VALUES ('2811', '330603', '柯桥区', '330600');
INSERT INTO `siping_county` VALUES ('2812', '330604', '上虞区', '330600');
INSERT INTO `siping_county` VALUES ('2813', '330624', '新昌县', '330600');
INSERT INTO `siping_county` VALUES ('2814', '330681', '诸暨市', '330600');
INSERT INTO `siping_county` VALUES ('2815', '330683', '嵊州市', '330600');
INSERT INTO `siping_county` VALUES ('2816', '330702', '婺城区', '330700');
INSERT INTO `siping_county` VALUES ('2817', '330781', '兰溪市', '330700');
INSERT INTO `siping_county` VALUES ('2818', '330727', '磐安县', '330700');
INSERT INTO `siping_county` VALUES ('2819', '330723', '武义县', '330700');
INSERT INTO `siping_county` VALUES ('2820', '330703', '金东区', '330700');
INSERT INTO `siping_county` VALUES ('2821', '330726', '浦江县', '330700');
INSERT INTO `siping_county` VALUES ('2822', '330782', '义乌市', '330700');
INSERT INTO `siping_county` VALUES ('2823', '330783', '东阳市', '330700');
INSERT INTO `siping_county` VALUES ('2824', '330784', '永康市', '330700');
INSERT INTO `siping_county` VALUES ('2825', '330802', '柯城区', '330800');
INSERT INTO `siping_county` VALUES ('2826', '330803', '衢江区', '330800');
INSERT INTO `siping_county` VALUES ('2827', '330822', '常山县', '330800');
INSERT INTO `siping_county` VALUES ('2828', '330825', '龙游县', '330800');
INSERT INTO `siping_county` VALUES ('2829', '330824', '开化县', '330800');
INSERT INTO `siping_county` VALUES ('2830', '330881', '江山市', '330800');
INSERT INTO `siping_county` VALUES ('2831', '330902', '定海区', '330900');
INSERT INTO `siping_county` VALUES ('2832', '330903', '普陀区', '330900');
INSERT INTO `siping_county` VALUES ('2833', '330921', '岱山县', '330900');
INSERT INTO `siping_county` VALUES ('2834', '330922', '嵊泗县', '330900');
INSERT INTO `siping_county` VALUES ('2835', '331002', '椒江区', '331000');
INSERT INTO `siping_county` VALUES ('2836', '331003', '黄岩区', '331000');
INSERT INTO `siping_county` VALUES ('2837', '331004', '路桥区', '331000');
INSERT INTO `siping_county` VALUES ('2838', '331021', '玉环县', '331000');
INSERT INTO `siping_county` VALUES ('2839', '331022', '三门县', '331000');
INSERT INTO `siping_county` VALUES ('2840', '331023', '天台县', '331000');
INSERT INTO `siping_county` VALUES ('2841', '331024', '仙居县', '331000');
INSERT INTO `siping_county` VALUES ('2842', '331081', '温岭市', '331000');
INSERT INTO `siping_county` VALUES ('2843', '331082', '临海市', '331000');
INSERT INTO `siping_county` VALUES ('2844', '331121', '青田县', '331100');
INSERT INTO `siping_county` VALUES ('2845', '331102', '莲都区', '331100');
INSERT INTO `siping_county` VALUES ('2846', '331122', '缙云县', '331100');
INSERT INTO `siping_county` VALUES ('2847', '331123', '遂昌县', '331100');
INSERT INTO `siping_county` VALUES ('2848', '331124', '松阳县', '331100');
INSERT INTO `siping_county` VALUES ('2849', '331125', '云和县', '331100');
INSERT INTO `siping_county` VALUES ('2850', '331126', '庆元县', '331100');
INSERT INTO `siping_county` VALUES ('2851', '331127', '景宁畲族自治县', '331100');
INSERT INTO `siping_county` VALUES ('2852', '331181', '龙泉市', '331100');

-- ----------------------------
-- Table structure for siping_province
-- ----------------------------
DROP TABLE IF EXISTS `siping_province`;
CREATE TABLE `siping_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(6) DEFAULT NULL,
  `province` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='省/自治区/直辖市';

-- ----------------------------
-- Records of siping_province
-- ----------------------------
INSERT INTO `siping_province` VALUES ('1', '340000', '安徽省');
INSERT INTO `siping_province` VALUES ('2', '110000', '北京市');
INSERT INTO `siping_province` VALUES ('3', '500000', '重庆市');
INSERT INTO `siping_province` VALUES ('4', '350000', '福建省');
INSERT INTO `siping_province` VALUES ('5', '620000', '甘肃省');
INSERT INTO `siping_province` VALUES ('6', '440000', '广东省');
INSERT INTO `siping_province` VALUES ('7', '450000', '广西壮族自治区');
INSERT INTO `siping_province` VALUES ('8', '520000', '贵州省');
INSERT INTO `siping_province` VALUES ('9', '460000', '海南省');
INSERT INTO `siping_province` VALUES ('10', '130000', '河北省');
INSERT INTO `siping_province` VALUES ('11', '230000', '黑龙江省');
INSERT INTO `siping_province` VALUES ('12', '410000', '河南省');
INSERT INTO `siping_province` VALUES ('13', '420000', '湖北省');
INSERT INTO `siping_province` VALUES ('14', '430000', '湖南省');
INSERT INTO `siping_province` VALUES ('15', '320000', '江苏省');
INSERT INTO `siping_province` VALUES ('16', '360000', '江西省');
INSERT INTO `siping_province` VALUES ('17', '220000', '吉林省');
INSERT INTO `siping_province` VALUES ('18', '210000', '辽宁省');
INSERT INTO `siping_province` VALUES ('19', '150000', '内蒙古自治区');
INSERT INTO `siping_province` VALUES ('20', '640000', '宁夏回族自治区');
INSERT INTO `siping_province` VALUES ('21', '630000', '青海省');
INSERT INTO `siping_province` VALUES ('22', '370000', '山东省');
INSERT INTO `siping_province` VALUES ('23', '310000', '上海市');
INSERT INTO `siping_province` VALUES ('24', '140000', '山西省');
INSERT INTO `siping_province` VALUES ('25', '610000', '陕西省');
INSERT INTO `siping_province` VALUES ('26', '510000', '四川省');
INSERT INTO `siping_province` VALUES ('27', '120000', '天津市');
INSERT INTO `siping_province` VALUES ('28', '650000', '新疆维吾尔自治区');
INSERT INTO `siping_province` VALUES ('29', '540000', '西藏自治区');
INSERT INTO `siping_province` VALUES ('30', '530000', '云南省');
INSERT INTO `siping_province` VALUES ('31', '330000', '浙江省');

-- ----------------------------
-- Table structure for slide_pic
-- ----------------------------
DROP TABLE IF EXISTS `slide_pic`;
CREATE TABLE `slide_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `pic_path` varchar(30) DEFAULT NULL COMMENT '图片路径',
  `url` varchar(100) DEFAULT NULL COMMENT '链接地址',
  `hover_tips` varchar(30) DEFAULT NULL COMMENT '鼠标悬停提示信息',
  `enabled` bit(1) DEFAULT NULL COMMENT '是否启用，0不启用，1启用',
  `order_no` int(8) DEFAULT NULL COMMENT '序号',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='首页图片轮播';

-- ----------------------------
-- Records of slide_pic
-- ----------------------------
INSERT INTO `slide_pic` VALUES ('13', '14634697947980.jpg', 'https://www.baidu.com/', 'X战警：逆转未来', '\0', null, '2016-05-17 15:22:22', null, '2016-05-20 14:46:22', null);
INSERT INTO `slide_pic` VALUES ('14', '14634697948560.jpg', 'https://www.baidu.com/', '后会无期', '\0', null, '2016-05-17 15:22:22', null, '2016-05-20 14:46:22', null);
INSERT INTO `slide_pic` VALUES ('17', '14634698261820.jpg', 'https://www.baidu.com/', '一个人的武林', '\0', null, '2016-05-17 15:22:54', null, '2016-05-20 14:46:22', null);
INSERT INTO `slide_pic` VALUES ('18', '14634698261870.jpg', 'https://www.baidu.com/', '激浪青春', '\0', null, '2016-05-17 15:22:54', null, '2016-05-20 14:46:22', null);
INSERT INTO `slide_pic` VALUES ('21', '14634703775260.jpg', 'https://www.baidu.com/', '庞贝末日', '\0', null, '2016-05-17 15:32:05', null, '2016-05-20 14:46:22', null);
INSERT INTO `slide_pic` VALUES ('25', '14634716435820.jpg', 'http://www.sipingsoft.com', '绣春刀', '\0', null, '2016-05-17 15:53:11', null, '2016-05-20 17:41:33', null);
INSERT INTO `slide_pic` VALUES ('26', '14635355410730.png', 'http://www.sipingsoft.com', '高新产业园', '', null, '2016-05-18 09:38:06', null, '2016-05-20 16:21:31', null);
INSERT INTO `slide_pic` VALUES ('27', '14635392043790.png', 'http://www.sipingsoft.com', '高新产业园', '', null, '2016-05-18 10:39:20', null, '2016-05-20 16:21:31', null);
INSERT INTO `slide_pic` VALUES ('28', '14635475104980.png', 'http://www.sipingsoft.com', '高新产业园', '', null, '2016-05-18 12:57:34', null, '2016-05-20 16:21:31', null);
INSERT INTO `slide_pic` VALUES ('29', '14635475105200.png', 'http://www.sipingsoft.com', '高新产业园', '', null, '2016-05-18 12:57:34', null, '2016-05-20 16:21:31', null);
INSERT INTO `slide_pic` VALUES ('30', '14635475105380.png', 'http://www.sipingsoft.com', '高新产业园', '', null, '2016-05-18 12:57:34', null, '2016-05-20 16:21:13', null);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `pwd_hash` varchar(128) NOT NULL COMMENT '密码hash',
  `pwd_iterator` int(11) NOT NULL COMMENT '密码Iterator',
  `pwd_salt` varchar(10) NOT NULL COMMENT 'salt',
  `user_type` smallint(1) DEFAULT NULL COMMENT '1 ，单位用户（人社局）；2，企业用户；3，个人用户（求职者）；4，服务机构（入驻企业）',
  `enabled` bit(1) NOT NULL COMMENT '1启用，0 禁用',
  `is_verified` smallint(1) DEFAULT NULL COMMENT '是否审核通过，0未审核，1已通过，2未通过',
  `verified_time` datetime DEFAULT NULL COMMENT '审核时间',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件，可用于激活账户和找回密码',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '12345678-08', 'd24b6ba296688fbe599fe9f20880ce58f0f07c3ce84293e924de64d75e715ad0c49a1b82e99f7383edb376989f201034f0b1e0de5cdcaca1bc232768d2d743a7', '6', 'iliz2u', '2', '', null, null, '', '2016-05-05 15:33:58', null, '2016-05-12 09:50:27', '1');
INSERT INTO `users` VALUES ('2', '12345678-09', 'c9587682d64de008e05429151b804fb3e8539783e120991c93c23266b38ff417eb79e1f4bec6e19913ce3c0c375cc8d3e07050f97a94bdcface9320bb940d67a', '8', 'Ev8f4r', '4', '', null, null, '', '2016-05-05 16:10:32', null, null, null);
INSERT INTO `users` VALUES ('3', '510922190001013831', 'e30c495f3ac214b1c1bdf96983ff4f738fd2e8c848445cbd10c010ade063034655ef924e55b8559f37cd8b0db1b865fe5f41c0fa9aa3b5f88a93e977810648be', '5', 'C1GSGW', '3', '', '0', null, '3@qq.com', '2016-05-05 16:11:59', null, null, null);
INSERT INTO `users` VALUES ('4', '510922190001013830', 'c584642a5b8e20c9592ebe941007687b3dd10cfa451e19f46139b11fdfbc0c65018eae469e445439026d2ff411b768ecb943d8354330adec411eb96cdca85e00', '7', 'iaemQM', '3', '', '0', null, '3@qq.com', '2016-05-05 16:12:14', null, null, null);
INSERT INTO `users` VALUES ('5', '510922190001013834', '5b4a9f5dc5a8e542e5a6c6b5e9eb89714eb384381de8e48ec5085cdccda74e6d27c7bbd22f428ef61d08c2fd0af330a288f7eff19be0e18a6074b3ab1376fd43', '10', 'tMghK3', '3', '', '0', null, '3@qq.com', '2016-05-05 16:12:19', null, null, null);
INSERT INTO `users` VALUES ('6', '510922190001013835', '1f0d28b72f2a872f99a385a1569f1eaa9d38c4f76388d4997f019ac8d6d36643826c64d70669c021c0578e50aef00a22db189c3f2ed4467db748764833534a43', '7', 'I9W3Te', '3', '', '0', null, '3@qq.com', '2016-05-05 16:12:22', null, null, null);
INSERT INTO `users` VALUES ('7', '510922190001013836', '4182cce10f08d15a4d8cbe005172d2ed3527d4d24167b5bec700c650b84391b6fe151702fe12fc827ca06cd6f9d32aee4bbe3d21fcb0ac655f3cba2a6a514d29', '2', 'Ya26EE', '3', '', '0', null, '3@qq.com', '2016-05-05 16:12:25', null, null, null);
INSERT INTO `users` VALUES ('8', '510922190001013837', 'fa513c12df634f91f43f5d4ecc1ea360c5a706e3238a2619761df61a2ee8ef8138c618ee505196b6dc4426182da7d563097858fafe64c78792101d1bd84a4a2f', '3', 'r3ehPl', '3', '', '0', null, '3@qq.com', '2016-05-05 16:12:28', null, null, null);
INSERT INTO `users` VALUES ('9', '510922190001013838', 'a9247f00977d9147b0dfee01e279e4316f41ed429addd223a9837fb7532023fe8dd1d8e9f264de7fa335011a6a8abb2f9eefa02491845f2df0715337f88d0b44', '9', 'd9RpH5', '3', '', '0', null, '3@qq.com', '2016-05-05 16:12:31', null, null, null);
INSERT INTO `users` VALUES ('10', '510922190001013839', '4a3e8dc06c0c183a9dc272f0745340a75b792ab1f78ebaa78143fd4c2853f8c7dc63475eb7af37156723925f69827921a0e9de41bd573f7b1ed4ade29a90109e', '7', 'JrKfRE', '3', '', '0', null, '3@qq.com', '2016-05-05 16:12:33', null, null, null);
INSERT INTO `users` VALUES ('11', '510922190001013841', '49f971250f3e9f656e30df7fa944cd8f64adf8c19e19ab6d229b1889ef03cd76898fd293f0250f563c735bae318c8e823d0e1ba0a19be363b35949d92af8f724', '10', 'UP35Oj', '3', '', '0', null, '3@qq.com', '2016-05-05 16:12:38', null, null, null);
INSERT INTO `users` VALUES ('12', '510922190001013842', '46323ca865f948cf28b2be23198201b19b69b74c324db48dde62835a0125a58ea16fd16e4cfa328d661453f12d10bb75898f93e384ee5117288b481292c93ebb', '6', 'Wn9Hxz', '3', '', '0', null, '3@qq.com', '2016-05-05 16:12:41', null, null, null);
INSERT INTO `users` VALUES ('13', '510922190001013843', '83a6c445eee49d82ff589971bf966be3fc1847ed73834738e63f47cbb7feea0d8ad2ca89711524f9777a37c9bc0de010f7fd2f5fd21659dc066d9e192003167a', '10', '2idQxI', '3', '', '0', null, '3@qq.com', '2016-05-05 16:12:44', null, null, null);
INSERT INTO `users` VALUES ('14', '510922190001013844', '0bc8f180960f819eddf113d97bdc64c720392c441ec217a89bb0746633bfa3691c2ac3c1ea517c9452263719e8f4fdd55b354d448ccad0c598ff3c01f8030829', '2', 'XBvbBY', '3', '', '0', null, '3@qq.com', '2016-05-05 16:12:47', null, null, null);
INSERT INTO `users` VALUES ('15', '510922190001013846', 'c4539d471de0f4d3d6355143ab2d3d54ec800073364a1887b58ea16e33443831f33b37c85da950f5ab7532fb2293727e03dfc4c45c30c082ac0073c7fbe1193e', '5', '3Fromc', '3', '', '0', null, '3@qq.com', '2016-05-05 16:12:50', null, null, null);
INSERT INTO `users` VALUES ('19', 'zzzzzzz', 'cb94e0f1e096199fb3ce975e66ba811206b4facfd1efd7c108f2a196805fefe198dddb60239c00b66b9a057b372713829883f57c44a8d78e436c0155bcc7967f', '1', 'nc6wZY', '1', '', '0', null, '3333333@qq.com', '2016-05-05 17:21:26', null, '2016-05-17 11:11:51', null);
INSERT INTO `users` VALUES ('20', 'zzzzzzzz', '03dc0310972d24b0e0fab41366f4026357740be966cbcd1f2c57f2d3480f1cd987005dec0790576e027200d4838fbc9440d1d5582c5202f6ece40c6567339b0d', '9', '9bJVgl', '1', '', '1', null, null, '2016-05-06 11:16:12', null, null, null);
INSERT INTO `users` VALUES ('21', 'qweqweqw', 'd994e2249cb3fdebc8e99280d1622741fe9c8b2ecc9fd22134fdb8cba2aaa98256ed8aff874ef6e2549d26e178539dae31bcbf94d526515d36640c70c5b2aaf9', '8', 'LD8275', '1', '', '1', null, '33131@qq.com', '2016-05-06 11:39:03', null, '2016-05-06 15:05:23', null);
INSERT INTO `users` VALUES ('22', 'xcvxcvxv', '645976f9c8651a8a383813cbb6da939998f6d232f213e3466dcc334a3ec8fd342eb135832e69ef3cfc2430f3cf82d2999c00b4016a1eda329479b144bf54470b', '7', 'xqdDsb', '1', '', '1', null, '1312@qq.cjom', '2016-05-20 13:29:36', null, null, null);

-- ----------------------------
-- Table structure for user_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `user_enterprise`;
CREATE TABLE `user_enterprise` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `org_code` varchar(30) NOT NULL COMMENT '组织机构代码',
  `registered_no` varchar(30) DEFAULT NULL COMMENT '工商注册号',
  `license_pic` varchar(30) DEFAULT NULL COMMENT '营业执照图片地址',
  `org_name` varchar(50) DEFAULT NULL COMMENT '企业名称',
  `is_hightech` bit(1) DEFAULT NULL COMMENT '是否高新技术企业',
  `org_type_id` int(11) DEFAULT NULL COMMENT '企业类型',
  `industry` varchar(200) DEFAULT NULL COMMENT '主营行业',
  `turnover` double DEFAULT NULL COMMENT '营业额',
  `employees` int(11) DEFAULT NULL COMMENT '雇员人数',
  `legal_person` varchar(20) DEFAULT NULL COMMENT '法人代表',
  `found_date` date DEFAULT NULL COMMENT '企业成立时间',
  `province` int(10) DEFAULT NULL COMMENT '企业所属省',
  `city` int(10) DEFAULT NULL COMMENT '企业所属市',
  `county` int(10) DEFAULT NULL COMMENT '企业所属区',
  `street` varchar(40) DEFAULT NULL COMMENT '企业注册街道地址',
  `org_profile` varchar(400) DEFAULT NULL COMMENT '企业简介',
  `product` varchar(400) DEFAULT NULL COMMENT '产品介绍',
  `business_scope` varchar(80) DEFAULT NULL COMMENT '业务范围',
  `contacts` varchar(15) DEFAULT NULL COMMENT '联系人',
  `telephone` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `postcode` varchar(10) DEFAULT NULL COMMENT '邮编',
  `address` varchar(40) DEFAULT NULL COMMENT '办公地址',
  `website` varchar(30) DEFAULT NULL COMMENT '网址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='入驻企业资料';

-- ----------------------------
-- Records of user_enterprise
-- ----------------------------
INSERT INTO `user_enterprise` VALUES ('1', '12345678-09', '12345678-25', '2131', null, '231', null, '1', '321', '321', '321', null, null, '500000', null, '500102', '123', '321', '', '', '', '', '', '', '', '', '', '2016-05-09 09:40:53', null, null);

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `group_id` int(11) DEFAULT NULL COMMENT '组id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组表，is_delete：0或false表示未删除，1或true表示已删除';

-- ----------------------------
-- Records of user_group
-- ----------------------------

-- ----------------------------
-- Table structure for user_org_info
-- ----------------------------
DROP TABLE IF EXISTS `user_org_info`;
CREATE TABLE `user_org_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `org_code` varchar(30) DEFAULT NULL COMMENT '组织机构代码',
  `registered_no` varchar(30) DEFAULT NULL COMMENT '工商注册号',
  `license_pic` varchar(30) DEFAULT NULL COMMENT '营业执照图片地址',
  `org_name` varchar(50) DEFAULT NULL COMMENT '企业名称',
  `org_type_id` int(11) DEFAULT NULL COMMENT '公司性质',
  `main_industry` varchar(30) DEFAULT NULL COMMENT '公司所属主要行业',
  `secondary_industry` varchar(30) DEFAULT NULL COMMENT '公司所属次要行业',
  `employees` int(11) DEFAULT NULL COMMENT '公司规模,雇员人数',
  `province` int(10) DEFAULT NULL COMMENT '企业所属省',
  `city` int(10) DEFAULT NULL COMMENT '企业所属市',
  `county` int(10) DEFAULT NULL COMMENT '企业所属区',
  `street` varchar(40) DEFAULT NULL COMMENT '企业注册街道地址',
  `org_profile` varchar(400) DEFAULT NULL COMMENT '企业简介',
  `logo_pic` varchar(30) DEFAULT NULL COMMENT '公司logo图片路径',
  `contacts` varchar(15) DEFAULT NULL COMMENT '联系人',
  `telephone` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `cellphone` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `postcode` varchar(10) DEFAULT NULL COMMENT '邮编',
  `address` varchar(40) DEFAULT NULL COMMENT '办公地址',
  `website` varchar(30) DEFAULT NULL COMMENT '网址',
  `hr_contacts` varchar(15) DEFAULT NULL COMMENT '招聘联系人',
  `hr_telephone` varchar(30) DEFAULT NULL COMMENT '招聘联系电话',
  `hr_email` varchar(30) DEFAULT NULL COMMENT '招聘电子邮件',
  `hr_cellphone` varchar(15) DEFAULT NULL COMMENT '招聘手机号码',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='招聘企业用户资料';

-- ----------------------------
-- Records of user_org_info
-- ----------------------------
INSERT INTO `user_org_info` VALUES ('20', '12345678-08', '123456', 'req', '1462523252730.jpg', 'reqe', '0', 'erq', 'er,er,', null, '510000', '510800', '510812', 'req', 'req455', '1462523252741.jpg', 'erqree', '', ',,,,,,,', '', '', null, '', '', '', '', null, '', '2016-05-06 16:27:31', '2016-05-19 14:12:21', null);

-- ----------------------------
-- Table structure for user_personal_info
-- ----------------------------
DROP TABLE IF EXISTS `user_personal_info`;
CREATE TABLE `user_personal_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `nationality` varchar(30) DEFAULT NULL COMMENT '国籍',
  `nickname` varchar(15) DEFAULT NULL COMMENT '昵称',
  `realname` varchar(15) DEFAULT NULL COMMENT '真实姓名',
  `foreign_name` varchar(25) DEFAULT NULL COMMENT '外文名字',
  `birthplace` varchar(30) DEFAULT NULL COMMENT '出生地',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `province` int(10) DEFAULT NULL COMMENT '所在省',
  `city` int(10) DEFAULT NULL COMMENT '所在市',
  `county` int(10) DEFAULT NULL COMMENT '所在区',
  `address` varchar(40) DEFAULT NULL COMMENT '所在街道详细地址',
  `sex` bit(1) DEFAULT NULL COMMENT '性别，0女，1男',
  `nation` varchar(10) DEFAULT NULL COMMENT '民族',
  `politics_status` varchar(10) DEFAULT NULL COMMENT '政治面貌',
  `marital_status` varchar(10) DEFAULT NULL COMMENT '婚姻状况',
  `telephone` varchar(30) DEFAULT NULL COMMENT '办公电话',
  `cellphone` varchar(30) DEFAULT NULL COMMENT '手机',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `website` varchar(30) DEFAULT NULL COMMENT '个人网址/博客',
  `start_work_year` int(4) DEFAULT NULL COMMENT '参加工作年份',
  `resident_city` int(10) DEFAULT NULL COMMENT '户口所在城市',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='个人用户资料';

-- ----------------------------
-- Records of user_personal_info
-- ----------------------------
INSERT INTO `user_personal_info` VALUES ('1', '510922190001013831', '中国sadfasf', 'asdfasds5', 'werwedsf2323', 'tomasdfasf', 'ksdfasdf', '1980-05-10', '520000', '520600', '520622', '测试街道测试小区', '\0', '怒族', '民建会员', '未婚', '18823285479', '12356898565', '026-45643333654', '3@qq.com', 'baidu.comsdfasdf', '1999', '340500', '2016-05-06 11:01:01', '2016-05-10 11:03:52', null);
INSERT INTO `user_personal_info` VALUES ('2', '510922190001013830', '意大利', 'dfsadf', 'dsafasdf', 'Jamessdfs', '是打发', '2016-05-24', '520000', '522300', '522323', 'asdfasdf', '\0', '仡佬族', '民革党员', '已婚', '18838385479', '12356456555', '2323323', '3@qq.com', 'google.com', '2001', '220700', '2016-05-06 16:34:38', '2016-05-09 11:26:05', null);
