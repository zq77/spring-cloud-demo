package com.z.product.controller;

import com.z.product.config.AppConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Value("${app.env}")
    private String env;

    @Resource
    private AppConfiguration appConfiguration;

    @GetMapping("/env")
    public String env() {
        return env;
    }

    @GetMapping("/env2")
    public String env2() {
        return appConfiguration.getEnv();
    }

    @GetMapping("/test")
    public String testConnect() {
        return "This is a connect test.";
    }
}
