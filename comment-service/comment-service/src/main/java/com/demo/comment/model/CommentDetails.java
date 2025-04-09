package com.demo.comment.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class CommentDetails {
    private Long id;
    private Long userId;
    private String userName;
    private Long parentCommentId;
    private Long postId;
    private String text;
    private long numberOfLikes;
    private long numberOfDislikes;
    private Date createTime;
}
