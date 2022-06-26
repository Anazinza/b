package com.dsm.spotemo.repository;

import com.dsm.spotemo.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends MongoRepository<Post, Integer> {
}
