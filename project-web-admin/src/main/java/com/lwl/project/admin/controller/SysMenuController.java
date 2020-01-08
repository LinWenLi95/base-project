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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Override
    @ApiOperation(value = "获取指定id的菜单实体")
    @GetMapping("/query/{id}")
    public ResponseEntity<Result<SysMenu>> queryOne(@PathVariable("id") Integer id) {
        SysMenu sysMenu = sysMenuService.selectById(id);
        return Result.success(sysMenu) ;
    }

    @ApiOperation(value = "获取菜单树列表")
    @GetMapping("/menuTrees")
    public ResponseEntity<Result<List<MenuTree>>> getMenusTree() {
        List<MenuTree> menuTree = sysMenuService.getMenuTrees();
        return Result.success(menuTree);
    }

    @ApiOperation(value = "更新菜单节点")
    @PutMapping("/menuTrees")
    public ResponseEntity<Result<Object>> putMenusTree(@RequestBody SysMenu sysMenu) {
        return this.update(sysMenu);
    }
}
