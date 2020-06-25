package org.example.template.api.accountRole.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.template.model.Account;
import org.example.template.model.AccountRole;

import java.util.List;

@Mapper
public interface AccountRoleMapper {
    List<AccountRole> selectAccountRoleByAccountId(AccountRole accountRole);
    int insertAccountRole(AccountRole accountRole);
    int deleteAccountRole(AccountRole accountRole);
}
