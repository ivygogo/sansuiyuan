package tw.edu.ntut.sce.java18.common.utils;

public class DBService {
  public static final String DB_TYPE = "MYSQL";
  public static final String host = "127.0.0.1";
  public static final String USERID = "admin";
  public static final String PSWD = "admin123";
  public static final String DBNAME = "wulidb";
  public static final String JNDI_DB_NAME = "java:comp/env/jdbc/wuliDataMySQL";
  private static final String DBURL = "jdbc:mysql://" + host + "/";

  private static final String DBTABLEURL =
      "jdbc:mysql://"
          + host
          + "/"
          + DBNAME
          + "?useUnicode=yes&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Taipei&allowPublicKeyRetrieval=true";

  private static final String DROP_Banner = "DROP Table IF EXISTS banner ";
  private static final String DROP_Board = "DROP Table IF EXISTS board ";
  private static final String DROP_Booking = "DROP TABLE IF EXISTS booking";
  private static final String DROP_Character_Favor = "DROP Table IF EXISTS character_favor ";
  private static final String DROP_Chat_Message = "DROP TABLE IF EXISTS chat_message";
  private static final String DROP_Chatroom = "DROP TABLE IF EXISTS chatroom";
  private static final String DROP_Contract = "DROP TABLE IF EXISTS contract";
  private static final String DROP_Faq = "DROP TABLE IF EXISTS faq";
  private static final String DROP_fix = "DROP TABLE IF EXISTS fix";
  private static final String DROP_Guarantor = "DROP TABLE IF EXISTS guarantor";
  private static final String DROP_Member = "DROP TABLE IF EXISTS member";
  private static final String DROP_Property_Management = "DROP TABLE IF EXISTS property_management";
  private static final String DROP_Room = "DROP TABLE IF EXISTS room";
  private static final String DROP_Roomtype = "DROP TABLE IF EXISTS roomtype";
  private static final String DROP_Store = "DROP TABLE IF EXISTS store";
  private static final String DROP_Tenant = "DROP TABLE IF EXISTS tenant";
  private static final String DROP_Refund = "DROP TABLE IF EXISTS refund_account";

  private static final String CREATE_Banner =
      "CREATE TABLE `banner` ("
          + "  `Id` int NOT NULL AUTO_INCREMENT,"
          + "  `Name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `Img` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'link',"
          + "  `Describe` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,"
          + "  `Sub_Describe` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,"
          + "  `Link` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,"
          + "  `Order` int DEFAULT NULL COMMENT '1/2/3????????????????????????1????????????????????????????????????',"
          + "  `Publish_Time` datetime DEFAULT NULL,"
          + "  `UnPublish_Time` datetime DEFAULT NULL,"
          + "  `Ishow` tinyint DEFAULT '0' COMMENT '0???1????????????0',"
          + "  `CREATE_Time` datetime DEFAULT NULL,"
          + "  `Update_time` datetime DEFAULT NULL,"
          + "  `Delete_Time` datetime DEFAULT NULL,"
          + "  PRIMARY KEY (`Id`)"
          + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci";

  private static final String CREATE_Board =
      "CREATE TABLE `board` (  `Id` int NOT NULL AUTO_INCREMENT,  `Class` varchar(5) COLLATE"
          + " utf8mb4_unicode_ci DEFAULT NULL,  `IsComment` varchar(45) COLLATE utf8mb4_unicode_ci"
          + " DEFAULT NULL COMMENT '??????1?????????,???????????????',  `Poster_Id` int DEFAULT NULL COMMENT 'fk', "
          + " `Poster_Nickname` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'from"
          + " member',  `Content` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL, "
          + " `CREATE_Time` datetime DEFAULT NULL,  `Update_Time` datetime DEFAULT NULL,  `Views`"
          + " int DEFAULT NULL,  `Comments` int DEFAULT NULL,  PRIMARY KEY (`Id`),  UNIQUE KEY"
          + " `Id_UNIQUE` (`Id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci";

  private static final String CREATE_Booking =
      "CREATE TABLE `booking` ("
          + "  `Id` int NOT NULL,"
          + "  `Booker_Id` int NOT NULL,"
          + "  `Roomtype` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `Book_Date` date NOT NULL,"
          + "  `Prefer_Time` time NOT NULL,"
          + "  `Prefer_Floor` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,"
          + "  `Chatroom_number` int DEFAULT NULL,"
          + "  `Lead_person` int DEFAULT NULL,"
          + "  `CREATE_Time` datetime DEFAULT NULL,"
          + "  `IsCancel` tinyint DEFAULT NULL COMMENT '??????????????????????????????',"
          + "  `Cancle_Time` datetime DEFAULT NULL,"
          + "  `Update_Time` datetime DEFAULT NULL COMMENT '??????????????????????????????',"
          + "  PRIMARY KEY (`Id`)"
          + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci";

  private static final String CREATE_Character_Favor =
      "CREATE TABLE `character_favor` ("
          + "  `ID` int NOT NULL AUTO_INCREMENT,"
          + "  `Type` int DEFAULT NULL COMMENT '1,2 (Character/Prefer)',"
          + "  `Name` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL,"
          + "  `Icon` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '?????????',"
          + "  `IsShow` tinyint DEFAULT NULL,"
          + "  `CreateTime` datetime DEFAULT NULL,"
          + "  `Update_Time` datetime DEFAULT NULL,"
          + "  `Delete_Time` datetime DEFAULT NULL,"
          + "  PRIMARY KEY (`ID`),"
          + "  UNIQUE KEY `ID_UNIQUE` (`ID`)"
          + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='?????????????????????'";

  private static final String CREATE_Chat_Message =
      "CREATE TABLE `chat_message` ("
          + "  `Id` int NOT NULL AUTO_INCREMENT COMMENT '????????????????????????????????????????????????',"
          + "  `chatroom_Id` int DEFAULT NULL,"
          + "  `Sender` int DEFAULT NULL,"
          + "  `Receiver` int DEFAULT NULL,"
          + "  `Content` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,"
          + "  `Send_Time` datetime DEFAULT NULL,"
          + "  `Read_Time` datetime DEFAULT NULL,"
          + "  PRIMARY KEY (`Id`)"
          + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='??????'";

  private static final String CREATE_Chatroom =
      "CREATE TABLE `chatroom` (  `Cid` int NOT NULL AUTO_INCREMENT,  `Member1` int NOT NULL, "
          + " `Member2` int NOT NULL,  `CREATE_Time` datetime DEFAULT NULL COMMENT '???????????????????????????????????????',"
          + "  `IsOpen` tinyint DEFAULT NULL,  `ValidTime` datetime NOT NULL COMMENT '????????????\\n"
          + "\"?????????????????????????????????+24hrs?\\n"
          + "????????????????????????????????????+24hrs\\n"
          + "??????????????????????????????+14days\\n"
          + "?????????????????????????????????invalid?\"',  PRIMARY KEY (`Cid`,`Member1`,`Member2`)) ENGINE=InnoDB"
          + " DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci";

  private static final String CREATE_Contract =
      "CREATE TABLE `contract` ("
          + "  `Id` int NOT NULL,"
          + "  `Status` int NOT NULL COMMENT '0123',"
          + "  `PDF` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'LINK',"
          + "  `Room_Number` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,"
          + "  `Room_Type` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,"
          + "  `Tenant_Id` int DEFAULT NULL,"
          + "  `Payment_Status` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '????????????',"
          + "  `Check_Fee` tinyint DEFAULT NULL COMMENT '????????????',"
          + "  `Check_Status` tinyint DEFAULT NULL COMMENT '????????????',"
          + "  PRIMARY KEY (`Id`),"
          + "  UNIQUE KEY `Room_Number_UNIQUE` (`Room_Number`),"
          + "  UNIQUE KEY `Tenant_Id_UNIQUE` (`Tenant_Id`),"
          + "  UNIQUE KEY `PDF_UNIQUE` (`PDF`)"
          + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci";

  private static final String CREATE_Faq =
      "CREATE TABLE `faq` ("
          + "  `Id` int NOT NULL,"
          + "  `Question` varchar(45) DEFAULT NULL,"
          + "  `Answer` varchar(45) DEFAULT NULL COMMENT 'link',"
          + "  `Publish_Time` datetime DEFAULT NULL,"
          + "  `Unpublish_Time` datetime DEFAULT NULL COMMENT '0??????????????????',"
          + "  `IsShow` tinyint DEFAULT '0' COMMENT '0????????????',"
          + "  `CREATE_Time` datetime DEFAULT NULL,"
          + "  `Update_Time` datetime DEFAULT NULL,"
          + "  `Delete_Time` datetime DEFAULT NULL,"
          + "  PRIMARY KEY (`Id`),"
          + "  UNIQUE KEY `IsShow_UNIQUE` (`IsShow`)"
          + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";

  private static final String CREATE_fix =
      "CREATE TABLE `fix` ("
          + "  `Id` int NOT NULL,"
          + "  `Room_Number` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `Applicant` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '?????????',"
          + "  `Phone` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `CREATE_Time` datetime NOT NULL,"
          + "  `Expection_Time` datetime NOT NULL COMMENT '??????????????????',"
          + "  `Fix_Time` datetime DEFAULT NULL COMMENT '??????????????????',"
          + "  `Finish_Time` datetime DEFAULT NULL COMMENT '??????????????????',"
          + "  `Project` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '????????????',"
          + "  `Note` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,"
          + "  `Status` int NOT NULL DEFAULT '0' COMMENT '0 ?????????\\n\\n123?????????....',"
          + "  `Amount` int DEFAULT NULL,"
          + "  `Chatroom_number` int DEFAULT NULL COMMENT 'FK',"
          + "  PRIMARY KEY (`Id`)"
          + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='????????????'";

  private static final String CREATE_Guarantor =
      "CREATE TABLE `guarantor` ("
          + "  `UId` int NOT NULL DEFAULT '1',"
          + "  `Member_Id` int NOT NULL COMMENT '??????member id',"
          + "  `Name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `Id_Number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `Phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `Adress` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `Relation` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,"
          + "  `CREATE_Time` datetime DEFAULT NULL,"
          + "  `Update_Time` datetime DEFAULT NULL,"
          + "  PRIMARY KEY (`UId`),"
          + "  UNIQUE KEY `UId_UNIQUE` (`UId`),"
          + "  UNIQUE KEY `Member_Id_UNIQUE` (`Member_Id`)"
          + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='?????????'";

  private static final String CREATE_Member =
      "CREATE TABLE `member` (  `UId` int NOT NULL DEFAULT '1',  `Name` varchar(10) CHARACTER SET"
          + " utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,  `Gender` varchar(5) CHARACTER SET"
          + " utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,  `Phone` varchar(15) CHARACTER SET"
          + " utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,  `Id_Number` varchar(10) CHARACTER SET"
          + " utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '?????????',  `Mail` varchar(45)"
          + " CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,  `Password` varchar(64)"
          + " CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,  `Address` varchar(45)"
          + " CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,  `Nickname` varchar(5)"
          + " CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,  `State` tinyint DEFAULT"
          + " '1' COMMENT '1???????????????????????????:??????\\n"
          + "0?????????????????????\\n"
          + "\\n"
          + "???????????????,????????????????????????????????????,???????????????default?????????0',  `Code` varchar(6) CHARACTER SET utf8mb4 COLLATE"
          + " utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '??????????????????',  `School` varchar(10) CHARACTER SET"
          + " utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,  `Pic` int DEFAULT NULL, "
          + " `Signature_1` int DEFAULT NULL,  `Signature_2` int DEFAULT NULL,  `Signature_3` int"
          + " DEFAULT NULL,  `Favor_1` int DEFAULT NULL,  `Favor_2` int DEFAULT NULL,  `Favor_3`"
          + " int DEFAULT NULL,  `Pair_1` int DEFAULT NULL,  `Pair_2` int DEFAULT NULL,  `Pair_3`"
          + " int DEFAULT NULL,  `Pair_4` int DEFAULT NULL,  `Pair_5` int DEFAULT NULL,  `Open_Tag`"
          + " tinyint DEFAULT '0',  `CREATE_Time` datetime DEFAULT NULL,  `Update_Time` datetime"
          + " DEFAULT NULL,  `Last_IP` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci"
          + " DEFAULT NULL,  PRIMARY KEY (`UId`),  UNIQUE KEY `Mail_UNIQUE` (`Mail`),  UNIQUE KEY"
          + " `UId_UNIQUE` (`UId`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4"
          + " COLLATE=utf8mb4_unicode_ci COMMENT='????????????'";

  private static final String CREATE_Property_Management =
      "CREATE TABLE `property_management` (  `UId` int NOT NULL DEFAULT '1',  `Name` varchar(10)"
          + " CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,  `Password`"
          + " varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,  `Phone`"
          + " varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,  `Adress`"
          + " varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,  `Mail`"
          + " varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,  `Stamp`"
          + " varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT"
          + " '????????? link',  PRIMARY KEY (`UId`),  UNIQUE KEY `UId_UNIQUE` (`UId`),  UNIQUE KEY"
          + " `Password_UNIQUE` (`Password`),  UNIQUE KEY `Mail_UNIQUE` (`Mail`)) ENGINE=InnoDB"
          + " DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='????????????'";

  private static final String CREATE_Room =
      "CREATE TABLE `room` ("
          + "  `Rid` int NOT NULL AUTO_INCREMENT,"
          + "  `Room_Number` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `Building` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `Floor` int NOT NULL,"
          + "  `Location` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `Roomtype_Number` int NOT NULL,"
          + "  `Tenant_Number` int DEFAULT NULL,"
          + "  `Contract_Number` int DEFAULT NULL,"
          + "  PRIMARY KEY (`Rid`),"
          + "  UNIQUE KEY `Room_Number_UNIQUE` (`Room_Number`)"
          + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='??????'";

  private static final String CREATE_Roomtype =
      "CREATE TABLE `roomtype` (  `Rid` int NOT NULL,  `name` varchar(2) CHARACTER SET utf8mb4"
          + " COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'A/B/C...',  `Total` int DEFAULT NULL"
          + " COMMENT '????????????????????????',  `Price` int DEFAULT NULL,  `Size` decimal(3,1) DEFAULT NULL, "
          + " `Balcony` tinyint DEFAULT NULL,  `Pic1` varchar(45) CHARACTER SET utf8mb4 COLLATE"
          + " utf8mb4_0900_ai_ci DEFAULT NULL,  `Pic2` varchar(45) CHARACTER SET utf8mb4 COLLATE"
          + " utf8mb4_0900_ai_ci DEFAULT NULL,  `Pic0` varchar(45) CHARACTER SET utf8mb4 COLLATE"
          + " utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '??????link',  `Q_TV` int DEFAULT '1', "
          + " `Q_Refrigerator` int DEFAULT '1',  `Q_Air_Condition` int DEFAULT '1',  `Q_Heater` int"
          + " DEFAULT '1',  `Q_Mirror` int DEFAULT '1',  `Q_Flow_Table` int DEFAULT '1', "
          + " `Q_Side_Table_S` int DEFAULT NULL,  `Q_Side_Table_L` int DEFAULT NULL, "
          + " `Q_Bed_Board_S` int DEFAULT NULL,  `Q_Bed_Board_L` int DEFAULT NULL,  `Q_Desk_S` int"
          + " DEFAULT NULL,  `Q_Desk_L` int DEFAULT NULL,  `Q_Bed_S` int DEFAULT NULL,  `Q_Bed_L`"
          + " int DEFAULT NULL,  `Q_Windows_Screen_S` int DEFAULT NULL,  `Q_Windows_Screen_L` int"
          + " DEFAULT NULL,  `Q_Windows_Screen_G` int DEFAULT NULL COMMENT '????????????',  `Q_Wardrobe`"
          + " int DEFAULT NULL,  `Q_Chair` int DEFAULT NULL,  `P_TV` int DEFAULT NULL, "
          + " `P_Refrigerator` int DEFAULT NULL,  `P_Air_Condotioner` int DEFAULT NULL,  `P_Heater`"
          + " int DEFAULT NULL,  `P_Mirror` int DEFAULT NULL,  `P_Flow_Table` int DEFAULT NULL, "
          + " `P_Side_Table_S` int DEFAULT NULL,  `P_Side_Table_L` int DEFAULT NULL, "
          + " `P_Bed_Board_S` int DEFAULT NULL,  `P_Bed_Board_L` int DEFAULT NULL,  `P_Desk_S` int"
          + " DEFAULT NULL,  `P_Desk_L` int DEFAULT NULL,  `P_Bed_S` int DEFAULT NULL,  `P_Bed_L`"
          + " int DEFAULT NULL,  `P_Window_Screen_S` int DEFAULT NULL,  `P_Window_Screen_L` int"
          + " DEFAULT NULL,  `P_Window_Screen_G` int DEFAULT NULL,  `P_Wardrobe` int DEFAULT NULL, "
          + " `P_Chair` int DEFAULT NULL,  PRIMARY KEY (`Rid`),  UNIQUE KEY `name_UNIQUE` (`name`),"
          + "  UNIQUE KEY `Rid_UNIQUE` (`Rid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4"
          + " COLLATE=utf8mb4_unicode_ci COMMENT='??????,Q?????????????????? / P??????????????????'";

  private static final String CREATE_Store =
      "CREATE TABLE `store` (  `Uid` int NOT NULL,  `Name` varchar(45) CHARACTER SET utf8mb4"
          + " COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,  `Open_Hour` varchar(45) CHARACTER SET"
          + " utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,  `Phone` varchar(15) CHARACTER SET"
          + " utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,  `Adress` varchar(30) CHARACTER SET"
          + " utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,  `Social_link` varchar(45) CHARACTER"
          + " SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,  `Img` varchar(200) CHARACTER"
          + " SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'link \\n"
          + "???????????????????????????????????????????????????????????????????????????',  `Describe` varchar(500) CHARACTER SET utf8mb4 COLLATE"
          + " utf8mb4_0900_ai_ci DEFAULT NULL,  `Conclusion_Link` varchar(45) CHARACTER SET utf8mb4"
          + " COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '???????????????',  `Order` int DEFAULT NULL"
          + " COMMENT '1/2/3????????????????????????1????????????????????????????????????',  `IsShow` tinyint DEFAULT NULL,  `Publish_Time`"
          + " datetime DEFAULT NULL,  `Unpublish_Time` datetime DEFAULT NULL COMMENT '???????????????????????????', "
          + " `CREATE_Time` datetime DEFAULT NULL,  `Update_Time` datetime DEFAULT NULL, "
          + " `Delete_Time` datetime DEFAULT NULL,  PRIMARY KEY (`Uid`)) ENGINE=InnoDB DEFAULT"
          + " CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='??????'";

  private static final String CREATE_Tenant =
      "CREATE TABLE `tenant` ("
          + "  `UId` int NOT NULL DEFAULT '1',"
          + "  `Member_Id` int NOT NULL COMMENT 'FK',"
          + "  `Contract_Number` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'FK',"
          + "  `Begin_Time` date DEFAULT NULL,"
          + "  `End_Time` date DEFAULT NULL,"
          + "  `Room_Number` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'FK',"
          + "  `Deposit` int DEFAULT NULL,"
          + "  PRIMARY KEY (`UId`),"
          + "  UNIQUE KEY `UId_UNIQUE` (`UId`),"
          + "  UNIQUE KEY `Member_Id_UNIQUE` (`Member_Id`)"
          + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='??????'";

  private static final String CREATE_Refund =
      "CREATE TABLE `refund_account` ("
          + "  `UId` int NOT NULL DEFAULT '1',"
          + "  `Member_Id` int NOT NULL COMMENT '??????member id',"
          + "  `Name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `RrefundBank` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `bankStore` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `Phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `refundName` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,"
          + "  `CreateTime` datetime DEFAULT NULL,"
          + "  `UpdateTime` datetime DEFAULT NULL,"
          + "  PRIMARY KEY (`UId`),"
          + "  UNIQUE KEY `UId_UNIQUE` (`UId`),"
          + "  UNIQUE KEY `Member_Id_UNIQUE` (`Member_Id`)"
          + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='?????????'";

  public static String getDropBanner() {
    return DROP_Banner;
  }

  public static String getDropBoard() {
    return DROP_Board;
  }

  public static String getDropBooking() {
    return DROP_Booking;
  }

  public static String getDropCharacter_Favor() {
    return DROP_Character_Favor;
  }

  public static String getDropChat_Message() {
    return DROP_Chat_Message;
  }

  public static String getDropChatroom() {
    return DROP_Chatroom;
  }

  public static String getDropContract() {
    return DROP_Contract;
  }

  public static String getDropFaq() {
    return DROP_Faq;
  }

  public static String getDropfix() {
    return DROP_fix;
  }

  public static String getDropGuarantor() {
    return DROP_Guarantor;
  }

  public static String getDropMember() {
    return DROP_Member;
  }

  public static String getDropProperty_Management() {
    return DROP_Property_Management;
  }
  ;

  public static String getDropRoom() {
    return DROP_Room;
  }

  public static String getDropRoomtype() {
    return DROP_Roomtype;
  }

  public static String getDropStore() {
    return DROP_Store;
  }

  public static String getDropTenant() {
    return DROP_Tenant;
  }

  public static String getDropRefund() {
    return DROP_Refund;
  }

  public static String getCreateBanner() {
    return CREATE_Banner;
  }

  public static String getCreateBoard() {
    return CREATE_Board;
  }

  public static String getCreateBooking() {
    return CREATE_Booking;
  }

  public static String getCreateCharacter_Favor() {
    return CREATE_Character_Favor;
  }

  public static String getCreateChat_Message() {
    return CREATE_Chat_Message;
  }

  public static String getCreateChatroom() {
    return CREATE_Chatroom;
  }

  public static String getCreateContract() {
    return CREATE_Contract;
  }

  public static String getCreateFaq() {
    return CREATE_Faq;
  }

  public static String getCreatefix() {
    return CREATE_fix;
  }

  public static String getCreateGuarantor() {
    return CREATE_Guarantor;
  }

  public static String getCreateMember() {
    return CREATE_Member;
  }

  public static String getCreateProperty_Management() {
    return CREATE_Property_Management;
  }
  ;

  public static String getCreateRoom() {
    return CREATE_Room;
  }

  public static String getCreateRoomtype() {
    return CREATE_Roomtype;
  }

  public static String getCreateStore() {
    return CREATE_Store;
  }

  public static String getCREATE_Refund() {
    return CREATE_Refund;
  }

  public static String getCreateTenant() {
    return CREATE_Tenant;
  }

  public static String getUser() {
    return USERID;
  }

  public static String getPassword() {
    return PSWD;
  }

  public static String getDbUrl() {
    return DBURL;
  }

  public static String getDbTableUrl() {
    return DBTABLEURL;
  }
}
