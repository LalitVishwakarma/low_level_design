package com.demo.postservice.controller;

import com.demo.postservice.entity.Post;
import com.demo.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/posts")
    @ResponseBody
    public Long add(@RequestBody Post post) throws Exception {
        try {
            post.setCreateTime(new Date(System.currentTimeMillis()));
            return postService.add(post);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }

    @GetMapping("/posts")
    @ResponseBody
    public List<Post> list() throws Exception {
        try {
            return postService.list();
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }

    @DeleteMapping("/posts/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Long postId) throws Exception {
        try {
            postService.delete(postId);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }
}
