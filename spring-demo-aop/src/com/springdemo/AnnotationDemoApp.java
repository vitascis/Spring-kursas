package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

 //   read Spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

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
