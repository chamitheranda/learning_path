package com.example.jwtsecurity.security;

import com.example.jwtsecurity.model.JWTUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JWTValidator {
    String secret = "hardcoded_secret";

    public JWTUser validate(String token) {
        JWTUser jwtUser = null ;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JWTUser();
            jwtUser.setUserName( body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return jwtUser ;
    }
}
