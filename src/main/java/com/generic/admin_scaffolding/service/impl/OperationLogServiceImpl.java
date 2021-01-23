package com.generic.admin_scaffolding.service.impl;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.constant.FieldConstant;
import com.generic.admin_scaffolding.entity.model.OperationRecord;
import com.generic.admin_scaffolding.repository.OperationLogRepository;
import com.generic.admin_scaffolding.service.OperationLogService;
import com.generic.admin_scaffolding.utils.PageInfoUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/1/23 10:47
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Resource
    private OperationLogRepository operationLogRepository;

    @Override
    public Result<List<OperationRecord>> findOperationRecordList(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, FieldConstant.CREATED_TIME));
        Page<OperationRecord> data = operationLogRepository.findAll(pageable);
        return Result.of(data.getContent(), PageInfoUtils.getPageInfo(data));
    }
}
