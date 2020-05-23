package com.z.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${app.env}")
    private String env;

    @GetMapping("/test")
    public String test() {
        return env + " Hello World2222";
    }
}
