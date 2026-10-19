package com.jeang.mapper;

import com.jeang.pojo.User;
import org.apache.ibatis.annotations.Param;

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

    /*
    * 筛选用户
    * */
    public List<User> filterUsers(@Param("name") String name, @Param("age") int age);

    /*
    * 添加用户
    * */
    public boolean addUser(User user);

    /*
    * 删除用户
    * */
    public boolean deleteUser(int id);

    /*
    * 批量删除
    * */
    public boolean deleteUsersList(@Param("ids") int[] ids);
}
