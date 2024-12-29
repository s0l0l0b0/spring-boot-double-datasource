package com.tapusd.demo.service;

import com.tapusd.demo.domain_model.Account;
import com.tapusd.demo.mapper.db1.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;


    public List<Account> findAllAccount() {
        return accountMapper.selectList();
    }
}
