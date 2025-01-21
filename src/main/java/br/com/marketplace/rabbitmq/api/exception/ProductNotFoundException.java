package br.com.marketplace.rabbitmq.api.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){
        super("Nenhum produto não encontrado !");
    }

    public ProductNotFoundException(String msg){
        super(msg);
    }
}
