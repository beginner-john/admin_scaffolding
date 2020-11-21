package com.generic.admin_scaffolding.service.impl;

import com.generic.admin_scaffolding.common.PageInfo;
import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.enums.DataDictionaryEnum;
import com.generic.admin_scaffolding.entity.model.User;
import com.generic.admin_scaffolding.exception.ExceptionDef;
import com.generic.admin_scaffolding.exception.ServiceException;
import com.generic.admin_scaffolding.repository.UserRepository;
import com.generic.admin_scaffolding.service.UserService;
import com.generic.admin_scaffolding.utils.DateUtils;
import com.generic.admin_scaffolding.utils.MD5Utils;
import com.generic.admin_scaffolding.utils.PageInfoUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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
        User userData = new User();
        userData.setUsername(user.getUsername());
        userData.setPhone(user.getPhone());
        userData.setSex(user.getSex());
        userData.setPassword(MD5Utils.encrypt(user.getPassword()));
        userData.setStatus(DataDictionaryEnum.ENABLE.getCode());
        userData.setIsAdmin(DataDictionaryEnum.CUSTOMER.getCode());
        userData.setCreatedTime(DateUtils.getCurrentTimestamp());
        userData.setCreated_by(null);//todo

        return Result.of(userRepository.saveAndFlush(userData));
    }

    /**
     * 修改用户，支持修改用户的以下信息
     * 密码，电话号码，性别，启用状态
     *
     * @param user
     * @return
     */

    @Override
    public Result<User> updateUser(User user) {
        if (StringUtils.isEmpty(user.getId())) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (!optionalUser.isPresent()) {
            throw new ServiceException(ExceptionDef.ERROR_DATA_NOT_EXIST);
        }
        User existUser = optionalUser.get();
        existUser.setPassword(MD5Utils.encrypt(user.getPassword()));
        existUser.setPhone(user.getPhone());
        existUser.setSex(user.getSex());
        int s = user.getStatus() == DataDictionaryEnum.ENABLE.getCode() ? DataDictionaryEnum.ENABLE.getCode()
                : DataDictionaryEnum.DISABLE.getCode();
        existUser.setStatus(s);

        return Result.of(userRepository.saveAndFlush(existUser));
    }

    @Override
    public Result<Boolean> deleteUser(Long id) {
        userRepository.deleteById(id);
        return Result.of(true);
    }

    @Override
    public Result<User> findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new ServiceException(ExceptionDef.ERROR_DATA_NOT_EXIST);
        }
        return Result.of(optionalUser.get());
    }
}
