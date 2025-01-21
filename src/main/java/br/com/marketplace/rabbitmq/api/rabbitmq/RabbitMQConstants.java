package br.com.marketplace.rabbitmq.api.rabbitmq;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RabbitMQConstants {

    public static final String EXCHANGE_NAME = "amq.direct";

    public static final String QUEUE_PAYMENT = "RB_MARKETPLACE_PAYMENT";

    public static final String QUEUE_PAYMENT_PROCESSED = "RB_MARKETPLACE_PAYMENT_PROCESSED";

    public static String getDataHoraAtualSistema(){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("[yyyy-MM-dd HH:mm:ss]");
        return agora.format(formato);
    }
}
