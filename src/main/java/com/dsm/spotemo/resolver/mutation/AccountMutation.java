package com.dsm.spotemo.resolver.mutation;

import com.dsm.spotemo.dto.request.AccountRequest;
import com.dsm.spotemo.dto.response.TokenAndAccountResponse;
import com.dsm.spotemo.entity.Account;
import com.dsm.spotemo.entity.value.Emotions;
import com.dsm.spotemo.entity.value.WriteDate;
import com.dsm.spotemo.entity.value.Nickname;
import com.dsm.spotemo.global.auth.TokenUtil;
import com.dsm.spotemo.global.exception.BasicException;
import com.dsm.spotemo.global.exception.ExceptionMessage;
import com.dsm.spotemo.repository.AccountRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;


@Service
@RequiredArgsConstructor
@Log4j2
public class AccountMutation implements GraphQLMutationResolver {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenUtil tokenUtil;

    @Transactional
    public TokenAndAccountResponse createAccount(final AccountRequest req) {
        final int idx = new Random().nextInt(Nickname.values().length);
        final String nickname = Nickname.values()[idx].getNickname();

        log.info("create-account"+"       "+nickname);

        if( accountRepository.existsById(req.getEmail()) ) {
            throw new BasicException(ExceptionMessage.EmailAlreadyExist, "이미 존재하는 이메일입니다.");
        }

        accountRepository.save(
                Account.builder()
                        .email(req.getEmail())
                        .password(passwordEncoder.encode(req.getPassword()))
                        .nickname(nickname)
                        .writeDate(new WriteDate())
                        .emotions(new Emotions())
                        .build()
        );

        return TokenAndAccountResponse.builder()
                .email(req.getEmail())
                .nickname(nickname)
                .token(tokenUtil.createToken(req.getEmail(), nickname)).build();
    }
}
