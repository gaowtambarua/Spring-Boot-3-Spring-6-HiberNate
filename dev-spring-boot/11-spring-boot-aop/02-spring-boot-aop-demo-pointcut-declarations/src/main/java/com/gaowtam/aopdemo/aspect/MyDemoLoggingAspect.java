package com.gaowtam.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component// ai class ti ke bean er moddhe rekhece
@Order(2)//order by kora hoyeche konti age print korbe seti
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Befor advice


//    @Pointcut("execution(* com.gaowtam.aopdemo.dao.*.*(..))") //(..) any class,any method,any numnbers of argument
//    /* Ai point card declare korar kacron ai ekti method shob jygy use kora jabe*/
//    private void forDaoPackage()
//    {
//
//    }
//
//    // create a pointcut for getter methods
//    @Pointcut("execution(* com.gaowtam.aopdemo.dao.*.get*(..))") // all g
//    private  void getter(){}
//
//    // create a pointcut for setter methods
//    @Pointcut("execution(* com.gaowtam.aopdemo.dao.*.set*(..))")
//    private  void setter(){}
//
//    // create pintcut: include package ... exclude getter/setter
//    @Pointcut("forDaoPackage() && !(getter()|| setter())")
//    private void forDaoPackageNoGetterSetter(){};

//    @Before("forDaoPackage()")
//    public void beforeAddAccountAdvice()
//    {
//        System.out.println("\n====>>> Executing @Before advice on method");
//    }
//
//    @Before("forDaoPackage()")
//    public  void performApiAnalytics()
//    {
//        System.out.println("\n====>>> Performing API analytics");
//    }

//    @Before("forDaoPackageNoGetterSetter()")
//    public  void performApiAnalytics()
//    {
//        System.out.println("\n====>>> Performing API analytics");
//    }
//
//    @Before("forDaoPackageNoGetterSetter()")
//    public  void logToCloudAsynce()
//    {
//        System.out.println("\n====>>> Logging to cloud in async fashion");
//    }


    @Before("com.gaowtam.aopdemo.aspect.GaowtamAopEcpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("\n====>>> 2 Executing @Before advice on method");
    }

    /// ///////onno class e transfer kora hoiyce ty invisible kora hoice
}
