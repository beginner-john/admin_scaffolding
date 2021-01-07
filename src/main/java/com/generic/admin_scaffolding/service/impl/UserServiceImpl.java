package com.generic.admin_scaffolding.service.impl;

import com.alibaba.fastjson.JSON;
import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.dto.UserDto;
import com.generic.admin_scaffolding.entity.dto.UserRoleDTO;
import com.generic.admin_scaffolding.entity.enums.DataDictionaryEnum;
import com.generic.admin_scaffolding.entity.model.User;
import com.generic.admin_scaffolding.entity.model.UserRole;
import com.generic.admin_scaffolding.exception.ExceptionDef;
import com.generic.admin_scaffolding.exception.ServiceException;
import com.generic.admin_scaffolding.repository.UserRepository;
import com.generic.admin_scaffolding.repository.UserRoleRepository;
import com.generic.admin_scaffolding.service.UserService;
import com.generic.admin_scaffolding.utils.DateUtils;
import com.generic.admin_scaffolding.utils.PageInfoUtils;
import com.generic.admin_scaffolding.utils.RedisUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/18 17:09
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Resource
    private UserRepository userRepository;
    @Resource
    private UserRoleRepository userRoleRepository;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;
    @Resource
    private RedisUtils redisUtils;

    @Override
    public Result<List<User>> getUserList(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<User> data = userRepository.findAll(pageable);
        return Result.of(data.getContent(), PageInfoUtils.getPageInfo(data));
    }

    @Override
    public User findByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Result<User> saveUser(User user,Long userId) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        //用户名是唯一标识
        User exitsUser = findByUsername(user.getUsername());
        if (exitsUser != null) {
            throw new ServiceException(ExceptionDef.ERROR_USER_EXIST);
        }
        User userData = new User();
        userData.setUsername(user.getUsername());
        userData.setPhone(user.getPhone());
        userData.setSex(user.getSex());
        userData.setPassword(passwordEncoder.encode(user.getPassword()));
        userData.setStatus(DataDictionaryEnum.ENABLE.getCode());
        userData.setIsAdmin(DataDictionaryEnum.CUSTOMER.getCode());
        userData.setCreateTime(DateUtils.getCurrentTimestamp());
        userData.setCreateBy(userId);

        return Result.of(userRepository.saveAndFlush(userData));
    }

    /**
     * 修改用户，支持修改用户的以下信息
     * 电话号码，性别，启用状态
     *
     * @param user
     * @return
     */
    @Override
    public Result<User> updateUser(User user,Long userId) {
        User existUser = getUserById(user.getId());
        existUser.setPhone(user.getPhone());
        existUser.setSex(user.getSex());
        int s = user.getStatus() == DataDictionaryEnum.ENABLE.getCode() ? DataDictionaryEnum.ENABLE.getCode()
                : DataDictionaryEnum.DISABLE.getCode();
        existUser.setStatus(s);
        existUser.setUpdateBy(userId);
        existUser.setUpdateTime(DateUtils.getCurrentTimestamp());
        String key = "user" + user.getId();
        redisUtils.del(key);

        return Result.of(userRepository.saveAndFlush(existUser));
    }

    @Override
    public Result<User> updatePassword(UserDto userDto) {
        User existUser = getUserById(userDto.getId());
        if (StringUtils.isEmpty(userDto.getOldPassword()) || !userDto.getNewPassword().equals(userDto.getRenewPassword())) {
            throw new ServiceException(ExceptionDef.ERROR_PASSWORD_INCONSISTENCY);
        }
        //matches 方法解密来验证
        if (!passwordEncoder.matches(userDto.getOldPassword(), existUser.getPassword())) {
            throw new ServiceException(ExceptionDef.ERROR_PASSWORD_FAILED);
        }
        existUser.setPassword(passwordEncoder.encode(userDto.getNewPassword()));
        return Result.of(userRepository.saveAndFlush(existUser));
    }

    @Override
    public Result<Boolean> deleteUser(Long id) {
        userRepository.deleteById(id);
        return Result.of(true);
    }

    @Override
    public Result<User> findById(Long id) {
        String key = "user" + id;
        Object object = redisUtils.get(key);
        if (object == null) {
            object = getUserById(id);
            redisUtils.set(key, JSON.toJSONString(object), 60 * 60 * 3);
            return Result.of((User) object);
        }
        //这种使用JSON适用于实体中有实体对象字段
        User user = JSON.parseObject(object.toString(), User.class);
        return Result.of(user);
    }

    private User getUserById(Long id) {
        if (StringUtils.isEmpty(id)) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new ServiceException(ExceptionDef.ERROR_DATA_NOT_EXIST);
        }
        return optionalUser.get();
    }

    @Override
    public Result bindingRole(UserRoleDTO dto) {
        if (Objects.isNull(dto) || Objects.isNull(dto.getUserId()) || Objects.isNull(dto.getRoleIds())) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        List<UserRole> urList = new ArrayList<>();
        dto.getRoleIds().forEach(e -> {
            UserRole userRole = new UserRole();
            userRole.setRoleId(e);
            userRole.setUserId(dto.getUserId());
            userRole.setCreateBy(null);
            userRole.setCreateTime(DateUtils.getCurrentTimestamp());
            urList.add(userRole);
        });

        userRoleRepository.saveAll(urList);
        return Result.of(true);
    }

    @Override
    public Result relieveRole(UserRoleDTO dto) {
        if (Objects.isNull(dto) || Objects.isNull(dto.getUserId()) || Objects.isNull(dto.getRoleIds())) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        Integer row = userRoleRepository.deleteByRoleIds(dto.getRoleIds());
        return Result.of(row);
    }
}
