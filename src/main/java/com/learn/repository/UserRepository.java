package com.learn.repository;

import com.learn.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> getAllByOrderByUserIdDesc();

    Optional<UserEntity> findAllByUserId(Integer username);

    UserEntity findByUsername(String username);
}
