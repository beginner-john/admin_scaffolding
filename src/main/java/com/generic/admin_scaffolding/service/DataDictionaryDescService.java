package com.generic.admin_scaffolding.service;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.model.DataDictionaryDesc;

import java.util.List;

/**
 * 数据字典接口
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2020/12/1 17:26
 */
public interface DataDictionaryDescService {

    /**
     * 获取数据字典列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    Result<List<DataDictionaryDesc>> list(int page, int pageSize);

    /**
     * 查看详情
     *
     * @param id
     * @return
     */
    Result<DataDictionaryDesc> findById(Long id);

    /**
     * 新增数据字典详情
     *
     * @param dataDictionaryDesc
     * @return
     */
    Result<DataDictionaryDesc> save(DataDictionaryDesc dataDictionaryDesc);


    /**
     * 修改数据字典详情
     *
     * @param dataDictionaryDesc
     * @return
     */
    Result<DataDictionaryDesc> update(DataDictionaryDesc dataDictionaryDesc);


    /**
     * 批量删除
     *
     * @param ids 主键id集合
     * @return
     */
    Result<Integer> deleteByPks(List<Long> ids);

}
