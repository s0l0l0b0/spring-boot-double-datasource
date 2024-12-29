package com.tapusd.demo.mappers.one;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tapusd.demo.domain.Account;

import java.util.List;

public interface AccountMapper extends BaseMapper<Account> {
    List<Account> findAll();
}
