package com.pocket.demo.common.enums;

import lombok.Getter;
import lombok.AllArgsConstructor;

/**
 * 响应状态码枚举
 * @author Shawn
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    // 成功
    SUCCESS(200, "操作成功"),

    // 客户端错误（4xx）
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未登录或Token已过期"),
    FORBIDDEN(403, "无权限访问"),
    NOT_FOUND(404, "请求资源不存在"),


    // 服务端错误（5xx）
    INTERNAL_ERROR(500, "服务器内部错误"),
    SERVICE_UNAVAILABLE(503, "服务暂不可用"),

    // 业务错误（自定义范围：1000-1999）
    // 用户错误（1000-1099）
    USER_NOT_FOUND(1001, "用户不存在"),
    USER_ALREADY_EXISTS(1002, "用户已存在"),
    PASSWORD_ERROR(1003, "密码错误"),
    INVALID_TOKEN(1004, "无效的Token"),

    // 部门错误（1100-1199）
    DEPT_CODE_ALREADY_EXISTS(1101, "部门编号已存在"),
    DEPT_CODE_NOT_FOUND(1102, "部门不存在"),
    PARENT_DEPT_CODE_NOT_FOUND(1103, "父级部门不存在"),

    // 数据库错误（2000-2999）
    DB_OPERATION_ERROR(2001, "数据库操作失败"),
    DUPLICATE_KEY_ERROR(2002, "数据重复，违反唯一约束");




    private final Integer code;
    private final String message;
}