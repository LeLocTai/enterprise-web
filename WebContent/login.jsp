<%@ page import="com.magazineapp.model.User" %>
<%@ page import="com.magazineapp.repository.DatabaseHelper" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = null;
    String userRole = request.getParameter("role");

    if ("student".equals(userRole))
    {
        user = DatabaseHelper.getTestStudent();
    } else if ("student2".equals(userRole))
    {
        user = DatabaseHelper.getTestStudent2();
    } else if ("coordinator".equals(userRole))
    {
        user = DatabaseHelper.getTestCoordinator();
    } else if ("coordinator2".equals(userRole))
    {
        user = DatabaseHelper.getTestCoordinator2();
    } else if ("manager".equals(userRole))
    {
        user = DatabaseHelper.getTestManager();
    }

    session.setAttribute("user", user);

    if (user != null)
    {
        String dest = (String) session.getAttribute("Redirect");
        if (StringUtils.isBlank(dest))
            dest = request.getContextPath() + "/";
        response.sendRedirect(dest);
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
    <li><a href="?role=student">Student@1</a></li>
    <li><a href="?role=student2">Student@2</a></li>
    <li><a href="?role=coordinator">Coordinator@1</a></li>
    <li><a href="?role=coordinator2">Coordinator@2</a></li>
    <li><a href="?role=manager">Manager</a></li>
</ul>
</body>
</html>
