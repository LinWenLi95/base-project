package com.lwl.project.admin.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* 系统 用户表
* @author lwl
* @since 2019/12/15
*/
@Data
public class SysUserVO implements Serializable {

    /**用户名*/
    private String username;
    /**密码，加密存储*/
    private String password;
    /**手机号*/
    private String telephone;
    /**邮箱*/
    private String email;
    /**状态 0禁用,1启动*/
    private Integer state;
    /**是否已删除*/
    private Boolean isDel;
    /**备注*/
    private String description;
    /**创建者id*/
    private Integer creatorId;
    /**创建时间*/
    private Timestamp createTime;

}
