package com.cactus.demo.cactusspringboot.unsubmit.mq.mannual;

import com.rabbitmq.client.*;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MQConfig {

    public static final String FANOUT_EXCHANGE = "fanout.exchange";

    public static void main(String[] args) throws IOException {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("192.168.221.128");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        Connection connection = connectionFactory.createConnection();

        Channel channel = connection.createChannel(true);
        channel.exchangeDeclare(MQConfig.FANOUT_EXCHANGE, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, MQConfig.FANOUT_EXCHANGE, "");


        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println(new String(body));
            }
        };

        channel.basicConsume(queueName, true, consumer);
    }
}
