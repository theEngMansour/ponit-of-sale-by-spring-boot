package com.learn.dto.mapper;

import com.learn.dto.UserDto;
import com.learn.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "name", target = "username")
    UserEntity userDtoToUserEntity(UserDto userDto);

    @InheritInverseConfiguration
    UserDto userEntityToUserDto(UserEntity userEntity);
}
