package com.jackson.eventdriven.inventory.exception;

public class StockUnavailableException extends RuntimeException {

    public StockUnavailableException (String message) {
        super(message);
    }
}