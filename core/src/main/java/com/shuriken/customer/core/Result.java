package com.shuriken.customer.core;

import java.util.List;
import lombok.Value;
import com.shuriken.customer.core.error.ErrorCode;

import static com.shuriken.customer.core.error.BaseErrorCode.SUCCESS;
import static com.shuriken.customer.core.error.BaseErrorCode.UNDEFINED_ERROR;

public class Result<T> {

    protected int code;
    protected String message;
    protected T data;

    protected Result() {
    }

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    /**
     * 构建一个无数据的成功结果
     *
     * @return
     */
    public static Result createSuccessResult() {
        return createErrorResult(SUCCESS);
    }

    /**
     * 构建一个有数据的成功结果
     *
     * @param data
     * @return
     */
    public static Result createSuccessResult(Object data) {
        return new Result(SUCCESS.getCode(), SUCCESS.getMsg(), data);
    }

    /**
     * 构建一个默认的的错误
     *
     * @param msg
     * @return
     */
    public static Result createErrorResult(String msg) {
        return new Result(UNDEFINED_ERROR.getCode(), msg, null);
    }

    /**
     * 构建一个包含data的错误结果
     *
     * @param message
     * @param data
     * @return
     */
    public static Result createErrorResult(String message, Object data) {
        return new Result(UNDEFINED_ERROR.getCode(), message, data);
    }

    /**
     * 构建一个有错误码的错误结果
     *
     * @param errorCode
     * @return
     */
    public static Result createErrorResult(ErrorCode errorCode) {
        return new Result(errorCode.getCode(), errorCode.getMsg(), null);
    }

    /**
     * 构建一个有自定义错误信息的错误结果
     *
     * @param errorCode
     * @param message
     * @return
     */
    public static Result createErrorResult(ErrorCode errorCode, String message) {
        return new Result(errorCode.getCode(), message, null);
    }

    /**
     * 分页结果对象
     *
     * @param <T>
     */
    @Value(staticConstructor = "of")
    public static class Page<T> {
        private int current;
        private long total;
        private List<T> list;
    }
}
