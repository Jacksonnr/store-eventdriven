package com.jackson.eventdriven.inventory.exception;

public class InvalidUUIDException extends RuntimeException {
    public InvalidUUIDException (String message) {
        super(message);
    }
}
