package br.com.marketplace.rabbitmq.api.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super("Usuario não encontrado !");
    }

    public UserNotFoundException(String var, String msg, Throwable cause){
        super(msg, cause);
    }
}
