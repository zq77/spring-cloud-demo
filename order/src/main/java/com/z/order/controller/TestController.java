package com.z.order.controller;

import com.z.order.api.ProductApi;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {
//    @Resource
//    private LoadBalancerClient loadBalancerClient;

//    @Resource
//    private RestTemplate restTemplate;

    @Resource
    private ProductApi productApi;

    @GetMapping("/get_proudct_msg")
    public String getMsgFormProductServer() {
        // one way
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8000/test", String.class);

        // two way
//        ServiceInstance service = loadBalancerClient.choose("PRODUCT");
//        String response = restTemplate.getForObject(
//                String.format("http://%s:%s/%s", service.getHost(), service.getPort(), "test"), String.class);

        //three way
//        String response = restTemplate.getForObject("http://PRODUCT/test", String.class);

        // four way feign
        String response = productApi.getProductMsg();
        return response;
    }
}
