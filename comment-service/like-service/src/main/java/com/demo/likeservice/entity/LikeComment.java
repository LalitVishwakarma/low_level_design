package com.demo.likeservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@Setter
@Getter
public class LikeComment {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(nullable = false)
    private boolean isLike;

    @Column(nullable = false)
    private Long serviceUserId;

    @Column(nullable = false)
    Long postId;

    @Column(nullable = false)
    Long commentId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date createTime;
}
