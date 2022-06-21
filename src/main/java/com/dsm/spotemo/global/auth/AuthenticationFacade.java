package com.dsm.spotemo.global.auth;

import com.dsm.spotemo.entity.Account;
import com.dsm.spotemo.global.exception.exceptions.AnonymousAccountNotFound;
import com.dsm.spotemo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticationFacade {
    private final AccountRepository accountRepository;

    public Object getPrincipal() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public AccountDetails getAccountDetails() {
        return (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public Account getAnonymousAccount() {
        return accountRepository.findById("anonymous").orElseThrow(AnonymousAccountNotFound::new);
    }
}
