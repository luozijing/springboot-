package com.students.springbootstu.controller;

import com.students.springbootstu.common.ResponseResult;
import com.students.springbootstu.entity.TbStudent;
import com.students.springbootstu.entity.TbStupwd;
import com.students.springbootstu.service.TbStupwdService;
import com.students.springbootstu.util.PasswordEncoderUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * (TbStupwd)表控制层
 *
 * @author makejava
 * @since 2020-06-28 14:52:12
 */
@RestController
@RequestMapping("tbStupwd")
public class TbStupwdController {


    /**
     * 服务对象
     */
    @Resource
    private TbStupwdService tbStupwdService;



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbStupwd selectOne(Integer id) {
        return this.tbStupwdService.queryById(id);
    }


    //http://localhost/tbStupwd/saveone?stuid=1004&stuaccount=abc&stupwd=abc&role=role1
    @GetMapping("saveOne")
    @ApiOperation(value = "保存学生账号")
    public ResponseResult<TbStupwd> saveOne( @Valid TbStupwd tbStupwd){
        //加密
        tbStupwd.setStupwd(PasswordEncoderUtil.passwordEncoder(tbStupwd.getStupwd()));
        TbStupwd stu = this.tbStupwdService.insert(tbStupwd);
        return ResponseResult.success(stu);
    }


}