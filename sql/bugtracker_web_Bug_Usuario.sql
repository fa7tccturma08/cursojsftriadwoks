CREATE DATABASE  IF NOT EXISTS `bugtracker_web` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bugtracker_web`;
-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: bugtracker_web
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.14.04.1

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
-- Table structure for table `Bug_Usuario`
--

DROP TABLE IF EXISTS `Bug_Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bug_Usuario` (
  `Bug_id` int(11) NOT NULL,
  `responsaveis_id` int(11) NOT NULL,
  KEY `FK_chwmh9hxt8wwjqm85ve1lxuxp` (`responsaveis_id`),
  KEY `FK_d3en5io0r9ef332e7504jxsvy` (`Bug_id`),
  CONSTRAINT `FK_chwmh9hxt8wwjqm85ve1lxuxp` FOREIGN KEY (`responsaveis_id`) REFERENCES `Usuario` (`id`),
  CONSTRAINT `FK_d3en5io0r9ef332e7504jxsvy` FOREIGN KEY (`Bug_id`) REFERENCES `Bug` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bug_Usuario`
--

LOCK TABLES `Bug_Usuario` WRITE;
/*!40000 ALTER TABLE `Bug_Usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `Bug_Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-24 22:16:36
