package com.example.jwtsecurity.controller;

import com.example.jwtsecurity.model.JWTUser;
import com.example.jwtsecurity.security.JWTTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    JWTTokenGenerator jwtTokenGenerator ;

    @PostMapping("/get_token")
    public String generate(@RequestBody JWTUser jwtUser){
        String token = jwtTokenGenerator.generate(jwtUser);
        return token;
    }
}
