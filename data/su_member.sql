/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.28 : Database - wulidb
*********************************************************************
*/

SET NAMES utf8;

SET SQL_MODE='';

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 ;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' ;
SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 ;
-- CREATE DATABASE `wulidb`  DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci  DEFAULT ENCRYPTION='N' ;

USE `wulidb`;

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `UId` int NOT NULL DEFAULT '1',
  `Name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Gender` tinyint(1) NOT NULL,
  `Phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Idnumber` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '身分證',
  `Mail` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `County` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `District` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `State` tinyint NOT NULL DEFAULT '1' COMMENT '1是表是目前帳號狀態:開通\n0表示表示未開通\n\n留著做以後,若是註冊時需要驗證信箱用,如果這樣的default要改成0',
  `Code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '驗證時的密碼',
  `School` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Pic` int NOT NULL,
  `Signature_1` int DEFAULT NULL,
  `Signature_2` int DEFAULT NULL,
  `Signature_3` int DEFAULT NULL,
  `Favor_1` int DEFAULT NULL,
  `Favor_2` int DEFAULT NULL,
  `Favor_3` int DEFAULT NULL,
  `Pair_1` int DEFAULT NULL,
  `Pair_2` int DEFAULT NULL,
  `Pair_3` int DEFAULT NULL,
  `Pair_4` int DEFAULT NULL,
  `Pair_5` int DEFAULT NULL,
  `Open_Tag` tinyint DEFAULT '0',
  `CREATE_Time` datetime DEFAULT NULL,
  `Update_Time` datetime DEFAULT NULL,
  `Last_IP` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`UId`),
  UNIQUE KEY `Mail_UNIQUE` (`Mail`),
  UNIQUE KEY `UId_UNIQUE` (`UId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='會員註冊';

/*Data for the table `member` */

insert  into `member`(`UId`,`Name`,`Gender`,`Phone`,`Idnumber`,`Mail`,`Password`,`County`,`District`,`Address`,`Nickname`,`State`,`Code`,`School`,`Pic`,`Signature_1`,`Signature_2`,`Signature_3`,`Favor_1`,`Favor_2`,`Favor_3`,`Pair_1`,`Pair_2`,`Pair_3`,`Pair_4`,`Pair_5`,`Open_Tag`,`CREATE_Time`,`Update_Time`,`Last_IP`) values
(1,'蘇酥酥',0,'0912123123','A123123123','ggg.gg.ggg@gmail.com','123456','高雄市','新興區','台北市內湖區水源路110號','北投小辣椒',1,'1234','淡江小學00',10,1,3,10,23,25,27,NULL,NULL,NULL,NULL,NULL,1,'2022-08-08 00:55:29','2022-08-26 23:56:04','0:0:0:0:0:0:0:1'),
(2,'盧啊輝',0,'0945456456','A456456456','ooo.ooo.oooo1@gmail.com','123456',NULL,NULL,'台北市中山區中正路100號','淡水扛壩子',1,'1234','',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'2022-08-10 23:03:33','2022-08-10 23:03:33','127.0.0.1');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
SET SQL_NOTES=@OLD_SQL_NOTES;
