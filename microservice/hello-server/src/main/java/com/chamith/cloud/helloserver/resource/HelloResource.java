package com.chamith.cloud.helloserver.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/hello/server")
public class HelloResource {

    @GetMapping
    public String hello(){
        return "Hi Chamith Eranda";
    }
}
