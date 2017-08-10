/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : personalblog

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2017-08-10 12:57:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `AnnouncementId` int(11) NOT NULL DEFAULT '0',
  `creatorId` int(11) DEFAULT NULL COMMENT '公告发布者id  fk',
  `Content` varchar(200) DEFAULT NULL COMMENT '公告内容		fk',
  `CreateDate` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`AnnouncementId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发公告，用于管理员发布在网站上';

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `BlogId` int(11) NOT NULL,
  `creatorId` int(11) DEFAULT NULL COMMENT '作者ID fk',
  `SectionId` int(11) DEFAULT NULL COMMENT '版块ID fk',
  `BlogContentId` int(11) DEFAULT NULL COMMENT '内容ID fk',
  `BlogNewLivenessId` int(11) DEFAULT NULL COMMENT '博客最新动态  fk',
  `CreateDate` date DEFAULT NULL COMMENT '创建时间',
  `ReleaseDate` date DEFAULT NULL COMMENT '发布时间',
  `Visiable` int(11) DEFAULT NULL COMMENT '设置博客是否可见 0 私密 1 公开',
  `DynamicNotice` int(11) DEFAULT NULL COMMENT '设置动态提醒0 关闭 1 开启',
  `CommentApprove` int(11) DEFAULT NULL COMMENT '是否开启评论审核 0 关闭 1 开启',
  `DraftContent` int(2) DEFAULT NULL,
  `checkArticle` int(2) DEFAULT NULL,
  PRIMARY KEY (`BlogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客表';

-- ----------------------------
-- Table structure for blogcomment
-- ----------------------------
DROP TABLE IF EXISTS `blogcomment`;
CREATE TABLE `blogcomment` (
  `CommentId` int(11) NOT NULL AUTO_INCREMENT,
  `BlogId` int(11) DEFAULT NULL COMMENT '博客ID pk',
  `RefCommentId` int(11) DEFAULT NULL COMMENT '回复的评论ID',
  `CreatorId` int(11) DEFAULT NULL COMMENT '评论者',
  `CreateDate` date DEFAULT NULL COMMENT '评论时间',
  `CommentContent` varchar(50) DEFAULT NULL COMMENT '评论内容',
  `DynamicNotice` int(11) DEFAULT NULL COMMENT '设置动态提醒0 关闭 1 开启',
  `state` int(11) DEFAULT NULL COMMENT '审核状态 0.待审核 1.通过 2.未通过',
  PRIMARY KEY (`CommentId`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='博客评论表';

-- ----------------------------
-- Table structure for blogcontent
-- ----------------------------
DROP TABLE IF EXISTS `blogcontent`;
CREATE TABLE `blogcontent` (
  `BlogContentId` int(11) NOT NULL,
  `Title` varchar(50) DEFAULT NULL COMMENT '博客标题',
  `Abstrac` varchar(100) DEFAULT NULL,
  `Content` varchar(20000) DEFAULT NULL,
  `DraftContent` int(2) DEFAULT NULL,
  `checkArticle` int(2) DEFAULT NULL,
  PRIMARY KEY (`BlogContentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客内容表';

-- ----------------------------
-- Table structure for bloglabel
-- ----------------------------
DROP TABLE IF EXISTS `bloglabel`;
CREATE TABLE `bloglabel` (
  `BlogLabelId` int(11) NOT NULL AUTO_INCREMENT,
  `BlogId` int(11) DEFAULT NULL COMMENT '博客ID fk',
  `LabelId` int(11) DEFAULT NULL COMMENT '标签ID fk',
  PRIMARY KEY (`BlogLabelId`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COMMENT='博客标签关系表';

-- ----------------------------
-- Table structure for blogliveness
-- ----------------------------
DROP TABLE IF EXISTS `blogliveness`;
CREATE TABLE `blogliveness` (
  `BlogLivenessId` int(11) NOT NULL DEFAULT '0',
  `ReceiveGoods` int(11) DEFAULT NULL COMMENT '获取的点赞总数',
  `ReceiveComments` int(11) DEFAULT NULL COMMENT '获取的评论总数',
  `ReceiveClickRate` int(11) DEFAULT NULL COMMENT '获取的点击总数',
  `ReceiveBads` int(11) DEFAULT NULL COMMENT '获取的踩数',
  `TimeQuantum` date DEFAULT NULL COMMENT '时间段，一月一次统计',
  `BlogId` int(11) DEFAULT NULL COMMENT '博客id fk',
  PRIMARY KEY (`BlogLivenessId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客动态表';

-- ----------------------------
-- Table structure for blognewliveness
-- ----------------------------
DROP TABLE IF EXISTS `blognewliveness`;
CREATE TABLE `blognewliveness` (
  `BlogNewLivenessId` int(11) NOT NULL DEFAULT '0',
  `NewGoods` int(11) DEFAULT NULL COMMENT '新增的点赞数',
  `NewComments` int(11) DEFAULT NULL COMMENT '新增的评论数',
  `NewBads` int(11) DEFAULT NULL COMMENT '新增的踩数',
  `NewClickRate` int(11) DEFAULT NULL COMMENT '新增的点击数',
  PRIMARY KEY (`BlogNewLivenessId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客最新动态表，后期交由redis存储';

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `LabelId` int(11) NOT NULL AUTO_INCREMENT,
  `creatorId` int(11) DEFAULT NULL COMMENT '创建者ID',
  `LabelName` varchar(20) DEFAULT NULL COMMENT '标签名',
  PRIMARY KEY (`LabelId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `MessageId` int(11) NOT NULL DEFAULT '0',
  `SenderId` int(11) DEFAULT NULL COMMENT '发送者id fk',
  `ReceiverId` int(11) DEFAULT NULL COMMENT '接受者id fk',
  `Content` varchar(200) DEFAULT NULL COMMENT '消息主题内容',
  `CreateDate` date DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`MessageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用于管理员和用户之间互相通信';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(20) NOT NULL DEFAULT '0',
  `rolename` varchar(30) DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for roleright
-- ----------------------------
DROP TABLE IF EXISTS `roleright`;
CREATE TABLE `roleright` (
  `id` int(20) NOT NULL DEFAULT '0',
  `rightcode` varchar(20) DEFAULT NULL COMMENT '权限ID',
  `role1id` int(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Table structure for section
-- ----------------------------
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `SectionId` int(11) NOT NULL AUTO_INCREMENT,
  `SectionName` varchar(20) DEFAULT NULL COMMENT '版块名',
  `Visiable` int(11) DEFAULT NULL COMMENT '是否可见',
  `keyWord` varchar(20) DEFAULT NULL COMMENT '关键字',
  `description` varchar(20) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`SectionId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='版块';

-- ----------------------------
-- Table structure for tright
-- ----------------------------
DROP TABLE IF EXISTS `tright`;
CREATE TABLE `tright` (
  `tightid` varchar(20) NOT NULL DEFAULT '',
  `rightparentcode` varchar(20) DEFAULT NULL COMMENT '父节点id',
  `righttitle` varchar(20) DEFAULT NULL COMMENT '权限名称',
  `righturl` varchar(50) DEFAULT NULL COMMENT '权限对应的action url',
  PRIMARY KEY (`tightid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `accountEmail` varchar(20) DEFAULT NULL COMMENT '用户邮箱',
  `accountTel` varchar(20) DEFAULT NULL COMMENT '用户手机号',
  `nickName` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(40) DEFAULT NULL COMMENT '用户密码',
  `state` int(11) DEFAULT NULL COMMENT '用户状态 0 禁言 1 启用',
  `headPortrait` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `rate` int(11) DEFAULT NULL COMMENT '用户积分',
  `roleId` int(11) DEFAULT NULL COMMENT '用户角色',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for userlabel
-- ----------------------------
DROP TABLE IF EXISTS `userlabel`;
CREATE TABLE `userlabel` (
  `UserLabelId` int(11) NOT NULL AUTO_INCREMENT,
  `CreatorId` int(11) DEFAULT NULL COMMENT '创建者id fk',
  `LabelId` int(11) DEFAULT NULL COMMENT '标签id fk',
  PRIMARY KEY (`UserLabelId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='用户创建标签表';
