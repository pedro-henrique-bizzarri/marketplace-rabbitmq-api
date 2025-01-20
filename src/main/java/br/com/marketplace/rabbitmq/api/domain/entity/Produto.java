package br.com.marketplace.rabbitmq.api.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "produto", sequenceName = "sq_produto", allocationSize = 1, initialValue = 1)
public class Produto {

    @Id
    @Column(name="cod_produto")
    @GeneratedValue(generator="produto",strategy=GenerationType.SEQUENCE)
    private Long codigo;

    @Column(nullable = false)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private int estoque;
}
