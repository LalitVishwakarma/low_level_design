package com.demo.comment.controller;

import com.demo.comment.model.CommentDetails;
import com.demo.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentRestController {

    @Autowired
    CommentService commentService;


    @GetMapping("posts/{postId}/comments")
    @ResponseBody
    public List<CommentDetails> listFirstLevelCommentOnPost(@PathVariable("postId") Long postId) throws Exception {
        try {
            return commentService.listFirstLevelCommentOnPost(postId);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }

    @PostMapping("posts/{postId}/comments")
    @ResponseBody
    public Long addCommentOnPost(@PathVariable("postId") Long postId, @RequestBody CommentDetails commentDetails) throws Exception {
        try {
            return commentService.add(postId, commentDetails);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    @ResponseBody
    public Long updateComment(@PathVariable("postId") Long postId,
                              @PathVariable("commentId") Long commentId,
                              @RequestBody CommentDetails commentDetails) throws Exception {
        try {
            return commentService.edit(postId, commentId, commentDetails);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }

    @GetMapping("/posts/{postId}/comments/{commentId}/")
    @ResponseBody
    public CommentDetails updateComment(@PathVariable("postId") Long postId,
                                        @PathVariable("commentId") Long commentId) throws Exception {
        try {
            return commentService.getById(postId, commentId);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }

    @GetMapping("/posts/{postId}/comments/{commentId}/childComments")
    @ResponseBody
    public List<CommentDetails> listChildComments(@PathVariable("postId") Long postId,
                                                  @PathVariable("commentId") Long commentId) throws Exception {
        try {
            return commentService.listAllChildComments(postId, commentId);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }

    @PostMapping("/posts/{postId}/comments/{commentId}/reply")
    @ResponseBody
    public Long replyToComment(@PathVariable("postId") Long postId,
                               @PathVariable("commentId") Long commentId,
                               @RequestBody CommentDetails commentDetails) throws Exception {
        try {
            return commentService.reply(postId, commentId, commentDetails);
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }
}
