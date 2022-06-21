package com.dsm.spotemo.global.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RestExceptionResponse {
    private final int status;
    private final String message;
    private final String detailsMessage;
    private final String stack;
}
