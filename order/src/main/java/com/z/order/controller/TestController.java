package com.z.order.controller;

import com.google.common.collect.Lists;
import com.z.order.api.ProductApi;
import com.z.order.api.view.ProductView;
import com.z.order.util.ResponseUtil;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("/get_proudcts")
    public List<ProductView> getProductsFormProductServer() {
        List<ProductView> product = productApi.getProductByIds(Lists.newArrayList(1L, 2L));
        return product;
    }


    @GetMapping("/buy")
    public ResponseEntity buy() {
        // success
//        productApi.buy(Lists.newArrayList(new ProductView(1L, 2), new ProductView(3L, 1)));

        // fail
//        productApi.buy(Lists.newArrayList(new ProductView(1L, 2), new ProductView(223L, 1)));
        productApi.buy(Lists.newArrayList(new ProductView(1L, 1000), new ProductView(2L, 1)));
        return ResponseUtil.success();
    }
}
