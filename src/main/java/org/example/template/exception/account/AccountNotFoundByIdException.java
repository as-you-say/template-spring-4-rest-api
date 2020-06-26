package org.example.template.exception.account;

public class AccountNotFoundByIdException extends RuntimeException {
    public AccountNotFoundByIdException(String message) {
        super(message);
    }
}
