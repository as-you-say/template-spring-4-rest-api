package org.example.template.api.account.service.impl;

import org.example.template.api.account.mapper.AccountMapper;
import org.example.template.api.account.service.AccountService;
import org.example.template.exception.account.*;
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

        Account result = accountMapper.selectAccountById(account);
        boolean accountIsNull = (result == null);
        if (accountIsNull) {
            throw new AccountNotFoundByIdException("Account is null - id :" + account.getId());
        }

        return result;
    }

    @Override
    public Account selectAccountByUsername(Account account) {
        this.validateSelectAccountByUsername(account);

        Account result = accountMapper.selectAccountByUsername(account);
        boolean accountIsNull = (result == null);
        if (accountIsNull) {
            throw new AccountNotFoundByUsernameException("Account is null - username :" + account.getUsername());
        }

        return result;
    }

    @Override
    public int insertAccount(Account account) {
        this.validateInsertAccount(account);

        boolean accountAlreadyExist = accountMapper.selectAccountByUsername(account) != null;
        if (accountAlreadyExist) {
            throw new AccountAlreadyExistException("Account already exists - username :" + account.getUsername());
        }

        int result = accountMapper.insertAccount(account);
        boolean accountIsNotAdded = (result != 1);
        if (accountIsNotAdded) {
            throw new AccountIsNotAddedException("Account is not added");
        }

        return result;
    }

    @Override
    public int updateAccount(Account account) {
        this.validateUpdateAccount(account);

        int result = accountMapper.updateAccount(account);
        boolean accountIsNotModified = (result == 0);
        if (accountIsNotModified) {
            throw new AccountIsNotModifiedException("Account is not modified");
        }

        return accountMapper.updateAccount(account);
    }

    @Override
    public int deleteAccount(Account account) {
        this.validateDeleteAccount(account);

        int result = accountMapper.deleteAccount(account);
        boolean accountIsNotRemoved = (result == 0);
        if (accountIsNotRemoved) {
            throw new AccountIsNotRemovedException("Account is not removed");
        }

        return accountMapper.deleteAccount(account);
    }

}
