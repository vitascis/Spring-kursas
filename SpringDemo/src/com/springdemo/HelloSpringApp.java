package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {

        // uzkrauti Spring konfiguracijos faila
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //gauti beana is spring konteinerio (contex'o)
        CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);

        //kreipsimes i bean'o metoda
        System.out.println(coach.getDailyWorkOut());

        // iskvieciamas FortuneService metodas
        System.out.println(coach.getDailyFortune());
        // uzdaryti context'a
        context.close();

 //   Susikurti objekta
 //Coach coach = new BaseballCoach();
 //       Coach coach = new TrackCoach();
 // Panaudoti objekta
 //       System.out.println(coach.getDailyWorkOut());
    }
}
