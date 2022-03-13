package com.springboot.demo.mycoolap.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {
    //expose "/" that return "Hello World!"
    @GetMapping("/")
    public String sayHello() {

        return "Hello World!   Time on server " + LocalDateTime.now();
    }

    //    expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run 1000m, then 2000m and finally 100m";
    }

    @GetMapping("/fortune")
    public String fortune() {

        return "Today is your unlucky  day!";
    }
}


