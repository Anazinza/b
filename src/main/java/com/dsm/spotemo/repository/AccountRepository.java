package com.dsm.spotemo.repository;

import com.dsm.spotemo.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
