package com.didi.rest.webservices.restful_web_services.helloWorld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {

    @GetMapping("hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
