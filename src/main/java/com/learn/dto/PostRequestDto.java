package com.learn.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostRequestDto {
    private Integer userId;
    @NotNull(message = "Title cannot be empty")
    @NotBlank(message = "Title cannot be empty")
    @Size(min = 2, max = 30)

    private String title;
    private String description;
}
