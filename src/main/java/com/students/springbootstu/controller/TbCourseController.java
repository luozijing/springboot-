package com.students.springbootstu.controller;

import com.students.springbootstu.entity.TbCourse;
import com.students.springbootstu.service.TbCourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbCourse)表控制层
 *
 * @author makejava
 * @since 2020-06-11 19:23:15
 */
@RestController
@RequestMapping("tbCourse")
public class TbCourseController {
    /**
     * 服务对象
     */
    @Resource
    private TbCourseService tbCourseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbCourse selectOne(Integer id) {
        return this.tbCourseService.queryById(id);
    }

}