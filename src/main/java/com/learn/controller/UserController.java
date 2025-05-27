package com.learn.controller;

import com.learn.dto.UserDto;
import com.learn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(path = "/users")
    public Map<String, String> addUser(@RequestBody UserDto userDto) {
        return userService.addNewUser(userDto);
    }
}
