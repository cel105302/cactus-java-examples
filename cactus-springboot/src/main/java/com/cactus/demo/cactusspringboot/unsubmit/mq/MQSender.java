package com.cactus.demo.cactusspringboot.unsubmit.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQSender {
    private static final Logger log = LoggerFactory.getLogger(MQSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendFanout() throws InterruptedException {
        int i = 0;
        while (true) {
            System.out.println(i);
            rabbitTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, MQConfig.TOPIC_KEY2, "ABC" + i);
            i++;
            Thread.sleep(1000);
        }

    }


}
