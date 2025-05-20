package com.learn.dao;

import com.learn.entity.PostEntity;
import com.learn.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostDao {

    @Autowired
    private PostRepository postRepository;

    public List<PostEntity> getAllPost() {
        return this.postRepository.findAll();
    }

}
