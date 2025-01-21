package br.com.marketplace.rabbitmq.api.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.marketplace.rabbitmq.api.domain.dto.PagamentoRequest;
import br.com.marketplace.rabbitmq.api.domain.entity.Pagamento;

@Component
public class PagamentoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarFilaPagamento(Pagamento pagamento){
        String json = new Gson().toJson(new PagamentoRequest(pagamento));

        rabbitTemplate.convertAndSend(RabbitMQConstants.QUEUE_PAYMENT, json);
            
        System.out.println(
            "\nO sistema enviou uma mensagem para o RabbitMQ, fila: " + RabbitMQConstants.QUEUE_PAYMENT +
            "\nPagamento: " + json);
    }
}
