package com.z.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${app.env}")
    private String env;

    @GetMapping("/env")
    public String env() {
        return env;
    }

    @GetMapping("/test")
    public String testConnect() {
        return "This is a connect test.";
    }
}
