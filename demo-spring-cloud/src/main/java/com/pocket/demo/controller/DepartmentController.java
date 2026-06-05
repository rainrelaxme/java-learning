package com.pocket.demo.controller;

import com.pocket.demo.common.result.Result;
import com.pocket.demo.dto.request.DepartmentCreateRequest;
import com.pocket.demo.dto.response.DepartmentResponse;
import com.pocket.demo.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 部门控制器
 * @author shawn
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/api/demo/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    /**
     * create department
     * POST /api/demo/departments/create
     */
    @PostMapping("/create")
    public Result<DepartmentResponse> create(@Valid @RequestBody DepartmentCreateRequest request) {
        log.info("接收到创建部门请求：{}", request.getName());
        DepartmentResponse department = departmentService.createDepartment(request);

        return Result.success(department);
    }

    /**
     * show department tree
     * GET /api/demo/departments/tree
     */
    @GetMapping("/tree")
    public Result<Void> tree() {
        return null;
    }

    /**
     * show department info
     * GET /api/demo/departments/{id}
     */
    @GetMapping("/{id}")
    public Result<Void> info(@PathVariable Long id) {
        return null;
    }

    /**
     * edit department info
     * POST /api/demo/departments/edit
     */
    @PostMapping("/edit")
    public Result<Void> edit() {
        return null;
    }

    /**
     * move department structure
     * POST /api/demo/departments/move
     */
    @PostMapping("/move")
    public Result<Void> move() {
        return null;
    }

    /**
     * delete department
     * POST /api/demo/departments/delete
     */
    @PostMapping("/delete")
    public Result<Void> delete() {
        return null;
    }

    /**
     * set department leader
     * POST /api/demo/departments/setLeader
     */
    @PostMapping("/setLeader")
    public Result<Void> setLeader() {
        return null;
    }

    /**
     * show department users
     * POST /api/demo/departments/{id}/users
     */
    @PostMapping("/{id}/users")
    public Result<Void> departmentUsers(@PathVariable Long id) {
        return null;
    }


}
