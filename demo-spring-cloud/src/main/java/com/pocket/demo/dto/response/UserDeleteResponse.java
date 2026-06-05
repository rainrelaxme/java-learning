package com.pocket.demo.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 删除用户的响应DTO
 * @author shawn
 */
@Data
public class UserDeleteResponse {

    private Long id;
    private String username;
}
