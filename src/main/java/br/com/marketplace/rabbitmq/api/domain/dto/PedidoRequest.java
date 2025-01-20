package br.com.marketplace.rabbitmq.api.domain.dto;

import java.util.List;

import br.com.marketplace.rabbitmq.api.domain.entity.Pagamento;
import br.com.marketplace.rabbitmq.api.domain.enums.MetodoPagamentoEnum;
import jakarta.validation.constraints.NotNull;

public record PedidoRequest(
    
    @NotNull(message = "O metodo de pagamento não pode ser nulo")
    MetodoPagamentoEnum metodoPagamento, 
    
    @NotNull(message = "O codigo do pedido não pode ser nulo")
    Long codigoUsuario,
    
    List<ItemRequest> items,
    
    String observacao) {

    public Pagamento toPagamento(){
        return new Pagamento(metodoPagamento, codigoUsuario, items, observacao);
    }
}
