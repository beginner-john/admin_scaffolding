package com.generic.admin_scaffolding.service.impl;

import com.generic.admin_scaffolding.common.PageInfo;
import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.enums.DataDictionaryEnum;
import com.generic.admin_scaffolding.entity.model.User;
import com.generic.admin_scaffolding.exception.ExceptionDef;
import com.generic.admin_scaffolding.exception.ServiceException;
import com.generic.admin_scaffolding.repository.UserRepository;
import com.generic.admin_scaffolding.service.UserService;
import com.generic.admin_scaffolding.utils.MD5Utils;
import com.generic.admin_scaffolding.utils.PageInfoUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/18 17:09
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public Result<List<User>> getUserList(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<User> data = userRepository.findAll(pageable);
        return Result.of(data.getContent(), PageInfoUtils.getPageInfo(data));
    }

    @Override
    public Result<User> saveUser(User user) {
        if(StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPassword())){
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        user.setPassword(MD5Utils.encrypt(user.getPassword()));
        user.setStatus(DataDictionaryEnum.ENABLE.getCode());
        user.setIsAdmin(DataDictionaryEnum.CUSTOMER.getCode());
        long time = System.currentTimeMillis();
        user.setCreatedTime(new Timestamp(time));
        user.setCreated_by(null);//todo

        return Result.of(userRepository.saveAndFlush(user));
    }
}
