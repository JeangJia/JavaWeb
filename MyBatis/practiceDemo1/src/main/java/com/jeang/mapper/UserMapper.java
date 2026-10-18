package com.jeang.mapper;

import com.jeang.pojo.User;

import java.util.List;

public interface UserMapper {
    /*
    * 查询所有
    * */
    public List<User> selectAllUsers();

    /*
    * 根据id查询
    * */
    public User selectUserById(int id);
}
