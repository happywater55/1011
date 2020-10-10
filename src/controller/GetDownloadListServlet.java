package controller;

import dao.DownloadDao;
import tools.JdbcUtil;
import vo.Download;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/servlet/download")
public class GetDownloadListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String path = request.getServletContext().getRealPath("/files/wtu.docx");
////        获取文件的绝对路径
//        String fileName = path.substring(path.lastIndexOf("\\") + 1);
////        获取文件名
//        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
////        设置content-disposition响应头控制浏览器以下载的形式打开文件
//        InputStream in = new FileInputStream(path);
//        int len = 0;
//
//        byte[] buffer = new byte[1024];
//
//        ServletOutputStream outputStream = response.getOutputStream();
////        获取outputstream对象
//        while ((len = in.read(buffer)) != -1) {
//            outputStream.write(buffer, 0, len);
//        }
//        in.close();
//        outputStream.close();
        //获取session对象
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        //获取id
        //查询此id文档
        try {
            DownloadDao dao = new DownloadDao(JdbcUtil.getConnection());
            Download download = dao.getById(Integer.parseInt(id));
            if(download == null){
                //无此id文档
                String error = "无此id文档!!!";
                session.setAttribute("error",error);
                //跳转到error页面
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
            else {
                //有该id文档
                String path = request.getServletContext().getRealPath(download.getPath());
//        获取文件的绝对路径
                String fileName = path.substring(path.lastIndexOf("\\") + 1);
//        获取文件名
                response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
//        设置content-disposition响应头控制浏览器以下载的形式打开文件
                InputStream in = new FileInputStream(path);
                int len = 0;

                byte[] buffer = new byte[1024];

                ServletOutputStream outputStream = response.getOutputStream();
//        获取outputstream对象
                while ((len = in.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
                in.close();
                outputStream.close();
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
