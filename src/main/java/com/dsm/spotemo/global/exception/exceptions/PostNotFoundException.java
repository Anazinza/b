package com.dsm.spotemo.global.exception.exceptions;

import com.dsm.spotemo.global.exception.BasicException;
import com.dsm.spotemo.global.exception.ExceptionMessage;

public class PostNotFoundException extends BasicException {
    public PostNotFoundException() {
        super(ExceptionMessage.PostNotFoundException);
    }
}
