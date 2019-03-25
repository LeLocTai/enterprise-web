<%@page import="com.magazineapp.repository.DatabaseHelper" %>
<%@page import="com.magazineapp.repository.SubmissionRepo" %>
<%@page import="com.magazineapp.model.Submission" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="com.magazineapp.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
    User user = (User) session.getAttribute("user");

    ArrayList<Submission> submissions = new SubmissionRepo().getFromAuthor(DatabaseHelper.getTestStudent());
<%@page import="com.magazineapp.repository.DatabaseHelper"%>
<%@page import="com.magazineapp.repository.SubmissionRepo"%>
<%@page import="com.magazineapp.model.Submission"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

%>
<%
	
	ArrayList<Submission> subList = new SubmissionRepo().getFromAuthor(DatabaseHelper.getTestStudent()) ;
	
 %>
 <!--  %
String id = request.getParameter("userId");
String driverName = "org.mariadb.jdbc.Driver";
String connectionUrl = "jdbc:mariadb://localhost:3306/";
String dbName = "magazinedb";
String userId = "author";
String password = "12345";

try {
Class.forName(viewSubmission);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%-->

 <!DOCTYPE html>
<html>

<head>
    <title>Greenwich university</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords"/>

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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div class="headerIndex inner_banner">
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
	<div class="headerIndex inner_banner">
		<header class="header" id="home">
			<!--/top-bar-->
			<div class="top-bar">
				<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
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
									<a  href="submit.jsp">Submit</a>
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
	<!--/short-->
	<div class="breadcrumb">
		<div class="inner_breadcrumb">
			<ul class="short">
				<li>
					<a href="index.jsp">Home</a>
					<span>|</span>
				</li>
				<li>View Submission</li>
			</ul>
		</div>
	</div>
	<!--//short-->
	<!-- //inner_content -->
	<div class="content">
		<!-- faculty-->
	<div class="section_1">
  <section class="wrapper">
		<div class="typo-agile">
		<h2 class="w3ls_head">View submission</h2>
			<div class="row">
			</div><!-- /.row -->
			<div class="bs-docs-example">
				<table class="table">
					<thead>
						<tr>
							<th>No</th>
							<th>Author_email</th>
							<th>Date</th>
							<th>Year</th>
							<th>Notice</th>
							<th>Comment</th>
							<th>Dowload</th>
							<th>Upload</th>
						</tr>
					</thead>
					<!--  %
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM Submission WHERE Id = 33";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%-->
					<tbody>
						  <tr>
							<td>1</td>
							<td>a@fpt.edu.vn</td>
							<td>July 25th</td>
							<td>2018</td>
							<td>aaaa</td>
							<td>dsdsds</td>
							<td><a href="download-submission/35">Dowload</a></td>
							<td><a href="update.jsp">Upload</a></td>
						</tr>
						<tr>
							<td>1</td>
							<td>a@fpt.edu.vn</td>
							<td>July 25th</td>
							<td>2018</td>
							<td>aaaa</td>
							<td>dsdsds</td>
							<td><a href="download-submission/35">Dowload</a></td>
							<td><a href="update.jsp">Upload</a></td>
						</tr>

					</tbody>
					<!-- % 
}

} catch (Exception e) {
e.printStackTrace();
}
%-->
				</table>
			</div>
		</div>
</section>
</div>
<!--//inner_banner-->
<!--/short-->
<div class="breadcrumb">
    <div class="inner_breadcrumb">
        <ul class="short">
            <li>
                <a href="index.jsp">Home</a>
                <span>|</span>
            </li>
            <li>View Submission</li>
        </ul>
    </div>
</div>
<!--//short-->
<!-- //inner_content -->
<div class="content">
    <!-- faculty-->
    <div class="section_1">
        <section class="wrapper">
            <div class="typo-agile">
                <h2 class="w3ls_head">View submission</h2>
                <div class="row">
                </div><!-- /.row -->
                <div class="bs-docs-example">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Author Email</th>
                            <th>Date</th>
                            <th>Year</th>
                            <th>Comment</th>
                            <th>Dowload</th>
                            <th>Upload</th>
                            <th>Select</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>a@fpt.edu.vn</td>
                            <td>July 25th</td>
                            <td>2018</td>
                            <td>dsdsds</td>
                            <td><a href="#">Dowload</a></td>
                            <td><a href="#">Upload</a></td>
                            <td><a href="#">Select</a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
    </div>
</div>

<!--footer-->
<footer class="contact-footer">
    <div class="bottom-social">
        <div class="container">
            <div class="col-md-8 botttom-nav-w3ls-agile">
                <ul data-aos="zoom-in">
                    <li>
                        <h4>Email: </h4>
                    </li>
                    <li>
                        <h4>Tell: 0123435454</h4>
                    </li>


                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="col-md-4 social-icons" data-aos="zoom-in">
                <h6>Connect with us</h6>
                <a class="btn btn-block btn social btn-twitter" href="#">
                    <span class="fa fa-twitter"></span>
                </a>
                <a class="twitter" href="#">
                    <span class="fa fa-twitter"></span>
                </a>
                <a class="pinterest" href="#">
                    <span class="fa fa-pinterest-p"></span>
                </a>
                <a class="linkedin" href="#">
                    <span class="fa fa-linkedin"></span>
                </a>
            </div>
            <div class="clearfix"></div>

        </div>
    </div>
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
<!-- start-smoth-scrolling -->


<a href="#home" class="scroll" id="toTop" style="display: block;">
    <span id="toTopHover" style="opacity: 1;"> </span>
</a>
<script type="text/javascript" src="js/bootstrap.js"></script>

</body>

</html>
