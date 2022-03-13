package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {

 //   read Spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

 // get the bean from Spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);        //buvo name: "thatSillyCoach"
        Coach coach1 = context.getBean("tennisCoach", Coach.class);

        //palyginsim, ar bean'ai yra tiepatys
        boolean result = (coach == coach1);

        // atspausdinti rezultatus
        System.out.println("Rodome y ta paty objekta" + result);
        System.out.println("Memory location for coach" + coach);
        System.out.println("memory location for coach1" + coach1);

 // call a method from
        System.out.println(coach.getDailyWorkOut());
// ...call method getDailyFortune
        System.out.println(coach.getDailyFortune());
//  close the context
        context.close();
    }
}
