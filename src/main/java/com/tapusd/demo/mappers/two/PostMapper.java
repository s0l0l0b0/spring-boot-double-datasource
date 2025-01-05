package com.tapusd.demo.mappers.two;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tapusd.demo.domain.Post;

import java.util.List;

public interface PostMapper extends BaseMapper<Post> {
    List<Post> findAll();
}
