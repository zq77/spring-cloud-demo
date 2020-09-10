package com.z.product.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.z.product.model.Product;

import java.math.BigDecimal;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ProductView {
    private Long id;

    private String name;

    private BigDecimal price;

    private Integer stock;

    private String description;

    private String icon;

    private String status;

    private Integer categoryType;

    public static ProductView valueOf(Product product) {
        ProductView view = new ProductView();
        view.setId(product.getId());
        view.setName(product.getName());
        view.setPrice(product.getPrice());
        view.setStock(product.getStock());
        view.setDescription(product.getDescription());
        view.setIcon(product.getIcon());
        view.setStatus(product.getStatus().getDisplayName());
        view.setCategoryType(product.getCategoryType());
        return view;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }
}
