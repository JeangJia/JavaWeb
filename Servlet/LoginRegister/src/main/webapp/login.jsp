<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.jeang.pojo.User" %>
<%@ page import="com.jeang.service.UserService" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%
    // 已登录或勾选过"记住我"，直接跳转首页
    User cachedUser = (User) session.getAttribute("user");
    if (cachedUser == null) {
        String rememberMe = null, cookieUsername = null, cookiePassword = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                switch (c.getName()) {
                    case "rememberMe": rememberMe = c.getValue(); break;
                    case "username": cookieUsername = c.getValue(); break;
                    case "password": cookiePassword = c.getValue(); break;
                }
            }
        }
        if ("true".equals(rememberMe) && cookieUsername != null && cookiePassword != null) {
            User user = new UserService().login(cookieUsername, cookiePassword);
            if (user != null) {
                cachedUser = user;
                session.setAttribute("user", user);
            }
        }
    }
    if (cachedUser != null) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <style>
        /* 基础重置 */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
            /* 渐变背景色，看起来更现代 */
            /*background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);*/
            background-color: #f5f5f5;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        /* 登录卡片容器 */
        .login-container {
            background-color: #ffffff;
            padding: 40px 30px;
            border-radius: 12px;
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        .login-container h2 {
            text-align: center;
            color: #333333;
            margin-bottom: 30px;
            font-size: 24px;
        }

        /* 输入框组 */
        .input-group {
            margin-bottom: 20px;
        }

        .input-group label {
            display: block;
            margin-bottom: 8px;
            color: #666666;
            font-size: 14px;
            font-weight: 500;
        }

        .input-group input {
            width: 100%;
            padding: 12px 15px;
            border: 1px solid #cccccc;
            border-radius: 8px;
            font-size: 14px;
            outline: none;
            transition: border-color 0.3s ease;
        }

        /* 输入框聚焦时的效果 */
        .input-group input:focus {
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.2);
        }

        .checkbox-group {
            display: flex;
            align-items: center;
            gap: 6px;
        }

        .checkbox-group input[type="checkbox"] {
            width: auto;
            margin: 0;
        }

        .checkbox-group label {
            display: inline;
            margin-bottom: 0;
        }

        /* 登录按钮 */
        .login-btn {
            width: 100%;
            padding: 12px;
            background-color: #667eea;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 10px;
        }

        .login-btn:hover {
            background-color: #5a6fd6;
        }

        /* 底部链接 */
        .extra-links {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
            font-size: 14px;
        }

        .extra-links a {
            color: #667eea;
            text-decoration: none;
        }

        .extra-links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>欢迎登录</h2>
    <p style="color: red; font-size: 14px; text-align: center">${login_msg}</p>
<% session.removeAttribute("login_msg"); %>
    <!-- 表单开始，实际使用时 action 填入后端的接口地址 -->
    <form action="/LoginRegister/loginServlet" method="get">
        <div class="input-group">
            <label for="username">用户名</label>
            <!-- required 属性表示必填 -->
            <input type="text" id="username" name="username" placeholder="请输入用户名"
            value="${cookie.username.value != null ? cookie.username.value : ''}" required>
        </div>

        <div class="input-group">
            <label for="password">密码</label>
            <input type="password" id="password" name="password" placeholder="请输入密码"
            value="${cookie.password.value != null ? cookie.password.value : ''}" required>
        </div>
        <div class="input-group checkbox-group">
            <input id="rememberMe" name="rememberMe" type="checkbox" value="true"
            ${cookie.rememberMe.value != null ? "checked" : ""}>
            <!-- 检查是否记住密码 -->
            <label for="rememberMe">记住我</label>
        </div>
        <button type="submit" class="login-btn">登 录</button>
    </form>

    <div class="extra-links">
        <a href="#">忘记密码？</a>
        <a href="register.jsp">没有账号？去注册</a>
    </div>
</div>

</body>
</html>