package com.students.springbootstu.controller;

import com.students.springbootstu.common.ResponseResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorld {

    @GetMapping("/")
    String home(Model model) {

        model.addAttribute("msg", ResponseResult.error("该部分只对权限Role_role2有效"));
        return "index";
    }

    @RequestMapping("/hello")
    String home1() {
        return "Hello World! Hello World!";
    }
}
