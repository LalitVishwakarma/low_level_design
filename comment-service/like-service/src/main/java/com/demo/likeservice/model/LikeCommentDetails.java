package com.demo.likeservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LikeCommentDetails {
    private Long userId;
    private String userName;
    private Long commentId;
    private Long postId;
}
