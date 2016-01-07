-- phpMyAdmin SQL Dump
-- version 2.9.0.2
-- http://www.phpmyadmin.net
-- 
-- 主機: localhost
-- 建立日期: Dec 21, 2009, 02:09 PM
-- 伺服器版本: 5.0.24
-- PHP 版本: 5.1.6
-- 
-- 資料庫: `android`
-- 

-- --------------------------------------------------------

-- 
-- 資料表格式： `group_00_class`
-- 

CREATE TABLE `group_00_class` (
  `song_id` int(11) default NULL,
  `Song_title` varchar(255) default NULL,
  `count` int(11) default NULL,
  `percent` double default NULL,
  `class` int(11) default NULL,
  `valence` int(11) default NULL,
  `arousal` int(11) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 列出以下資料庫的數據： `group_00_class`
-- 

