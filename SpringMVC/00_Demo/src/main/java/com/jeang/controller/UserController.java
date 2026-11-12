package com.jeang.controller;

import com.jeang.pojo.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 通过@Controller注解将类标识Bean
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    // 设置访问路径
    @RequestMapping("/save")
    // 设置响应结果为字符串
    public String save() {
        System.out.println("save method");
        return "success";
    }

    @GetMapping
    public String find(@RequestParam("id") int id) {
        System.out.println("find method, id = " + id);
        return "success";
    }

    @DeleteMapping
    public String del(@RequestParam("id") List<Integer> ids) {
        System.out.println("del method, ids = " + ids);
        return "success";
    }

    @PostMapping
    public String update(@RequestBody Role role) {
        System.out.println("update method, role = " + role);
        return "success";
    }

}