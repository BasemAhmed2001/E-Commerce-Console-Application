package org.example.product;

public class ProductExpiredException extends RuntimeException {
    public ProductExpiredException(String message) {
        super(message);
    }
}
