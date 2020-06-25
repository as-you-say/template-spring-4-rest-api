package org.example.template.api.account.service;

import org.example.template.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> selectAccountList(Account account);
    Account selectAccountById(Account account);
    Account selectAccountByUsername(Account account);
    void insertAccount(Account account);
    int updateAccount(Account account);
    int deleteAccount(Account account);
}
