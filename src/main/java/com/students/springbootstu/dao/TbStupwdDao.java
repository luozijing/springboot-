package com.students.springbootstu.dao;

import com.students.springbootstu.entity.TbStupwd;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbStupwd)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-28 14:52:12
 */
public interface TbStupwdDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbStupwd queryById(Integer id);


    /**
     * 通过account查询单条数据
     *
     * @param account 账号
     * @return 实例对象
     */
    TbStupwd queryByAccount(String account);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbStupwd> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbStupwd 实例对象
     * @return 对象列表
     */
    List<TbStupwd> queryAll(TbStupwd tbStupwd);

    /**
     * 新增数据
     *
     * @param tbStupwd 实例对象
     * @return 影响行数
     */
    int insert(TbStupwd tbStupwd);

    /**
     * 修改数据
     *
     * @param tbStupwd 实例对象
     * @return 影响行数
     */
    int update(TbStupwd tbStupwd);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}