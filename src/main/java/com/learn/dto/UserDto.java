package com.learn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String password;

    public Map<String, String> message() {
        return Map.of("message", "user added successfully!", "password", this.password);
    }
}
