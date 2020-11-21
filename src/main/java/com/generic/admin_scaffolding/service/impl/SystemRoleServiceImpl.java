package com.generic.admin_scaffolding.service.impl;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.enums.DataDictionaryEnum;
import com.generic.admin_scaffolding.entity.model.SystemRole;
import com.generic.admin_scaffolding.exception.ExceptionDef;
import com.generic.admin_scaffolding.exception.ServiceException;
import com.generic.admin_scaffolding.repository.SystemRoleRepository;
import com.generic.admin_scaffolding.service.SystemRoleService;
import com.generic.admin_scaffolding.utils.DateUtils;
import com.generic.admin_scaffolding.utils.PageInfoUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/21 9:50
 */

@Service("systemRoleService")
public class SystemRoleServiceImpl implements SystemRoleService {

    @Resource
    private SystemRoleRepository systemRoleRepository;

    @Override
    public Result<List<SystemRole>> getRoleList(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<SystemRole> data = systemRoleRepository.findAll(pageRequest);
        return Result.of(data.getContent(), PageInfoUtils.getPageInfo(data));
    }

    @Override
    public Result<SystemRole> findById(Long id) {
        Optional<SystemRole> optionalUser = systemRoleRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new ServiceException(ExceptionDef.ERROR_DATA_NOT_EXIST);
        }
        return Result.of(optionalUser.get());
    }

    @Override
    public Result<SystemRole> saveRole(SystemRole role) {
        if (StringUtils.isEmpty(role.getRoleCode()) || StringUtils.isEmpty(role.getRoleName())) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        SystemRole systemRole = new SystemRole();
        systemRole.setRoleCode(role.getRoleCode());
        systemRole.setRoleName(role.getRoleName());
        systemRole.setRemark(role.getRemark());
        systemRole.setStatus(DataDictionaryEnum.ENABLE.getCode());
        systemRole.setCreatedTime(DateUtils.getCurrentTimestamp());
        systemRole.setCreatedBy(null);//todo

        return Result.of(systemRoleRepository.saveAndFlush(systemRole));
    }

    @Override
    public Result<SystemRole> updateRole(SystemRole role) {
        if (StringUtils.isEmpty(role.getId())) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        Optional<SystemRole> optionalRole = systemRoleRepository.findById(role.getId());
        if (!optionalRole.isPresent()) {
            throw new ServiceException(ExceptionDef.ERROR_DATA_NOT_EXIST);
        }
        SystemRole existRole = optionalRole.get();
        existRole.setRoleName(StringUtils.isEmpty(role.getRoleName()) ? existRole.getRoleName() : role.getRoleName());
        existRole.setRemark(StringUtils.isEmpty(role.getRemark()) ? existRole.getRemark() : role.getRemark());
        existRole.setStatus(Objects.isNull(role.getStatus()) ? existRole.getStatus() : role.getStatus());

        return Result.of(systemRoleRepository.saveAndFlush(existRole));
    }
}
