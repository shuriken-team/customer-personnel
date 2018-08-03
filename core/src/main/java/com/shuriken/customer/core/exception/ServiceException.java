package com.shuriken.customer.core.exception;


import com.shuriken.customer.core.error.BaseErrorCode;
import com.shuriken.customer.core.error.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * 服务（业务）异常如“ 账号或密码错误 ”，该异常只做INFO级别的日志记录 @see WebMvcConfigurer
 */
@NoArgsConstructor
public class ServiceException extends RuntimeException implements ErrorCode {

    @Getter
    private int code;
    @Getter
    private String msg;

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(ErrorCode errorCode, String message) {
        super(message);
        if (StringUtils.isBlank(message)) {
            message = errorCode.getMsg();
        }
        this.code = errorCode.getCode();
        this.msg = message;
    }

    public ServiceException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public ServiceException(String message) {
        super(message);
        this.code = BaseErrorCode.UNDEFINED_ERROR.getCode();
        this.msg = message;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return "code=" + code + ",msg=" + msg;
    }

    @Override
    public String getLocalizedMessage() {
        return getMessage();
    }
}
