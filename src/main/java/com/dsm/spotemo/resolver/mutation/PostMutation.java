package com.dsm.spotemo.resolver.mutation;

import com.dsm.spotemo.dto.request.PostCreateRequest;
import com.dsm.spotemo.entity.Account;
import com.dsm.spotemo.global.auth.AuthenticationFacade;
import com.dsm.spotemo.global.exception.BasicException;
import com.dsm.spotemo.global.exception.ExceptionMessage;
import com.dsm.spotemo.repository.PostRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class PostMutation implements GraphQLMutationResolver {
    private final PostRepository repository;
    private final AuthenticationFacade authentication;

    public boolean createPost(final PostCreateRequest req, final int isLive) {

        if(isLive==1 && authentication.getPrincipal() instanceof String) {
            throw new BasicException(ExceptionMessage.UnableWriteWithoutLogin, "로그인을 하지 않은 상태에서 글을 보존할 수 없습니다. 로그인이 필요합니다.");
        }



        Account account = authentication.getPrincipal() instanceof String ?
                Account.builder().build() :
                authentication.getAccountDetails().getAccount();

        System.out.println(account.getNickname());


        return true;

    }

    public void postDelete() {

    }
}
