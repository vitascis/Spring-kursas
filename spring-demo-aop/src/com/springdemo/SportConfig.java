package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//   @ComponentScan("com.springdemo") (be @Comp..., nes norime pasinaudoti rankiniu budu sukurtais bean'ais Java budu)
@PropertySource(value = "classpath:application.yaml", encoding = "UTF-8") // pradinis variantas ("classpath:sport.properties")

public class SportConfig {

    // define for our sadFortuneServise
    @Bean
    public FortuneService sadFortuneServise() {

        return new SadFortuneService();
    }
    // define bean for our swimCoach and inject dependency
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneServise());
    }

}
