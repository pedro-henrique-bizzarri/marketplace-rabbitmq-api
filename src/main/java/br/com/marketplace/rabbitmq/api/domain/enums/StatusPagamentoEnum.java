package br.com.marketplace.rabbitmq.api.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusPagamentoEnum {

    APROVADO("Pagamento aprovado"),
    EM_PROCESSAMENTO("Pagamento em processamento"),
    REPROVADO("Pagamento reprovado");

    private String descricao;
}
