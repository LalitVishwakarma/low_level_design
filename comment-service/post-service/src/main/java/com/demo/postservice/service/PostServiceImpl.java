package com.demo.postservice.service;

import com.demo.postservice.entity.Post;
import com.demo.postservice.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void delete(Long postId) {
        try {
            Optional<Post> post = postRepository.findById(postId);
            if (post.isPresent()) {
                postRepository.deleteById(post.get().getId());
            } else {
                throw new Exception("Not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Long add(Post post) throws Exception {
        try {
            return postRepository.save(post).getId();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Post> list() {
        return postRepository.findAll();
    }

}
