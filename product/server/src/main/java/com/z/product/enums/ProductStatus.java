package com.z.product.enums;

public enum ProductStatus {
    UP,   //正常
    DOWN; //下架
    public String getDisplayName() {
        return this == UP ? "正常" : "下架";
    }
}
