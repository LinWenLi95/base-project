package com.lwl.project.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;

/**
 * 通用service，表对象的service接口继承此接口
 * @author lwl
 * @param <T>
 */
public interface BaseService<T> {

    /**
     * 分页查询（TODO 缺少条件）
     * @param current
     * @param size
     * @return
     */
    IPage<T> selectPage(Integer current, Integer size);

    /**
     * 获取对象数量
     * @param paramMap 查询条件
     * @return Integer
     */
    Integer selectCountByMap(Map<String, Object> paramMap);

    /**
     * 获取对象信息
     * @param id 用户id
     * @return T
     */
    T selectById(Integer id);

    /**
     * 获取对象列表
     * @param paramMap 查询条件
     * @return List<T>
     */
    List<T> selectByMap(Map<String, Object> paramMap);

    /**
     * 添加对象信息
     * @param t 要添加的对象数据
     * @return Integer 1成功，0失败
     */
    Integer add(T t);

    /**
     * 更新对象信息
     * @param t 要更新的对象信息
     * @return Integer 1成功，0失败
     */
    Integer update(T t);

    /**
     * 删除对象信息
     * @param id 对象id
     * @return Integer 1成功，0失败
     */
    Integer delById(Integer id);

}
