package com.generic.admin_scaffolding.service;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.model.SystemResource;

import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/29 12:36
 */
public interface SystemResourceService {

    /**
     * 获取系统资源列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    Result<List<SystemResource>> getResourceList(int page, int pageSize);

    /**
     * 查看资源详情
     *
     * @param id
     * @return
     */
    Result<SystemResource> findById(Long id);

    /**
     * 新增资源
     *
     * @param systemResource
     * @return
     */
    Result<SystemResource> save(SystemResource systemResource);

    /**
     * 修改资源
     *
     * @param systemResource
     * @return
     */
    Result<SystemResource> update(SystemResource systemResource);

    /**
     * 批量删除资源，根据ids
     * 存在批量，则删除一个也调用此方法即可
     *
     * @param ids
     * @return
     */
    Result<Integer> deleteByIds(List<Long> ids);


}
