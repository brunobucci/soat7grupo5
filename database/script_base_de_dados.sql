SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Banco de dados: `soat7grupo5`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) CHARACTER SET ucs2 COLLATE ucs2_general_ci DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `cpf` varchar(11) CHARACTER SET ucs2 COLLATE ucs2_general_ci NOT NULL,
  `id_campanha` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_cliente`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=ucs2;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `Nome`, `Email`, `cpf`, `id_campanha`) VALUES
(1, 'Marcelo Nome Completo', 'marcelo-email@email.com.br', '34133413831', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente_seq`
--

DROP TABLE IF EXISTS `cliente_seq`;
CREATE TABLE IF NOT EXISTS `cliente_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=ucs2;

--
-- Extraindo dados da tabela `cliente_seq`
--

INSERT INTO `cliente_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `id_pedido` int NOT NULL,
  `id_cliente` int DEFAULT NULL,
  `id_status` int DEFAULT NULL,
  `id_pagamento` int DEFAULT '1',
  `preco` double DEFAULT NULL,
  `duracao_total_preparo` int NOT NULL,
  `data_criacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_pedido`)
) ENGINE=MyISAM DEFAULT CHARSET=ucs2;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido_produto`
--

DROP TABLE IF EXISTS `pedido_produto`;
CREATE TABLE IF NOT EXISTS `pedido_produto` (
  `id_pedido_produto` int NOT NULL AUTO_INCREMENT,
  `id_pedido` int NOT NULL,
  `id_produto` int NOT NULL,
  `preco_produto` double DEFAULT NULL,
  `nome_produto` varchar(50) NOT NULL,
  `duracao_preparo` int NOT NULL,
  PRIMARY KEY (`id_pedido_produto`),
  KEY `FK1sojgctn8vt21b1tbuaou288m` (`id_pedido`)
) ENGINE=MyISAM AUTO_INCREMENT=54 DEFAULT CHARSET=ucs2;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido_produto_seq`
--

DROP TABLE IF EXISTS `pedido_produto_seq`;
CREATE TABLE IF NOT EXISTS `pedido_produto_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=ucs2;

--
-- Extraindo dados da tabela `pedido_produto_seq`
--

INSERT INTO `pedido_produto_seq` (`next_val`) VALUES
(151);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido_seq`
--

DROP TABLE IF EXISTS `pedido_seq`;
CREATE TABLE IF NOT EXISTS `pedido_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=ucs2;

--
-- Extraindo dados da tabela `pedido_seq`
--

INSERT INTO `pedido_seq` (`next_val`) VALUES
(451);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido_status`
--

DROP TABLE IF EXISTS `pedido_status`;
CREATE TABLE IF NOT EXISTS `pedido_status` (
  `ID_pedido_status` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_pedido_status`)
) ENGINE=MyISAM DEFAULT CHARSET=ucs2;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

DROP TABLE IF EXISTS `produto`;
CREATE TABLE IF NOT EXISTS `produto` (
  `ID_Produto` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) NOT NULL,
  `Descricao` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `duracao_preparo` int DEFAULT NULL,
  `id_tipo` int DEFAULT NULL,
  `fl_ativo` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID_Produto`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=ucs2;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`ID_Produto`, `Nome`, `Descricao`, `preco`, `duracao_preparo`, `id_tipo`, `fl_ativo`) VALUES
(1, 'Misto quente', 'Pão francês com presunto e queijo na chapa.', 10, 5, 1, 1),
(2, 'Queijo quente', 'Pão francês com queijo e tomate na chapa.', 8, 3, 1, 1),
(3, 'Suco de laranja', 'Suco de laranja 500ml.', 12, 7, 3, 1),
(4, 'Coca-cola', 'Refrigerante Coca-cola lata 350ml.', 8, 0, 3, 1),
(5, 'Sorvete', 'Picolé Tablito.', 15, 0, 4, 1),
(6, 'Cheese Burger', 'Pão de hambúrguer, carne e queijo.', 11, 7, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto_seq`
--

DROP TABLE IF EXISTS `produto_seq`;
CREATE TABLE IF NOT EXISTS `produto_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=ucs2;

--
-- Extraindo dados da tabela `produto_seq`
--

INSERT INTO `produto_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto_tipo`
--

DROP TABLE IF EXISTS `produto_tipo`;
CREATE TABLE IF NOT EXISTS `produto_tipo` (
  `ID_produto_tipo` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_produto_tipo`)
) ENGINE=MyISAM DEFAULT CHARSET=ucs2;

--
-- Extraindo dados da tabela `produto_tipo`
--

INSERT INTO `produto_tipo` (`ID_produto_tipo`, `nome`) VALUES
(1, 'Lanche'),
(2, 'Acompanhamento'),
(3, 'Bebida'),
(4, 'Sobremesa');
COMMIT;
