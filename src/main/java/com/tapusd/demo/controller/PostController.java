package com.tapusd.demo.controller;

import com.tapusd.demo.domain.Post;
import com.tapusd.demo.mappers.two.PostMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostMapper postMapper;

    public PostController(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @GetMapping
    public List<Post> getPosts() {
        return postMapper.findAll();
    }
}
