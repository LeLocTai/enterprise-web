<%
    response.sendRedirect("viewSubmission.jsp");
%>

<html>
<head>
    <title>Greenwich university</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="headerIndex">
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
                                <a class="active" href="index.jsp">Home</a>
                            </li>
                            <li>
                                <a href="submit.jsp">Submit</a>
                            </li>
                            <li>
                                <a href="viewSubmission.jsp">View Submission</a>
                            </li>
                            <li>
                                <a href="login.jsp">Login</a>
                            </li>
                            <li>
                                <a href="logout.jsp">Logout</a>
                            </li>
                            <li>
                                <a href="report.jsp">Report</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </nav>
        </div>
        <!--//top-bar-->
    </header>
    <!-- banner-text -->
    <div class="slider">
        <div class="callbacks_container">
            <ul class="rslides callbacks callbacks1" id="slider4">
                <li>
                    <div class="banner-top"></div>
                </li>
                <li>
                    <div class="banner-top1"></div>
                </li>
                <li>
                    <div class="banner-top2"></div>
                </li>
                <li>
                    <div class="banner-top3"></div>
                </li>
            </ul>
        </div>
        <div class="clearfix"></div>

        <!--banner Slider starts Here-->
    </div>
</div>
<!--//Slider-->


<div class="content">
    <!-- faculty-->
    <div class="section_1">
        <ul class="clearfix">
            <li>
                <a href="images/b1.jpg" ">
                <img src="images/b1.jpg" alt="Lights">
                <div class="caption">
                    <h2>Programming</h2>
                </div>
                </a>
            </li>

            <li>
                <a href="images/b1.jpg" ">
                <img src="images/b2.jpg" alt="Lights">
                <div class="caption">
                    <h2>Design</h2>
                </div>
                </a>
            </li>

            <li>
                <a href="images/b1.jpg" ">
                <img src="images/b2.jpg" alt="Lights">
                <div class="caption">
                    <h2>Business</h2>
                </div>
                </a>
            </li>

        </ul>
    </div>
    <!--faculty -->

    <div class="section_2 clearfix">
        <div class="mainWrap">
            <div class="column_1 col-md-8">
                <h2>NEWS</h2>
                <ul>
                    <li>
                        <a href="">
                            <img src="images/b1.jpg" alt="">
                            <div class="wrapper">
                                <h3 class="cut100"></h3>
                                <span class="time"> 2019.03.01</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="images/b1.jpg" alt="">
                            <div class="wrapper">
                                <h3 class="cut100"></h3>
                                <span class="time"> 2019.03.01</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="images/b1.jpg" alt="">
                            <div class="wrapper">
                                <h3 class="cut100"></h3>
                                <span class="time"> 2019.03.01</span>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>

            <div class="column_2 col-md-4">
                <div class="wrapper">
                    <h2>EVENTS</h2>
                    <ul>
                        <li class="clearfix">
                            <a href="">
                                <div class="time">
                                    <span>11</span>2019.01
                                </div>
                                <div class="txtwrapper">
                                    <h3 class="cut100">Surviving the Misinformation Age</h3>
                                </div>
                            </a>
                        </li>
                        <li class="clearfix">
                            <a href="">
                                <div class="time">
                                    <span>11</span>2019.01
                                </div>
                                <div class="txtwrapper">
                                    <h3 class="cut100">Surviving the Misinformation Age</h3>
                                </div>
                            </a>
                        </li>
                        <li class="clearfix">
                            <a href="">
                                <div class="time">
                                    <span>11</span>2019.01
                                </div>
                                <div class="txtwrapper">
                                    <h3 class="cut100">Surviving the Misinformation Age</h3>
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>

            </div>
        </div>
    </div>

    <!--/top_spl_poses-->
    <div class="section_1">
        <h2>Best </h2>
        <ul class="clearfix">
            <li>
                <a href="images/b1.jpg" ">
                <img src="images/b2.jpg" alt="Lights">
                <div class="caption">
                    <h2>Programming</h2>
                </div>
                </a>
            </li>

            <li>
                <a href="images/b1.jpg" ">
                <img src="images/b2.jpg" alt="Lights">
                <div class="caption">
                    <h2>Design</h2>
                </div>
                </a>
            </li>

            <li>
                <a href="images/b1.jpg" ">
                <img src="images/b2.jpg" alt="Lights">
                <div class="caption">
                    <h2>Business</h2>
                </div>
                </a>
            </li>

        </ul>
    </div>
    <!--//top_spl_poses-->
</div>


<!--footer-->
<footer class="contact-footer">
    <div class="copy">
        <h2 class="footer-logo">
            <a href="index.jsp">Greenwich
                <span>university</span>
            </a>
        </h2>
        <p>� 2019 Fettle. All rights reserved | Design by
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