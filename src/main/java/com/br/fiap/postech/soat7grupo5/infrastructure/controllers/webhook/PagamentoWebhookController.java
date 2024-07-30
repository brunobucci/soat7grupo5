package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.webhook;

import java.util.Objects;

import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.postech.soat7grupo5.application.usecases.PedidoInteractor;
import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;
import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido.StatusPagamentoConstantes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "PagamentoWebhook", description = "Recursos relacionados aos produtos.")
@RequestMapping(path="pagamento-webhook", produces=MediaType.APPLICATION_JSON_VALUE)
public class PagamentoWebhookController {

	private final PedidoInteractor pedidoInteractor; 

	public PagamentoWebhookController(PedidoInteractor pedidoInteractor) {
		this.pedidoInteractor = pedidoInteractor;
	}
	
    @PostMapping
    @Operation(summary = "Realiza o cadastro do produto.")
    void recebeDados(@RequestBody WebhookNotificacaoRequest request) {
    	atualizarStatusPagamento(request);
    }

    @Async
    void atualizarStatusPagamento(WebhookNotificacaoRequest webhookNotificacaoPayload) {
		Pedido pedido = pedidoInteractor.buscarPedidoPorId(webhookNotificacaoPayload.idPedido());
		if (Objects.nonNull(pedido)) {
			if(webhookNotificacaoPayload.pagamentoAprovado()) {
				pedidoInteractor.atualizarStatusPagamento(pedido.getIdPedido(), StatusPagamentoConstantes.APROVADO);
			}
			else {
				pedidoInteractor.atualizarStatusPagamento(pedido.getIdPedido(), StatusPagamentoConstantes.REPROVADO);
			}
		}
	}
}
