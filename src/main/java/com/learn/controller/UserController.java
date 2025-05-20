package com.learn.controller;

import com.learn.entity.UserEntity;
import com.learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users")
    public List<UserEntity> getUsers() {
        return this.userRepository.getAllByOrderByUserIdDesc();
    }
}
