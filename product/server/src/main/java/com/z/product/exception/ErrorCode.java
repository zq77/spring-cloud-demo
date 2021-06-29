package com.z.product.exception;

public enum ErrorCode {
    NOTFOUND(1, "Product not found"),
    STOCK_NOT_ENOUGH(2, "Stock not enough");

    private Integer id;
    private String message;

    ErrorCode(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
