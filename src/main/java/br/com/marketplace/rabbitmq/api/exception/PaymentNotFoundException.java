package br.com.marketplace.rabbitmq.api.exception;

public class PaymentNotFoundException extends RuntimeException{

    public PaymentNotFoundException(){
        super("Pagamento não encontrado !");
    }

    public PaymentNotFoundException(String var, String msg, Throwable cause){
        super(msg, cause);
    }
}
