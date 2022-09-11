CREATE DATABASE IF NOT EXISTS `wulidb`;

USE `wulidb`;

DROP TABLE IF EXISTS `chatroom`;

CREATE TABLE `chatroom`
(
  `Id`          int      NOT NULL AUTO_INCREMENT,
  `Chat_type`   varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Repair/Friend/Booking',
  `Member1`     int      NOT NULL,
  `Member2`     int      NOT NULL,
  `Create_Time` datetime                                                    DEFAULT NULL COMMENT '此欄位是指聊天室成立的時間',
  `Close_Time`  datetime NOT NULL COMMENT '關閉時間\n"如果是報修：修復完成後+24hrs?\n如果是預約取消：取消時間+24hrs\n如果是預約：看房時間+14days\n如果被室友婉拒，則立即invalid?"',
  `IsOpen`      tinyint                                                     DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

/*Data for the table `chatroom` */

insert into `chatroom`(`Id`, `Chat_type`, `Member1`, `Member2`, `Create_Time`, `Close_Time`,
                       `IsOpen`)
values (1, 'B', 0, 1, '2022-09-06 14:37:35', '2022-09-20 14:37:17', 1),
       (2, 'B', 0, 2, '2022-08-24 14:37:59', '2022-09-05 14:38:10', 0),
       (3, 'R', 0, 3, '2022-09-05 14:38:30', '2023-09-06 14:39:00', 1),
       (4, 'R', 0, 4, '2022-08-08 14:39:19', '2022-09-04 14:39:24', 0),
       (5, 'F', 1, 2, '2022-09-04 14:39:47', '2022-09-07 14:39:53', 1),
       (6, 'F', 1, 3, '2022-09-04 14:42:05', '2022-09-10 14:42:12', 1),
       (7, 'F', 1, 4, '2022-09-05 14:42:28', '2022-09-30 14:42:38', 1),
       (8, 'F', 2, 3, '2022-09-05 14:43:10', '2022-09-16 14:43:27', 1);
