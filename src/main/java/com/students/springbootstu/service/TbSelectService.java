package com.students.springbootstu.service;

import com.students.springbootstu.entity.TbSelect;
import java.util.List;

/**
 * (TbSelect)表服务接口
 *
 * @author makejava
 * @since 2020-06-11 19:46:17
 */
public interface TbSelectService {

    /**
     * 通过ID查询单条数据
     *
     * @param sid 主键
     * @return 实例对象
     */
    TbSelect queryById(int sid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbSelect> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbSelect 实例对象
     * @return 实例对象
     */
    TbSelect insert(TbSelect tbSelect);

    /**
     * 修改数据
     *
     * @param tbSelect 实例对象
     * @return 实例对象
     */
    TbSelect update(TbSelect tbSelect);

    /**
     * 通过主键删除数据
     *
     * @param sid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sid);

}