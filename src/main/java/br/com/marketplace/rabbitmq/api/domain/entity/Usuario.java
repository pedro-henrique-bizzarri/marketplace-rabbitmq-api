package br.com.marketplace.rabbitmq.api.domain.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "usuario", sequenceName = "sq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario {

    @Id
    @Column(name="cod_usuario")
    @GeneratedValue(generator="usuario",strategy=GenerationType.SEQUENCE)
    private Long codigo;

    @Column(nullable = false)
    private String login;

    @Column(length = 12,nullable = false)
    private String cpf;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualiacao;
}
