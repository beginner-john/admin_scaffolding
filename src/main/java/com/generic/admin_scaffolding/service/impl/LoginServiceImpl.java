package com.generic.admin_scaffolding.service.impl;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.model.User;
import com.generic.admin_scaffolding.exception.ExceptionDef;
import com.generic.admin_scaffolding.exception.ServiceException;
import com.generic.admin_scaffolding.repository.UserRepository;
import com.generic.admin_scaffolding.service.LoginService;
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


    @Override
    public Result login(String username, String password) {
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        User user = userRepository.findUserByUsernameAndPassword(username,password);
        if(user==null){
            throw new ServiceException(ExceptionDef.ERROR_USER_LOGIN_FAILED);
        }
        return Result.of(user);
    }

}
