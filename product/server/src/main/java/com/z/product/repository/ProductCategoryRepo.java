package com.z.product.repository;

import com.z.product.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {
    List<ProductCategory> findByTypeIn(List<Integer> categoryTypeList);
}
