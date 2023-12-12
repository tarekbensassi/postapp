package com.postapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postapp.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> findByPublished(boolean published);

  List<Post> findByTitleContaining(String title);
}
