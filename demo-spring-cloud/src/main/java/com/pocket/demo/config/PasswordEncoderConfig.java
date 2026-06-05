package com.pocket.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 配置类：密码加密
 * @author shawn
 */

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 可选：传入 strength 参数控制加密强度，默认 10，范围 4-31
        // 值越大越安全但速度越慢
        return new BCryptPasswordEncoder(10);
    }
}
