package com.dsm.spotemo.rest;

import com.dsm.spotemo.dto.request.LoginRequest;
import com.dsm.spotemo.dto.response.TokenAndAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService service;

    @PostMapping("/account")
    public TokenAndAccountResponse login(@RequestBody final LoginRequest req) {
        return service.login(req.getEmail(), req.getPassword());
    }
}
