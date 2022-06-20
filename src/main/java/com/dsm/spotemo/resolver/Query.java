package com.dsm.spotemo.resolver;

import com.dsm.spotemo.dto.response.PostResponse;
import com.dsm.spotemo.entity.Post;
import com.dsm.spotemo.repository.PostRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
    private final PostRepository postRepository;

    public PostResponse getPost(int id) {
        Post post = postRepository.findById(id).orElseThrow();

        return PostResponse
                .builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .emotion(post.getEmotion())
                .date(post.getCreatedAt()).build();
    }
}
