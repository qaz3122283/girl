package com.test.girl.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {
    @Pointcut("execution(public * com.test.girl.controller.GirlController.*(..))")
    public void log(){
        System.out.println("1");
    }

    @Before("log()")
    public void before(){
        System.out.println("2");
    }

}
