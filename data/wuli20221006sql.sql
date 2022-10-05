/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.28 : Database - wulidb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wulidb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `wulidb`;

/*Table structure for table `avatar` */

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
(7,'other.png',2,1,'2022-08-16 14:25:07','2022-08-16 14:25:10'),
(8,'boy01.png',0,1,'2022-08-16 14:25:34','2022-08-16 14:25:37'),
(9,'boy02.png',0,1,'2022-08-16 14:25:51','2022-08-16 14:25:54'),
(10,'boy03.png',0,1,'2022-08-16 14:26:08','2022-08-16 14:26:12'),
(11,'boy04.png',0,1,'2022-08-16 14:26:32','2022-08-16 14:26:34'),
(12,'boy05.png',0,1,'2022-08-16 14:26:59','2022-08-16 14:27:02'),
(13,'boy06.png',0,1,'2022-08-16 14:27:21','2022-08-16 14:27:30'),
(14,'default.png',3,1,'2022-08-16 14:27:21','2022-08-16 14:27:30');

/*Table structure for table `banner` */

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Img` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'link',
  `Describe` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Sub_Describe` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Link` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Order` int DEFAULT NULL COMMENT '1/2/3，如果有兩則都是1，則以上架時間愈新的為主',
  `Publish_Time` datetime DEFAULT NULL,
  `UnPublish_Time` datetime DEFAULT NULL,
  `Ishow` tinyint DEFAULT '0' COMMENT '0或1，預設為0',
  `Create_Time` datetime DEFAULT NULL,
  `Update_time` datetime DEFAULT NULL,
  `Delete_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `banner` */

/*Table structure for table `board` */

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Class` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IsComment` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '預設1可留言,房東可關閉',
  `Poster_Id` int DEFAULT NULL COMMENT 'fk',
  `Poster_Nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'from member',
  `Content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Create_Time` datetime DEFAULT NULL,
  `Update_Time` datetime DEFAULT NULL,
  `Views` int DEFAULT NULL,
  `Comments` int DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `board` */

/*Table structure for table `bookerexample` */

DROP TABLE IF EXISTS `bookerexample`;

CREATE TABLE `bookerexample` (
  `Booker_Id` int NOT NULL AUTO_INCREMENT,
  `Book_Date` date DEFAULT NULL,
  `BookerName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Booker_Phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Lead_Person` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Prefer_Floor` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Prefer_Time` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Roomtype` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Booker_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `bookerexample` */

/*Table structure for table `booking` */

DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking` (
  `Id` int NOT NULL,
  `Booker_Id` int NOT NULL,
  `Roomtype` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Book_Date` date NOT NULL,
  `Prefer_Time` time NOT NULL,
  `Prefer_Floor` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Chatroom_number` int DEFAULT NULL,
  `Lead_person` int DEFAULT NULL,
  `Create_Time` datetime DEFAULT NULL,
  `IsCancel` tinyint DEFAULT NULL COMMENT '房東可以幫用戶改時間',
  `Cancle_Time` datetime DEFAULT NULL,
  `Update_Time` datetime DEFAULT NULL COMMENT '房東可以幫用戶改時間',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `booking` */

/*Table structure for table `bookingexample` */

DROP TABLE IF EXISTS `bookingexample`;

CREATE TABLE `bookingexample` (
  `Booker_Id` int NOT NULL,
  `Book_Date` date DEFAULT NULL,
  `Prefer_Time` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Booker_Name` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Booker_Phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Roomtype` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Prefer_Floor` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Lead_Person` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Booker_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `bookingexample` */

insert  into `bookingexample`(`Booker_Id`,`Book_Date`,`Prefer_Time`,`Booker_Name`,`Booker_Phone`,`Roomtype`,`Prefer_Floor`,`Lead_Person`) values 
(8,'2022-09-20','15:00-15:30','吳志明','0988-125-478','雙人房A','高樓層','輝'),
(9,'2022-09-23','15:30-16:00','許英蘭','02-2863-4782','單人房C','高樓層','玄'),
(10,'2022-09-23','13:00-13:30','表仁鋒','0935-325-415','單人房A','高樓層','軒'),
(11,'2022-09-24','16:00-16:30','李昌勳','0988-788-258','雙人房B','高樓層','輝'),
(12,'2022-09-25','14:30-15:00','朴美月','0936-880-843','單人房B','高樓層','玄'),
(13,'2022-09-26','15:30-16:00','金素妍','02-2634-1258','雙人房C','高樓層','輝'),
(14,'2022-09-26','16:30-17:00','蕭亞軒','0957-423-899','單人房C','高樓層','玄'),
(15,'2022-09-26','16:30-17:00','吳芳','02-2299-9979','單人房A','高樓層','軒');

/*Table structure for table `character_favor` */

DROP TABLE IF EXISTS `character_favor`;

CREATE TABLE `character_favor` (
  `ID` int NOT NULL,
  `Type` int DEFAULT NULL COMMENT '1,2 (Character/Prefer)',
  `Name` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Icon` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '再討論',
  `IsShow` tinyint DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `Update_Time` datetime DEFAULT NULL,
  `Delete_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='個性標籤和偏好';

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

/*Table structure for table `chat_message` */

DROP TABLE IF EXISTS `chat_message`;

CREATE TABLE `chat_message` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Chatroom_Id` int DEFAULT NULL,
  `Sender` int unsigned DEFAULT NULL,
  `Receiver` int DEFAULT NULL,
  `Content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Send_Time` datetime DEFAULT NULL,
  `Is_Read` tinyint DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `chat_message` */

/*Table structure for table `chatroom` */

DROP TABLE IF EXISTS `chatroom`;

CREATE TABLE `chatroom` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Chat_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Repair/Friend/Booking',
  `Member1` int NOT NULL,
  `Member2` int NOT NULL,
  `Create_Time` datetime DEFAULT NULL COMMENT '聊天室成立的時間',
  `Close_Time` datetime NOT NULL,
  `IsOpen` tinyint DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `chatroom` */

/*Table structure for table `contract` */

DROP TABLE IF EXISTS `contract`;

CREATE TABLE `contract` (
  `CID` int NOT NULL AUTO_INCREMENT,
  `Status` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Name` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Room_Number` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Room_Type` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Payment_Status` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Check_Fee` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Check_Status` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `PDF` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Signed_Date` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Deposit` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Hide` tinyint DEFAULT '1',
  `MemberID` int DEFAULT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `contract` */

insert  into `contract`(`CID`,`Status`,`Name`,`Room_Number`,`Room_Type`,`Payment_Status`,`Check_Fee`,`Check_Status`,`PDF`,`Signed_Date`,`Deposit`,`Hide`,`MemberID`) values 
(1,'已退租','羅凱','EL1A','單人房A','已繳','未結算','未點交','111EL1A','2022-02-02','未退款',1,1),
(2,'已退租','林伯威','EL6C ','單人房C','未繳','未結算','已點交','111EL6C','2022-02-03','未退款',1,2),
(3,'已退租','陳上華','ER4E','雙人房B','未繳','未結算','已點交','111ER4E','2022-02-04','未退款',1,3),
(4,'租賃中','劉智澄','ER3A','單人房A','未繳','未結算','已點交','111ER3A','2022-02-05','未退款',1,4),
(5,'租賃中','盧家輝','ER1B','單人房B','未繳','未結算','已點交','111ER1B','2022-02-06','未退款',1,5),
(6,'租賃中','林伯彥','CR5D','雙人房A','未繳','未結算','已點交','111CR5D','2022-02-07','未退款',1,6),
(7,'租賃中','楊嘉琦','CL3F','雙人房C','未繳','已結算','已點交','111CL3F','2022-02-11','已退款',1,7),
(8,'租約到期','林祐德','EL4D','雙人房A','未繳','已結算','已點交','109EL4D','2022-02-12','已退款',1,8),
(9,'租約到期','潘嘉祥','EL6C','單人房C','已繳','已結算','已點交','110EL6C','2022-02-13','已退款',1,9),
(10,'租約到期','蔡東崙','CL5A','單人房A','已繳','已結算','已點交','110CL5A','2022-02-14','已退款',1,10),
(11,'已退租','許俊偉','CL7E','雙人房B','已繳','已結算','未點交','111CL7E','2022-02-15','已退款',1,11),
(12,'已退租','林志偉','EL2E','單人房B','已繳','已結算','未點交','111EL2E','2022-02-16','已退款',1,12),
(13,'已退租','陳秀萍','CL6F','雙人房C','未繳','已結算','未點交','111CL6F','2022-02-17','未退款',1,13),
(14,'租約到期','庭葦','EL6C','單人房C','未繳','未結算','未點交','110EL6C','2022-09-22','未退款',1,14),
(15,'租約到期','周采玲','CR5A','單人房A','已繳','未結算','未點交','110CR5A','2022-09-23','未退款',1,15);

/*Table structure for table `contractroom_typeitems` */

DROP TABLE IF EXISTS `contractroom_typeitems`;

CREATE TABLE `contractroom_typeitems` (
  `Room_Type` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TV` int DEFAULT NULL,
  `WaterHeater` int DEFAULT NULL,
  `Airconditioner` int DEFAULT NULL,
  `Freezer` int DEFAULT NULL,
  `Screen` int DEFAULT NULL,
  `Chair` int DEFAULT NULL,
  `SingleBed` int DEFAULT NULL,
  `DoubleBed` int DEFAULT NULL,
  `SmallDesk` int DEFAULT NULL,
  `BigDesk` int DEFAULT NULL,
  `SmallSideTable` int DEFAULT NULL,
  `BigSideTable` int DEFAULT NULL,
  `Wardrobe` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `contractroom_typeitems` */

insert  into `contractroom_typeitems`(`Room_Type`,`TV`,`WaterHeater`,`Airconditioner`,`Freezer`,`Screen`,`Chair`,`SingleBed`,`DoubleBed`,`SmallDesk`,`BigDesk`,`SmallSideTable`,`BigSideTable`,`Wardrobe`) values 
('單人房A',1,1,1,1,1,1,0,1,0,1,0,1,1),
('單人房B',1,1,1,1,1,1,0,1,0,1,0,1,1),
('單人房C',1,1,1,1,1,1,0,1,0,1,0,1,2),
('雙人房A',1,1,1,1,1,2,2,0,2,0,2,0,2),
('雙人房B',1,1,1,1,1,2,2,0,2,0,2,0,2),
('雙人房C',1,1,1,1,1,2,0,2,0,2,0,2,2);

/*Table structure for table `faq` */

DROP TABLE IF EXISTS `faq`;

CREATE TABLE `faq` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Answer` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CREATE_Time` datetime(6) DEFAULT NULL,
  `Delete_Time` datetime(6) DEFAULT NULL,
  `IsShow` tinyint DEFAULT NULL,
  `Publish_Time` datetime(6) DEFAULT NULL,
  `Question` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Unpublish_Time` datetime(6) DEFAULT NULL,
  `Update_Time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `faq` */

/*Table structure for table `fix` */

DROP TABLE IF EXISTS `fix`;

CREATE TABLE `fix` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Form_Number` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Room_Number` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Member_Id` int DEFAULT NULL,
  `Applicant` varchar(90) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_Time` datetime DEFAULT NULL,
  `Expection_Time` datetime DEFAULT NULL,
  `Fix_Time` datetime DEFAULT NULL,
  `Finish_Time` datetime DEFAULT NULL,
  `Project` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Note` varchar(450) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `landlordNote` varchar(450) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Status` int DEFAULT NULL,
  `Amount` int DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

/*Data for the table `fix` */

insert  into `fix`(`Id`,`Form_Number`,`Room_Number`,`Member_Id`,`Applicant`,`Phone`,`CREATE_Time`,`Expection_Time`,`Fix_Time`,`Finish_Time`,`Project`,`Note`,`landlordNote`,`Status`,`Amount`) values 
(1,'CL1B2022-09-25A1','CL1B',2,'輝','0915263563','2022-09-25 00:18:55','2022-10-02 11:49:45','2022-10-29 12:19:00','2022-09-25 21:05:57','17','紗窗破洞','維修完成',3,2000),
(2,'CL1B2022-09-25A2','CL1B',2,'輝','0915263563','2022-09-25 02:32:13','2022-10-02 11:49:45','2022-09-30 21:07:00',NULL,'17',' ',' 測試0925',2,2000),
(3,'CL1B2022-09-25A3','CL1B',2,'輝','0915263563','2022-09-25 02:41:19','2022-10-02 11:49:45',NULL,NULL,'1',' ',NULL,0,NULL),
(4,'CL1B2022-09-25A4','CL1B',2,'輝','0915263563','2022-09-25 02:42:17','2022-10-02 11:49:45',NULL,NULL,'13',' ',NULL,0,NULL),
(5,'CL1B2022-09-25A5','CL1B',2,'輝','0915263563','2022-09-25 02:47:02','2022-10-02 11:49:45',NULL,NULL,'2',' ',NULL,0,NULL),
(6,'CL1B2022-09-25A6','CL1B',2,'輝','0915263563','2022-09-25 02:51:31','2022-10-02 11:49:45',NULL,NULL,'14',' ',NULL,0,NULL),
(7,'CL1B2022-09-25A7','CL1B',2,'輝','0915263563','2022-09-25 02:55:46','2022-10-02 11:49:45',NULL,NULL,'2',' ',NULL,0,NULL),
(8,'CL1B2022-09-25A8','CL1B',2,'輝','0915263563','2022-09-25 02:57:30','2022-10-02 11:49:45',NULL,NULL,'16',' ',NULL,0,NULL),
(9,'CL1B2022-09-25A9','CL1B',2,'輝','0915263563','2022-09-25 02:58:40','2022-10-02 11:49:45',NULL,NULL,'1',' ',NULL,0,NULL);

/*Table structure for table `furniture_price` */

DROP TABLE IF EXISTS `furniture_price`;

CREATE TABLE `furniture_price` (
  `Id` int DEFAULT NULL,
  `Name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Price` int DEFAULT NULL,
  `alias_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `furniture_price` */

insert  into `furniture_price`(`Id`,`Name`,`Price`,`alias_name`) values 
(1,'TV',11000,'電視'),
(2,'Refrigerator',10500,'冰箱'),
(3,'AirCondition',NULL,'空調'),
(4,'Heater',NULL,'熱水器'),
(5,'Mirror',900,'化妝台'),
(6,'Flow_Table',600,'水表'),
(7,'Side_Table_S',3300,'小側邊桌'),
(8,'Side_Table_L',3500,'大側邊桌'),
(9,'Bed_Board_S',1800,'小床架'),
(10,'Bed_Board_L',2000,'大床架'),
(11,'Desk_S',3400,'小桌'),
(12,'Desk_L',3600,'大桌'),
(13,'Bed_S',3300,'小床'),
(14,'Bed_L',3500,'大床'),
(15,'Window_Screen_S',1600,'小窗戶'),
(16,'Window_Screen_L',2000,'大窗戶'),
(17,'Window_Screen_G',2000,'一般窗戶'),
(18,'Wardrobe',4500,'衣櫃'),
(19,'Chair',1800,'椅子');

/*Table structure for table `guarantor` */

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
(1,1,'蘇爸爸','A122883611','0987578575','臺北市','內湖區','台北市內湖區水源路111號','父親','2022-08-22 23:39:40','2022-08-27 00:28:23'),
(2,2,'張張','A122883611','0900000000','雲林縣','斗南鎮','中正路1000號','母','2022-08-22 23:39:40','2022-09-17 14:59:12'),
(3,3,'盧爸爸','A122883611','0925277685','臺南市','中西區','台北市中山區中正路101號','父親','2022-08-25 01:07:42','2022-08-28 21:04:02'),
(4,4,'劉媽媽','A122883611','0923351530','宜蘭縣','宜蘭市','經國路578號','母親','2022-08-25 09:20:27','2022-08-25 09:20:27'),
(5,5,'林媽媽','A122883611','0957888858','彰化縣','彰化市','三水路66號','阿姨','2022-08-25 23:13:51','2022-08-26 00:21:08');

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `UId` int NOT NULL DEFAULT '1',
  `Name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Gender` tinyint(1) NOT NULL,
  `Phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Id_Number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '身分證',
  `Mail` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `County` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `District` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
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
  `idNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`UId`),
  UNIQUE KEY `Mail_UNIQUE` (`Mail`),
  UNIQUE KEY `UId_UNIQUE` (`UId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='會員註冊';

/*Data for the table `member` */

insert  into `member`(`UId`,`Name`,`Gender`,`Phone`,`Id_Number`,`Mail`,`Password`,`County`,`District`,`Address`,`Nickname`,`State`,`Code`,`School`,`Pic`,`Signature_1`,`Signature_2`,`Signature_3`,`Favor_1`,`Favor_2`,`Favor_3`,`Pair_1`,`Pair_2`,`Pair_3`,`Pair_4`,`Pair_5`,`Open_Tag`,`CREATE_Time`,`Update_Time`,`Last_IP`,`idNumber`) values 
(1,'蘇酥酥',1,'0923154653','A272977393','ggg.gg.ggg@gmail.com','63f2680b55866975bf149514e344df18','高雄市','新興區','中正路100號','小酥1',1,'1234','淡江大學',1,1,3,10,23,25,27,NULL,NULL,NULL,NULL,NULL,1,'2022-08-08 00:55:29','2022-08-26 23:56:04','0:0:0:0:0:0:0:1',NULL),
(2,'盧啊輝',0,'0915263563','A166627157','ooo.ooo.oooo1@gmail.com','63f2680b55866975bf149514e344df18','台北市','中山區','台北市中山區中正路100號','小輝2',1,'1234','淡江大學',9,3,7,9,22,26,24,NULL,NULL,NULL,NULL,NULL,1,'2022-08-10 23:03:33','2022-08-10 23:03:33','127.0.0.1',NULL),
(3,'林威',0,'0951236523','A116725199','linw@gmail.com','63f2680b55866975bf149514e344df18','台北市',NULL,'台北市新生南路565號','小威3',1,'1234','海洋科大',8,4,6,8,22,23,26,NULL,NULL,NULL,NULL,NULL,1,'2022-09-10 13:00:43',NULL,NULL,NULL),
(4,'蔡英文',1,'0956326627','A288436054','1023@mail.com','63f2680b55866975bf149514e344df18','新北市','三重區','新北市三重區三水路8863號','小英4',1,'1234','聖約翰大學',2,2,3,8,27,21,23,NULL,NULL,NULL,NULL,NULL,1,'2022-09-10 13:02:28',NULL,NULL,NULL),
(5,'連勝文',0,'0956385656','A122883611','4563@gmail.com','63f2680b55866975bf149514e344df18','台南市','安平區','台南市安平區鯤鯓路41號','小文5',1,'1024','真理大學',10,4,6,8,21,26,22,NULL,NULL,NULL,NULL,NULL,1,'2022-09-10 13:03:42',NULL,NULL,NULL),
(6,'馬英九',0,'0945616256','A123456789','ma@gmail.com','63f2680b55866975bf149514e344df18','台北市',NULL,'台北市','小馬6',1,'1234','真理大學',12,5,2,1,25,24,25,NULL,NULL,NULL,NULL,NULL,1,'2022-09-24 20:56:00',NULL,NULL,NULL);

/*Table structure for table `memberhibernatebean` */

DROP TABLE IF EXISTS `memberhibernatebean`;

CREATE TABLE `memberhibernatebean` (
  `uId` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `county` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createTime` datetime(6) DEFAULT NULL,
  `district` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `favor1` int DEFAULT NULL,
  `favor2` int DEFAULT NULL,
  `favor3` int DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `idNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lastIp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `openTag` bit(1) NOT NULL,
  `pair1` int DEFAULT NULL,
  `pair2` int DEFAULT NULL,
  `pair3` int DEFAULT NULL,
  `pair4` int DEFAULT NULL,
  `pair5` int DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pic` int DEFAULT NULL,
  `school` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `signature1` int DEFAULT NULL,
  `signature2` int DEFAULT NULL,
  `signature3` int DEFAULT NULL,
  `state` int DEFAULT NULL,
  `updateTime` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `memberhibernatebean` */

/*Table structure for table `property_management` */

DROP TABLE IF EXISTS `property_management`;

CREATE TABLE `property_management` (
  `id` int NOT NULL DEFAULT '1',
  `Name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `county` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `district` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
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
(1,'山水苑','63f2680b55866975bf149514e344df18','0935355331','新北市','淡水區','水源街二段177巷45號','wuli.co.ltd@gmail.com','mid_1_20220925.png');

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

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `Rid` int NOT NULL AUTO_INCREMENT,
  `RoomId` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Building` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Floor` int NOT NULL,
  `Location` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `RoomType` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Tenant_Number` int DEFAULT NULL,
  `Contract_Number` int DEFAULT NULL,
  PRIMARY KEY (`Rid`),
  UNIQUE KEY `Room_Number_UNIQUE` (`RoomId`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='房間';

/*Data for the table `room` */

insert  into `room`(`Rid`,`RoomId`,`Building`,`Floor`,`Location`,`RoomType`,`Tenant_Number`,`Contract_Number`) values 
(1,'CL1A','C',1,'L','A',1,1),
(2,'CL1B','C',1,'L','B',2,2),
(3,'CL1C','C',1,'L','C',NULL,NULL),
(4,'CL1D','C',1,'L','D',4,4),
(5,'CL1E','C',1,'L','E',NULL,NULL),
(6,'CL1F','C',1,'L','F',6,6),
(7,'CL2A','C',2,'L','A',7,7),
(8,'CL2B','C',2,'L','B',8,8),
(9,'CL2C','C',2,'L','C',NULL,NULL),
(10,'CL2D','C',2,'L','D',10,10),
(11,'CL2E','C',2,'L','E',11,11),
(12,'CL2F','C',2,'L','F',12,12),
(13,'CL3A','C',3,'L','A',13,13),
(14,'CL3B','C',3,'L','B',14,14),
(15,'CL3C','C',3,'L','C',15,15),
(16,'CL3D','C',3,'L','D',16,16),
(17,'CL3E','C',3,'L','E',NULL,NULL),
(18,'CL3F','C',3,'L','F',18,18),
(19,'CL4A','C',4,'L','A',19,19),
(20,'CL4B','C',4,'L','B',20,20),
(21,'CL4C','C',4,'L','C',21,21),
(22,'CL4D','C',4,'L','D',NULL,NULL),
(23,'CL4E','C',4,'L','E',NULL,NULL),
(24,'CL4F','C',4,'L','F',24,24),
(25,'CL5A','C',5,'L','A',25,25),
(26,'CL5B','C',5,'L','B',26,26),
(27,'CL5C','C',5,'L','C',27,27),
(28,'CL5D','C',5,'L','D',28,28),
(29,'CL5E','C',5,'L','E',29,29),
(30,'CL5F','C',5,'L','F',30,30),
(31,'CL6A','C',6,'L','A',31,31),
(32,'CL6B','C',6,'L','B',32,32),
(33,'CL6C','C',6,'L','C',33,33),
(34,'CL6D','C',6,'L','D',34,34),
(35,'CL6E','C',6,'L','E',35,35),
(36,'CL6F','C',6,'L','F',36,36),
(37,'CL7A','C',7,'L','A',37,37),
(38,'CL7B','C',7,'L','B',38,38),
(39,'CL7C','C',7,'L','C',39,39),
(40,'CL7D','C',7,'L','D',40,40),
(41,'CL7E','C',7,'L','E',41,41),
(42,'CL7F','C',7,'L','F',42,42),
(43,'CL8A','C',8,'L','A',43,43),
(44,'CL8B','C',8,'L','B',44,44),
(45,'CL8C','C',8,'L','C',NULL,NULL),
(46,'CL8D','C',8,'L','D',NULL,NULL),
(47,'CL8E','C',8,'L','E',47,47),
(48,'CL8F','C',8,'L','F',48,48),
(49,'CR1A','C',1,'R','A',49,49),
(50,'CR1B','C',1,'R','B',50,50),
(51,'CR1C','C',1,'R','C',51,51),
(52,'CR1D','C',1,'R','D',52,52),
(53,'CR1E','C',1,'R','E',53,53),
(54,'CR1F','C',1,'R','F',54,54),
(55,'CR2A','C',2,'R','A',55,55),
(56,'CR2B','C',2,'R','B',56,56),
(57,'CR2C','C',2,'R','C',57,57),
(58,'CR2D','C',2,'R','D',58,58),
(59,'CR2E','C',2,'R','E',59,59),
(60,'CR2F','C',2,'R','F',60,60),
(61,'CR3A','C',3,'R','A',61,61),
(62,'CR3B','C',3,'R','B',62,62),
(63,'CR3C','C',3,'R','C',63,63),
(64,'CR3D','C',3,'R','D',64,64),
(65,'CR3E','C',3,'R','E',65,65),
(66,'CR3F','C',3,'R','F',66,66),
(67,'CR4A','C',4,'R','A',67,67),
(68,'CR4B','C',4,'R','B',68,68),
(69,'CR4C','C',4,'R','C',69,69),
(70,'CR4D','C',4,'R','D',70,70),
(71,'CR4E','C',4,'R','E',71,71),
(72,'CR4F','C',4,'R','F',72,72),
(73,'CR5A','C',5,'R','A',NULL,NULL),
(74,'CR5B','C',5,'R','B',74,74),
(75,'CR5C','C',5,'R','C',NULL,NULL),
(76,'CR5D','C',5,'R','D',76,76),
(77,'CR5E','C',5,'R','E',77,77),
(78,'CR5F','C',5,'R','F',78,78),
(79,'CR6A','C',6,'R','A',NULL,NULL),
(80,'CR6B','C',6,'R','B',NULL,NULL),
(81,'CR6C','C',6,'R','C',NULL,NULL),
(82,'CR6D','C',6,'R','D',82,82),
(83,'CR6E','C',6,'R','E',83,83),
(84,'CR6F','C',6,'R','F',84,84),
(85,'CR7A','C',7,'R','A',85,85),
(86,'CR7B','C',7,'R','B',86,86),
(87,'CR7C','C',7,'R','C',87,87),
(88,'CR7D','C',7,'R','D',88,88),
(89,'CR7E','C',7,'R','E',89,89),
(90,'CR7F','C',7,'R','F',90,90),
(91,'CR8A','C',8,'R','A',91,91),
(92,'CR8B','C',8,'R','B',92,92),
(93,'CR8C','C',8,'R','C',93,93),
(94,'CR8D','C',8,'R','D',94,94),
(95,'CR8E','C',8,'R','E',95,95),
(96,'CR8F','C',8,'R','F',96,96),
(97,'EL1A','E',1,'L','A',97,97),
(98,'EL1B','E',1,'L','B',NULL,NULL),
(99,'EL1C','E',1,'L','C',99,99),
(100,'EL1D','E',1,'L','D',100,100),
(101,'EL1E','E',1,'L','E',101,101),
(102,'EL1F','E',1,'L','F',102,102),
(103,'EL2A','E',2,'L','A',NULL,NULL),
(104,'EL2B','E',2,'L','B',104,104),
(105,'EL2C','E',2,'L','C',105,105),
(106,'EL2D','E',2,'L','D',106,106),
(107,'EL2E','E',2,'L','E',107,107),
(108,'EL2F','E',2,'L','F',NULL,NULL),
(109,'EL3A','E',3,'L','A',109,109),
(110,'EL3B','E',3,'L','B',110,110),
(111,'EL3C','E',3,'L','C',111,111),
(112,'EL3D','E',3,'L','D',NULL,NULL),
(113,'EL3E','E',3,'L','E',113,113),
(114,'EL3F','E',3,'L','F',114,114),
(115,'EL4A','E',4,'L','A',115,115),
(116,'EL4B','E',4,'L','B',NULL,NULL),
(117,'EL4C','E',4,'L','C',117,117),
(118,'EL4D','E',4,'L','D',118,118),
(119,'EL4E','E',4,'L','E',NULL,NULL),
(120,'EL4F','E',4,'L','F',120,120),
(121,'EL5A','E',5,'L','A',121,121),
(122,'EL5B','E',5,'L','B',122,122),
(123,'EL5C','E',5,'L','C',NULL,NULL),
(124,'EL5D','E',5,'L','D',124,124),
(125,'EL5E','E',5,'L','E',125,125),
(126,'EL5F','E',5,'L','F',NULL,NULL),
(127,'EL6A','E',6,'L','A',127,127),
(128,'EL6B','E',6,'L','B',128,128),
(129,'EL6C','E',6,'L','C',129,129),
(130,'EL6D','E',6,'L','D',130,130),
(131,'EL6E','E',6,'L','E',131,131),
(132,'EL6F','E',6,'L','F',132,132),
(133,'EL7A','E',7,'L','A',133,133),
(134,'EL7B','E',7,'L','B',134,134),
(135,'EL7C','E',7,'L','C',NULL,NULL),
(136,'EL7D','E',7,'L','D',136,136),
(137,'EL7E','E',7,'L','E',137,137),
(138,'EL7F','E',7,'L','F',138,138),
(139,'EL8A','E',8,'L','A',139,139),
(140,'EL8B','E',8,'L','B',140,140),
(141,'EL8C','E',8,'L','C',141,141),
(142,'EL8D','E',8,'L','D',142,142),
(143,'EL8E','E',8,'L','E',143,143),
(144,'EL8F','E',8,'L','F',144,144),
(145,'ER1A','E',1,'R','A',145,145),
(146,'ER1B','E',1,'R','B',146,146),
(147,'ER1C','E',1,'R','C',NULL,NULL),
(148,'ER1D','E',1,'R','D',NULL,NULL),
(149,'ER1E','E',1,'R','E',NULL,NULL),
(150,'ER1F','E',1,'R','F',150,150),
(151,'ER2A','E',2,'R','A',151,151),
(152,'ER2B','E',2,'R','B',152,152),
(153,'ER2C','E',2,'R','C',153,153),
(154,'ER2D','E',2,'R','D',154,154),
(155,'ER2E','E',2,'R','E',155,155),
(156,'ER2F','E',2,'R','F',156,156),
(157,'ER3A','E',3,'R','A',NULL,NULL),
(158,'ER3B','E',3,'R','B',158,158),
(159,'ER3C','E',3,'R','C',159,159),
(160,'ER3D','E',3,'R','D',NULL,NULL),
(161,'ER3E','E',3,'R','E',161,161),
(162,'ER3F','E',3,'R','F',162,162),
(163,'ER4A','E',4,'R','A',163,163),
(164,'ER4B','E',4,'R','B',164,164),
(165,'ER4C','E',4,'R','C',165,165),
(166,'ER4D','E',4,'R','D',166,166),
(167,'ER4E','E',4,'R','E',167,167),
(168,'ER4F','E',4,'R','F',NULL,NULL),
(169,'ER5A','E',5,'R','A',169,169),
(170,'ER5B','E',5,'R','B',170,170),
(171,'ER5C','E',5,'R','C',NULL,NULL),
(172,'ER5D','E',5,'R','D',172,172),
(173,'ER5E','E',5,'R','E',NULL,NULL),
(174,'ER5F','E',5,'R','F',NULL,NULL),
(175,'ER6A','E',6,'R','A',175,175),
(176,'ER6B','E',6,'R','B',NULL,NULL),
(177,'ER6C','E',6,'R','C',177,177),
(178,'ER6D','E',6,'R','D',178,178),
(179,'ER6E','E',6,'R','E',179,179),
(180,'ER6F','E',6,'R','F',180,180),
(181,'ER7A','E',7,'R','A',181,181),
(182,'ER7B','E',7,'R','B',182,182),
(183,'ER7C','E',7,'R','C',183,183),
(184,'ER7D','E',7,'R','D',184,184),
(185,'ER7E','E',7,'R','E',185,185),
(186,'ER7F','E',7,'R','F',186,186),
(187,'ER8A','E',8,'R','A',NULL,NULL),
(188,'ER8B','E',8,'R','B',NULL,NULL),
(189,'ER8C','E',8,'R','C',189,189),
(190,'ER8D','E',8,'R','D',190,190),
(191,'ER8E','E',8,'R','E',NULL,NULL),
(192,'ER8F','E',8,'R','F',192,192);

/*Table structure for table `roomtype` */

DROP TABLE IF EXISTS `roomtype`;

CREATE TABLE `roomtype` (
  `Type` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'A-F',
  `Name` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '單人房A/雙人A',
  `Total` int NOT NULL COMMENT '該房型的總共數量',
  `Price` int DEFAULT NULL,
  `Size` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Balcony` tinyint DEFAULT NULL,
  `Pic1` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Pic2` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Pic3` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '格局link',
  `TV` int DEFAULT '1',
  `Refrigerator` int DEFAULT '1',
  `AirCondition` int DEFAULT '1',
  `Heater` int DEFAULT '1',
  `Mirror` int DEFAULT '1',
  `Flow_Table` int DEFAULT '1',
  `Side_Table_S` int DEFAULT NULL,
  `Side_Table_L` int DEFAULT NULL,
  `Bed_Board_S` int DEFAULT NULL,
  `Bed_Board_L` int DEFAULT NULL,
  `Desk_S` int DEFAULT NULL,
  `Desk_L` int DEFAULT NULL,
  `Bed_S` int DEFAULT NULL,
  `Bed_L` int DEFAULT NULL,
  `Window_Screen_S` int DEFAULT NULL,
  `Window_Screen_L` int DEFAULT NULL,
  `Window_Screen_G` int DEFAULT NULL COMMENT '落地紗窗',
  `Wardrobe` int DEFAULT NULL,
  `Chair` int DEFAULT NULL,
  PRIMARY KEY (`Type`),
  UNIQUE KEY `Rid_UNIQUE` (`Type`),
  UNIQUE KEY `name_UNIQUE` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='房型,Q開頭的是數量 / P開頭的是價格';

/*Data for the table `roomtype` */

insert  into `roomtype`(`Type`,`Name`,`Total`,`Price`,`Size`,`Balcony`,`Pic1`,`Pic2`,`Pic3`,`TV`,`Refrigerator`,`AirCondition`,`Heater`,`Mirror`,`Flow_Table`,`Side_Table_S`,`Side_Table_L`,`Bed_Board_S`,`Bed_Board_L`,`Desk_S`,`Desk_L`,`Bed_S`,`Bed_L`,`Window_Screen_S`,`Window_Screen_L`,`Window_Screen_G`,`Wardrobe`,`Chair`) values 
('A','單人房A',64,7800,'5 ~ 7',0,'SingleA1.jpg','SingleA2.jpg','SingleA3.jpg',1,1,1,1,1,1,0,1,0,1,0,1,0,1,NULL,NULL,NULL,1,1),
('B','單人房B',64,8300,'5 ~ 7',1,'SingleB1.jpg','SingleB2.jpg','SingleB3.jpg',1,1,1,1,1,1,0,1,0,1,0,1,0,1,NULL,NULL,NULL,1,1),
('C','單人房C',64,8500,'5 ~ 7',1,'SingleC1.jpg','SingleC2.jpg','SingleC3.jpg',1,1,1,1,1,1,0,1,0,1,0,1,0,1,NULL,NULL,NULL,2,1),
('D','雙人房A',64,9500,'8 ~ 10',0,'DoubleA1.jpg','DoubleA2.jpg','DoubleA2.jpg',1,1,1,1,1,1,2,0,2,0,2,0,2,0,NULL,NULL,NULL,2,2),
('E','雙人房B',64,10000,'8 ~ 10',1,'DoubleB1.jpg','DoubleB2.jpg','DoubleB3.jpg',1,1,1,1,1,1,2,0,2,0,2,0,2,0,NULL,NULL,NULL,2,2),
('F','雙人房C',64,10500,'8 ~ 10',1,'DoubleC1.jpg','DoubleC2.jpg','DoubleC3.jpg',1,1,1,1,1,1,0,2,2,0,0,2,2,0,NULL,NULL,NULL,2,2);

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `Uid` int NOT NULL,
  `Name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Open_Hour` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Adress` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Social_link` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Img` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'link \n連結字串，指定到某個圖片檔，沒有圖片需指到預設圖片',
  `Describe` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Conclusion_Link` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '連結字串？',
  `Order` int DEFAULT NULL COMMENT '1/2/3，如果有兩則都是1，則以上架時間愈新的為主',
  `IsShow` tinyint DEFAULT NULL,
  `Publish_Time` datetime DEFAULT NULL,
  `Unpublish_Time` datetime DEFAULT NULL COMMENT '空白表示：永遠上架',
  `Create_Time` datetime DEFAULT NULL,
  `Update_Time` datetime DEFAULT NULL,
  `Delete_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`Uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商家';

/*Data for the table `store` */

/*Table structure for table `tenant` */

DROP TABLE IF EXISTS `tenant`;

CREATE TABLE `tenant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Member_Id` int NOT NULL COMMENT 'FK',
  `Contract_Number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'FK',
  `Begin_Time` date DEFAULT NULL,
  `End_Time` date DEFAULT NULL,
  `Room_Number` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'FK',
  `Deposit` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='租客';

/*Data for the table `tenant` */

insert  into `tenant`(`id`,`Member_Id`,`Contract_Number`,`Begin_Time`,`End_Time`,`Room_Number`,`Deposit`) values 
(3,4,'111CL1D','2022-08-12','2022-10-01','CL1D',18000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
