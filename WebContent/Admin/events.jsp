
<head>
<title>Events</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- calendar -->
<link rel="stylesheet" href="css/monthly.css">
<!-- //calendar -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
</head>
<body>
<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">
    <a href="index.html" class="logo">
        Greenwich University
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>
<!--logo end-->

</header>
<!--header end-->
<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a class="active" href="index.jsp">
                        <i class="fa fa-dashboard"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                
                <li class="sub-menu">
                    <a href="StudentSubmission.jsp">
                        <i class="glyphicon glyphicon-ok"></i>
                        <span>Student Submission</span>
                    </a>
                </li>
                <li>
                    <a href="events.jsp">
                        <i class="glyphicon glyphicon-grain"></i>
                        <span>Events</span>
                    </a>
                </li>
                <li class="sub-menu">
                    <a href="best.jsp">
                        <i class="glyphicon glyphicon-king"></i>
                        <span>The best magazine</span>
                    </a>
                </li>
               
            </ul>            </div>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<div class="table-agile-info">
 <div class="panel panel-default">
    <div class="panel-heading">
     Events
    </div>
    <div>
      <table class="table" ui-jq="footable" ui-options='{
        "paging": {
          "enabled": true
        },
        "filtering": {
          "enabled": true
        },
        "sorting": {
          "enabled": true
        }}'>
        <thead>
          <tr>
            <th data-breakpoints="xs">ID</th>
            <th>Name</th>
            <th data-breakpoints="xs sm md" data-title="DOB">Time</th>
            <th>Status</th>
            <th>View all Submission</th>
          </tr>
        </thead>
        <tbody>
          <tr data-expanded="true">
            <td>1</td>
            <td>Dennise</td>
            <td>July 25th 2018</td>
            <td>Cancel</td>
            <td>
                <a href="viewAllSubmission.jsp" >View All Submission</a>
          </tr>
          <tr>
            <td>2</td>
            <td>Dennise</td>
            <td>July 25th 2018</td>
            <td>Cancel</td>
            <td>
               <a href="viewAllSubmission.jsp" >View All Submission</a>
          </tr>
          <tr>
            <td>3</td>
            <td>Dennise</td>
            <td>July 25th 2018</td>
            <td>Cancel</td>
            <td>
                <a href="viewAllSubmission.jsp" >View All Submission</a>
          </tr>
          <tr>
            <td>4</td>
            <td>Dennise</td>
            <td>July 25th 2018</td>
            <td>Cancel</td>
            <td>
                <a href="viewAllSubmission.jsp" >View All Submission</a>
          </tr>
          <tr>
            <td>5</td>
            <td>Dennise</td>
            <td>July 25th 2018</td>
            <td>Cancel</td>
            <td>
                <a href="viewAllSubmission.jsp" >View All Submission</a>
          </tr>
          <tr>
            <td>6</td>
            <td>Dennise</td>
            <td>July 25th 2018</td>
            <td>Cancel</td>
            <td>
                <a href="viewAllSubmission.jsp" >View All Submission</a>
          </tr>
          <tr>
            <td>7</td>
            <td>Dennise</td>
            <td>July 25th 2018</td>
            <td>Cancel</td>
            <td>
                <a href="viewAllSubmission.jsp" >View All Submission</a>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
</section>
 <!-- footer -->
		  <div class="footer">
			<div class="wthree-copyright">
			  <p>© 2019 Fettle. All rights reserved | Design by
                <a href="">Sandra0710</a>
			</div>
		  </div>
  <!-- / footer -->
</section>

<!--main content end-->
</section>
<script src="js/bootstrap.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
</body>
</html>
