package com.example.springdbsecurity.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@RestController
public class HelloResource {

    @GetMapping("/all")
    public String hello(){
        return "Hello Chamith";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello(){
        return "Secured hello";
    }

    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }
}
