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
-- Dumping routines for database 'tp_final'
--
/*!50003 DROP PROCEDURE IF EXISTS `Cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Cliente`(IN OP varchar(50),IN IDUs int)
BEGIN


if(OP='ListarCliente') then
if exists(Select * from cliente where idCliente=IDUs)then
SELECT  a.*,b.idNacionalidad as idNacionalidad,b.Descripcion as DescripcionNac, c.idLocalidad AS idLocalidad, c.Descripcion AS DescripcionLoc,d.idProvincia AS idProvincia, d.Descripcion AS DescripcionProv FROM tp_final.cliente a inner join nacionalidad b on a.IDNacionalidad=b.idNacionalidad inner join localidad c on a.IDLocalidad=c.idLocalidad inner join provincia d on a.IDProvincia=d.idProvincia  WHERE idCliente=IDUs ;
END if;
END if;

if(OP='ListarClientes')then
SELECT a.*,b.idNacionalidad as idNacionalidad,b.Descripcion as DescripcionNac, c.idLocalidad AS idLocalidad, c.Descripcion AS DescripcionLoc,d.idProvincia AS idProvincia, d.Descripcion AS DescripcionProv FROM tp_final.cliente a inner join nacionalidad b on a.IDNacionalidad=b.idNacionalidad inner join localidad c on a.IDLocalidad=c.idLocalidad inner join provincia d on a.IDProvincia=d.idProvincia;
END if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Login`(IN OP varchar(100), IN UsParam varchar(100),IN claveParam varchar(100),IN mailParam varchar(100))
BEGIN
if(OP='Login') then

if exists(SELECT * FROM admin WHERE (Usuario=UsParam AND Contrasenia=claveParam AND Estado=1)) then
select distinct Usuario as Usuario, idTipoUsuario as TipoUsuario, Contrasenia as Clave from admin where Usuario=UsParam;
end if;

if exists(SELECT * FROM cliente WHERE (usuario=UsParam AND Contrasenia=claveParam AND Estado=1)) then
select distinct Usuario as Usuario, idTipoUsuario as TipoUsuario, Contrasenia as Clave from Cliente where Usuario=UsParam;
end if;
end if;

if(OP='RecuperarUsuario') then
if exists(SELECT * FROM cliente WHERE(Mail=mailParam))then
select Mail as Mail, Usuario as Usuario, Contrasenia as Clave from tp_final.cliente WHERE Mail=mailParam;
end if;

if exists(SELECT * FROM admin WHERE(Mail=mailParam))then
select Mail as Mail, Usuario as Usuario, Contrasenia as Clave from tp_final.admin WHERE Mail=mailParam;
end if;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Transferencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Transferencia`(IN OP varchar(50),IN CBUo bigint, IN CBUd bigint, IN monto double)
BEGIN
if(OP='Transferir') then
update cuentaxcliente set Saldo=Saldo-monto where Cbu= CBUo;
update cuentaxcliente set Saldo=Saldo+monto where Cbu= CBUd;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-15  4:05:17
