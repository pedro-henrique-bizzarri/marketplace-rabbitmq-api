package br.com.marketplace.rabbitmq.api.config;

import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.marketplace.rabbitmq.api.exception.CustomErrorMessage;
import br.com.marketplace.rabbitmq.api.exception.PaymentNotFoundException;
import br.com.marketplace.rabbitmq.api.exception.ProductNotFoundException;
import br.com.marketplace.rabbitmq.api.exception.UserNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorMessage> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        CustomErrorMessage errorMessage = new CustomErrorMessage();
        errorMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorMessage.setMessage(exception.getBindingResult().getFieldErrors()
                                        .stream()
                                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                        .collect(Collectors.toList())
                                    .toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CustomErrorMessage> userNotFoundException(UserNotFoundException exception) {
        CustomErrorMessage errorMessage = new CustomErrorMessage();
        errorMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorMessage.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }    

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<CustomErrorMessage> productNotFoundException(ProductNotFoundException exception){
        CustomErrorMessage errorMessage = new CustomErrorMessage();
        errorMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorMessage.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<CustomErrorMessage> paymentNotFoundException(PaymentNotFoundException exception){
        CustomErrorMessage errorMessage = new CustomErrorMessage();
        errorMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorMessage.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

 }
