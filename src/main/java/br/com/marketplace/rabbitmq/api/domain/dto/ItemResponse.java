package br.com.marketplace.rabbitmq.api.domain.dto;

public record ItemResponse(String produto, String descricao, double preco, int quantidade) {

}
