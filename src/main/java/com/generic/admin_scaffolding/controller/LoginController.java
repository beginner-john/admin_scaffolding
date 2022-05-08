package com.generic.admin_scaffolding.controller;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.common.annotation.OperationAspect;
import com.generic.admin_scaffolding.entity.dto.LoginDTO;
import com.generic.admin_scaffolding.entity.model.User;
import com.generic.admin_scaffolding.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/10/31 19:02
 */
@Api(tags = "登录")
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private LoginService loginService;
    @Resource
    private ConsumerTokenServices consumerTokenServices;


    /**
     * 用户登录
     *
     * @param loginDTO
     * @return
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    @OperationAspect(accessPath = "/login", accessDesc = "用户登录")
    public Result<User> login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }

    /**
     * 用户退出
     *
     * @param accessToken
     * @return
     */
    @ApiOperation("用户退出")
    @PostMapping("/logout")
    @OperationAspect(accessPath = "/logout", accessDesc = "用户退出")
    public Result logout(@RequestParam(name = "token") String accessToken) {
        if (consumerTokenServices.revokeToken(accessToken)) {
            return Result.of(true);
        }
        return Result.error("退出失败");
    }


    /**
     * 获取token调用接口
     * 步骤：
     * 1，localhost:8080/api/oauth/token  Post请求
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
