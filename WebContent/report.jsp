<%@ page import="com.magazineapp.model.Year" %>
<%@ page import="com.magazineapp.repository.YearRepo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Year currentYear = new YearRepo().getCurrentYear();
    pageContext.setAttribute("currentYear", currentYear);
%>

<!DOCTYPE html>
<html>

<head>
    <title>Report</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords"/>
    
    <script src="js/jquery-2.2.3.min.js"></script>
    <script src="js/Chart.bundle.min.js"></script>
    <link rel="stylesheet" href="css/Chart.min.css">

    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="css/style.css" rel='stylesheet' type='text/css'/>
    <link href="css/news.css" rel='stylesheet' type='text/css'/>
    <link rel="stylesheet" href="css/report.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div class="headerIndex inner_banner_report">
    <header class="header" id="home">
        <!--/top-bar-->
        <div class="top-bar">
            <nav class="navbar navbar-default">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <h1>
                        <a class="navbar-brand" href="index.jsp">Greenwich
                            <span>University</span>
                        </a>
                    </h1>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                    <nav>
                        <ul class="top_nav">
                            <li>
                                <a class="" href="index.jsp">Home</a>
                            </li>
                            <li>
                                <a href="submit.jsp">Submit</a>
                            </li>
                            <li>
                                <a class="active" href="viewSubmission.jsp">View Submission</a>
                            </li>
                            <li>
                                <a href="contact.jsp">Contact</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </nav>
        </div>
        <!--//top-bar-->
    </header>
</div>
<!--//inner_banner-->
<div class="breadcrumb">
    <div class="inner_breadcrumb">
        <ul class="short">
            <li>
                <a href="index.jsp">Home</a>
                <span>|</span>
            </li>
            <li>Report</li>
        </ul>
    </div>
</div>
<div class="frame">
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

    <div id="charts"></div>
 
</div>


<!--footer-->
<footer class="contact-footer">
    <div class="copy">
        <h2 class="footer-logo">
            <a href="index.jsp">Greenwich
                <span>university</span>
            </a>
        </h2>
        <p>© 2019 Fettle. All rights reserved | Design by
            <a href="">Sandra0710</a>
        </p>
        <div class="clearfix"></div>
    </div>
</footer>
<!--/footer -->
<!-- js -->
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script src="js/report.js"></script>

<!--search-bar-->
<script src="js/responsiveslides.min.js"></script>

<script>
    $(function () {
        $("#slider4").responsiveSlides({
            auto: true,
            pager: true,
            nav: false,
            speed: 1000,
            namespace: "callbacks",
            before: function () {
                $('.events').append("<li>before event fired.</li>");
            },
            after: function () {
                $('.events').append("<li>after event fired.</li>");
            }
        });
    });
</script>
<!--//search-bar-->

<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $(".scroll").click(function (event) {
            event.preventDefault();
            $('html,body').animate({
                scrollTop: $(this.hash).offset().top
            }, 900);
        });
    });
</script>

<a href="#home" class="scroll" id="toTop" style="display: block;">
    <span id="toTopHover" style="opacity: 1;"> </span>
</a>
<script type="text/javascript" src="js/bootstrap.js"></script>

</body>

</html>
