package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PermissionFilter implements Filter {
    private String notCheckPath;//从web.xml

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("Filter init");
        notCheckPath = filterConfig.getInitParameter("notCheckPath");
//        System.out.println(notCheckPath);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("Filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getServletPath();//获取请求的URL
//        System.out.println(path);
        if(notCheckPath.indexOf(path) == -1){
            //请求地址需要过滤
            System.out.println(path);
            HttpSession session = request.getSession();
            if(session.getAttribute("username")==null){
                //未登录
//                System.out.println("jjjj");
                request.setAttribute("error","未登录");
                request.getRequestDispatcher("/error.jsp").forward(request,servletResponse);
            }
            else {
                //已登录
                filterChain.doFilter(request,servletResponse);
            }

        }
        else {
            //请求地址不需要过滤
            filterChain.doFilter(request,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
