package org.example.template.api.account.controller;

import org.example.template.api.account.service.AccountService;
import org.example.template.model.Account;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AccountController {

    @Resource(name = "accountServiceImpl")
    AccountService accountService;

    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> getAccounts(Account account){
        return accountService.selectAccountList(account);
    }

    @GetMapping(value = "/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Account getAccount(Account account){
        return accountService.selectAccountById(account);
    }

    @PostMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
    public void postAccount(@RequestBody Account account){
        accountService.insertAccount(account);
    }

    @PutMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
    public void putAccount(@RequestBody Account account){
        accountService.updateAccount(account);
    }

    @DeleteMapping(value = "/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAccount(@RequestBody Account account){
        accountService.deleteAccount(account);
    }

}
