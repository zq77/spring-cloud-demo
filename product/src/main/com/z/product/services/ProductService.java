package com.z.product.services;

import com.z.product.model.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有在架商品列表
     */
    List<Product> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<Product> findList(List<Long> productIdList);

}
