package com.lwl.project.admin.service;

import com.lwl.project.admin.pojo.entity.SysUser;

public interface SysUserService extends BaseService<SysUser>{

    /**
     * 获取用户信息
     * @param userName 用户名/手机号/邮箱
     * @return SysUser
     */
    SysUser selectByName(String userName);
}
