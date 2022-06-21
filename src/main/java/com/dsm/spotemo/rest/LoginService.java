package com.dsm.spotemo.rest;

import com.dsm.spotemo.dto.response.TokenAndAccountResponse;
import com.dsm.spotemo.entity.Account;
import com.dsm.spotemo.global.auth.TokenUtil;
import com.dsm.spotemo.global.exception.BasicException;
import com.dsm.spotemo.global.exception.ExceptionMessage;
import com.dsm.spotemo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AccountRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenUtil tokenUtil;

    public TokenAndAccountResponse login(final String email, final String password) {
        Account account = repository.findById(email).orElseThrow();
        if(!passwordEncoder.matches(password, account.getPassword())) {
            throw new BasicException(ExceptionMessage.PasswordMisMatch, "존재하는 이메일이지만 비밀번호가 올바르지 않습니다.");
        }

        return TokenAndAccountResponse.builder()
                        .email(email)
                        .nickname(account.getNickname())
                        .token(tokenUtil.createToken(email, account.getNickname())).build();
    }
}
