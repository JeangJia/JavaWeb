import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
    重定向两种方式：
    1.
    设置状态码和相应头
    resp.setStatus(302);
    resp.setHeader("Location", "/xxx");
    2.
    重定向到外部资源
    resp.sendRedirect("http://www.baidu.com");
*/
@WebServlet("/demo4")
public class demo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4...");
        resp.sendRedirect("/JavaWebDemo/demo3");
    }
}
