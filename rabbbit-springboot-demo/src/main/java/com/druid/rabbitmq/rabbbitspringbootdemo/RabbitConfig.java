package com.druid.rabbitmq.rabbbitspringbootdemo;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitConfig {

    @Bean("topicExchange")
    public TopicExchange topicExchange(){
        return new TopicExchange("TOPIC_EXCHANGE");
    }

    @Bean("fanoutExchange")
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("FANOUT_EXCHANGE");
    }

    @Bean("firstQueue")
    public Queue getFirstQueue(){
        Map<String, Object> args = new HashMap<>();

        args.put("x-message-ttl", 6000);
        Queue queue = new Queue("FIRST_QUEUE", false,false,true, args);

        return queue;
    }

    @Bean("secondQueue")
    public Queue getSecondQueue(){

        return new Queue("SECOND_QUEUE");
    }

    @Bean("thirdQueue")
    public Queue getThirdQueue(){
        return new Queue("THIRD_QUEUE");
    }

    @Bean
    public Binding bindSecond(@Qualifier("secondQueue") Queue queue, @Qualifier("topicExchange") TopicExchange topicExchange){

        return BindingBuilder.bind(queue).to(topicExchange).with("#.druid.#");
    }

    public Binding bindThird(@Qualifier("thirdQueue") Queue queue, @Qualifier("thirdExchage") FanoutExchange fanoutExchange){

        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}
