package com.learn.service;

import com.learn.dto.UserDto;

import java.util.Map;

public interface UserService {
    Map<String, String> addNewUser(UserDto userDto);
}
