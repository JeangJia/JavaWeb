import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class demo8 extends HttpServlet {
    // Session 测试

    /*
    `Session`对象功能
    ```java
    void setAttribute(String name, Object o) // 存储数据到 session 域中
    Object getAttribute(String name) // 根据 key，获取值
    void removeAttribute(String name) // 根据 key，删除该键值对
    ```
    */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建一个 Session
        HttpSession session = request.getSession();
        // 存储数据到 session 域中
        session.setAttribute("user", "zhangsan");
        // 根据 key，获取值
        Object user = session.getAttribute("user");
        // 打印用户信息
        System.out.println(user);
    }
}
