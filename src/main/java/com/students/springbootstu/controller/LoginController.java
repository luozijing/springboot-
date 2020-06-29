package com.students.springbootstu.controller;

import com.students.springbootstu.entity.TbStupwd;
import com.students.springbootstu.service.TbStupwdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbStupwd)表控制层
 *
 * @author makejava
 * @since 2020-06-28 14:52:12
 */
@Controller

public class LoginController {
    /**
     * 服务对象
     */
    @Resource
    private TbStupwdService tbStupwdService;

    /**
     * @return login页面
     */
    @GetMapping("/login")
    public String selectOne() {
        return "login";
    }


}