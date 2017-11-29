package com.aquatic.schedule.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: com.aquatic.schedule.web.filter.CORSFilter
 * @description: 跨域访问过滤器
 * @author: wanghao/haozixiaowang@163.com
 * @date: 2017/11/29 15:03
 **/
@Component
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "X-Custom-Header, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
