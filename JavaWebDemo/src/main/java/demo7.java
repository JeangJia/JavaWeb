import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
// Cookie 测试
@WebServlet(urlPatterns = "/demo7")
public class demo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建Cookie对象
        Cookie cookie=new Cookie("jeang","jia");
        // 添加Cookie
        resp.addCookie(cookie);
        // 获取所有Cookie
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            System.out.println(cookies[i].getName() + ": " + cookies[i].getValue());
        }
    }
}
