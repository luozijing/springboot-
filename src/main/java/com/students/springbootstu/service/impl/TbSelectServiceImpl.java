package com.students.springbootstu.service.impl;

import com.students.springbootstu.entity.TbSelect;
import com.students.springbootstu.dao.TbSelectDao;
import com.students.springbootstu.service.TbSelectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbSelect)表服务实现类
 *
 * @author makejava
 * @since 2020-06-11 19:46:17
 */
@Service("tbSelectService")
public class TbSelectServiceImpl implements TbSelectService {
    @Resource
    private TbSelectDao tbSelectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sid 主键
     * @return 实例对象
     */
    @Override
    public TbSelect queryById(int sid) {
        return this.tbSelectDao.queryById(sid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbSelect> queryAllByLimit(int offset, int limit) {
        return this.tbSelectDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbSelect 实例对象
     * @return 实例对象
     */
    @Override
    public TbSelect insert(TbSelect tbSelect) {
        this.tbSelectDao.insert(tbSelect);
        return tbSelect;
    }

    /**
     * 修改数据
     *
     * @param tbSelect 实例对象
     * @return 实例对象
     */
    @Override
    public TbSelect update(TbSelect tbSelect) {
        this.tbSelectDao.update(tbSelect);
        return this.queryById(tbSelect.getSid());
    }

    /**
     * 通过主键删除数据
     *
     * @param sid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sid) {
        return this.tbSelectDao.deleteById(sid) > 0;
    }
}