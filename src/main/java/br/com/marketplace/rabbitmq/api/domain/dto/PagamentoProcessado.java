package br.com.marketplace.rabbitmq.api.domain.dto;

import br.com.marketplace.rabbitmq.api.domain.enums.StatusPagamentoProcessadoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoProcessado {

    private StatusPagamentoProcessadoEnum status; 
    
    private Long codigoPagamento;
}
