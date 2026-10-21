package com.jeang.mapper;

import com.jeang.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /*
    * 登录查询
    * */
    @Select("select * from user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);
}
