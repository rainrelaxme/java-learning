package com.pocket.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 删除用户
 * @author shawn
 */
@Data
public class UserDeleteRequest {

    @NotBlank(message = "ID不能为空")
    private String id;
}
