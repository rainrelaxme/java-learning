package com.pocket.demo.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 岗位实体
 * @author shawn
 */
@Data
public class PositionEntity {

    private Long id;
    private String name;
    private String code;
    /**
     * null = 全公司通用
     */
    private Long deptId;
    /**
     * 职级，可选
     */
    private Integer level;
    private Integer sortOrder;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;

}
