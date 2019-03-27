package com.magazineapp.filter;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class FilterHelper
{
    public static final HashSet<String> AUTH_URL_WHITE_LIST = new HashSet<>();

    static
    {
        AUTH_URL_WHITE_LIST.add("/");
        AUTH_URL_WHITE_LIST.add("/login.jsp");
//        AUTH_URL_WHITE_LIST.add("/viewSubmission.jsp");
    }

    public static String getRelativePath(HttpServletRequest request)
    {
        return request.getRequestURI().substring(request.getContextPath().length());
    }
}
