// service/impl/UserServiceImpl.java
package com.pocket.demo.service.impl;

import com.pocket.demo.dto.request.UserChangePwdRequest;
import com.pocket.demo.dto.request.UserCreateRequest;
import com.pocket.demo.dto.request.UserDeleteRequest;
import com.pocket.demo.dto.request.UserEditRequest;
import com.pocket.demo.dto.response.UserResponse;
import com.pocket.demo.dto.response.UserDeleteResponse;
import com.pocket.demo.service.UserService;
import com.pocket.demo.common.exception.BusinessException;
import com.pocket.demo.common.enums.ResultCodeEnum;
import com.pocket.demo.entity.UserEntity;
import com.pocket.demo.mapper.UserMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户服务实现类
 * @author Shawn
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserResponse createUser(UserCreateRequest request) {
        log.info("创建用户：{}", request.getUsername());

        // 检查用户名是否已存在
        UserEntity existUser = userMapper.selectByUsername(request.getUsername());
        if (existUser != null) {
            throw new BusinessException(ResultCodeEnum.USER_ALREADY_EXISTS);
        }

        // 创建用户实体
        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setNickname(request.getNickname());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        // 密码加密
        user.setPassword(encryptPassword(request.getPassword()));
        // 默认启用
        user.setStatus(1);
        user.setCreateTime(LocalDateTime.now());
        user.setIsDeleted(1);

        // 保存到数据库
        userMapper.insert(user);
        log.info("用户创建成功，ID：{}", user.getId());

        return convertToResponse(user);
    }

    @Override
    public UserResponse getUserById(Long id) {
        log.info("查询用户，ID：{}", id);

        UserEntity user = userMapper.selectById(id);
        if (user == null) {
            throw new BusinessException(ResultCodeEnum.USER_NOT_FOUND);
        }

        return convertToResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        log.info("查询所有用户");

        List<UserEntity> users = userMapper.selectAll();
        return users.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(Long id) {
        log.info("删除用户，ID：{}", id);

        UserEntity user = userMapper.selectById(id);
        if (user == null) {
            throw new BusinessException(ResultCodeEnum.USER_NOT_FOUND);
        }

        int result = userMapper.deleteById(id);
        if (result == 0) {
            throw new BusinessException("删除用户失败");
        }

        log.info("用户删除成功，ID：{}", id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDeleteResponse deleteUserById(UserDeleteRequest request) {
        log.info("删除用户, ID:{}", request.getId());
        Long id = Long.parseLong(request.getId());

        UserEntity user = userMapper.selectById(id);
        if (user == null) {
            throw new BusinessException(ResultCodeEnum.USER_NOT_FOUND);
        }
        String username = user.getUsername();

        int result = userMapper.deleteById2(id);
        if (result == 0) {
            throw new BusinessException("删除用户失败");
        }

        log.info("用户删除成功，ID：{}，username：{}", id, username);
        return convertToDelResponse(user);
    };

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserResponse editUser(UserEditRequest request) {
        log.info("修改用户信息，ID:{}", request.getId());
        Long id = Long.parseLong(request.getId());

        UserEntity user = userMapper.selectById(id);
        if (user == null) {
            throw new BusinessException(ResultCodeEnum.USER_NOT_FOUND);
        }

        if (request.getNewUsername() != null && !request.getNewUsername().isBlank()) {
            user.setUsername(request.getNewUsername());
        }
        if (request.getNewNickname() != null && !request.getNewNickname().isBlank()) {
            user.setNickname(request.getNewNickname());
        }
        if (request.getNewEmail() != null && !request.getNewEmail().isBlank()) {
            user.setEmail(request.getNewEmail());
        }
        if (request.getNewPhone() != null && !request.getNewPhone().isBlank()) {
            user.setPhone(request.getNewPhone());
        }
        if (request.getNewStatus() != null && !request.getNewStatus().isBlank()) {
            user.setStatus(Integer.parseInt(request.getNewStatus()));
        }
        user.setUpdateTime(LocalDateTime.now());

        int result = userMapper.update(user);
        if (result == 0) {
            throw new BusinessException("更新用户信息失败");
        }

        log.info("用户更新成功，ID：{}", id);
        return convertToResponse(user);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changeUserPassword(UserChangePwdRequest request) {
        log.info("修改用户密码，ID:{}", request.getId());
        Long id = Long.parseLong(request.getId());

        if (request.getOldPassword().equals(request.getNewPassword())) {
            throw new BusinessException("新密码不能与旧密码相同");
        }

        UserEntity user = userMapper.selectById(id);
        if (user == null) {
            throw new BusinessException(ResultCodeEnum.USER_NOT_FOUND);
        }

        // 校验旧密码是否正确
        if(!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new BusinessException("旧密码错误");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        user.setUpdateTime(LocalDateTime.now());

        int result = userMapper.updateUserPassword(user);
        if (result == 0) {
            throw new BusinessException("更新用户密码失败");
        }

        log.info("用户密码更新成功, ID: {}", id);
        return;
    }


    /**
     * 实体转响应DTO
     */
    private UserResponse convertToResponse(UserEntity entity) {
        UserResponse response = new UserResponse();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        response.setNickname(entity.getNickname());
        response.setEmail(entity.getEmail());
        response.setPhone(entity.getPhone());
        response.setStatus(entity.getStatus());
        response.setCreateTime(entity.getCreateTime());
        response.setUpdateTime(entity.getUpdateTime());
        return response;
    }

    /**
     * 实体转响应DTO
     */
    private UserDeleteResponse convertToDelResponse(UserEntity entity) {
        UserDeleteResponse response = new UserDeleteResponse();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        return response;
    }

    /**
     * 使用 BCrypt 对明文密码加密后入库
     */
    private String encryptPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}