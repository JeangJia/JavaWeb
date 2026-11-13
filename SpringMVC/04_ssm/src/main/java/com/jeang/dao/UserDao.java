package com.jeang.dao;

import com.jeang.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    @Insert("insert into user (username, password) values (#{username},#{password})")
    public boolean save(User user);

    @Delete("delete from user where id = #{id}")
    public boolean delete(Integer id);

    @Update("update user set username = #{username}, password = #{password} where id = #{id}")
    public boolean update(User user);

    @Select("select * from user where id = #{id}")
    public User getById(Integer id);

    @Select("select * from user")
    public List<User> getAll();
}
