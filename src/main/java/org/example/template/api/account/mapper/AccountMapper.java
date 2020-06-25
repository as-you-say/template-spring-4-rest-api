package org.example.template.api.account.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.template.model.Account;

import java.util.List;

@Mapper
public interface AccountMapper {
    List<Account> selectAccountList(Account account);
    Account selectAccountById(Account account);
    Account selectAccountByUsername(Account account);
    void insertAccount(Account account);
    int updateAccount(Account account);
    int deleteAccount(Account account);
}
