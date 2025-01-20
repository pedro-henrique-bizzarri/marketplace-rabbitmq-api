package br.com.marketplace.rabbitmq.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marketplace.rabbitmq.api.domain.entity.Pagamento;
import br.com.marketplace.rabbitmq.api.domain.enums.StatusPagamentoEnum;
import br.com.marketplace.rabbitmq.api.repository.PagamentoRepository;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento realizarPagamento(Pagamento pagamento){
        pagamento.setStatus(StatusPagamentoEnum.EM_PROCESSAMENTO);
        pagamento.setValor(pagamento.getPedido().getTotal());
        pagamento.setDataPagamento(new Date());
        Pagamento realizado = pagamentoRepository.save(pagamento);

        return realizado;
    }

    

}
