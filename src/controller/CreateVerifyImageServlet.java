package controller;

import dao.CreateVerificationCodeImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(urlPatterns = "/CreateImage")
public class CreateVerifyImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CreateVerificationCodeImage createVerificationCodeImage = new CreateVerificationCodeImage();

        String vCode = createVerificationCodeImage.createCode();
        HttpSession session = request.getSession();

        session.setAttribute("verityCode", vCode);
        //将随机码存入session
        response.setContentType("img/jpeg");

        response.setHeader("Pragma","No-cache");

        response.setHeader("Cache-Control","no-cache");
        //设置无缓存

        response.setDateHeader("Expires",0);
        //设置验证码失效时间


        BufferedImage image = createVerificationCodeImage.CreateImage(vCode);
        ServletOutputStream out = response.getOutputStream();
        //获取字节流输出对象
        ImageIO.write(image,"JPEG",out);
        //以字节流发送过去，交给img的src属性去解析
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
