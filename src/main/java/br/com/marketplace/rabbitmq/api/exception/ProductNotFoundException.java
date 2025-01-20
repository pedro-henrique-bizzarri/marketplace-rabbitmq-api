package br.com.marketplace.rabbitmq.api.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){
        super("Produto não encontrado !");
    }

    public ProductNotFoundException(String var, String msg, Throwable cause){
        super(msg, cause);
    }
}
