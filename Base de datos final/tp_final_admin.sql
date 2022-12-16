-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: tp_final
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `Usuario` varchar(45) NOT NULL,
  `Contrasenia` varchar(45) DEFAULT NULL,
  `IdTipoUsuario` bigint(20) DEFAULT NULL,
  `Estado` bit(1) DEFAULT NULL,
  `SuperAdmin` bit(1) DEFAULT NULL,
  `Mail` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('Admin1','admin',1,'','','admin1@gmail.com'),('Admin10','admin',1,'','\0','admin10@gmail.com'),('Admin11','admin',1,'','\0','admin11@gmail.com'),('Admin12','admin',1,'','\0','admin12@gmail.com'),('Admin13','admin',1,'','\0','admin13@gmail.com'),('Admin14','admin',1,'','\0','admin14@gmail.com'),('Admin15','admin',1,'','\0','admin15@gmail.com'),('Admin2','admin',1,'','\0','admin2@gmail.com'),('Admin3','admin',1,'','\0','admin3@gmail.com'),('Admin4','admin',1,'','\0','admin4@gmail.com'),('Admin5','admin',1,'','\0','admin5@gmail.com'),('Admin6','admin',1,'','\0','admin6@gmail.com'),('Admin7','admin',1,'','\0','admin7@gmail.com'),('Admin8','admin',1,'','\0','admin8@gmail.com'),('Admin9','admin',1,'','\0','admin9@gmail.com'),('admin99','admin',1,'','\0','admin99@gmail.com');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-15  4:05:16
