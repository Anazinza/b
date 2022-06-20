package com.dsm.spotemo.global.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {
    EmailAlreadyExist(400,"email already exist"),
    PasswordMisMatch(400, "password mismatch"),
    AccountNotFoundException(404, "account not found"),
    PostNotFoundException(404, "post not found");

    private int code;
    private String message;

    ExceptionMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
