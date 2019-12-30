//package com.lwl.test;
//
//import com.baomidou.mybatisplus.core.conditions.Wrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.lwl.project.admin.WebAdminApplication;
//import com.lwl.project.admin.dao.TbPermissionMapper;
//import com.lwl.project.admin.dao.SysUserMapper;
//import com.lwl.project.admin.pojo.TbPermission;
//import com.lwl.project.admin.pojo.TbRole;
//import com.lwl.project.admin.pojo.TbUser;
//import com.lwl.project.admin.pojo.entity.SysPermission;
//import com.lwl.project.admin.pojo.entity.SysUser;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@SpringBootTest(classes = WebAdminApplication.class)
//public class TestApplication {
//
//    @Resource
//    private SysUserMapper tbUserMapper;
//    @Resource
//    private TbPermissionMapper tbPermissionMapper;
//
//    @Test
//    public void test() {
//        List<SysUser> tbUsers = tbUserMapper.selectByMap(null);
//        System.out.println(tbUsers.size());
//    }
//
//    @Test
//    public void d() {
//        IPage<SysPermission> page = new Page<>();
//        page.setSize(10);
//        page.setCurrent(1);
//        Wrapper<SysPermission> wrapper = new QueryWrapper<>();
//        IPage<SysPermission> tbPermissionIPage = tbPermissionMapper.selectPage(page, wrapper);
//        System.out.println("");
//        // 查询方法应有过滤条件
//        // 过滤条件 ?type=1&age=16
//
//        // 允许一定的uri冗余，如 /zoos/1 与 /zoos?id=1
//
//        // 排序 ?sort=age&order=asc 指定返回结果按照哪个属性排序，以及排序顺序
//
//        // 分页 ? page=2&per_page=100 指定第几页，以及每页的记录数
//    }
//}
