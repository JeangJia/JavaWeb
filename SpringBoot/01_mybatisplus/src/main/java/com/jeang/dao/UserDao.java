package com.jeang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeang.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
