package com.springdemo;

public class SadFortuneService implements  FortuneService{

    @Override
    public String getFortune() {
        return "...today is your sad day";
    }
}
