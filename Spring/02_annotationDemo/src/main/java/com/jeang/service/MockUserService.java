package com.jeang.service;

import com.jeang.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 演示：同类型多个实现时，通过 @Qualifier 选择另一个实现（模拟数据，常用于本地调试）
 */
@Service
public class MockUserService {

    @Autowired
    @Qualifier("mockUserDao")
    private UserDao userDao;

    public void queryUser(int id) {
        System.out.println("模拟查询结果: " + userDao.getUserById(id));
    }
}
