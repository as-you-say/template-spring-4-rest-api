package org.example.template.exception.account;

public class AccountIsNotModifiedException extends RuntimeException {
    public AccountIsNotModifiedException(String message) {
        super(message);
    }
}
