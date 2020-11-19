package com.generic.admin_scaffolding.controller;

import com.generic.admin_scaffolding.common.Result;
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
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("用户列表")
    @GetMapping
    public Result<List<User>> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return userService.getUserList(page, pageSize);
    }

    @ApiOperation("新增用户")
    @PostMapping
    public Result<User> save(@RequestBody User user) {
        return userService.saveUser(user);
    }

}
