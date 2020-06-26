package org.example.template.exception.accountRole;

public class AccountRoleNotFoundByIdException extends RuntimeException {
    public AccountRoleNotFoundByIdException(String message) {
        super(message);
    }
}
