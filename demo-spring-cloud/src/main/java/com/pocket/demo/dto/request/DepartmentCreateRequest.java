package com.pocket.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * create department request DTO
 * @author shawn
 */
@Data
public class DepartmentCreateRequest {

    @NotBlank(message = "Department name can't be null!")
    @Size(min = 3, max = 20, message = "Department name length limit: 3–20 characters.")
    private String name;

    private String code;

    private String parentId;

    private String status;

}
