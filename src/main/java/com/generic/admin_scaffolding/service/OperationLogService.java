package com.generic.admin_scaffolding.service;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.model.OperationRecord;

import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/1/23 10:47
 */
public interface OperationLogService {


    Result<List<OperationRecord>> findOperationRecordList(int page, int pageSize);

}
