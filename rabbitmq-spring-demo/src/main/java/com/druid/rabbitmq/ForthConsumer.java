package com.druid.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class ForthConsumer implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(ForthConsumer.class);
    @Override
    public void onMessage(Message message) {
        logger.info("The forth consumer received message : " + message);
    }
}
