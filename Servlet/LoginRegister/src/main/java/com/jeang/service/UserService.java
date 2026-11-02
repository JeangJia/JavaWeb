package com.jeang.service;

import com.jeang.mapper.UserMapper;
import com.jeang.pojo.User;
import com.jeang.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /*
     * 登录查询用户
     * */
    public User login(String username, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User result = userMapper.selectUser(username, password);
        sqlSession.close();
        return result;
    }

    /*
     * 根据用户名查询用户
     * */
    public User selectByUsername(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User result = userMapper.selectByUsername(username);
        sqlSession.close();
        return result;
    }

    /*
     * 注册用户
     * */
    public boolean register(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u = userMapper.selectByUsername(user.getUsername());
        if (u != null) {
            return false;
        }
        boolean result = userMapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

}
