package com.br.fiap.postech.soat7grupo5.infrastructure.controllers.webhook;

import java.util.Objects;

import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.AtualizarStatusPagamentoInteractor;
import com.br.fiap.postech.soat7grupo5.application.usecases.pedido.BuscarPedidoPorIdInteractor;
import com.br.fiap.postech.soat7grupo5.domain.entity.Pedido;
import com.br.fiap.postech.soat7grupo5.infrastructure.controllers.pedido.StatusPagamentoConstantes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "PagamentoWebhook", description = "Webhook para atualização de status de pagamento dos pedidos.")
@RequestMapping(path="pagamento-webhook", produces=MediaType.APPLICATION_JSON_VALUE)
public class PagamentoWebhookController {

	private final BuscarPedidoPorIdInteractor buscarPedidoPorIdInteractor; 
	private final AtualizarStatusPagamentoInteractor atualizarStatusPagamentoInteractor;

	public PagamentoWebhookController(BuscarPedidoPorIdInteractor buscarPedidoPorIdInteractor, AtualizarStatusPagamentoInteractor atualizarStatusPagamentoInteractor) {
		this.buscarPedidoPorIdInteractor = buscarPedidoPorIdInteractor;
		this.atualizarStatusPagamentoInteractor = atualizarStatusPagamentoInteractor;
	}
	
    @PostMapping
    @Operation(summary = "Recebe dados e atualiza status do pagamento.")
    void recebeDados(@RequestBody WebhookNotificacaoRequest request) {
    	atualizarStatusPagamento(request);
    }

    @Async
    void atualizarStatusPagamento(WebhookNotificacaoRequest webhookNotificacaoPayload) {
		Pedido pedido = buscarPedidoPorIdInteractor.buscarPedidoPorId(webhookNotificacaoPayload.idPedido());
		if (Objects.nonNull(pedido)) {
			if(webhookNotificacaoPayload.pagamentoAprovado()) {
				atualizarStatusPagamentoInteractor.atualizarStatusPagamento(pedido.getIdPedido(), StatusPagamentoConstantes.APROVADO);
			}
			else {
				atualizarStatusPagamentoInteractor.atualizarStatusPagamento(pedido.getIdPedido(), StatusPagamentoConstantes.REPROVADO);
			}
		}
	}
}
