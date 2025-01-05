package com.tapusd.demo.controller;

import com.tapusd.demo.domain.Account;
import com.tapusd.demo.mappers.one.AccountMapper;
import com.tapusd.demo.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountRepository repository;
    private final AccountMapper accountMapper;

    public AccountController(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.repository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @GetMapping
    public List<Account> findAll() {
//        return repository.findAll();
        return accountMapper.findAll();
    }
}
