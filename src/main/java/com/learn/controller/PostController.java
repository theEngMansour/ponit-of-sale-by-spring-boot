package com.learn.controller;

import com.learn.annotation.CurrentUser;
import com.learn.dto.PostRequestDto;
import com.learn.dto.mapper.PostMapper;
import com.learn.entity.PostEntity;
import com.learn.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private EntityManager entityManager;

    @Value(value = "${app.user.url}")
    private String baseUrl;

    @PostMapping(path = "/create-post")
    public PostRequestDto testValidation(@RequestBody @Valid PostRequestDto dto) {
        return dto;
    }

    @GetMapping("/me")
    public String getCurrentUser(@CurrentUser Integer id) {

        System.out.println("Current User: " + id);
        return "مرحبا ";
    }

    @GetMapping(path = "config-test")
    public String getCurrentUser() {
        return this.baseUrl;
    }

    @GetMapping(path = "/posts")
    public List<PostEntity> getPosts(@RequestParam(required = false) String title) {
        Session session = entityManager.unwrap(Session.class);
        session.enableFilter("softDeleteFilter");
        return this.postRepository.findAll();
    }

    @GetMapping(path = "/posts-and-description")
    public List<PostEntity> findAllByTitleAndDescription(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description
    ) {
        return this.postRepository.findAllByTitleAndDescription(title, description);
    }

    @GetMapping(path = "/posts-or-description")
    public List<PostEntity> findAllByTitleOrDescription(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description
    ) {
        return this.postRepository.findAllByTitleOrDescription(title, description);
    }

    @GetMapping(path = "/posts-starting-with")
    public List<PostEntity> findAllByTitleStartingWith(
            @RequestParam(required = false) String title
    ) {
        return this.postRepository.findAllByTitleStartingWith(title);
    }

    @GetMapping(path = "/posts-ends-with")
    public List<PostEntity> findAllByTitleEndsWith(
            @RequestParam(required = false) String title
    ) {
        return this.postRepository.findAllByTitleEndsWith(title);
    }

    @GetMapping(path = "/posts-containing")
    public List<PostEntity> findAllByTitleContaining(
            @RequestParam(required = false) String title
    ) {
        return this.postRepository.findAllByTitleContaining(title);
    }

    @GetMapping(path = "/posts-order-by-desc")
    public List<PostEntity> findAllByTitleContaining() {
        return this.postRepository.getAllByOrderByIdDesc();
    }

    @GetMapping(path = "/posts-sort")
    public List<PostEntity> findAll() {
        return this.postRepository.findAll(
                Sort.by(Sort.Direction.DESC, "id", "title")
        );
    }

    @DeleteMapping(path = "/delete-post/{id}")
    public void deletePost(@PathVariable Integer id) {
        Optional<PostEntity> post = this.postRepository.findById(id);
        if (post.isPresent()) {
            PostEntity postEntity = post.get();
            postEntity.setDeletedAt(LocalDateTime.now());
            this.postRepository.save(postEntity);
        } else {
            throw new RuntimeException("Post not found with id: " + id);
        }


    }
}
