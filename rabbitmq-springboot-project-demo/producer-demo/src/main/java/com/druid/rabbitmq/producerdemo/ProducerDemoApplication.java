package com.druid.rabbitmq.producerdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.druid.rabbitmq.producerdemo.mapper")
public class ProducerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerDemoApplication.class, args);
    }

}
