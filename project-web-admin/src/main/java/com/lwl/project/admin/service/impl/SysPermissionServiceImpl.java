package com.lwl.project.admin.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwl.project.admin.dao.SysPermissionMapper;
import com.lwl.project.admin.pojo.entity.SysPermission;
import com.lwl.project.admin.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysPermissionServiceImpl extends BaseServiceImpl<SysPermission> implements SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public BaseMapper<SysPermission> getMapper() {
        return sysPermissionMapper;
    }
}
