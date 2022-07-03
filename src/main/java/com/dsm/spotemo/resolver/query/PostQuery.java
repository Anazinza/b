package com.dsm.spotemo.resolver.query;

import com.dsm.spotemo.dto.response.PostResponse;
import com.dsm.spotemo.entity.Post;
import com.dsm.spotemo.global.exception.BasicException;
import com.dsm.spotemo.global.exception.ExceptionMessage;
import com.dsm.spotemo.global.exception.exceptions.PostNotFoundException;
import com.dsm.spotemo.repository.PostRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostQuery implements GraphQLQueryResolver {
    private final PostRepository postRepository;

    @PreAuthorize("isAuthenticated()")
    public PostResponse post(String id) {
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);

        if(!post.isLive()) {
            throw new BasicException(ExceptionMessage.PostNotFoundException, "삭제된 게시글입니다.");
        }

        return PostResponse
                .builder()
                .id(post.getId().toString())
                .title(post.getTitle())
                .content(post.getContent())
                .emotion(post.getEmotion())
                .date(post.getDay()).build();
    }
}
