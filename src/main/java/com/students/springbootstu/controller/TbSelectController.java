package com.students.springbootstu.controller;

import com.students.springbootstu.entity.TbSelect;
import com.students.springbootstu.service.TbSelectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbSelect)表控制层
 *
 * @author makejava
 * @since 2020-06-11 19:46:18
 */
@RestController
@RequestMapping("tbSelect")
public class TbSelectController {
    /**
     * 服务对象
     */
    @Resource
    private TbSelectService tbSelectService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbSelect selectOne(Integer id) {
        return this.tbSelectService.queryById(id);
    }
}