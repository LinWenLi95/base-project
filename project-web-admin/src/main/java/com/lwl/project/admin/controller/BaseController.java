package com.lwl.project.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwl.project.admin.annotation.ApiLog;
import com.lwl.project.admin.pojo.dto.Result;
import com.lwl.project.admin.pojo.dto.ResultCode;
import com.lwl.project.admin.service.BaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T> {

    public abstract BaseService<T> getBaseService();

    @ApiLog
    @ApiOperation(value = "查询多条数据")
    @GetMapping("/")
    public ResponseEntity<Result<Page<T>>> queryList(@ApiParam(value = "单页数据条数", example = "10")
                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     @ApiParam(value = "页码", example = "1")
                                                     @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage) {
        IPage<T> tiPage = getBaseService().selectPage(currentPage, pageSize);
        Page<T> page = new Page<>(currentPage, pageSize, tiPage.getTotal());
        page.setRecords(tiPage.getRecords());
        return Result.success(page);
    }

    @ApiLog
    @ApiOperation(value = "查询单条数据")
    @GetMapping("/{id}")
    public ResponseEntity<Result<T>> queryOne(@PathVariable("id") Integer id) {
        T t = getBaseService().selectById(id);
        return Result.success(t);
    }

    @ApiLog
    @ApiOperation(value = "插入数据")
    @PostMapping("/")
    public ResponseEntity<Result<Object>> add(@RequestBody T obj) {
        Integer result = 0;
        if (obj != null) {
            result = getBaseService().add(obj);
        }
        return result == 1 ? Result.success() : Result.success(ResultCode.UNEXPECTED_RESULTS);
    }

    @ApiLog
    @ApiOperation(value = "更新数据")
    @PutMapping("/")
    public ResponseEntity<Result<Object>> update(@RequestBody T obj) {
        Integer result = 0;
        if (obj != null) {
            result = getBaseService().update(obj);
        }
        return result == 1 ? Result.success() : Result.success(ResultCode.UNEXPECTED_RESULTS);
    }

    @ApiLog
    @ApiOperation(value = "删除数据")
    @DeleteMapping("/{id}")
    public ResponseEntity<Result<Object>> del(@PathVariable("id") Integer id) {
        Integer result = 0;
        if (id != null) {
            result = getBaseService().delById(id);
        }
        return result == 1 ? Result.success() : Result.success(ResultCode.UNEXPECTED_RESULTS);
    }

}
