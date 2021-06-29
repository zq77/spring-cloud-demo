package com.z.product.exception;

public class ProductException extends RuntimeException {
    private ErrorCode code;
    public ProductException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode;
    }

    public ErrorCode getCode() {
        return code;
    }
}
