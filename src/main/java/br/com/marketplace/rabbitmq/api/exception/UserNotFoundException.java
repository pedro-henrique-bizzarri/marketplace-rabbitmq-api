package br.com.marketplace.rabbitmq.api.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super("NeNhum usuário encontrado !");
    }

    public UserNotFoundException(String msg){
        super(msg);
    }
}
