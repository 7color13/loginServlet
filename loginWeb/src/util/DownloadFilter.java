package util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//拦截器，检测登录状态
@WebFilter(urlPatterns = {"/download.jsp","/main.jsp"})
public class DownloadFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String userName = (String) request.getSession().getAttribute("username");
        if (userName==null||userName.equals("")){
            //request.getRequestDispatcher("login.html").forward(servletRequest, servletResponse);
            request.setCharacterEncoding("UTf-8");
            response.setCharacterEncoding("UTF-8");
            request.setAttribute("msg","抱歉，您必须先登录才能访问该资源");
            request.getRequestDispatcher("error.jsp").forward(request,response);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
