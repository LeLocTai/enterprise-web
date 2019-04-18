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
        HashSet<String> url1 = new HashSet<>();
        url1.add("/edit-comment");
        url1.add("/select-submission");
        url1.add("/download-selected-as-zip");
        url1.add("/report-data");
        url1.add("/report.jsp");
        ROLE_URL_BLACKLIST.put("student", url1);

        HashSet<String> url2 = new HashSet<>();
        url1.add("/download-selected-as-zip");
        url1.add("/report-data");
        url1.add("/report.jsp");
        ROLE_URL_BLACKLIST.put("coordinator", url2);

        HashSet<String> url3 = new HashSet<>();
        url3.add("/submit.jsp");
        url3.add("/upload-submission");
        url3.add("/edit-comment");
        url3.add("/select-submission");
        ROLE_URL_BLACKLIST.put("manager", url3);
    }


    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest  request  = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession         session  = request.getSession();

        String relPath = getRelativePath(request);

        User user = (User) session.getAttribute("user");

        Set<String> blackList = ROLE_URL_BLACKLIST.get(user.get_role().toLowerCase());

        if (blackList != null && blackList.contains(relPath))
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        else
            filterChain.doFilter(request, response);
    }

    private static String getRelativePath(HttpServletRequest request)
    {
        return request.getRequestURI().substring(request.getContextPath().length());
    }

    @Override
    public void destroy()
    {

    }
}
