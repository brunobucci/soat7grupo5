CREATE TABLE `cliente` (
  `id` integer PRIMARY KEY,
  `name` varchar2,
  `email` varchar2,
  `cpf` integer,
  `campanha_id` integer
);

CREATE TABLE `produto` (
  `id` integer PRIMARY KEY,
  `name` varchar2,
  `description` text,
  `image` blob,
  `price` decimal,
  `prepare_duration` integer,
  `tipo_id` integer
);

CREATE TABLE `produto_tipo` (
  `id` integer PRIMARY KEY,
  `name` varchar2
);

CREATE TABLE `pedido` (
  `id` integer PRIMARY KEY,
  `cliente_id` integer,
  `produto_id` integer,
  `name` varchar2,
  `description` text,
  `price` decimal,
  `prepare_duration` integer,
  `status_id` integer,
  `pagamento_id` integer,
  `timestamp` timestamp
);

CREATE TABLE `pedido_status` (
  `id` integer PRIMARY KEY,
  `name` varchar2
);

CREATE TABLE `campanha` (
  `id` integer PRIMARY KEY,
  `name` varchar2,
  `percentual` decimal
);

CREATE TABLE `pedido_pagamento` (
  `id` integer PRIMARY KEY,
  `name` varchar2,
  `pagamento_forma_id` integer
);

CREATE TABLE `pagamento_forma` (
  `id` integer PRIMARY KEY,
  `name` varchar2
);

ALTER TABLE `campanha` ADD FOREIGN KEY (`id`) REFERENCES `cliente` (`campanha_id`);

ALTER TABLE `cliente` ADD FOREIGN KEY (`id`) REFERENCES `pedido` (`cliente_id`);

ALTER TABLE `pedido` ADD FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`);

ALTER TABLE `pedido_status` ADD FOREIGN KEY (`id`) REFERENCES `pedido` (`status_id`);

ALTER TABLE `pedido_pagamento` ADD FOREIGN KEY (`id`) REFERENCES `pedido` (`pagamento_id`);

ALTER TABLE `pagamento_forma` ADD FOREIGN KEY (`id`) REFERENCES `pedido_pagamento` (`pagamento_forma_id`);

ALTER TABLE `produto` ADD FOREIGN KEY (`tipo_id`) REFERENCES `produto_tipo` (`id`);
