import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo6")
public class demo6 extends HttpServlet {
    /*
     * Response 响应字符数据
     * 用 PrintWriter，只能用 getWriter()，不能和 getOutputStream() 混用
     * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应类型，指定编码避免中文乱码
        resp.setContentType("text/html;charset=UTF-8");

        // 获取字符输出流
        PrintWriter writer = resp.getWriter();
        writer.write("你好demo6...");
        writer.write("<h1>你好demo6...</h1>");
    }
}
