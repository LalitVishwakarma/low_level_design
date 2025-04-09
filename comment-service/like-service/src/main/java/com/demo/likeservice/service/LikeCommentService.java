package com.demo.likeservice.service;

import com.demo.likeservice.model.LikeCommentDetails;

import java.util.List;

public interface LikeCommentService {

    Long add(Long postId, Long commentId, LikeCommentDetails likeCommentDetails, boolean like) throws Exception;

    List<LikeCommentDetails> getLikesOnPost(Long postId);
    List<LikeCommentDetails> getDislikesOnPost(Long postId);
    List<LikeCommentDetails> getLikesOnComment(Long postId, Long commentId);
    List<LikeCommentDetails> getDislikesOnComment(Long postId, Long commentId);

    Long deleteALike(Long userId, Long postId, Long commentId);

}
