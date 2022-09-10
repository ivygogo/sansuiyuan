CREATE DATABASE IF NOT EXISTS `wulidb`;

USE `wulidb`;

DROP TABLE IF EXISTS `chat_message`;

CREATE TABLE `chat_message`
(
  `Id`          int NOT NULL AUTO_INCREMENT,
  `Chatroom_Id` int                                                           DEFAULT NULL,
  `Sender`      int unsigned                                                  DEFAULT NULL,
  `Receiver`    int                                                           DEFAULT NULL,
  `Content`     varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Send_Time`   datetime                                                      DEFAULT NULL,
  `Read`        tinyint                                                       DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 48
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
