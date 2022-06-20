package com.dsm.spotemo.global.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BasicException extends RuntimeException implements GraphQLError {
    private final ExceptionMessage em;

    public BasicException(ExceptionMessage exception) {
        super (exception.getMessage());
        this.em = exception;
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
