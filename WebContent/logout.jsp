<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    session.setAttribute("user", null);

    response.sendRedirect(request.getContextPath() + "/");
%>