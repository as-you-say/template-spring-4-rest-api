package org.example.template.security.user;

import org.example.template.api.account.mapper.AccountMapper;
import org.example.template.model.Account;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;

public class SecurityAccountService implements UserDetailsService {

    @Resource(name = "accountMapper")
    AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = new Account();
        account.setUsername(username);

        Account resultAccount = accountMapper.selectAccountById(account);
        return new SecurityAccount(
            resultAccount,
            true,
            true,
            true,
            true
        );
    }
}
