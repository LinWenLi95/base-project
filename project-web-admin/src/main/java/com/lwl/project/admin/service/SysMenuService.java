package com.lwl.project.admin.service;

import com.lwl.project.admin.pojo.entity.SysMenu;
import com.lwl.project.admin.pojo.vo.MenuTree;
import com.lwl.project.admin.pojo.vo.MenuTreeNode;

import java.util.List;

public interface SysMenuService extends BaseService<SysMenu>  {

    /**
     * 获取菜单树节点列表
     * @return List<MenuTreeNode>
     */
    List<MenuTree> getMenuTrees();
}
