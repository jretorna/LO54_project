CREATE DATABASE  IF NOT EXISTS `projet` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `projet`;
-- MySQL dump 10.13  Distrib 5.5.40, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: projet
-- ------------------------------------------------------
-- Server version	5.5.40-0+wheezy1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `temperature`
--

DROP TABLE IF EXISTS `temperature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temperature` (
  `Tmp_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Tmp_Value` float NOT NULL,
  `Tmp_Date` datetime NOT NULL,
  `Sen_Id` int(11) NOT NULL,
  PRIMARY KEY (`Tmp_Id`),
  KEY `fk_VariableData_Variable1_idx` (`Sen_Id`),
  CONSTRAINT `fk_VariableData_Variable1` FOREIGN KEY (`Sen_Id`) REFERENCES `sensor` (`Sen_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temperature`
--

LOCK TABLES `temperature` WRITE;
/*!40000 ALTER TABLE `temperature` DISABLE KEYS */;
INSERT INTO `temperature` VALUES (6,15.2,'2013-11-22 18:11:27',1),(7,15.2,'2013-11-22 18:12:10',1),(8,15.3,'2013-11-22 18:14:55',8),(9,15.3,'2013-11-22 18:15:39',8),(10,15.3,'2013-11-22 18:16:26',8),(11,15.3,'2013-11-22 18:29:14',8),(12,15.3,'2013-11-29 15:01:17',8),(13,15.3,'2013-11-29 15:03:56',8),(14,15.3,'2013-11-29 15:04:22',8);
/*!40000 ALTER TABLE `temperature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `Are_Id` int(11) NOT NULL,
  `Are_Label` varchar(45) NOT NULL,
  `Are_Road` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Are_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'test','');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alert`
--

DROP TABLE IF EXISTS `alert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alert` (
  `Alr_code` varchar(5) NOT NULL,
  `Alr_Label` varchar(45) NOT NULL,
  `Alr_Description` text NOT NULL,
  PRIMARY KEY (`Alr_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert`
--

LOCK TABLES `alert` WRITE;
/*!40000 ALTER TABLE `alert` DISABLE KEYS */;
/*!40000 ALTER TABLE `alert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trigger`
--

DROP TABLE IF EXISTS `trigger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trigger` (
  `Trg_Id` int(11) NOT NULL,
  `Trg_High` float NOT NULL,
  `Trg_Low` float NOT NULL,
  `Trg_Edge` tinyint(1) NOT NULL,
  `Alr_code` varchar(5) NOT NULL,
  `Sen_Id` int(11) NOT NULL,
  PRIMARY KEY (`Trg_Id`),
  KEY `fk_Trigger_Alert_idx` (`Alr_code`),
  KEY `fk_Trigger_Variable1_idx` (`Sen_Id`),
  CONSTRAINT `fk_Trigger_Alert` FOREIGN KEY (`Alr_code`) REFERENCES `alert` (`Alr_code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Trigger_Variable1` FOREIGN KEY (`Sen_Id`) REFERENCES `sensor` (`Sen_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trigger`
--

LOCK TABLES `trigger` WRITE;
/*!40000 ALTER TABLE `trigger` DISABLE KEYS */;
/*!40000 ALTER TABLE `trigger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station` (
  `Sta_Id` int(11) NOT NULL,
  `Sta_Label` varchar(45) NOT NULL,
  `Are_Id` int(11) NOT NULL,
  `Sta_LastCom` datetime DEFAULT NULL,
  `Sta_Valid` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Sta_Id`),
  KEY `fk_Sensor_Area1_idx` (`Are_Id`),
  CONSTRAINT `fk_Sensor_Area1` FOREIGN KEY (`Are_Id`) REFERENCES `area` (`Are_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,'Station1',1,'2013-11-22 18:12:10',0),(19,'Station19',1,'2013-11-29 15:05:04',0),(198,'Station198',1,'2013-11-22 18:15:39',0);
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alerthis`
--

DROP TABLE IF EXISTS `alerthis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alerthis` (
  `Alh_Id` int(11) NOT NULL,
  `Alh_Date` datetime NOT NULL,
  `Alh_State` tinyint(1) NOT NULL,
  `Trg_Id` int(11) NOT NULL,
  PRIMARY KEY (`Alh_Id`),
  KEY `fk_AlertHis_Trigger1_idx` (`Trg_Id`),
  CONSTRAINT `fk_AlertHis_Trigger1` FOREIGN KEY (`Trg_Id`) REFERENCES `trigger` (`Trg_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alerthis`
--

LOCK TABLES `alerthis` WRITE;
/*!40000 ALTER TABLE `alerthis` DISABLE KEYS */;
/*!40000 ALTER TABLE `alerthis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor`
--

DROP TABLE IF EXISTS `sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sensor` (
  `Sen_Id` int(11) NOT NULL,
  `Sen_Label` varchar(45) NOT NULL,
  `Sta_Id` int(11) NOT NULL,
  PRIMARY KEY (`Sen_Id`),
  KEY `fk_Variable_Sensor1_idx` (`Sta_Id`),
  CONSTRAINT `fk_Variable_Sensor1` FOREIGN KEY (`Sta_Id`) REFERENCES `station` (`Sta_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor`
--

LOCK TABLES `sensor` WRITE;
/*!40000 ALTER TABLE `sensor` DISABLE KEYS */;
INSERT INTO `sensor` VALUES (1,'Sensor1',1),(8,'Sensor8',198);
/*!40000 ALTER TABLE `sensor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-29 10:02:29
