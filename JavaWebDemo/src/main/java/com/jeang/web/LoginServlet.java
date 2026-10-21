package com.jeang.web;

import com.jeang.mapper.UserMapper;
import com.jeang.pojo.User;
import com.jeang.util.SqlSessionFactoryUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // mybatis
        // String resource = "mybatis-config.xml";
        // InputStream inputStream = Resources.getResourceAsStream(resource);
        // SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        // 从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 从SqlSession中获取Mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.select(username, password);
        sqlSession.close();

        resp.setHeader("content-type", "text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (user != null) {
            writer.println("<h1>登录成功</h1>");
            writer.println("<p>欢迎，" + user.getUsername() + "！</p>");
        } else {
            writer.println("<h1>登录失败</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
