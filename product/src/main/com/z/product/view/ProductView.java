package com.z.product.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.z.product.model.Product;

import java.math.BigDecimal;

//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductView {
    @JsonProperty("id")
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
