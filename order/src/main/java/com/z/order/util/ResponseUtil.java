package com.z.order.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseUtil {


    public static ResponseEntity success(Object obj) {
        return ResponseEntity.ok().body(JsonUtil.toJson(obj));
    }
    public static ResponseEntity success() {
        return ResponseEntity.ok().build();
    }

    public static ResponseEntity creationSuccess(Object obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(JsonUtil.toJson(obj));
    }

    public static ResponseEntity badRequestError(String message) {
        return ResponseEntity.badRequest().body(message);
    }

    public static ResponseEntity notFoundError() {
        return ResponseEntity.notFound().build();
    }

    public static ResponseEntity notFoundError(Object obj) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(JsonUtil.toJson(obj));
    }

    public static ResponseEntity internalServerError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    public static ResponseEntity internalServerError(Object obj) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(JsonUtil.toJson(obj));
    }

    public static ResponseEntity forbiddenError(Object obj) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(JsonUtil.toJson(obj));
    }

    public static ResponseEntity forbiddenError() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    public static ResponseEntity validationError(Object obj) {
        return ResponseEntity.badRequest().body(JsonUtil.toJson(obj));
    }

    public static ResponseEntity validationError(List<FieldError> list) {
        return validationError(list.stream().map(a -> new ErrorData(a.getField(), a.getDefaultMessage()))
                .collect(Collectors.toList()));
    }

    public static ResponseEntity validationError() {
        return ResponseEntity.badRequest().build();
    }
}
