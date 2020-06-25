package com.students.springbootstu.dao;

import com.students.springbootstu.entity.TbStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbStudent)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 17:32:33
 */

@Mapper
public interface TbStudentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param stuid 主键
     * @return 实例对象
     */
    TbStudent queryById(Integer stuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbStudent> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbStudent 实例对象
     * @return 对象列表
     */
    List<TbStudent> queryAll(TbStudent tbStudent);

    /**
     * 新增数据
     *
     * @param tbStudent 实例对象
     * @return 影响行数
     */
    int insert(TbStudent tbStudent);

    /**
     * 修改数据
     *
     * @param tbStudent 实例对象
     * @return 影响行数
     */
    int update(TbStudent tbStudent);

    /**
     * 通过主键删除数据
     *
     * @param stuid 主键
     * @return 影响行数
     */
    int deleteById(Integer stuid);

}