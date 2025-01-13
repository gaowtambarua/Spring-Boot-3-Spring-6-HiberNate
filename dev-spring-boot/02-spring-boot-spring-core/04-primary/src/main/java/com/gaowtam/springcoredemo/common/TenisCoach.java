package com.gaowtam.springcoredemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TenisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "This is TenisCoach";
    }
}
