package br.com.marketplace.rabbitmq.api.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_item_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "item_pedido", sequenceName = "sq_item_pedido", allocationSize = 1, initialValue = 1)
public class ItemPedido {

    @Id
    @Column(name="cod_item_pedido")
    @GeneratedValue(generator="item_pedido",strategy=GenerationType.SEQUENCE)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "cod_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "cod_produto", nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private int quantidade;

    public ItemPedido(Long codigoProduto, int quantidade) {
        this.produto = new Produto(codigoProduto, null, null, 0, 0);
        this.quantidade = quantidade;
    }

}
