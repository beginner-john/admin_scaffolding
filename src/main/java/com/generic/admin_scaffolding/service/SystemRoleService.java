package com.generic.admin_scaffolding.service;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.model.SystemRole;

import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/21 9:50
 */
public interface SystemRoleService {

    /**
     * 获取角色列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    Result<List<SystemRole>> getRoleList(int page, int pageSize);

    /**
     * 查看角色详情
     *
     * @param id
     * @return
     */
    Result<SystemRole> findById(Long id);

    /**
     * 新增角色
     *
     * @param role
     * @return
     */
    Result<SystemRole> saveRole(SystemRole role);

    /**
     * 修改角色
     * roleCode不能修改，此值用于权限的判断
     *
     * @param role
     * @return
     */
    Result<SystemRole> updateRole(SystemRole role);

}
