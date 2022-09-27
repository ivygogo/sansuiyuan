/*本檔案包括以下Table:
 * 1. avatar,
 * 2. character_favor,
 * 3. fix,guarantor,
 * 4. tenant,
 * 5. refund_account,
 * 6. property_management,
 * 7. member--->用崧哥的
 * */
CREATE DATABASE IF NOT EXISTS `wulidb`;

DROP TABLE IF EXISTS `avatar`;

CREATE TABLE `avatar` (
  `id` int NOT NULL DEFAULT '1',
  `avatarName` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `genderType` tinyint NOT NULL,
  `isShow` tinyint NOT NULL,
  `createTime` datetime NOT NULL,
  `updateTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `avatar` */

insert  into `avatar`(`id`,`avatarName`,`genderType`,`isShow`,`createTime`,`updateTime`) values 
(1,'girl01.png',1,1,'2022-08-11 00:29:49','2022-08-11 00:29:55'),
(2,'girl02.png',1,1,'2022-08-16 14:20:29','2022-08-16 14:20:33'),
(3,'girl03.png',1,1,'2022-08-16 14:20:41','2022-08-16 14:20:50'),
(4,'girl04.png',1,1,'2022-08-16 14:21:40','2022-08-16 14:21:47'),
(5,'girl05.png',1,1,'2022-08-16 14:22:04','2022-08-16 14:22:08'),
(6,'girl06.png',1,1,'2022-08-16 14:22:37','2022-08-16 14:22:40'),
(7,'default.png',2,1,'2022-08-16 14:25:07','2022-08-16 14:25:10'),
(8,'boy01.png',0,1,'2022-08-16 14:25:34','2022-08-16 14:25:37'),
(9,'boy02.png',0,1,'2022-08-16 14:25:51','2022-08-16 14:25:54'),
(10,'boy03.png',0,1,'2022-08-16 14:26:08','2022-08-16 14:26:12'),
(11,'boy04.png',0,1,'2022-08-16 14:26:32','2022-08-16 14:26:34'),
(12,'boy05.png',0,1,'2022-08-16 14:26:59','2022-08-16 14:27:02'),
(13,'boy06.png',0,1,'2022-08-16 14:27:21','2022-08-16 14:27:30');


DROP TABLE IF EXISTS `character_favor`;

CREATE TABLE `character_favor` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Type` int DEFAULT NULL COMMENT '1,2 (Character/Prefer)',
  `Name` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Icon` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '再討論',
  `IsShow` tinyint DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `Update_Time` datetime DEFAULT NULL,
  `Delete_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='個性標籤和偏好';

/*Data for the table `character_favor` */

insert  into `character_favor`(`ID`,`Type`,`Name`,`Icon`,`IsShow`,`CreateTime`,`Update_Time`,`Delete_Time`) values 
(1,1,'活潑開朗',NULL,1,'2022-08-08 00:11:59','2022-08-08 00:11:59',NULL),
(2,1,'安靜內向',NULL,1,'2022-08-08 00:24:27','2022-08-08 00:24:27',NULL),
(3,1,'喜歡運動',NULL,1,'2022-08-08 00:26:52','2022-08-08 00:26:52',NULL),
(4,1,'喜歡看書',NULL,1,'2022-08-08 00:26:52','2022-08-08 00:26:52',NULL),
(5,1,'喜歡動漫',NULL,1,'2022-08-08 00:26:52','2022-08-08 00:26:52',NULL),
(6,1,'喜歡寵物',NULL,1,'2022-08-08 00:26:52','2022-08-08 00:26:52',NULL),
(7,1,'喜歡音樂',NULL,1,'2022-08-08 00:26:52','2022-08-08 00:26:52',NULL),
(8,1,'喜歡電競',NULL,1,'2022-08-08 00:26:52','2022-08-08 00:26:52',NULL),
(9,1,'喜歡看劇',NULL,1,'2022-08-08 00:26:52','2022-08-08 00:26:52',NULL),
(10,1,'喜歡日韓',NULL,1,'2022-08-08 00:26:52','2022-08-08 00:26:52',NULL),
(18,2,'晨型人',NULL,1,'2022-08-08 00:32:51','2022-08-08 00:32:51',NULL),
(19,2,'夜貓子',NULL,1,'2022-08-08 00:32:51','2022-08-08 00:32:51',NULL),
(20,2,'一塵不染',NULL,1,'2022-08-08 00:32:51','2022-08-08 00:32:51',NULL),
(21,2,'稍稍潔癖',NULL,1,'2022-08-08 00:32:51','2022-08-08 00:32:51',NULL),
(22,2,'亂中有序',NULL,1,'2022-08-08 00:32:51','2022-08-08 00:32:51',NULL),
(23,2,'邊界感強',NULL,1,'2022-08-08 00:32:51','2022-08-08 00:32:51',NULL),
(24,2,'很好溝通',NULL,1,'2022-08-08 00:32:51','2022-08-08 00:32:51',NULL),
(25,2,'公費均攤',NULL,1,'2022-08-08 00:32:51','2022-08-08 00:32:51',NULL),
(26,2,'朋友可訪',NULL,1,'2022-08-08 00:32:51','2022-08-08 00:32:51',NULL),
(27,2,'接受寵物',NULL,1,'2022-08-08 00:32:51','2022-08-08 00:32:51',NULL);

DROP TABLE IF EXISTS `fix`;

CREATE TABLE `fix` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Form_Number` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Room_Number` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Member_Id` int DEFAULT NULL,
  `Applicant` varchar(90) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Phone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_Time` datetime DEFAULT NULL,
  `Expection_Time` datetime DEFAULT NULL,
  `Fix_Time` datetime DEFAULT NULL,
  `Finish_Time` datetime DEFAULT NULL,
  `Project` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Note` varchar(450) COLLATE utf8_unicode_ci DEFAULT NULL,
  `landlordNote` varchar(450) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Status` int DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `fix` */

insert  into `fix`(`Id`,`Form_Number`,`Room_Number`,`Member_Id`,`Applicant`,`Phone`,`CREATE_Time`,`Expection_Time`,`Fix_Time`,`Finish_Time`,`Project`,`Note`,`landlordNote`,`Status`,`Amount`) values 
(1,'BL01F1A2022-09-25A1','BL01F1A',2,'oootest','0900000001','2022-09-25 00:18:55','2022-10-02 11:49:45','2022-10-29 12:19:00','2022-09-25 21:05:57','17',' 測試單',' 備註測試',3,2000),
(2,'BL01F1A2022-09-25A2','BL01F1A',2,'oootest','0900000001','2022-09-25 02:32:13','2022-10-02 11:49:45','2022-09-30 21:07:00',NULL,'17',' ',' 測試0925',2,2000),
(3,'BL01F1A2022-09-25A3','BL01F1A',2,'oootest','0900000001','2022-09-25 02:41:19','2022-10-02 11:49:45',NULL,NULL,'1',' ',NULL,0,NULL),
(4,'BL01F1A2022-09-25A4','BL01F1A',2,'oootest','0900000001','2022-09-25 02:42:17','2022-10-02 11:49:45',NULL,NULL,'13',' ',NULL,0,NULL),
(5,'BL01F1A2022-09-25A5','BL01F1A',2,'oootest','0900000001','2022-09-25 02:47:02','2022-10-02 11:49:45',NULL,NULL,'2',' ',NULL,0,NULL),
(6,'BL01F1A2022-09-25A6','BL01F1A',2,'oootest','0900000001','2022-09-25 02:51:31','2022-10-02 11:49:45',NULL,NULL,'14',' ',NULL,0,NULL),
(7,'BL01F1A2022-09-25A7','BL01F1A',2,'oootest','0900000001','2022-09-25 02:55:46','2022-10-02 11:49:45',NULL,NULL,'2',' ',NULL,0,NULL),
(8,'BL01F1A2022-09-25A8','BL01F1A',2,'oootest','0900000001','2022-09-25 02:57:30','2022-10-02 11:49:45',NULL,NULL,'16',' ',NULL,0,NULL),
(9,'BL01F1A2022-09-25A9','BL01F1A',2,'oootest','0900000001','2022-09-25 02:58:40','2022-10-02 11:49:45',NULL,NULL,'1',' ',NULL,0,NULL);

/*Table structure for table `furniture_price` */

DROP TABLE IF EXISTS `guarantor`;

CREATE TABLE `guarantor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Member_Id` int NOT NULL COMMENT '對應member id',
  `Name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Id_Number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
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

/*Data for the table `guarantor` */

insert  into `guarantor`(`id`,`Member_Id`,`Name`,`Id_Number`,`Phone`,`County`,`District`,`Address`,`Relation`,`Create_Time`,`Update_Time`) values 
(1,1,'張張','A123456789','0900000000','雲林縣','斗南鎮','中正路1000號','母','2022-08-22 23:39:40','2022-09-17 14:59:12');



/*Table structure for table `property_management` */

DROP TABLE IF EXISTS `property_management`;

CREATE TABLE `property_management` (
  `id` int NOT NULL DEFAULT '1',
  `Name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `county` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `district` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Mail` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Stamp` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '公司章 link',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UId_UNIQUE` (`id`),
  UNIQUE KEY `Password_UNIQUE` (`Password`),
  UNIQUE KEY `Mail_UNIQUE` (`Mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='物業資訊';

/*Data for the table `property_management` */

insert  into `property_management`(`id`,`Name`,`Password`,`Phone`,`county`,`district`,`Address`,`Mail`,`Stamp`) values 
(1,'山水苑',NULL,'0900000000','基隆市','仁愛區','淡水公路188號','000@gmail.com','mid_1_20220925.png');

/*Table structure for table `refund_account` */

DROP TABLE IF EXISTS `refund_account`;

CREATE TABLE `refund_account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Member_Id` int NOT NULL COMMENT 'FK',
  `refundBank` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bankStore` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `bankAccount` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `refundName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UId_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='租客';

/*Data for the table `refund_account` */

insert  into `refund_account`(`id`,`Member_Id`,`refundBank`,`bankStore`,`bankAccount`,`refundName`,`createTime`,`updateTime`) values 
(4,1,'中國信託商業銀行','敦南分行','1234567899','張小明','2022-08-26 21:31:28','2022-09-07 01:07:00');

/*Table structure for table `room` */

DROP TABLE IF EXISTS `tenant`;

CREATE TABLE `tenant` (
  `id` int NOT NULL DEFAULT '1',
  `Member_Id` int NOT NULL COMMENT 'FK',
  `Contract_Number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'FK',
  `Begin_Time` date DEFAULT NULL,
  `End_Time` date DEFAULT NULL,
  `Room_Number` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'FK',
  `Deposit` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='租客';

/*Data for the table `tenant` */

insert  into `tenant`(`id`,`Member_Id`,`Contract_Number`,`Begin_Time`,`End_Time`,`Room_Number`,`Deposit`) values 
(1,1,'20220901','2022-09-11','2022-09-30','CL01F1A',10000),
(2,1,'20210701','2021-09-11','2022-09-11','CL01F1A',10000),
(3,2,'20220812','2022-08-12','2022-10-01','BL01F1A',5000);