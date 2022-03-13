package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {

 //   read Spring config Java class SportConfig
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

 // get the bean from Spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);        //buvo name: "thatSillyCoach"

 // call a method from
        System.out.println(coach.getDailyWorkOut());
// ...call method getDailyFortune
        System.out.println(coach.getDailyFortune());
//  close the context
        context.close();
    }
}
