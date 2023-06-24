package com.example.ifprbiblioteca.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class Auth implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Chat gpt puro :( :D :/ :::
        if (request.getSession().getAttribute("user") == null) {
            String loginPath = request.getContextPath() + "/u/login";
            if (!request.getRequestURI().equals(loginPath)) {
                response.sendRedirect(loginPath);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Liberação de recursos do filtro
    }
}
 
