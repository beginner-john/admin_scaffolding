package com.generic.admin_scaffolding.service.impl;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.model.SystemResource;
import com.generic.admin_scaffolding.exception.ExceptionDef;
import com.generic.admin_scaffolding.exception.ServiceException;
import com.generic.admin_scaffolding.repository.SystemResourceRepository;
import com.generic.admin_scaffolding.service.SystemResourceService;
import com.generic.admin_scaffolding.utils.DateUtils;
import com.generic.admin_scaffolding.utils.PageInfoUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/29 12:37
 */
@Service("systemResourceService")
public class SystemResourceServiceImpl implements SystemResourceService {

    @Resource
    private SystemResourceRepository resourceRepository;

    @Override
    public Result<List<SystemResource>> getResourceList(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<SystemResource> data = resourceRepository.findAll(pageable);
        return Result.of(data.getContent(), PageInfoUtils.getPageInfo(data));
    }

    @Override
    public Result<SystemResource> findById(Long id) {
        return Result.of(getResourceById(id));
    }

    private SystemResource getResourceById(Long id) {
        if (StringUtils.isEmpty(id)) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        Optional<SystemResource> optional = resourceRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ServiceException(ExceptionDef.ERROR_DATA_NOT_EXIST);
        }
        return optional.get();
    }

    @Override
    public Result<SystemResource> save(SystemResource systemResource) {
        if (StringUtils.isEmpty(systemResource.getName()) || StringUtils.isEmpty(systemResource.getCode())
                || StringUtils.isEmpty(systemResource.getType())) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        SystemResource resourceData = new SystemResource();
        resourceData.setName(systemResource.getName());
        resourceData.setCode(systemResource.getCode());
        resourceData.setType(systemResource.getType());
        resourceData.setShowOrder(systemResource.getShowOrder());
        resourceData.setRemark(systemResource.getRemark());
        resourceData.setResUrl(systemResource.getResUrl());
        resourceData.setCreatedTime(DateUtils.getCurrentTimestamp());
        resourceData.setCreatedBy(null);

        return Result.of(resourceRepository.save(resourceData));
    }

    @Override
    public Result<SystemResource> update(SystemResource systemResource) {
        if (StringUtils.isEmpty(systemResource.getName()) || StringUtils.isEmpty(systemResource.getCode())
                || StringUtils.isEmpty(systemResource.getType())) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        SystemResource existsResource = getResourceById(systemResource.getId());

        existsResource.setName(systemResource.getName());
        existsResource.setCode(systemResource.getCode());
        existsResource.setType(systemResource.getType());
        existsResource.setShowOrder(systemResource.getShowOrder());
        existsResource.setRemark(systemResource.getRemark());
        existsResource.setResUrl(systemResource.getResUrl());

        return Result.of(resourceRepository.saveAndFlush(existsResource));
    }

    @Override
    public Result<Integer> deleteByIds(List<Long> ids) {
        return Result.of(resourceRepository.deleteByIds(ids));
    }
}
