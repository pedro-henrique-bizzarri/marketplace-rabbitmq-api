package br.com.marketplace.rabbitmq.api.rabbitmq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class RabbitMQConnection {

    @Autowired
    private AmqpAdmin amqpAdmin;

    private Queue queue(String nome){
        return new Queue(nome, true, false, false);
    }

    private DirectExchange directExchange(){
        return new DirectExchange(RabbitMQConstants.EXCHANGE_NAME);
    }

    private Binding binding(Queue queue, DirectExchange directExchange){
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, directExchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    public void declareQueues(){
        // Criando fila de pagamento
        Queue paymentQueue = queue(RabbitMQConstants.QUEUE_PAYMENT);
        DirectExchange paymentDirectExchange = directExchange();
        Binding paymentBinding = binding(paymentQueue, paymentDirectExchange);

        amqpAdmin.declareQueue(paymentQueue);
        amqpAdmin.declareExchange(paymentDirectExchange);
        amqpAdmin.declareBinding(paymentBinding);

        //Criando fila de resposta do pagamento
        Queue paymentProcessedQueue = queue(RabbitMQConstants.QUEUE_PAYMENT_PROCESSED);
        DirectExchange paymentProcessedDirectExchange = directExchange();
        Binding paymentProcessedBinding = binding(paymentQueue, paymentDirectExchange);

        amqpAdmin.declareQueue(paymentProcessedQueue);
        amqpAdmin.declareExchange(paymentProcessedDirectExchange);
        amqpAdmin.declareBinding(paymentProcessedBinding);
    }
}
