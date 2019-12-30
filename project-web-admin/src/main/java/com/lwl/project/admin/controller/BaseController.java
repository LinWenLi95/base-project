package com.lwl.project.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwl.project.admin.annotation.ApiLog;
import com.lwl.project.admin.pojo.dto.Result;
import com.lwl.project.admin.service.BaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T> {

    public abstract BaseService<T> getBaseService();

    @ApiLog
    @ApiOperation(value = "查询多条数据")
    @GetMapping("/")
    public Result<Page<T>> queryList(Integer pageSize,Integer currentPage) {
        pageSize = 100;
        currentPage = 1;
        int total = getBaseService().selectCountByMap(null);
        Page<T> page = new Page<>(currentPage, pageSize, total);
        if (total > 0) {
            List<T> ts = getBaseService().selectByMap(null);
            page.setRecords(ts);
        }
        return Result.success(page);
    }

    @ApiLog
    @ApiOperation(value = "查询单条数据")
    @GetMapping("/{id}")
    public Result<T> queryOne(@PathVariable Integer id) {
        if (id == null) {
            return Result.failure();
        }
        T t = getBaseService().selectById(id);
        return Result.success(t);
    }

    @ApiLog
    @ApiOperation(value = "插入数据")
    @PostMapping("/")
    public Result add(@RequestBody T obj) {
        Integer result = 0;
        if (obj != null) {
            result = getBaseService().add(obj);
        }
        return result == 1 ? Result.success() : Result.failure("新增失败");
    }

    @ApiLog
    @ApiOperation(value = "更新数据")
    @PutMapping("/")
    public Result update(@RequestBody T obj) {
        Integer result = 0;
        if (obj != null) {
            result = getBaseService().update(obj);
        }
        return result == 1 ? Result.success() : Result.failure("更新失败");
    }

    @ApiLog
    @ApiOperation(value = "删除数据")
    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id) {
        Integer result = 0;
        if (id != null) {
            result = getBaseService().delById(id);
        }
        return result == 1 ? Result.success() : Result.failure("删除失败");
    }
}
