package com.students.springbootstu.dao;

import com.students.springbootstu.entity.TbCourse;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbCourse)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 19:23:15
 */

public interface TbCourseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cosid 主键
     * @return 实例对象
     */
    TbCourse queryById(Integer cosid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbCourse> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbCourse 实例对象
     * @return 对象列表
     */
    List<TbCourse> queryAll(TbCourse tbCourse);

    /**
     * 新增数据
     *
     * @param tbCourse 实例对象
     * @return 影响行数
     */
    int insert(TbCourse tbCourse);

    /**
     * 修改数据
     *
     * @param tbCourse 实例对象
     * @return 影响行数
     */
    int update(TbCourse tbCourse);

    /**
     * 通过主键删除数据
     *
     * @param cosid 主键
     * @return 影响行数
     */
    int deleteById(Integer cosid);

}