package com.jeang.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 清除 cookie 中的用户名、密码、记住我标记（path 需与写入时一致）
        for (String name : new String[]{"username", "password", "rememberMe"}) {
            Cookie cookie = new Cookie(name, "");
            cookie.setMaxAge(0);
            cookie.setPath(req.getContextPath());
            resp.addCookie(cookie);
        }
        // 销毁会话
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}