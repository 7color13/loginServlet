package controller;

import dao.IUserDao;
import dbc.DatabaseConnection;
import factory.DAOFactory;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static Connection con;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        con = new DatabaseConnection().getConnection();
        IUserDao userDao = DAOFactory.getUserDAOInstance(con);
        User user = new User();
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);
        System.out.println("用户名：" + username + " 密码: " + password);
        HttpSession session = request.getSession();
        String vCode = (String) session.getAttribute("verifyCode");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String verifyCode = request.getParameter("userCode");
        PrintWriter pw = response.getWriter();

        try {
            if (userDao.selectOne(user) == 1 && verifyCode.equals(vCode)) {
                //response.sendRedirect("success.html");
                session.setAttribute("username", username);
                response.sendRedirect("main.jsp");
            } else {
                String message = "";
                if (userDao.selectOne(user) == 3) {
                    message += "抱歉，您输入的用户名不存在";
                }
                if (userDao.selectOne(user) == 2) {
                    message += "抱歉，您输入的密码不正确";
                }
                if (!verifyCode.equals(vCode)) {
                    message += "抱歉，您输入的验证码不正确";
                }
                request.setAttribute("msg",message);
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
