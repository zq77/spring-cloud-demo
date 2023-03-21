package com.z.apigateway.exception;

public class RateLimitException extends RuntimeException {

    public RateLimitException() {
        super("Bucket is full...");
    }

}
