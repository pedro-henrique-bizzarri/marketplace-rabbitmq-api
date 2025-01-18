package br.com.marketplace.rabbitmq.api.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusPedidoEnum {

    AGUARDANDO_PAGAMENTO("Aguardadndo pagamento"),
    AGUARDANDO_PROCESSAMENTO("Aguardando processamento"),
    EM_SEPARACAO("Em separacao do estoque"),
    ENVIADO("Enviado"),
    FINALIZADO("Finalizado");

    private String descricao;
}
