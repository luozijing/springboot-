package com.students.springbootstu.dao;

import com.students.springbootstu.entity.TbException;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbException)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-14 16:29:56
 */
public interface TbExceptionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbException queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbException> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbException 实例对象
     * @return 对象列表
     */
    List<TbException> queryAll(TbException tbException);

    /**
     * 新增数据
     *
     * @param tbException 实例对象
     * @return 影响行数
     */
    int insert(TbException tbException);

    /**
     * 修改数据
     *
     * @param tbException 实例对象
     * @return 影响行数
     */
    int update(TbException tbException);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}