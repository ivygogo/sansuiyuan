CREATE DATABASE IF NOT EXISTS `wulidb`;

USE  wulidb;

DROP TABLE IF EXISTS `BookingExample`;

-- `bookingexample`
CREATE TABLE BookingExample 
  (   Booker_Id INT ,
  Book_Date DATE,
  Prefer_Time VARCHAR(32),   
  Booker_Name VARCHAR(32),
  Booker_Phone VARCHAR(15), 
  Roomtype VARCHAR(10),
  Prefer_Floor VARCHAR(10), 
  Lead_Person VARCHAR(10),
  PRIMARY KEY(Booker_Id)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci;
  
INSERT INTO BookingExample(Booker_Id,Book_Date,Prefer_Time,Booker_Name,Booker_Phone,Roomtype,Prefer_Floor,Lead_Person)
VALUES 
(1,STR_TO_DATE("2022-09-15","%Y-%m-%d"),'13:00-13:30','姜曉','0930-123-456','A','高樓層','輝'),
(2,STR_TO_DATE("2022-09-15","%Y-%m-%d"),'13:00-13:30','成奇勳','0930-456-456','C','高樓層','吳'),
(3,STR_TO_DATE("2022-09-16","%Y-%m-%d"),'13:30-14:00','盧家輝','0930-578-456','B','低樓層','吳'),
(4,STR_TO_DATE("2022-09-17","%Y-%m-%d"),'15:00-15:30','張家輝','0930-666-456','E','中樓層','輝'),
(5,STR_TO_DATE("2022-09-17","%Y-%m-%d"),'15:00-15:30','梁家輝','0930-123-999','E','高樓層','輝');

CREATE TABLE BookingExample 
  (  	Book_Date DATE,
	Prefer_Time VARCHAR(32),  
	Booker_Id VARCHAR(32), 
	Booker_Name VARCHAR(32),
	Booker_Phone VARCHAR(15), 
	Roomtype VARCHAR(10),
	Prefer_Floor VARCHAR(10), 
	Lead_Person VARCHAR(10),
	PRIMARY KEY(Booker_Id)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci;
  
INSERT INTO BookingExample(Book_Date,Prefer_Time,Booker_Id,Booker_Name,Booker_Phone,Roomtype,Prefer_Floor,Lead_Person)
VALUES 
(STR_TO_DATE("2022-09-15","%Y-%m-%d"),'13:00-13:30','AA001','姜曉','0930-123-456','A','高樓層','輝'),
(STR_TO_DATE("2022-09-15","%Y-%m-%d"),'13:00-13:30','AA002','成奇勳','0930-456-456','C','高樓層','吳'),
(STR_TO_DATE("2022-09-16","%Y-%m-%d"),'13:30-14:00','BB009','盧家輝','0930-578-456','B','低樓層','吳'),
(STR_TO_DATE("2022-09-17","%Y-%m-%d"),'15:00-15:30','CC008','張家輝','0930-666-456','E','中樓層','輝'),
(STR_TO_DATE("2022-09-17","%Y-%m-%d"),'15:00-15:30','DD009','梁家輝','0930-123-999','E','高樓層','輝');

