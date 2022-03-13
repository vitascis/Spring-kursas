package com.springboot.demo.mycoolap.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

//    inject properties: coach.nane and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

//    expose new endpoint for teaminfo
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "coach: " + coachName + " " + "team name: " + teamName;
    }
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


