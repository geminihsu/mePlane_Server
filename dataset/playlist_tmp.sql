-- phpMyAdmin SQL Dump
-- version 2.9.0.2
-- http://www.phpmyadmin.net
-- 
-- 主機: localhost
-- 建立日期: Dec 21, 2009, 02:06 PM
-- 伺服器版本: 5.0.24
-- PHP 版本: 5.1.6
-- 
-- 資料庫: `android`
-- 

-- --------------------------------------------------------

-- 
-- 資料表格式： `playlist_tmp`
-- 

CREATE TABLE `playlist_tmp` (
  `u_id` varchar(255) default NULL,
  `Year` varchar(255) default NULL,
  `Month` varchar(255) default NULL,
  `Date` varchar(255) default NULL,
  `Hour` varchar(255) default NULL,
  `Minute` varchar(255) default NULL,
  `Latitude` varchar(255) default NULL,
  `Longitude` varchar(255) default NULL,
  `label` varchar(255) default NULL,
  `Song_id` varchar(255) default NULL,
  `Song_artist` varchar(255) default NULL,
  `Song_title` varchar(255) default NULL,
  `Song_artist_ch` varchar(255) default NULL,
  `Song_title_ch` varchar(255) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 列出以下資料庫的數據： `playlist_tmp`
-- 

INSERT INTO `playlist_tmp` VALUES ('2', '2009', '10', '20', '16', '22', '0.02300199999999819', '0.4679970000000111', '8', '87', 'Tanya', 'Tanya_j', '蔡健雅', 'Only Love');
INSERT INTO `playlist_tmp` VALUES ('1', '2009', '10', '13', '8', '25', '0.03629382000000092', '0.43560970000001475', '8', '2', 'Aqua', 'Back_To_The_80', '水叮噹', 'Back To The 80');
INSERT INTO `playlist_tmp` VALUES ('1', '2009', '10', '18', '11', '45', '0.036966999999997086', '0.4331189999999907', '8', '102', 'lady_gaga', 'Paparazzi', '女神卡卡', 'Paparazzi');
INSERT INTO `playlist_tmp` VALUES ('8', '2009', '11', '13', '11', '50', '0.03706577500000208', '0.43649557499999503', '9', '624', 'christine_fan', 'christine_fan_f', '范瑋琪', '不要哭');
INSERT INTO `playlist_tmp` VALUES ('2', '2009', '10', '13', '8', '45', '0.02300199999999819', '0.4679970000000111', '8', '65', 'Utada', 'Taking_My_Money_Back', '宇多田光', 'Taking My Money Back');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '14', '24', '35', '0.02300199999999819', '0.4679970000000111', '8', '44', 'Jolin', 'girl', '蔡依林', '許願池的希臘少女');
INSERT INTO `playlist_tmp` VALUES ('2', '2009', '10', '13', '17', '5', '0.036966999999997086', '0.4331189999999907', '4', '62', 'Utada', 'FYI', '宇多田光', 'FYI');
INSERT INTO `playlist_tmp` VALUES ('2', '2009', '10', '13', '17', '10', '0.036966999999997086', '0.4331189999999907', '2', '55', 'linkin_park', 'New_Divide', '聯合公園', 'New_Divide');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '30', '19', '26', '0.036885599999997964', '0.43501598000000286', '2', '250', 'Joanna', 'Joanna_b', '王若琳', '有你的快樂');
INSERT INTO `playlist_tmp` VALUES ('2', '2009', '10', '13', '19', '40', '0.02300199999999819', '0.4679970000000111', '8', '89', 'Doraemon', 'Doraemon_b', '丁噹', '花火 vs.五月天阿信');
INSERT INTO `playlist_tmp` VALUES ('2', '2009', '10', '13', '20', '18', '0.04173899999999975', '0.5163849999999854', '8', '91', 'lady_gaga', 'Poker_Face', '女神卡卡', 'Poker Face');
INSERT INTO `playlist_tmp` VALUES ('2', '2009', '10', '13', '20', '58', '0.036966999999997086', '0.4331189999999907', '8', '74', 'Eason', 'Eason_h', '陳奕迅', '心的距離');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '30', '19', '27', '0.036885599999997964', '0.43501598000000286', '2', '250', 'Joanna', 'Joanna_b', '王若琳', '有你的快樂');
INSERT INTO `playlist_tmp` VALUES ('1', '2009', '10', '13', '01', '55', '0.04173899999999975', '0.5163849999999854', '8', '67', 'Eason', 'Eason_a', '陳奕迅', '在你身邊');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '30', '19', '27', '0.036885599999997964', '0.43501598000000286', '2', '250', 'Joanna', 'Joanna_b', '王若琳', '有你的快樂');
INSERT INTO `playlist_tmp` VALUES ('1', '2009', '10', '13', '02', '1', '0.04173899999999975', '0.5163849999999854', '8', '62', 'Utada', 'FYI', '宇多田光', 'FYI');
INSERT INTO `playlist_tmp` VALUES ('8', '2009', '11', '8', '17', '43', '0.02300199999999819', '0.4679970000000111', '9', '263', 'she', 'she_c', 'S.H.E', '沿海公路的出口');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '14', '24', '19', '0.036966999999997086', '0.4331189999999907', '8', '55', 'linkin_park', 'New_Divide', '聯合公園', 'New_Divide');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '15', '18', '10', '0.02300199999999819', '0.4679970000000111', '3', '102', 'lady_gaga', 'Paparazzi', '女神卡卡', 'Paparazzi');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '15', '18', '26', '0.02300199999999819', '0.4679970000000111', '3', '91', 'khalil_fong', 'Nothing_is_Gonna_Change_My_Love_For_You', '方大同', 'Nothing is Gonna Change My Love For You');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '14', '23', '44', '0.036966999999997086', '0.4331189999999907', '8', '89', 'Doraemon', 'Doraemon_b', '丁噹', '花火 vs.五月天阿信');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '14', '23', '19', '0.036966999999997086', '0.4331189999999907', '8', '89', 'Doraemon', 'Doraemon_b', '丁噹', '花火 vs.五月天阿信');
INSERT INTO `playlist_tmp` VALUES ('2', '2009', '10', '15', '16', '42', '0.02300199999999819', '0.4679970000000111', '8', '135', 'Angela', 'Angela_c', '張韶涵', '看得最遠的地方');
INSERT INTO `playlist_tmp` VALUES ('2', '2009', '10', '15', '14', '52', '0.02300199999999819', '0.4679970000000111', '4', '65', 'Utada', 'Taking_My_Money_Back', '宇多田光', 'Taking My Money Back');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '14', '24', '30', '0.02300199999999819', '0.4679970000000111', '8', '85', 'Tanya', 'Tanya_h', '蔡健雅', '若你碰到他');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '14', '00', '59', '0.02300199999999819', '0.4679970000000111', '8', '27', 'fergie', 'Finally', '菲姬', 'Finally');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '14', '04', '31', '0.036966999999997086', '0.4331189999999907', '8', '119', 'Taylor_Swift', 'Love_Story', '泰勒絲', 'Love Story');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '26', '00', '44', '0.036966999999997086', '0.4331189999999907', '9', '196', 'hikaru_utada', 'HEART_STATION', '宇多田光', 'HEART STATION');
INSERT INTO `playlist_tmp` VALUES ('1', '2009', '10', '15', '11', '17', '0.036966999999997086', '0.4331189999999907', '8', '103', 'lady_gaga', 'Poker_Face', '女神卡卡', 'Poker Face');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '16', '20', '26', '0.02300199999999819', '0.4679970000000111', '8', '135', 'Angela', 'Angela_c', '張韶涵', '看得最遠的地方');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '16', '02', '43', '0.036966999999997086', '0.4331189999999907', '8', '76', 'Eason', 'Eason_j', '陳奕迅', '給你');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '16', '02', '54', '0.036966999999997086', '0.4331189999999907', '8', '103', 'lady_gaga', 'Poker_Face', '女神卡卡', 'Poker Face');
INSERT INTO `playlist_tmp` VALUES ('2', '2009', '10', '18', '10', '19', '0.036966999999997086', '0.4331189999999907', '8', '76', 'Eason', 'Eason_j', '陳奕迅', '給你');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '26', '00', '46', '0.036966999999997086', '0.4331189999999907', '9', '196', 'hikaru_utada', 'HEART_STATION', '宇多田光', 'HEART STATION');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '26', '00', '56', '0.036966999999997086', '0.4331189999999907', '9', '268', 'tanya_chua', 'tanya_chua_a', '蔡健雅', '思念');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '26', '01', '3', '0.036966999999997086', '0.4331189999999907', '9', '207', 'Madonna', '4_Minutes', '瑪丹娜', '四分鐘');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '26', '01', '42', '0.036966999999997086', '0.4331189999999907', '9', '214', 'Sodagreen', 'Sodagreen_a', '蘇打綠', '陪我唱歌');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '27', '01', '54', '0.02300199999999819', '0.4679970000000111', '9', '292', 'she', 'she_g', 'S.H.E', '612星球');
INSERT INTO `playlist_tmp` VALUES ('2', '2009', '10', '27', '19', '4', '0.036966999999997086', '0.4331189999999907', '9', '228', 'nan_quan_ma_ma', 'nan_quan_ma_ma_a', '南拳媽媽', '下雨天');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '29', '17', '26', '0.04173899999999975', '0.5163849999999854', '9', '268', 'tanya_chua', 'tanya_chua_a', '蔡健雅', '思念');
INSERT INTO `playlist_tmp` VALUES ('1', '2009', '10', '30', '16', '60', '0.036885599999997964', '0.43501598000000286', '4', '2', 'Aqua', 'Back_To_The_80', '水叮噹', 'Back To The 80');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '29', '17', '40', '0.04173899999999975', '0.5163849999999854', '9', '173', 'love', 'love_a', '元若藍', '99次我愛他');
INSERT INTO `playlist_tmp` VALUES ('1', '2009', '10', '30', '00', '34', '0.03629382000000092', '0.43560970000001475', '9', '8', 'backstreet_boys', 'Bigger', '新好男孩', '寬廣的心');
INSERT INTO `playlist_tmp` VALUES ('1', '2009', '10', '30', '00', '34', '0.03629382000000092', '0.43560970000001475', '9', '8', 'backstreet_boys', 'Bigger', '新好男孩', '寬廣的心');
INSERT INTO `playlist_tmp` VALUES ('8', '2009', '11', '8', '17', '44', '0.02300199999999819', '0.4679970000000111', '9', '263', 'she', 'she_c', 'S.H.E', '沿海公路的出口');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '30', '19', '33', '0.03617003333333457', '0.4348681666666607', '9', '682', 'nan_quan_ma_ma', 'What_Can_I_Do', '南拳媽媽', 'What Can  I Do');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '30', '19', '33', '0.03617003333333457', '0.4348681666666607', '9', '682', 'nan_quan_ma_ma', 'What_Can_I_Do', '南拳媽媽', 'What Can  I Do');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '30', '19', '35', '0.03617003333333102', '0.43486816666667494', '2', '268', 'tanya_chua', 'tanya_chua_a', '蔡健雅', '思念');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '30', '19', '40', '0.03617003333333457', '0.4348681666666607', '9', '683', 'nan_quan_ma_ma', 'Tonight', '南拳媽媽', 'Tonight');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '11', '3', '16', '37', '0.03523775000000029', '0.43371580000000165', '4', '196', 'hikaru_utada', 'HEART_STATION', '宇多田光', 'HEART STATION');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '11', '10', '12', '52', '0.036966999999997086', '0.4331189999999907', '9', '42', 'Joanna', 'Weve_Only_Just_Begun', '王若琳', 'Weve Only Just Begun');
INSERT INTO `playlist_tmp` VALUES ('6', '2009', '11', '10', '12', '51', '0.02300199999999819', '0.4679970000000111', '9', '92', 'khalil_fong', 'Bad', '方大同', 'Bad');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '30', '20', '17', '0.03415983999999739', '0.43337596000000644', '9', '240', 'christine_fan', 'christine_fan_a', '范瑋琪', '一顆心的距離');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '30', '20', '17', '0.03415983999999739', '0.43337596000000644', '9', '240', 'christine_fan', 'christine_fan_a', '范瑋琪', '一顆心的距離');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '30', '22', '39', '0.03763327499999747', '0.43530412500001603', '9', '79', 'Tanya', 'Tanya_b', '蔡健雅', '誰');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '30', '22', '40', '0.03763327499999747', '0.43530412500001603', '9', '79', 'Tanya', 'Tanya_b', '蔡健雅', '誰');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '30', '22', '40', '0.03763327499999747', '0.43530412500001603', '9', '79', 'Tanya', 'Tanya_b', '蔡健雅', '誰');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '10', '31', '07', '55', '0.03629381666666376', '0.43560969999998633', '9', '228', 'nan_quan_ma_ma', 'nan_quan_ma_ma_a', '南拳媽媽', '下雨天');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '31', '16', '0', '0.03763327500000102', '0.43530412500001603', '9', '679', 'nan_quan_ma_ma', 'nan_quan_ma_ma_i', '南拳媽媽', '牡丹江');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '10', '31', '16', '0', '0.03763327500000102', '0.43530412500001603', '9', '679', 'nan_quan_ma_ma', 'nan_quan_ma_ma_i', '南拳媽媽', '牡丹江');
INSERT INTO `playlist_tmp` VALUES ('5', '2009', '10', '31', '16', '28', '0.03629381666666376', '0.43560969999998633', '9', '1003', 'mom', 'mom_1', '方瑞娥', '情人港');
INSERT INTO `playlist_tmp` VALUES ('6', '2009', '11', '1', '16', '4', '0.034965800000001934', '0.43251195000000564', '7', '240', 'christine_fan', 'christine_fan_a', '范瑋琪', '一顆心的距離');
INSERT INTO `playlist_tmp` VALUES ('6', '2009', '11', '1', '16', '4', '0.034965800000001934', '0.43251195000000564', '7', '240', 'christine_fan', 'christine_fan_a', '范瑋琪', '一顆心的距離');
INSERT INTO `playlist_tmp` VALUES ('6', '2009', '11', '1', '16', '5', '0.034965800000001934', '0.43251195000000564', '7', '240', 'christine_fan', 'christine_fan_a', '范瑋琪', '一顆心的距離');
INSERT INTO `playlist_tmp` VALUES ('8', '2009', '11', '8', '18', '7', '0.02300199999999819', '0.4679970000000111', '9', '247', 'she', 'she_b', 'S.H.E', '宇宙小姐');
INSERT INTO `playlist_tmp` VALUES ('6', '2009', '11', '8', '18', '7', '0.036966999999997086', '0.4331189999999907', '9', '250', 'Joanna', 'Joanna_b', '王若琳', '有你的快樂');
INSERT INTO `playlist_tmp` VALUES ('6', '2009', '11', '8', '17', '20', '0.036966999999997086', '0.4331189999999907', '9', '89', 'Madonna', 'Celebration', '瑪丹娜', 'Celebration');
INSERT INTO `playlist_tmp` VALUES ('6', '2009', '11', '8', '17', '36', '0.036966999999997086', '0.4331189999999907', '9', '93', 'khalil_fong', 'khalil_fong_a', '方大同', '狂潮');
INSERT INTO `playlist_tmp` VALUES ('3', '2009', '11', '3', '16', '37', '0.03523775000000029', '0.43371580000000165', '4', '196', 'hikaru_utada', 'HEART_STATION', '宇多田光', 'HEART STATION');
INSERT INTO `playlist_tmp` VALUES ('8', '2009', '11', '8', '17', '51', '0.02300199999999819', '0.4679970000000111', '9', '4', 'Aqua', 'Doctor_Jones', '水叮噹', 'Doctor Jones');
INSERT INTO `playlist_tmp` VALUES ('6', '2009', '11', '8', '17', '54', '0.036966999999997086', '0.4331189999999907', '9', '682', 'nan_quan_ma_ma', 'What_Can_I_Do', '南拳媽媽', 'What Can  I Do');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '11', '8', '18', '57', '0.036966999999997086', '0.4331189999999907', '9', '233', 'Eason', 'Eason_a_b', '陳奕迅', '然後怎樣');
INSERT INTO `playlist_tmp` VALUES ('6', '2009', '11', '10', '12', '51', '0.02300199999999819', '0.4679970000000111', '9', '92', 'khalil_fong', 'Bad', '方大同', 'Bad');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '11', '13', '15', '14', '0.03706577500000208', '0.43649557499999503', '9', '314', 'Joanna', 'Joanna_d', '王若琳', '因為你愛我');
INSERT INTO `playlist_tmp` VALUES ('4', '2009', '11', '13', '15', '15', '0.03706577500000208', '0.43649557499999503', '9', '314', 'Joanna', 'Joanna_d', '王若琳', '因為你愛我');
INSERT INTO `playlist_tmp` VALUES ('9', '2009', '11', '13', '15', '45', '0.03706577500000208', '0.43649557499999503', '4', '314', 'Joanna', 'Joanna_d', '王若琳', '因為你愛我');
INSERT INTO `playlist_tmp` VALUES ('9', '2009', '11', '13', '15', '45', '0.03706577500000208', '0.43649557499999503', '4', '314', 'Joanna', 'Joanna_d', '王若琳', '因為你愛我');
INSERT INTO `playlist_tmp` VALUES ('10', '2009', '11', '13', '16', '51', '0.034225500000001574', '0.43411850000001095', '7', '620', 'christine_fan', 'christine_fan_b', '范瑋琪', '一個像夏天一個像秋天');
INSERT INTO `playlist_tmp` VALUES ('10', '2009', '11', '17', '13', '32', '0.03865300000000005', '0.43038400000000365', '2', '142', 'Angela', 'Angela_j', '張韶涵', '白白的');
INSERT INTO `playlist_tmp` VALUES ('1', '2009', '11', '18', '14', '40', '0.03865300000000005', '0.43038400000000365', '9', '1099', 'norah_jones', 'Dont_Know_Why', '諾拉瓊絲', 'Dont Know Why');
