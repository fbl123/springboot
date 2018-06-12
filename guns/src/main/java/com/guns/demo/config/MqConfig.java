package com.guns.demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.*;

@Configuration
@EnableJms
public class MqConfig {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("mq");
    }



}
