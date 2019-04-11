<%@ page language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                        <a class="navbar-brand" href="index.jsp">GreenWich
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
                                <a class="active" href="submit.jsp">Submit</a>
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
            <li>Submit</li>
        </ul>
    </div>
</div>
<!--//short-->
<!-- //inner_content -->
<div class="contentNew">
    <h2>Submit magazine for event </h2>
    <div id="wrapper">
        <div class="agile-last-grids">
            <div class="col-md-6 agile-last-left ">
                <div class="agile-last-grid">
                    <div>
                        <h3>Submit your file:</h3>
                        <hr>
                    </div>
                    <div>
                        <form id="uploadImage" enctype="multipart/form-data" method="post" action="upload-submission">
                            <input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>
                            <input id="fileupload" name="myfile" type="file"/><br>
                            <input type="submit"/>
                        </form>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

    </div>
</div>

<hr>

<div class="content">
    <!--/top_spl_poses-->
    <div class="section_1">
        <h2>Some example </h2>
        <ul class="clearfix">
            <li>
                <a href="images/b1.jpg">
                    <img src="images/b2.jpg" alt="Lights">
                    <div class="caption">
                    </div>
                </a>
            </li>

            <li>
                <a href="images/b1.jpg">
                    <img src="images/b2.jpg" alt="Lights">
                    <div class="caption">
                    </div>
                </a>
            </li>

            <li>
                <a href="images/b1.jpg">
                    <img src="images/b2.jpg" alt="Lights">
                    <div class="caption">
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
            <a href="index.html">Greenwich
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

<script type="text/javascript">
    const realFileBtn = document.getElementById("real-file");
    const customBtn = document.getElementById("custom-button");
    const customTxt = document.getElementById("custom-text");

    customBtn.addEventListener("click", function () {
        realFileBtn.click();
    });

    realFileBtn.addEventListener("change", function () {
        if (realFileBtn.value) {
            customTxt.innerHTML = realFileBtn.value.match(
                /[\/\\]([\w\d\s\.\-\(\)]+)$/
            )[1];
        } else {
            customTxt.innerHTML = "No file chosen, yet.";
        }
    });
</script>
<script type="text/javascript">
    function preview_image(event) {
        var reader = new FileReader();
        reader.onload = function () {
            var output = document.getElementById("output_image");
            output.src = reader.result;
        }
        reader.readAsDataURL(event.target.files[0]);
    }
</script>

<script>
    $('#submit').click(function (event) {
        var val = $('input[type=file]').val().toLowerCase();
        var regex = new RegExp("(.*?)\.(pdf|docx|doc)$");
        if (!(regex.test(val))) {
            $('.uploadExtensionError').show();
            event.preventDefault();
        }
    });
</script>


</body>

</html>