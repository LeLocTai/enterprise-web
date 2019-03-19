package com.magazineapp;

import com.magazineapp.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authentication")
public class AuthFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest  request  = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession         session  = request.getSession(false); //dont auto create
        String              loginURI = request.getContextPath() + "/login.jsp";

        boolean isLoggedIn      = session != null && session.getAttribute("user") != null;
        boolean isTryingToLogin = request.getRequestURI().equals(loginURI);

        if (isLoggedIn || isTryingToLogin)
            filterChain.doFilter(request, response);
        else
            response.sendRedirect(loginURI);
    }

    @Override
    public void destroy()
    {

    }
}
