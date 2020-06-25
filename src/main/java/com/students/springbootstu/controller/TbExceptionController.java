package com.students.springbootstu.controller;

import com.students.springbootstu.entity.TbException;
import com.students.springbootstu.entity.query.QueryId;
import com.students.springbootstu.service.TbExceptionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * (TbException)表控制层
 *
 * @author makejava
 * @since 2020-06-14 16:29:57
 */
@RestController
@RequestMapping("tbException")
public class TbExceptionController {
    /**
     * 服务对象
     */
    @Resource
    private TbExceptionService tbExceptionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbException selectOne(@Valid QueryId id) {
        return this.tbExceptionService.queryById(Integer.parseInt(id.getId()));
    }

}