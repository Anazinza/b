package com.dsm.spotemo.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    protected ResponseEntity<RestExceptionResponse> basicExceptionHandler(final BasicException e) {
        final String message = e.getEm().getMessage();
        final int code = e.getEm().getCode();
        return new ResponseEntity<>(new RestExceptionResponse(code, message), HttpStatus.valueOf(code));
    }
}
