import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/demo5")
public class demo5 extends HttpServlet {
    /*
     * Response 响应字节数据（图片）
     * 只能用 getOutputStream()，不能和 getWriter() 混用
     * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 图片响应类型
        resp.setContentType("image/jpeg");

        // 2. 用绝对路径读取图片
        String realPath = getServletContext().getRealPath("/jeang.jpeg");
        FileInputStream fis = new FileInputStream(realPath);

        // 3. 只用字节输出流
        ServletOutputStream os = resp.getOutputStream();
//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = fis.read(bytes)) != -1) {
//            os.write(bytes, 0, len);
//        }
        IOUtils.copy(fis, os);
        fis.close();
    }
}
