package com.z.product.services.impl;

import com.z.product.enums.ProductStatus;
import com.z.product.model.Product;
import com.z.product.repository.ProductRepo;
import com.z.product.services.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductRepo productRepo;

    @Override
    public List<Product> findUpAll() {
        return productRepo.findByStatus(ProductStatus.UP);
    }

    @Override
    public List<Product> findList(List<Long> productIdList) {
        return productRepo.findByIdIn(productIdList);
    }
}
