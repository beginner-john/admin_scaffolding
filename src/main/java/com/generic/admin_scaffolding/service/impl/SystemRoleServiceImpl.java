package com.generic.admin_scaffolding.service.impl;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.constant.FieldConstant;
import com.generic.admin_scaffolding.entity.dto.RoleResourceDTO;
import com.generic.admin_scaffolding.entity.enums.DataDictionaryEnum;
import com.generic.admin_scaffolding.entity.model.RoleResource;
import com.generic.admin_scaffolding.entity.model.SystemRole;
import com.generic.admin_scaffolding.exception.ExceptionDef;
import com.generic.admin_scaffolding.exception.ServiceException;
import com.generic.admin_scaffolding.repository.RoleResourceRepository;
import com.generic.admin_scaffolding.repository.SystemRoleRepository;
import com.generic.admin_scaffolding.service.SystemRoleService;
import com.generic.admin_scaffolding.utils.DateUtils;
import com.generic.admin_scaffolding.utils.PageInfoUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    private RoleResourceRepository roleResourceRepository;

    @Override
    public Result<List<SystemRole>> findRoleList(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, FieldConstant.CREATED_TIME));
        Page<SystemRole> data = systemRoleRepository.findAll(pageRequest);
        return Result.of(data.getContent(), PageInfoUtils.getPageInfo(data));
    }

    @Override
    public Result<SystemRole> findById(Long id) {
        return Result.of(getSystemRoleById(id));
    }

    //查看详情
    private SystemRole getSystemRoleById(Long id) {
        Optional<SystemRole> optionalUser = systemRoleRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new ServiceException(ExceptionDef.ERROR_DATA_NOT_EXIST);
        }
        return optionalUser.get();
    }

    @Override
    public Result<SystemRole> saveRole(SystemRole role, Long userId) {
        if (StringUtils.isEmpty(role.getRoleCode()) || StringUtils.isEmpty(role.getRoleName())) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        SystemRole systemRole = new SystemRole();
        systemRole.setRoleCode(role.getRoleCode());
        systemRole.setRoleName(role.getRoleName());
        systemRole.setRemark(role.getRemark());
        systemRole.setStatus(DataDictionaryEnum.ENABLE.getCode());
        systemRole.setCreateTime(DateUtils.getCurrentTimestamp());
        systemRole.setCreateBy(userId);

        return Result.of(systemRoleRepository.saveAndFlush(systemRole));
    }

    @Override
    public Result<SystemRole> updateRole(SystemRole role, Long userId) {
        SystemRole existRole = getSystemRoleById(role.getId());
        existRole.setRoleName(StringUtils.isEmpty(role.getRoleName()) ? existRole.getRoleName() : role.getRoleName());
        existRole.setRemark(StringUtils.isEmpty(role.getRemark()) ? existRole.getRemark() : role.getRemark());
        existRole.setStatus(Objects.isNull(role.getStatus()) ? existRole.getStatus() : role.getStatus());
        existRole.setUpdateBy(userId);
        existRole.setUpdateTime(DateUtils.getCurrentTimestamp());

        return Result.of(systemRoleRepository.saveAndFlush(existRole));
    }

    @Override
    public Result bindingRole(RoleResourceDTO dto) {
        if (Objects.isNull(dto) || Objects.isNull(dto.getRoleId()) || Objects.isNull(dto.getResourceIds())) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        List<RoleResource> rrList = new ArrayList<>();
        dto.getResourceIds().forEach(e -> {
            RoleResource roleResource = new RoleResource();
            roleResource.setRoleId(dto.getRoleId());
            roleResource.setResourceId(e);
            roleResource.setCreateBy(null);
            roleResource.setCreateTime(DateUtils.getCurrentTimestamp());
            rrList.add(roleResource);
        });

        roleResourceRepository.saveAll(rrList);
        return Result.of(true);
    }

    @Override
    public Result relieveRole(RoleResourceDTO dto) {
        if (Objects.isNull(dto) || Objects.isNull(dto.getRoleId()) || Objects.isNull(dto.getResourceIds())) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        Integer row = roleResourceRepository.deleteByResourceIds(dto.getResourceIds());
        return Result.of(row);
    }
}
