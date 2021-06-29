package com.z.product.repository;


import com.google.common.collect.Lists;
import com.z.product.ProductApplicationTests;
import com.z.product.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@Component
public class ProductRepoTest extends ProductApplicationTests {

    @Resource
    private ProductRepo productRepo;

    @Test
    public void findfindByIdIn() {
        List<Product> products = productRepo.findByIdIn(Lists.newArrayList(1L));
        assertEquals("", 1, products.size());
    }
}