package com.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
// create an array of Strings
    private String [] data={
    "Kruopstumas yra kelias y sekme",
    "Kelione yra atlygis",
    "Miegas-tai raktas y sekme"
};
// create random number generator
private Random random = new Random();

    @Override
    public String getFortune() {
// pick random string from array
int index = random.nextInt(data.length);
String fortune = data[index];
        return fortune;
    }
}
