package com.guns.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class ControllerAop {


    @Pointcut(value = "execution(public * com.guns.demo.controller..*.*(..))")
    public void poincut(){}


    @Around("poincut()")
    public void around(ProceedingJoinPoint point){
        System.out.println(point);
        System.out.println("前");
        try {
            point.proceed();
            System.out.println("后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常");

        }
        System.out.println("---------end");

    }



}
