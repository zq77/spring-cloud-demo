package com.z.product.common;

import java.math.BigDecimal;

public class ProductView {
    private Long id;

    private String name;

    private BigDecimal price;

    private Integer stock;

    private String description;

    private String icon;

    private String status;

    private Integer categoryType;

    public ProductView() {
    }

    public ProductView(Long id, Integer stock) {
        this.id = id;
        this.stock = stock;
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCategoryType() {
        return categoryType;
    }
}
