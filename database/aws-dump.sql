-- MySQL dump 10.17  Distrib 10.3.13-MariaDB, for Win64 (AMD64)
--
-- Host: ewd.c6d1svw4itgu.ap-southeast-1.rds.amazonaws.com    Database: magazinedb
-- ------------------------------------------------------
-- Server version	10.3.8-MariaDB-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE magazinedb;
USE magazinedb;

--
-- Table structure for table `Faculty`
--

DROP TABLE IF EXISTS `Faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Faculty` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Faculty`
--

LOCK TABLES `Faculty` WRITE;
/*!40000 ALTER TABLE `Faculty` DISABLE KEYS */;
INSERT INTO `Faculty` VALUES (1,'Faculty1');
/*!40000 ALTER TABLE `Faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Submission`
--

DROP TABLE IF EXISTS `Submission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Submission` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Path` text NOT NULL,
  `Author_Id` int(10) NOT NULL,
  `Date` date NOT NULL,
  `Year_Id` int(10) NOT NULL,
  `Has_Sent_Notice` tinyint(1) NOT NULL,
  `Comment` mediumtext DEFAULT NULL,
  `Is_Selected` tinyint(1) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKSubmission108191` (`Author_Id`),
  KEY `FKSubmission463040` (`Year_Id`),
  CONSTRAINT `FKSubmission108191` FOREIGN KEY (`Author_Id`) REFERENCES `User` (`Id`),
  CONSTRAINT `FKSubmission463040` FOREIGN KEY (`Year_Id`) REFERENCES `Year` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Submission`
--

LOCK TABLES `Submission` WRITE;
/*!40000 ALTER TABLE `Submission` DISABLE KEYS */;
INSERT INTO `Submission` VALUES (13,'C:\\files\\BlueStacks_ScreenShot92.jpg',1,'2019-03-11',1,0,'',0),(14,'C:\\files\\4k-wallpaper-abstract-art-1210276.jpg',1,'2019-03-11',1,0,'',0),(15,'C:\\files\\564x511.jpg',1,'2019-03-11',1,0,'',0),(16,'C:\\files\\forextutorial.pdf',1,'2019-03-13',1,0,'',0),(17,'C:\\files\\11 ch 21-24 - Nov 25.pdf',1,'2019-03-13',1,0,'',0),(31,'C:\\files\\1.1552641327448.4k-wallpaper-abstract-art-1210276.jpg',1,'2019-03-15',1,0,'',0),(32,'path/to/file/on/disk',1,'2019-03-15',1,0,NULL,0);
/*!40000 ALTER TABLE `Submission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Role` tinytext NOT NULL,
  `Faculty_Id` int(10) DEFAULT NULL,
  `Has_Accepted_TOC` tinyint(1) NOT NULL,
  `Email` text NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKUser34225` (`Faculty_Id`),
  CONSTRAINT `FKUser34225` FOREIGN KEY (`Faculty_Id`) REFERENCES `Faculty` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'Student',1,1,'a@gmail.com'),(2,'Coordinator',1,1,'ewd.coordinator@sharklasers.com');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Year`
--

DROP TABLE IF EXISTS `Year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Year` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `Entry_ClosureDate` date NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Year`
--

LOCK TABLES `Year` WRITE;
/*!40000 ALTER TABLE `Year` DISABLE KEYS */;
INSERT INTO `Year` VALUES (1,'2018-12-31','2019-12-30','2019-08-31');
/*!40000 ALTER TABLE `Year` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-15 17:33:20
