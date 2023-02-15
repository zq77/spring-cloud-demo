package com.z.product.services.impl;

import com.z.product.enums.ProductStatus;
import com.z.product.exception.ErrorCode;
import com.z.product.exception.ProductException;
import com.z.product.model.Product;
import com.z.product.repository.ProductRepo;
import com.z.product.services.ProductService;
import com.z.product.view.ProductView;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductRepo productRepo;
    @Resource
    private StreamBridge streamBridge;

    @Override
    public List<Product> findUpAll() {
        return productRepo.findByStatus(ProductStatus.UP);
    }

    @Override
    public List<Product> findList(List<Long> productIdList) {
        return productRepo.findByIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<ProductView> productViews) {
        List<ProductView> newResult = new ArrayList<>();
        productViews.forEach(prod -> {
            Optional<Product> productOptional = productRepo.findById(prod.getId());
            if (!productOptional.isPresent()) {
                throw new ProductException(ErrorCode.NOTFOUND);
            }
            int result = productOptional.get().getStock() - prod.getStock();
            if (result < 0) {
                throw new ProductException(ErrorCode.STOCK_NOT_ENOUGH);
            }
            productOptional.get().setStock(result);
            productRepo.save(productOptional.get());
            newResult.add(ProductView.valueOf(productOptional.get()));
        });
        // send MQ message
        streamBridge.send("product-out-0", newResult);
    }
}
