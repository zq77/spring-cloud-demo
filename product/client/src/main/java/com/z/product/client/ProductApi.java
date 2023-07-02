package com.z.product.client;

import com.z.product.common.ProductView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "product", fallback = ProductApi.ProductApiFallback.class)
public interface ProductApi {

    @GetMapping("/test")
    public String getProductMsg();

    @PostMapping("/api/products/byIds")
    public List<ProductView> getProductByIds(List<Long> ids);

    @PostMapping("/api/products/buy")
    public void buy(List<ProductView> prods);

    @Component
    static class ProductApiFallback implements ProductApi {
        @Override
        public String getProductMsg() {
            return "This is a request fallback test.";
        }

        @Override
        public List<ProductView> getProductByIds(List<Long> ids) {
            return null;
        }

        @Override
        public void buy(List<ProductView> prods) {

        }
    }
}