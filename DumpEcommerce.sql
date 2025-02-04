-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: ecommerce
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avaliacao` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador único da avaliação',
  `nota` int DEFAULT NULL COMMENT 'Nota atribuída ao produto (1 a 5)',
  `comentario` text COMMENT 'Comentário do cliente sobre o produto',
  `data` date DEFAULT NULL COMMENT 'Data em que a avaliação foi realizada',
  `cliente_id` int DEFAULT NULL COMMENT 'Referência ao cliente que fez a avaliação',
  `produto_id` int DEFAULT NULL COMMENT 'Referência ao produto avaliado',
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `avaliacao_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE SET NULL,
  CONSTRAINT `avaliacao_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` VALUES (32,5,'Excelente produto!','2025-02-01',11,41),(33,4,'Bom produto!','2025-02-02',12,42),(34,3,'Produto razoável','2025-02-03',13,43),(35,2,'Não gostei','2025-02-04',14,44),(36,1,'Péssimo produto','2025-02-05',15,45),(37,4,'Bom preço','2025-02-06',16,46),(38,3,'Custo-benefício ok','2025-02-07',17,47),(39,5,'Produto de ótima qualidade','2025-02-08',18,48),(40,4,'Gostei, mas poderia melhorar','2025-02-09',19,49),(41,2,'Não gostei, devolvi','2025-02-10',20,50),(42,5,'Excelente produto!','2025-02-01',11,41),(43,4,'Bom produto!','2025-02-02',12,42),(44,3,'Produto razoável','2025-02-03',13,43),(45,2,'Não gostei','2025-02-04',14,44),(46,1,'Péssimo produto','2025-02-05',15,45),(47,4,'Bom preço','2025-02-06',16,46),(48,3,'Custo-benefício ok','2025-02-07',17,47),(49,5,'Produto de ótima qualidade','2025-02-08',18,48),(50,4,'Gostei, mas poderia melhorar','2025-02-09',19,49),(51,2,'Não gostei, devolvi','2025-02-10',20,50);
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrinho`
--

DROP TABLE IF EXISTS `carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrinho` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador único do carrinho',
  `cliente_id` int NOT NULL COMMENT 'Referência ao cliente que criou o carrinho',
  `data_criacao` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Data e hora de criação do carrinho',
  PRIMARY KEY (`id`),
  KEY `fk_carrinho_cliente_idx` (`cliente_id`),
  CONSTRAINT `fk_carrinho_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho`
--

LOCK TABLES `carrinho` WRITE;
/*!40000 ALTER TABLE `carrinho` DISABLE KEYS */;
INSERT INTO `carrinho` VALUES (11,11,'2025-02-01 10:00:00'),(12,12,'2025-02-02 11:00:00'),(13,13,'2025-02-03 12:00:00'),(14,14,'2025-02-04 13:00:00'),(15,15,'2025-02-05 14:00:00'),(16,16,'2025-02-06 15:00:00'),(17,17,'2025-02-07 16:00:00'),(18,18,'2025-02-08 17:00:00'),(19,19,'2025-02-09 18:00:00'),(20,20,'2025-02-10 19:00:00');
/*!40000 ALTER TABLE `carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador único do cliente',
  `nome` varchar(100) DEFAULT NULL COMMENT 'Nome completo do cliente',
  `cpf` varchar(14) DEFAULT NULL COMMENT 'Cadastro de Pessoa Física (CPF) do cliente',
  `email` varchar(100) DEFAULT NULL COMMENT 'Endereço de e-mail do cliente',
  `senha` varchar(100) DEFAULT NULL COMMENT 'Senha de acesso do cliente',
  `telefone` varchar(15) DEFAULT NULL COMMENT 'Número de telefone do cliente',
  `dataNascimento` date DEFAULT NULL COMMENT 'Data de nascimento do cliente',
  `nacionalidade` varchar(50) DEFAULT NULL COMMENT 'País de origem do cliente',
  `genero` varchar(10) DEFAULT NULL COMMENT 'Gênero do cliente',
  `endereco_id` int DEFAULT NULL COMMENT 'Referência ao endereço do cliente',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `email` (`email`),
  KEY `endereco_id` (`endereco_id`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (11,'Cliente 1','12345678901','cliente1@exemplo.com','senha1','31999999999','1990-01-01','Brasil','Masculino',11),(12,'Cliente 2','12345678902','cliente2@exemplo.com','senha2','31988888888','1991-02-02','Brasil','Feminino',12),(13,'Cliente 3','12345678903','cliente3@exemplo.com','senha3','31977777777','1992-03-03','Brasil','Masculino',13),(14,'Cliente 4','12345678904','cliente4@exemplo.com','senha4','31966666666','1993-04-04','Brasil','Feminino',14),(15,'Cliente 5','12345678905','cliente5@exemplo.com','senha5','31955555555','1994-05-05','Brasil','Masculino',15),(16,'Cliente 6','12345678906','cliente6@exemplo.com','senha6','31944444444','1995-06-06','Brasil','Feminino',16),(17,'Cliente 7','12345678907','cliente7@exemplo.com','senha7','31933333333','1996-07-07','Brasil','Masculino',17),(18,'Cliente 8','12345678908','cliente8@exemplo.com','senha8','31922222222','1997-08-08','Brasil','Feminino',18),(19,'Cliente 9','12345678909','cliente9@exemplo.com','senha9','31911111111','1998-09-09','Brasil','Masculino',19),(20,'Cliente 10','12345678910','cliente10@exemplo.com','senha10','31900000000','1999-10-10','Brasil','Feminino',20);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador único do endereço',
  `cep` int DEFAULT NULL COMMENT 'Código de Endereçamento Postal (CEP)',
  `rua` varchar(255) DEFAULT NULL COMMENT 'Nome da rua',
  `complemento` varchar(255) DEFAULT NULL COMMENT 'Informações complementares do endereço',
  `logradouro` varchar(100) DEFAULT NULL COMMENT 'Tipo de logradouro (Avenida, Rua, etc.)',
  `bairro` varchar(100) DEFAULT NULL COMMENT 'Nome do bairro',
  `cidade` varchar(100) DEFAULT NULL COMMENT 'Nome da cidade',
  `estado` varchar(100) DEFAULT NULL COMMENT 'Nome do estado',
  `numero` int DEFAULT NULL COMMENT 'Número do endereço',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (11,30123000,'Rua A','Apto 101','Avenida','Centro','Belo Horizonte','MG',100),(12,30123001,'Rua B','Casa 202','Rua','Barro Preto','Belo Horizonte','MG',200),(13,30123002,'Rua C','Sala 303','Avenida','Savassi','Belo Horizonte','MG',300),(14,30123003,'Rua D','Casa 404','Rua','Funcionários','Belo Horizonte','MG',400),(15,30123004,'Rua E','Apto 505','Avenida','Prado','Belo Horizonte','MG',500),(16,30123005,'Rua F','Casa 606','Rua','Santo Antônio','Belo Horizonte','MG',600),(17,30123006,'Rua G','Apto 707','Avenida','Cidade Jardim','Belo Horizonte','MG',700),(18,30123007,'Rua H','Casa 808','Rua','Anchieta','Belo Horizonte','MG',800),(19,30123008,'Rua I','Apto 909','Avenida','Nova Suíça','Belo Horizonte','MG',900),(20,30123009,'Rua J','Casa 1010','Rua','Lagoinha','Belo Horizonte','MG',1000),(21,30123000,'Rua A','Apto 101','Avenida','Centro','Belo Horizonte','MG',100),(22,30123001,'Rua B','Casa 202','Rua','Barro Preto','Belo Horizonte','MG',200),(23,30123002,'Rua C','Sala 303','Avenida','Savassi','Belo Horizonte','MG',300),(24,30123003,'Rua D','Casa 404','Rua','Funcionários','Belo Horizonte','MG',400),(25,30123004,'Rua E','Apto 505','Avenida','Prado','Belo Horizonte','MG',500),(26,30123005,'Rua F','Casa 606','Rua','Santo Antônio','Belo Horizonte','MG',600),(27,30123006,'Rua G','Apto 707','Avenida','Cidade Jardim','Belo Horizonte','MG',700),(28,30123007,'Rua H','Casa 808','Rua','Anchieta','Belo Horizonte','MG',800),(29,30123008,'Rua I','Apto 909','Avenida','Nova Suíça','Belo Horizonte','MG',900),(30,30123009,'Rua J','Casa 1010','Rua','Lagoinha','Belo Horizonte','MG',1000);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itenscarrinho`
--

DROP TABLE IF EXISTS `itenscarrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itenscarrinho` (
  `carrinho_id` int NOT NULL COMMENT 'Referência ao carrinho',
  `produto_id` int NOT NULL COMMENT 'Referência ao produto',
  `quantidade` int NOT NULL COMMENT 'Quantidade do produto no carrinho',
  `preco_unitario` double NOT NULL COMMENT 'Preço do produto no momento da adição',
  PRIMARY KEY (`carrinho_id`,`produto_id`),
  KEY `fk_itensCarrinho_produto_idx` (`produto_id`),
  CONSTRAINT `fk_itensCarrinho_carrinho` FOREIGN KEY (`carrinho_id`) REFERENCES `carrinho` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_itensCarrinho_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itenscarrinho`
--

LOCK TABLES `itenscarrinho` WRITE;
/*!40000 ALTER TABLE `itenscarrinho` DISABLE KEYS */;
INSERT INTO `itenscarrinho` VALUES (11,42,50,199.99),(12,49,10,899.99),(13,48,50,799.99),(14,41,10,99.99),(15,49,777,899.99),(15,50,10,999.99),(16,45,5,499.99),(17,42,7,199.99);
/*!40000 ALTER TABLE `itenscarrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itensvenda`
--

DROP TABLE IF EXISTS `itensvenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itensvenda` (
  `produto_id` int NOT NULL COMMENT 'Referência ao produto',
  `venda_id` int NOT NULL COMMENT 'Referência à venda',
  `quantidade` int DEFAULT NULL COMMENT 'Quantidade de produto na venda',
  `preco_praticado` double DEFAULT NULL COMMENT 'Preço do produto no momento da venda',
  PRIMARY KEY (`produto_id`,`venda_id`),
  KEY `fk_produto_has_venda_venda1_idx` (`venda_id`),
  KEY `fk_produto_has_venda_produto1_idx` (`produto_id`),
  CONSTRAINT `fk_produto_has_venda_produto1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_produto_has_venda_venda1` FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itensvenda`
--

LOCK TABLES `itensvenda` WRITE;
/*!40000 ALTER TABLE `itensvenda` DISABLE KEYS */;
INSERT INTO `itensvenda` VALUES (41,12,1,99.99),(42,13,1,199.99),(43,14,1,299.99),(44,15,1,399.99),(45,16,1,499.99),(46,17,1,599.99),(47,18,1,699.99),(48,19,1,799.99),(49,20,1,899.99),(50,21,1,999.99),(50,33,500,999.99);
/*!40000 ALTER TABLE `itensvenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador único do produto',
  `nome` varchar(100) DEFAULT NULL COMMENT 'Nome do produto',
  `descricao` text COMMENT 'Descrição detalhada do produto',
  `valor_atual` double DEFAULT NULL COMMENT 'Preço unitário do produto',
  `estoque` int DEFAULT NULL COMMENT 'Quantidade disponível em estoque',
  `custo_atual` double DEFAULT NULL,
  `vendedor_id` int DEFAULT NULL COMMENT 'Referência ao vendedor do produto',
  PRIMARY KEY (`id`),
  KEY `vendedor_id` (`vendedor_id`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`vendedor_id`) REFERENCES `vendedor` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (41,'Produto 1','Produto de exemplo 1',99.99,100,50,21),(42,'Produto 2','Produto de exemplo 2',199.99,200,100,22),(43,'Produto 3','Produto de exemplo 3',299.99,300,150,23),(44,'Produto 4','Produto de exemplo 4',399.99,400,200,24),(45,'Produto 5','Produto de exemplo 5',499.99,500,250,25),(46,'Produto 6','Produto de exemplo 6',599.99,600,300,26),(47,'Produto 7','Produto de exemplo 7',699.99,700,350,27),(48,'Produto 8','Produto de exemplo 8',799.99,800,400,28),(49,'Produto 9','Produto de exemplo 9',899.99,900,450,29),(50,'Produto 10','Produto de exemplo 10',999.99,500,500,30);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador único do carrinho',
  `data_hora` datetime DEFAULT NULL COMMENT 'Data em que o pedido foi realizado',
  `total_pago` double DEFAULT NULL COMMENT 'Valor total dos itens no carrinho',
  `tipoPagamento` varchar(45) DEFAULT NULL COMMENT 'Código do tipo de pagamento escolhido',
  `pagamento_efetuado` tinyint DEFAULT NULL,
  `cliente_id` int DEFAULT NULL COMMENT 'Referência ao cliente que criou o carrinho',
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `carrinho_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (12,'2025-02-01 10:10:00',99.99,'Cartão de Crédito',1,11),(13,'2025-02-02 11:10:00',199.99,'Boleto',1,12),(14,'2025-02-03 12:10:00',299.99,'Dinheiro',1,13),(15,'2025-02-04 13:10:00',399.99,'Pix',1,14),(16,'2025-02-05 14:10:00',499.99,'Cartão de Crédito',1,15),(17,'2025-02-06 15:10:00',599.99,'Boleto',1,16),(18,'2025-02-07 16:10:00',699.99,'Dinheiro',1,17),(19,'2025-02-08 17:10:00',799.99,'Pix',1,18),(20,'2025-02-09 18:10:00',899.99,'Cartão de Crédito',1,19),(21,'2025-02-10 19:10:00',999.99,'Boleto',1,20),(22,'2025-02-01 10:10:00',99.99,'Cartão de Crédito',1,11),(23,'2025-02-02 11:10:00',199.99,'Boleto',1,12),(24,'2025-02-03 12:10:00',299.99,'Dinheiro',1,13),(25,'2025-02-04 13:10:00',399.99,'Pix',1,14),(26,'2025-02-05 14:10:00',499.99,'Cartão de Crédito',1,15),(27,'2025-02-06 15:10:00',599.99,'Boleto',1,16),(28,'2025-02-07 16:10:00',699.99,'Dinheiro',1,17),(29,'2025-02-08 17:10:00',799.99,'Pix',1,18),(30,'2025-02-09 18:10:00',899.99,'Cartão de Crédito',1,19),(31,'2025-02-10 19:10:00',999.99,'Boleto',1,20),(32,'2025-02-04 17:10:24',499995,'Cartão de Crédito',1,11),(33,'2025-02-04 17:11:08',499995,'Cartão de Crédito',1,11);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador único do vendedor',
  `nome` varchar(100) DEFAULT NULL COMMENT 'Nome completo do vendedor',
  `cpf` varchar(14) DEFAULT NULL COMMENT 'Cadastro de Pessoa Física (CPF) do vendedor',
  `cnpj` varchar(18) DEFAULT NULL COMMENT 'Cadastro Nacional de Pessoa Jurídica (CNPJ), caso aplicável',
  `email` varchar(100) DEFAULT NULL COMMENT 'Endereço de e-mail do vendedor',
  `senha` varchar(100) DEFAULT NULL COMMENT 'Senha de acesso do vendedor',
  `telefone` varchar(15) DEFAULT NULL COMMENT 'Número de telefone do vendedor',
  `dataNascimento` date DEFAULT NULL COMMENT 'Data de nascimento do vendedor',
  `nacionalidade` varchar(50) DEFAULT NULL COMMENT 'País de origem do vendedor',
  `genero` varchar(10) DEFAULT NULL COMMENT 'Gênero do vendedor',
  `endereco_id` int DEFAULT NULL COMMENT 'Referência ao endereço do vendedor',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `cnpj` (`cnpj`),
  UNIQUE KEY `email` (`email`),
  KEY `endereco_id` (`endereco_id`),
  CONSTRAINT `vendedor_ibfk_1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (21,'Vendedor 1','12345678911','12345678000100','vendedor1@exemplo.com','senha1','31999999999','1985-01-01','Brasil','Masculino',11),(22,'Vendedor 2','12345678912','12345678000101','vendedor2@exemplo.com','senha2','31988888888','1986-02-02','Brasil','Feminino',12),(23,'Vendedor 3','12345678913','12345678000102','vendedor3@exemplo.com','senha3','31977777777','1987-03-03','Brasil','Masculino',13),(24,'Vendedor 4','12345678914','12345678000103','vendedor4@exemplo.com','senha4','31966666666','1988-04-04','Brasil','Feminino',14),(25,'Vendedor 5','12345678915','12345678000104','vendedor5@exemplo.com','senha5','31955555555','1989-05-05','Brasil','Masculino',15),(26,'Vendedor 6','12345678916','12345678000105','vendedor6@exemplo.com','senha6','31944444444','1990-06-06','Brasil','Feminino',16),(27,'Vendedor 7','12345678917','12345678000106','vendedor7@exemplo.com','senha7','31933333333','1991-07-07','Brasil','Masculino',17),(28,'Vendedor 8','12345678918','12345678000107','vendedor8@exemplo.com','senha8','31922222222','1992-08-08','Brasil','Feminino',18),(29,'Vendedor 9','12345678919','12345678000108','vendedor9@exemplo.com','senha9','31911111111','1993-09-09','Brasil','Masculino',19),(30,'Vendedor 10','12345678920','12345678000109','vendedor10@exemplo.com','senha10','31900000000','1994-10-10','Brasil','Feminino',20);
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-04 17:38:06
