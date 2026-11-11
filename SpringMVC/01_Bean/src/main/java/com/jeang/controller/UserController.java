package com.jeang.controller;

import com.jeang.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    // 请求参数接收
    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "age", defaultValue = "0") int age) {
        System.out.println("save running...");
        System.out.println("name ==> " + name);
        System.out.println("age ==> " + age);
        return "{'msg':'success'}";
    }

    // POJO 参数接收
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user) {
        System.out.println("pojoParam running...");
        System.out.println("name ==> " + user.getName());
        System.out.println("age ==> " + user.getAge());
        return "{'msg':'success'}";
    }

    // 数组参数
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(@RequestParam(value = "name", required = false) String[] names) {
        System.out.println("arrayParam running...");
        System.out.println(Arrays.toString(names));
        return "{'msg':'success'}";
    }

    // 集合参数
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam(value = "name", required = false) List<String> names) {
        System.out.println("listParam running...");
        // println 内部做了 null 判断，参数没传时打印 null 而不是抛 NPE
        System.out.println(names);
        return "{'msg':'success'}";
    }

    // 集合参数: JSON 格式
    @RequestMapping("/jsonParam")
    @ResponseBody
    public String jsonParam(@RequestBody List<String> names) {
        System.out.println("jsonParam running...");
        System.out.println(names);
        return "{'msg':'success'}";
    }

    // 日期参数
    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        System.out.println("dateParam running...");
        System.out.println("date ==> " + date);
        return "{'msg':'success'}";
    }

    // 响应 JSON 数据(对象集合转 JSON 数组)
    @RequestMapping("/jsonResponse")
    @ResponseBody
    public List<User> jsonResponse() {
        System.out.println("jsonResponse running...");
        User user1 = new User("张三", 18);
        User user2 = new User("李四", 19);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        return userList;
    }
}
