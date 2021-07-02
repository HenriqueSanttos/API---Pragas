-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cultura`
--

DROP TABLE IF EXISTS `cultura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cultura` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cultura`
--

LOCK TABLES `cultura` WRITE;
/*!40000 ALTER TABLE `cultura` DISABLE KEYS */;
INSERT INTO `cultura` VALUES (1,'Soja'),(2,'Milho'),(3,'Algodão'),(4,'Sorgo'),(5,'Milheto'),(6,'Clotalaria'),(7,'Feijão');
/*!40000 ALTER TABLE `cultura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pragas`
--

DROP TABLE IF EXISTS `pragas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pragas` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pragas`
--

LOCK TABLES `pragas` WRITE;
/*!40000 ALTER TABLE `pragas` DISABLE KEYS */;
INSERT INTO `pragas` VALUES (1,'ovoBicudo'),(2,'larvaBicudo'),(3,'pupaBicudo');
/*!40000 ALTER TABLE `pragas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pragas_encontradas`
--

DROP TABLE IF EXISTS `pragas_encontradas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pragas_encontradas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qnt` varchar(45) NOT NULL,
  `Pragas_id` int NOT NULL,
  `Verificacao_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Pragas_encontradas_Pragas_idx` (`Pragas_id`),
  KEY `fk_Pragas_encontradas_Verificacao1_idx` (`Verificacao_id`),
  CONSTRAINT `fk_Pragas_encontradas_Pragas` FOREIGN KEY (`Pragas_id`) REFERENCES `pragas` (`id`),
  CONSTRAINT `fk_Pragas_encontradas_Verificacao1` FOREIGN KEY (`Verificacao_id`) REFERENCES `verificacao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pragas_encontradas`
--

LOCK TABLES `pragas_encontradas` WRITE;
/*!40000 ALTER TABLE `pragas_encontradas` DISABLE KEYS */;
/*!40000 ALTER TABLE `pragas_encontradas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `safra`
--

DROP TABLE IF EXISTS `safra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `safra` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `Cultura_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Safra_Cultura1_idx` (`Cultura_id`),
  CONSTRAINT `fk_Safra_Cultura1` FOREIGN KEY (`Cultura_id`) REFERENCES `cultura` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `safra`
--

LOCK TABLES `safra` WRITE;
/*!40000 ALTER TABLE `safra` DISABLE KEYS */;
INSERT INTO `safra` VALUES (1,'2015',1),(2,'2016',1),(3,'2017',1),(4,'2018',1),(5,'2018',1),(6,'2019',1),(7,'2020',1),(8,'2015',2),(9,'2016',2),(10,'2017',2),(11,'2018',2),(12,'2019',2),(13,'2020',2),(14,'2015',3),(15,'2016',3),(16,'2017',3),(17,'2018',3),(18,'2019',3),(19,'2020',3);
/*!40000 ALTER TABLE `safra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talhao`
--

DROP TABLE IF EXISTS `talhao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `talhao` (
  `id` int NOT NULL,
  `area` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talhao`
--

LOCK TABLES `talhao` WRITE;
/*!40000 ALTER TABLE `talhao` DISABLE KEYS */;
INSERT INTO `talhao` VALUES (1,'100'),(2,'150'),(3,'30'),(4,'55'),(5,'79'),(6,'63'),(7,'69'),(8,'57'),(9,'102'),(10,'174'),(11,'656'),(12,'666');
/*!40000 ALTER TABLE `talhao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verificacao`
--

DROP TABLE IF EXISTS `verificacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verificacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_safra` int NOT NULL,
  `id_talhao` int NOT NULL,
  `datDia` timestamp(6) NOT NULL,
  `geo` varchar(45) NOT NULL,
  `total_pragas` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_safra` (`id_safra`),
  KEY `id_talhao` (`id_talhao`),
  CONSTRAINT `verificacao_ibfk_1` FOREIGN KEY (`id_safra`) REFERENCES `safra` (`id`),
  CONSTRAINT `verificacao_ibfk_2` FOREIGN KEY (`id_talhao`) REFERENCES `talhao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verificacao`
--

LOCK TABLES `verificacao` WRITE;
/*!40000 ALTER TABLE `verificacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `verificacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-01 16:27:48
