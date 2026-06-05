package com.pocket.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 修改用户密码请求DTO
 * @author shawn
 */
@Data
public class UserChangePwdRequest {

    @NotBlank(message = "ID不能为空")
    private String id;

    @NotBlank(message = "旧密码不能为空")
    private String oldPassword;

    @NotBlank(message = "新密码不能为空")
    @Size(min = 8, max = 20, message = "新密码长度为8-20字符")
    private String newPassword;

}
