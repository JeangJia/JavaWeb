package com.jeang.mapper;

import com.jeang.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> selectAllUsers();
}
