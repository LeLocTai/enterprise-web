package com.magazineapp;

import com.magazineapp.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "submission")
public class SubmissionFilter implements Filter
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

        User user = (User) session.getAttribute("user");

        if (user.get_role().equalsIgnoreCase("student") ||
                user.get_role().equalsIgnoreCase("coordinator"))
            filterChain.doFilter(request, response);
        else
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }

    @Override
    public void destroy()
    {

    }
}
