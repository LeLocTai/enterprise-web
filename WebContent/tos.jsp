<%@ page import="com.magazineapp.repository.DatabaseHelper" %>
<%@ page import="com.magazineapp.repository.UserRepo" %>
<%@ page import="com.magazineapp.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("user");

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
    <div style="padding: 70px;">
    <div>
        <p>Help protect your website and its users with clear and fair website terms and conditions. These terms and conditions for a website set out key issues such as acceptable use, privacy, cookies, registration and passwords, intellectual property, links to other sites, termination and disclaimers of responsibility. Terms and conditions are used and necessary to protect a website owner from liability of a user relying on the information or the goods provided from the site then suffering a loss.</p>
<p>
Making your own terms and conditions for your website is hard, not impossible, to do. It can take a few hours to few days for a person with no legal background to make. But worry no more; we are here to help you.</p>
    </div>
<form action="" method="post">
    <input type="checkbox" name="tos-accepted" value="true">
    I have read and agree to the Terms and Conditions and Privacy Policy 
    <br>
    <input type="submit" value="Accept">
</form></div>
</body>
</html>
