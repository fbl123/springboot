package com.guns.demo.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;


    public void send(Destination destination, MessageCreator message) throws JMSException {
        jmsTemplate.send(destination, message);
    }


    public void send(Destination destination, String message) throws JMSException {
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        };
        jmsTemplate.send(destination, messageCreator);
    }


}
