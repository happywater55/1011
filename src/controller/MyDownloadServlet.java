package controller;

import dao.DownloadDao;
import tools.JdbcUtil;
import vo.Download;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(urlPatterns = "/MyDownloadServlet")
public class MyDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            DownloadDao dao = new DownloadDao(JdbcUtil.getConnection());
            List<Download> list = new LinkedList<>();
            list = dao.query();
            session.setAttribute("Downlist",list);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/download.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
