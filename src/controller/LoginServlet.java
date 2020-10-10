package controller;

import dao.UserDao;
import tools.JdbcUtil;
import tools.Md5;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String vCode = request.getParameter("vCode");
        String remember = request.getParameter("Remember");

        System.out.println(remember);
//        if(remember!=null){
//            //记住登录信息
//        }

        HttpSession session = request.getSession();


        if (vCode.equalsIgnoreCase((String) session.getAttribute("verityCode"))) {
            //验证码正确

            //验证用户名密码
            try {
                UserDao userDao = new UserDao(JdbcUtil.getConnection());
                User user = userDao.getByUsername(username);
//                System.out.println("asdfsa");
//                System.out.println(user.toString());

                if (user==null){
                    //无用户
                    //往session里面设置错误信息
                    String error = "无此用户";
                    request.setAttribute("error",error);
                }
                else{
                    if (password.equals(user.getPassword())){
                        //密码正确
                    }
                    else {
                        String error = "密码错误";
                        request.setAttribute("error",error);
                        //密码错误
                    }
                }
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        else{
            //验证码错误
//            System.out.println(vCode);
//            System.out.println(session.getAttribute("verityCode"));
            String error = "验证码错误";
            request.setAttribute("error",error);

        }
        if(request.getAttribute("error") != null){
            //有错误
            System.out.println(request.getAttribute("error"));
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
        else {
            //无错误

//            response.addHeader("Set-Cookie","");

            Cookie cookie = new Cookie("loginAlready",username);
            if(!remember.equals("1")){
                cookie.setMaxAge(0);
                System.out.println("if");

                response.addCookie(cookie);
            }
            else {
                //记住登录信息
                System.out.println("else");
                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
            }

//            cookie.setDomain();


//            System.out.println("qwercookie:"+cookie.getValue());
//            Cookie[] c = request.getCookies();

            session.setAttribute("username",username);
//            System.out.println();
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
