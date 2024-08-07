    CREATE USER 'soat7grupo5'@'%' IDENTIFIED BY 'soat7grupo5';
    GRANT ALL PRIVILEGES ON *.* TO 'soat7grupo5'@'%';

    USE soat7grupo5;

    --
    -- Table structure for table `cliente`
    --

    DROP TABLE IF EXISTS `cliente`;
    /*!40101 SET @saved_cs_client     = @@character_set_client */;
    /*!50503 SET character_set_client = utf8mb4 */;
    CREATE TABLE `cliente` (
      `id_cliente` int NOT NULL AUTO_INCREMENT,
      `Nome` varchar(255) CHARACTER SET ucs2 COLLATE ucs2_general_ci DEFAULT NULL,
      `Email` varchar(255) DEFAULT NULL,
      `cpf` varchar(11) CHARACTER SET ucs2 COLLATE ucs2_general_ci NOT NULL,
      `id_campanha` int NOT NULL DEFAULT '0',
      PRIMARY KEY (`id_cliente`)
    ) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=ucs2;
    /*!40101 SET character_set_client = @saved_cs_client */;


    --
    -- Dumping data for table `cliente`
    --

    LOCK TABLES `cliente` WRITE;
    /*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
    INSERT INTO `cliente` VALUES (1,'Marcelo Nome Completo','marcelo-email@email.com.br','34133413831',2);
    /*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
    UNLOCK TABLES;

    --
    -- Table structure for table `cliente_seq`
    --

    DROP TABLE IF EXISTS `cliente_seq`;
    /*!40101 SET @saved_cs_client     = @@character_set_client */;
    /*!50503 SET character_set_client = utf8mb4 */;
    CREATE TABLE `cliente_seq` (
      `next_val` bigint DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=ucs2;
    /*!40101 SET character_set_client = @saved_cs_client */;

    --
    -- Dumping data for table `cliente_seq`
    --

    LOCK TABLES `cliente_seq` WRITE;
    /*!40000 ALTER TABLE `cliente_seq` DISABLE KEYS */;
    INSERT INTO `cliente_seq` VALUES (51);
    /*!40000 ALTER TABLE `cliente_seq` ENABLE KEYS */;
    UNLOCK TABLES;

    --
    -- Table structure for table `pedido`
    --

    DROP TABLE IF EXISTS `pedido`;
    /*!40101 SET @saved_cs_client     = @@character_set_client */;
    /*!50503 SET character_set_client = utf8mb4 */;
    CREATE TABLE `pedido` (
      `id_pedido` int NOT NULL,
      `id_cliente` int DEFAULT NULL,
      `id_status` int DEFAULT NULL,
      `id_pagamento` int DEFAULT '1',
      `preco` double DEFAULT NULL,
      `duracao_total_preparo` int NOT NULL,
      `data_criacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
      PRIMARY KEY (`id_pedido`)
    ) ENGINE=MyISAM DEFAULT CHARSET=ucs2;
    /*!40101 SET character_set_client = @saved_cs_client */;

    --
    -- Dumping data for table `pedido`
    --

    LOCK TABLES `pedido` WRITE;
    /*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
    /*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
    UNLOCK TABLES;

    --
    -- Table structure for table `pedido_produto`
    --

    DROP TABLE IF EXISTS `pedido_produto`;
    /*!40101 SET @saved_cs_client     = @@character_set_client */;
    /*!50503 SET character_set_client = utf8mb4 */;
    CREATE TABLE `pedido_produto` (
      `id_pedido_produto` int NOT NULL AUTO_INCREMENT,
      `id_pedido` int NOT NULL,
      `id_produto` int NOT NULL,
      `preco_produto` double DEFAULT NULL,
      `nome_produto` varchar(50) NOT NULL,
      `duracao_preparo` int NOT NULL,
      PRIMARY KEY (`id_pedido_produto`),
      KEY `FK1sojgctn8vt21b1tbuaou288m` (`id_pedido`)
    ) ENGINE=MyISAM AUTO_INCREMENT=54 DEFAULT CHARSET=ucs2;
    /*!40101 SET character_set_client = @saved_cs_client */;

    --
    -- Dumping data for table `pedido_produto`
    --

    LOCK TABLES `pedido_produto` WRITE;
    /*!40000 ALTER TABLE `pedido_produto` DISABLE KEYS */;
    /*!40000 ALTER TABLE `pedido_produto` ENABLE KEYS */;
    UNLOCK TABLES;

    --
    -- Table structure for table `pedido_produto_seq`
    --

    DROP TABLE IF EXISTS `pedido_produto_seq`;
    /*!40101 SET @saved_cs_client     = @@character_set_client */;
    /*!50503 SET character_set_client = utf8mb4 */;
    CREATE TABLE `pedido_produto_seq` (
      `next_val` bigint DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=ucs2;
    /*!40101 SET character_set_client = @saved_cs_client */;

    --
    -- Dumping data for table `pedido_produto_seq`
    --

    LOCK TABLES `pedido_produto_seq` WRITE;
    /*!40000 ALTER TABLE `pedido_produto_seq` DISABLE KEYS */;
    INSERT INTO `pedido_produto_seq` VALUES (151);
    /*!40000 ALTER TABLE `pedido_produto_seq` ENABLE KEYS */;
    UNLOCK TABLES;

    --
    -- Table structure for table `pedido_seq`
    --

    DROP TABLE IF EXISTS `pedido_seq`;
    /*!40101 SET @saved_cs_client     = @@character_set_client */;
    /*!50503 SET character_set_client = utf8mb4 */;
    CREATE TABLE `pedido_seq` (
      `next_val` bigint DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=ucs2;
    /*!40101 SET character_set_client = @saved_cs_client */;

    --
    -- Dumping data for table `pedido_seq`
    --

    LOCK TABLES `pedido_seq` WRITE;
    /*!40000 ALTER TABLE `pedido_seq` DISABLE KEYS */;
    INSERT INTO `pedido_seq` VALUES (451);
    /*!40000 ALTER TABLE `pedido_seq` ENABLE KEYS */;
    UNLOCK TABLES;

    --
    -- Table structure for table `pedido_status`
    --

    DROP TABLE IF EXISTS `pedido_status`;
    /*!40101 SET @saved_cs_client     = @@character_set_client */;
    /*!50503 SET character_set_client = utf8mb4 */;
    CREATE TABLE `pedido_status` (
      `ID_pedido_status` int NOT NULL,
      `nome` varchar(255) NOT NULL,
      PRIMARY KEY (`ID_pedido_status`)
    ) ENGINE=MyISAM DEFAULT CHARSET=ucs2;
    /*!40101 SET character_set_client = @saved_cs_client */;

    --
    -- Dumping data for table `pedido_status`
    --

    LOCK TABLES `pedido_status` WRITE;
    /*!40000 ALTER TABLE `pedido_status` DISABLE KEYS */;
    /*!40000 ALTER TABLE `pedido_status` ENABLE KEYS */;
    UNLOCK TABLES;

    --
    -- Table structure for table `produto`
    --

    DROP TABLE IF EXISTS `produto`;
    /*!40101 SET @saved_cs_client     = @@character_set_client */;
    /*!50503 SET character_set_client = utf8mb4 */;
    CREATE TABLE `produto` (
      `ID_Produto` int NOT NULL AUTO_INCREMENT,
      `Nome` varchar(255) NOT NULL,
      `Descricao` varchar(255) DEFAULT NULL,
      `preco` double DEFAULT NULL,
      `duracao_preparo` int DEFAULT NULL,
      `id_tipo` int DEFAULT NULL,
      `fl_ativo` int NOT NULL DEFAULT '1',
      PRIMARY KEY (`ID_Produto`)
    ) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=ucs2;
    /*!40101 SET character_set_client = @saved_cs_client */;

    --
    -- Dumping data for table `produto`
    --

    LOCK TABLES `produto` WRITE;
    /*!40000 ALTER TABLE `produto` DISABLE KEYS */;
    INSERT INTO `produto` VALUES (1,'Misto quente','Pão francês com presunto e queijo na chapa.',10,5,1,1),(2,'Queijo quente','Pão francês com queijo e tomate na chapa.',8,3,1,1),(3,'Suco de laranja','Suco de laranja 500ml.',12,7,3,1),(4,'Coca-cola','Refrigerante Coca-cola lata 350ml.',8,0,3,1),(5,'Sorvete','Picolé Tablito.',15,0,4,1),(6,'Cheese Burger','Pão de hambúrguer, carne e queijo.',11,7,1,1);
    /*!40000 ALTER TABLE `produto` ENABLE KEYS */;
    UNLOCK TABLES;

    --
    -- Table structure for table `produto_seq`
    --

    DROP TABLE IF EXISTS `produto_seq`;
    /*!40101 SET @saved_cs_client     = @@character_set_client */;
    /*!50503 SET character_set_client = utf8mb4 */;
    CREATE TABLE `produto_seq` (
      `next_val` bigint DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=ucs2;
    /*!40101 SET character_set_client = @saved_cs_client */;

    --
    -- Dumping data for table `produto_seq`
    --

    LOCK TABLES `produto_seq` WRITE;
    /*!40000 ALTER TABLE `produto_seq` DISABLE KEYS */;
    INSERT INTO `produto_seq` VALUES (101);
    /*!40000 ALTER TABLE `produto_seq` ENABLE KEYS */;
    UNLOCK TABLES;

    --
    -- Table structure for table `produto_tipo`
    --

    DROP TABLE IF EXISTS `produto_tipo`;
    /*!40101 SET @saved_cs_client     = @@character_set_client */;
    /*!50503 SET character_set_client = utf8mb4 */;
    CREATE TABLE `produto_tipo` (
      `ID_produto_tipo` int NOT NULL,
      `nome` varchar(255) NOT NULL,
      PRIMARY KEY (`ID_produto_tipo`)
    ) ENGINE=MyISAM DEFAULT CHARSET=ucs2;
    /*!40101 SET character_set_client = @saved_cs_client */;

    --
    -- Dumping data for table `produto_tipo`
    --

    LOCK TABLES `produto_tipo` WRITE;
    /*!40000 ALTER TABLE `produto_tipo` DISABLE KEYS */;
    INSERT INTO `produto_tipo` VALUES (1,'Lanche'),(2,'Acompanhamento'),(3,'Bebida'),(4,'Sobremesa');
    /*!40000 ALTER TABLE `produto_tipo` ENABLE KEYS */;
    UNLOCK TABLES;