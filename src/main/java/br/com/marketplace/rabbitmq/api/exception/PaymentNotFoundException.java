package br.com.marketplace.rabbitmq.api.exception;

public class PaymentNotFoundException extends RuntimeException{

    public PaymentNotFoundException(){
        super("Nenhum pagamento encontrado !");
    }

    public PaymentNotFoundException(String msg){
        super(msg);
    }
}
