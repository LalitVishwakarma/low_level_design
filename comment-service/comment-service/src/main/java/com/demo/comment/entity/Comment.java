package com.demo.comment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@Setter
@Getter
public class Comment {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private Long serviceUserId;

    @Column(nullable = false)
    private boolean isDeleted;

    @Column(nullable = false)
    Long postId;

    @Column(nullable = false)
    Long parentCommentId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
}
