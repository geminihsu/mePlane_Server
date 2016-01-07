-- phpMyAdmin SQL Dump
-- version 2.9.0.2
-- http://www.phpmyadmin.net
-- 
-- 主機: localhost
-- 建立日期: Dec 21, 2009, 02:08 PM
-- 伺服器版本: 5.0.24
-- PHP 版本: 5.1.6
-- 
-- 資料庫: `android`
-- 

-- --------------------------------------------------------

-- 
-- 資料表格式： `emotion_01`
-- 

CREATE TABLE `emotion_01` (
  `song_id` varchar(255) default NULL,
  `Song_title` varchar(255) default NULL,
  `Valence` varchar(255) default NULL,
  `Arousal` varchar(255) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 列出以下資料庫的數據： `emotion_01`
-- 

