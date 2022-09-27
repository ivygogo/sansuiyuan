/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.28 : Database - wulidb
*********************************************************************
*/

 SET NAMES utf8 ;

 SET SQL_MODE='';

 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 ;
 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 ;
 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' ;
 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 ;
-- CREATE DATABASE IF NOT EXISTS`wulidb` !40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT ENCRYPTION='N' ;

USE `wulidb`;

-- Table structure for table `guarantor`

DROP TABLE IF EXISTS `guarantor`;

CREATE TABLE `guarantor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Memberid` int NOT NULL COMMENT '對應member id',
  `Name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Idnumber` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `County` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `District` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Relation` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Create_Time` datetime DEFAULT NULL,
  `Update_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UId_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='保證人';

-- Data for the table `guarantor`

insert  into `guarantor`(`id`,`Memberid`,`Name`,`Idnumber`,`Phone`,`County`,`District`,`Address`,`Relation`,`Create_Time`,`Update_Time`) values
(1,1,'蘇爸爸','A111111111','0911111111','臺北市','內湖區','台北市內湖區水源路111號','父親','2022-08-22 23:39:40','2022-08-27 00:28:23'),
(3,2,'盧爸爸','A222222222','','臺南市','中西區','台北市中山區中正路101號','父親','2022-08-25 01:07:42','2022-08-28 21:04:02'),
(4,1,'test','A123456789','0900000000','宜蘭縣','宜蘭市','wefwef','test','2022-08-25 09:20:27','2022-08-25 09:20:27'),
(5,1,'測試0825','A123456789','0900000000','彰化縣','彰化市','測試0825測試0825','測試0825','2022-08-25 23:13:51','2022-08-26 00:21:08');


 SET SQL_MODE=@OLD_SQL_MODE ;
 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS ;
 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS ;
 SET SQL_NOTES=@OLD_SQL_NOTES ;
