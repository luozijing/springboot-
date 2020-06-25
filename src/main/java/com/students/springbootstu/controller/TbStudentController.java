package com.students.springbootstu.controller;

import com.students.springbootstu.common.ResponseResult;
import com.students.springbootstu.entity.TbStudent;
import com.students.springbootstu.entity.query.QueryId;
import com.students.springbootstu.log.LogAspect;
import com.students.springbootstu.service.TbStudentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * (TbStudent)表控制层
 *
 * @author makejava
 * @since 2020-06-11 17:32:36
 */
@RestController
@Slf4j
@RequestMapping("tbStudent")
public class TbStudentController {
    /**
     * 服务对象
     */
    @Resource
    private TbStudentService tbStudentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ApiOperation(value = "查询学生")
    public ResponseResult<TbStudent> selectOne(@Valid QueryId id) {
        TbStudent stu = this.tbStudentService.queryById(Integer.parseInt(id.getId()));
        return ResponseResult.success(stu);
    }

    //http://localhost/tbStudent/saveone?stuName=jack&stuSex=1&stuBirth=2014-03-05 10:57:51&stuAdr=北京
    @GetMapping("saveOne")
    @ApiOperation(value = "保存学生")
    public ResponseResult<TbStudent> saveOne(@RequestBody @Valid TbStudent student){
        TbStudent stu =  this.tbStudentService.insert(student);
        return ResponseResult.success(stu);
    }

    @GetMapping("log")
    @LogAspect("测试")
    public String log(String d, int b){
        log.debug("---------------debug---------------");
        log.info("---------------info---------------");
        log.warn("---------------warn---------------");
        return "d";
    }

}