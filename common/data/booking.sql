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
(1,STR_TO_DATE("2022-09-15","%Y-%m-%d"),'13:00-13:30','姜曉','0936-299-416','單人房A','高樓層','輝'),
(2,STR_TO_DATE("2022-09-15","%Y-%m-%d"),'14:00-14:30','成奇勳','0930-457-126','單人房C','高樓層','軒'),
(3,STR_TO_DATE("2022-09-16","%Y-%m-%d"),'13:30-14:00','盧家輝','0939-099-296','雙人房B','低樓層','玄'),
(4,STR_TO_DATE("2022-09-17","%Y-%m-%d"),'15:30-16:00','張家輝','0958-656-858','單人房A','中樓層','輝'),
(5,STR_TO_DATE("2022-09-17","%Y-%m-%d"),'16:30-17:00','梁家輝','0970-723-789','單人房B','高樓層','軒'),
(6,STR_TO_DATE("2022-09-18","%Y-%m-%d"),'14:30-15:00','陳彥中','0912-122-422','雙人房A','高樓層','輝'),
(7,STR_TO_DATE("2022-09-19","%Y-%m-%d"),'13:30-14:00','權伍中','0928-163-459','雙人房C','高樓層','軒'),
(8,STR_TO_DATE("2022-09-20","%Y-%m-%d"),'15:00-15:30','吳志明','0988-125-478','雙人房A','高樓層','輝'),
(9,STR_TO_DATE("2022-09-23","%Y-%m-%d"),'15:30-16:00','許英蘭','02-2863-4782','單人房C','高樓層','玄'),
(10,STR_TO_DATE("2022-09-23","%Y-%m-%d"),'13:00-13:30','表仁鋒','0935-325-415','單人房A','高樓層','軒'),
(11,STR_TO_DATE("2022-09-24","%Y-%m-%d"),'16:00-16:30','李昌勳','0988-788-258','雙人房B','高樓層','輝'),
(12,STR_TO_DATE("2022-09-25","%Y-%m-%d"),'14:30-15:00','朴美月','0936-880-843','單人房B','高樓層','玄'),
(13,STR_TO_DATE("2022-09-26","%Y-%m-%d"),'15:30-16:00','金素妍','02-2634-1258','雙人房C','高樓層','輝'),
(14,STR_TO_DATE("2022-09-26","%Y-%m-%d"),'16:30-17:00','蕭亞軒','0957-423-899','單人房C','高樓層','玄'),
(15,STR_TO_DATE("2022-09-26","%Y-%m-%d"),'16:30-17:00','吳芳','02-2299-9979','單人房A','高樓層','軒');

