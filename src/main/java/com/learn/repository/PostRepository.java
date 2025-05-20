package com.learn.repository;

import com.learn.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

    List<PostEntity> findAllByTitle(String title);

    List<PostEntity> findAllByTitleAndDescription(String title, String description);

    List<PostEntity> findAllByTitleOrDescription(String title, String description);

    List<PostEntity> findAllByTitleStartingWith(String title);

    List<PostEntity> findAllByTitleEndsWith(String title);

    List<PostEntity> findAllByTitleContaining(String title);

    List<PostEntity> getAllByOrderByIdDesc();

    List<PostEntity> readAllByOrderByIdDesc();
}
