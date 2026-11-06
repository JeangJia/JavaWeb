package com.jeang.dao;

import org.springframework.stereotype.Repository;

/**
 * 第二个 UserDao 实现：用于演示「同类型多个 Bean 时按名称注入」
 * 注入方需使用 @Autowired + @Qualifier("mockUserDao")
 */
@Repository("mockUserDao")
public class MockUserDaoImpl implements UserDao {

    @Override
    public String getUserById(int id) {
        return "用户-" + id + "（来自模拟数据）";
    }
}
