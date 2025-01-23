package com.gaowtam.springcoredemo.config;

import com.gaowtam.springcoredemo.common.Coach;
import com.gaowtam.springcoredemo.common.SwimCoch;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoch()
    {
        return new SwimCoch();
    }
}
