package br.com.marketplace.rabbitmq.api.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.marketplace.rabbitmq.api.domain.dto.PagamentoProcessado;
import br.com.marketplace.rabbitmq.api.domain.entity.Pagamento;
import br.com.marketplace.rabbitmq.api.service.PagamentoService;

@Component
public class PagamentoConsumer {

    @Autowired
    private PagamentoService pagamentoService;

    @RabbitListener(queues = RabbitMQConstants.QUEUE_PAYMENT_PROCESSED)
    public void consumirFilaPagamentoProcessado(String pagamentoJson){
        PagamentoProcessado pagamentoProcessado = new Gson().fromJson(pagamentoJson, PagamentoProcessado.class);

        System.out.println(
            "\n" + RabbitMQConstants.getDataHoraAtualSistema() + " O sistema recebeu uma mensagem do RabbitMQ, fila: " + RabbitMQConstants.QUEUE_PAYMENT_PROCESSED +
            "\n" + RabbitMQConstants.getDataHoraAtualSistema() + " Pagamento Processado | Status: " + pagamentoProcessado.getCodigoPagamento().toString() + " Pagamento: " + pagamentoProcessado.getStatus().toString() +
            "\n" + RabbitMQConstants.getDataHoraAtualSistema() + " Processando pagamento...\n");

        Pagamento pagamentoAlterado = pagamentoService.atualizarPagamentoProcessado(pagamentoProcessado.getCodigoPagamento(), pagamentoProcessado.getStatus());

        System.out.println(
            RabbitMQConstants.getDataHoraAtualSistema() + "\nO sistema alterou o status do pedido " + 
                pagamentoProcessado.getCodigoPagamento() + " para " + 
                pagamentoAlterado.getPedido().getStatus().toString() + "\n");    
    }

}
