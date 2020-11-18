package com.generic.admin_scaffolding.service;

import com.generic.admin_scaffolding.common.Result;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/10/31 19:02
 */
public interface LoginService {

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    Result login(String username, String password);

}
