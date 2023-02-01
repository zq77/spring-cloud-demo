package com.z.product.message;

import com.z.product.model.Product;
import com.z.product.view.ProductView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class StreamReceiver {

    private Logger LOG = LoggerFactory.getLogger(StreamReceiver.class);

//    @Bean
//    Consumer<String> myStreamInput() {
//        return str -> {
//            LOG.info("myStreamInput: " + str);
//        };
//    }

    @Bean
    Consumer<ProductView> myStreamInput() {
        return view -> {
            LOG.info("myStreamInput: " + view.toString());
            LOG.info("myStreamInput: " + view.getId());
        };
    }
}
