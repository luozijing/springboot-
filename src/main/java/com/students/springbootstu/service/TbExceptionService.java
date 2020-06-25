package com.students.springbootstu.service;

import com.students.springbootstu.entity.TbException;
import java.util.List;

/**
 * (TbException)表服务接口
 *
 * @author makejava
 * @since 2020-06-14 16:29:56
 */
public interface TbExceptionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbException queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbException> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbException 实例对象
     * @return 实例对象
     */
    int insert(TbException tbException);

    /**
     * 修改数据
     *
     * @param tbException 实例对象
     * @return 实例对象
     */
    TbException update(TbException tbException);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}