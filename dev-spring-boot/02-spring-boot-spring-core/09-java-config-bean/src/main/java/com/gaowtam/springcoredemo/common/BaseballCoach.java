package com.gaowtam.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    public BaseballCoach()
    {
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    //define our init method
    @PostConstruct
    public void doMyStartupStuff()
    {
        System.out.println("In doMyStartupStuff(): "+getClass().getSimpleName());
    }

    // define our destory method

    @PreDestroy
    public void doMyCleanupStuff()
    {
        System.out.println("In doMyCleanupStuff(): "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "This is BaseballCoach";
    }
}
