package com.jeang.dao;

import org.springframework.stereotype.Repository;

/**
 * @Repository：数据层组件，等价于 @Component，语义更明确
 * 括号内指定 Bean 的 id，不写则默认为类名首字母小写（userDaoImpl）
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public String getUserById(int id) {
        return "用户-" + id + "（来自数据库）";
    }
}
