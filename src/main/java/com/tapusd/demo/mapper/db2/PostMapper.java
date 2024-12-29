package com.tapusd.demo.mapper.db2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tapusd.demo.domain_model.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper extends BaseMapper<Post> {

}
