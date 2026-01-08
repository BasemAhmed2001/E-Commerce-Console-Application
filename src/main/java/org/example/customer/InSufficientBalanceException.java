package org.example.customer;

public class InSufficientBalanceException extends RuntimeException {
    public InSufficientBalanceException(String message) {
        super(message);
    }
}
