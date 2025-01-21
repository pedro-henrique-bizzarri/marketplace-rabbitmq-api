package br.com.marketplace.rabbitmq.api.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.marketplace.rabbitmq.api.domain.dto.PagamentoProcessadoRequest;
import br.com.marketplace.rabbitmq.api.service.PagamentoService;

@Component
public class PagamentoConsumer {

    @Autowired
    private PagamentoService pagamentoService;

    @RabbitListener(queues = RabbitMQConstants.QUEUE_PAYMENT_PROCESSED)
    public void consumirFilaPagamentoProcessado(PagamentoProcessadoRequest pagamento){
        pagamentoService.atualizarPagamentoProcessado(pagamento.codigoPagamento(), pagamento.status());
        System.out.println(
            "\n O sistema recebeu uma mensagem do RabbitMQ, fila: " + RabbitMQConstants.QUEUE_PAYMENT_PROCESSED +
            "\n Pagamento Processado | Status: " + pagamento.codigoPagamento().toString() + " Pagamento: " + pagamento.status().toString());
    }
}
