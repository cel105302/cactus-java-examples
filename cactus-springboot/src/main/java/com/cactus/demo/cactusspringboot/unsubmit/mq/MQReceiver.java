package com.cactus.demo.cactusspringboot.unsubmit.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MQReceiver {
    private static final Logger log = LoggerFactory.getLogger(MQReceiver.class);

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE2)
    public void fanout(Object message){
        System.out.println("one" + message);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE2)
    public void fanout1(Object message){
        System.out.println("two" + message);
    }
}
