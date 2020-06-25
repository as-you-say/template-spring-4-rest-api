package org.example.template.api.account.service.impl;

import org.example.template.api.account.mapper.AccountMapper;
import org.example.template.api.account.service.AccountService;
import org.example.template.model.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl extends AccountValidationServiceImpl implements AccountService {

    @Resource
    AccountMapper accountMapper;

    @Override
    public List<Account> selectAccountList(Account account) {
        this.validateSelectAccountList(account);
        return accountMapper.selectAccountList(account);
    }

    @Override
    public Account selectAccountById(Account account) {
        this.validateSelectAccountById(account);
        return accountMapper.selectAccountById(account);
    }

    @Override
    public Account selectAccountByUsername(Account account) {
        this.validateSelectAccountByUsername(account);
        return accountMapper.selectAccountByUsername(account);
    }

    @Override
    public int insertAccount(Account account) {
        this.validateInsertAccount(account);
        return accountMapper.insertAccount(account);
    }

    @Override
    public int updateAccount(Account account) {
        this.validateUpdateAccount(account);
        return accountMapper.updateAccount(account);
    }

    @Override
    public int deleteAccount(Account account) {
        this.validateDeleteAccount(account);
        return accountMapper.deleteAccount(account);
    }
}
