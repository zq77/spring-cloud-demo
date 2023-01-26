package com.z.product.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(MqReceiver.class);

    @RabbitListener(queuesToDeclare = @Queue("MyQueue"))
    public void receive(String message) {
        LOGGER.info(message);
    }
}
