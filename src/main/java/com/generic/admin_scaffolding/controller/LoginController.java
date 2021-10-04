package com.generic.admin_scaffolding.controller;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.common.annotation.OperationAspect;
import com.generic.admin_scaffolding.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/10/31 19:02
 */
@Api(tags = "登录")
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    @OperationAspect(accessPath = "/login",accessDesc = "用户登录")
    public Result login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        return loginService.login(username, password);
    }


    /**
     * 获取token调用接口
     * 步骤：
     * 1，localhost:8080/oauth/token  Post请求
     * 2，Auth选择Basic Auth,
     *      username填AuthorizationServerConfiguration配置的clientId，
     *      password填AuthorizationServerConfiguration配置的secret
     * 3，body输入x-www-form-unlencoded格式，
     *      grant_type:password
     *      username:tom
     *      password:123456
     * 4，token是接口返回的access_token值
     * 5，token放到Auth的Bearer Token中
     */
}
