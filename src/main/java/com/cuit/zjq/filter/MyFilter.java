package com.cuit.zjq.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // do something 处理request 或response

        // 调用filter链中的下一个filter
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {

    }
}