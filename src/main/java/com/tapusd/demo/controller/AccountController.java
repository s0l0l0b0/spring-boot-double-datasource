package com.tapusd.demo.controller;

import com.tapusd.demo.domain.Account;
import com.tapusd.demo.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountRepository repository;

    public AccountController(AccountRepository accountRepository) {
        this.repository = accountRepository;
    }

    @GetMapping
    public List<Account> findAll() {
        return repository.findAll();
    }
}
