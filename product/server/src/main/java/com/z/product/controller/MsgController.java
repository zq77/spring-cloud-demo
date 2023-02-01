package com.z.product.controller;

import com.z.product.view.ProductView;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MsgController {
    @Resource
    private StreamBridge streamBridge;

    @GetMapping("/msg/send")
    public void sendMsg() {
//        streamBridge.send("myStream-out-0", "test stream send");
        ProductView view = new ProductView();
        view.setId(12131L);
        streamBridge.send("myStreamOutput-out-0", MessageBuilder.withPayload(view).build());

    }
}
