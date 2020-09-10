package com.z.product.repository;

import com.z.product.enums.ProductStatus;
import com.z.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByStatus(ProductStatus status);

    List<Product> findByIdIn(List<Long> ids);
}
