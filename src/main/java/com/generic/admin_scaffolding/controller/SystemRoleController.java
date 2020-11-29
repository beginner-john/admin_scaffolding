package com.generic.admin_scaffolding.controller;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.dto.RoleResourceDTO;
import com.generic.admin_scaffolding.entity.model.SystemRole;
import com.generic.admin_scaffolding.service.SystemRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色不提供删除功能，只有在修改中有个启用禁用设置
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/21 9:49
 */

@Api(tags = "角色模块")
@RequestMapping("/roles")
@RestController
public class SystemRoleController {

    @Resource
    private SystemRoleService systemRoleService;

    @ApiOperation("角色列表")
    @GetMapping
    public Result<List<SystemRole>> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return systemRoleService.getRoleList(page, pageSize);
    }

    @ApiOperation("角色详情")
    @GetMapping("/{id}")
    public Result<SystemRole> findById(@PathVariable Long id) {
        return systemRoleService.findById(id);
    }

    @ApiOperation("添加角色")
    @PostMapping
    public Result<SystemRole> saveRole(@RequestBody SystemRole role) {
        return systemRoleService.saveRole(role);
    }

    @ApiOperation("修改角色")
    @PutMapping
    public Result<SystemRole> updateRole(@RequestBody SystemRole role) {
        return systemRoleService.updateRole(role);
    }


    @ApiOperation("给角色绑定资源,资源多选")
    @PostMapping("/bindingResource")
    public Result bindingRole(@RequestBody RoleResourceDTO dto) {
        return systemRoleService.bindingRole(dto);
    }

    @ApiOperation("给角色解除资源,资源多选")
    @PostMapping("/relieveResource")
    public Result relieveRole(@RequestBody RoleResourceDTO dto) {
        return systemRoleService.relieveRole(dto);
    }


}
