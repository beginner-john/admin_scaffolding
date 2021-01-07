package com.generic.admin_scaffolding.controller;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.dto.UserDto;
import com.generic.admin_scaffolding.entity.dto.UserRoleDTO;
import com.generic.admin_scaffolding.entity.model.User;
import com.generic.admin_scaffolding.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/18 17:08
 */
@Api(tags = "用户模块")
@RequestMapping("/users")
@RestController
public class UserController extends AbstractController {

    @Resource
    private UserService userService;

    @ApiOperation("用户列表")
    @GetMapping
    public Result<List<User>> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return userService.getUserList(page, pageSize);
    }

    @ApiOperation("用户详情")
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @ApiOperation("新增用户")
    @PostMapping
    public Result<User> save(@RequestBody User user) {
        return userService.saveUser(user, super.getUserContentId());
    }

    @ApiOperation("修改用户")
    @PutMapping
    public Result<User> update(@RequestBody User user) {
        return userService.updateUser(user, super.getUserContentId());
    }

    @ApiOperation("用户修改密码")
    @PostMapping("updatePassword")
    public Result<User> updatePassword(@RequestBody UserDto userDto) {
        return userService.updatePassword(userDto);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @ApiOperation("给用户绑定角色,角色多选")
    @PostMapping("/bindingRole")
    public Result bindingRole(@RequestBody UserRoleDTO roleIds) {
        return userService.bindingRole(roleIds);
    }

    @ApiOperation("给用户解除角色,角色多选")
    @PostMapping("/relieveRole")
    public Result relieveRole(@RequestBody UserRoleDTO roleIds) {
        return userService.relieveRole(roleIds);
    }

}
