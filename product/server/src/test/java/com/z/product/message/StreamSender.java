package com.z.product.message;

import com.z.product.ProductApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StreamSender extends ProductApplicationTests {
    @Resource
    private StreamBridge streamBridge;
    @Test
    public void testSend() {
        System.out.println("test send");
        streamBridge.send("myStream-out-0", "test stream send");
    }
}
