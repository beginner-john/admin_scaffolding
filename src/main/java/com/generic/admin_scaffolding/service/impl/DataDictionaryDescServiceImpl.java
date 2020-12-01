package com.generic.admin_scaffolding.service.impl;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.model.DataDictionaryDesc;
import com.generic.admin_scaffolding.exception.ExceptionDef;
import com.generic.admin_scaffolding.exception.ServiceException;
import com.generic.admin_scaffolding.repository.DataDictionaryDescRepository;
import com.generic.admin_scaffolding.service.DataDictionaryDescService;
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
 * @date 2020/12/1 17:48
 */

@Service("dataDictionaryDescService")
public class DataDictionaryDescServiceImpl implements DataDictionaryDescService {

    @Resource
    private DataDictionaryDescRepository dictionaryDescRepository;

    @Override
    public Result<List<DataDictionaryDesc>> list(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<DataDictionaryDesc> data = dictionaryDescRepository.findAll(pageable);
        return Result.of(data.getContent(), PageInfoUtils.getPageInfo(data));
    }

    @Override
    public Result<DataDictionaryDesc> findById(Long id) {
        return Result.of(getDictionaryDescById(id));
    }

    //查看详情
    private DataDictionaryDesc getDictionaryDescById(Long id) {
        if (StringUtils.isEmpty(id)) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        Optional<DataDictionaryDesc> optionalUser = dictionaryDescRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new ServiceException(ExceptionDef.ERROR_DATA_NOT_EXIST);
        }
        return optionalUser.get();
    }

    @Override
    public Result<DataDictionaryDesc> save(DataDictionaryDesc dictDesc) {
        if (StringUtils.isEmpty(dictDesc.getDictionaryId()) || StringUtils.isEmpty(dictDesc.getValueCode())) {
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL);
        }
        DataDictionaryDesc data = new DataDictionaryDesc();
        data.setDictionaryId(dictDesc.getDictionaryId());
        data.setValueCode(dictDesc.getValueCode());
        data.setValueEn(dictDesc.getValueEn());
        data.setValueCn(dictDesc.getValueCn());
        data.setCreateTime(DateUtils.getCurrentTimestamp());
        data.setCreateBy(null);
        return Result.of(dictionaryDescRepository.saveAndFlush(data));
    }

    @Override
    public Result<DataDictionaryDesc> update(DataDictionaryDesc dictDesc) {
        DataDictionaryDesc existData = getDictionaryDescById(dictDesc.getId());
        existData.setValueEn(dictDesc.getValueEn());
        existData.setValueCn(dictDesc.getValueCn());
        existData.setUpdateBy(null);
        existData.setUpdateTime(DateUtils.getCurrentTimestamp());
        return Result.of(dictionaryDescRepository.saveAndFlush(existData));
    }

    @Override
    public Result<Integer> deleteByPks(List<Long> ids) {
        return Result.of(dictionaryDescRepository.deleteByIds(ids));
    }
}
