package com.generic.admin_scaffolding.controller;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.model.OperationRecord;
import com.generic.admin_scaffolding.service.OperationLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2021/1/23 10:45
 */
@Api(tags = "操作日志")
@RequestMapping("/operation")
@RestController
public class OperationLogController {


    @Resource
    private OperationLogService operationLogService;

    @ApiOperation("操作日志列表")
    @GetMapping
    public Result<List<OperationRecord>> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return operationLogService.findOperationRecordList(page, pageSize);
    }


}
