package com.jeang.web;

import com.jeang.pojo.User;
import com.jeang.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");
        User user = userService.selectByUsername(username);
        if (user == null) {
            // 用户名可注册
            if (password.equals(confirmPassword)) {
                // 密码一致，注册成功
                userService.register(new User(null, username, password));
                req.setAttribute("login_msg", "注册成功");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else {
                // 密码不一致，注册失败
                req.setAttribute("register_error", "密码不一致");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }
        } else {
            // 用户名已存在
            req.setAttribute("register_error", "用户名已存在");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
