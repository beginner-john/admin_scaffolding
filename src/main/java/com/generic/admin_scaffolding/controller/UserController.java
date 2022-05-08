package com.generic.admin_scaffolding.controller;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.common.annotation.OperationAspect;
import com.generic.admin_scaffolding.entity.dto.UserPasswordDTO;
import com.generic.admin_scaffolding.entity.dto.UserRoleDTO;
import com.generic.admin_scaffolding.entity.model.User;
import com.generic.admin_scaffolding.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@CrossOrigin
public class UserController extends AbstractController {

    @Resource
    private UserService userService;

    @ApiOperation("用户列表")
    @GetMapping
    public Result<List<User>> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return userService.findUserList(page, pageSize);
    }

    @ApiOperation("用户详情")
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @ApiOperation("获取当前登录用户信息")
    @GetMapping("/current")
    public Result<User> findCurrentUSer() {
        return Result.of(super.getUserContent());
    }

    @ApiOperation("新增用户")
    @PostMapping
    @OperationAspect(accessPath = "/users/save",accessDesc = "新增用户")
    public Result<User> save(@RequestBody User user) {
        return userService.saveUser(user, super.getUserContentId());
    }

    @ApiOperation("修改用户")
    @PutMapping
    @OperationAspect(accessPath = "/users/update",accessDesc = "修改用户")
    public Result<User> update(@RequestBody User user) {
        return userService.updateUser(user, super.getUserContentId());
    }

    @ApiOperation("启用/禁用用户")
    @PostMapping("/enable/{id}/{status}")
    @OperationAspect(accessPath = "/users/enable/id/status", accessDesc = "启用/禁用用户")
    public Result<User> enableUser(@PathVariable Long id, @PathVariable Integer status) {
        return userService.enableUser(id, status, super.getUserContentId());
    }

    @ApiOperation("用户修改密码")
    @PostMapping("updatePassword")
    @OperationAspect(accessPath = "/users/updatePassword",accessDesc = "用户修改密码")
    public Result<User> updatePassword(@RequestBody UserPasswordDTO userPasswordDto) {
        return userService.updatePassword(userPasswordDto);
    }

    @ApiOperation("管理员给用户重置密码")
    @PostMapping("resetAccountPassword")
    @OperationAspect(accessPath = "/users/resetAccountPassword",accessDesc = "管理员给用户重置密码")
    public Result<User> resetAccountPassword(@RequestBody UserPasswordDTO userPasswordDto) {
        return userService.resetAccountPassword(userPasswordDto, super.getUserContentId());
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    @OperationAspect(accessPath = "/users/delete",accessDesc = "删除用户")
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
