import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/demo1")
public class demo1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo1...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求行
//        - `String getMethod()`：获取请求方式：`GET`
        System.out.println(req.getMethod());
//        - `String getContextPath()`：获取虚拟目录(项目访问路径)：`/request-demo`
        System.out.println(req.getContextPath());
//        - `StringBuffer getRequestURL()`：获取 URL(统一资源定位符)：`http://localhost:8080/request-demo/req1`
        System.out.println(req.getRequestURL());
//        - `String getRequestURI()`：获取 URI(统一资源标识符)：`/request-demo/req1`
        System.out.println(req.getRequestURI());
//        - `String getQueryString()`：获取请求参数（GET 方式）：`username=zhangsan&password=123`
        System.out.println(req.getQueryString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求体
        System.out.println(req.getReader().readLine());
    }
}
