package br.com.marketplace.rabbitmq.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marketplace.rabbitmq.api.domain.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    public Optional<Produto> findByCodigo(Long codigo);
}
