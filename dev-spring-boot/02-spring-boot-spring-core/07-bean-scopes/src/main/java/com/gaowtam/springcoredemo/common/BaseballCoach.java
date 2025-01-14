package com.gaowtam.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) /*er maddhome portibar notun bean toiri hobe jokhon ai class ke zacy kora hobe*/
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
