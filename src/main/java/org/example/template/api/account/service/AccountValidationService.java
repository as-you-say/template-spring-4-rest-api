package org.example.template.api.account.service;

import org.example.template.model.Account;

public interface AccountValidationService {
    void validateSelectAccountList(Account account);
    void validateSelectAccountById(Account account);
    void validateSelectAccountByUsername(Account account);
    void validateInsertAccount(Account account);
    void validateUpdateAccount(Account account);
    void validateDeleteAccount(Account account);
}
