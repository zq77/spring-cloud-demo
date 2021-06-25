package com.z.product.controller.api;

import com.z.product.services.ProductService;
import com.z.product.view.ProductView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController("ApiProductController")
@RequestMapping("/api/products")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("")
    public List<ProductView> list() {
        return productService.findUpAll().stream().map(ProductView::valueOf).collect(Collectors.toList());
    }

    @PostMapping("/byIds")
    public List<ProductView> listByIds(@RequestBody List<Long> ids) {
        return productService.findList(ids).stream().map(ProductView::valueOf).collect(Collectors.toList());
    }

    @PostMapping("/buy")
    public void buy(@RequestBody List<ProductView> prods) {
        productService.decreaseStock(prods);
    }
}
