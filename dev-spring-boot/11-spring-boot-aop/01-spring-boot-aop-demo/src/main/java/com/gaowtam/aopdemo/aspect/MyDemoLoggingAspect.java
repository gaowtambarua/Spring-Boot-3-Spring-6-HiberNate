package com.gaowtam.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component// ai class ti ke bean er moddhe rekhece
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Befor advice

//    @Before("execution(public void com.gaowtam.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void addAccount())") // all addAccount call hobe.
//    @Before("execution(public void add*())") // add diye shokol method shuru name ke call kora hobe
//    @Before("execution(void add*())")
//    @Before("execution(* add*())") // any return type and any add method with start add name allow
//    @Before("execution(* add*(com.gaowtam.aopdemo.Account))")
//    @Before("execution(* add*(com.gaowtam.aopdemo.Account,..))") //(..) any numnbers of argument
//    @Before("execution(* add*(..))") //(..) any numnbers of argument
@Before("execution(* com.gaowtam.aopdemo.dao.*.*(..))") //(..) any class,any method,any numnbers of argument
    public void beforeAddAccountAdvice()
    {
        System.out.println("\n====>>> Executing @Before advice on addAccount()");
    }
}
