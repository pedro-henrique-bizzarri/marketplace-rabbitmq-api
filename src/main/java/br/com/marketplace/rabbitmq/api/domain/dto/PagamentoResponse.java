package br.com.marketplace.rabbitmq.api.domain.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.marketplace.rabbitmq.api.domain.entity.Pagamento;
import br.com.marketplace.rabbitmq.api.domain.enums.MetodoPagamentoEnum;
import br.com.marketplace.rabbitmq.api.domain.enums.StatusPagamentoEnum;
import br.com.marketplace.rabbitmq.api.domain.enums.StatusPedidoEnum;

public record PagamentoResponse(
    MetodoPagamentoEnum metodoPagamento, 
    StatusPagamentoEnum statusPagamento, 
    Date dataPagamento, 
    Long codigoPedido,
    double valor,
    StatusPedidoEnum statusPedido, 
    String observacao,
    List<ItemResponse> items,
    String nomeUsuario) {

    public PagamentoResponse(Pagamento pagamento){
        this(
            pagamento.getMetodoPagamento(), 
            pagamento.getStatus(), 
            pagamento.getDataPagamento(), 
            pagamento.getPedido().getCodigo(), 
            pagamento.getValor(), 
            pagamento.getPedido().getStatus(), 
            pagamento.getPedido().getObservacao(), 
            pagamento.getPedido().getItens()
                .stream()
                .map(item -> new ItemResponse(
                    item.getProduto().getNome(), 
                    item.getProduto().getDescricao(), 
                    item.getProduto().getPreco(), 
                    item.getQuantidade()))
                .collect(Collectors.toList()), 
            pagamento.getUsuario().getNome());
    }
}
