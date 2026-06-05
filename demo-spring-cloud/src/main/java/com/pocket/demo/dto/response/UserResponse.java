// dto/response/UserResponse.java
package com.pocket.demo.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 用户响应DTO
 * @author Shawn
 */
@Data
public class UserResponse {

    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}