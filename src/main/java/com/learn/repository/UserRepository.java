package com.learn.repository;

import com.learn.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> getAllByOrderByUserIdDesc();
}
