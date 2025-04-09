package com.grepp.servlet.study.b_filter;

import com.grepp.servlet.study.b_filter.wrapper.PathWrapper;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ViewResolver implements Filter {
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain) throws IOException, ServletException {
        
        PathWrapper pathWrapper = new PathWrapper((HttpServletRequest) servletRequest);
        filterChain.doFilter(pathWrapper, servletResponse);
    }
}
