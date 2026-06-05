package com.pocket.demo.dto.response;

import lombok.Data;

/**
 * department response DTO
 * @author shawn
 */
@Data
public class DepartmentResponse {

    private Long id;
    private String code;
    private String name;
    private String leader;
    private int level;
    private int parentId;

}
