package com.students.springbootstu.service.impl;

import com.students.springbootstu.entity.TbStudent;
import com.students.springbootstu.dao.TbStudentDao;
import com.students.springbootstu.service.TbStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbStudent)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 17:32:33
 */
@Service("tbStudentService")
public class TbStudentServiceImpl implements TbStudentService {
    @Resource
    private TbStudentDao tbStudentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param stuid 主键
     * @return 实例对象
     */
    @Override
    public TbStudent queryById(int stuid) {
        return this.tbStudentDao.queryById(stuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbStudent> queryAllByLimit(int offset, int limit) {
        return this.tbStudentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbStudent 实例对象
     * @return 实例对象
     */
    @Override
    public TbStudent insert(TbStudent tbStudent) {
        this.tbStudentDao.insert(tbStudent);
        return tbStudent;
    }

    /**
     * 修改数据
     *
     * @param tbStudent 实例对象
     * @return 实例对象
     */
    @Override
    public TbStudent update(TbStudent tbStudent) {
        this.tbStudentDao.update(tbStudent);
        return this.queryById(tbStudent.getStuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param stuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer stuid) {
        return this.tbStudentDao.deleteById(stuid) > 0;
    }
}