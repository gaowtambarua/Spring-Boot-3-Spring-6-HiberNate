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


    @Override
    public String getDailyWorkout() {
        return "This is BaseballCoach";
    }
}
