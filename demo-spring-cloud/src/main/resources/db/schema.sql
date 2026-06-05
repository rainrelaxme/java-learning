-- 创建数据库
CREATE DATABASE IF NOT EXISTS demo_dev DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE demo_dev;

-- 用户表
CREATE TABLE IF NOT EXISTS `user` (
                                      `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                                      `username` VARCHAR(50) NOT NULL COMMENT '用户名',
    `email` VARCHAR(100) NOT NULL COMMENT '邮箱',
    `phone` VARCHAR(20) DEFAULT NULL COMMENT '手机号',
    `password` VARCHAR(255) NOT NULL COMMENT '密码（加密）',
    `status` TINYINT DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`),
    UNIQUE KEY `uk_email` (`email`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';