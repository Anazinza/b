package com.dsm.spotemo.dto.response;

import com.dsm.spotemo.entity.Account;
import lombok.Builder;

@Builder
public class TokenAndAccountDto {
    String email;
    String nickname;
    String token;
}
