package com.jackson.eventdriven.inventory.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ErrorMessage> productNotFound (ProductNotFoundException ex) {
        ErrorMessage error = new ErrorMessage(404, ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessage> BadRequest (BadRequestException ex) {
        ErrorMessage error = new ErrorMessage(400, ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(StockUnavailableException.class)
    public ResponseEntity<ErrorMessage> StockUnavailable (StockUnavailableException ex) {
        ErrorMessage error = new ErrorMessage(422, ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }

    @ExceptionHandler(InvalidUUIDException.class)
    public ResponseEntity<ErrorMessage> InvalidUUID (InvalidUUIDException ex) {
        ErrorMessage error = new ErrorMessage(400, ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> Unexpected() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage(500, "Erro interno no servidor. Tente novamente mais tarde.", LocalDateTime.now()));
    }



}