package br.com.marketplace.rabbitmq.api.domain.entity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.marketplace.rabbitmq.api.domain.dto.ItemRequest;
import br.com.marketplace.rabbitmq.api.domain.enums.MetodoPagamentoEnum;
import br.com.marketplace.rabbitmq.api.domain.enums.StatusPagamentoEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "pagamento", sequenceName = "sq_pagamento", allocationSize = 1, initialValue = 1)
public class Pagamento {

    @Id
    @Column(name="cod_pagamento")
    @GeneratedValue(generator="pagamento",strategy=GenerationType.SEQUENCE)
    private Long codigo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MetodoPagamentoEnum metodoPagamento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum status;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPagamento;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_usuario", nullable = false)
    private Usuario usuario;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;

    public Pagamento(MetodoPagamentoEnum metodoPagamento, long codigoUsuario, List<ItemRequest> items, String observacao) {
        this.metodoPagamento = metodoPagamento;
        this.pedido = new Pedido(
            null, 
            null, 
            null, 
            0, 
            items
                .stream()
                .map(item -> new ItemPedido(
                    item.codigoProduto(), 
                    item.quantidade()))
                .collect(Collectors.toList()), 
            observacao, 
            dataCriacao, 
            dataUltimaAtualizacao);

        this.usuario = new Usuario(
            codigoUsuario, 
            null, 
            null, 
            null, 
            null);
    }

}
