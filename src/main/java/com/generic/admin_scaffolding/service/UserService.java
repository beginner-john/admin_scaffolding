package com.generic.admin_scaffolding.service;

import com.generic.admin_scaffolding.common.Result;
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
    Result<List<User>> getUserList(int page, int pageSize);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    Result<User> saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    Result<User> updateUser(User user);

    /**
     * 删除用户
     *
     * @param id 主键id
     * @return
     */
    Result<Boolean> deleteUser(Long id);

    Result<User> findById(Long id);
}
