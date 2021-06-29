package com.z.order.util;

public class ErrorData {
    private String message;
    private String field;
    private String tip;

    public ErrorData(String message) {
        this.message = message;
    }
    public ErrorData(String field, String tip) {
        this.field = field;
        this.tip = tip;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
