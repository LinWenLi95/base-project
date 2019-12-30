package com.lwl.project.admin.controller;

import com.lwl.project.admin.pojo.dto.Result;
import com.lwl.project.admin.pojo.entity.SysMenu;
import com.lwl.project.admin.pojo.vo.MenuTree;
import com.lwl.project.admin.service.BaseService;
import com.lwl.project.admin.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lwl
 */
@Slf4j
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/menus")
public class SysMenuController extends BaseController<SysMenu> {

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public BaseService<SysMenu> getBaseService() {
        return sysMenuService;
    }

    @ApiOperation(value = "获取指定id的菜单实体")
    @GetMapping("/query/{id}")
    public ResponseEntity<Result<SysMenu>> queryOne2(@PathVariable("id") Integer id) {
        if (id == 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Result.failure());
        }
        SysMenu sysMenu = sysMenuService.selectById(id);
        return ResponseEntity.ok(Result.success(sysMenu));
    }


    @GetMapping("/menuTrees")
    public Result<List<MenuTree>> getMenusTree() {
        List<MenuTree> menuTree = sysMenuService.getMenuTrees();
        return Result.success(menuTree);
    }

    @PutMapping("/menuTrees")
    public Result putMenusTree(@RequestBody SysMenu sysMenu) {
        return this.update(sysMenu);
    }
}
