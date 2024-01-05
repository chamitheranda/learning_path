package com.example.micrometer_prometheus.config;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloController {
    @Timed(
            value = "hello.request1",
            histogram = true,
            percentiles = {0.96 , 0.97},
            extraTags = {"version","1.0"}
    )
    @GetMapping("/hello1")
    public String hello2(){
        return "hello chamith";
    }

    @Timed(
            value = "hello.request2",
            histogram = true,
            percentiles = {0.96 , 0.97},
            extraTags = {"version","1.0"}
    )
    @GetMapping("/hello2")
    public String hello1(){
        return "hello eranda";
    }
}
