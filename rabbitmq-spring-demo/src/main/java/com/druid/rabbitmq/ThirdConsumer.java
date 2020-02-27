package com.druid.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class ThirdConsumer implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(ThirdConsumer.class);
    @Override
    public void onMessage(Message message) {
        logger.info("The third consumer received message : " + message);
    }
}
