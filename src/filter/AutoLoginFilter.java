package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AutoLoginFilter")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //获取cookie

        //获取cookie中的用户

        //跟数据库用户比对

        //

        //////先留着好像，这个拦截器现在没什么屁用
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
