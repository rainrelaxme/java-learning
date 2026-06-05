package com.pocket.demo.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 部门实体
 * @author Shawn
 */
@Data
public class DepartmentEntity {

    private Long id;
    private Long parentId;
    private String name;
    private String code;

    /**
     * 部门负责人
     */
    private Long leaderId;
    private Integer sortOrder;
    private Integer status;
    private String path;
    private Integer level;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;

}
