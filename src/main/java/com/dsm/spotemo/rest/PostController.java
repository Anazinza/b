package com.dsm.spotemo.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/post/{id}")
    public void postDelete(@PathVariable String id) {
        postService.postDelete(id);
    }
}
