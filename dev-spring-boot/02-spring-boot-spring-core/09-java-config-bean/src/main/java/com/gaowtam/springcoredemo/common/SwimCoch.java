package com.gaowtam.springcoredemo.common;

public class SwimCoch implements Coach{

    public SwimCoch()
    {
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 100 meters as a warm up";
    }
}
