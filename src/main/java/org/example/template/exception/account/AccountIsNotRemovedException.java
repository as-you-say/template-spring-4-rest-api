package org.example.template.exception.account;

public class AccountIsNotRemovedException extends RuntimeException {
    public AccountIsNotRemovedException(String message) {
        super(message);
    }
}
