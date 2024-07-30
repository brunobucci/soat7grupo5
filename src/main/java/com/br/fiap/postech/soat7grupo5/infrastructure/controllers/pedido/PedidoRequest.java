package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido;

import java.util.Date;

public record PedidoRequest(int idPedido, Double preco, int idStatusPedido, int idCliente, int idTipoPagamento, int duracaoTotalPreparo, Date dataCriacao, int idStatusPagamento) {

}
