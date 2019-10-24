package com.honor.simulator.order.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler {

    public static class ErrorObject {
        private List<String> error;



        public List<String> getError() {
            return error;
        }
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorObject> constraintExceptionHandler(MethodArgumentNotValidException ex) {
        List<String> exceptionMessages = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(x -> exceptionMessages.add(
                x.getField() + ": " + x.getDefaultMessage()
        ));
        ErrorObject errorObject = new ErrorObject();
        errorObject.error = exceptionMessages;
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
