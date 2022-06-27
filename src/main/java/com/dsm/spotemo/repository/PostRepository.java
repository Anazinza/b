package com.dsm.spotemo.repository;

import com.dsm.spotemo.entity.Account;
import com.dsm.spotemo.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findAllByYearAndMonthAndAccountAndLiveIsTrue(int year, int month, Account account);
}
