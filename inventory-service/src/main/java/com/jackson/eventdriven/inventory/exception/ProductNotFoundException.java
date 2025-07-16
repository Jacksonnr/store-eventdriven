package com.jackson.eventdriven.inventory.exception;

public class ProductNotFoundException extends RuntimeException {

        public ProductNotFoundException(String message) {
            super(message);
        }
}
