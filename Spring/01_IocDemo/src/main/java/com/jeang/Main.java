package com.jeang;

import com.jeang.service.DemoClass;
import com.jeang.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 1. 启动 IoC 容器，加载配置文件
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 从容器中获取 Bean（对象由 Spring 创建并注入依赖）
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.queryUser(1001);

        DemoClass demoClass = ctx.getBean("demoClass", DemoClass.class);
        demoClass.showUser(1002);

        // 3. 验证单例：两次获取的是同一个对象
        System.out.println("是否为单例: " + (userService == ctx.getBean("userService")));
    }
}
