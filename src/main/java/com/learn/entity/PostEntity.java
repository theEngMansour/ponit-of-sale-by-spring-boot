package com.learn.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "posts")
@AllArgsConstructor
@NoArgsConstructor

public class PostEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity userEntity;

    public String getTitle() {
        return title + "@" + userEntity.getUsername();
    }

}
