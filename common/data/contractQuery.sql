USE  wulidb;

DROP TABLE IF EXISTS contract;
-- contract
CREATE TABLE contract 
  (   CID INT ,
 `Status` VARCHAR(5),
 `Name` VARCHAR(25),
 Room_Number VARCHAR(25),
 Room_Type VARCHAR(25), 
 Payment_Status VARCHAR(25),
 Check_Fee VARCHAR(25), 
 Check_Status VARCHAR(25),
 PDF VARCHAR(25),
 Signed_Date VARCHAR(25),
 Deposit VARCHAR(25),
 Hide TINYINT DEFAULT 1, 
 MemberID INT ,
 PRIMARY KEY(CID)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci;
INSERT INTO contract(CID,`Status`,`Name`,Room_Number,Room_Type,Payment_Status,Check_Fee,Check_Status,PDF,Signed_Date,Deposit,MemberID)
VALUES 
(10,'已退租','羅凱吉','EL01F1A','單人房A','已繳','未結算','未點交','100EP01F1A','2022-02-02','未退款',1),
(2,'已退租','林伯威','EL01F1B ','單人房C','未繳','未結算','已點交','100EP01F1B','2022-02-03','未退款',2),
(3,'已退租','陳上華','EL01F1C','雙人房B','未繳','未結算','已點交','100EP01F1C','2022-02-04','未退款',3),
(4,'租賃中','劉智澄','EL01F1D','單人房A','未繳','未結算','已點交','100EP01F1D','2022-02-05','未退款',4),
(5,'租賃中','盧家輝','EL01F1E','單人房B','未繳','未結算','已點交','100EP01F1E','2022-02-06','未退款',5),
(16,'租賃中','林伯彥','EL01F1F','雙人房A','未繳','未結算','已點交','100EP01F1F','2022-02-07','未退款',6),
(17,'租賃中','楊嘉琦','EL01F1G','雙人房C','未繳','已結算','已點交','100EP01F1G','2022-02-11','已退款',7),
(18,'租約到期','林祐德','EL01F1W','雙人房A','未繳','已結算','已點交','100EP01F1X','2022-02-12','已退款',8),
(19,'租約到期','潘嘉祥','EL01F1G','單人房C','已繳','已結算','已點交','100EP01F1W','2022-02-13','已退款',9),
(20,'租約到期','蔡東崙','EL01F1H','單人房A','已繳','已結算','已點交','100EP01F1E','2022-02-14','已退款',10),
(11,'已退租','許俊偉','EL01F1X','雙人房B','已繳','已結算','未點交','100EP01F1G','2022-02-15','已退款',11),
(12,'已退租','林志偉','EL01F1V','單人房B','已繳','已結算','未點交','100EP01F1H','2022-02-16','已退款',12),
(13,'已退租','陳秀萍','EL01F1N','雙人房C','未繳','已結算','未點交','100EP01F1J','2022-02-17','未退款',13),
(14,'租約到期','庭葦','EL01F1H','單人房C','未繳','未結算','未點交','100EP01F1A','2022-02-22','未退款',14),
(15,'租約到期','周采玲','EL01F1R','單人房A','已繳','未結算','未點交','100EP01F1B','2022-02-23','未退款',15);