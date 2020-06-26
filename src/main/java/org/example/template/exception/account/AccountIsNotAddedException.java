package org.example.template.exception.account;

public class AccountIsNotAddedException extends RuntimeException {
    public AccountIsNotAddedException(String message) {
        super(message);
    }
}
