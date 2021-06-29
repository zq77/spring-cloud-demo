package com.z.product.services.impl;

import com.z.product.model.ProductCategory;
import com.z.product.repository.ProductCategoryRepo;
import com.z.product.services.ProdCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProdCategoryServiceImpl implements ProdCategoryService {

    @Resource
    private ProductCategoryRepo productCategoryRepo;

    @Override
    public List<ProductCategory> findByCategoryTypes(List<Integer> categoryTypeList) {
        return productCategoryRepo.findByTypeIn(categoryTypeList);
    }
}
