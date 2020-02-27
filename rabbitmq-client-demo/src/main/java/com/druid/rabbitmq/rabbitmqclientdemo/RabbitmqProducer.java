package com.druid.rabbitmq.rabbitmqclientdemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqProducer {

    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        String message = " my first rabbitmq message";
        channel.basicPublish(EXCHANGE_NAME, "druid", null, message.getBytes());

        channel.close();
        connection.close();
    }
}
