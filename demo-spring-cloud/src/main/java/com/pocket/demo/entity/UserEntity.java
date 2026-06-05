package com.pocket.demo.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 用户实体
 * @author Shawn
 */
@Data
public class UserEntity {

    /**
     * 用户ID（主键）
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码（加密后存储）
     */
    private String password;

    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否已删除：0-未删除，1-已删除
     */
    private  Integer isDeleted;

}