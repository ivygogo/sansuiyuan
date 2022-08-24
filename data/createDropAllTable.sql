CREATE DATABASE IF NOT EXISTS `wulidb`;

USE `wulidb`;

/*Table structure for table `banner` */

DROP TABLE IF EXISTS `banner`;

CREATE TABLE `banner`
(
  `Id`             int                                    NOT NULL AUTO_INCREMENT,
  `Name`           varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Img`            varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'link',
  `Describe`       varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Sub_Describe`   varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Link`           varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Order`          int                                    DEFAULT NULL COMMENT '1/2/3，如果有兩則都是1，則以上架時間愈新的為主',
  `Publish_Time`   datetime                               DEFAULT NULL,
  `UnPublish_Time` datetime                               DEFAULT NULL,
  `Ishow`          tinyint                                DEFAULT '0' COMMENT '0或1，預設為0',
  `Create_Time`    datetime                               DEFAULT NULL,
  `Update_time`    datetime                               DEFAULT NULL,
  `Delete_Time`    datetime                               DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

/*Table structure for table `board` */

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board`
(
  `Id`              int NOT NULL AUTO_INCREMENT,
  `Class`           varchar(5) COLLATE utf8mb4_unicode_ci   DEFAULT NULL,
  `IsComment`       varchar(45) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '預設1可留言,房東可關閉',
  `Poster_Id`       int                                     DEFAULT NULL COMMENT 'fk',
  `Poster_Nickname` varchar(20) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT 'from member',
  `Content`         varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Create_Time`     datetime                                DEFAULT NULL,
  `Update_Time`     datetime                                DEFAULT NULL,
  `Views`           int                                     DEFAULT NULL,
  `Comments`        int                                     DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

/*Table structure for table `booking` */

DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking`
(
  `Id`              int                                                         NOT NULL,
  `Booker_Id`       int                                                         NOT NULL,
  `Roomtype`        varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Book_Date`       date                                                        NOT NULL,
  `Prefer_Time`     time                                                        NOT NULL,
  `Prefer_Floor`    varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Chatroom_number` int                                                         DEFAULT NULL,
  `Lead_person`     int                                                         DEFAULT NULL,
  `CREATE_Time`     datetime                                                    DEFAULT NULL,
  `IsCancel`        tinyint                                                     DEFAULT NULL COMMENT '房東可以幫用戶改時間',
  `Cancle_Time`     datetime                                                    DEFAULT NULL,
  `Update_Time`     datetime                                                    DEFAULT NULL COMMENT '房東可以幫用戶改時間',
  PRIMARY KEY (`Id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

/*Table structure for table `character_favor` */

DROP TABLE IF EXISTS `character_favor`;

CREATE TABLE `character_favor`
(
  `ID`          int NOT NULL AUTO_INCREMENT,
  `Type`        int                                    DEFAULT NULL COMMENT '1,2 (Character/Prefer)',
  `Name`        varchar(5) COLLATE utf8mb4_unicode_ci  DEFAULT NULL,
  `Icon`        varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '再討論',
  `IsShow`      tinyint                                DEFAULT NULL,
  `CreateTime`  datetime                               DEFAULT NULL,
  `Update_Time` datetime                               DEFAULT NULL,
  `Delete_Time` datetime                               DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='個性標籤和偏好';

/*Table structure for table `chat_message` */

DROP TABLE IF EXISTS `chat_message`;

CREATE TABLE `chat_message`
(
  `Id`          int NOT NULL AUTO_INCREMENT COMMENT '依據接送訊息者上線時間回寫訊息？',
  `chatroom_Id` int                                     DEFAULT NULL,
  `Sender`      int                                     DEFAULT NULL,
  `Receiver`    int                                     DEFAULT NULL,
  `Content`     varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Send_Time`   datetime                                DEFAULT NULL,
  `Read_Time`   datetime                                DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='訊息';

/*Table structure for table `chatroom` */

DROP TABLE IF EXISTS `chatroom`;

CREATE TABLE `chatroom`
(
  `Cid`         int      NOT NULL AUTO_INCREMENT,
  `Member1`     int      NOT NULL,
  `Member2`     int      NOT NULL,
  `Create_Time` datetime DEFAULT NULL COMMENT '此欄位是指聊天室成立的時間',
  `IsOpen`      tinyint  DEFAULT NULL,
  `ValidTime`   datetime NOT NULL COMMENT '關閉時間\n"如果是報修：修復完成後+24hrs?\n如果是預約取消：取消時間+24hrs\n如果是預約：看房時間+14days\n如果被室友婉拒，則立即invalid?"',
  PRIMARY KEY (`Cid`, `Member1`, `Member2`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

/*Table structure for table `contract` */

DROP TABLE IF EXISTS `contract`;

CREATE TABLE `contract`
(
  `Id`             int NOT NULL,
  `Status`         int NOT NULL COMMENT '0123',
  `PDF`            varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'LINK',
  `Room_Number`    varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Room_Type`      varchar(2) COLLATE utf8mb4_unicode_ci  DEFAULT NULL,
  `Tenant_Id`      int                                    DEFAULT NULL,
  `Payment_Status` varchar(5) COLLATE utf8mb4_unicode_ci  DEFAULT NULL COMMENT '繳費狀態',
  `Check_Fee`      tinyint                                DEFAULT NULL COMMENT '費用點清',
  `Check_Status`   tinyint                                DEFAULT NULL COMMENT '點交狀態',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Room_Number_UNIQUE` (`Room_Number`),
  UNIQUE KEY `Tenant_Id_UNIQUE` (`Tenant_Id`),
  UNIQUE KEY `PDF_UNIQUE` (`PDF`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

/*Table structure for table `faq` */

DROP TABLE IF EXISTS `faq`;

CREATE TABLE `faq`
(
  `Id`             int NOT NULL,
  `Question`       varchar(45) DEFAULT NULL,
  `Answer`         varchar(45) DEFAULT NULL COMMENT 'link',
  `Publish_Time`   datetime    DEFAULT NULL,
  `Unpublish_Time` datetime    DEFAULT NULL COMMENT '0表示永遠上架',
  `IsShow`         tinyint     DEFAULT '0' COMMENT '0表示關閉',
  `Create_Time`    datetime    DEFAULT NULL,
  `Update_Time`    datetime    DEFAULT NULL,
  `Delete_Time`    datetime    DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IsShow_UNIQUE` (`IsShow`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

/*Table structure for table `fix` */

DROP TABLE IF EXISTS `fix`;

CREATE TABLE `fix`
(
  `Id`              int                                    NOT NULL,
  `Room_Number`     varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Applicant`       varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '申請人',
  `Phone`           varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Create_Time`     datetime                               NOT NULL,
  `Expection_Time`  datetime                               NOT NULL COMMENT '預期修繕時間',
  `Fix_Time`        datetime                                        DEFAULT NULL COMMENT '確認修繕日期',
  `Finish_Time`     datetime                                        DEFAULT NULL COMMENT '完成修繕日期',
  `Project`         varchar(5) COLLATE utf8mb4_unicode_ci           DEFAULT NULL COMMENT '維修項目',
  `Note`            varchar(150) COLLATE utf8mb4_unicode_ci         DEFAULT NULL,
  `Status`          int                                    NOT NULL DEFAULT '0' COMMENT '0 未處理\n\n123分別是....',
  `Amount`          int                                             DEFAULT NULL,
  `Chatroom_number` int                                             DEFAULT NULL COMMENT 'FK',
  PRIMARY KEY (`Id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='報修管理';

/*Table structure for table `guarantor` */

DROP TABLE IF EXISTS `guarantor`;

CREATE TABLE `guarantor`
(
  `UId`         int                                                          NOT NULL DEFAULT '1',
  `Member_Id`   int                                                          NOT NULL COMMENT '對應member id',
  `Name`        varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Id_Number`   varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Phone`       varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Adress`      varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Relation`    varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci           DEFAULT NULL,
  `Create_Time` datetime                                                              DEFAULT NULL,
  `Update_Time` datetime                                                              DEFAULT NULL,
  PRIMARY KEY (`UId`),
  UNIQUE KEY `UId_UNIQUE` (`UId`),
  UNIQUE KEY `Member_Id_UNIQUE` (`Member_Id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='保證人';

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member`
(
  `UId`         int                                                          NOT NULL DEFAULT '1',
  `Name`        varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Gender`      varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
  `Phone`       varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Id_Number`   varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '身分證',
  `Mail`        varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Password`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Address`     varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Nickname`    varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
  `State`       tinyint                                                               DEFAULT '1' COMMENT '1是表是目前帳號狀態:開通\n0表示表示未開通\n\n留著做以後,若是註冊時需要驗證信箱用,如果這樣的default要改成0',
  `Code`        varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci           DEFAULT NULL COMMENT '驗證時的密碼',
  `School`      varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL,
  `Pic`         int                                                                   DEFAULT NULL,
  `Signature_1` int                                                                   DEFAULT NULL,
  `Signature_2` int                                                                   DEFAULT NULL,
  `Signature_3` int                                                                   DEFAULT NULL,
  `Favor_1`     int                                                                   DEFAULT NULL,
  `Favor_2`     int                                                                   DEFAULT NULL,
  `Favor_3`     int                                                                   DEFAULT NULL,
  `Pair_1`      int                                                                   DEFAULT NULL,
  `Pair_2`      int                                                                   DEFAULT NULL,
  `Pair_3`      int                                                                   DEFAULT NULL,
  `Pair_4`      int                                                                   DEFAULT NULL,
  `Pair_5`      int                                                                   DEFAULT NULL,
  `Open_Tag`    tinyint                                                               DEFAULT '0',
  `Create_Time` datetime                                                              DEFAULT NULL,
  `Update_Time` datetime                                                              DEFAULT NULL,
  `Last_IP`     varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL,
  PRIMARY KEY (`UId`),
  UNIQUE KEY `Mail_UNIQUE` (`Mail`),
  UNIQUE KEY `UId_UNIQUE` (`UId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='會員註冊';

/*Table structure for table `property_management` */

DROP TABLE IF EXISTS `property_management`;

CREATE TABLE `property_management`
(
  `UId`      int NOT NULL                                                 DEFAULT '1',
  `Name`     varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Phone`    varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Adress`   varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Mail`     varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Stamp`    varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '公司章 link',
  PRIMARY KEY (`UId`),
  UNIQUE KEY `UId_UNIQUE` (`UId`),
  UNIQUE KEY `Password_UNIQUE` (`Password`),
  UNIQUE KEY `Mail_UNIQUE` (`Mail`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='物業資訊 \n';

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room`
(
  `Rid`             int                                                          NOT NULL AUTO_INCREMENT,
  `RoomId`          varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Building`        varchar(2) COLLATE utf8mb4_unicode_ci                        NOT NULL,
  `Floor`           int                                                          NOT NULL,
  `Location`        varchar(2) COLLATE utf8mb4_unicode_ci                        NOT NULL,
  `RoomType`        varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL,
  `Tenant_Number`   int DEFAULT NULL,
  `Contract_Number` int DEFAULT NULL,
  PRIMARY KEY (`Rid`),
  UNIQUE KEY `Room_Number_UNIQUE` (`RoomId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='房間';

/*Table structure for table `roomtype` */

DROP TABLE IF EXISTS `roomtype`;

CREATE TABLE `roomtype`
(
  `Type`            varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Name`            varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Total`           int                                                         NOT NULL,
  `Price`           int                                                          DEFAULT NULL,
  `Size`            varchar(6) COLLATE utf8mb4_unicode_ci                        DEFAULT NULL,
  `Balcony`         tinyint                                                      DEFAULT NULL,
  `Pic1`            varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Pic2`            varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Pic3`            varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `TV`              int                                                          DEFAULT '1',
  `Refrigerator`    int                                                          DEFAULT '1',
  `AirCondition`    int                                                          DEFAULT '1',
  `Heater`          int                                                          DEFAULT '1',
  `Mirror`          int                                                          DEFAULT '1',
  `Flow_Table`      int                                                          DEFAULT '1',
  `Side_Table_S`    int                                                          DEFAULT NULL,
  `Side_Table_L`    int                                                          DEFAULT NULL,
  `Bed_Board_S`     int                                                          DEFAULT NULL,
  `Bed_Board_L`     int                                                          DEFAULT NULL,
  `Desk_S`          int                                                          DEFAULT NULL,
  `Desk_L`          int                                                          DEFAULT NULL,
  `Bed_S`           int                                                          DEFAULT NULL,
  `Bed_L`           int                                                          DEFAULT NULL,
  `Window_Screen_S` int                                                          DEFAULT NULL,
  `Window_Screen_L` int                                                          DEFAULT NULL,
  `Window_Screen_G` int                                                          DEFAULT NULL,
  `Wardrobe`        int                                                          DEFAULT NULL,
  `Chair`           int                                                          DEFAULT NULL,
  PRIMARY KEY (`Type`),
  UNIQUE KEY `Rid_UNIQUE` (`Type`),
  UNIQUE KEY `name_UNIQUE` (`Name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store`
(
  `Uid`             int NOT NULL,
  `Name`            varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL,
  `Open_Hour`       varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL,
  `Phone`           varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL,
  `Adress`          varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL,
  `Social_link`     varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL,
  `Img`             varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'link \n連結字串，指定到某個圖片檔，沒有圖片需指到預設圖片',
  `Describe`        varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Conclusion_Link` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '連結字串？',
  `Order`           int                                                           DEFAULT NULL COMMENT '1/2/3，如果有兩則都是1，則以上架時間愈新的為主',
  `IsShow`          tinyint                                                       DEFAULT NULL,
  `Publish_Time`    datetime                                                      DEFAULT NULL,
  `Unpublish_Time`  datetime                                                      DEFAULT NULL COMMENT '空白表示：永遠上架',
  `Create_Time`     datetime                                                      DEFAULT NULL,
  `Update_Time`     datetime                                                      DEFAULT NULL,
  `Delete_Time`     datetime                                                      DEFAULT NULL,
  PRIMARY KEY (`Uid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='商家';

/*Table structure for table `tenant` */

DROP TABLE IF EXISTS `tenant`;

CREATE TABLE `tenant`
(
  `UId`             int NOT NULL                           DEFAULT '1',
  `Member_Id`       int NOT NULL COMMENT 'FK',
  `Contract_Number` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'FK',
  `Begin_Time`      date                                   DEFAULT NULL,
  `End_Time`        date                                   DEFAULT NULL,
  `Room_Number`     varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'FK',
  `Deposit`         int                                    DEFAULT NULL,
  PRIMARY KEY (`UId`),
  UNIQUE KEY `UId_UNIQUE` (`UId`),
  UNIQUE KEY `Member_Id_UNIQUE` (`Member_Id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='租客';

/*Table structure for table `furniture_price` */

DROP TABLE IF EXISTS `furniture_price`;

CREATE TABLE `furniture_price`
(
  `Id`    int NOT NULL AUTO_INCREMENT,
  `Name`  varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Price` int                                    DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 20
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
