package com.dubbo.serviceconsumer.filter;


import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * @author kk
 */
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
    }

    @Override
    public void destroy() {

    }
}
