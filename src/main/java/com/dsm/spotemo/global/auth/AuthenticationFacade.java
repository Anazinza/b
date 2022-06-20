package com.dsm.spotemo.global.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {
    public Object getPrincipal() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public AccountDetails getAccountDetails() {
        return (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
