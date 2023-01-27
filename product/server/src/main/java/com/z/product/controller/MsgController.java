package com.z.product.controller;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MsgController {
    @Resource
    private StreamBridge streamBridge;

    @GetMapping("/msg/send")
    public void sendMsg() {
        streamBridge.send("myStream-out-0", "test stream send");
    }
}
