package com.dsm.spotemo.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestExceptionResponse {
    private final int status;
    private final String message;
}
