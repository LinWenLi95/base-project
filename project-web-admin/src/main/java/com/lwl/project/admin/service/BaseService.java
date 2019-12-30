package com.lwl.project.admin.service;

import java.util.List;
import java.util.Map;

/**
 * 通用service，表对象的service接口继承此接口
 * @author lwl
 * @param <T>
 */
public interface BaseService<T> {

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
