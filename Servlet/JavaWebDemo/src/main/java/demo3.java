import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// request 转发
// req.getRequestDispatcher("/xxx").forward(req, resp);
// 设置传递参数 setAttribute()
// 从请求域中获取数据 getAttribute()
// 删除请求域属性 removeAttribute()
@WebServlet("/demo3")
public class demo3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo3...");
//       如果不加 doGet和doPost方法不会调用
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        // 请求转发
        // 设置请求域属性 存储数据
        req.setAttribute("msg", "hello " + username);
        // 转发
        req.getRequestDispatcher("/demo2").forward(req, resp);

        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
