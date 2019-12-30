package com.lwl.project.admin.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import java.sql.Timestamp;

/**
* 系统 权限表
* @author lwl
* @since 2019/12/15
*/
@Data
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**id*/
    private Integer id;
    /**权限标题*/
    private String title;
    /**授权路径*/
    private String url;
    /**请求类型
0:GET,1:POST,2:PUT,3:DELETE,4:OPTIONS,5:HEAD,6:TRACE,7:CONNECT*/
    private Integer type;
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
