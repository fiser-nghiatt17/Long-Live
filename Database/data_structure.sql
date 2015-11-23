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
  CONSTRAINT `albums_ibfk_1` FOREIGN KEY (`author`) REFERENCES `users` (`username`) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT `albums_ibfk_2` FOREIGN KEY (`category`) REFERENCES `categories` (`categoryID`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`commentUser`) REFERENCES `users` (`username`) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`onAlbum`) REFERENCES `albums` (`albumID`) ON UPDATE CASCADE ON DELETE CASCADE
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
  CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`likeUser`) REFERENCES `users` (`username`) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`onAlbum`) REFERENCES `albums` (`albumID`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  CONSTRAINT `pictures_ibfk_1` FOREIGN KEY (`inAlbum`) REFERENCES `albums` (`albumID`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-21 22:39:19
