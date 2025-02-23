package com.gaowtam.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component// ai class ti ke bean er moddhe rekhece
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Befor advice


    @Pointcut("execution(* com.gaowtam.aopdemo.dao.*.*(..))") //(..) any class,any method,any numnbers of argument
    /* Ai point card declare korar kacron ai ekti method shob jygy use kora jabe*/
    private void forDaoPackage()
    {

    }

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("\n====>>> Executing @Before advice on method");
    }

    @Before("forDaoPackage()")
    public  void performApiAnalytics()
    {
        System.out.println("\n====>>> Performing API analytics");
    }
}
