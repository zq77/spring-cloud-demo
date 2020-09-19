package com.z.product.controller;

import com.z.product.services.ProductService;
import com.z.product.view.ProductView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductView>> list() {
        List<ProductView> list = productService.findUpAll().stream().map(ProductView::valueOf).collect(Collectors.toList());
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/404")
    public ResponseEntity<String> ret404() {
        return ResponseEntity.notFound().build();
    }
}
