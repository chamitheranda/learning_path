package com.example.springsecurityldap.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {
    @GetMapping("/check")
    public String check(){
        return "check worked";
    }
}
