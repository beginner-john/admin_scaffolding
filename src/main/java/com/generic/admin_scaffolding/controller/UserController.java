package com.generic.admin_scaffolding.controller;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.model.User;
import com.generic.admin_scaffolding.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    public Result<User> list() {
        return null;
    }

}
