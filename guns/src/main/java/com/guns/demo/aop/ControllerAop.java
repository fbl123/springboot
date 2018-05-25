package com.guns.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class ControllerAop {

    private Logger logger=LoggerFactory.getLogger(ControllerAop.class);


    @Pointcut(value = "execution(public * com.guns.demo.controller..*.*(..))")
    public void poincut(){}


    @Around("poincut()")
<<<<<<< HEAD
    public Object around(ProceedingJoinPoint point){
        Object result=null;
        try {
            logger.info("前置通知");
             result = point.proceed();
            logger.info("后置通知");
=======
    public void around(ProceedingJoinPoint point){
        try {
            logger.info("前置通知");
            point.proceed();
            logger.info("后置通知");

>>>>>>> 0c60abd094fcbecea525f895823ae668c8155512
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.info("异常通知");

        }
        logger.info("---------end");

<<<<<<< HEAD
            return result;
=======

>>>>>>> 0c60abd094fcbecea525f895823ae668c8155512
    }



}
