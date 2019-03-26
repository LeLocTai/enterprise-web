package com.magazineapp.filter;

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

        String loginURI    = request.getContextPath() + "/login.jsp";
        String destination = request.getRequestURI();

        boolean isLoggedIn      = session != null && session.getAttribute("user") != null;
        boolean isTryingToLogin = destination.equals(loginURI);

        if (isLoggedIn || isTryingToLogin)
            filterChain.doFilter(request, response);
        else
        {
            request.getSession().setAttribute("Redirect", destination);
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/login.jsp"));
        }
    }

    @Override
    public void destroy()
    {

    }
}
