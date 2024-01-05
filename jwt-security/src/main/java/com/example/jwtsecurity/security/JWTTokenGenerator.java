package com.example.jwtsecurity.security;

import com.example.jwtsecurity.model.JWTUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JWTTokenGenerator {
    public String generate(JWTUser jwtUser) {
        Claims claims = Jwts.claims().setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role" , jwtUser.getRole());

                return Jwts.builder()
                        .setClaims(claims)
                        .signWith(SignatureAlgorithm.HS512 , "hardcoded_secret")
                        .compact();
    }
}
