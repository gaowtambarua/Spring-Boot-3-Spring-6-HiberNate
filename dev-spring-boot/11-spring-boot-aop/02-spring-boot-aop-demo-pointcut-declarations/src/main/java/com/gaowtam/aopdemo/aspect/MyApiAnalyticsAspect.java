package com.gaowtam.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)//order by kora hoyeche konti age print korbe seti
public class MyApiAnalyticsAspect {

    @Before("com.gaowtam.aopdemo.aspect.GaowtamAopEcpressions.forDaoPackageNoGetterSetter()")
    public  void performApiAnalytics()
    {
        System.out.println("\n====>>>3 Performing API analytics");
    }
}
