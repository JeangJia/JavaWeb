package com.jeang.web;

import com.jeang.mapper.UserMapper;
import com.jeang.pojo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");
        // 使用mybatis
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 查询用户是否存在
        User user = userMapper.selectByUsername(username);
        resp.setHeader("content-type", "text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (user != null) {
            // 用户存在，注册失败
            writer.println("<h1>用户名已存在</h1>");
        } else {
            // 用户不存在
            if (password.equals(confirmPassword)) {
                // 密码一致，注册成功
                User u = new User();
                u.setUsername(username);
                u.setPassword(password);
                userMapper.insert(u);
                sqlSession.commit();
                writer.println("<h1>注册成功</h1>");
            } else {
                // 密码不一致，注册失败
                writer.println("<h1>两次输入密码不一致，请重新输入</h1>");
            }
        }
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
