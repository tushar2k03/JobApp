package com.tushar.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Join;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogginAspect {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LogginAspect.class);

    //return type ,class-name.method-name,args
    @Before("execution(* com.tushar.springbootrest.service.JobService.*(..))")
    public void logMethodCall() {
        LOGGER.info("Before Logger");
    }

    @After("execution(* com.tushar.springbootrest.service.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("After Logger after called method name : "+jp.getSignature().getName());
    }
    @AfterThrowing("execution(* com.tushar.springbootrest.service.JobService.getJob(..))")
    public void logMethodCrash(JoinPoint jp) {
        LOGGER.info("Daya  method mai kuch to gad bad hai  -> method name : "+jp.getSignature().getName());
    }
}
