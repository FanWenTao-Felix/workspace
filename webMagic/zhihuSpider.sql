/*
Navicat MySQL Data Transfer

Source Server         : localuser
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : zhihuspider

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-10-22 13:41:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_base_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_base_info`;
CREATE TABLE `user_base_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pageUrl` varchar(200) NOT NULL COMMENT '抓取页URL',
  `nickname` varchar(60) NOT NULL DEFAULT '' COMMENT '用户名',
  `location` varchar(32) DEFAULT NULL COMMENT '居住地',
  `weiboUrl` varchar(248) DEFAULT NULL COMMENT '微博地址',
  `headline` varchar(248) DEFAULT NULL COMMENT '一句话介绍',
  `description` text COMMENT '个人简介',
  `followees` int(11) DEFAULT '0' COMMENT '关注了',
  `followers` int(11) DEFAULT '0' COMMENT '关注者',
  `columns` int(11) DEFAULT '0' COMMENT '关注专栏',
  `topics` int(11) DEFAULT '0' COMMENT '关注话题',
  `pageViews` int(11) DEFAULT '0' COMMENT '主页被多少人浏览',
  `questions` int(11) DEFAULT '0' COMMENT '提问',
  `answers` int(11) DEFAULT '0' COMMENT '回答',
  `articles` int(11) DEFAULT '0' COMMENT '专栏文章',
  `collections` int(11) DEFAULT '0' COMMENT '收藏了',
  `edits` int(11) DEFAULT '0' COMMENT '公共编辑',
  `agreeNums` int(11) DEFAULT '0' COMMENT '赞同',
  `thanksNums` int(11) DEFAULT '0' COMMENT '感谢',
  `lastDynamic` varchar(20) DEFAULT NULL COMMENT '最近动态(未处理)',
  `lastDynamicTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最近动态(处理后)',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `pageUrl` (`pageUrl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_base_info
-- ----------------------------

-- ----------------------------
-- Table structure for `user_detail_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_detail_info`;
CREATE TABLE `user_detail_info` (
  `detail_user_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pageUrl` varchar(200) NOT NULL COMMENT '抓取页URL',
  `nickname` varchar(60) NOT NULL DEFAULT '' COMMENT '用户名',
  `gender` varchar(32) DEFAULT NULL COMMENT '性别',
  `status` varchar(248) DEFAULT NULL COMMENT '状态',
  `business` varchar(32) DEFAULT NULL COMMENT '所在行业',
  `employment` varchar(32) DEFAULT NULL COMMENT '公司或组织名称',
  `position` varchar(32) DEFAULT NULL COMMENT '职位',
  `education` varchar(32) DEFAULT NULL COMMENT '学校或教育机构名',
  `educationExtra` varchar(11) DEFAULT NULL COMMENT '专业方向',
  `collecters` int(11) DEFAULT '0' COMMENT '收藏者',
  `shares` int(11) DEFAULT '0' COMMENT '分享',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`detail_user_id`),
  UNIQUE KEY `pageUrl` (`pageUrl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_detail_info
-- ----------------------------
