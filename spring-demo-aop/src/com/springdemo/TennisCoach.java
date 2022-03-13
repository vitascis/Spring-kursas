package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component                                    // ("thatSillyCoach") buvo
@Scope  // bandyti "prototype" kaip default'iny
public class TennisCoach implements Coach {
    @Autowired       // Java reflections technologija, (nenaudojant konstruktoriaus, seter'io)
    @Qualifier("randomFortuneService")                             // buvo happyFortuneServise
    private FortuneService fortuneService;


//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }
    public TennisCoach()
    {
        System.out.println("TennisCoach: inside default construktor");
    }
    @Override
    public String getDailyWorkOut() {

        return "Practice your backhand volleys";
    }
@Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
}
//   @Autowired
// public void setFortuneService(FortuneService fortuneService) {
//    this.fortuneService = fortuneService;
//    System.out.println("TennisCoach: inside set fortuneService");
//    }

//   @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService) {
//        System.out.println("TennisCoach: doSomeCrazyStuff method");
//        this.fortuneService = fortuneService;

//    }

// define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("TennisCoach: inside doMyStartupStuff");
    }

    // define my destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("TennisCoach: doMyCleanupStuff");
    }



    }


