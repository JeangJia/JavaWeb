import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/demo2")
public class demo2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo2...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryString = req.getQueryString();
//        Map<String,String[]> getParameterMap()  // 获取所有参数的Map集合
//        String[] getParameterValues(String name)  // 根据名称获取参数值(数组)
//        String getParameter(String name) // 根据名称获取参数值(单个值)
        System.out.println(queryString);
        req.getParameterMap().forEach((key, value) -> {
            System.out.print(key + ": ");
            for (String v : value) {
                System.out.print(v + " ");
            }
            System.out.println();
        });
        // 从请求域中获取数据
        Object msg = req.getAttribute("msg");
        System.out.println(msg);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
        System.out.println(req.getReader().lines());
    }
}
