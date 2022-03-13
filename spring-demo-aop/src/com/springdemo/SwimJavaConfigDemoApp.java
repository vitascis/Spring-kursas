package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {

 //   read Spring config Java class SportConfig
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

 // get the bean from Spring container
        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class); // kazkada buvo name:
        // "thatSillyCoach",
        // ...pridejome Swim prie Coach

 // call a method from
        System.out.println(coach.getDailyWorkOut());
// ...call method getDailyFortune
        System.out.println(coach.getDailyFortune());
//  call our swimCoach methods has the props values injected
        System.out.println("email: " + coach.getEmail() + "\n" + "team: " + coach.getTeam());
//  close the context
        context.close();
    }
}
