package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.webhook;

public record WebhookNotificacaoRequest(int idPedido, boolean pagamentoAprovado) {

}
