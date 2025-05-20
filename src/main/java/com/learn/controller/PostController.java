package com.learn.controller;

import com.learn.entity.PostEntity;
import com.learn.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "/posts")
    public List<PostEntity> getPosts(@RequestParam(required = false) String title) {
        return this.postRepository.findAllByTitle(title);
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
}
