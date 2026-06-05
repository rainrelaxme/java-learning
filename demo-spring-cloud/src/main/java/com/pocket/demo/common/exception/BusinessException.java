package com.pocket.demo.common.exception;

import lombok.Getter;
import com.pocket.demo.common.enums.ResultCodeEnum;

/**
 * 业务异常（自定义异常）
 * @author Shawn
 */
@Getter
public class BusinessException extends RuntimeException {

    private final Integer code;
    private final String message;

    /**
     * 使用枚举构造
     */
    public BusinessException(ResultCodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    /**
     * 自定义错误码和消息
     */
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 自定义消息（使用默认错误码500）
     */
    public BusinessException(String message) {
        super(message);
        this.code = ResultCodeEnum.INTERNAL_ERROR.getCode();
        this.message = message;
    }
}