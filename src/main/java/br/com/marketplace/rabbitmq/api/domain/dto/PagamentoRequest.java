package br.com.marketplace.rabbitmq.api.domain.dto;

import br.com.marketplace.rabbitmq.api.domain.entity.Pagamento;
import br.com.marketplace.rabbitmq.api.domain.enums.MetodoPagamentoEnum;
import br.com.marketplace.rabbitmq.api.domain.enums.StatusPagamentoEnum;

public record PagamentoRequest(String nome, String cpf, Long codigo, MetodoPagamentoEnum metodoPagamento, StatusPagamentoEnum status, double valor) {

    public PagamentoRequest(Pagamento pagamento){
        this(
            pagamento.getUsuario().getNome(),
            pagamento.getUsuario().getCpf(),
            pagamento.getCodigo(),
            pagamento.getMetodoPagamento(),
            pagamento.getStatus(),
            pagamento.getValor());
    }
}
