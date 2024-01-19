package com.chamith.cloud.helloclient.resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/hello/client")
public class HelloResource {
    @Autowired
    private RestTemplate restTemplate ;

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping
    public String hello(){
        String url = "http://hello-server/rest/hello/server";
        return restTemplate.getForObject(url , String.class)+" | Including client";
    }

    public String fallback(Throwable hystrixCommand){
        return "Fall back hello world ";
    }
}
