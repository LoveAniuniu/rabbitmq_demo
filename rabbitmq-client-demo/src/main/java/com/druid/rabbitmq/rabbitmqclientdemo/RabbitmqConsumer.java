package com.druid.rabbitmq.rabbitmqclientdemo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqConsumer {

    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    private final static String QUEUE_NAME = "SIMPLE_QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"direct", false,false,null);
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        System.out.println("beginning waiting.......");
        // 绑定队列和交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "druid");
        // 创建消费者
        Consumer consumer = new Consumer() {


            @Override
            public void handleConsumeOk(String s) {

            }

            @Override
            public void handleCancelOk(String s) {

            }

            @Override
            public void handleCancel(String s) throws IOException {

            }

            @Override
            public void handleShutdownSignal(String s, ShutdownSignalException e) {

            }

            @Override
            public void handleRecoverOk(String s) {

            }

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {

                String msg = new String(bytes, "UTF-8");
                System.out.println("Received message : '" + msg + "'");
                System.out.println("consumerTag : " + consumerTag );
                System.out.println("deliveryTag : " + envelope.getDeliveryTag() );
            }
        };
        // 开始获取消息
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
