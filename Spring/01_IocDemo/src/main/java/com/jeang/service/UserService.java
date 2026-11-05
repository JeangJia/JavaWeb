package com.jeang.service;

import com.jeang.dao.UserDao;

/**
 * 演示 Setter 注入 + 属性注入
 */
public class UserService {

    private UserDao userDao;
    private String appName;

    // Setter 注入：由 Spring 容器调用 set 方法注入依赖
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void queryUser(int id) {
        System.out.println("[" + appName + "] 查询到: " + userDao.getUserById(id));
    }
}
