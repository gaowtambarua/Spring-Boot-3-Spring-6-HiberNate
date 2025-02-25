package com.gaowtam.aopdemo.aspect;

import com.gaowtam.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /// ////////////////////////////////////////////////////

    @Around("execution(* com.gaowtam.aopdemo.service.*.getFortune(..))")
    public Object arroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
    {
        // print out method we are advising on
        String method=theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Excuting @Around on method: "+method);

        // get begin timestamp
//        long begin=System.currentTimeMillis();
        long begin=System.nanoTime();

        // now, let's execute the method
        Object result=null;
        try {
            result=theProceedingJoinPoint.proceed();
        } catch (Exception exc) {
            // log the exception
            System.out.println("Exceptin: "+exc.getMessage());

//            // give user a custom message
//            result="Major accident!But no worries,your private AOP helicopter is on the way!";

            // rethrow exception
            throw exc;
        }

        // get end timestamp
//        long end=System.currentTimeMillis();

        // compute duration and display it
//        long duration=end-begin;
//        System.out.println("\n=====>: "+duration/1000.0+" seconds");

        long end=System.nanoTime();
        long duration=end-begin;
        System.out.println("\n=====>: "+duration +" nanoseconds");




        return result;
    }



    /// ///////////////////////////////////////////////////////////////////////////
    @Before("com.gaowtam.aopdemo.aspect.GaowtamAopEcpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint)
    {
        System.out.println("\n====>>> 2 Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();//mehtod er location print korbe
        System.out.println("Method: "+methodSignature);

        // display method arguments

        // get args
        Object[] args=theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg: args)
        {
            System.out.println(tempArg);
            if(tempArg instanceof Account)
            {
                // downcast and print Account specific stuff
                Account theAccount=(Account) tempArg;

                System.out.println("account name: "+theAccount.getName());
                System.out.println("account level: "+theAccount.getLevel());
            }
        }
    }

    /// /////////////////////////////////////////////////////////////////////
    // add a new advice for @AfterReturning on the findAccounts method
    // ai method ti method er return value dekhar use kora hoyeche.
    @AfterReturning(
            pointcut = "execution(* com.gaowtam.aopdemo.dao.AccountDAO.findAccount(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result)
    {
        // print out which method we are advising on
        String method=theJoinPoint.getSignature().toLongString();
        System.out.println("\n\n\n\n====>>> Excuting @AfterReturning on method: "+method);

        // print out the results of the method call
        System.out.println("\n====>>> result is: "+result);

        // let's post-process the data ... let's modify it:-)

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("\n====>>> result is: "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for (Account tempAccount : result)
        {
            // get uppercase version of name
            String theUpperName=tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }
    }


    /// ////////////////////////////////////////////////////////////////////////////////

    @AfterThrowing(
            pointcut = "execution(* com.gaowtam.aopdemo.dao.AccountDAO.findAccount(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc)
    {
        // print out which method we are advising on
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\n\n\n\n====>>> Excuting @AfterThrowing on method: "+method);

        // log the exception
        System.out.println("\n====>>> The exception is: "+theExc);
    }

    /// //////////////////////////////////////////////////////////////////////

    @After("execution(* com.gaowtam.aopdemo.dao.AccountDAO.findAccount(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint)
    {
        // print out which method we are advising on
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Excuting @After (finally) on method: "+method);
    }


    /// ///////onno class e transfer kora hoiyce ty invisible kora hoice
}
