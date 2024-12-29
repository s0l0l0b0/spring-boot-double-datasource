package com.tapusd.demo.mapper.db1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tapusd.demo.domain_model.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    List<Account> selectList();
}
