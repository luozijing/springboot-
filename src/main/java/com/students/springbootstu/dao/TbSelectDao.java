package com.students.springbootstu.dao;

import com.students.springbootstu.entity.TbSelect;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbSelect)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-11 19:46:16
 */
public interface TbSelectDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sid 主键
     * @return 实例对象
     */
    TbSelect queryById(int sid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbSelect> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbSelect 实例对象
     * @return 对象列表
     */
    List<TbSelect> queryAll(TbSelect tbSelect);

    /**
     * 新增数据
     *
     * @param tbSelect 实例对象
     * @return 影响行数
     */
    int insert(TbSelect tbSelect);

    /**
     * 修改数据
     *
     * @param tbSelect 实例对象
     * @return 影响行数
     */
    int update(TbSelect tbSelect);

    /**
     * 通过主键删除数据
     *
     * @param sid 主键
     * @return 影响行数
     */
    int deleteById(Integer sid);

}