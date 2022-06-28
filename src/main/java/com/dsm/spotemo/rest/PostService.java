package com.dsm.spotemo.rest;

import com.dsm.spotemo.entity.Post;
import com.dsm.spotemo.global.auth.AuthenticationFacade;
import com.dsm.spotemo.global.exception.BasicException;
import com.dsm.spotemo.global.exception.ExceptionMessage;
import com.dsm.spotemo.global.exception.exceptions.PostNotFoundException;
import com.dsm.spotemo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;
    private final AuthenticationFacade authentication;

    public void postDelete(String id) {
        Post post = repository.findById(id).orElseThrow(PostNotFoundException::new);

        if(!writerCheck(post.getAccount().getEmail())) {
            throw new BasicException(ExceptionMessage.NotAuthor, "작성자가 아니기때문에 삭제할 수 있는 권한이 없습니다.");
        }

        post.postDelete();

        repository.save(post);
    }

    private boolean writerCheck(String email) {
        return email.equals(authentication.getAccountDetails().getUsername());
    }
}
