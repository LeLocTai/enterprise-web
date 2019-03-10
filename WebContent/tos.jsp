<%@ page import="repository.DatabaseHelper" %>
<%@ page import="repository.UserRepo" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.setAttribute("user", DatabaseHelper.getTestStudent());


    User user = (User) session.getAttribute("user");
    System.out.println("User: " + user.get_email());

    if (user != null && request.getParameter("tos-accepted").equals("true"))
    {
        user.set_has_Accepted_TOC(true);
        new UserRepo().update(user);

        response.sendRedirect("index.jsp");
    }
%>
<html>
<head>
    <title>Terms and Conditions</title>
</head>
<body>
<form action="" method="post">
    <input type="hidden" name="tos-accepted" value="true">
    <input type="submit" value="Accept">
</form>
<p></p>
</body>
</html>
