package com.pocket.demo.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 用户-部门关联实体
 * @author shawn
 */
@Data
public class UserDepartmentEntity {

    private Long id;
    private Long userId;
    private Long deptId;
    /**
     * 在该部门的岗位
     */
    private Long positionId;
    private Integer isPrimary;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
