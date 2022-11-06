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
public class ServiceAspect {

    Logger loger = Logger.getLogger(ServiceAspect.class.getName());

    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void servicePointCut(){/*this is a pointcut to monitor repository.*/}

    @Before("servicePointCut()")
    public void serviceInvocationAdvice(JoinPoint joinPoint){
        loger.log(Level.INFO,String.format("%s Service executed.",joinPoint.getSignature()));
    }
}
