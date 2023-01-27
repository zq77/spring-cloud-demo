package com.z.product.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(MqReceiver.class);

//    @RabbitListener(queues = "MyQueue")
//    @RabbitListener(queuesToDeclare = @Queue("MyQueue"))
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("MyQueue"),
            exchange = @Exchange("MyExchange")
    ))
    public void receive(String message) {
        LOGGER.info(message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("MyQueueA"),
            key = "A",
            exchange = @Exchange("MyExchange")
    ))
    public void receiveA(String message) {
        LOGGER.info(message);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("MyQueueB"),
            key = "B",
            exchange = @Exchange("MyExchange")
    ))
    public void receiveB(String message) {
        LOGGER.info(message);
    }
}
