package com.pocket.demo.service;

import com.pocket.demo.dto.request.*;
import com.pocket.demo.dto.response.DepartmentResponse;

import java.util.List;

/**
 * 部门服务接口
 * @author shawn 
 */
public interface DepartmentService {

    /**
     * 创建部门
     */
    DepartmentResponse createDepartment(DepartmentCreateRequest request);

    DepartmentResponse updateDepartment(DepartmentCreateRequest request);

    /**
     * 查询部门（根据ID）
     */
//    UserResponse getUserById(Long id);

    /**
     * 查询所有部门
     */
//    List<UserResponse> getAllUsers();

    /**
     * 删除部门2
     */
//    UserDeleteResponse deleteUserById(UserDeleteRequest request);

    /**
     * 修改部门信息
     */
//    UserResponse editUser(UserEditRequest request);

}
