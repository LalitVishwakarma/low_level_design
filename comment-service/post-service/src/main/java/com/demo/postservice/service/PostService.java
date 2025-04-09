package com.demo.postservice.service;

import com.demo.postservice.entity.Post;

import java.util.List;

public interface PostService {
    Long add(Post post) throws Exception;

    void delete(Long postId);

    List<Post> list();
}
