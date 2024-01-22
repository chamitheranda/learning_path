package com.chamith.testcontrollerexample.resource;

import com.chamith.testcontrollerexample.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloResource {

    @Autowired
    private HelloService helloService ;

    @GetMapping
    public String helloWorld(){
        return "Hello world";
    }
    @GetMapping("/service")
    public String serviceCall(){
        return helloService.hello();
    }

    @GetMapping(value = "/json" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello json(){
        return new Hello(
                "greetings",
                "Hello World"
        );
    }
    @PostMapping(value = "/post" , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello post(@RequestBody Hello hello){
        return hello;
    }

    public static class Hello {
        private String title ;
        private String value ;

        public Hello(String title, String value) {
            this.title = title;
            this.value = value;
        }

        public Hello() {
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
