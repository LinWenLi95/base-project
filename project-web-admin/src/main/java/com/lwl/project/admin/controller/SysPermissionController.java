package com.lwl.project.admin.controller;

import com.lwl.project.admin.pojo.entity.SysPermission;
import com.lwl.project.admin.pojo.entity.SysRole;
import com.lwl.project.admin.service.BaseService;
import com.lwl.project.admin.service.SysPermissionService;
import com.lwl.project.admin.service.SysRoleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwl
 */
@Slf4j
@Api(tags = "权限管理")
@RestController
@RequestMapping("/permissions")
public class SysPermissionController extends BaseController<SysPermission> {

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public BaseService<SysPermission> getBaseService() {
        return sysPermissionService;
    }
}
