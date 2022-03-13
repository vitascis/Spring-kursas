package com.springdemo;

public class TrackCoach implements Coach {

    // apibrezti "private" tipo kintamaji priklausomybei
    private  FortuneService fortuneService;

    // atlikti priklausomybiu injekcija per konstruktoriu
    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkOut() {
        return "Run 5000 m everyday";
    }

    @Override
    public String getDailyFortune() {
     // panaudoti FortuneService "pagal paskirti" (kad sektusi)
        return fortuneService.getFortune();
    }
}
