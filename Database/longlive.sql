CREATE DATABASE  IF NOT EXISTS `longlive` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `longlive`;
-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (i686)
--
-- Host: 127.0.0.1    Database: longlive
-- ------------------------------------------------------
-- Server version	5.5.44-0+deb8u1

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
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `albumID` int(11) NOT NULL AUTO_INCREMENT,
  `author` int(11) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  PRIMARY KEY (`albumID`),
  KEY `author` (`author`),
  KEY `category` (`category`),
  CONSTRAINT `album_ibfk_2` FOREIGN KEY (`category`) REFERENCES `category` (`categoryID`),
  CONSTRAINT `album_ibfk_1` FOREIGN KEY (`author`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,1,'lion',4);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'natural',NULL),(2,'sport',NULL),(3,'cultural',NULL),(4,'animal',NULL),(5,'forest',NULL),(6,'baby',NULL),(7,'car',NULL),(8,'travel',NULL),(9,'food',NULL),(10,'other',NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentID` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `onPicture` int(11) NOT NULL,
  `commentTime` datetime DEFAULT NULL,
  `content` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`commentID`),
  KEY `user` (`user`),
  KEY `onPicture` (`onPicture`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`onPicture`) REFERENCES `picture` (`pictureID`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `pictureID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `album` int(11) DEFAULT NULL,
  `url` text,
  `dateUpdate` date DEFAULT NULL,
  `view` int(11) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`pictureID`),
  KEY `album` (`album`),
  CONSTRAINT `picture_ibfk_1` FOREIGN KEY (`album`) REFERENCES `album` (`albumID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES (1,'Great lion',1,'http://localhost/picture/great_lion.jpg','2015-11-14',34,'A big lion');
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `sex` bit(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nghiatt17','nghiatt17','Tran Tuan Nghia',NULL,'nghiatt17@fpt.com.vn',NULL),(2,'sinhlt3','sinhlt3','Luu Truong Sinh',NULL,'sinhlt3@fpt.com.vn',NULL),(3,'hungct2','hungct2','Chu Thanh Hung',NULL,'hungct2@fpt.com.vn',NULL),(4,'anhtt50','anhtt50','Thai Tuan Anh',NULL,'anhtt50@fpt.com.vn',NULL),(5,'cuonglv13','cuonglv13','Le Van Cuong',NULL,'cuonglv13@fpt.com.vn',NULL),(6,'tumv2','tumv2','Ma Van Tu',NULL,'tumv2@fpt.com.vn',NULL),(7,'tuanna80','tuanna80','Nguyen Anh Tuan',NULL,'tuanna80@fpt.com.vn',NULL),(8,'cuongnm37','cuongnm37','Nguyen Manh Cuong',NULL,'cuongnm37@fpt.com.vn',NULL),(9,'linhnk7','linhnk7','Nguyen Kieu Linh',NULL,'linhnk7@fpt.com.vn',NULL),(10,'khuyennt7','khuyennt7','Nguyen Thi Khuyen',NULL,'khuyennt7@fpt.com.vn',NULL),(11,'testUser','testPassword','Test Member','\0',NULL,'2015-12-13');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-19 17:48:17
