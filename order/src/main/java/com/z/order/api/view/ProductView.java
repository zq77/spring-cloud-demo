package com.z.order.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ProductView {
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("stock")
    private Integer stock;

    @JsonProperty("description")
    private String description;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("status")
    private String status;

    @JsonProperty("category_type")
    private Integer categoryType;

    public ProductView() {
    }

    public ProductView(Long id, Integer stock) {
        this.id = id;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }
}
