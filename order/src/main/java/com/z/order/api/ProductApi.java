package com.z.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("product")
public interface ProductApi {

    @GetMapping("/test")
    public String getProductMsg();
}
