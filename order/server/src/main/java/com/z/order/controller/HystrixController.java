package com.z.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.z.product.common.ProductView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="fallback")
    @GetMapping("/hystrix/products")
    public ResponseEntity<String> getProdList() {
        String prods = restTemplate.getForObject("http://PRODUCT/api/products", String.class);
        return ResponseEntity.ok(prods);
    }

    @HystrixCommand(fallbackMethod="fallback")
    @GetMapping("/hystrix/test")
    public ResponseEntity<String> test() {
        throw new RuntimeException("test hystrix error");
    }

    @HystrixCommand
    @GetMapping("/hystrix/test/default")
    public ResponseEntity<String> testDefaultFallback() {
        throw new RuntimeException("test hystrix error");
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @GetMapping("/hystrix/test/timeout")
    public ResponseEntity<String> testTimeout() throws InterruptedException {
        Thread.sleep(2000l);
        return ResponseEntity.ok("test timeout success");
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    @GetMapping("/hystrix/test/circuitBreaker")
    public ResponseEntity<String> testCircuitBreaker(@RequestParam Integer num) {
        if (num % 2 == 0) {
            throw new RuntimeException("test circuitBreaker fail");
        }
        return ResponseEntity.ok("test circuitBreaker success");
    }

    private ResponseEntity<String> fallback() {
        return ResponseEntity.ok("Fallback: Please waiting....");
    }

    private ResponseEntity<String> defaultFallback() {
        return ResponseEntity.ok("Default fallback: Please waiting....");
    }
}
