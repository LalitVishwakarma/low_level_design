package com.demo.postservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(nullable = false)
    private Long serviceUserId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
}
