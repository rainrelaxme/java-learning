package com.pocket.demo.mapper;

import com.pocket.demo.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * 部门Mapper
 * @author Shawn
 */
@Mapper
public interface DepartmentMapper {

    /**
     * create department
     */
    @Insert("INSERT INTO department(parent_id, name, code, leader_id, sort_order, status, path, level, create_time, update_time, is_deleted) " +
            "VALUES(#{parentId}, #{name}, #{code}, #{leaderId}, #{sortOrder}, #{status}, #{path}, #{level}, #{createTime}, #{updateTime}, #{isDeleted})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(DepartmentEntity department);

    /**
     * select department by ID
     */
    @Select("SELECT * FROM department WHERE id = #{id} AND is_deleted = '0'")
    DepartmentEntity selectById(Long id);

    /**
     * select department by code
     */
    @Select("SELECT * FROM department WHERE code = #{code} AND is_deleted = '0'")
    DepartmentEntity selectByCode(String code);

    /**
     * 查询系统自动生成的部门编号最大序号（DEPT0001 格式）
     */
    @Select("SELECT MAX(CAST(SUBSTRING(code, 5) AS UNSIGNED)) FROM department " +
            "WHERE code REGEXP '^DEPT[0-9]+$' AND is_deleted = '0'")
    Integer selectMaxAutoCodeSequence();

}
