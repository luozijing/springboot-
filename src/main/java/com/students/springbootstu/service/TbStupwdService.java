package com.students.springbootstu.service;

import com.students.springbootstu.entity.TbStupwd;
import java.util.List;

/**
 * (TbStupwd)表服务接口
 *
 * @author makejava
 * @since 2020-06-28 14:52:12
 */
public interface TbStupwdService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbStupwd queryById(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @param account 账号名称
     * @return 实例对象
     */
    TbStupwd queryByStuAccount(String account);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbStupwd> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbStupwd 实例对象
     * @return 实例对象
     */
    TbStupwd insert(TbStupwd tbStupwd);

    /**
     * 修改数据
     *
     * @param tbStupwd 实例对象
     * @return 实例对象
     */
    TbStupwd update(TbStupwd tbStupwd);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}