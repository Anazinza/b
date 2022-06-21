package com.dsm.spotemo.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    protected ResponseEntity<RestExceptionResponse> basicExceptionHandler(final BasicException e) {
        final int code = e.getEm().getCode();
        return new ResponseEntity<>(
                RestExceptionResponse.builder()
                        .status(e.getEm().getCode())
                        .message(e.getMessage())
                        .detailsMessage(e.getDetailsMessage())
                        .stack(Arrays.stream(e.getStackTrace()).findAny().toString()).build(),
                HttpStatus.valueOf(code));
    }
}
