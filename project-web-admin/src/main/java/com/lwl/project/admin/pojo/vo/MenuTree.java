package com.lwl.project.admin.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * 菜单树对象 el-tree标签的数据结构
 * @author lwl
 */
@Data
public class MenuTree {

    private Integer id;
    /**父菜单id（一级菜单的父id默认为0）*/
    private Integer parentId;
    /**菜单中文名称*/
    private String name;
    private List<MenuTree> children;

}
