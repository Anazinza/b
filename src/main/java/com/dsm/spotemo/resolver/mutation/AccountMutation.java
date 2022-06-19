package com.dsm.spotemo.resolver.mutation;

import com.dsm.spotemo.dto.request.AccountRequestDto;
import com.dsm.spotemo.dto.response.TokenAndAccountDto;
import com.dsm.spotemo.entity.Account;
import com.dsm.spotemo.entity.value.Nickname;
import com.dsm.spotemo.global.TokenUtil;
import com.dsm.spotemo.repository.AccountRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
@RequiredArgsConstructor
@Log4j2
public class AccountMutation implements GraphQLMutationResolver {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenUtil tokenUtil;

    public TokenAndAccountDto createAccount(final AccountRequestDto dto) {
        final int idx = new Random().nextInt(Nickname.values().length);
        final String nickname = Nickname.values()[idx].getNickname();

        log.info("create-account"+"       "+nickname);

        if( accountRepository.existsById(dto.getEmail()) ) {

        }

        accountRepository.save(
                Account.builder()
                        .email(dto.getEmail())
                        .password(passwordEncoder.encode(dto.getPassword()))
                        .nickname(nickname).build()
        );

        return TokenAndAccountDto.builder()
                .email(dto.getEmail())
                .nickname(nickname)
                .token(tokenUtil.createToken(dto.getEmail(), nickname)).build();
    }
}
