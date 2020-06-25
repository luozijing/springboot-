package com.students.springbootstu.service.impl;

import com.students.springbootstu.entity.TbCourse;
import com.students.springbootstu.dao.TbCourseDao;
import com.students.springbootstu.service.TbCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbCourse)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 19:23:15
 */
@Service("tbCourseService")
public class TbCourseServiceImpl implements TbCourseService {
    @Resource
    private TbCourseDao tbCourseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cosid 主键
     * @return 实例对象
     */
    @Override
    public TbCourse queryById(Integer cosid) {
        return this.tbCourseDao.queryById(cosid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbCourse> queryAllByLimit(int offset, int limit) {
        return this.tbCourseDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbCourse 实例对象
     * @return 实例对象
     */
    @Override
    public TbCourse insert(TbCourse tbCourse) {
        this.tbCourseDao.insert(tbCourse);
        return tbCourse;
    }

    /**
     * 修改数据
     *
     * @param tbCourse 实例对象
     * @return 实例对象
     */
    @Override
    public TbCourse update(TbCourse tbCourse) {
        this.tbCourseDao.update(tbCourse);
        return this.queryById(tbCourse.getCosid());
    }

    /**
     * 通过主键删除数据
     *
     * @param cosid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer cosid) {
        return this.tbCourseDao.deleteById(cosid) > 0;
    }
}