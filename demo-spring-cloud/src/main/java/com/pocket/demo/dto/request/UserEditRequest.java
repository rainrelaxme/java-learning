package com.pocket.demo.dto.request;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 修改用户信息请求DTO
 * @author shawn
 */
@Data
public class UserEditRequest {

    @NotBlank(message = "ID不能为空")
    private String id;

    @Size(min = 3, max = 20, message = "长度为3-20个字符")
    private String newUsername;

    @Size(min = 3, max = 20, message = "长度为3-20个字符")
    private String newNickname;

    @Size(min = 3, max = 20, message = "长度为3-20个字符")
    private String newEmail;

    @Size(min = 3, max = 20, message = "长度为3-20个字符")
    private String newPhone;

    @Size(min = 3, max = 20, message = "长度为3-20个字符")
    private String newStatus;

}
