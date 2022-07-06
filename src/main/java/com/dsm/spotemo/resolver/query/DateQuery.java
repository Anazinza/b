package com.dsm.spotemo.resolver.query;

import com.dsm.spotemo.dto.response.AccountResponse;
import com.dsm.spotemo.dto.response.PostResponse;
import com.dsm.spotemo.dto.response.WriteDateResponse;
import com.dsm.spotemo.entity.Account;
import com.dsm.spotemo.entity.value.WriteDate;
import com.dsm.spotemo.global.auth.AuthenticationFacade;
import com.dsm.spotemo.repository.PostRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Log4j2
public class DateQuery implements GraphQLQueryResolver {
    private final AuthenticationFacade authentication;
    private final PostRepository postRepository;

    @PreAuthorize("isAuthenticated()")
    public WriteDateResponse writeDay() {
        WriteDate writeDate = authentication.getAccountDetails().getAccount().getWriteDate();
        return WriteDateResponse.builder()
                .years(new HashSet<>(writeDate.getYears()))
                .months(new HashSet<>(writeDate.getMonths()))
                .dates(new HashSet<>(writeDate.getDates()))
                .postInfos(writeDate.getDayPostInfos()).build();
    }

    @PreAuthorize("isAuthenticated()")
    public AccountResponse account() {
        Account account = authentication.getAccountDetails().getAccount();

        return AccountResponse.builder()
                .email(account.getEmail())
                .nickname(account.getNickname())
                .emotions(account.getEmotions().getEmotions()).build();
    }

    @PreAuthorize("isAuthenticated()")
    public List<PostResponse> posts(int year, int month) {
        return postRepository.findAllByYearAndMonthAndAccountAndLiveIsTrue(year, month, authentication.getAccountDetails().getAccount())
                .stream()
                .map( post -> PostResponse.builder()
                                        .id(post.getId().toString())
                                        .title(post.getTitle())
                                        .content(post.getContent())
                                        .emotion(post.getEmotion())
                                        .date(post.getDay())
                                        .build()).collect(Collectors.toList());
    }
}
