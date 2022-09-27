USE  wulidb;

DROP TABLE IF EXISTS contractRoom_TypeItems;
-- contract
CREATE TABLE contractRoom_TypeItems 
  (  Room_Type VARCHAR(10) ,
     TV INT,
     WaterHeater INT,
     Airconditioner INT,
  Freezer INT ,
  Screen INT ,
  Chair INT ,
  SingleBed INT,
  DoubleBed INT ,
  SmallDesk INT,
  BigDesk INT ,
  SmallSideTable INT,
  BigSideTable INT,
  Wardrobe INT
  ) ENGINE=INNODB DEFAULT CHARSET=utf8 DEFAULT COLLATE utf8_unicode_ci;
  INSERT INTO contractRoom_TypeItems(Room_Type,TV,WaterHeater,Airconditioner,Freezer,Screen,Chair,SingleBed,DoubleBed,SmallDesk,BigDesk,SmallSideTable,BigSideTable,Wardrobe)
  VALUES 
('單人房A',1,1,1,1,1,1,0,1,0,1,0,1,1),
('單人房B',1,1,1,1,1,1,0,1,0,1,0,1,1),
('單人房C',1,1,1,1,1,1,0,1,0,1,0,1,2),
('雙人房A',1,1,1,1,1,2,2,0,2,0,2,0,2),
('雙人房B',1,1,1,1,1,2,2,0,2,0,2,0,2),
('雙人房C',1,1,1,1,1,2,0,2,0,2,0,2,2);