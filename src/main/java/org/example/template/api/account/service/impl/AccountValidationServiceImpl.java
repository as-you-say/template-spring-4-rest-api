package org.example.template.api.account.service.impl;

import org.example.template.api.account.service.AccountValidationService;
import org.example.template.exception.account.AccountNotValidParameterException;
import org.example.template.model.Account;

public class AccountValidationServiceImpl implements AccountValidationService {

    @Override
    public void validateSelectAccountList(Account account) {
        Integer limit = account.getLimit();
        if (limit == null) {
            throw new AccountNotValidParameterException("Limit is null.");
        }
        if (limit <= 0) {
            throw new AccountNotValidParameterException("Limit is not valid - limit :" + limit);
        }

        Integer offset = account.getOffset();
        if (offset == null) {
            throw new AccountNotValidParameterException("Offset is null.");
        }
        if (offset <= 0) {
            throw new AccountNotValidParameterException("Offset is not valid - offset :" + offset);
        }
    }

    @Override
    public void validateSelectAccountById(Account account) {
        boolean idIsNull = account.getId() == null;
        if (idIsNull) {
            throw new AccountNotValidParameterException("Id is null.");
        }
    }

    @Override
    public void validateSelectAccountByUsername(Account account) {
        boolean usernameIsNull = account.getUsername() == null;
        if (usernameIsNull) {
            throw new AccountNotValidParameterException("Username is null.");
        }
    }

    @Override
    public void validateInsertAccount(Account account) {
        String username = account.getUsername();
        boolean usernameIsNull = username == null;
        if (usernameIsNull) {
            throw new AccountNotValidParameterException("Username is null.");
        }

        String password = account.getPassword();
        boolean passwordIsNull = password == null;
        if (passwordIsNull) {
            throw new AccountNotValidParameterException("Password is null.");
        }
    }

    @Override
    public void validateUpdateAccount(Account account) {
        String username = account.getUsername();
        boolean usernameIsNull = username == null;
        if (usernameIsNull) {
            throw new AccountNotValidParameterException("Username is null.");
        }

        String password = account.getPassword();
        boolean passwordIsNull = password == null;
        if (passwordIsNull) {
            throw new AccountNotValidParameterException("Password is null.");
        }
    }

    @Override
    public void validateDeleteAccount(Account account) {
        boolean idIsNull = account.getId() == null;
        if (idIsNull) {
            throw new AccountNotValidParameterException("Id is null.");
        }
    }

}
