package com.generic.admin_scaffolding.controller;

import com.generic.admin_scaffolding.entity.model.User;
import com.generic.admin_scaffolding.exception.ExceptionDef;
import com.generic.admin_scaffolding.exception.ServiceException;
import com.generic.admin_scaffolding.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/1/7 10:05
 */
public abstract class AbstractController {

    @Resource
    private UserService userService;

    /**
     * 获取当前登录用户信息
     *
     * @return
     * @throws ServiceException
     */
    protected User getUserContent() throws ServiceException {
        User user = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!Objects.isNull(principal)) {
            user = userService.findByUsername(principal.toString());
        }
        if (Objects.isNull(user)) {
            throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID);
        }
        return user;
    }

    /**
     * 获取当前登录用户ID
     *
     * @return
     * @throws ServiceException
     */
    protected Long getUserContentId() throws ServiceException {
        User user = getUserContent();
        return user.getId();
    }

}
