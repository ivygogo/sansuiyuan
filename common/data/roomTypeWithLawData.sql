CREATE DATABASE IF NOT EXISTS `wulidb`;

USE `wulidb`;

DROP TABLE IF EXISTS `roomtype`;

CREATE TABLE `roomtype`
(
  `Type`            varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'A-F',
  `Name`            varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '單人房A/雙人A',
  `Total`           int                                                         NOT NULL COMMENT '該房型的總共數量',
  `Price`           int                                                          DEFAULT NULL,
  `Size`            varchar(6) COLLATE utf8mb4_unicode_ci                        DEFAULT NULL,
  `Balcony`         tinyint                                                      DEFAULT NULL,
  `Pic1`            varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Pic2`            varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Pic3`            varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '格局link',
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
  COLLATE = utf8mb4_unicode_ci COMMENT ='房型,Q開頭的是數量 / P開頭的是價格';

/*Data for the table `roomtype` */

insert into `roomtype`(`Type`, `Name`, `Total`, `Price`, `Size`, `Balcony`, `Pic1`, `Pic2`, `Pic3`,
                       `TV`, `Refrigerator`, `AirCondition`, `Heater`, `Mirror`, `Flow_Table`,
                       `Side_Table_S`, `Side_Table_L`, `Bed_Board_S`, `Bed_Board_L`, `Desk_S`,
                       `Desk_L`, `Bed_S`, `Bed_L`, `Window_Screen_S`, `Window_Screen_L`,
                       `Window_Screen_G`, `Wardrobe`, `Chair`)
values ('A', '單人房A', 64, 7800, '5 ~ 7', 0, 'SingleA1.jpg', 'SingleA2.jpg', 'SingleA3.jpg', 1, 1, 1,
        1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, NULL, NULL, NULL, 1, 1),
       ('B', '單人房B', 64, 8300, '5 ~ 7', 1, 'SingleB1.jpg', 'SingleB2.jpg', 'SingleB3.jpg', 1, 1, 1,
        1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, NULL, NULL, NULL, 1, 1),
       ('C', '單人房C', 64, 8500, '5 ~ 7', 1, 'SingleC1.jpg', 'SingleC2.jpg', 'SingleC3.jpg', 1, 1, 1,
        1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, NULL, NULL, NULL, 2, 1),
       ('D', '雙人房A', 64, 9500, '8 ~ 10', 0, 'DoubleA1.jpg', 'DoubleA2.jpg', 'DoubleA2.jpg', 1, 1, 1,
        1, 1, 1, 2, 0, 2, 0, 2, 0, 2, 0, NULL, NULL, NULL, 2, 2),
       ('E', '雙人房B', 64, 10000, '8 ~ 10', 1, 'DoubleB1.jpg', 'DoubleB2.jpg', 'DoubleB3.jpg', 1, 1,
        1, 1, 1, 1, 2, 0, 2, 0, 2, 0, 2, 0, NULL, NULL, NULL, 2, 2),
       ('F', '雙人房C', 64, 10500, '8 ~ 10', 1, 'DoubleC1.jpg', 'DoubleC2.jpg', 'DoubleC3.jpg', 1, 1,
        1, 1, 1, 1, 0, 2, 2, 0, 0, 2, 2, 0, NULL, NULL, NULL, 2, 2);
