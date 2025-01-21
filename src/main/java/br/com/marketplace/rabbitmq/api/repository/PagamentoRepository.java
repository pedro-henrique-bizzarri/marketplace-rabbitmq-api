package br.com.marketplace.rabbitmq.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marketplace.rabbitmq.api.domain.entity.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    public Optional<Pagamento> findByCodigo(Long codigo);
}
