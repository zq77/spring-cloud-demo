package com.z.order.exception;

public class OrderException extends RuntimeException {

    public static final String NOT_FOUND = "Order not found.";
    public static final String ORDER_STATUS_ERROR = "Order status error.";
    public static final String ORDER_DETAIL_EMPTY = "Order detail is empty.";

    public OrderException(String message) {
        super(message);
    }
}
