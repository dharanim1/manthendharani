package com.onlinebookshop.shop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.onlinebookshop.shop.service.*.*(..))")
    public void beforeServiceMethods() {
        System.out.println("----Logging from aspect: Method called in service layer-------");
    }

    @After("execution(* com.onlinebookshop.shop.service.*.*(..))")
    public void afterServiceMethods() {
        System.out.println("----Logging from aspect: Method execution completed in service layer-------");
    }

    @Around("execution(* com.onlinebookshop.shop.service.*.*(..))")
    public Object aroundServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("------Logging: Method " + joinPoint.getSignature().getName() + " executed in: "
                + (endTime - startTime) + " ms");
        return result;
    }

    @AfterReturning(pointcut = "execution(* com.onlinebookshop.shop.service.*.*(..))", returning = "result")
    public void afterReturningServiceMethods(Object result) {
        System.out.println("----Logging from aspect: Method returned with value: " + result + " -------");
    }

    @AfterThrowing(pointcut = "execution(* com.onlinebookshop.shop.service.*.*(..))", throwing = "exception")
    public void afterThrowingServiceMethods(Exception exception) {
        System.out.println("----Logging from aspect: Method threw exception: " + exception.getMessage() + " -------");
    }
}
