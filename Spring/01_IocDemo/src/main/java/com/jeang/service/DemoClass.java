package com.jeang.service;

import com.jeang.dao.UserDao;

/**
 * 演示构造器注入
 */
public class DemoClass {

    private final UserDao userDao;

    // 构造器注入：由 Spring 容器通过构造方法注入依赖
    public DemoClass(UserDao userDao) {
        this.userDao = userDao;
    }

    public void showUser(int id) {
        System.out.println("DemoClass 通过构造器注入的 UserDao 查询: " + userDao.getUserById(id));
    }
}
