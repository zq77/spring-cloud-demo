package com.z.order.api;

import com.z.order.api.view.ProductView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("product")
public interface ProductApi {

    @GetMapping("/test")
    public String getProductMsg();

    @PostMapping("/api/products/byIds")
    public List<ProductView> getProductByIds(List<Long> ids);

    @PostMapping("/api/products/buy")
    public void buy(List<ProductView> prods);
}
