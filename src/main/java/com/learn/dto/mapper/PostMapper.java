package com.learn.dto.mapper;

import com.learn.dto.PostRequestDto;
import com.learn.entity.PostEntity;

import java.util.Map;

public interface PostMapper {
    PostEntity toPostEntity(PostRequestDto postRequestDto);

    Map<String, String> toPostResponseDto(PostEntity postEntity);
}
