package com.learn.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "course_user")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CourseUserEntity {
    @Transient
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column
    private Integer id;

    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private CourseEntity courseEntity;

    public Integer getId() {
        return this.courseEntity.getId();
    }

    public String getName() {
        return this.courseEntity.getName();
    }
}
