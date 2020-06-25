package com.students.springbootstu.service.impl;

import com.students.springbootstu.entity.TbException;
import com.students.springbootstu.dao.TbExceptionDao;
import com.students.springbootstu.service.TbExceptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbException)表服务实现类
 *
 * @author makejava
 * @since 2020-06-14 16:29:56
 */
@Service("tbExceptionService")
public class TbExceptionServiceImpl implements TbExceptionService {
    @Resource
    private TbExceptionDao tbExceptionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbException queryById(Integer id) {
        return this.tbExceptionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbException> queryAllByLimit(int offset, int limit) {
        return this.tbExceptionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbException 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(TbException tbException) {
        return this.tbExceptionDao.insert(tbException);
    }

    /**
     * 修改数据
     *
     * @param tbException 实例对象
     * @return 实例对象
     */
    @Override
    public TbException update(TbException tbException) {
        this.tbExceptionDao.update(tbException);
        return this.queryById(tbException.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tbExceptionDao.deleteById(id) > 0;
    }
}