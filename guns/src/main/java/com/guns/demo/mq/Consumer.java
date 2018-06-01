package com.guns.demo.mq;

import org.springframework.beans.factory.annotation.Autowired;
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
