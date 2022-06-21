package com.dsm.spotemo.global.exception.exceptions;

import com.dsm.spotemo.global.exception.BasicException;
import com.dsm.spotemo.global.exception.ExceptionMessage;

public class AccountNotFoundException extends BasicException {
    public AccountNotFoundException() {
        super(ExceptionMessage.AccountNotFoundException, "ID가 존재하지 않습니다. 회원가입이 필요합니다.");
    }
}
