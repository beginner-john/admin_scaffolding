package com.generic.admin_scaffolding.controller;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.common.annotation.OperationAspect;
import com.generic.admin_scaffolding.entity.model.SystemResource;
import com.generic.admin_scaffolding.service.SystemResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/29 13:11
 */

@Api(tags = "系统资源管理")
@RestController
@RequestMapping("/resource")
public class SystemResourceController extends AbstractController{

    @Resource
    private SystemResourceService resourceService;

    @ApiOperation("系统资源列表")
    @GetMapping
    public Result<List<SystemResource>> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return resourceService.findResourceList(page, pageSize);
    }

    @ApiOperation("系统资源详情")
    @GetMapping("/{id}")
    public Result<SystemResource> findById(@PathVariable(name = "id") Long id) {
        return resourceService.findById(id);
    }

    @ApiOperation("新增系统资源")
    @PostMapping
    public Result<SystemResource> add(@RequestBody SystemResource systemResource) {
        return resourceService.save(systemResource, super.getUserContentId());
    }

    @ApiOperation("修改系统资源")
    @PutMapping
    public Result<SystemResource> update(@RequestBody SystemResource systemResource) {
        return resourceService.update(systemResource, super.getUserContentId());
    }

    @ApiOperation("批量删除系统资源")
    @DeleteMapping
    @OperationAspect(accessPath = "/resource/deleteByIds",accessDesc = "批量删除系统资源")
    public Result<Integer> deleteByIds(@RequestBody List<Long> ids) {
        return resourceService.deleteByIds(ids);
    }

}
