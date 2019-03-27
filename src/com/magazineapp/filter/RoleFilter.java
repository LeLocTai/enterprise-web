package com.magazineapp.filter;

import com.magazineapp.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

@WebFilter(filterName = "RoleFilter")
public class RoleFilter implements Filter
{
    private static final Dictionary<String, Set<String>> ROLE_URL_BLACKLIST = new Hashtable<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        HashSet<String> url = new HashSet<>();
        url.add("/submit.jsp");
        url.add("/file-upload");
        ROLE_URL_BLACKLIST.put("manager", url);
    }


    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest  request  = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession         session  = request.getSession();

        String relPath = FilterHelper.getRelativePath(request);

        if (FilterHelper.AUTH_URL_WHITE_LIST.contains(relPath))
        {
            filterChain.doFilter(request, response);
            return;
        }

        User user = (User) session.getAttribute("user");

        Set<String> blackList = ROLE_URL_BLACKLIST.get(user.get_role().toLowerCase());

        if (blackList != null && blackList.contains(relPath))
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        else
            filterChain.doFilter(request, response);
    }

    @Override
    public void destroy()
    {

    }
}
