package com.z.product.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class StreamReceiver {

    private Logger LOG = LoggerFactory.getLogger(StreamReceiver.class);

    @Bean
    Consumer<String> myStreamInput() {
        return str -> {
            LOG.info("myStreamInput: " + str);
        };
    }
}
