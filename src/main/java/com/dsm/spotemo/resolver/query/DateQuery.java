package com.dsm.spotemo.resolver.query;

import com.dsm.spotemo.dto.response.PostResponse;
import com.dsm.spotemo.entity.value.WriteDate;
import com.dsm.spotemo.global.auth.AuthenticationFacade;
import com.dsm.spotemo.repository.PostRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DateQuery implements GraphQLQueryResolver {
    private final AuthenticationFacade authentication;
    private final PostRepository postRepository;

    @PreAuthorize("authenticated()")
    public WriteDate getWriteDay() {
        // token 없을시 접근 못하게...
        return authentication.getAccountDetails().getAccount().getWriteDate();
    }

    public List<PostResponse> getDayAndPostInfo(int year, int month) {
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
