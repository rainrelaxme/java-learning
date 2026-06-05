package com.pocket.demo.service.impl;

import com.pocket.demo.common.enums.ResultCodeEnum;
import com.pocket.demo.common.exception.BusinessException;
import com.pocket.demo.dto.request.DepartmentCreateRequest;
import com.pocket.demo.dto.response.DepartmentResponse;
import com.pocket.demo.entity.DepartmentEntity;
import com.pocket.demo.entity.UserEntity;
import com.pocket.demo.mapper.DepartmentMapper;
import com.pocket.demo.mapper.UserMapper;
import com.pocket.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * 部门服务实现类
 * @author Shawn
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private static final String AUTO_CODE_PREFIX = "DEPT";

    private final DepartmentMapper departmentMapper;
    private final UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DepartmentResponse createDepartment(DepartmentCreateRequest request) {
        log.info("Create department：{}", request.getName());

        DepartmentEntity department = new DepartmentEntity();

        department.setName(request.getName());
        department.setCode(resolveDepartmentCode(request.getCode()));
        // 如果给了父级部门，则设置当前部门的级别
        if (request.getParentId() == null && !request.getParentId().isBlank()) {
           department.setLevel(1);
        }else {
            DepartmentEntity parentDepartment = departmentMapper.selectById(Long.parseLong(request.getParentId()));
            if (parentDepartment == null) {
                throw new BusinessException(ResultCodeEnum.PARENT_DEPT_CODE_NOT_FOUND);
            }
            department.setParentId(Long.parseLong(request.getParentId()));
            department.setLevel(parentDepartment.getLevel() + 1);
        }
        department.setStatus(Integer.parseInt(request.getStatus()));
        department.setCreateTime(LocalDateTime.now());
        department.setIsDeleted(0);

        int result = departmentMapper.insert(department);
        if (result == 0) {
            throw new BusinessException("创建部门失败");
        }

        log.info("Create department success, ID: {}", department.getId());
        return convertToResponse(department);
    }

    @Override
    public DepartmentResponse updateDepartment(DepartmentCreateRequest request) {
        return null;
    }

    /**
     * 解析部门编号：用户提供则校验唯一后使用，未提供则自动生成自增编号
     */
    private String resolveDepartmentCode(String requestedCode) {
        if (requestedCode != null && !requestedCode.isBlank()) {
            String code = requestedCode.trim();
            if (departmentMapper.selectByCode(code) != null) {
                throw new BusinessException(ResultCodeEnum.DEPT_CODE_ALREADY_EXISTS);
            }
            return code;
        }
        return generateNextDepartmentCode();
    }

    /**
     * 生成下一个自增部门编号，格式：DEPT0001、DEPT0002 ...
     */
    private String generateNextDepartmentCode() {
        Integer maxSequence = departmentMapper.selectMaxAutoCodeSequence();
        int nextSequence = (maxSequence == null ? 0 : maxSequence) + 1;

        String code;
        do {
            code = AUTO_CODE_PREFIX + String.format("%04d", nextSequence++);
        } while (departmentMapper.selectByCode(code) != null);

        return code;
    }

    /**
     * 实体转响应DTO
     */
    private DepartmentResponse convertToResponse(DepartmentEntity entity) {
        DepartmentResponse response = new DepartmentResponse();
        response.setId(entity.getId());
        response.setCode(entity.getCode());
        response.setName(entity.getName());
        response.setLevel(entity.getLevel());
        response.setParentId(entity.getParentId() != null ? entity.getParentId().intValue() : 0);

        if (entity.getLeaderId() != null) {
            UserEntity leader = userMapper.selectById(entity.getLeaderId());
            if (leader != null) {
                response.setLeader(resolveUserDisplayName(leader));
            }
        }

        return response;
    }

    /**
     * 优先返回昵称，无昵称则返回用户名
     */
    private String resolveUserDisplayName(UserEntity user) {
        if (user.getNickname() != null && !user.getNickname().isBlank()) {
            return user.getNickname();
        }
        return user.getUsername();
    }

}
