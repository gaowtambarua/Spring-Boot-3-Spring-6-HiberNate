package com.gaowtam.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class GaowtamAopEcpressions {

    // this is where we add all of our related advices for logging

    // let's start with an @Befor advice


    @Pointcut("execution(* com.gaowtam.aopdemo.dao.*.*(..))") //(..) any class,any method,any numnbers of argument
    /* Ai point card declare korar kacron ai ekti method shob jygy use kora jabe*/
    public void forDaoPackage()
    {

    }

    // create a pointcut for getter methods
    @Pointcut("execution(* com.gaowtam.aopdemo.dao.*.get*(..))") // all g
    public  void getter(){}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.gaowtam.aopdemo.dao.*.set*(..))")
    public  void setter(){}

    // create pintcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter()|| setter())")
    public void forDaoPackageNoGetterSetter(){};
}
