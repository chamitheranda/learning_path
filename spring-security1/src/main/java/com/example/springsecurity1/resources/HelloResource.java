package com.example.springsecurity1.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@RestController
public class HelloResource {
    @GetMapping
    public String hello(){
        return "Hello Chamith";
    }
}
