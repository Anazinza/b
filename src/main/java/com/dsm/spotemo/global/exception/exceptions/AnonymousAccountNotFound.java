package com.dsm.spotemo.global.exception.exceptions;

import com.dsm.spotemo.global.exception.BasicException;
import com.dsm.spotemo.global.exception.ExceptionMessage;

public class AnonymousAccountNotFound extends BasicException {
    public AnonymousAccountNotFound() {
        super(ExceptionMessage.AnonymousAccountNotFound, "익명 계정이 존재하지 않습니다. 이건 서버 잘못이에요. 부디 이 오류를 안 볼 수 있길 바랍니다.");
    }
}
