package com.z.product.services;

import com.z.product.model.ProductCategory;

import java.util.List;

public interface ProdCategoryService {
    List<ProductCategory> findByCategoryTypes(List<Integer> categoryTypeList);
}
