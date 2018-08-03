package com.shuriken.customer.core.error;

public enum BaseErrorCode implements ErrorCode {

    /**
     * 成功响应
     */
    SUCCESS(200, "SUCCESS"),
    SERVER_ERROR(500, "服务端错误"),
    UNDEFINED_ERROR(999, "未定义的错误");

    private int code;
    private String message;

    BaseErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return message;
    }
}
