package com.pocket.demo.controller;

import com.pocket.demo.dto.request.UserChangePwdRequest;
import com.pocket.demo.dto.request.UserDeleteRequest;
import com.pocket.demo.dto.request.UserEditRequest;
import com.pocket.demo.dto.response.UserDeleteResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.pocket.demo.common.result.Result;
import com.pocket.demo.dto.request.UserCreateRequest;
import com.pocket.demo.dto.response.UserResponse;
import com.pocket.demo.service.UserService;

/**
 * 用户控制器
 * @author Shawn
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/api/demo/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 创建用户
     * POST /api/demo/users
     */
    @PostMapping
    public Result<UserResponse> createUser(@Valid @RequestBody UserCreateRequest request) {
        log.info("接收到创建用户请求：{}", request.getUsername());
        UserResponse user = userService.createUser(request);
        return Result.success(user);
    }

    /**
     * 查询用户（根据ID）
     * GET /api/demo/users/{id}
     */
    @GetMapping("/{id}")
    public Result<UserResponse> getUserById(@PathVariable Long id) {
        log.info("接收到查询用户请求，ID：{}", id);
        UserResponse user = userService.getUserById(id);
        return Result.success(user);
    }

    /**
     * 查询所有用户
     * GET /api/demo/users
     */
    @GetMapping
    public Result<java.util.List<UserResponse>> getAllUsers() {
        log.info("接收到查询所有用户请求");
        java.util.List<UserResponse> users = userService.getAllUsers();
        return Result.success(users);
    }

    /**
     * 删除用户
     * DELETE /api/demo/users/{id}
     */
    @DeleteMapping("/{id}")
    public Result<Void> deleteUser(@PathVariable Long id) {
        log.info("接收到删除用户请求，ID：{}", id);
        userService.deleteUser(id);
        return Result.success();
    }

    /**
     * 删除用户：标记删除
     * POST /api/demo/users/delete
     */
    @PostMapping("/delete")
    public Result<UserDeleteResponse> deleteUserById(@Valid @RequestBody UserDeleteRequest request) {
        log.info("接收到删除用户请求：{}", request.getId());
        UserDeleteResponse user = userService.deleteUserById(request);
        return Result.success(user);
    }

    /**
     * 修改用户信息
     * POST /api/demo/users/edit
     */
    @PostMapping("/edit")
    public Result<UserResponse> editUser(@Valid @RequestBody UserEditRequest request) {
        log.info("接收到修改用户信息请求：{}", request.getId());
        // 校验：至少有一个字段需要修改
        if (request.getNewUsername() == null && request.getNewNickname() == null &&
                request.getNewEmail() == null && request.getNewPhone() == null &&
                request.getNewStatus() == null) {
            return Result.error("至少需要提供一个要修改的字段");
        }
        UserResponse user = userService.editUser(request);
        return Result.success(user);

    }

    /**
     * 修改用户密码
     * POST /api/demo/users/changePwd
     */
    @PostMapping("/changeUserPassword")
    public Result<Void> changUserPassword(@Valid @RequestBody UserChangePwdRequest request) {
        log.info("接收到修改用户密码请求：{}", request.getId());
        userService.changeUserPassword(request);
        return Result.success();
    }



}

