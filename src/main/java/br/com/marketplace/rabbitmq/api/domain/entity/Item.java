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
@Table(name = "tb_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "item", sequenceName = "sq_item", allocationSize = 1, initialValue = 1)
public class Item {

    @Id
    @Column(name="cod_item")
    @GeneratedValue(generator="item",strategy=GenerationType.SEQUENCE)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "cod_produto", nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private int quantidade;
}
