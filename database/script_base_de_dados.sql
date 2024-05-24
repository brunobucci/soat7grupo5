CREATE TABLE `cliente` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255),
  `email` VARCHAR(255),
  `cpf` VARCHAR(11),
  `campanha_id` INT
);

CREATE TABLE `produto` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255),
  `description` TEXT,
  `image` BLOB,
  `price` DECIMAL(10, 2),
  `prepare_duration` INT,
  `tipo_id` INT
);

CREATE TABLE `produto_tipo` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255)
);

CREATE TABLE `pedido` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `cliente_id` INT,
  `produto_id` INT,
  `name` VARCHAR(255),
  `description` TEXT,
  `price` DECIMAL(10, 2),
  `prepare_duration` INT,
  `status_id` INT,
  `pagamento_id` INT,
  `timestamp` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `pedido_status` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255)
);

CREATE TABLE `campanha` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255),
  `percentual` DECIMAL(5, 2)
);

CREATE TABLE `pedido_pagamento` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255),
  `pagamento_forma_id` INT
);

CREATE TABLE `pagamento_forma` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255)
);

ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_campanha` FOREIGN KEY (`campanha_id`) REFERENCES `campanha` (`id`);

ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_pedido_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `fk_pedido_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`),
  ADD CONSTRAINT `fk_pedido_status` FOREIGN KEY (`status_id`) REFERENCES `pedido_status` (`id`),
  ADD CONSTRAINT `fk_pedido_pagamento` FOREIGN KEY (`pagamento_id`) REFERENCES `pedido_pagamento` (`id`);

ALTER TABLE `produto`
  ADD CONSTRAINT `fk_produto_tipo` FOREIGN KEY (`tipo_id`) REFERENCES `produto_tipo` (`id`);

ALTER TABLE `pedido_pagamento`
  ADD CONSTRAINT `fk_pagamento_forma` FOREIGN KEY (`pagamento_forma_id`) REFERENCES `pagamento_forma` (`id`);
