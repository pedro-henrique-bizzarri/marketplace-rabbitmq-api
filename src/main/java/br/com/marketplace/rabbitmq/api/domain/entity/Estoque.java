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
@Table(name = "tb_estoque")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "estoque", sequenceName = "sq_estoque", allocationSize = 1, initialValue = 1)
public class Estoque {

    @Id
    @Column(name="cod_estoque")
    @GeneratedValue(generator="estoque",strategy=GenerationType.SEQUENCE)
    private Long codigo;
}
