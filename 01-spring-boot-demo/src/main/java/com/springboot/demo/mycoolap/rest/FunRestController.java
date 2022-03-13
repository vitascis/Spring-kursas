package com.springboot.demo.mycoolap.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {
//expose "/" that return "Hello World!"
    @GetMapping("/")
    public String sayHello() {
       return "HEll world!   Time on server is " + LocalDateTime.now();
    }
}
