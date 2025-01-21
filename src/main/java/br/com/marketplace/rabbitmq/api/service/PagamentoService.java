package br.com.marketplace.rabbitmq.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marketplace.rabbitmq.api.domain.entity.Pagamento;
import br.com.marketplace.rabbitmq.api.domain.enums.StatusPagamentoEnum;
import br.com.marketplace.rabbitmq.api.domain.enums.StatusPagamentoProcessadoEnum;
import br.com.marketplace.rabbitmq.api.exception.PaymentNotFoundException;
import br.com.marketplace.rabbitmq.api.rabbitmq.PagamentoProducer;
import br.com.marketplace.rabbitmq.api.repository.PagamentoRepository;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoProducer pagamentoProducer;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento realizarPagamento(Pagamento pagamento){
        pagamento.setStatus(StatusPagamentoEnum.EM_PROCESSAMENTO);
        pagamento.setValor(pagamento.getPedido().getTotal());
        pagamento.setDataPagamento(new Date());
        Pagamento realizado = pagamentoRepository.save(pagamento);

        pagamentoProducer.enviarFilaPagamento(pagamento);

        return realizado;
    }

    public void atualizarPagamentoProcessado(Long codigoPagamento, StatusPagamentoProcessadoEnum status){
        Pagamento pagamento = new Pagamento();

        if (status.equals(StatusPagamentoProcessadoEnum.SUCESSO)) {
            pagamento = pesquisarPagamento(codigoPagamento);
            pagamento.setStatus(StatusPagamentoEnum.APROVADO);
        } else {
            pagamento = pesquisarPagamento(codigoPagamento);
            pagamento.setStatus(StatusPagamentoEnum.REPROVADO);
        }

        pagamentoRepository.save(pagamento);
    }

    public Pagamento pesquisarPagamento(Long codigo){
        return pagamentoRepository.findByCodigo(codigo).orElseThrow(
            PaymentNotFoundException::new);
    }

}
