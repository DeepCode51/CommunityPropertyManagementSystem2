package com.so.demosboot.common.config;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import java.io.IOException;


public class WebFilter implements Filter {

    @Autowired
    private BaseInfoConfig baseInfoConfig;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
      
    }

}
