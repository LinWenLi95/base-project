package com.lwl.project.admin.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import java.sql.Timestamp;

/**
* 系统 用户-角色表
* @author lwl
* @since 2019/12/15
*/
@Data
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**id*/
    private Integer id;
    /**用户ID*/
    private Integer userId;
    /**角色ID*/
    private Integer roleId;
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
    /**更新者id*/
    private Integer updaterId;
    /**更新时间*/
    private Timestamp updateTime;
}
