// AuthController.java
package com.learn.controller;

import com.learn.entity.UserEntity;
import com.learn.repository.UserRepository;
import com.learn.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepo;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam Integer id) {
        Optional<UserEntity> user = userRepo.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found with id: " + id);
        }
        String token = jwtUtil.generateToken(user.get().getUserId());
        return ResponseEntity.ok().body(
                Map.of("token", token)
        );
    }

    @GetMapping("/users")
    public ResponseEntity<?> users() {
        List<String> users = new ArrayList<>();
        users.add("User 1");
        return ResponseEntity.ok().body(
                Map.of("users", users)
        );
    }


}
