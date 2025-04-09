package com.demo.likeservice.controller;

import com.demo.likeservice.model.LikeCommentDetails;
import com.demo.likeservice.service.LikeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeCommentRestController {

    @Autowired
    LikeCommentService likeCommentService;

    @PostMapping("posts/{postId}/likes")
    @ResponseBody
    public Long addLikeOnPost(@PathVariable("postId") Long postId, @RequestBody LikeCommentDetails likeComment) throws Exception {
        try {
            return likeCommentService.add(postId, 0L, likeComment, true);
        } catch (Exception e) {
            throw new Exception("Post Not found");
        }
    }

    @GetMapping("posts/{postId}/likes")
    @ResponseBody
    public List<LikeCommentDetails> listOfLikesOnPost(@PathVariable("postId") Long postId) throws Exception {
        try {
            return likeCommentService.getLikesOnPost(postId);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }

    @PostMapping("posts/{postId}/dislikes")
    @ResponseBody
    public Long addDislikeOnPost(@PathVariable("postId") Long postId, @RequestBody LikeCommentDetails likeComment) throws Exception {
        try {
            return likeCommentService.add(postId, 0L, likeComment, false);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }

    @GetMapping("posts/{postId}/dislikes")
    @ResponseBody
    public List<LikeCommentDetails> listOfDislikesOnPost(@PathVariable("postId") Long postId) throws Exception {
        try {
            return likeCommentService.getDislikesOnPost(postId);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }


    @PostMapping("posts/{postId}/comments/{commentId}/likes")
    @ResponseBody
    public Long addLikeOnComment(@PathVariable("postId") Long postId,
                                 @PathVariable("commentId") Long commentId,
                                 @RequestBody LikeCommentDetails likeComment) throws Exception {
        try {
            return likeCommentService.add(postId, commentId, likeComment, true);
        } catch (Exception e) {
            throw new Exception("Post Not found");
        }
    }

    @GetMapping("posts/{postId}/comments/{commentId}/likes")
    @ResponseBody
    public List<LikeCommentDetails> listOfLikesOnComment(@PathVariable("postId") Long postId,
                                                         @PathVariable("commentId") Long commentId) throws Exception {
        try {
            return likeCommentService.getLikesOnComment(postId, commentId);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }

    @PostMapping("posts/{postId}/comments/{commentId}/dislikes")
    @ResponseBody
    public Long addDislikeOnComment(@PathVariable("postId") Long postId,
                                    @PathVariable("commentId") Long commentId,
                                    @RequestBody LikeCommentDetails likeComment) throws Exception {
        try {
            return likeCommentService.add(postId, commentId, likeComment, false);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }

    @GetMapping("posts/{postId}/comments/{commentId}/dislikes")
    @ResponseBody
    public List<LikeCommentDetails> listOfDislikesOnComment(@PathVariable("postId") Long postId,
                                                            @PathVariable("commentId") Long commentId) throws Exception {
        try {
            return likeCommentService.getDislikesOnComment(postId, commentId);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }

    @DeleteMapping("users/{userId}/posts/{postId}/comments/{commentId}/likes")
    @ResponseBody
    public Long deleteALike(@PathVariable("userId") Long userId,
                                                @PathVariable("postId") Long postId,
                                                @PathVariable("commentId") Long commentId) throws Exception {
        try {
            return likeCommentService.deleteALike(userId, postId, commentId);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }
}
