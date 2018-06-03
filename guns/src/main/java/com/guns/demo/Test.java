package com.guns.demo;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Test {
    public static final String URL = "tcp://localhost:61616";
    // 目标，在ActiveMQ管理员控制台创建 http://localhost:8161/admin/queues.jsp
    public static final String DESTINATION = "mq";
   

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD, URL);

        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            //获取操作连接
            /**
             * 参数说明
             * 第一个参数  是否时事务性消息 设置为true时第二个参数无效
             * 第二个参数 消息的签收类型Session.AUTO_ACKNOWLEDGE 自动确认 异常时也会确认
             * Session.CLIENT_ACKNOWLEDGE为客户端确认。客户端接收到消息后，
             * 必须调用javax.jms.Message的acknowledge方法。
             * jms服务器才会删除消息。
             *
             *
             */
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //消息发送的位置
            Destination destination = session.createQueue(DESTINATION);
            //消息提供者
//            producer(session,destination);

            //消息消费者
            consumer(session, destination);

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (null != connection) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private static void consumer(Session session, Destination destination) throws JMSException {
        MessageConsumer consumer = session.createConsumer(destination);//创建消费者 消费制定队列中的消息
        while (true) {
            //获取消息
            TextMessage message = (TextMessage) consumer.receive();
            if (null == message) {
                break;

            }
            //获取消息内容
            String text = message.getText();
            System.out.println(text);
        }


    }


    public static void producer(Session session, Destination destination) throws JMSException {
        //创建提供者
        MessageProducer producer = session.createProducer(destination);
        //创建消息
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("f发送的内容");
        producer.send(textMessage);
        //提交
        session.commit();
    }

}
