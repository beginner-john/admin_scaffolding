package com.generic.admin_scaffolding.service;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.dto.UserDto;
import com.generic.admin_scaffolding.entity.dto.UserRoleDTO;
import com.generic.admin_scaffolding.entity.model.User;

import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/18 17:09
 */
public interface UserService {


    /**
     * 用户列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    Result<List<User>> findUserList(int page, int pageSize);

    //根据用户名查找用户实体
    User findByUsername(String username);

    /**
     * 新增用户
     *
     * @param user
     * @param userId 当前用户ID
     * @return
     */
    Result<User> saveUser(User user, Long userId);

    /**
     * 更新用户
     *
     * @param user
     * @param userId 当前用户ID
     * @return
     */
    Result<User> updateUser(User user, Long userId);

    /**
     * 用户修改密码
     *
     * @param userDto
     * @return
     */
    Result<User> updatePassword(UserDto userDto);

    /**
     * 删除用户
     *
     * @param id 主键id
     * @return
     */
    Result<Boolean> deleteUser(Long id);

    Result<User> findById(Long id);

    /**
     * 用户绑定角色
     *
     * @param roleIds
     * @return
     */
    Result bindingRole(UserRoleDTO roleIds);

    /**
     * 用户解除角色
     *
     * @param roleIds
     * @return
     */
    Result relieveRole(UserRoleDTO roleIds);

    /**
     * 启用/禁用用户
     * 禁用用户无法登录和操作
     *
     * @param id
     * @param status
     * @param userContentId
     * @return
     */
    Result<User> enableUser(Long id, Integer status, Long userContentId);

    /**
     * 管理员给用户重置密码
     * @param userDto
     * @param userContentId
     * @return
     */
    Result<User> resetAccountPassword(UserDto userDto, Long userContentId);
}
