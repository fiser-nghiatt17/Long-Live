-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: longlive
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `albums`
--

DROP TABLE IF EXISTS `albums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `albums` (
  `albumID` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `albumName` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `viewAmount` int(11) DEFAULT '0',
  `likeAmount` int(11) DEFAULT '0',
  PRIMARY KEY (`albumID`),
  KEY `author` (`author`),
  KEY `category` (`category`),
  CONSTRAINT `albums_ibfk_1` FOREIGN KEY (`author`) REFERENCES `users` (`username`),
  CONSTRAINT `albums_ibfk_2` FOREIGN KEY (`category`) REFERENCES `categories` (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `albums`
--

LOCK TABLES `albums` WRITE;
/*!40000 ALTER TABLE `albums` DISABLE KEYS */;
INSERT INTO `albums` VALUES (1,'hungct2','Chim Ung',1,3,31),(2,'nghiatt17','Jenifer',2,4,23),(3,'tumv2','Trees',6,9,41),(6,'cuonglv13','My eyes',3,7,30),(7,'sinhlt3','Creative Suite',7,23,81),(8,'sinhlt3','Nature',7,23,81),(9,'tumv2','Manga',7,23,81);
/*!40000 ALTER TABLE `albums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `categoryID` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'natural','Natural Type'),(2,'sport','Sport Type'),(3,'cultural','Cultural Type'),(4,'animal','Animal Type'),(5,'forest','Forest Type'),(6,'baby','Baby Type'),(7,'car','Car Type'),(8,'travel','Travel Type'),(9,'food','Food Type'),(10,'other','Other Type');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `commentID` int(11) NOT NULL AUTO_INCREMENT,
  `commentUser` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `onAlbum` int(11) NOT NULL,
  `commentTime` datetime DEFAULT NULL,
  `content` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`commentID`),
  KEY `user` (`commentUser`),
  KEY `onPicture` (`onAlbum`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`commentUser`) REFERENCES `users` (`username`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`onAlbum`) REFERENCES `albums` (`albumID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `likes` (
  `likeID` int(11) NOT NULL,
  `likeUser` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `onAlbum` int(11) NOT NULL,
  `state` bit(1) DEFAULT b'0',
  PRIMARY KEY (`likeID`),
  KEY `likeUser` (`likeUser`),
  KEY `onAlbum` (`onAlbum`),
  CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`likeUser`) REFERENCES `users` (`username`),
  CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`onAlbum`) REFERENCES `albums` (`albumID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pictures`
--

DROP TABLE IF EXISTS `pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pictures` (
  `pictureID` int(11) NOT NULL AUTO_INCREMENT,
  `pictureName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `inAlbum` int(11) DEFAULT NULL,
  `pictureURL` text COLLATE utf8_unicode_ci,
  `uploadDate` date DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`pictureID`),
  KEY `album` (`inAlbum`),
  CONSTRAINT `pictures_ibfk_1` FOREIGN KEY (`inAlbum`) REFERENCES `albums` (`albumID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pictures`
--

LOCK TABLES `pictures` WRITE;
/*!40000 ALTER TABLE `pictures` DISABLE KEYS */;
INSERT INTO `pictures` VALUES (1,'a picture',1,'images/1 (1).jpg','2015-02-23','Something'),(2,'angry bird',1,'images/1 (2).jpg','2013-04-11','A big bird'),(3,'Big bird   ',7,'images/1 (5).jpg','2015-11-10','A big bird'),(4,'Big bird2',7,'images/1 (6).jpg','2015-11-24',NULL),(5,'Big bird3   ',7,'images/1 (7).jpg','2015-11-23',NULL),(6,'Big bird3   ',7,'images/1 (8).jpg','2015-11-23',NULL),(7,'angry bird',1,'images/1 (3).jpg','2013-04-11','A big bird'),(8,'angry bird',2,'images/1 (4).jpg','2013-04-11','A big bird'),(9,'angry bird',2,'images/1 (9).jpg','2013-04-11','A big bird'),(10,'angry bird',2,'images/1 (10).jpg','2013-04-11','A big bird'),(11,'angry bird',3,'images/1 (11).jpg','2013-04-11','A big bird'),(12,'angry bird',3,'images/1 (12).jpg','2013-04-11','A big bird'),(13,'angry bird',3,'images/1 (13).jpg','2013-04-11','A big bird'),(14,'angry bird',3,'images/1 (14).jpg','2013-04-11','A big bird'),(15,'angry bird',6,'images/1 (15).jpg','2013-04-11','A big bird'),(16,'angry bird',6,'images/1 (16).jpg','2013-04-11','A big bird'),(17,'angry bird',6,'images/1 (17).jpg','2013-04-11','A big bird'),(18,'angry bird',6,'images/1 (18).jpg','2013-04-11','A big bird'),(19,'angry bird',8,'images/1 (19).jpg','2013-04-11','A big bird'),(20,'angry bird',8,'images/1 (20).jpg','2013-04-11','A big bird'),(21,'angry bird',8,'images/1 (21).jpg','2013-04-11','A big bird'),(22,'angry bird',8,'images/1 (22).jpg','2013-04-11','A big bird'),(23,'angry bird',9,'images/1 (23).jpg','2013-04-11','A big bird'),(24,'angry bird',9,'images/1 (24).jpg','2013-04-11','A big bird');
/*!40000 ALTER TABLE `pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fullname` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userGender` bit(1) DEFAULT b'1',
  `userEmail` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `userBirthday` date DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('','','','\0',NULL,NULL),('anhtt50','anhtt50','Thai Tuan Anh',NULL,'anhtt50@fpt.com.vn',NULL),('cuonglv13','cuonglv13','Le Van Cuong',NULL,'cuonglv13@fpt.com.vn',NULL),('hungct2','hungct2','Chu Thanh Hung',NULL,'hungct2@fpt.com.vn',NULL),('nghiatt17','nghiatt17','Tran Tuan Nghia',NULL,'nghiatt17@fpt.com.vn',NULL),('sinhlt3','123456','Luu Truong Sinh',NULL,'sinhlt3@fpt.com.vn',NULL),('sinhlt31','123456','SinhBlack','\0',NULL,NULL),('sinhlt35','123456','SinhBlack','\0',NULL,NULL),('tumv2','tumv2','Ma Van Tu',NULL,'tumv2@fpt.com.vn',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-23 19:54:17
