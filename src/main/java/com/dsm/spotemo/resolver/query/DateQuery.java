package com.dsm.spotemo.resolver.query;

import com.dsm.spotemo.entity.Post;
import com.dsm.spotemo.entity.value.WriteDate;
import com.dsm.spotemo.global.auth.AuthenticationFacade;
import com.dsm.spotemo.repository.PostRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<Post> getDayAndPostInfo(int year, int month) {

        return postRepository.findAllByYearAndMonthAndAccount(year, month, authentication.getAccountDetails().getAccount());
    }
}
