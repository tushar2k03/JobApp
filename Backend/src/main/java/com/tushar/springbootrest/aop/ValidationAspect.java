package com.tushar.springbootrest.aop;

import jakarta.persistence.OneToMany;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);
    @Around("execution(* com.tushar.springbootrest.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp,int postId) throws Throwable {
        if(postId < 0 ) {
            LOGGER.info("Bro wtf how postId become negative please check it out whats wrong");
            postId = -postId;
        }
        Object obj = jp.proceed(new Object[]{postId});
        return obj;
    }
}
