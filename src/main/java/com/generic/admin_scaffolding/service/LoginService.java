package com.generic.admin_scaffolding.service;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.dto.LoginDTO;
import com.generic.admin_scaffolding.entity.model.User;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/10/31 19:02
 */
public interface LoginService {

    /**
     * 用户登录
     *
     * @return
     */
    Result<User> login(LoginDTO loginDTO);

}
