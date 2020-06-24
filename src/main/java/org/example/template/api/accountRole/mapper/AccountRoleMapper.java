package org.example.template.api.accountRole.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.template.model.Account;

@Mapper
public interface AccountRoleMapper {
    Account findAccountById(Account account);
}
