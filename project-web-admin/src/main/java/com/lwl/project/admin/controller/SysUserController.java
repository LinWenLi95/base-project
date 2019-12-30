package com.lwl.project.admin.controller;

import com.lwl.project.admin.pojo.entity.SysUser;
import com.lwl.project.admin.service.BaseService;
import com.lwl.project.admin.service.SysUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lwl
 */
@Slf4j
@Api(tags = "用户信息管理")
@RestController
@RequestMapping("/users")
public class SysUserController extends BaseController<SysUser> {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public BaseService<SysUser> getBaseService() {
        return sysUserService;
    }

}
