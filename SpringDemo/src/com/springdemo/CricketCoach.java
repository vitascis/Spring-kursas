package com.springdemo;

public class CricketCoach implements  Coach {
    private FortuneService fortuneService;
    // pridesime naujus laukelius el.p. ir komanda (team)
    private String emailAddress;
    private String team;

    public CricketCoach() {
        System.out.println("CricketCoach: inside no arg construktor");
    }
public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    System.out.println("CricketCoach: inside setter method - set fortuneService");
}
public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    System.out.println("Cricket coach: inside setter method - set emailAddress");
}
public void setTeam(String team) {
        this.team = team;
    System.out.println("CricketCoach: inside setter method - set team");
}

public String getEmailAddress() {
        return emailAddress;
}
public String getTeam() {
        return team;
}

public String getDailyWorkout() {
        return  "Practice fast bowling";
}

    @Override
    public String getDailyWorkOut() {
        return "Practice fast bowling for 50 min";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
