package com.learn.dto.mapper.implement;

import com.learn.dto.PostRequestDto;
import com.learn.dto.PostResponseDto;
import com.learn.dto.mapper.PostMapper;
import com.learn.entity.PostEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PostMapperImplement implements PostMapper {
    @Override
    public PostEntity toPostEntity(PostRequestDto postRequestDto) {
//        PostEntity postEntity = new PostEntity();
//        postEntity.setUserId();
//        postEntity.setTitle(postDto.getTitle());
//        postEntity.setDescription(postDto.getDescription());
//        return postEntity;
        return PostEntity.
                builder()
                .userId(postRequestDto.getUserId())
                .title(postRequestDto.getTitle())
                .description(postRequestDto.getDescription())
                .build();
    }

    @Override
    public Map<String, String> toPostResponseDto(PostEntity postEntity) {
        PostResponseDto responseDto = PostResponseDto.builder()
                .title(postEntity.getTitle())
                .build();

        return responseDto.message();
    }
}
