package br.com.marketplace.rabbitmq.api.domain.dto;

import br.com.marketplace.rabbitmq.api.domain.enums.StatusPagamentoProcessadoEnum;

public record PagamentoProcessadoRequest (StatusPagamentoProcessadoEnum status, Long codigoPagamento) {

}
