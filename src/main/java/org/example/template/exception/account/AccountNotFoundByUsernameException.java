package org.example.template.exception.account;

public class AccountNotFoundByUsernameException extends RuntimeException {
    public AccountNotFoundByUsernameException(String message) {
        super(message);
    }
}
