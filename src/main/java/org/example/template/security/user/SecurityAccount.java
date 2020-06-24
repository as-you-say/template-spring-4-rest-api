package org.example.template.security.user;

import org.example.template.model.Account;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityAccount extends User {
    public SecurityAccount(
        Account account,
        boolean enabled,
        boolean accountNonExpired,
        boolean credentialsNonExpired,
        boolean accountNonLocked
    ) {
        super(
            account.getUsername(),
            account.getPassword(),
            enabled,
            accountNonExpired,
            credentialsNonExpired,
            accountNonLocked,
            AuthorityUtils.createAuthorityList(account.getRoleNameList())
        );
    }
}
