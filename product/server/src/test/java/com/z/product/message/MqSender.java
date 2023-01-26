package com.z.product.message;

import com.z.product.ProductApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MqSender extends ProductApplicationTests {
    @Resource
    private AmqpTemplate amqpTemplate;

    @Test
    public void testSend() {
        amqpTemplate.convertAndSend("MyQueue", "test MQ2");
    }
}
