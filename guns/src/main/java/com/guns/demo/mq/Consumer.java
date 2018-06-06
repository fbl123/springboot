package com.guns.demo.mq;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "mq")
    public void receiveQueue(String text){
//        if("消息2".equals(text)){
//            throw new RuntimeException();
//        }
        System.out.println(text);

    }

}
