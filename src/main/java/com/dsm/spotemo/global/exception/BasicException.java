package com.dsm.spotemo.global.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
public class BasicException extends RuntimeException implements GraphQLError {
    private final ExceptionMessage em;
    private final String detailsMessage;

    public BasicException(ExceptionMessage exception, String detailsMessage) {
        super (exception.getMessage());
        this.em = exception;
        this.detailsMessage = detailsMessage;
    }


    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> attributes = new LinkedHashMap<>();
        attributes.put("code", this.em.getCode());
        attributes.put("message", this.em.getMessage());
        return attributes;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }
}
