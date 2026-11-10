package com.jeang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 通过@Controller注解将类标识Bean
@Controller
public class UserController {
    // 设置访问路径
    @RequestMapping("/save")
    // 设置响应结果为字符串
    @ResponseBody
    public String save() {
        System.out.println("save method");
        return "success";
    }
}
