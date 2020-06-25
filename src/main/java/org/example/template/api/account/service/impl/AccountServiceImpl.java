package org.example.template.api.account.service.impl;

import org.example.template.api.account.mapper.AccountMapper;
import org.example.template.api.account.service.AccountService;
import org.example.template.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl extends AccountValidationServiceImpl implements AccountService {

    @Resource
    AccountMapper accountMapper;

    @Override
    public List<Account> selectAccountList(Account account) {
        return accountMapper.selectAccountList(account);
    }

    @Override
    public Account selectAccountById(Account account) {
        return null;
    }

    @Override
    public Account selectAccountByUsername(Account account) {
        return null;
    }

    @Override
    public void insertAccount(Account account) {

    }

    @Override
    public int updateAccount(Account account) {
        return 0;
    }

    @Override
    public int deleteAccount(Account account) {
        return 0;
    }
}
