package com.tapusd.demo.controller;

import com.tapusd.demo.domain_model.Account;
import com.tapusd.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
//    private final AccountRepository repository;

//    public AccountController(AccountRepository accountRepository) {
//        this.repository = accountRepository;
//    }

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        List<Account> accounts = accountService.findAllAccount();
        return ResponseEntity.ok(accounts);
    }
}
