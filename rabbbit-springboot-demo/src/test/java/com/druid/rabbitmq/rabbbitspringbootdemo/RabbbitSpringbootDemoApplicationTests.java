package com.druid.rabbitmq.rabbbitspringbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class RabbbitSpringbootDemoApplicationTests {

	@Autowired
	DruidProducer provider;

	@Test
	public void contextLoads() {
		provider.send();
	}
}
