package com.dsm.spotemo.resolver.mutation;

import com.dsm.spotemo.dto.request.PostCreateRequest;
import com.dsm.spotemo.entity.Account;
import com.dsm.spotemo.entity.Post;
import com.dsm.spotemo.entity.value.DayPostInfo;
import com.dsm.spotemo.entity.value.Emotion;
import com.dsm.spotemo.global.auth.AuthenticationFacade;
import com.dsm.spotemo.global.exception.BasicException;
import com.dsm.spotemo.global.exception.ExceptionMessage;
import com.dsm.spotemo.repository.AccountRepository;
import com.dsm.spotemo.repository.PostRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@RequiredArgsConstructor
@Component
public class PostMutation implements GraphQLMutationResolver {
    private final PostRepository postRepository;
    private final AccountRepository accountRepository;
    private final AuthenticationFacade authentication;

    public boolean createPost(final PostCreateRequest req, final boolean isLive) {

        if(isLive && authentication.getPrincipal() instanceof String) {
            throw new BasicException(ExceptionMessage.UnableWriteWithoutLogin, "로그인을 하지 않은 상태에서 글을 보존할 수 없습니다. 로그인이 필요합니다.");
        }

        Account account = authentication.getPrincipal() instanceof String ?
                authentication.getAnonymousAccount() :
                authentication.getAccountDetails().getAccount();

        Post p = Post.builder()
                        .title(req.getTitle())
                        .content(req.getContent())
                        .emotion(new Emotion(req.getEmotion()))
                        .year(LocalDate.now().getYear())
                        .month(LocalDate.now().getMonthValue())
                        .day(LocalDate.now())
                        .live(isLive)
                        .account(account).build();

        Post post = postRepository.save(p);

        account.getWriteDate().addDay(
                post.getYear(),
                post.getMonth(),
                post.getDay());

        account.getWriteDate().saveDayPostInfo(
                DayPostInfo.builder()
                .day(post.getDay())
                .postId(post.getId())
                .postTitle(p.getTitle())
                .postEmotion(p.getEmotion()).build()
        );

        account.getEmotions().addEmotion(p.getEmotion().getEmotion());

        accountRepository.save(account);

        return post.isLive(); // false means it's post is deleted
    }

    public void postDelete() {

    }
}
