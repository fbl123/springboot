package com.guns.demo.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.activation.CommandObject;
import javax.jms.*;

@Component
public class Producer /*implements CommandLineRunner*/ {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Queue queue;

//    public void send(String message){
//        jmsMessagingTemplate.convertAndSend(queue,message);
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        send("meassage");
//
//    }


//    public void send(Destination destination, MessageCreator message) throws JMSException {
//        jmsTemplate.send(destination, message);
//    }
//
//

    public void send(String message) {
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        };
        jmsTemplate.send(queue, messageCreator);
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
