package org.example.cart;

public class CartEmptyException extends RuntimeException {
    public CartEmptyException(String message) {
        super(message);
    }
}
