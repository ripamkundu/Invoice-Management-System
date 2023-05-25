<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Products</title>
<link rel="icon" type="image/x-icon" href="./image/logo.ico">

<link rel="stylesheet" href="./css/product.css">
<link rel="stylesheet" href="./css/responsive.css">
<link rel="stylesheet" href="./css/responsive1.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
<%
String username = (String) session.getAttribute("username");
if(username==null)
{
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>
</head>
<body>
	<header>
		<nav>
			<div class="logo">
				<img src="./image/logo.png" alt="No-Pic">
			</div>
			<div class="menu">
				<a href="./index.jsp">Home</a> <a href="./invoice.jsp">Invoice</a>
				<a href="./product.jsp">Products</a> <a href="./customer.jsp">Customers</a>
				<a href="./calculator.jsp" target="_blank">Calculate It</a>
				<a href="./logout.jsp" target="_blank">Logout</a>
				
			</div>
			<!-- <div class="login">
                <a href="#">Login</a>
            </div> -->
		</nav>
		<section class="header_text">
			<span class="something">Invoice Management System</span>
			<h3>PRODUCT SECTION</h3>
			<br>
		</section>
	</header>
	<section>
		<div class="container" style="margin-top: 3%;">
			<h1>PRODUCT ZONE</h1>
			<div class="row">
				<div class="col-md-6">
					<!-- <img src="./image/invoice2.jpg" alt="No-Pic"> -->
					<div class="pic"></div>
				</div>
				<div class="col-md-6">
					<h3 style="text-decoration: underline;">CREATE PRODUCT</h3>

					<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nam
						sunt dolor dolores facere aliquid sint pariatur quis nesciunt,
						incidunt commodi, itaque molestiae inventore quia? Animi?</p>
					<!-- <button href = "# " type="button" class="kuch-bhi"> Click</button> -->
					<a href="./productform.jsp" target="_blank" class="kuch-bhi">
						Click</a>

				</div>
			</div>
			<div class="row" style="margin-top: 5%;">
				<div class="col-md-6">
					<h3 style="text-decoration: underline;">MANAGE PRODUCT</h3>

					<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nam
						sunt dolor dolores facere aliquid sint pariatur quis nesciunt,
						incidunt commodi, itaque molestiae inventore quia? Animi?</p>
					<!-- <button href = "# " type="button" class="kuch"> Click</button> -->
					<a href="showproductdata" target="_blank" class="kuch">
						Click</a>

				</div>
				<div class="col-md-6">
					<!-- <img src="./image/invoice3.jpg" alt="No-Pic"> -->
					<div class="pic1"></div>
				</div>
			</div>
		</div>
	</section>
	<!-- ---------------------------------------------------Footer -------------------------------------- -->
	<section>
		<footer class="footer" style="margin-top: 15%;">
			<div class="waves">
				<div class="wave" id="wave1"></div>
				<div class="wave" id="wave2"></div>
				<div class="wave" id="wave3"></div>
				<div class="wave" id="wave4"></div>
			</div>
			<ul class="social-icon">
				<li class="social-icon__item"><a class="social-icon__link"
					href="#"> <ion-icon name="logo-facebook"></ion-icon>
				</a></li>
				<li class="social-icon__item"><a class="social-icon__link"
					href="#"> <ion-icon name="logo-twitter"></ion-icon>
				</a></li>
				<li class="social-icon__item"><a class="social-icon__link"
					href="#"> <ion-icon name="logo-linkedin"></ion-icon>
				</a></li>
				<li class="social-icon__item"><a class="social-icon__link"
					href="#"> <ion-icon name="logo-instagram"></ion-icon>
				</a></li>
			</ul>
			<p>&copy;MadeBy MCA Student 2k22 - 23 | All Rights Reserved</p>
		</footer>
	</section>


	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>


</body>
</html>