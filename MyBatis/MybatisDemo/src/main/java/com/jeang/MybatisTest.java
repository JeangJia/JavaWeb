package com.jeang;

import com.jeang.mapper.userMapper;
import com.jeang.pojo.student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper userMapper = sqlSession.getMapper(userMapper.class);
        List<student> students = userMapper.selectAll();
        for (student student : students) {
            System.out.println(student);
        }
    }
}
