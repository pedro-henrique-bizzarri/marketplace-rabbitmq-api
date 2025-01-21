package br.com.marketplace.rabbitmq.api.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.marketplace.rabbitmq.api.domain.dto.PagamentoQueueRequest;
import br.com.marketplace.rabbitmq.api.domain.entity.Pagamento;

@Component
public class PagamentoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarFilaPagamento(Pagamento pagamento){
        rabbitTemplate.convertAndSend(
            RabbitMQConstants.QUEUE_PAYMENT,
            new Gson().toJson(new PagamentoQueueRequest(pagamento)));
    }
}
