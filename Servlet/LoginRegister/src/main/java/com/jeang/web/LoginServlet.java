package com.jeang.web;

import com.jeang.pojo.User;
import com.jeang.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");
        User user = userService.login(username, password);
        if (user != null) {
            // 登录成功
            // 是否记住
            if("true".equals(rememberMe)){
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);
                Cookie rememberMeCookie = new Cookie("rememberMe", "true");
                usernameCookie.setMaxAge(60 * 60 * 24 * 7);
                passwordCookie.setMaxAge(60 * 60 * 24 * 7);
                rememberMeCookie.setMaxAge(60 * 60 * 24 * 7);
                usernameCookie.setPath(req.getContextPath());
                passwordCookie.setPath(req.getContextPath());
                rememberMeCookie.setPath(req.getContextPath());
                resp.addCookie(usernameCookie);
                resp.addCookie(passwordCookie);
                resp.addCookie(rememberMeCookie);
            } else {
                Cookie usernameCookie = new Cookie("username", "");
                Cookie passwordCookie = new Cookie("password", "");
                Cookie rememberMeCookie = new Cookie("rememberMe", "");
                usernameCookie.setMaxAge(0);
                passwordCookie.setMaxAge(0);
                rememberMeCookie.setMaxAge(0);
                usernameCookie.setPath(req.getContextPath());
                passwordCookie.setPath(req.getContextPath());
                rememberMeCookie.setPath(req.getContextPath());
                resp.addCookie(usernameCookie);
                resp.addCookie(passwordCookie);
                resp.addCookie(rememberMeCookie);
            }
            HttpSession session = req.getSession();
            // 将用户信息存储到会话中，方便后续请求获取
            session.setAttribute("user", user);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/index.jsp");
        } else {
            // 登录失败
            req.setAttribute("login_msg", "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
