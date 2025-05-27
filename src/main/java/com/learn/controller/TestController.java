package com.learn.controller;


import com.learn.dto.TestValidDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestController {
    @PostMapping(path = "test")
    public TestValidDto test(@RequestBody @Valid TestValidDto testValidDto) {
        return testValidDto;
    }
}
