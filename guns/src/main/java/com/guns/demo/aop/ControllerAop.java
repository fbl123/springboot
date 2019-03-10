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

    private Logger logger = LoggerFactory.getLogger(ControllerAop.class);


    @Pointcut(value = "execution(public * com.guns.demo.controller..*.*(..))")
    public void poincut() {
    }


    @Around("poincut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        try {
            logger.info("调用方法:{}",point.getSignature()); ;
            logger.info("目标参数为参数为{}",point.getArgs());
            result = point.proceed();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.info("异常----");

        }
        logger.info("---------end");

        return result;

    }
    private static final int SIZE = 6;
    private static final String SYMBOL = "*";

    public static void main(String[] args) {
        String value="124qda212";

        if (null == value || "".equals(value)) {
            System.out.println("value");
            return;
        }
        int len = value.length();
        int pamaone = len / 2;
        int pamatwo = pamaone - 1;
        int pamathree = len % 2;
        StringBuilder stringBuilder = new StringBuilder();
        if (len <= 2) {
            if (pamathree == 1) {//如果长度为2直接返回*
                System.out.println(SYMBOL);
            }
            //如果低于一位 返回*和第一个字节
            stringBuilder.append(SYMBOL);
            stringBuilder.append(value.charAt(len - 1));
        } else {//长度大余2时
            if (pamatwo <= 0) {//如果长度是3时（／2 -1小于1时）
                //返回第一位+*+最后一位
                stringBuilder.append(value.substring(0, 1));
                stringBuilder.append(SYMBOL);
                stringBuilder.append(value.substring(len - 1, len));
            } else if (pamatwo >= SIZE / 2 && SIZE + 1 != len) {//如果长度／2 -1大于2并且长度不是size+1时）
                int pamafive = (len - SIZE) / 2;
                stringBuilder.append(value.substring(0, pamafive));
                for (int i = 0; i < SIZE; i++) {
                    stringBuilder.append(SYMBOL);
                }
                if ((pamathree == 0 && SIZE / 2 == 0) || (pamathree != 0 && SIZE % 2 != 0)) {
                    stringBuilder.append(value.substring(len - pamafive, len));
                } else {
                    stringBuilder.append(value.substring(len - (pamafive + 1), len));
                }
            } else {
                int pamafour = len - 2;
                stringBuilder.append(value.substring(0, 1));
                for (int i = 0; i < pamafour; i++) {
                    stringBuilder.append(SYMBOL);
                }
                stringBuilder.append(value.substring(len - 1, len));
            }
        }
        System.out.println(stringBuilder.toString());
    }

}
