<%@ page import="com.magazineapp.model.User" %>
<%@ page import="com.magazineapp.repository.DatabaseHelper" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String redirect = response.getHeader("Redirect");
    if (StringUtils.isNotBlank(redirect) || !redirect.contentEquals(request.getRequestURL()))
        session.setAttribute("Redirect", redirect);
    else
        session.setAttribute("Redirect", request.getContextPath() + "/");

    User user = null;
    String userRole = request.getParameter("role");

    if ("student".equals(userRole)) {
        user = DatabaseHelper.getTestStudent();
    } else if ("coordinator".equals(userRole)) {
        user = DatabaseHelper.getTestCoordinator();
    } else if ("manager".equals(userRole)) {
        user = DatabaseHelper.getTestManager();
    }

    session.setAttribute("user", user);

    if (user != null) {
        response.sendRedirect((String) session.getAttribute("Redirect"));
    }
%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<p>Due to time and resources restriction, authentication are assumed to be handled by existing system. This page is to
    demonstrate authorization</p>
<ul>Login as:
    <li><a href="?role=student">Student</a></li>
    <li><a href="?role=coordinator">Coordinator</a></li>
    <li><a href="?role=manager">Manager</a></li>
</ul>
</body>
</html>
