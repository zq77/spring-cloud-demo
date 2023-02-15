package com.z.order.message;

import com.z.product.common.ProductView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.Consumer;

@Component
public class MQConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(MQConsumer.class);

    private static final String key = "product_stock_%d";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    Consumer<List<ProductView>> decreaseProductStock() {
        return items -> {
            items.forEach(item -> {
                LOG.info("myStreamInput: " + item.toString());
                LOG.info("myStreamInput: " + item.getId());
                LOG.info("myStreamInput: " + item.getStock());

                stringRedisTemplate.opsForValue().set(String.format(key, item.getId()), String.valueOf(item.getStock()));
            });
        };
    }
}
