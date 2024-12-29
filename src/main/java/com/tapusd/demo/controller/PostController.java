package com.tapusd.demo.controller;

import com.tapusd.demo.domain_model.Post;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController
//@RequestMapping("/posts")
public class PostController {

    private final JdbcTemplate jdbcTemplate;

    public PostController(@Qualifier("secondaryJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Post> findAll() {
        return jdbcTemplate.query("SELECT * FROM post", rs -> {
            List<Post> posts = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong(1);
                long accountId = rs.getLong(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                Post post = new Post();
                post.setId(id);
                post.setAccountId(accountId);
                post.setTitle(title);
                post.setContent(content);
                posts.add(post);
            }
            return posts;
        });
    }
}
