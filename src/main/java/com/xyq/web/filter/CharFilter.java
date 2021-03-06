package com.xyq.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决全栈的乱码问题
 */
@WebFilter("/*")
public class CharFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain  filterChain) throws IOException, ServletException {
    //将父接口转换为子接口
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

    //获取请求方法
        String method = request.getMethod();
        //解决post请求中文数据乱码问题
        if(method.equalsIgnoreCase("post")|| method.equalsIgnoreCase("get")){
            request.setCharacterEncoding("utf-8");
            //处理响应乱码
            response.setContentType("text/html;charset=utf-8");
        }
        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
