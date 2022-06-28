package com.dsm.spotemo.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class AccountResponse {
    private String email;
    private String nickname;
//    private Emotions emotions;
    private Set<String> emotions;
}
