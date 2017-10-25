-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	5.6.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `t_callrecord`
--

DROP TABLE IF EXISTS `t_callrecord`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_callrecord` (
  `call_record_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `patient_id`     INT(11)          NOT NULL,
  `patient_name`   VARCHAR(45)      NOT NULL,
  `nurse_id`       INT(11)          NOT NULL,
  `nurse_name`     VARCHAR(45)               DEFAULT NULL,
  `status`         TINYINT(1)       NOT NULL,
  PRIMARY KEY (`call_record_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_heartrate`
--

DROP TABLE IF EXISTS `t_heartrate`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_heartrate` (
  `heartrate_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `value`        INT(11)          NOT NULL,
  `patient_id`   INT(11)          NOT NULL,
  `patient_name` VARCHAR(45)      NOT NULL,
  `record_time`  DATETIME         NOT NULL,
  `hour`         INT(11)          NOT NULL,
  `minute`       INT(11)          NOT NULL,
  PRIMARY KEY (`heartrate_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_nurse`
--

DROP TABLE IF EXISTS `t_nurse`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_nurse` (
  `nurse_id`   INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nurse_name` VARCHAR(45)      NOT NULL,
  PRIMARY KEY (`nurse_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_patient`
--

DROP TABLE IF EXISTS `t_patient`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_patient` (
  `patient_id`   INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `patient_name` VARCHAR(45)      NOT NULL,
  `stage_num`    INT(11)          NOT NULL,
  `room_num`     INT(11)          NOT NULL,
  `bed_num`      INT(11)          NOT NULL,
  `checkin_time` DATETIME                  DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_temperature`
--

DROP TABLE IF EXISTS `t_temperature`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_temperature` (
  `temperature_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `value`          DOUBLE           NOT NULL,
  `patient_id`     INT(11)          NOT NULL,
  `patient_name`   VARCHAR(45)      NOT NULL,
  `record_time`    DATETIME         NOT NULL,
  `hour`           INT(11)          NOT NULL,
  `minute`         INT(11)          NOT NULL,
  PRIMARY KEY (`temperature_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2017-10-21 18:58:43

DROP TABLE IF EXISTS `t_alarm`;
CREATE TABLE `t_alarm` (
  `alarm_id`       INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `patient_id`     INT(11)          NOT NULL,
  `hour`           INT(11)          NOT NULL,
  `minute`         INT(11)          NOT NULL,
  `is_shock`       TINYINT(1)       NOT NULL,
  `repeat_content` VARCHAR(45)      NULL,
  `is_on`          TINYINT(1)       NOT NULL,
  PRIMARY KEY (`alarm_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;