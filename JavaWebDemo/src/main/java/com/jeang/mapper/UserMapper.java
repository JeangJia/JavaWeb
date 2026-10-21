package com.jeang.mapper;

import com.jeang.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /*
     * 登录查询
     * */
    @Select("select * from user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /*
     * 根据用户名查询用户
     * */
    @Select("select * from user where username = #{username}")
    User selectByUsername(@Param("username") String username);

    /*
     * 注册用户
     * */
    @Insert("insert into user (id ,username, password) values (null, #{username}, #{password})")
    boolean insert(User user);
}
