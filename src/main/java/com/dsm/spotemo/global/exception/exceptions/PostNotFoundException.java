package com.dsm.spotemo.global.exception.exceptions;

import com.dsm.spotemo.global.exception.BasicException;
import com.dsm.spotemo.global.exception.ExceptionMessage;

public class PostNotFoundException extends BasicException {
    public PostNotFoundException() {
        super(ExceptionMessage.PostNotFoundException, "게시글을 찾을 수 없습니다.");
    }
}
