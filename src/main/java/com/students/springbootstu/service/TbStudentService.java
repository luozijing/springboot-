package com.students.springbootstu.service;

import com.students.springbootstu.common.page.PageRequest;
import com.students.springbootstu.common.page.PageResult;
import com.students.springbootstu.entity.TbStudent;
import java.util.List;

/**
 * (TbStudent)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 17:32:33
 */
public interface TbStudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param stuid 主键
     * @return 实例对象
     */
    TbStudent queryById(int stuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbStudent> queryAllByLimit(int offset, int limit);

    /**
     * 查询全部数据
     *
     * @return 对象列表
     */
    List<TbStudent> queryAll();

    /**
     * 分页查询数据
     *
     * @return 对象列表
     */
    PageResult queryByPages(PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbStudent 实例对象
     * @return 实例对象
     */
    TbStudent insert(TbStudent tbStudent);

    /**
     * 修改数据
     *
     * @param tbStudent 实例对象
     * @return 实例对象
     */
    TbStudent update(TbStudent tbStudent);

    /**
     * 通过主键删除数据
     *
     * @param stuid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer stuid);

}