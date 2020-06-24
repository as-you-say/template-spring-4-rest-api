package org.example.template.api.account.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.template.model.Account;

@Mapper
public interface AccountMapper {
    Account findAccountById(Account account);
}
