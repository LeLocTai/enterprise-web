<%@ page import="java.util.Date" %>
<%@ page import="com.magazineapp.model.Submission" %>
<%@ page import="com.magazineapp.repository.SubmissionRepo" %>
<%@ page import="com.magazineapp.model.User" %>
<%@ page import="com.magazineapp.model.Year" %>
<%@ page import="com.magazineapp.repository.DatabaseHelper" %><%--
  Created by IntelliJ IDEA.
  com.magazineapp.model.User: vzttz
  Date: 3/4/2019
  Time: 14:35:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Submission testSubmission = new Submission(
            "path/to/file/on/disk",
            new Date(),
            false,
            null,
            false,
            DatabaseHelper.getTestStudent(),
            DatabaseHelper.getTestYear()
    );

    new SubmissionRepo().add(testSubmission);
%>
</body>
</html>
