package com.generic.admin_scaffolding.service.impl;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.model.User;
import com.generic.admin_scaffolding.exception.ExceptionDef;
import com.generic.admin_scaffolding.exception.ServiceException;
import com.generic.admin_scaffolding.repository.UserRepository;
import com.generic.admin_scaffolding.service.LoginService;
import com.generic.admin_scaffolding.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/10/31 19:11
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserService userService;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;


    /**
     * 使用BCryptPasswordEncoder加密是不可逆的,
     * 因此通过用户名查找用户,再对比密码是否一致,
     * 这样就要求用户名是唯一的
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public Result login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new ServiceException(ExceptionDef.ERROR_USER_LOGIN_FAILED);
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ServiceException(ExceptionDef.ERROR_USER_LOGIN_FAILED);
        }
        return Result.of(user);
    }

}
