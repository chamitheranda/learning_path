package com.example.profile.testing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/welcome")
@RestController
public class Hello {
    @Value("${spring.message}")
    private String message ;

    @GetMapping("/m1")
    public String hello(){
        return message ;
    }

}
