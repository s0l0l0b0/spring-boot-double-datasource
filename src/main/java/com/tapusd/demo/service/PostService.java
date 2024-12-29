package com.tapusd.demo.service;

import com.tapusd.demo.domain_model.Post;
import com.tapusd.demo.mapper.db2.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public Post getPostById(Long id) {
        return postMapper.selectById(id);
    }
}
