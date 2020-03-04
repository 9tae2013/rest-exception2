package com.example.demo;

public class BusinessException extends Exception {
    private final int code;
    private final String detail;

    public BusinessException(int code, String detail) {
        super("Error code " + code + " detail " + detail);
        this.code = code;
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }
}
