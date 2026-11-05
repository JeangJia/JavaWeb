package com.jeang.dao;

public class UserDaoImpl implements UserDao {

    @Override
    public String getUserById(int id) {
        return "用户-" + id;
    }
}
