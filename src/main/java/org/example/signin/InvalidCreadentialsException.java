package org.example.signin;

public class InvalidCreadentialsException extends RuntimeException {
    public InvalidCreadentialsException(String message) {
        super(message);
    }
}
