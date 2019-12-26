package com.cactus.demo.cactusspringboot.unsubmit.mq.mannual;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MQSender {
    private static final Logger log = LoggerFactory.getLogger(MQSender.class);

    public static void main(String[] args) throws IOException {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("192.168.221.128");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        Connection connection = connectionFactory.createConnection();

        Channel channel = connection.createChannel(true);
        channel.exchangeDeclare(MQConfig.FANOUT_EXCHANGE,"fanout");

        int i = 0;
        while (i <10000){
            channel.basicPublish(MQConfig.FANOUT_EXCHANGE,"", null,(i+"").getBytes());
            channel.txCommit();
            try {
                System.out.println(i);
                Thread.sleep(500);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            channel.close();
            connection.close();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
