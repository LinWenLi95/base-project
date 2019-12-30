package com.lwl.project.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwl.project.admin.dao.SysMenuMapper;
import com.lwl.project.admin.pojo.entity.SysMenu;
import com.lwl.project.admin.pojo.vo.MenuTree;
import com.lwl.project.admin.pojo.vo.MenuTreeNode;
import com.lwl.project.admin.service.SysMenuService;
import com.lwl.project.admin.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> implements SysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public BaseMapper<SysMenu> getMapper() {
        return sysMenuMapper;
    }

    @Override
    public Integer add(SysMenu sysMenu) {
        sysMenu.setParentId(0);
        sysMenu.setIsDel(false);
        sysMenu.setCreatorId(0);
        sysMenu.setUpdaterId(0);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        sysMenu.setCreateTime(timestamp);
        sysMenu.setUpdateTime(timestamp);
        return getMapper().insert(sysMenu);
    }

    @Override
    public List<MenuTree> getMenuTrees() {
        // 获取实体属性
        Field[] fields = MenuTreeNode.class.getDeclaredFields();
        String[] columns = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            columns[i] = StringUtils.camelToUnderscore(fields[i].getName());
        }
        // 过滤条件,只返回指定属性
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();
        wrapper.select(columns);
        List<SysMenu> sysMenus = sysMenuMapper.selectList(wrapper);
        // 转数据格式
        return getTrees(sysMenus);
    }

    /**
     * 列表转树
     * @param treeNodes
     * @return
     */
    public List<MenuTree> getTrees(List<SysMenu> treeNodes) {
        // 获取根节点列表
        List<MenuTree> roots = new ArrayList<>();
        List<SysMenu> nodes = new ArrayList<>();
        for (SysMenu treeNode : treeNodes) {
            if (treeNode.isRoot()) {
                MenuTree tree = new MenuTree();
                BeanUtils.copyProperties(treeNode, tree);
                roots.add(tree);
            } else {
                nodes.add(treeNode);
            }
        }
        // 获取节点的子节点
        for (MenuTree root : roots) {
            root.setChildren(findChild(root.getId(), nodes));
        }
        return roots;
    }

    /**
     * 获取指定节点的子节点列表
     * @param parentNodeId 父节点id
     * @param nodes 节点列表
     * @return 子节点列表
     */
    public List<MenuTree> findChild(Integer parentNodeId, List<SysMenu> nodes) {
        List<MenuTree> child = new ArrayList<>();
        // 迭代递归
        for (SysMenu treeNode : nodes) {
            if (treeNode.getParentId().equals(parentNodeId)) {
                // 迭代器必须在递归之前执行remove，这样在当次递归时传入的nodes数量才会-1，如果不执行remove，最终循环次数固定
                MenuTree tree = new MenuTree();
                BeanUtils.copyProperties(treeNode, tree);
                tree.setChildren(findChild(treeNode.getId(), nodes));
                child.add(tree);
            }
        }
        return child;
    }
}
