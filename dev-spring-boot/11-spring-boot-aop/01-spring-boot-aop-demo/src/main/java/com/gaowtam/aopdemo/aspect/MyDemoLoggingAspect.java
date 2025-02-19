package com.gaowtam.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component// ai class ti ke bean er moddhe rekhece
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Befor advice

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice()
    {
        System.out.println("\n====>>> Executing @Before advice on addAccount()");
    }
}
