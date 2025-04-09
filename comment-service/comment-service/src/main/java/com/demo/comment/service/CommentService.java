package com.demo.comment.service;


import com.demo.comment.model.CommentDetails;

import java.util.List;

public interface CommentService {

    List<CommentDetails>  listFirstLevelCommentOnPost(Long postId);

    Long add(Long postId, CommentDetails commentDetails) throws Exception;

    Long edit(Long postId, Long commentId, CommentDetails commentDetails) throws Exception;

    Long reply(Long postId, Long commentId, CommentDetails commentDetails) throws Exception;
    void delete(int commentId);

    List<CommentDetails> listAllChildComments(Long postId, Long commentId);

    CommentDetails getById(Long postId, Long commentId) throws Exception;
}
