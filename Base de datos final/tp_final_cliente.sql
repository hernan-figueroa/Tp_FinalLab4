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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `CUIL` bigint(20) DEFAULT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `Sexo` varchar(45) DEFAULT NULL,
  `IDNacionalidad` bigint(20) DEFAULT NULL,
  `FechaNacimiento` datetime DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `IDLocalidad` bigint(20) DEFAULT NULL,
  `IDProvincia` bigint(20) DEFAULT NULL,
  `Mail` varchar(45) DEFAULT NULL,
  `Usuario` varchar(45) DEFAULT NULL,
  `Estado` bit(1) DEFAULT NULL,
  `DNI` bigint(20) DEFAULT NULL,
  `Contrasenia` varchar(45) DEFAULT NULL,
  `IdTipoUsuario` int(11) DEFAULT '0',
  PRIMARY KEY (`idCliente`),
  KEY `cliente_nacionalidad_idx` (`IDNacionalidad`),
  KEY `cliente_localidad_idx` (`IDLocalidad`),
  KEY `cliente_provincia_idx` (`IDProvincia`),
  KEY `cliente_usuario_idx` (`Usuario`),
  KEY `cliente_prestamoxcliente_idx` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,2222222,'Emiliano','Martinez','Masculino',1,'1990-11-04 00:00:00','Direccion',1,2,'emiliano@gmail.com','dibu','',3544444,'usuario',0),(2,2236444448,'Lisandro','Martinez','Masculino',1,'1997-11-04 00:00:00','Direccion',2,3,'lisandro@hotmail.com','lisandro','',3644444,'usuario',0),(3,32653265,'Nombre3','Apellido3','Masculino',3,'2022-11-03 00:00:00','calle 55553',2,5,'Usuario1@gmail.com','Usuario1','',11122233,'usuario',0),(4,1111111,' asdasd','asdasd','Masculino',5,'2022-11-03 00:00:00','calle 123',3,5,'Usuario9@asdasd.com','Usuario9','',111111,'usuario',0),(5,222222,' 222222','222222','Femenino',3,'2022-11-10 00:00:00','calle 123',3,5,'Usuario10@asdasd.com','Usuario10','',2222222,'usuario',0),(6,4444,' 4444','44444','Masculino',2,'2022-11-10 00:00:00','calle 123',2,2,'Usuario11@asdasd.com','Usuario11','',44444,'usuario',0),(7,55555,' 555555','55555','Femenino',4,'2022-11-03 00:00:00','calle 55555',1,4,'Usuario12@asdasd.com','Usuario12','',55555,'usuario',0),(8,66666,'Nombre1','Apellido1','Masculino',11,'2022-11-03 00:00:00','calle 55555',1,5,'Usuario@gmail.com','Usuario','',11122333,'usuario',0),(9,77777,'Nombre2','Apellido2','Masculino',12,'2022-11-03 00:00:00','calle 55555',2,6,'Usuario2@gmail.com','Usuario2','',33322111,'usuario',0),(10,888888,'Nombre3','Apellido3','Masculino',15,'2022-11-03 00:00:00','calle 55555',4,2,'Usuario3@gmail.com','Usuario3','',22211133,'usuario',0),(11,99999,'Nombre4','Apellido4','Masculino',13,'2022-11-03 00:00:00','calle 55555',5,9,'Usuario4@gmail.com','Usuario4','',33223311,'usuario',0),(12,123456,'Nombre5','Apellido5','Femenino',9,'2022-11-03 00:00:00','calle 55555',3,7,'Usuario5@gmail.com','Usuario5','',12312343,'usuario',0),(13,654321,'Nombre6','Apellido6','Femenino',8,'2022-11-03 00:00:00','calle 55555',7,8,'Usuario6@gmail.com','Usuario6','',12342356,'usuario',0),(14,654123,'Nombre7','Apellido7','Femenino',9,'2022-11-03 00:00:00','calle 55555',8,5,'Usuario7@gmail.com','Usuario7','',7766554,'usuario',0),(15,123654,'Nombre8','Apellido8','Femenino',7,'2022-11-03 00:00:00','calle 55555',9,4,'Usuario8@gmail.com','Usuario8','',8877889,'usuario',0);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
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
