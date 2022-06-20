package com.dsm.spotemo.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenAndAccountResponse {
    String email;
    String nickname;
    String token;
}
