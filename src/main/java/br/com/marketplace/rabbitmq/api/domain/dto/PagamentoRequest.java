package br.com.marketplace.rabbitmq.api.domain.dto;

import br.com.marketplace.rabbitmq.api.domain.entity.Pagamento;

public record PagamentoRequest(String nome, double valor) {

    public PagamentoRequest(Pagamento pagamento){
        this(
            pagamento.getUsuario().getNome(),
            pagamento.getValor());
    }
}
