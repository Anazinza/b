package com.dsm.spotemo.global;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Log4j2
@Component
public class TokenUtil {
    @Value("${auth.secret}")
    private String secret;

    public String createToken(String email, String nickname) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .claim("email", email)
                .claim("nickname", nickname)
                .setSubject("user")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+90000*60*24*12))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

}
