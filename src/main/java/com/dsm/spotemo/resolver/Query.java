package com.dsm.spotemo.resolver;

import com.dsm.spotemo.entity.Post;
import com.dsm.spotemo.repository.PostRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
    private final PostRepository postRepository;

    @GraphQLQuery
    public Post getPostTest(int id) {

        return postRepository.findById(id).orElseThrow();
    }
}
