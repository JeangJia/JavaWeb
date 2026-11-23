package com.jeang.controller;

import com.jeang.domain.Enter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Value("${server.port}")
    private String port;
    @Value("${enter.name}")
    private String name;
    @Value("${enter.likes[0]}")
    private String like;
    @Autowired
    private Environment env;
    @Autowired
    private Enter enter;

    @GetMapping("/{id}")
    public String getUsers(@PathVariable("id") Integer id) {
        System.out.println("get users ==>" + id);
        System.out.println("port ==>" + port);
        System.out.println("name ==>" + name);
        System.out.println("like ==>" + like);
        System.out.println("------------");
        System.out.println(env.getProperty("enter.name"));
        System.out.println(env.getProperty("enter.likes[0]"));
        System.out.println("------------");
        System.out.println(enter.toString());
        return "success";
    }
}


