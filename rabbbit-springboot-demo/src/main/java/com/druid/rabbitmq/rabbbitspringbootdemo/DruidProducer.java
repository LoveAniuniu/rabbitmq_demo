package com.druid.rabbitmq.rabbbitspringbootdemo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DruidProducer {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void  send(){

        amqpTemplate.convertAndSend("", "FIRST_QUEUE", "---------- a direct mag");

        amqpTemplate.convertAndSend("TOPIC_EXCHANGE", "wanghao.druid.wangning", "--------topic message: wanghao.druid.wangnig");
        amqpTemplate.convertAndSend("TOPIC_EXCHANGE", "wanghao.druid.aniuniu", "--------topic message: wanghao.druid.aniuniu");

        amqpTemplate.convertAndSend("FANOUT_EXCHANGE", "", "-------fanout msg");
    }
}
