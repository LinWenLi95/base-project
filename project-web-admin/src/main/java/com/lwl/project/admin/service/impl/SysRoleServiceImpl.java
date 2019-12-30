package com.lwl.project.admin.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwl.project.admin.dao.SysRoleMapper;
import com.lwl.project.admin.pojo.entity.SysRole;
import com.lwl.project.admin.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {

    @Resource
    private SysRoleMapper tbRoleMapper;

    @Override
    public BaseMapper<SysRole> getMapper() {
        return tbRoleMapper;
    }
}
