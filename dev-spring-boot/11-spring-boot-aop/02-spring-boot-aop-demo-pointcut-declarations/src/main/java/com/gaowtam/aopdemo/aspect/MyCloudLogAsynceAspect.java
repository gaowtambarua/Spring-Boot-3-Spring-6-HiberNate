package com.gaowtam.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)//order by kora hoyeche konti age print korbe seti
public class MyCloudLogAsynceAspect {

    @Before("com.gaowtam.aopdemo.aspect.GaowtamAopEcpressions.forDaoPackageNoGetterSetter()")
    public  void logToCloudAsynce()
    {
        System.out.println("\n====>>>1 Logging to cloud in async fashion");
    }
}
