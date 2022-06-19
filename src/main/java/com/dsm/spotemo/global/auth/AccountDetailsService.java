package com.dsm.spotemo.global.auth;

import com.dsm.spotemo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Override
    public AccountDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return accountRepository.findById(email)
                .map(AccountDetails::new)
                .orElseThrow();
    }
}
