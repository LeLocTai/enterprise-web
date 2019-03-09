<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
	<title>GreenWich university</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">
	<meta name="keywords"  />

	<script type="application/x-javascript">
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/news.css" rel='stylesheet' type='text/css' />
</head>

<body>
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
									<a href="gallery.jsp">Gallery</a>
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
				<li>Submit</li>
			</ul>
		</div>
	</div>
	<!--//short-->
	<!-- //inner_content -->
    <div class="contentNew">
    <div id="wrapper">
    	<h3>Upload your file: </h3>
    	<input type="file" id="real-file"/>
		<button type="button" id="custom-button">CHOOSE A FILE</button>
		<span id="custom-text">No file chosen, yet.</span><hr>
		<h3>Upload your file images: </h3>
    	<input type="file" accept="image/*" onchange="preview_image(event)"><br>
    	<img id="output_image"/><hr>
    	<button type="button" >Submit</button><hr>
    </div>
   </div>
	<!--footer-->
	<footer class="contact-footer">
		<div class="bottom-social">
			<div class="container">
				<div class="col-md-8 botttom-nav-w3ls-agile">
					<ul  data-aos="zoom-in">
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
				<a href="index.html">GreenWich
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

	
	</script>
	<a href="#home" class="scroll" id="toTop" style="display: block;">
		<span id="toTopHover" style="opacity: 1;"> </span>
	</a>
 	<script type="text/javascript" src="js/bootstrap.js"></script>

	<script type="text/javascript">
		   const realFileBtn = document.getElementById("real-file");
			const customBtn = document.getElementById("custom-button");
			const customTxt = document.getElementById("custom-text");

			customBtn.addEventListener("click", function() {
			  realFileBtn.click();
			});

			realFileBtn.addEventListener("change", function() {
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
	function preview_image(event){
		var reader =  new FileReader();
		reader.onload = function(){
			var output = document.getElementById("output_image");
			output.src = reader.result;
		}
		reader.readAsDataURL(event.target.files[0]);
	}
</script>

<script>
    $('#submit').click(function(event) {
        var val = $('input[type=file]').val().toLowerCase();
        var regex = new RegExp("(.*?)\.(pdf|docx|doc)$");
        if(!(regex.test(val))) {
            $('.uploadExtensionError').show();
            event.preventDefault();
        }
    });
</script>


</body>

</html>