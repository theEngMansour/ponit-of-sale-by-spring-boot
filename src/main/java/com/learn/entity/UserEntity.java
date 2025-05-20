package com.learn.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name = "user_id")
    private Integer userId;
    @Column
    private String username;
    @Column
    private String password;

    @OneToOne(mappedBy = "userEntity")
    @JsonManagedReference
    private AddressEntity address;

    @JsonManagedReference
    @OneToMany(mappedBy = "userEntity")
    private List<PostEntity> posts;

    @OneToMany(mappedBy = "userEntity")
    @JsonManagedReference
    private List<CourseUserEntity> courses;
}
