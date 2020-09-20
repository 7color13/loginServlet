package controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/servlet/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
        String relativePath = (String) req.getParameter("relativePath");
        String path = req.getServletContext().getRealPath(relativePath);
        String filename = path.substring(path.lastIndexOf("\\") + 1);
        System.out.println(filename);
        resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        InputStream in = new FileInputStream(path);
        int len = 0;
        byte[] buffer = new byte[1024];
        ServletOutputStream out = resp.getOutputStream();
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }
}
