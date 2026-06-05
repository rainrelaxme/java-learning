// service/UserService.java
package com.pocket.demo.service;

import com.pocket.demo.dto.request.UserChangePwdRequest;
import com.pocket.demo.dto.request.UserCreateRequest;
import com.pocket.demo.dto.request.UserDeleteRequest;
import com.pocket.demo.dto.request.UserEditRequest;
import com.pocket.demo.dto.response.UserDeleteResponse;
import com.pocket.demo.dto.response.UserResponse;
import java.util.List;

/**
 * 用户服务接口
 * @author Shawn
 */
public interface UserService {

    /**
     * 创建用户
     */
    UserResponse createUser(UserCreateRequest request);

    /**
     * 查询用户（根据ID）
     */
    UserResponse getUserById(Long id);

    /**
     * 查询所有用户
     */
    List<UserResponse> getAllUsers();

    /**
     * 删除用户
     */
    void deleteUser(Long id);

    /**
     * 删除用户2
     */
    UserDeleteResponse deleteUserById(UserDeleteRequest request);

    /**
     * 修改用户信息
     */
    UserResponse editUser(UserEditRequest request);

    /**
     * 修改用户密码
     */
    void changeUserPassword(UserChangePwdRequest request);


}

