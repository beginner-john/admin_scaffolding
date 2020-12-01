package com.generic.admin_scaffolding.controller;

import com.generic.admin_scaffolding.common.Result;
import com.generic.admin_scaffolding.entity.model.DataDictionaryDesc;
import com.generic.admin_scaffolding.service.DataDictionaryDescService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/12/1 18:11
 */

@Api(tags = "数据字典接口")
@RequestMapping("basic/dataDictionary")
@RestController
public class DataDictionaryDescController {

    @Resource
    private DataDictionaryDescService dictionaryDescService;

    @ApiOperation("数据字典列表")
    @GetMapping
    public Result<List<DataDictionaryDesc>> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return dictionaryDescService.list(page, pageSize);
    }

    @ApiOperation("查看详情")
    @GetMapping("/{id}")
    public Result<DataDictionaryDesc> findById(@PathVariable Long id) {
        return dictionaryDescService.findById(id);
    }

    @ApiOperation("新增数据字典")
    @PostMapping
    public Result<DataDictionaryDesc> save(@RequestBody DataDictionaryDesc desc) {
        return dictionaryDescService.save(desc);
    }

    @ApiOperation("修改数据字典")
    @PutMapping
    public Result<DataDictionaryDesc> update(@RequestBody DataDictionaryDesc desc) {
        return dictionaryDescService.update(desc);
    }

    @ApiOperation("批量删除数据字典")
    @DeleteMapping
    public Result<Integer> deleteByIds(@RequestBody List<Long> ids) {
        return dictionaryDescService.deleteByPks(ids);
    }

}
