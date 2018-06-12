package com.huijie.demo.mq;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    //监听 mq这个Destination 一旦有消息 就执行
    @JmsListener(destination = "mq")
    public void receiveQueue(String text){
//        if("消息2".equals(text)){
//            throw new RuntimeException();
//        }
        System.out.println(text);

    }

}
