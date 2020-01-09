package com.lwl.project.admin.pojo.dto;

import lombok.Data;

// TODO 新增修改时可传入的参数可能不同，此时可直接独立成两个独立的DTO
@Data
public class SysUserDTO {

    /**id*/
    private Integer id;
    /**用户名*/
    private String username;
    /**手机号*/
    private String phone;
    /**邮箱*/
    private String email;
    /**状态 0禁用,1启动*/
    private Integer state;
    /**备注*/
    private String description;

}
