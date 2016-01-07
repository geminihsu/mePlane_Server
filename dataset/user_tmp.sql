-- phpMyAdmin SQL Dump
-- version 2.9.0.2
-- http://www.phpmyadmin.net
-- 
-- 主機: localhost
-- 建立日期: Dec 21, 2009, 02:04 PM
-- 伺服器版本: 5.0.24
-- PHP 版本: 5.1.6
-- 
-- 資料庫: `android`
-- 

-- --------------------------------------------------------

-- 
-- 資料表格式： `user_tmp`
-- 

CREATE TABLE `user_tmp` (
  `u_id` varchar(255) default NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) default NULL,
  `age` varchar(255) default NULL,
  `gender` varchar(255) default NULL,
  `favor_artist` varchar(255) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 列出以下資料庫的數據： `user_tmp`
-- 

INSERT INTO `user_tmp` VALUES ('1', 'gemini', '612', '20-25', 'Female', NULL);
INSERT INTO `user_tmp` VALUES ('2', 'geminihome', '612', '20-25', 'Female', NULL);
INSERT INTO `user_tmp` VALUES ('3', 'geminimusic', '612', '15-20', 'Female', NULL);
INSERT INTO `user_tmp` VALUES ('4', 'aa', '612', '20-25', 'Female', 'Aqua');
INSERT INTO `user_tmp` VALUES ('5', 'abc', '612', '>40', 'Female', '江蕙');
INSERT INTO `user_tmp` VALUES ('6', 'terence', '612', '20-25', 'Female', '方大同');
INSERT INTO `user_tmp` VALUES ('7', 'bb', '612', '20-25', 'Female', '江蕙');
INSERT INTO `user_tmp` VALUES ('8', 'pp', '612', '20-25', 'Female', 'Aqua');
INSERT INTO `user_tmp` VALUES ('9', 'richel', '612', '20-25', 'Female', '王若琳');
INSERT INTO `user_tmp` VALUES ('10', 'oo', '612', '20-25', 'Female', '瑪丹娜');
