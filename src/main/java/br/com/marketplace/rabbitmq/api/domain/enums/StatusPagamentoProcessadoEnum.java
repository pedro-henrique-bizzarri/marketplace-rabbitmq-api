package br.com.marketplace.rabbitmq.api.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusPagamentoProcessadoEnum {

    SUCESSO("Sucesso"),
    ERRO("Erro");

    private String descricao;
}
