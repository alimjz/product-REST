package com.digipay.productrest.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class ControllerAspect {

    Logger loger = Logger.getLogger(ControllerAspect.class.getName());
    /*
    * This aspect logs the all public method executed in controllers.
    */

    @Around("execution(public * com.digipay.productrest.controller.*.*(..))")
    public Object controllersInvocationDurationAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch watch = new StopWatch();
        watch.start();
        Object proceed = joinPoint.proceed();
        watch.stop();
        loger.log(Level.INFO,String.format("Method invoked: %s  Executed in -> %s milisecond",
                joinPoint.getSignature(),watch.getTotalTimeMillis()));
        return proceed;
    }

}
