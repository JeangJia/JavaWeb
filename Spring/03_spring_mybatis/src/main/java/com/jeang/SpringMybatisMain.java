package com.jeang;

import com.jeang.mapper.UserMapper;
import com.jeang.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Spring 整合 MyBatis 后的用法：
 * 对比 Main.java（纯 MyBatis），不再需要手动构建 SqlSessionFactory / SqlSession，
 * 直接从 Spring 容器中获取 Mapper 代理即可。
 */
public class SpringMybatisMain {
    public static void main(String[] args) {
        // 1. 启动 Spring 容器（内部自动创建数据源、SqlSessionFactory、Mapper 代理）
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 直接注入/获取 Mapper，无需写任何 MyBatis 样板代码
        UserMapper userMapper = ctx.getBean(UserMapper.class);
        List<User> users = userMapper.selectAllUsers();
        users.forEach(System.out::println);
    }
}
