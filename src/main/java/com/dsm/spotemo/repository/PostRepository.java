package com.dsm.spotemo.repository;

import com.dsm.spotemo.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
