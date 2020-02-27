package com.druid.rabbitmq.rabbbitspringbootdemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "THIRD_QUEUE")
public class ThirdConsumer {

    public void process(String msg){
        System.out.println("third message:"+msg);
    }
}
