package com.jeang;

import com.jeang.mapper.UserMapper;
import com.jeang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
// 1. 读取全局配置，构建 SqlSessionFactory（全局唯一，随应用创建一次）
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

// 2. 获取 SqlSession（与数据库交互的会话），true = 自动提交事务（默认 false 需手动 commit）
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

// 3. 获取 Mapper 代理对象并调用方法
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAllUsers();
        System.out.println(userList.toString());

        sqlSession.close();
    }
}
