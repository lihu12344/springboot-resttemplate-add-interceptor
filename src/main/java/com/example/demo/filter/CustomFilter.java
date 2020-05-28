package com.example.demo.filter;

import com.example.demo.util.CustomContext;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class CustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        CustomContext.setHeader(request.getHeader("User-Agent"));
        System.out.println("customFilter："+request.getHeader("User-Agent"));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
