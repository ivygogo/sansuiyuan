CREATE DATABASE IF NOT EXISTS `wulidb`;

USE `wulidb`;

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

/*Data for the table `furniture_price` */

insert into `furniture_price`(`Id`, `Name`, `Price`)
values (1, 'TV', 11000),
       (2, 'Refrigerator', 10500),
       (3, 'AirCondition', NULL),
       (4, 'Heater', NULL),
       (5, 'Mirror', 900),
       (6, 'Flow_Table', 600),
       (7, 'Side_Table_S', 3300),
       (8, 'Side_Table_L', 3500),
       (9, 'Bed_Board_S', 1800),
       (10, 'Bed_Board_L', 2000),
       (11, 'Desk_S', 3400),
       (12, 'Desk_L', 3600),
       (13, 'Bed_S', 3300),
       (14, 'Bed_L', 3500),
       (15, 'Window_Screen_S', 1600),
       (16, 'Window_Screen_L', 2000),
       (17, 'Window_Screen_G', 2000),
       (18, 'Wardrobe', 4500),
       (19, 'Chair', 1800);
