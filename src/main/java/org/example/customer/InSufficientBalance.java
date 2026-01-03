package org.example.customer;

public class InSufficientBalance extends RuntimeException {
    public InSufficientBalance(String message) {
        super(message);
    }
}
