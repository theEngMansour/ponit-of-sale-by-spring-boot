package com.learn.service.impelement;

import com.learn.dto.UserDto;
import com.learn.dto.mapper.UserMapper;
import com.learn.entity.UserEntity;
import com.learn.repository.UserRepository;
import com.learn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Map<String, String> addNewUser(UserDto userDto) {
        UserEntity userEntity = userMapper.userDtoToUserEntity(userDto);
        userRepository.save(userEntity);
        return userMapper.userEntityToUserDto(userEntity).message();
    }
}
