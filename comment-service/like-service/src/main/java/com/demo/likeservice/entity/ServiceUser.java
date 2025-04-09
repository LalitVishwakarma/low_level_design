package com.demo.likeservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table
@Setter
@Getter
public class ServiceUser {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;
}
