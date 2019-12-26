package com.cactus.demo.cactusspringboot.unsubmit.mq;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MQReceiver {
    private static final Logger log = LoggerFactory.getLogger(MQReceiver.class);


}
