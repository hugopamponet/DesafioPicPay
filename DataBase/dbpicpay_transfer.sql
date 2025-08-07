-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbpicpay
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `transfer`
--

DROP TABLE IF EXISTS `transfer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfer` (
  `id` binary(16) NOT NULL,
  `value` decimal(38,2) DEFAULT NULL,
  `wallet_receiver_id` bigint DEFAULT NULL,
  `wallet_sender_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc1qjjkg9xui0xm6ojsvc9rrs2` (`wallet_receiver_id`),
  KEY `FKgaj3r9p9bygcgcyac1l2dxra4` (`wallet_sender_id`),
  CONSTRAINT `FKc1qjjkg9xui0xm6ojsvc9rrs2` FOREIGN KEY (`wallet_receiver_id`) REFERENCES `wallet` (`id`),
  CONSTRAINT `FKgaj3r9p9bygcgcyac1l2dxra4` FOREIGN KEY (`wallet_sender_id`) REFERENCES `wallet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer`
--

LOCK TABLES `transfer` WRITE;
/*!40000 ALTER TABLE `transfer` DISABLE KEYS */;
INSERT INTO `transfer` VALUES (_binary '‰pƒƒ™A<–=0³B \Í',20.00,3,1),(_binary 'B#—\èiPA£†cº‚¢ˆ\Þ',10.00,2,1),(_binary 'a¡6…FE‡¿,u ˜\ËHÁ',20.00,1,2),(_binary '\æ9\ÅXù°@\"›p\Ä½|ü›',10.00,2,1);
/*!40000 ALTER TABLE `transfer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-06 17:33:28
