<%@ page import="com.magazineapp.model.Year" %>
<%@ page import="com.magazineapp.repository.YearRepo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Year currentYear = new YearRepo().getCurrentYear();
    pageContext.setAttribute("currentYear", currentYear);
%>
<html>
<head>
    <title>Report</title>
    <script src="js/jquery-2.2.3.min.js"></script>
    <script src="js/Chart.bundle.min.js"></script>
    <link rel="stylesheet" href="css/Chart.min.css">
    <link rel="stylesheet" href="css/report.css">
</head>
<body>
<form action="#" id="input-form">
    <label>
        From:
        <input type="date" name="from" id="from" value="${currentYear._startDate}">
    </label>
    <label>
        To:
        <input type="date" name="to" id="to" value="${currentYear._endDate}">
    </label>
    <input type="submit">
</form>

<div id="charts">
    
</div>

<script src="js/report.js"></script>
</body>
</html>
