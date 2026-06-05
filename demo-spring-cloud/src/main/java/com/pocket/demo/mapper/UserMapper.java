package com.pocket.demo.mapper;

import org.apache.ibatis.annotations.*;
import com.pocket.demo.entity.UserEntity;
import java.util.List;

/**
 * 用户Mapper
 * @author Shawn
 */
@Mapper
public interface UserMapper {

    /**
     * 插入用户
     */
    @Insert("INSERT INTO user(username, nickname, email, phone, password, status, create_time, update_time, is_deleted) " +
            "VALUES(#{username}, #{nickname}, #{email}, #{phone}, #{password}, #{status}, #{createTime}, #{updateTime}, #{isDeleted})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserEntity user);

    /**
     * 根据ID查询用户
     */
    @Select("SELECT * FROM user WHERE id = #{id} AND is_deleted = '0'")
    UserEntity selectById(Long id);

    /**
     * 根据用户名查询用户
     */
    @Select("SELECT * FROM user WHERE username = #{username} AND is_deleted = '0'")
    UserEntity selectByUsername(String username);

    /**
     * 查询所有用户
     */
    @Select("SELECT * FROM user ORDER BY create_time DESC")
    List<UserEntity> selectAll();

    /**
     * 更新用户
     */
    @Update("UPDATE user SET username=#{username}, nickname = #{nickname}, email=#{email}, phone=#{phone}, " +
            "status=#{status}, update_time=#{updateTime} WHERE id=#{id}")
    int update(UserEntity user);

    /**
     * 更新用户密码
     */
    @Update("UPDATE user SET password = #{password}, update_time = #{updateTime} WHERE id = #{id}")
    int updateUserPassword(UserEntity user);

    /**
     * 删除用户
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(Long id);

    /**
     * 删除用户-标记删除
     */
    @Update("UPDATE user SET is_deleted = '1' WHERE id = #{id}")
    int deleteById2(Long id);


}