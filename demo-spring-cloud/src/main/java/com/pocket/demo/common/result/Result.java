package com.pocket.demo.common.result;

import com.pocket.demo.common.enums.ResultCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 统一API响应结构
 * @author Shawn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    /**
     * 状态码（200表示成功）
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 时间戳
     */
    private long timestamp;

    /**
     * 成功响应（无数据）
     */
    public static <T> Result<T> success() {

        return success(null);
    }

    /**
     * 成功响应（有数据）
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(
                ResultCodeEnum.SUCCESS.getCode(),
                ResultCodeEnum.SUCCESS.getMessage(),
                data,
                System.currentTimeMillis()
        );
    }

    /**
     * 失败响应（自定义消息）
     */
    public static <T> Result<T> error(String message) {
        return new Result<>(
                ResultCodeEnum.INTERNAL_ERROR.getCode(),
                message,
                null,
                System.currentTimeMillis()
        );
    }

    /**
     * 失败响应（使用枚举）
     */
    public static <T> Result<T> error(ResultCodeEnum codeEnum) {
        return new Result<>(
                codeEnum.getCode(),
                codeEnum.getMessage(),
                null,
                System.currentTimeMillis()
        );
    }

    /**
     * 失败响应（自定义状态码和消息）
     */
    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(
                code,
                message,
                null,
                System.currentTimeMillis()
        );
    }

}
