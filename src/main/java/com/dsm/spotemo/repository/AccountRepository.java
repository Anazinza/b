package com.dsm.spotemo.repository;

import com.dsm.spotemo.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
}
