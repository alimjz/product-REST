package com.digipay.productrest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class RepositoryAspect {
    Logger loger = Logger.getLogger(RepositoryAspect.class.getName());

    @Pointcut("@within(org.springframework.stereotype.Repository)")
    public void repositoryPointCut(){/*this is a pointcut to monitor repository.*/}

    @Before("repositoryPointCut()")
    public void repositoryInvocationAdvice(JoinPoint joinPoint){
        loger.log(Level.INFO,String.format("%s Repository invoked a DDL/DML.",joinPoint.getArgs()));
    }

}
